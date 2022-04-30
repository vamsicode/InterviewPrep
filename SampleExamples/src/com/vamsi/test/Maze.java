package com.vamsi.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Maze {

    public static void main(String[] args) {
        char[][] maze = {
                {'.', '.', '.', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '.', '.', '.', '0', '.', '.', '.', '0'},
                {'0', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
                {'.', '.', '.', '0', '.', '0', '.', '0', '.', '0'},
                {'.', '0', '0', '0', '.', '.', '.', '0', '.', '0'},
                {'.', '.', '.', '.', '0', '0', '0', '.', '.', '0'},
                {'.', '0', '0', '.', '.', '.', '0', '.', '.', '0'},
                {'.', '.', '.', '0', '0', '.', '0', '0', '.', '.'},
                {'0', '0', '.', '0', '0', '.', '.', '.', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '.', '.', '.'},
        };

        print(maze);

        if(traverse(maze, 0, 0)) {
            System.out.println("SOLVED maze");
        } else {
            System.out.println("could NOT SOLVE maze");
        }
        
        //Solved maze
        print(maze);
    }

    private static void print(char[][] maze) {
        System.out.println("-----------------------");
        for(int x = 0; x < 10; x++) {
            System.out.print("| ");
            for(int y = 0; y < 10; y++) {
                System.out.print(maze[x][y] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------");
    }

    //If a spot is Empty(no wall), it returns true
    public static boolean isValidSpot(char[][] maze, int r, int c) {
        if(r >= 0 && r < 10 && c >= 0 && c < 10) {
            return maze[r][c] == '.';
        }
        return false;
    }

    //Traverse thru the empty spots in all 4 directions recursively.
    //By check the empty spots using isValidSpot() method above.
    public static boolean traverse(char[][] maze, int r, int c) {
        if(isValidSpot(maze, r, c)) {
            //it is a valid spot
            if(r == 9 && c == 9) {
                return true;
            }

            maze[r][c] = '*';

            //up
            boolean returnValue = traverse(maze, r - 1, c);


            //right
            if(!returnValue) {
                returnValue = traverse(maze, r, c + 1);
            }

            //down
            if(!returnValue) {
                returnValue = traverse(maze, r + 1, c);
            }

            //left
            if(!returnValue) {
                returnValue = traverse(maze, r, c - 1);
            }

            if(returnValue) {
                //System.out.println(r + ", " + c);
                maze[r][c] = '$';
            }
            return returnValue;
        }

        return false;
    }
    
	
	private ArrayList<String> bfs(Node startNode) {

		Queue<GNode> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
        ArrayList<String> nodeList = new ArrayList<String>();

		queue.add(startNode);
		visited.add(startNode.name);

		while (!queue.isEmpty()) {
			GNode currentNode = queue.remove();
			System.out.println(currentNode.getName());

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