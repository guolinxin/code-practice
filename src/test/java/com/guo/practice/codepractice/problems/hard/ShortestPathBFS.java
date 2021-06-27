package com.guo.practice.codepractice.problems.hard;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Using the Java language, have the function ShortestPath(strArr) take strArr which will be an
 * array of strings which models a non-looping Graph. The structure of the array will be as follows:
 * The first element in the array will be the number of nodes N (points) in the array as a string.
 * The next N elements will be the nodes which can be anything (A, B, C .. Brick Street, Main Street
 * .. etc.). Then after the Nth element, the rest of the elements in the array will be the
 * connections between all of the nodes. They will look like this: (A-B, B-C .. Brick Street-Main
 * Street .. etc.). Although, there may exist no connections at all.
 *
 * <p>An example of strArr may be: ["4","A","B","C","D","A-B","B-D","B-C","C-D"]. It may help to
 * visualize the Graph by drawing out the nodes and their connections. Your program should return
 * the shortest path from the first Node to the last Node in the array separated by dashes. So in
 * the example above the output should be A-B-D. Here is another example with strArr being
 * ["7","A","B","C","D","E","F","G","A-B","A-E","B-C","C-D","D-F","E-D","F-G"]. The output for this
 * array should be A-E-D-F-G. There will only ever be one shortest path for the array. If no path
 * between the first and last node exists, return -1. The array will at minimum have two nodes.
 * Also, the connection A-B for example, means that A can get to B and B can get to A.
 */
@Slf4j
public class ShortestPathBFS {

  // 1. build the graph from array

  // Node class
  class Node {
    String val;
    int weight;
    Set<Node> adjacentList = new HashSet<>();

    Node(String value) {
      this.val = value;
    }
  }

  // Storage save nodes
  Map<String, Node> nodes = new HashMap<>();

  // add connection / adjacent
  public void addConnection(String start, String end) {
    Node s = nodes.get(start);
    Node e = nodes.get(end);
    s.adjacentList.add(e);
    e.adjacentList.add(s);
  }

  public void createNodes(String[] input) {
    int nodeSize = Integer.parseInt(input[0]);

    // create nodes
    for (int i = 1; i <= nodeSize; i++) {
      Node n = new Node(input[i]);
      nodes.put(input[i], n);
    }

    // add connection
    for (int j = nodeSize + 1; j < input.length; j++) {
      String[] connection = input[j].split("-");
      addConnection(connection[0], connection[1]);
    }
  }

  // 2. BFS shortest path

  public List<String> shortestPathBFS(String start, String end) {

    Node startNode = nodes.get(start);
    Node endNode = nodes.get(end);

    // create queue to loop graph
    Queue<Node> nextTOVisit = new LinkedList<>();
    // create map store visited nodes
    Map<String, Node> visited = new HashMap<>();
    // add startNode
    nextTOVisit.add(startNode);

    // BFS
    while (!nextTOVisit.isEmpty()) {
      Node currentVisit = nextTOVisit.remove();
      // continue loop if visited before
      if (visited.get(currentVisit.val) != null) {
        continue;
      }
      visited.put(currentVisit.val, currentVisit);

      // add adjacent to queue
      for (Node adjNode : currentVisit.adjacentList) {
        if (!adjNode.val.equals(startNode.val) && !visited.containsKey(adjNode.val)) {
          adjNode.weight = currentVisit.weight + 1;
        }
        nextTOVisit.add(adjNode);
      }

      // calculate shortest path if end node found
      if (currentVisit == endNode) {
        log.info("*** End founded ***");
        return buildShortestPath(startNode, endNode);
      }
    }

    // return empty if end node not been visited
    if (!visited.isEmpty() && !visited.containsKey(end)) {
      return Collections.emptyList();
    }

    return Collections.emptyList();
  }

  private List<String> buildShortestPath(Node startNode, Node endNode) {
    // reverse check nodes have least weight to start nodes
    List<String> shortestPath = new ArrayList<>();
    Node current = endNode;
    while (current != null) {
      // add to shortest path list
      shortestPath.add(current.val);
      // get least weight adjacent
      current = getNextLeastWeightAdjacent(current);
      if (current.val.equals(startNode.val)) {
        shortestPath.add(current.val);
        break;
      }
    }
    return shortestPath;
  }

  private Node getNextLeastWeightAdjacent(Node node) {
    Node lessWeightNode = null;
    for (Node adj : node.adjacentList) {
      if (lessWeightNode == null) {
        lessWeightNode = adj;
      } else {
        if (adj.weight < lessWeightNode.weight) {
          lessWeightNode = adj;
        }
      }
    }
    return lessWeightNode;
  }

  public String shortestPath(String[] input, String start, String dest) {
    // creat nodes
    createNodes(input);
    List<String> list = shortestPathBFS(start, dest);

    if (list.isEmpty()) {
      return "-1";
    }

    StringBuilder stringBuilder = new StringBuilder();
    for (int i = list.size() - 1; i >= 0; i--) {
      stringBuilder.append(list.get(i));
      if (i > 0) {
        stringBuilder.append("-");
      }
    }

    return stringBuilder.toString();
  }

  @Test
  public void testShortestPath() {
    String[] s = new String[] {"4", "A", "B", "C", "D", "A-B", "B-D", "B-C", "C-D"};

    ShortestPathBFS shortestPathBFS = new ShortestPathBFS();
    String str = shortestPathBFS.shortestPath(s, "A", "D");

    //    String str = shortestPath(s, "A", "D");

    log.info(str);
  }
}
