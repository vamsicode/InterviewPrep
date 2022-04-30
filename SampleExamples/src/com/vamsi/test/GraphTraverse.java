package com.vamsi.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * Traverse the Graph using BFS-Breadth First Search using Queue (FIFO)
 * 
 * @author vamsi
 *
 */
class GraphTraverse {
    public static void main(String[] args) {
    
        //Constructing the graph
        Node n0 = new Node("0");
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");

        //Populate children
        n0.addEdge(n1);
        n1.addEdge(n0);
        n1.addEdge(n3);
        n1.addEdge(n2);
        n2.addEdge(n1);
        n2.addEdge(n4);
        n3.addEdge(n1);
        n3.addEdge(n4);
        n3.addEdge(n5);
        n4.addEdge(n2);
        n4.addEdge(n3);
        n5.addEdge(n3);


        //Traversal method using BFS - Breadth First Search using Queue(FIFO)
        System.out.println("BFS Iterative:");
        System.out.println(walkGraph(n0).toString());
        
//        System.out.println("Test Paths:");
//        System.out.println(paths(n0).toString());

    }

	/*
	 * Implement a function with the following signature:
	 * 
	 * public ArrayList walkGraph(GNode);
	 * 
	 * which should return a ArrayList containing every GNode in the graph. Each
	 * node should appear in the ArrayList exactly once (i.e. no duplicates).
	 * 
	 * 
	 * Breadth First Search uses a queue(FIFO) to traverse the graph. A start node is added to the queue to start.
     * As long as the queue is not empty, a node is removed and its unvisited neighbors are added to the queue. 
     * 
	 * Since a graph may contain cycles, a visited hashset is used to keep track of all visited nodes. 
	 * We only want to add unvisited nodes into the queue.
	 * 
	 */
    public static ArrayList<String> walkGraph(GNode startNode) {
        
        Queue<GNode> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        ArrayList<String> nodeList = new ArrayList<String>();
        
        queue.add(startNode);
        visited.add(startNode.getName());
        
        while (!queue.isEmpty()) {
            GNode currentNode = queue.remove();
            nodeList.add(currentNode.getName());
            
            for (GNode n : currentNode.getChildren()) {
                if (!visited.contains(n.getName())) {
                    queue.add((Node) n);
                    visited.add(n.getName());
                }
            }
        }
		return nodeList;
    }

 

    

}

