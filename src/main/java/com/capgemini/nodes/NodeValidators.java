package com.capgemini.nodes;

import java.io.IOException;
import java.util.List;

/**
 * Created by ldrygala on 2015-02-09.
 * <p/>
 * Write validate for
 * <ul>
 *     <li>node id should have 4 characters</li>
 *     <li>node description can have maximal 128 characters</li>
 *     <li>no cycle</li>
 *     <li>only penultimate can have two subsequent</li>
 * </ul>
 */
public class NodeValidators 
{	
    public void validateMethod(List<Node> nodes)
    {
    	for ( Node node : nodes )
    	{
    		if ( node.getId().length() != 4 )
    		{
    			System.out.println("id does not have 4 characers");
    		}
    		
    		if ( node.getDescription().length() > 128 || node.getDescription().length() == 0 )
    		{
    			System.out.println("bad node description character length");
    		}
    		
    		
    	}
    }
    
    public static void main(String[] args)
	{
    	
	}
}
