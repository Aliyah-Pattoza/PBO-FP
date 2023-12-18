package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import id.its.pbo.GamePanel;

public class OBJ_BotolB extends SuperObject {
	GamePanel gp;
	
	public OBJ_BotolB(GamePanel gp) {
		this.gp = gp;
		
		name = "BotolB";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/botolB.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
