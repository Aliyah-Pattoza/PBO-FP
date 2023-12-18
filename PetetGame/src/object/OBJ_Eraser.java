package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import id.its.pbo.GamePanel;

public class OBJ_Eraser extends SuperObject {
	GamePanel gp;
	
	public OBJ_Eraser(GamePanel gp) {
		this.gp = gp;
		
		name = "Penghapus";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/eraser.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
