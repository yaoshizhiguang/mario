package org.my.mario;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Enemy implements Runnable {
	
	private Tool t1 = null;
	
	public Tool getT1() {
		return t1;
	}

	public void setT1(Tool t1) {
		this.t1 = t1;
	}
	private int x;
	private int y;
	private int deadTime = 2;
	private int moving = 0;
	
	private Mario mario = null;
	
    public void setMario(Mario mario) {
		this.mario = mario;
	 }

	public int getDeadTime() {
		return deadTime;
	}
	private int startX;
	private int startY;
	
	private int ymove = 0;
	private int upTime = 0 ;
	
	private int type;
	
	private BufferedImage showImage;
	
	private boolean isLeftOrUp = true;
	
	private int upMax = 0;
	
	private int downMax = 0;
	
	private Thread t = new Thread(this);
	
	private int imageType = 0;
	
	private BackGround bg;
	
	public void setBg(BackGround bg) {
		this.bg = bg;
	}
	
	public void dead1() {
		
	}
	public void dead() {
		this.showImage = StaticValue.allTriangleImage.get(2);
		this.isLeftOrUp = false;
		
	}

	public Enemy(int x,int y,boolean isLeft,int type,BackGround bg) {
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
		this.bg = bg;
		this.isLeftOrUp = isLeft;
		this.type = type;
		if(type == 1) {
			this.showImage = StaticValue.allTriangleImage.get(0);
			
		}
		if(type == 3) {
			this.showImage = StaticValue.allTriangleImage.get(0);
		}
		if(type == 4) {
			this.showImage = StaticValue.allLangImage.get(4);
		}
		t.start();
		t.suspend();
	}
	
	public Enemy(int x,int y,boolean isUp,int type,int upMax,int downMax) {
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
		this.isLeftOrUp = isUp;
		this.type = type;
		this.upMax = upMax;
		this.downMax = downMax;
		if(type == 2) {
			this.showImage = StaticValue.allFlowerImage.get(0);
		}
		
		t.start();
		t.suspend();
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(type == 4)
			{
				if(this.isLeftOrUp ) {
					this.x -= 10;
				}
				else {
					this.x += 10;
				}
				
				int temp = 0;
				
				if(this.isLeftOrUp) {
					temp += 4;
				}
				
				boolean canLeft = true;
				boolean canRight = true;
				
				
				for(int i = 0; i < this.bg.getAllObstruction().size(); i++) {
					Obstruction ob = this.bg.getAllObstruction().get(i);
					 
					if((ob.getX() == this.x + 170 )&& 
							(ob.getY() + 166 > this.y && ob.getY() - 166 < this.y)) {
						canRight = false;
					}
					if((ob.getX() == this.x - 170) 
							&& (ob.getY() + 166 > this.y && ob.getY() - 166 < this.y  )) {
						canLeft = false;
					   }
				}
				if(t1 != null) {
					Rectangle r1 = new Rectangle(t1.getX(),t1.getY(),60,60);
					Rectangle r2 = new Rectangle(this.getX(),this.getY(),170,166);
					if(r2.intersects(r1)) {
						bg.getAllEnemy().remove(this);
						bg.getRemovedEnemy().add(this);
						t1.remove();
					}
				}
			
				if(this.isLeftOrUp && !canLeft || this.x == 0 ) {
					this.isLeftOrUp = false;
					
				}
				else if(!this.isLeftOrUp && !canRight || this.x == 840) {
					
					this.isLeftOrUp = true;
				}
				
				
					temp += this.moving;
					moving++;
					if(moving == 4) {
						moving = 0;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					this.showImage = StaticValue.allLangImage.get(temp);
			}
			if(type == 1 || type == 3)
			{
				if(this.isLeftOrUp ) {
					this.x -= 2;
				}
				else {
					this.x += 2;
				}
				if(imageType == 0) {
					imageType = 1;
					
				}
				else {
					imageType = 0;
				}
				boolean canLeft = true;
				boolean canRight = true;
				
				
				for(int i = 0; i < this.bg.getAllObstruction().size(); i++) {
					Obstruction ob = this.bg.getAllObstruction().get(i);
					if((ob.getX() == this.x + 60 )&& 
							(ob.getY() + 50 > this.y && ob.getY() - 50 < this.y)) {
						canRight = false;
					}
					if((ob.getX() == this.x - 60) 
							&& (ob.getY() + 50 > this.y && ob.getY() - 50 < this.y  )) {
						canLeft = false;
					   }
				}
				if(t1 != null) {
					Rectangle r1 = new Rectangle(t1.getX(),t1.getY(),60,60);
					Rectangle r2 = new Rectangle(this.getX(),this.getY(),60,60);
					if(r2.intersects(r1)) {
						bg.getAllEnemy().remove(this);
						bg.getRemovedEnemy().add(this);
						t1.remove();
					}
				}
			
				if(this.isLeftOrUp && !canLeft || this.x == 0 ) {
					this.isLeftOrUp = false;
					
				}
				else if(!this.isLeftOrUp && !canRight || this.x == 840) {
					
					this.isLeftOrUp = true;
				}
					
				if(this.type == 3) {
					
				
					if( this.mario.getUpTime()!=0 && this.upTime == 0 && this.y == 480) {
						this.jump();
					}
					
					 if(this.upTime != 0 ) {
			    		  this.upTime--;
			    		 // this.ymove += 5;
			    	  }
			    	  else {
			    		 
			    			 this.down();
			    		 }
			    		 
					
				    	  this.ymove += 5;
			    	  
			    	  y += ymove;
			    	  if(this.y > 480) {
							this.y = 480;
						}
			      }
				
				this.showImage = StaticValue.allTriangleImage.get(imageType);
			}
			if(type == 2) {
				if(this.isLeftOrUp) {
					this.y -= 2;
				}
				else {
					this.y += 2;
				}
				if(imageType == 0) {
					imageType = 1;
					
				}
				else {
					imageType = 0;
				}
				
				if(this.isLeftOrUp && this.y == this.upMax) {
					this.isLeftOrUp = false;
				}
				if(!this.isLeftOrUp && this.y == this.downMax) {
					this.isLeftOrUp = true;
				}
				this.showImage = StaticValue.allFlowerImage.get(imageType);
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public int getType() {
		return type;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public BufferedImage getShowImage() {
		return showImage;
	}
	public void startMove() {
		t.resume();
	}
	public void reset() {
		this.x = this.startX;
		this.y = this.startY;
		if(this.type == 1) {
			this.showImage = StaticValue.allTriangleImage.get(0);
		}
		if(this.type == 2) {
			this.showImage = StaticValue.allFlowerImage.get(0);
		}
		 
	}
	public void jump() {
		ymove = -45;
		upTime = 10;
	}
	public void down() {
		if(this.y < 480) {
		
		ymove = 10;
		}
		
	}

}
