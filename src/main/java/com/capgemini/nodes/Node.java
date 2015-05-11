package com.capgemini.nodes;

import java.util.List;

/**
 * Created by ldrygala on 2015-02-09.
 */
public class Node 
{
	Node()
	{
		
	}
	
	Node(String sid, String spid )
	{
		id = sid;
		predecessorId = spid;
		description = "ASD";
	}
	
	public void addChild( Node child ) { mChild.add(child); }
	
	public String getId() { return id; }
	public String getDescription() { return description; }
	public String getPredecessorId() { return predecessorId; }
	//public Node getChild() { return mChild; }
	
    private String id;
    private String description;
    private String predecessorId;
    private List<Node> mChild;
}
