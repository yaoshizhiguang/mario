package org.my.mario;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import javax.swing.JOptionPane;



public class Mario implements Runnable {
	private int x;
	private int y;
	
	private boolean canSecond = false;
	
	private boolean canfire = false;
	
	private boolean hasTool = true;
	
	private boolean hasMagic = true;
	
	public void setHasTool(boolean hasTool) {
		this.hasTool = hasTool;
	}

	public boolean isHasTool() {
		return hasTool;
	}

	private Tool tl = null;
	
	private Tool t2 = null;
	
	public Tool getT2() {
		return t2;
	}

	public void setT2(Tool t2) {
		this.t2 = t2;
	}

	private BackGround bg ;
	
	
	public boolean isHasMagic() {
		return hasMagic;
	}

	public void setHasMagic(boolean hasMagic) {
		this.hasMagic = hasMagic;
	}

	/**
	 * @param bg
	 */
	public void setBg(BackGround bg) {
		this.bg = bg;
	}

	public int getXmove() {
		return xmove;
	}

	private Thread t = null;
	
	private int xmove = 0;
	
	private int ymove = 0;
	
	private String status;
	
	private BufferedImage showImage;
	
	private int score;
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	private int life;
	
	private int moving = 0;
	
	private int upTime = 0;
	
	private int secondTime = 0;
	
	private boolean death = false;
	
	private boolean isClear = false;
	
	public boolean isDeath() {
		return death;
	}

	public boolean isClear() {
		return isClear;
	}

	public Mario(int x,int y) {
		this.x = x;
		this.y = y;
		this.showImage = StaticValue.allMarioImage.get(0);
		this.life = 3;
		this.score = 0;
		
	
		
		t = new Thread(this);
		t.start();
		
		
		this.status = "right--standing";
		//System.out.print(this.status);
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

	public void fire() {
		
	}
	
	public void jump() {
		if (this.status.indexOf("jumping") == -1 && this.status.indexOf("sec")==-1) {
			if(this.status.indexOf("left") != -1) {
				this.status = "left--jumping";
			}
			else {
				this.status ="right--jumping";
			}
			ymove = -45  ;
			upTime = 10;
		}
	
		
	}
	
	public void down() {
		if(this.status.indexOf("left") != -1) {
				this.status = "left--jumping";
		}

		else {
				this.status = "right--jumping";
		}
		
		ymove = 10;
	}
	
	public void leftMove() {

		xmove = -7;
		if(this.status.indexOf("jumping") != -1) {
			this.status = "left--jumping";
		}
		else if(this.status.indexOf("sec")!= -1)
		{
			
			this.status = "left--second";
		}
		else {
			this.status = "left--moving";
			
		}
		
	}
	
    public void rightMove() {
		xmove = 7;
		if(this.status.indexOf("jumping")!= -1) {
			this.status = "right--jumping";
		}
		else if(this.status.indexOf("sec")!= -1)
		{
			
			this.status = "right--second";
		}
		else {
			this.status = "right--moving";
		}
	}
	public void leftStop() {
		this.xmove = 0;
		if(this.status.indexOf("jumping") != -1) {
			this.status = "left--jumping";
		}
		else if(this.status.indexOf("sec")!= -1)
		{
			
			this.status = "left--second";
		}
		else {
			this.status = "left--standing";
		}
		
	}
	public void rightStop() {
		this.xmove = 0;
		if(this.status.indexOf("jumping") != -1) {
			this.status = "right--jumping";
		}
		else if(this.status.indexOf("sec")!= -1)
		{
			
			this.status = "right--second";
		}
		else {
			this.status = "right--standing";
		}
		
	}
	public void secondJump() {
		if (this.status.indexOf("sec") == -1 && upTime == 0 && this.canSecond) {
			if(this.status.indexOf("left") != -1) {
				this.status = "left--second";
			}
			else {
				this.status ="right--second";
			}
			ymove = -45  ;
			secondTime = 2;
		}
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void dead() {
		this.life--;
		this.canSecond = false;
		if(this.life == 0) {
			this.death = true;	
		}
		else {
			this.bg.reset();
			this.x = 0;
			this.y = 480;
		}
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			
			if( this.x >= 1800+500+3600) {
				this.bg.setOver(true);
				if(this.bg.isDown()) {
					this.status = "right--moving";
					if(this.x < 1800+540+3600) {
						x += 5;
					}
					else {
						if(y < 480) {
							y += 5;
						}
						x += 5;
						if(x >= 1800+780+3600) {
							this.isClear = true;
						}
					}
				}
				else {
					if(this.y < 420) {
						this.y += 5;
					}
					if(this.y >= 420) {
						y = 420;
						this.status = "right--standing";
					}
				}
			}
			else {
			
			
				boolean canLeft = true;
				boolean canRight = true;
				boolean onLand = false;
				
				  if(this.tl!=null) {
					Rectangle r1 = new Rectangle(tl.getX(),tl.getY(),60,60);
					Rectangle r2 = new Rectangle(this.getX(),this.getY(),60,60);
					if(r2.intersects(r1)) {
						tl.remove();
					
							this.canSecond = true;
						
					
					
				}
				  }
				  if(this.t2 != null) {
						Rectangle r1 = new Rectangle(t2.getX(),t2.getY(),60,60);
						Rectangle r2 = new Rectangle(this.getX(),this.getY(),60,60);
						if(r2.intersects(r1)) {
							t2.remove();
						
							
							
								this.canfire = true;
						
					}
					  }
				for(int i = 0; i < this.bg.getAllObstruction().size(); i++) {
					Obstruction ob = this.bg.getAllObstruction().get(i);
					if((ob.getX() <= this.x + 60 )&&(ob.getX() > this.x ) &&
							(ob.getY() + 50 > this.y && ob.getY() - 50 < this.y)) {
						if(ob.getType() !=3) {
							canRight = false;
							//this.x = ob.getX() - 60;
						}
						
					}
					if((ob.getX() >= this.x - 50 )&&(ob.getX() < this.x ) 
							&& (ob.getY() + 50 > this.y && ob.getY() - 50 < this.y  )) {
						if(ob.getType() !=3) {
							canLeft = false;
						
								//this.x = ob.getX() + 50;
						}
						
					   }
					if(ob.getY() <= this.y + 60 && ob.getY() > this.y
							&& (ob.getX() + 45 > this.x && ob.getX() - 45 < this.x)) {
						if(ob.getType() !=3) {
							onLand = true;
							if(this.y + 60 > ob.getY()) {
								this.y = ob.getY() - 60;
							}
						}
						
					}
					if(ob.getY() >= this.y - 60 && ob.getY() < this.y && (ob.getX() + 45 > this.x && ob.getX() - 45 < this.x
							&& upTime > 0)) {
						if(ob.getType() == 0) {
							this.bg.getAllObstruction().remove(ob);
							this.bg.getRemovedObstruction().add(ob);
						}
						if(ob.getType() == 4 || ob.getType() == 3  && upTime > 0) {
							ob.setType(2);
							ob.setImage();
						}
						if(ob.getType() == 12 && upTime > 0) {
							ob.setType(2);
							ob.setImage();
							this.hasTool = false;
							
							
						}
						if(ob.getType() == 13 && upTime > 0) {
							ob.setType(2);
							ob.setImage();
							this.hasMagic = false;
							
							
						}
						
						upTime = 0;
						secondTime = 0;
					}
				}
					 
			  for(int i = 0; i < this.bg.getAllEnemy().size();i++) {
				  Enemy e = this.bg.getAllEnemy().get(i);
				  if(e.getX() + 50 > this.x  &&  e.getX() -50 < this.x
							&&(e.getY() + 60 > this.y && e.getY() <= this.y)) {
						this.dead();
			      }
				  if(e.getY() <= this.y + 60 &&this.y < e.getY()
							&& (e.getX() + 60 > this.x && e.getX() - 60 < this.x)) {
						if(e.getType() == 1||e.getType()==3) {
							if(this.y + 60 > e.getY()) {
								this.y = e.getY() - 60;
							}
							e.dead();
						
				  
				  
							this.upTime = 5;
							this.ymove = -5;
							int time = e.getDeadTime();
							while(time != 0) {
								try {
									Thread.sleep(30);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								time--;
							}
							bg.getAllEnemy().remove(e);
							bg.getRemovedEnemy().add(e);
						}
						else if(e.getType() == 2) {
							this.dead();
						
						}
				  }
				  if(e.getType() == 4) {
					  Rectangle r3 = new Rectangle(e.getX(),e.getY(),170,166);
					  Rectangle r4 = new Rectangle(this.getX(),this.getY(),60,60);
					  if(r3.intersects(r4)) {
							this.dead();
					  }
				  }
			  }
		      if(onLand && upTime == 0) {
		    	  if(this.status.indexOf("left") != -1) {
		    		  if(xmove != 0) {
		    			  this.status = "left--moving";
		    		  }
		    		  else {
		    			  this.status = "left--standing";
		    		  }
						
					}
				else {
					if(xmove != 0) {
						this.status = "right--moving";
					}
					else {
						this.status ="right--standing";
					}
					
				}
	      }
	      else {
		    	  if(upTime != 0 ) {
		    		  upTime--;
		    		  ymove += 5;
		    	  }
		    	  else {
		    		  if(this.status.indexOf("sec") == -1) {
		    			  this.down();
		    		 }
		    		  else {
		    			 
		    				  secondTime--;
		    			   if(secondTime < -7 &&secondTime > -12)
		    				   ymove = -5;
		    				  
		    		  }
		    		 
			    	  ymove += 5;
		    	  }
		    	  y += ymove;
		      }
		      if(this.y > 600) {
		    	  this.dead();
		      }
		      
			  if(canLeft && xmove < 0 || canRight && xmove > 0  )  {   
			
				
				x += xmove;
				if(this.x < 0) {
					this.x = 0;
				}
			  }
			
				
			}
			int temp = 0;
			
			if(this.status.indexOf("left") !=-1) {
				temp += 5;
			}
			
			
			
			if(this.status.indexOf("moving")!= -1) {
				temp += this.moving;
				moving++;
				if(moving == 4) {
					moving = 0;
				}
			}
			
			if(this.status.indexOf("jumping")!=-1) {
				temp += 4;
			}
			if(this.status.indexOf("sec")!=-1) {
				if(this.status.indexOf("left")!=-1) {
					temp = 10;
				}
				else {
					temp = 11;
				}
				
			}
			
			this.showImage = StaticValue.allMarioImage.get(temp);
			
			
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	}
	public boolean isCanfire() {
		return canfire;
	}

	public int getUpTime() {
		return upTime;
	}

	public void setTl(Tool tl) {
		this.tl = tl;
	
	}

	public Tool getTl() {
		return tl;
	}

	public String getStatus() {
		return status;
	}
}

	


