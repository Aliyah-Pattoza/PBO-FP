package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import id.its.pbo.GamePanel;

public class OBJ_Baju extends SuperObject {
	GamePanel gp;
	
	public OBJ_Baju(GamePanel gp) {
		this.gp = gp;
		
		name = "Baju";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/baju.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
