package id.its.pbo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;


public class UI {
	GamePanel gp;
	Graphics2D g2;
	Font arial_30, arial_15, arial_80B;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	
	public UI(GamePanel gp) {
		this.gp = gp;
		arial_30 = new Font("Cambria", Font.BOLD, 30);
		arial_15 = new Font("Arial", Font.PLAIN, 10);
		arial_80B = new Font("Arial", Font.BOLD, 80);
	}
	
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		this.gp = gp;
		
		g2.setFont(arial_30);
		g2.setColor(Color.white);
		
		// PLAY STATE
		if(gp.gameState == gp.playState) {
			// Nothing
		}
		// PAUSE STATE
		if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
		}
		
		// FINISH STATE
		if(gameFinished == true) {
			g2.setFont(arial_30);
			g2.setColor(Color.WHITE);
			
			String text;
			int textLength;
			int x;
			int y;
			
			text = "Kamu berhasil sampai kesekolah!";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 - (gp.tileSize*3);
			g2.drawString(text, x, y);
			
			text = "Waktu kamu: "+ dFormat.format(playTime)+ "!";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 + (gp.tileSize*4);
			g2.drawString(text, x, y);
			
			text = "Total Poin: "+ gp.player.poin;
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 + (gp.tileSize*2);
			g2.drawString(text, x, y);
			
			g2.setFont(arial_80B);
			g2.setColor(Color.yellow);
			text = "Selamat!";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 + (gp.tileSize);
			g2.drawString(text, x, y);
			
			gp.gameThread = null;
		} else {
			g2.setFont(arial_30);
			g2.setColor(Color.WHITE);
			g2.drawString("Poin: " + gp.player.poin, 74, 65);
			
			// TIME
			playTime += (double)1/60;
			g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize*8, 65);
			
			// Message 
			if (messageOn == true) {
				g2.setFont(arial_15.deriveFont(15F));
				g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
				
				messageCounter++;
				
				if(messageCounter > 120) {
					messageCounter = 0;
					messageOn = false;
				}
			}
		}
	}
	
	public void drawPauseScreen() {
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
		String text = "PAUSE";
		int x = getXforCenteredText(text);
		
		int y = gp.screenHeight/2;
		
		g2.drawString(text, x, y);
	}
	
	public int getXforCenteredText(String text) {
		int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;
	}
}
