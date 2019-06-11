package org.my.mario;

import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class StaticValue {
	
	public static List<BufferedImage> allMarioImage=new ArrayList<BufferedImage>();
	public static BufferedImage startImage = null;
	public static BufferedImage endImage = null;
	public static BufferedImage bgImage = null;
	
	public static List<BufferedImage> allFlowerImage=new ArrayList<BufferedImage>();
	public static List<BufferedImage> allTriangleImage=new ArrayList<BufferedImage>();
	public static List<BufferedImage> allTurtleImage=new ArrayList<BufferedImage>();
	public static List<BufferedImage> allObstructionImage=new ArrayList<BufferedImage>();
	public static List<BufferedImage> allToolImage = new ArrayList<BufferedImage>();
	public static List<BufferedImage> allLangImage = new ArrayList<BufferedImage>();
	public static BufferedImage marioDeadImage = null;
	public static BufferedImage wolf = null;
	

	public static String imagePath=System.getProperty("user.dir")+"/bin/";
	
	//��ȫ��ͼƬ��ʼ�� 
	public static void init(){
		
		//������10��ͼƬ
		for(int i=1;i<=12;i++){		
			try {
				//	allMarioImage.add(ImageIO.read(new File(System.getProperty("user.dir")+"/bin"+i+".jpg")));
				allMarioImage.add(ImageIO.read(new File(imagePath+i+".gif")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		try {
			wolf=ImageIO.read(new File(imagePath+"t.gif"));
			startImage=ImageIO.read(new File(imagePath+"start.gif"));
			//endImage=ImageIO.read(new File(imagePath+"firststageend.gif"));
			bgImage=ImageIO.read(new File(imagePath+"firststage.gif"));
			marioDeadImage=ImageIO.read(new File(imagePath+"over.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=1;i<=5;i++){
			try {
				if(i<=2){
					allFlowerImage.add(ImageIO.read(new File(imagePath+"flower"+i+".gif")));
				}
				
				if(i<=3){
					allTriangleImage.add(ImageIO.read(new File(imagePath+"triangle"+i+".gif")));
				}
				
				allTurtleImage.add(ImageIO.read(new File(imagePath+"Turtle"+i+".gif")));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=1;i<=8;i++){
			try {
				
				
				allLangImage.add(ImageIO.read(new File(imagePath+"lang"+i+".png")));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=1;i<=14;i++){
			try {
				allObstructionImage.add(ImageIO.read(new File(imagePath+"ob"+i+".gif")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		for(int i = 1; i <= 4; i++) {
			try {
				allToolImage.add(ImageIO.read(new File(imagePath+"long"+i+".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i = 1; i <= 5; i++) {
			try {
				allToolImage.add(ImageIO.read(new File(imagePath+"fire"+i+".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i = 1; i <= 2; i++) {
			try {
				allToolImage.add(ImageIO.read(new File(imagePath+"magic"+i+".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i = 6; i <= 10; i++) {
			try {
				allToolImage.add(ImageIO.read(new File(imagePath+"fire"+i+".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
