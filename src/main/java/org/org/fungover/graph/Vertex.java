package org.org.fungover.graph;

import java.util.ArrayList;
import java.util.List;

//City
public class Vertex {
    String name;
    List<Edge> edges = new ArrayList<>();

    public Vertex(String name) {
        this.name = name;
    }
}
