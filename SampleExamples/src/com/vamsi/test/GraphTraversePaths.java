package com.vamsi.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


/**
 * Traverse the Graph using BFS-Breadth First Search using Queue (FIFO)
 * 
 * @author vamsi
 *
 */
class GraphTraversePaths {
    public static void main(String[] args) {
    
        //Constructing the graph
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");
        Node J = new Node("J");
        

        //Populate children
        A.addEdge(B);
        B.addEdge(E);
        B.addEdge(F);
        A.addEdge(C);
        C.addEdge(G);
        C.addEdge(H);
        C.addEdge(I);
        A.addEdge(D);
        D.addEdge(J);

        System.out.println("Test Paths:");
        System.out.println(paths(A).toString());

    }


    public static ArrayList<ArrayList<String>> paths(GNode startNode) {
        
        Queue<GNode> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        ArrayList<String> nodeList = new ArrayList<String>();
        
        ArrayList<ArrayList<String>> pathsList = new ArrayList<ArrayList<String>>();
        ArrayList<String> paths = new ArrayList<String>();

        
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
		return pathsList;
    }

    public static ArrayList<ArrayList<String>> nodePaths(GNode startNode) {
    	
    	List<GNode> neighbourList = startNode.getChildren();
    	
    	for(GNode n : neighbourList) {
    		n.getName();
    	}
        
        Queue<GNode> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        ArrayList<String> nodeList = new ArrayList<String>();
        
        ArrayList<ArrayList<String>> pathsList = new ArrayList<ArrayList<String>>();
        ArrayList<String> paths = new ArrayList<String>();

        
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
		return pathsList;
    }


}

