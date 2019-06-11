package org.my.mario;

import java.awt.image.BufferedImage;

public class Obstruction implements Runnable {
	private int x;
	private int y;
	
	Thread t = new Thread(this);
	
	private int type;
	
	private int startType;
	
	private BufferedImage showImage = null;
	
	private BackGround bg = null;
	
	private boolean hasTool = false;
	private boolean hasMagic = false;
	
	public Obstruction(int x, int y, int type,BackGround bg) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.startType = type;
		this.bg = bg;
		setImage();
		
		
		if(this.type == 11) {
			t.start();
			
		}
	}
	
	

	public void setType(int type) {
		this.type = type;
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

	public void reset() {
		this.type = startType;
		
		this.setImage();
		this.hasTool = true;
		this.hasMagic = true;
	}
	public void setImage() {
		showImage = StaticValue.allObstructionImage.get(type);
		
		
	}

	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(this.bg.isOver()){
				if(this.y < 420) {
					this.y += 5;
				}
				else {
					this.bg.setDown(true);
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
}
