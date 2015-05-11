package com.capgemini.taxi;

import static org.junit.Assert.*;

import org.junit.Test;

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
	
	public static void updateTaxis()
	{
		for ( Taxi t : taxiList )
		{
			t.update();
		}
	}
	
	public static int getTaxisInRange()
	{
		int taxisInRange = 0;
		for ( int i = 0; i < taxiList.length; ++i )
		{	
			Taxi taxi = taxiList[i];
			
			float dist = getDistance( user, taxi );
//			System.out.println(taxi.getPosition().x + " " + taxi.getPosition().y + " " + dist);
			
			if ( dist <= 1.0f && taxi.isFree() )
				++taxisInRange;
		}
		
		updateTaxis();
		
		return taxisInRange;
	}
	
	public static void mainLoop()
	{
		int n = 20;
		while ( running )
		{
			if ( --n == 0 )
				running = false;
			
			int tir = getTaxisInRange();
			updateTaxis();
			
			System.out.println("Taxis in range: " + tir);
		}
	}
	
	public static void main(String[] args)
	{
		user = new User();
		user.setPosition( new Vector2(0,0) );
		
		taxiList = new Taxi[1000000];
		
		for ( int i = 0; i < taxiList.length; ++i )
			taxiList[i] = new Taxi();
		
		mainLoop();
	}
	
	@Test
	public void shouldReturn4()
	{
		user = new User();
		user.setPosition( new Vector2(0,0) );
		
		taxiList = new Taxi[10];
		
		for ( int i = 0; i < 10; ++i )
		{
			taxiList[i] = new Taxi();
		}
		
		taxiList[0].setPosition( new Vector2( 0,    0 ) );
		taxiList[1].setPosition( new Vector2( 0.5f, 0 ) );
		taxiList[2].setPosition( new Vector2( 1,    0 ) );
		taxiList[3].setPosition( new Vector2( 2,    1 ) );
		taxiList[4].setPosition( new Vector2( 0.9f, 1 ) );
		taxiList[5].setPosition( new Vector2( 10,   10 ) );
		taxiList[6].setPosition( new Vector2( 10,   0 ) );
		taxiList[7].setPosition( new Vector2( -0.5f, 0.5f ) );
		taxiList[8].setPosition( new Vector2(-1,   -1 ) );
		taxiList[9].setPosition( new Vector2(-0.7f,  0 ) );
		
		taxiList[0].setFree(false);
		taxiList[1].setFree(true);
		taxiList[2].setFree(true);
		taxiList[3].setFree(true);
		taxiList[4].setFree(true);
		taxiList[5].setFree(true);
		taxiList[6].setFree(true);
		taxiList[7].setFree(true);
		taxiList[8].setFree(true);
		taxiList[9].setFree(true);
		
		assertEquals(4, getTaxisInRange() );
		
	}
	
	private static User user;
	private static Taxi[] taxiList;
	private static boolean running = true;
}
















