//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;

	public Alien()
	{
		this(0,0,30,30,0);
	}

	public Alien(int x, int y)
	{
		super(x,y);
		speed = 0;
	}

	public Alien(int x, int y, int s)
	{
		super(x,y);
		speed = s;
	}

	public Alien(int x, int y, int w, int h, int s)
	{
	    super(x, y, w, h);
//        System.out.println("Creating Alien");
		speed=s;
		try
		{
			URL url = getClass().getResource("alien.jpg");
			image = ImageIO.read(url);
//			System.out.println("Found Alien Image");
		}
		catch(Exception e)
		{
//			System.out.println(e);
		}
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
		return "";
	}
}
