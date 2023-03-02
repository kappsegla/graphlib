package org.example.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static List<Vertex> nodes;
    private static List<Edge> edges;

    public static void main(String[] args) {

        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < 10; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        addLane("Edge_0", 0, 1, 4);
        addLane("Edge_1", 0, 7, 8);
        addLane("Edge_2", 1, 2, 8);
        addLane("Edge_3", 1, 7, 11);
        addLane("Edge_4", 2, 3, 7);
        addLane("Edge_5", 2, 5, 4);
        addLane("Edge_6", 2, 8, 2);
        addLane("Edge_7", 7, 8, 7);
        addLane("Edge_8", 3, 4, 9);
        addLane("Edge_9", 7, 6, 1);
        addLane("Edge_10", 8, 6, 6);
        addLane("Edge_11", 6, 5, 2);
        addLane("Edge_12", 5, 4, 10);
        addLane("Edge_13", 3, 5, 14);

        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(0));

        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(4));

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }
    }

    private static void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }
}
