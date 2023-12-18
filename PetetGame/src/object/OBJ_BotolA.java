package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import id.its.pbo.GamePanel;

public class OBJ_BotolA extends SuperObject {
	GamePanel gp;
	
	public OBJ_BotolA(GamePanel gp) {
		this.gp = gp;
		
		name = "BotolA";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/botolA.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
