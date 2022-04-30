package com.vamsi.test;

import java.util.ArrayList;

public class GraphPaths
{
    // Structure of an N ary tree node
    static class Node
    {
        String data;
        ArrayList<Node> child;

        // Parameterized Constructor
        public Node(String x)
        {
            this.data = x;
            this.child = new ArrayList<>();
        }
    }

    // Function to print the root to leaf
    // path of the given N-ary Tree
    static void printPath(ArrayList<String> vec)
    {
        System.out.println(vec.toString());
    }

    // Utility function to print all
    // root to leaf paths of an Nary Tree
    static void printAllRootToLeafPaths(Node root, ArrayList<String> vec)
    {
    
        // If root is null
        if (root == null)
            return;

        // Insert current node's
        // data into the vector
        vec.add(root.data);

        // If current node is a leaf node
        if (root.child.isEmpty())
        {

            // Print the path
            printPath(vec);

            // Pop the leaf node
            // and return
            vec.remove(vec.size() - 1);
            return;
        }

        // Recur for all children of
        // the current node
        for (int i = 0; i < root.child.size(); i++) {
            // Recursive Function Call
            printAllRootToLeafPaths(root.child.get(i), vec);
        }

        vec.remove(vec.size() - 1);
    }

    // Function to print root to leaf path
    static void printAllRootToLeafPaths(Node root)
    {
    
        // If root is null, return
        if (root == null)
            return;

        // Stores the root to leaf path
        ArrayList<String> vec = new ArrayList<>();

        // Utility function call
        printAllRootToLeafPaths(root, vec);
    }

    // Driver Code
    public static void main(String[] args)
    {

        // Given N-Ary tree
        Node root = new Node("A");
        (root.child).add(new Node("B"));
        (root.child).add(new Node("C"));
        (root.child).add(new Node("D"));
        (root.child.get(0).child).add(new Node("E"));
        (root.child.get(0).child).add(new Node("F"));
        (root.child.get(1).child).add(new Node("G"));
        (root.child.get(1).child).add(new Node("H"));
        (root.child.get(1).child).add(new Node("I"));
        (root.child.get(2).child).add(new Node("J"));
    

        // Function Call
        printAllRootToLeafPaths(root);
    }
}