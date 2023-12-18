package tile.pbo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import id.its.pbo.GamePanel;
import id.its.pbo.UtilityTool;

public class TileManager {
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[50];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/world.txt");
	}
	
	public void getTileImage() {
		setup(0, "rumput", false);
		setup(1, "rumput", false);
		setup(2, "rumput", false);
		setup(3, "rumput", false);
		setup(4, "rumput", false);
		setup(5, "rumput", false);
		setup(6, "rumput", false);
		setup(7, "rumput", false);
		setup(8, "rumput", false);
		setup(9, "rumput", false);

		// World Map
		setup(10, "rumput", false);
		setup(11, "water", true);
		setup(12, "lurus", false);
		setup(13, "lurus2", false);
		setup(14, "pohon", true);
		setup(15, "belok4", false);
		setup(16, "belok1", false);
		setup(17, "belok2", false);
		setup(18, "perempatan", false);
		setup(19, "belok3", false);
		setup(20, "pertigaan", false);
		setup(21, "pertigaan2", false);
		setup(22, "pertigaan3", false);
		setup(23, "pertigaan4", false);
		setup(24, "jembatan", false);
		setup(25, "kuning-kiri_bawah", true);
		setup(26, "kuning-kiri_atas", true);
		setup(27, "kuning-kanan_bawah", true);
		setup(28, "kuning-kanan_atas", true);
		setup(29, "ungu-kanan_atas", true);
		setup(30, "ungu-kiri_atas", true);
		setup(31, "ungu-kanan_bawah", true);
		setup(32, "ungu-kiri_bawah", true);
		setup(33, "boards", true);
		setup(34, "TK-kiri_atas", true);
		setup(35, "TK-kanan_atas", true);
		setup(36, "TK-kanan_bawah", true);
		setup(37, "TK-kiri_bawah", true);
		setup(38, "rumahA", true);
		setup(39, "rumahB", true);
		setup(40, "rumahC", true);
		setup(41, "semak1", true);
		setup(42, "tralight", true);
	}
	
	public void setup(int index, String imageName, boolean collision) {
		UtilityTool uTool = new UtilityTool();
		
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		} catch(Exception e) {
			
		}
	}
	
	public void draw(Graphics2D g2) {
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
			   worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) 
			{
				g2.drawImage(tile[tileNum].image, screenX, screenY, null);
			}
			
			worldCol++;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}
	}
}
