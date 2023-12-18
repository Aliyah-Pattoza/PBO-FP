package id.its.pbo;

import entity.pbo.NPC_Bebek;
import entity.pbo.NPC_Bus;
import object.OBJ_Air;
import object.OBJ_Baju;
import object.OBJ_Bekal;
import object.OBJ_Book;
import object.OBJ_Boots;
import object.OBJ_BotolA;
import object.OBJ_BotolB;
import object.OBJ_Crayon;
import object.OBJ_Eraser;
import object.OBJ_Key;
import object.OBJ_Lumpur;
import object.OBJ_Pensil;
import object.OBJ_Star;

public class AssetSetter {
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		gp.obj[0] = new OBJ_Key(gp);
		gp.obj[0].worldX = 18 * gp.tileSize;
		gp.obj[0].worldY = 26 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Book(gp);
		gp.obj[1].worldX = 9 * gp.tileSize;
		gp.obj[1].worldY = 17 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Pensil(gp);
		gp.obj[2].worldX = 30 * gp.tileSize;
		gp.obj[2].worldY = 21 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Baju(gp);
		gp.obj[3].worldX = 27 * gp.tileSize;
		gp.obj[3].worldY = 33 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Boots(gp);
		gp.obj[4].worldX = 7 * gp.tileSize;
		gp.obj[4].worldY = 30 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Lumpur(gp);
		gp.obj[5].worldX = 14 * gp.tileSize;
		gp.obj[5].worldY = 32 * gp.tileSize;
		
		gp.obj[6] = new OBJ_Lumpur(gp);
		gp.obj[6].worldX = 32 * gp.tileSize;
		gp.obj[6].worldY = 20 * gp.tileSize;
		
		gp.obj[7] = new OBJ_Air(gp);
		gp.obj[7].worldX = 12 * gp.tileSize;
		gp.obj[7].worldY = 27 * gp.tileSize;
		
		gp.obj[8] = new OBJ_Air(gp);
		gp.obj[8].worldX = 28 * gp.tileSize;
		gp.obj[8].worldY = 26 * gp.tileSize;
		
		gp.obj[9] = new OBJ_Star(gp);
		gp.obj[9].worldX = 19 * gp.tileSize;
		gp.obj[9].worldY = 8 * gp.tileSize;
		
		gp.obj[10] = new OBJ_BotolA(gp);
		gp.obj[10].worldX = 32 * gp.tileSize;
		gp.obj[10].worldY = 15 * gp.tileSize;
		
		gp.obj[11] = new OBJ_BotolB(gp);
		gp.obj[11].worldX = 24 * gp.tileSize;
		gp.obj[11].worldY = 30 * gp.tileSize;
		
		gp.obj[12] = new OBJ_Bekal(gp);
		gp.obj[12].worldX = 19 * gp.tileSize;
		gp.obj[12].worldY = 12 * gp.tileSize;
		
		gp.obj[13] = new OBJ_Crayon(gp);
		gp.obj[13].worldX = 23 * gp.tileSize;
		gp.obj[13].worldY = 16 * gp.tileSize;
		
		gp.obj[14] = new OBJ_Eraser(gp);
		gp.obj[14].worldX = 32 * gp.tileSize;
		gp.obj[14].worldY = 27 * gp.tileSize;
	}
	
	public void setNPC() {
		gp.npc[0] = new NPC_Bebek(gp);
		gp.npc[0].worldX = 30 * gp.tileSize;
		gp.npc[0].worldY = 28 * gp.tileSize;
		
		gp.npc[1] = new NPC_Bebek(gp);
		gp.npc[1].worldX = 13 * gp.tileSize;
		gp.npc[1].worldY = 28 * gp.tileSize;
		
		gp.npc[2] = new NPC_Bus(gp);
		gp.npc[2].worldX = 12 * gp.tileSize;
		gp.npc[2].worldY = 9 * gp.tileSize;
	}
}
