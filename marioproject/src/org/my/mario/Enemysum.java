package org.my.mario;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Enemysum implements Runnable {
	private int x;
	private int y;
	private int startX;
	private int startY;
	
	
	private BackGround bg;
	private Thread t;
	protected  Mario mario;
	private BufferedImage showImage;
	
	public Enemysum(int x, int y) {
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
		
	}
	
	public void iskiller(Mario mario) {
		Rectangle r1 = new Rectangle(mario.getX(),mario.getY(),60,60);
		Rectangle r2 = new Rectangle(this.x,this.y,60,60);
		if(r2.intersects(r1)) {
			mario.dead();
		}
	}
	
	public void dead() {
		
		
	}
	
	@SuppressWarnings("deprecation")
	public void startMove() {
		t.resume();
	}
	
	public void reset() {
		
	}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
