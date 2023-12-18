package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import id.its.pbo.GamePanel;

public class OBJ_Air extends SuperObject {
	GamePanel gp;
	
	public OBJ_Air(GamePanel gp) {
		this.gp = gp;
		
		name = "Air";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/air.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
