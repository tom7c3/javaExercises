package com.capgemini.taxi;

public class Vector2
{
	public Vector2()
	{
		x = 0;
		y = 0;
	}
	
	public Vector2( float xx, float yy )
	{
		x = xx;
		y = yy;
	}
	
	float length()
	{
		return (float) Math.sqrt( x * x + y * y );
	}
	
	public float x, y;
};
