package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import id.its.pbo.GamePanel;

public class OBJ_Crayon extends SuperObject {
	GamePanel gp;
	
	public OBJ_Crayon(GamePanel gp) {
		this.gp = gp;
		
		name = "Crayon";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/crayon.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
