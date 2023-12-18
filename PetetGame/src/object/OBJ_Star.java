package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import id.its.pbo.GamePanel;

public class OBJ_Star extends SuperObject {
	GamePanel gp;
	
	public OBJ_Star(GamePanel gp) {
		this.gp = gp;
		
		name = "Goal";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/goal.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
