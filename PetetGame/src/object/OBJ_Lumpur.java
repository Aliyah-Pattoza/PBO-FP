package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import id.its.pbo.GamePanel;

public class OBJ_Lumpur extends SuperObject {
	GamePanel gp;
	
	public OBJ_Lumpur(GamePanel gp) {
		this.gp = gp;
		
		name = "Lumpur";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/lumpur.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
