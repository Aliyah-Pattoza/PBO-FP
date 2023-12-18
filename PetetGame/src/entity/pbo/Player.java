package entity.pbo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import id.its.pbo.GamePanel;
import id.its.pbo.KeyHandler;
import id.its.pbo.UtilityTool;

public class Player extends Entity {
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	public int poin = 0;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);
		
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2); // 352
		screenY = gp.screenHeight/2 - (gp.tileSize/2); // 286
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 48;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		worldX = gp.tileSize * 18; 
		worldY = gp.tileSize * 27; 
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		up1 = setup("/player/up1");
		up2 = setup("/player/up2");
		down1 = setup("/player/down1");
		down2 = setup("/player/down2");
		left1 = setup("/player/left1");
		left2 = setup("/player/left2");
		right1 = setup("/player/right1");
		right2 = setup("/player/right2");
	}
	
	public void update() {
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
			if(keyH.upPressed == true) {
				direction = "up";
			}
			else if(keyH.downPressed == true) {
				direction = "down";
			}
			else if(keyH.leftPressed == true) {
				direction = "left";
			}
			else if(keyH.rightPressed == true) {
				direction = "right";
			}
			
			// CHECK TILE COLLISION
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			// CHECK OBJECT COLLISION
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			// CHECK NPC COLLISION
			int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
			interactNPC(npcIndex);
			
			// IF COLLISION IS FALSE, PLAYER CAN MOVE
			if(collisionOn == false) {
				switch(direction) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
				}
			}
			
			spriteCounter++;
			if(spriteCounter > 10) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
	}
	
	public void pickUpObject(int i) {
		if (i != 999) {
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "Tas":
				gp.playSE(1);
				poin = poin + 30;
				gp.obj[i] = null;
				gp.ui.showMessage("Kamu membawa tas");
				break;
			case "Buku":
				gp.playSE(1);
				poin = poin + 20;
				gp.obj[i] = null;
				gp.ui.showMessage("Kamu membawa buku");
				break;
			case "Pensil":
				gp.playSE(1);
				poin = poin + 20;
				gp.obj[i] = null;
				gp.ui.showMessage("Kamu membawa pensil");
				break;
			case "Baju":
				gp.playSE(1);
				poin = poin + 5;
				gp.obj[i] = null;
				gp.ui.showMessage("Kamu membawa baju ganti");
				break;
			case "Boots":
				gp.playSE(2);
				speed++;
				gp.obj[i] = null;
				gp.ui.showMessage("Speed Up!");
				break;
			case "BotolA":
				gp.playSE(1);
				poin = poin + 20;
				gp.obj[i] = null;
				gp.ui.showMessage("Kamu membawa minum");
				break;
			case "BotolB":
				gp.playSE(1);
				poin = poin + 20;
				gp.obj[i] = null;
				gp.ui.showMessage("Kamu membawa minum");
				break;	
			case "Bekal":
				gp.playSE(1);
				poin = poin + 15;
				gp.obj[i] = null;
				gp.ui.showMessage("Kamu membawa bekal");
				break;
			case "Crayon":
				gp.playSE(1);
				poin = poin + 10;
				gp.obj[i] = null;
				gp.ui.showMessage("Kamu membawa crayon");
				break;	
			case "Penghapus":
				gp.playSE(1);
				poin = poin + 15;
				gp.obj[i] = null;
				gp.ui.showMessage("Kamu membawa penghapus");
				break;	
			case "Lumpur":
				gp.playSE(3);
				gp.obj[i].collision = true;
				break;
			case "Air":
				gp.playSE(3);
				gp.obj[i].collision = true;
				break;
			case "Goal":
				gp.ui.gameFinished = true;
				gp.stopMusic();
				gp.playSE(1);
				break;
			}
		}
	}
	
	public void interactNPC(int i) {
		if(i != 999) {
			
		}
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		}
		g2.drawImage(image, screenX, screenY, null);
	}
}
