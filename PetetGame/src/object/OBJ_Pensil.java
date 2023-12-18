package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import id.its.pbo.GamePanel;

public class OBJ_Pensil extends SuperObject {
	GamePanel gp;
	
	public OBJ_Pensil(GamePanel gp) {
		this.gp = gp;
		
		name = "Pensil";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/pensil.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
