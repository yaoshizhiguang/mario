package org.my.mario;

import java.awt.image.BufferedImage;


public class Tool implements Runnable {
	private int time = 0;
	public int getTime() {
		return time;
	}
	private int temp1 = 10;
	private int temp2 = 4;
	private int temp = 0;
	private int x;
	private int y;
	private boolean isLeft = false;
	private boolean canMove = false;
	private int type;
	private Thread t = new Thread(this);
	private boolean remove = false;
	
	public boolean isRemove() {
		return remove;
	}
	private BufferedImage showImage;
	
	private BackGround bg;
	
	public Tool(int x, int y, boolean canMove, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.canMove = canMove;
		
	
		t.start();
	}
	public Tool(int x, int y, boolean canMove, int type, boolean isLeft) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.canMove = canMove;
		this.isLeft = isLeft;
	
		t.start();
	}
	public void remove() {
		this.remove = true;
		 
	}
	
	

	public void setBg(BackGround bg) {
		this.bg = bg;
	}
	@Override
	public void run() {
		while(true) {
			if(type == 3) {
				for(int i = 0; i < bg.getAllObstruction().size(); i++) {
					Obstruction ob = this.bg.getAllObstruction().get(i);
					if((ob.getX() <= this.x + 60 )&&(ob.getX() > this.x ) &&
							(ob.getY() + 50 > this.y && ob.getY() - 50 < this.y)) {
						if(ob.getType() !=3) {
							this.remove();
						}
					}
				}
					if( !isLeft) {
						x += 25;
					}
					else {
						x -= 25;
					}

				    int k = 0;
				    k += temp2;
				    temp2++;
				    if(temp2 == 8)
						temp2 = 4;
					if(this.isLeft == true) {
						this.showImage = StaticValue.allToolImage.get(k+7);
						
					}
					else {
						this.showImage = StaticValue.allToolImage.get(k);
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				time++;
			}
			if(type == 1) {
			boolean isDown = true;
			
				
			for(int i = 0; i < bg.getAllObstruction().size(); i++) {
				Obstruction ob = this.bg.getAllObstruction().get(i);
				if((ob.getX() <= this.x + 60 )&&(ob.getX() > this.x ) &&
						(ob.getY() + 50 > this.y && ob.getY() - 50 < this.y)) {
					if(ob.getType() !=3) {
						isLeft = true;
					}
				}
					if(ob.getY() <= this.y + 60 && ob.getY() > this.y
							&& (ob.getX() + 45 > this.x && ob.getX() - 45 < this.x)) {
						if(ob.getType() !=3) {
							isDown = false;
						}
					}
					if(this.x < 0) {
						remove();
					}
				
			}
			
			
			if(canMove && !isLeft) {
				x += 4;
			}
			else if(canMove && isLeft) {
				x -= 4;
			}
		
		     if(isDown) {
				y += 20;
			}
			// TODO Auto-generated method stub
			
				
				    int i = 0;
				    i += temp;
				    temp++;
				    if(temp == 2)
						temp = 0;
					if(this.isLeft == true) {
						this.showImage = StaticValue.allToolImage.get(i);
						
					}
					else {
						this.showImage = StaticValue.allToolImage.get(i+2);
					}
			}
			if(type == 2) {
				
				if(temp1 == 10)
					temp1 = 9;
				else
					temp1 = 10;
				this.showImage = StaticValue.allToolImage.get(temp1);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
					
					
			
			
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
	public boolean isLeft() {
		return isLeft;
	}
	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
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

}
	
