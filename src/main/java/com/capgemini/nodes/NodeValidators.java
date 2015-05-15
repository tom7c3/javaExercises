package com.capgemini.nodes;

import java.lang.invoke.MethodHandles.Lookup;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

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
    public static void validateMethod( List<Node> nodes ) throws Exception
	{
		Map<String, List<Node>> map = new HashMap<String, List<Node>>();

		for ( Node n : nodes )
		{
			if ( n.getId().length() != 4 )
    			throw new Exception("id does not have 4 characers");
    		
    		if ( n.getDescription().length() > 128 || n.getDescription().length() == 0 )
    			throw new Exception("bad node description character length");
    		
    		if ( !n.getPredecessorId().isEmpty() )
    		{
    			if ( !map.containsKey( n.getPredecessorId() ) )
    				map.put( n.getPredecessorId(), new ArrayList<Node>() );
    			List<Node> list = map.get(n.getPredecessorId());
    			list.add(n);
    		}
		}

        int twins = 0;
        Node twin1 = null;
        Node twin2 = null;
        
        for ( List<Node> node : map.values() )
        {
    	    if ( node.size() == 2 )
    	    {
    	    	++twins;
    	    	twin1 = node.get(0);
    	    	twin2 = node.get(1);
    	    }
    	    else if ( node.size() > 2 )
    	    	throw new Exception("one parent has more than 2 childs");
        }

        if ( twins != 1 )
            throw new Exception("twins more than 1 or none");

        for (String key : map.keySet()) 
        {
        	if ( key == twin1.getId() || key == twin2.getId() )
        		throw new Exception("twins has childs");
        }
        
        System.out.println("Validation OK");
	}
    
    public static void main(String[] args) throws Exception
	{
    	ArrayList<Node> nodes = new ArrayList<Node>();
    	nodes.add( new Node("1000", "") );
    	nodes.add( new Node("1001", "1000") );
    	nodes.add( new Node("1002", "1001") );
    	nodes.add( new Node("1003", "1002") );
    	nodes.add( new Node("1004", "1002") );
    	
    	validateMethod(nodes);
	}
}
