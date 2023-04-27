package com.jc.game;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Player implements GameConstants, PlayerState{
	  private int x;
	  private int y;
	  private int w;
	  private int h;
	  private int speed;
	  private int state;
	  private boolean isVisible;
	  public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	private final int FLOOR = GAME_HEIGHT - 100;
          BufferedImage img;
          BufferedImage firstImage[];
          
          public Player(){
        	  loadSpriteSheet();
        	  firstImage = firstImage();
        	  
        	  x = 100;
        	  w = 50;
        	  h = 100;
        	  y = FLOOR - 50;
        	  speed = 7;
        	  isVisible = true;
        	
          }
          
          public void loadSpriteSheet(){
        	  try {
  				img = ImageIO.read(Player.class.getResource("islander.png"));
  			} catch (IOException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
          }
          
         public BufferedImage[] firstImage(){
        	 BufferedImage array[] = new BufferedImage[5];
        	 array[0] = img.getSubimage(0, 341, 170, 262);
        	 array[1] = img.getSubimage(165, 337, 170, 262);
        	 array[2] = img.getSubimage(334, 335, 170, 262);
        	 array[3] = img.getSubimage(499, 327, 170, 262);
        	 array[4] = img.getSubimage(664, 328, 170, 262);
        	 
			return array;
        	 
         }
         int walkPass = 0;
   	  int walkIndex = 0;
   	  public void walkEffect(Graphics g){
   		  if(walkIndex>=firstImage.length-1){
   			  walkIndex = 0;
   		  }
   		  else{
   			  g.drawImage(firstImage[walkIndex], x, y, w, h, null);
   			  walkPass++;
   			  if(walkPass==4){
   			      walkIndex++; 
   			      walkPass = 0;
   		        }
   		    }
   	  }
   	  public void drawPlayer(Graphics g){
 		 // g.drawImage(defaultImage(), x, y, w, h, null);
 		  if(state==WALK){
 			  walkEffect(g);
 		  }
 		  else
 			  if(state==KICK){
 			  
 		  }
       }
   	  public void walk(){
			x += speed;
		}
}