package com.capgemini.nodes;

import java.lang.invoke.MethodHandles.Lookup;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static void validateMethod(List<Node> nodes)
    {
//    	Map<String, ArrayList<Node>> map = new HashMap<String, ArrayList<Node>>();
//    	Map<String, Node> map = new HashMap<String, Node>();
//    	Map<Node, List<Node>> map = new HashMap<Node, List<Node>>();
    	
    	
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
    		
//    		map.put( node.getId(), new ArrayList<Node>() );
//    		map.put(node.getId(), node);
    	}
    	
//    	for( Node n : map.values() )
//    	{
//    		System.out.println(n.getId());
//    	}
    }
    
    
    public static Map<String, List<Node>> getMap (List<Node> listOfTreeNodes) 
    {
        final Map<String, List<Node>> map = new HashMap<String, List<Node>>();
        for (Node treeNode : listOfTreeNodes) 
        {
            if (map.get(treeNode.getPredecessorId()) != null) 
            {
                map.get(treeNode.getPredecessorId()).add(treeNode);
            } 
            else 
            {
                List<Node> list = new ArrayList<Node>();
                list.add(treeNode);
                map.put(treeNode.getPredecessorId(), list);
            }
        }
        return map;
    }
    
    public static Node constructTree (Map<String, List<Node>> map, Node node) 
    {
        if (map.containsKey(node)) 
        {
//            List<Node> list = map.get(node);
            
            node.addChild(constructTree(map, map.get(node).get(0)));
        }
        return node;
    }
    
    public static void constructTree( ArrayList<Node> node )
    {
    	Map<String, ArrayList<Node>> map = new HashMap<String, ArrayList<Node>>();
    	
    	for ( Node n : node )
    	{
    		ArrayList<Node> al = new ArrayList<Node>();
    		al.add(n);
    		
    		map.put(n.getId(), al);
    	}
    }
    
    List<Node> BuildTreeAndGetRoots(List<Node> actualObjects)
    {
        Map<String, Node> lookup = new HashMap<String, Node>();
        List<Node> rootNodes = new ArrayList<Node>();

        for (Node item : actualObjects)
        {
            // add us to lookup
            Node ourNode = lookup.get( item.getId() );
            
            lookup.
            
            if ( ourNode != null )
            {   // was already found as a parent - register the actual object
                ourNode.Source = item;
            }
            else
            {
                ourNode = new Node() { Source = item };
                lookup.Add(item.ID, ourNode);
            }

            // hook into parent
            if (item.ParentID == item.ID)
            {   // is a root node
                rootNodes.Add(ourNode);
            }
            else
            {   // is a child row - so we have a parent
                Node parentNode;
                if (!lookup.TryGetValue(item.ParentID, out parentNode))
                {   // unknown parent, construct preliminary parent
                    parentNode = new Node();
                    lookup.Add(item.ParentID, parentNode);
                }
                parentNode.Children.Add(ourNode);
            }
        }

        return rootNodes;
    }
    
    public static void main(String[] args)
	{
    	ArrayList<Node> nodes = new ArrayList<Node>();
    	nodes.add( new Node("1000", "1001") );
    	nodes.add( new Node("1001", "1002") );
    	nodes.add( new Node("1002", "1003") );
    	nodes.add( new Node("1003", "1001") );
    	nodes.add( new Node("1003", "1000") );
    	
    	constructTree( nodes );

    	Node root;
    	
    	final Map<String, List<Node>> map = getMap (nodes);
        root = map.get(null).get(0);

        constructTree ( map , root);
    	
    	
    	
//    	validateMethod(nodes);
	}
}
