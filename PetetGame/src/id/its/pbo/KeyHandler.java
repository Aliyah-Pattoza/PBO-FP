package id.its.pbo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	// DEBUG
	boolean checkDrawTime = false;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	 
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		if(gp.gameState == gp.titleState) {
			if(code == KeyEvent.VK_UP) {
				gp.ui.commandNum--;
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}
			}
			if(code == KeyEvent.VK_DOWN) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}
			}
			if(code == KeyEvent.VK_ENTER) {
				if(gp.ui.commandNum == 0) {
					gp.gameState = gp.playState;
					gp.playMusic(0);
				}
				if(gp.ui.commandNum == 1) {
					System.exit(0);
				}
			}
		}
	
		if(code == KeyEvent.VK_UP) {
			upPressed = true;
		}
		if(code == KeyEvent.VK_DOWN) {
			downPressed = true;
		}
		if(code == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		if(code == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}
		if(code == KeyEvent.VK_P) {
			if(gp.gameState == gp.playState) {
				gp.gameState = gp.pauseState;
			}
			else if(gp.gameState == gp.pauseState) {
				gp.gameState = gp.playState;
			}
		}
		
		// DEBUG
		if(code == KeyEvent.VK_T) {
			if(checkDrawTime == false) {
				checkDrawTime = true;
			}
			else if(checkDrawTime == true) {
				checkDrawTime = false;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
	
		if(code == KeyEvent.VK_UP) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_DOWN) {
			downPressed = false;
		}
		if(code == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if(code == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
	}
	
}
