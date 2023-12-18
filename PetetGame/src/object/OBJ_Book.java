package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import id.its.pbo.GamePanel;

public class OBJ_Book extends SuperObject {
	GamePanel gp;
	
	public OBJ_Book(GamePanel gp) {
		this.gp = gp;
		
		name = "Buku";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Buku.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
