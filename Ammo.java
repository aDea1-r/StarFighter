//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed;

	public Ammo()
	{
		this(0,0);
		speed = 0;
	}

	public Ammo(int x, int y)
	{
		super(x,y);
		speed = 7;
	}

	public Ammo(int x, int y, int s)
	{
		super(x,y);
		speed = s;
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		Color temp = window.getColor();
		window.setColor(Color.ORANGE);
		window.fillRect(getX(),getY(),3,3);
		window.setColor(temp);
	}
	
	
	public void move( String direction )
	{
        if (direction.equals("up"))
            setY(getY()-speed);
        if (direction.equals("down") || direction.equals("south"))
            setY(getY()+speed);
        if (direction.equals("east") || direction.equals("right"))
            setX(getX()+speed);
        if (direction.equals("left") || direction.equals("west"))
            setX(getX()-speed);
	}

	public String toString()
	{
		return getX() + " " + getY() + " " + getSpeed();
	}
}
