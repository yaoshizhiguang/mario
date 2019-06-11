package org.my.mario;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements KeyListener,Runnable {
	
	
	
	private List<BackGround> allBG = new ArrayList<BackGround>();
	
	private Mario mario = null;
	
	private BackGround nowBG = null;
	
	private Tool tl = null;
	
	private Tool t2 = null;
	
	private Tool t3 = null;
	
	public BackGround getNowBG() {
		return nowBG;
	}

	private Thread t = new Thread(this);
	
	private boolean isStart = false;
	
	
	
	public MyFrame () {
		this.setTitle("Fantastic Jack");
		this.setSize(900,600);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((width - 900)/2,(height - 900)/2);
		this.setResizable(false);
		
		StaticValue.init();
		
		for(int i = 1; i <= 3; i++) {
			this.allBG.add(new BackGround(i,i==3?true:false));
		}
		
		this.nowBG = this.allBG.get(0);
	
		
		this.mario = new Mario(0,480);
		
		this.mario.setBg(nowBG);
		
		this.nowBG.getAllEnemy().get(2).setMario(this.mario);
		
			    
	    t.start();
		
		this.addKeyListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new MyFrame();
	}
	
	public void paint(Graphics g) {
		BufferedImage image = new BufferedImage(2700 + 3600,600,BufferedImage.TYPE_3BYTE_BGR);
		Graphics g2 = image.getGraphics();
		
		if(this.isStart) {
			

			
			g2.drawImage(this.nowBG.getBgImage(),0,0,this);
			
			g2.drawString("ÉúÃü£º"+this.mario.getLife(), 700, 30);
			
			
			
			Iterator<Enemy> iterEnemy = this.nowBG.getAllEnemy().iterator();
			while(iterEnemy.hasNext()) {
				Enemy e = iterEnemy.next();
				g2.drawImage(e.getShowImage(),e.getX(),e.getY(),this);
			}
			
			
			Iterator<Obstruction> iter = this.nowBG.getAllObstruction().iterator();
			while(iter.hasNext()) {
				Obstruction ob = iter.next();
				g2.drawImage(ob.getShowImage(),ob.getX(),ob.getY(),this);
			}
			
			if( this.t2!=null&& this.t2.isRemove() == false){
				g2.drawImage(this.t2.getShowImage(),this.t2.getX(),this.t2.getY(),this);
			}
			
			g2.drawImage(this.mario.getShowImage(),this.mario.getX(),this.mario.getY(),this);
			
			if( this.tl!=null&& this.tl.isRemove() == false){
			g2.drawImage(this.tl.getShowImage(),this.tl.getX(),this.tl.getY(),this);
			}
			
			if( this.t3!=null&& this.t3.isRemove() == false){
				g2.drawImage(this.t3.getShowImage(),this.t3.getX(),this.t3.getY(),this);
				}
		
			if(this.mario.getX() > 450 && this.mario.getX() < 2250 + 3600) {
				g2.drawImage(image,0-this.mario.getX()+450,0,this );
				}    
			else if(this.mario.getX()>2250+3600) {
				g2.drawImage(image,-1800-3600,0,this);
			}
		
			
				
		
			g.drawImage(image,0,0,this );
		}
		else {
			g2.drawImage(StaticValue.startImage,0,0,this);
			g.drawImage(image,0,0,this );
		}
			
			
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
	    System.out.println(e.getKeyCode());
		// TODO Auto-generated method stub
	    if(isStart) {
	        if(e.getKeyCode() == 68) {
	        	this.mario.rightMove();
	        }
	        if(e.getKeyCode() == 65) {
	        	this.mario.leftMove();
	        }
	        
	        if(e.getKeyCode() == 76 && this.mario.getStatus().indexOf("standing")==-1&&this.mario.getStatus().indexOf("moving")==-1) {
	        	this.mario.secondJump();
	        }
	        if(e.getKeyCode() == 75) {
	        	this.mario.jump();
	        }

	        if(e.getKeyCode() == 74) {
	        	if(this.mario.isCanfire()) {
	        		if(this.mario.getStatus().indexOf("left") != -1) {
	        			t3 = new Tool(this.mario.getX(),this.mario.getY(),true,3,true);
	        			}
	        		else {
	        			t3 = new Tool(this.mario.getX(),this.mario.getY(),true,3,false);	        		
	        			}
	        		this.t3.setBg(nowBG);
	        		Iterator<Enemy> iterEnemy = this.nowBG.getAllEnemy().iterator();
        			while(iterEnemy.hasNext()) {
        				Enemy e1 = iterEnemy.next();
        				e1.setT1(t3);
        			}
	        	}
	        }
	      
	       
	        
	       
	       
	    }
	    else {
	    	if(e.getKeyCode() == 32) {
	    		this.isStart = true;
	    		this.nowBG.enemyStartMove();
	    		this.mario.setScore(0);
	    		this.mario.setLife(3);
	    	}
	    }
        
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(isStart) {
			// TODO Auto-generated method stub
			  if(e.getKeyCode() == 68) {
		        	this.mario.rightStop();
		        }
		      if(e.getKeyCode() == 65) {
		        	this.mario.leftStop();
		        }
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			
			if(t3!= null && t3.getTime() > 15) {
    			t3.remove();
    		}
			
			if(this.mario.getY() > 480) {
				this.mario.setY(480);
				
			}
			if(this.mario.isHasTool() == false) {
				this.tl = new Tool(480,300,true,1);
				this.tl.setBg(nowBG);
				this.mario.setTl(tl);
				this.mario.setHasTool(true);

			}
			if(this.mario.isHasMagic() == false) {
				this.t2 = new Tool(2950,210,false,2);
				this.t2.setBg(nowBG);
				this.mario.setT2(t2);
				this.mario.setHasMagic(true);

			}
			if(this.mario.getX() > 2000 && this.mario.getX() < 2200) {
				this.nowBG.getAllEnemy().get((this.nowBG.getAllEnemy().size() - 3)).setMario(this.mario);
				this.nowBG.getAllEnemy().get((this.nowBG.getAllEnemy().size() - 3)).startMove();
			}
			if(this.mario.getX() > 800 &&this.mario.getX() < 1000 ) {
				this.nowBG.getAllEnemy().get((this.nowBG.getAllEnemy().size() - 4)).setMario(this.mario);
				this.nowBG.getAllEnemy().get((this.nowBG.getAllEnemy().size() - 4)).startMove();
				this.nowBG.getAllEnemy().get((this.nowBG.getAllEnemy().size() - 5)).setMario(this.mario);
				this.nowBG.getAllEnemy().get((this.nowBG.getAllEnemy().size() - 5)).startMove();
			}
			if(t3 != null && this.t3.isRemove() == true ) {
				System.gc();
			}
				
			this.repaint();
			try {
				Thread.sleep(60);
			//	if(this.mario.getX() >= 840 || this.mario.getX()>900+840) {
				//	this.nowBG = this.allBG.get(this.nowBG.getSort());
				//	this.mario.setBg(this.nowBG);
				//	this.nowBG.enemyStartMove();
				//	this.mario.setX(0);
				//}
				if(this.mario.isDeath()) {
					JOptionPane.showMessageDialog(null, "you dead");
					System.exit(0);
				}
				if(this.mario.isClear()) {
					JOptionPane.showMessageDialog(null, "NB");
					System.exit(0);
				}
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
