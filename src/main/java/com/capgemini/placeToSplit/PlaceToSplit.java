package com.capgemini.placeToSplit;

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
    private PlaceToSplit()
    {
    	
    }

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
}










