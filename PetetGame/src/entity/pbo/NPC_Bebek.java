package entity.pbo;

import java.util.Random;

import id.its.pbo.GamePanel;

public class NPC_Bebek extends Entity {
	public NPC_Bebek(GamePanel gp) {
		super(gp);
		
		direction = "left";
		speed = 1;
		
		getImage();
	}
	
	public void getImage() {
		left1 = setup("/npc/bebek1");
		left2 = setup("/npc/bebek2");
		right1 = setup("/npc/bebek3");
		right2 = setup("/npc/bebek4");
	}
	
	public void setAction() {
		actionLockCounter++;
		
		if(actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100)+1;
			
			if(i <= 25) {
				direction = "left";
			}
			if(i > 25 && i <= 50) {
				direction = "right";
			}
			if(i > 50 && i <= 75) {
				direction = "left";
			}
			if(i > 75 && i <= 100) {
				direction = "right";
			}	
			
			actionLockCounter = 0;
		}
	}
}
