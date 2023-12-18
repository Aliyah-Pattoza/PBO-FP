package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import id.its.pbo.GamePanel;

public class OBJ_Key extends SuperObject {
	GamePanel gp;
	
	public OBJ_Key(GamePanel gp) {
		this.gp = gp;
		
		name = "Tas";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/tas.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
