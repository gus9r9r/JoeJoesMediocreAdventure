package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32, 32);
	}

	public void tick(){
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 35);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		
		collision();
	}
	
	private void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy){          //tempObject is now basic enemy
				if(getBounds().intersects(tempObject.getBounds())){
					//collision code
					HUD.HEALTH -= 2;
				}
			}
			
		}
	}

	public void render(Graphics g){
		
	/*	Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.green);
		g2d.draw(getBounds());
	*/	
		if(id == ID.Player) g.setColor(Color.white);
		else if(id == ID.Player2) g.setColor(Color.blue);
		g.fillRect(x,  y, 32, 32);
	}
	
		

}
