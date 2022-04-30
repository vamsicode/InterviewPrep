package com.vamsi.graph;

import java.util.ArrayList;
import java.util.List;


/**
 * Node class implements GNode Interface
 * @author vamsi
 *
 */
public class Node implements GNode {
	
	String name;
	List<GNode> neighbors;

	public Node(String name) {
		this.name = name;
		neighbors = new ArrayList<>();
	}
	
	public void addEdge(Node to) {
		neighbors.add(to);
	}

	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the neighbors to a particular Node.
	 */
	@Override
	public List<GNode> getChildren() {
		return  this.neighbors;
	}
}
