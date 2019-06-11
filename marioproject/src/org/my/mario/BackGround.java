package org.my.mario;


import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class BackGround {
	private BufferedImage bgImage = null;
	
	public BufferedImage getBgImage() {
		return bgImage;
	}
	private int sort;
	
	private boolean isOver = false;
	
	private boolean isDown = false;
	
	public boolean isDown() {
		return isDown;
	}
	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}
	public boolean isOver() {
		return isOver;
	}
	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}
	private boolean flag;
	
	private List<Enemy> allEnemy = new ArrayList<Enemy>();
	
	private List<Obstruction> allObstruction = new ArrayList<Obstruction>();
	
	private List<Tool> allTool = new ArrayList<Tool>();
	
	public List<Tool> getAllTool() {
		return allTool;
	}
	public List<Obstruction> getAllObstruction() {
		return allObstruction;
	}
	private List <Enemy>removedEnemy = new ArrayList<Enemy>();
	
	private List <Obstruction> removedObstruction = new ArrayList<Obstruction>();
	
	public BackGround(int sort,boolean flag ) {
		this.sort = sort;
		this.flag = flag;
		
		
	/*	if(flag) {
			bgImage = StaticValue.endImage;
		}
		else {
			bgImage = StaticValue.bgImage;
		}*/
		
		bgImage = StaticValue.bgImage;
		
		//if(sort == 1) {
			for(int i = 0; i < 45+60; i++) {
				this.allObstruction.add(new Obstruction(i*60,540,9,this));
			}
			this.allObstruction.add(new Obstruction(120,360,4,this));
			this.allObstruction.add(new Obstruction(300,360,0,this));
			this.allObstruction.add(new Obstruction(360,360,4,this));
			this.allObstruction.add(new Obstruction(420,360,0,this));
			this.allObstruction.add(new Obstruction(480,360,12,this));
			this.allObstruction.add(new Obstruction(540,360,0,this));
			this.allObstruction.add(new Obstruction(420,180,4,this));
			
			
			this.allObstruction.add(new Obstruction(11*60,600-2*60,8,this));
			this.allObstruction.add(new Obstruction(12*60,600-2*60,7,this));
			this.allObstruction.add(new Obstruction(11*60,600-60,6,this));
			this.allObstruction.add(new Obstruction(12*60,600-60,5,this));
			
			this.allObstruction.add(new Obstruction(2800,300,3,this));
			
			this.allEnemy.add(new Enemy(600,480,true,1,this));
			this.allEnemy.add(new Enemy(2800,480,true,1,this));
			this.allEnemy.add(new Enemy(690,540,true,2,420,540));
			this.allEnemy.add(new Enemy(1700,480,true,3,this));
			this.allEnemy.add(new Enemy(1800,480,true,3,this));
			this.allEnemy.add(new Enemy(2900,480,true,3,this));
		//	this.allEnemy.add(new Enemy(1700+2000,480-106,true,4,this));
			this.allEnemy.add(new Enemy(1700+3000,480-106,true,4,this));
			this.allEnemy.add(new Enemy(1700+4000,480-106,true,4,this));
		//}
		/*if(sort == 2){
			for(int i = 0; i < 15; i++) {
				this.allObstruction.add(new Obstruction(i*60,540,9,this));
			}*/
			this.allObstruction.add(new Obstruction(900+60,540,6,this));
			this.allObstruction.add(new Obstruction(900+120,600-1*60,5,this));
			this.allObstruction.add(new Obstruction(900+1*60,600-120,6,this));
			this.allObstruction.add(new Obstruction(900+2*60,600-120,5,this));
			this.allObstruction.add(new Obstruction(900+1*60,600-180,8,this));
			this.allObstruction.add(new Obstruction(900+2*60,600-180,7,this));
			
			this.allObstruction.add(new Obstruction(2000+60,540,6,this));
			this.allObstruction.add(new Obstruction(2000+120,600-1*60,5,this));
			this.allObstruction.add(new Obstruction(2000+1*60,600-120,6,this));
			this.allObstruction.add(new Obstruction(2000+2*60,600-120,5,this));
			this.allObstruction.add(new Obstruction(2000+1*60,600-180,8,this));
			this.allObstruction.add(new Obstruction(2000+2*60,600-180,7,this));
			
			this.allObstruction.add(new Obstruction(3000+60,540,6,this));
			this.allObstruction.add(new Obstruction(3000+120,600-1*60,5,this));
			this.allObstruction.add(new Obstruction(3000+1*60,600-120,6,this));
			this.allObstruction.add(new Obstruction(3000+2*60,600-120,5,this));
			this.allObstruction.add(new Obstruction(3000+1*60,600-180,8,this));
			this.allObstruction.add(new Obstruction(3000+2*60,600-180,7,this));
			
			this.allObstruction.add(new Obstruction(4000+60,540,6,this));
			this.allObstruction.add(new Obstruction(4000+120,600-1*60,5,this));
			this.allObstruction.add(new Obstruction(4000+1*60,600-120,6,this));
			this.allObstruction.add(new Obstruction(4000+2*60,600-120,5,this));
			this.allObstruction.add(new Obstruction(4000+1*60,600-180,8,this));
			this.allObstruction.add(new Obstruction(4000+2*60,600-180,7,this));
			
			this.allObstruction.add(new Obstruction(5000+60,540,6,this));
			this.allObstruction.add(new Obstruction(5000+120,600-1*60,5,this));
			this.allObstruction.add(new Obstruction(5000+1*60,600-120,6,this));
			this.allObstruction.add(new Obstruction(5000+2*60,600-120,5,this));
			this.allObstruction.add(new Obstruction(5000+1*60,600-180,8,this));
			this.allObstruction.add(new Obstruction(5000+2*60,600-180,7,this));
			
			this.allObstruction.add(new Obstruction(900+240,540,6,this));
			this.allObstruction.add(new Obstruction(900+300,600-1*60,5,this));
			this.allObstruction.add(new Obstruction(900+4*60,600-120,6,this));
			this.allObstruction.add(new Obstruction(900+5*60,600-120,5,this));
			this.allObstruction.add(new Obstruction(900+4*60,600-180,6,this));
			this.allObstruction.add(new Obstruction(900+5*60,600-180,5,this));
			this.allObstruction.add(new Obstruction(900+4*60,600-240,8,this));
			this.allObstruction.add(new Obstruction(900+5*60,600-240,7,this));
			
			this.allObstruction.add(new Obstruction(3000,360,13,this));
			
			this.allObstruction.add(new Obstruction(2800,360,4,this));
			this.allObstruction.add(new Obstruction(2800-60,360,0,this));
			this.allObstruction.add(new Obstruction(2800+60,360,4,this));
			this.allObstruction.add(new Obstruction(2660,360,0,this));
		//}
		/*if(sort == 3){
			for(int i = 0; i < 15; i++) {
				this.allObstruction.add(new Obstruction(i*60,540,9,this));
			}*/
			this.allObstruction.add(new Obstruction(1800+550+3600,190,11,this));
			this.allObstruction.add(new Obstruction(1800+520+3600,480,2,this));
		}
		
	//}
	public boolean isFlag() {
		return flag;
	}
	public List<Enemy> getRemovedEnemy() {
		return removedEnemy;
	}
	public List<Enemy> getAllEnemy() {
		return allEnemy;
	}
	public int getSort() {
		return sort;
	}
	public List<Obstruction> getRemovedObstruction() {
		return removedObstruction;
	}
	public void reset() {
		this.allEnemy.addAll(this.removedEnemy);
		this.allObstruction.addAll(this.removedObstruction);
		
		for(int i = 0; i < this.allEnemy.size();i++) {
			this.allEnemy.get(i).reset();
		}
		for(int i = 0; i < this.allObstruction.size();i++) {
			this.allObstruction.get(i).reset();
		}
	}
	public void enemyStartMove() {
		for(int i = 0; i < this.allEnemy.size(); i++) {
			if(this.allEnemy.get(i).getType() != 3)
			this.allEnemy.get(i).startMove();
		}
	}
}
