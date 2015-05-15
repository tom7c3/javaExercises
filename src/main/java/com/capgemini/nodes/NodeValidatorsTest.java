package com.capgemini.nodes;

import static org.junit.Assert.*;

import com.capgemini.nodes.NodeValidators;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NodeValidatorsTest
{
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void shouldThrowMoreThanOneChild() throws Exception
	{
		exception.expect(Exception.class);
	    exception.expectMessage("one parent has more than 2 childs");
	    
		ArrayList<Node> nodes = new ArrayList<Node>();
    	nodes.add( new Node("1000", "") );
    	nodes.add( new Node("1001", "1000") );
    	nodes.add( new Node("1002", "1001") );
    	nodes.add( new Node("1003", "1001") );
    	nodes.add( new Node("1004", "1001") );
    	
    	NodeValidators.validateMethod(nodes);
	}
	
	@Test
	public void shouldThrowMoreChildsOrNone() throws Exception
	{
		exception.expect(Exception.class);
	    exception.expectMessage("twins more than 1 or none");
	    
		ArrayList<Node> nodes = new ArrayList<Node>();
    	nodes.add( new Node("1000", "") );
    	nodes.add( new Node("1001", "1000") );
    	nodes.add( new Node("1002", "1000") );
    	nodes.add( new Node("1003", "1001") );
    	nodes.add( new Node("1004", "1001") );
    	
    	NodeValidators.validateMethod(nodes);
	}
	
	@Test
	public void shouldThrowTwinsHasChilds() throws Exception
	{
		exception.expect(Exception.class);
	    exception.expectMessage("twins has childs");
	    
		ArrayList<Node> nodes = new ArrayList<Node>();
    	nodes.add( new Node("1000", "") );
    	nodes.add( new Node("1001", "1000") );
    	nodes.add( new Node("1002", "1001") );
    	nodes.add( new Node("1003", "1001") );
    	nodes.add( new Node("1004", "1003") );
    	
    	NodeValidators.validateMethod(nodes);
	}
	
	@Test
	public void shouldThrowInvalidID() throws Exception
	{
		exception.expect(Exception.class);
	    exception.expectMessage("id does not have 4 characers");
	    
		ArrayList<Node> nodes = new ArrayList<Node>();
    	nodes.add( new Node("1000", "") );
    	nodes.add( new Node("10011", "1000") );

    	NodeValidators.validateMethod(nodes);
	}
	
	@Test
	public void shouldThrowInvalidDescription() throws Exception
	{
		exception.expect(Exception.class);
	    exception.expectMessage("bad node description character length");
	    
    	String s = new String();
    	for ( int i = 0; i < 129; ++i )
    		s += "A";	// s will be 129 characters long //
    	
    	ArrayList<Node> nodes = new ArrayList<Node>();
    	Node node = new Node("1001", "1000");
    	node.setDescription(s);
    	nodes.add( new Node("1000", "") );
    	nodes.add( node );

    	NodeValidators.validateMethod(nodes);
	}
	
	@Test
	public void shouldValidateOK()
	{
		ArrayList<Node> nodes = new ArrayList<Node>();
    	nodes.add( new Node("1000", "") );
    	nodes.add( new Node("1001", "1000") );
    	nodes.add( new Node("1002", "1001") );
    	nodes.add( new Node("1003", "1002") );
    	nodes.add( new Node("1004", "1002") );
    	
    	try
		{
			NodeValidators.validateMethod(nodes);
		} 
    	catch (Exception e)
		{
    		fail(e.getMessage());
		}
	}
}












