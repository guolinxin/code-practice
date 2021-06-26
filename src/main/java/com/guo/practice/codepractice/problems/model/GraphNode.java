package com.guo.practice.codepractice.problems.model;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {


    String value;
    List<GraphNode> neighbours;
    boolean start;
    boolean end;
    int weight;


    GraphNode(String value, boolean start, boolean end) {
        this.value = value;
        this.neighbours = new ArrayList<GraphNode>();
        this.start = start;
        this.end = end;
        this.weight = 0;

    }

    void addNeighbour(GraphNode node) {
        this.neighbours.add(node);
    }

    GraphNode getNextNeighbour() {
        if (end) return null;

        for (GraphNode neighbour : this.neighbours) {
            if (neighbour.weight == this.weight - 1) {
                return neighbour;
            }
        }
        return null;
    }

}
