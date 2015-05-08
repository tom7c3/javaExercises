package com.capgemini.pythagorean;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Pythagorean
{
	public static void findProduct( int value )
	{
		int products = 0;
		
		for ( int i = 0; i <= value; ++i )
		{
			for ( int j = i + 1; j <= value; ++j )
			{
				for ( int k = j + 1; k <= value; ++k )
				{
					if ( i + j + k == value && i*i + j*j == k*k )
					{
						++products;
						System.out.println( i + "*" + i + " + " + j + "*" + j + " = " + k + "*" + k );
						System.out.println( "a = " + i);
						System.out.println( "b = " + j);
						System.out.println( "c = " + k);
						System.out.println( i + " < " + j + " < " + k  + " = " + value);
					}
				}
			}
		
		}
		
		if ( products == 0 )
		{
			System.out.println( "no product found");
		}
		else
		{
			System.out.println( "found " + products + " products");
		}
	}
	
	public static void main(String[] args)
	{
		findProduct(1000);
    	//System.out.println( getProduct(1000) );
	}
}

/*
 
1024 + 1764 = 2704

c
 
a = 16
b = 21
c = 26

c = 1000
*/
