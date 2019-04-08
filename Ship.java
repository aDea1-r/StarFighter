//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship()
	{
		this(10,10,10,10,10);
	}

	public Ship(int x, int y)
	{
	   this(x,y,0);
	}

	public Ship(int x, int y, int s)
	{
	   super(x,y,201,175);
	   speed = s;
	   try
	   {
	   		//URL url = getClass().getResource("ship.jpg");
		   image = ImageIO.read(new File("ship.jpg"));
	   }
		catch(Exception e) {
		    System.out.println(e);
        }
	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			//URL url = getClass().getResource("ship.jpg");
			image = ImageIO.read(new File("ship.jpg"));
		}
		catch(Exception e) { }
	}


	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void move(String direction)
	{
		if (getY()-speed>=0 && direction.equals("up"))
		    setY(getY()-speed);
		if (direction.equals("down") || direction.equals("south"))
		    setY(getY()+speed);
		if (direction.equals("east") || direction.equals("right"))
		    setX(getX()+speed);
		if (direction.equals("left") || direction.equals("west"))
		    setX(getX()-speed);
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
