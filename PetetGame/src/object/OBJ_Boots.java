package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import id.its.pbo.GamePanel;

public class OBJ_Boots extends SuperObject {
	GamePanel gp;
	
	public OBJ_Boots(GamePanel gp) {
		this.gp = gp;
		
		name = "Boots";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/boost.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
