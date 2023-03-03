package org.org.fungover.graph;

import java.util.Comparator;

//Road
public class Edge implements Comparable<Edge> {
    int cost;  //Distance km
    int dest;

    public Edge(int dest, int cost) {
        this.cost = cost;
        this.dest = dest;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.cost, other.cost);
    }
}
