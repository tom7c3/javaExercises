package com.capgemini.coins;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Created by ldrygala on 2015-02-06.
 * <p/>
 * Consider N coins aligned in a row. Each coin is showing either heads or tails. The adjacency of these coins is the number of adjacent pairs of coins with the same side facing up.
 * <p/>
 * It must return the maximum possible adjacency that can be obtained by reversing exactly one coin (that is, one of the coins must be reversed). Consecutive elements of array A represent consecutive coins in the row. Array A contains only 0s and/or 1s: 0 represents a coin with heads facing up; 1 represents a coin with tails facing up. For example, given array A consisting of six numbers, such that:
 * <p/>
 * A[0] = 1
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 0
 * A[5] = 0
 * <p/>
 * the function should return 4. The initial adjacency is 2, as there are two pairs of adjacent coins with the same side facing up, namely (0, 1) and (4, 5). After reversing the coin represented by A[2], the adjacency equals 4, as there are four pairs of adjacent coins with the same side facing up, namely: (0, 1), (1, 2), (2, 3) and (4, 5), and it is not possible to obtain a higher adjacency. The same adjacency can be obtained by reversing the coin represented by A[3].
 */
public class Coins 
{
    public static int solution(List<Integer> coins) 
    {
    	int amount = 0;
    	for ( int i = 1; i < coins.size(); ++i )
    	{
    		if ( coins.get(i) == coins.get(i - 1) )
    		{
    			++amount;
    		}
    	}
        return amount;
    }
    
    public static int findSolution(List<Integer> list )
    {
    	int max = 0;
    	int value = 0;
    	
    	for ( int i = 0; i < list.size(); ++i )
    	{    		
    		if ( list.get(i) == 0 )
    			list.set(i, 1);
    		else if ( list.get(i) == 1)
    			list.set(i, 0);
    		else
    			return -1;

    		value = solution(list);
    		
    		if ( value > max )
    			max = value;
    		
//    		for ( int j = 0; j < list.size(); ++j )
//    		{
//    			System.out.print( list.get(j) );
//    		}
//    		
//    		System.out.print( " : " + value + '\n' );
    		
    		if ( list.get(i) == 0 )
    			list.set(i, 1);
    		else if ( list.get(i) == 1 )
    			list.set(i, 0);
    		else
    			return -1;
    	}
    	
    	return max;
    }
    
    public static void main(String[] args)
	{
    	List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,1,0,1,0,0));
    	System.out.println( findSolution(list) );
	}
    
    @Test
    public void shouldReturn0()
    {
    	assertEquals(0, findSolution( new ArrayList<Integer>(Arrays.asList(1)) ));
    	assertEquals(0, findSolution( new ArrayList<Integer>(Arrays.asList(1,1)) ));
    }

    @Test
    public void shouldReturn1()
    {
    	assertEquals(1, findSolution( new ArrayList<Integer>(Arrays.asList(1,1,1)) ));
    }
    
    @Test
    public void shouldReturn3()
    {
    	assertEquals(3, findSolution( new ArrayList<Integer>(Arrays.asList(1,0,0,1,0)) ));
    }
    
    @Test
    public void shouldReturn4()
    {
    	assertEquals(4, findSolution( new ArrayList<Integer>(Arrays.asList(1,1,0,1,0,0)) ));
    	assertEquals(4, findSolution( new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0)) ));
    	assertEquals(4, findSolution( new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1)) ));
    }
    
    @Test
    public void shouldReturnMinus1()
    {
    	assertEquals(-1, findSolution( new ArrayList<Integer>(Arrays.asList(1,5,1)) ));
    	assertEquals(-1, findSolution( new ArrayList<Integer>(Arrays.asList(1,0,-1)) ));
    }
}












