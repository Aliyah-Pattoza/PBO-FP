package id.its.pbo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;

import entity.pbo.Entity;


public class UI{
	GamePanel gp;
	Graphics2D g2;
	Font arial_30, arial_15, arial_80B;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	public int commandNum = 0;
	
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
		this.g2 = g2;
		
		g2.setFont(arial_30);
		g2.setColor(Color.black);
		
		if(g2 == null) return;
		
		//TITLE STATE
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
		}

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
			
			// TIME
			if(gp.gameState == gp.playState) { 
			g2.drawString("Poin: " + gp.player.poin, 74, 65);
			playTime += (double)1/60;
			g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize*8, 65);
			}
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
	
	private void drawTitleScreen () {
		if(g2 == null) return;
		else {
			//BackGround Color
			g2.setColor(Color.pink);
			g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
			
			//Font - TitleName
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,50));
			String text = "PETET: Petualangan Teman TK";
			int x = getXforCenteredText(text);
			int y = gp.screenHeight/4;
			
			g2.setColor(Color.white);
			g2.drawString(text, x, y);	
			
			//Foto PETET
			x = (gp.screenWidth/3) + gp.tileSize;
			y =+ gp.tileSize*3;
			g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);
			
			//Menu
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,40));
			text = "New Game";
			x = getXforCenteredText(text);
			y += gp.tileSize*3;
			g2.drawString(text, x, y);
			if(commandNum == 0) {
				g2.drawString(">", x-gp.tileSize, y);
			}

			text = "Quit";
			x = getXforCenteredText(text);
			y += gp.tileSize;
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				g2.drawString(">", x-gp.tileSize, y);
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
