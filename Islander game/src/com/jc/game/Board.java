package com.jc.game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants, ActionListener{
              private Timer timer;
              private Camera camera; 
              private Player player;
      
	
	public void bindEvents(){
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					camera.move();
					player.walk();
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					camera.move();
				}
				if(e.getKeyCode()==KeyEvent.VK_K){
				player.setState(player.KICK);
				}
				
			}
		});
	}
	

    public Board(){
    	player = new Player();
    	camera  = new Camera();
	    setSize(GAME_WIDTH, GAME_HEIGHT);
       
        setFocusable(true);
        bindEvents();
        gameLoop();
    }
  
  public void gameLoop(){
	   timer = new Timer(GAME_SPEED, this);
	   timer.start();
	  
  }

   @Override
   public void actionPerformed(ActionEvent e) {
       repaint();
       player.walk();
  }
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		camera.drawbg(g);
		player.drawPlayer(g);
	}
}
