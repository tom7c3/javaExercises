package com.capgemini.placeToSplit;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
 * Example:
 * {{{
 * canBalance({1, 1, 1, 2, 1}) → true
 * canBalance({2, 1, 1, 2, 1}) → false
 * canBalance({10, 10}) → true
 * }}}
 */
public final class PlaceToSplit 
{

    public static boolean canBalance(int[] nums) 
    {
    	int leftSum = nums[0];
    	int rightSum = 0;
    	for ( int i = 1; i < nums.length; ++i )
    	{
    		rightSum += nums[i];
    	}
    	
    	if ( leftSum == rightSum )
    		return true;
    	
    	for ( int i = 1; i < nums.length - 1; ++i )
    	{
    		leftSum += nums[i];
    		rightSum -= nums[i];
    		
    		if ( leftSum == rightSum )
        		return true;
    	}
    	
        return false;
    }
    
    public static void main(String[] args)
	{
    	//int[] table = {1,1,1,2,1};
    	//int[] table = {2,1,1,2,1};
    	int[] table = {10,10};
    	System.out.println( canBalance(table) );
	}
    
    @Test
    public void shouldReturnTrue()
    {
    	int[] table = {10,10};
    	assertEquals(true,  canBalance( table ) );
    	
    	table = new int[]{1,1,1,2,1};
    	assertEquals(true,  canBalance( table ) );
    
    	table = new int[]{1,1,1,2,5};
    	assertEquals(true,  canBalance( table ) );
    }
    
    @Test
    public void shouldReturnFalse()
    {
    	int[] table = {10,-10};
    	assertEquals(false,  canBalance( table ) );
    	
    	table = new int[]{1,2,1,2,1};
    	assertEquals(false,  canBalance( table ) );
    
    	table = new int[]{1,-1,1,2,5};
    	assertEquals(false,  canBalance( table ) );
    }
    
}










