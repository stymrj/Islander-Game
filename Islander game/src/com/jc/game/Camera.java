package com.jc.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Camera {
        private int x;
        private int y;
        private int w;
        private int h;
        private int speed;
        BufferedImage img ;
        
        public Camera(){
        	speed = 100;
        	x = y = 0;
        	w = 1200;
        	h = 600;
        	try {
				img = ImageIO.read(Camera.class.getResource("bgi.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        public Image getPartImage(){
        	return img.getSubimage(x, y, w, h);
        }
       
        public void move(){
         x += speed;
        }
        
        public void drawbg(Graphics g){
      	  g.drawImage(getPartImage(), 0, 0, w, h, null);
        }
}
