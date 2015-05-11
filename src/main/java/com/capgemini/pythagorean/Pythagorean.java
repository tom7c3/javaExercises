package com.capgemini.pythagorean;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Pythagorean
{
	public static long findProduct( int value )
	{
//		int products = 0;
		
		for ( int i = 0; i <= value; ++i )
		{
			for ( int j = i + 1; j <= value; ++j )
			{
				for ( int k = j + 1; k <= value; ++k )
				{
					if ( i + j + k == value && i*i + j*j == k*k )
					{
//						++products;
//						System.out.println( i + "*" + i + " + " + j + "*" + j + " = " + k + "*" + k );
//						System.out.println( "a = " + i);
//						System.out.println( "b = " + j);
//						System.out.println( "c = " + k);
//						return i + " < " + j + " < " + k;
						return i * j * k;
//						System.out.println( i + " < " + j + " < " + k  + " = " + value);
					}
				}
			}
		
		}
		
		return 0;
		
//		if ( products == 0 )
//		{
//			System.out.println( "no product found");
//			return 0;
//		}
//		else
//		{
//			System.out.println( "found " + products + " products");
//			return products;
//		}
	}
	
	public static void main(String[] args)
	{
    	System.out.println( findProduct(200) );
	}
	
	@Test
	public void shouldReturn31875000()
	{
		assertEquals(31875000, findProduct(1000) );
	}
	
	@Test
	public void shouldReturn60()
	{
		assertEquals(60, findProduct(12) ); // 3 + 4 + 5 //
	}
	
	@Test
	public void shouldReturn0()
	{
		assertEquals(0, findProduct(13) ); 
	}
	
	@Test
	public void shouldReturn12180()
	{
		assertEquals(12180, findProduct(70) ); // 20 + 21 + 29 //
	}
}










