package org.org.fungover.graph;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    List<Vertex> vertices = new ArrayList<>();

    public static void main(String[] args) {
        Graph graph = new Graph();

        for (int i = 0; i < 9; i++) {
            graph.vertices.add(new Vertex(Integer.toString(i)));
        }

        graph.vertices.get(0).edges.add(new Edge(1, 4));
        graph.vertices.get(0).edges.add(new Edge(7, 8));

        graph.vertices.get(1).edges.add(new Edge(0, 4));
        graph.vertices.get(1).edges.add(new Edge(2, 8));
        graph.vertices.get(1).edges.add(new Edge(7, 11));

        graph.vertices.get(2).edges.add(new Edge(1, 8));
        graph.vertices.get(2).edges.add(new Edge(3, 7));
        graph.vertices.get(2).edges.add(new Edge(5, 4));
        graph.vertices.get(2).edges.add(new Edge(8, 2));

        graph.vertices.get(3).edges.add(new Edge(4, 9));
        graph.vertices.get(3).edges.add(new Edge(5, 14));
        graph.vertices.get(3).edges.add(new Edge(2, 7));

        graph.vertices.get(4).edges.add(new Edge(3, 9));
        graph.vertices.get(4).edges.add(new Edge(5, 10));

        graph.vertices.get(5).edges.add(new Edge(3, 14));
        graph.vertices.get(5).edges.add(new Edge(2, 4));
        graph.vertices.get(5).edges.add(new Edge(6, 2));
        graph.vertices.get(5).edges.add(new Edge(4, 10));

        graph.vertices.get(6).edges.add(new Edge(8, 6));
        graph.vertices.get(6).edges.add(new Edge(7, 1));
        graph.vertices.get(6).edges.add(new Edge(5, 2));


        graph.vertices.get(7).edges.add(new Edge(8, 7));
        graph.vertices.get(7).edges.add(new Edge(1, 11));
        graph.vertices.get(7).edges.add(new Edge(0, 8));
        graph.vertices.get(7).edges.add(new Edge(6, 1));

        graph.vertices.get(8).edges.add(new Edge(2, 2));
        graph.vertices.get(8).edges.add(new Edge(6, 6));
        graph.vertices.get(8).edges.add(new Edge(7, 7));

        graph.calculateShortestDistances(0);
        int distance = graph.shortestPath(4);
        System.out.println(distance);
        //Vilka vertices ska vi passera för att komma dit
        List<Integer> path = graph.shortestPathAsList(4);
        System.out.println(path.stream().map(Object::toString).collect(Collectors.joining(" - ")));
    }

    int[] shortestDistanceToVertex;
    int[] previousVertex;

    public void calculateShortestDistances(int start){
        final int V = vertices.size();
        shortestDistanceToVertex = new int[V];    //Shortest distance to reach this vertex
        previousVertex = new int[V];   //What vertex did we travel from to this index
        Set<Integer> visited = new HashSet<>();  //List of vertex id we have visited
        for (int i = 0; i < V; i++) {
            shortestDistanceToVertex[i] = Integer.MAX_VALUE;
            previousVertex[i] = -1;
        }
        shortestDistanceToVertex[start] = 0;

        Queue<Edge> places = new PriorityQueue<>();
        places.add(new Edge(start, 0));

        while( visited.size() != V ){
            int d = places.remove().dest;
            visited.add(d);
            for (Edge edge: vertices.get(d).edges) {
                if( !visited.contains(edge.dest))
                {
                    int newDist = shortestDistanceToVertex[d] + edge.cost;
                    if( newDist < shortestDistanceToVertex[edge.dest]) {
                        shortestDistanceToVertex[edge.dest] = newDist;
                        previousVertex[edge.dest] = d;
                    }
                    places.add(new Edge(edge.dest, shortestDistanceToVertex[edge.dest]));
                }
            }
        }
    }

    public List<Integer> shortestPathAsList(int dest) {
        if( previousVertex == null)
            throw new IllegalStateException("Call to shortestPath before calculateShortestDistances");
        List<Integer> shortestPath = new ArrayList<>();
        shortestPath.add(dest);
        int prevIndex = previousVertex[dest];
        while( prevIndex != -1){
            shortestPath.add(0,prevIndex);
            prevIndex = previousVertex[prevIndex];
        }
        return shortestPath;
    }

    public int shortestPath(int dest) {
        if( shortestDistanceToVertex == null)
            throw new IllegalStateException("Call to shortestPath before calculateShortestDistances");
        return shortestDistanceToVertex[dest];
    }
}
