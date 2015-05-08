package com.capgemini.nodes;

/**
 * Created by ldrygala on 2015-02-09.
 */
public class Node 
{
	public String getId() { return id; }
	public String getDescription() { return description; }
	public Node getPredecessor() { return predecessor; }
	
    private String id;
    private String description;
    private Node predecessor;
}
