//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AlienHorde
{
	private List<Alien> aliens;

	public AlienHorde(int size)
	{
//		System.out.println("Creating AlienHorde");
	    aliens = new ArrayList<Alien>();
		int r=0, c=-10;
//		System.out.println(aliens.size()+" "+size);
		for (int i=0; i<size; i++) {
//		    System.out.println("Starting loop");
		    aliens.add(new Alien(c,r,100,88,1));
//		    System.out.println("Creating Alien at "+r+" "+c);
		    c+=100;
		    if(i==size/2-1) {
//		        System.out.println("halfway");
		        r+=100;
		        c=-10;
            }
        }
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
	    for (Alien x: aliens)
	        x.draw(window);
	}

	public void moveEmAll()
	{
        ListIterator itr = aliens.listIterator();
        while(itr.hasNext()) {
            int rand = (int)(Math.random()*4);
            if (rand==0)
                ((Alien)itr.next()).move("up");
            if (rand==1)
                ((Alien)itr.next()).move("right");
            if (rand==2)
                ((Alien)itr.next()).move("down");
            if (rand==3)
                ((Alien)itr.next()).move("left");
        }
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
	    for (int a=0; a<aliens.size(); a++) {
	        Alien alien = aliens.get(a);
	        Rectangle alienBox = new Rectangle(alien.getX(), alien.getY(), alien.getWidth(), alien.getHeight());
            for (Ammo shot: shots) {
                Rectangle shotBox = new Rectangle(shot.getX(), shot.getY(), shot.getWidth(), shot.getHeight());
                if (alienBox.intersects(shotBox)) {
                    aliens.remove(a);
                    shots.remove(shot);
                }
            }
        }
	}

	public String toString()
	{
		return aliens.toString();
	}
}
