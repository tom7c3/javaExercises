package com.capgemini.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldrygala on 2015-02-09.
 */
public class Node 
{	
	Node(String sid, String spid )
	{
		id = sid;
		predecessorId = spid;
		description = "ASD";
	}
	
	public void setDescription( String s ) { description = s; }
	
	public String getId() { return id; }
	public String getDescription() { return description; }
	public String getPredecessorId() { return predecessorId; }

    private String id;
    private String description;
    private String predecessorId;
}
