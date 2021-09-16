package com.ag.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {


    private int numberOfNodes = 0;
    private final Map<Integer, List<Integer>> adjacencyList= new HashMap<>();

    private void addVertex (int node){
        adjacencyList.put(node, new ArrayList<>());
        numberOfNodes++;
    }

    private void addEdge(int node1, int node2){
        List<Integer> relation = adjacencyList.getOrDefault(node1, new ArrayList<>());
        relation.add(node2);

        relation = adjacencyList.getOrDefault(node2, new ArrayList<>());
        relation.add(node1);
    }

    public void showConnections(){
        StringBuilder connections = new StringBuilder();
        adjacencyList.forEach((node, list)->{
            connections.append(node).append("=>");
            list.forEach(adjacent-> connections.append(adjacent).append(" "));
            connections.append("\n");
        });

        System.out.println(connections);
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public static void main(String[] args) {
        final Graph myGraph = new Graph();
        myGraph.addVertex(0);
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);
        myGraph.addVertex(5);
        myGraph.addVertex(6);
        myGraph.addEdge(3, 1);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(4, 2);
        myGraph.addEdge(4, 5);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(1, 0);
        myGraph.addEdge(0, 2);
        myGraph.addEdge(6, 5);

        myGraph.showConnections();
    }
}
