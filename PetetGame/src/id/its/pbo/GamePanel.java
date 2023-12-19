package id.its.pbo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import entity.pbo.Entity;
import entity.pbo.Player;
import object.SuperObject;
import tile.pbo.TileManager;

public class GamePanel extends JPanel implements Runnable {
	final int originalTileSize = 16; //16x16 tile
	final int scale = 4;
	
	public final int tileSize = originalTileSize * scale; //64x64 tile
	public final int maxScreenCol = 12;
	public final int maxScreenRow = 10;
	public final int screenWidth = tileSize * maxScreenCol; // 768
	public final int screenHeight = tileSize * maxScreenRow; // 640
	
	// WORLD SETTINGS
	public final int maxWorldCol = 40;
	public final int maxWorldRow = 40;
	
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	Sound music = new Sound();
	Sound se = new Sound();
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	
	// Entity and Object
	public Player player = new Player(this, keyH);
	public SuperObject obj[] = new SuperObject[15];
	public Entity npc[] = new Entity[15];
	
	// Game State
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		aSetter.setObject();
		aSetter.setNPC();
		//playMusic(0);
		//stopMusic();
		gameState = titleState;
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if (delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			if (timer >= 1000000000) {
			//	System.out.println("FPS:"+ drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	}
	
	public void update() {
		if(gameState == titleState) {
			
		}
		if(gameState == playState) {
			// player
			player.update();
			// npc
			for(int i = 0; i < npc.length; i++) {
				if(npc[i] != null) {
					npc[i].update();
				}
			}
		}
		if(gameState == pauseState) {
			
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		// DEBUG
		long drawStart = 0;
		if(keyH.checkDrawTime == true) {
			drawStart = System.nanoTime();
		}
		
		//TITLE
		if(gameState == titleState) {
			ui.draw(g2);
		}
		
		else {
			// Tile
			tileM.draw(g2);
			
			// Object
			for(int i = 0; i < obj.length; i++) {
				if(obj[i] != null) {
					obj[i].draw(g2, this);
				}
			}
			
			// NPC
			for(int i = 0; i < npc.length; i++) {
				if(npc[i] != null) {
					npc[i].draw(g2);
				}
			}
			
			// Player
			player.draw(g2);
			
			// UI
			ui.draw(g2);
		}
		
		// DEBUG
		if(keyH.checkDrawTime == true) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setColor(Color.WHITE);
			g2.drawString("Drawing Time: " + passed, 10, 400);
			System.out.println("Draw Time: " + passed);
		}

		g2.dispose();
	}
	
	public void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}
	
	public void stopMusic() {
		music.stop();
	}
	
	public void playSE(int i) {
		se.setFile(i);
		se.play();
	}
}
