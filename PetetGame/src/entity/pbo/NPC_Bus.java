package entity.pbo;

import java.util.Random;

import id.its.pbo.GamePanel;

public class NPC_Bus extends Entity{
	public NPC_Bus(GamePanel gp) {
		super(gp);
		
		direction = "left";
		speed = 1;
		
		getImage();
	}
	
	public void getImage() {
		left1 = setup("/npc/bus1");
		left2 = setup("/npc/bus1");
		right1 = setup("/npc/bus");
		right2 = setup("/npc/bus");
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
