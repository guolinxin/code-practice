package com.guo.practice.codepractice.problems.hard;

import com.guo.practice.codepractice.problems.hard.exp.FarthestNodes;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Using the Java language, have the function FarthestNodes(strArr) read strArr which will be an
 * array of hyphenated letters representing paths between those two nodes. For example:
 * ["a-b","b-c","b-d"] means that there is a path from node a to b (and b to a), b to c, and b to d.
 * Your program should determine the longest path that exists in the graph and return the length of
 * that path. So for the example above, your program should return 2 because of the paths a-b-c and
 * d-b-c. The path a-b-c also means that there is a path c-b-a. No cycles will exist in the graph
 * and every node will be connected to some other node in the graph.
 */
public class LongestPathNodes {

  class Node {
    String val;
    int weight;
    Set<Node> adjacent = new HashSet<>();

    Node from;
    Node to;

    Node(String val) {
      this.val = val;
    }
  }

  class Connection {
    Node from;
    Node to;

    Connection(Node from, Node to) {
      this.from = from;
      this.to = to;
    }
  }

  // map to save node
  Map<String, Node> nodes = new HashMap();
  List<Connection> connections = new ArrayList<>();
  //  Set<String> visited = new HashSet<>();
  int longestPath = 0;

  // process input
  public void processInput(String[] strArr) {
    int strLength = strArr.length;
    for (int i = 0; i < strLength; i++) {
      String[] nodeArr = strArr[i].split("-");
      Node start = new Node(nodeArr[0]);
      Node end = new Node(nodeArr[1]);

      start.to = end;
      end.from = start;

      // adj
      start.adjacent.add(end);
      end.adjacent.add(start);
      nodes.put(nodeArr[0], start);
      nodes.put(nodeArr[1], end);

      // connection
      connections.add(new Connection(start, end));
    }
  }

  public int findLongest(String[] strArr) {
    processInput(strArr);
    for (Node n : nodes.values()) {
      int pathCount = 0;
       findLongestDFS(new HashSet<>(), n, pathCount);
      if (pathCount > longestPath) {
        longestPath = pathCount;
      }
    }
    return longestPath;
  }

  // dfs
  private void findLongestDFS(Set<String> visited, Node node, int count) {
    if (node == null) {
      return;
    }
    visited.add(node.val);
    int updatedCount = count + 1;
    if(node.to != null){
      findLongestDFS(visited, node.to, updatedCount);
    }

    //    for (Connection connection : connections) {
    //      int travelCount = findLongestDFS(visited, connection.to, updatedCount);
    //      System.out.println("travelCount: " + travelCount);
    //      if (travelCount > updatedCount) {
    //        updatedCount = travelCount;
    //      }
    //    }

  }

  @Test
  public void longestPathTest() {
    //    String[] str = new String[] {"a-b","b-c","b-d"};
    String[] str = new String[] {"b-a", "c-e", "b-c", "d-c"};

    LongestPathNodes longestPathNodes = new LongestPathNodes();
    int count = longestPathNodes.findLongest(str);

    System.out.println(count);
  }
}
