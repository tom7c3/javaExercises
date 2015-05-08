package com.capgemini.taxi;

import java.io.ObjectInputStream.GetField;

import com.capgemini.taxi.Vector2;

public class Base
{
	public static float getDistance( User user, Taxi taxi )
	{
		Vector2 userPos = user.getPosition();
		Vector2 taxiPos = taxi.getPosition();
		Vector2 dist = new Vector2( taxiPos.x - userPos.x, taxiPos.y - userPos.y );
		return dist.length();
	}
	
	public void findTaxi( float distance )
	{
		
	}
	
	public static void mainLoop()
	{
		int n = 20;
		while ( running )
		{
			if ( --n == 0 )
				running = false;
			
			//System.out.println("User position: " + user.getPosition().x + " " + user.getPosition().y);
			
			int taxisInRange = 0;
			for ( int i = 0; i < taxiList.length; ++i )
			{	
				Taxi taxi = taxiList[i];
				
				float dist = getDistance( user, taxi );
				//System.out.println(taxi.getPosition().x + " " + taxi.getPosition().y + " " + dist);
				
				if ( dist <= 1.0 && taxi.isFree() )
					++taxisInRange;
				
				taxi.update();
			}
			
			System.out.println("Taxis in range: " + taxisInRange);
		}
	}
	
	public static void main(String[] args)
	{
		user = new User();
		user.setPosition( new Vector2(0,0) );
		
		taxiList = new Taxi[1000];
		
		for ( int i = 0; i < taxiList.length; ++i )
			taxiList[i] = new Taxi();
		
		mainLoop();
	}
	
	private static User user;
	private static Taxi[] taxiList;
	private static boolean running = true;
}
