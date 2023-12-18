package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import id.its.pbo.GamePanel;

public class OBJ_Bekal extends SuperObject {
	GamePanel gp;
	
	public OBJ_Bekal(GamePanel gp) {
		this.gp = gp;
		
		name = "Bekal";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/bekal.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
