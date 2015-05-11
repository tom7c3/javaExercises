package com.capgemini.pascalrectangle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by ldrygala on 2015-01-23.
 * 0                     1
 * 1                   1   1
 * 2                 1   2   1
 * 3               1   3   3   1
 * 4             1   4   6   4   1
 * 5           1   5   10  10   5   1
 * 6         1   6   15  20  15   6   1
 * 7       1   7   21  35  35   21  7   1
 * 8     1   8   28  56  70  56   28  8   1
 * 9   1   9  36   84  126 126  84  36  9   1
 */
public class PascalRectangle 
{
    public static long pascal(int c, int r) 
    {
    	if ( c < 1 || r < 1 )
    	{
    		return 0;
    	}
    	
    	int[] tab = new int[c];
    	for ( int i = 0; i < c; ++i )
    	{
    		tab[i] = 1;
    	}
    	
    	for ( int i = 0; i < r - 1;  ++i )
    	{	
    		for ( int j = 1; j < c; ++j )
    		{
    			tab[j] = tab[j - 1] + tab[j];  	
    		}
    	}
    	
    	return tab[c - 1];	
    }
    
    public static void main(String[] args)
	{
    	System.out.println( pascal(5,5) );
	}
    
    @Test
    public void shouldReturn126()
    {
    	assertEquals(126, pascal(5,6) );
    	assertEquals(126, pascal(6,5) );
    }
    
    @Test
    public void shouldReturn7()
    {
    	assertEquals(7, pascal(7,2) );
    	assertEquals(7, pascal(7,2) );
    }
    
    @Test
    public void shouldReturn1()
    {
    	assertEquals(1, pascal(1,1) );
    	assertEquals(1, pascal(1,20) );
    	assertEquals(1, pascal(20,1) );
    }
    
    @Test
    public void shouldReturn0()
    {
    	assertEquals(0, pascal(0,1) );
    	assertEquals(0, pascal(-1,20) );
    	assertEquals(0, pascal(-5,-5) );
    }
    
}













