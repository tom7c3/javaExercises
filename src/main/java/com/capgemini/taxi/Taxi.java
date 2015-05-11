package com.capgemini.taxi;

import java.util.Random;

public class Taxi 
{
	Taxi()
	{
		Random random = new Random();
		mPosition = new Vector2();
		mPosition.x = (random.nextInt(100) - 50) / 10.0f;
		mPosition.y = (random.nextInt(100) - 50) / 10.0f;
		
		mVelocity = new Vector2();
		mVelocity.x = random.nextFloat() / 10.0f;
		mVelocity.y = random.nextFloat() / 10.0f;
		
		mFree = random.nextBoolean();
	}
	
	void update()
	{
		mPosition.x += mVelocity.x;
		mPosition.y += mVelocity.y;
		
		Random random = new Random();
		mFree = random.nextBoolean();
	}
	
	boolean isFree() { return mFree; }
	
	public void setPosition( Vector2 v ) { mPosition = v; }
	public void setFree( boolean b ) { mFree = b; }
	
	Vector2 getVelocity() { return mVelocity; }
	Vector2 getPosition() { return mPosition; }
	
	private boolean mFree;
	private Vector2 mPosition;
	private Vector2 mVelocity;
}
