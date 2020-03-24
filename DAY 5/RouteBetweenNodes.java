/*
  Looking for end node via 2 methods: dfs and bfs
*/

import java.util.ArrayList;
import java.util.LinkedList;

public class RouteBetweenNodes {
  public static boolean isDFSFound = false;
  public static boolean isBFSFound = false;

  public static void dfs(GraphNode start, GraphNode soughtFor) {
    if (start.isVisited()) return;
    start.visit();

    if (start == soughtFor) {
      isDFSFound = true;
    }

    for (GraphNode adjacent: start.adjacentNodes) {
      dfs(adjacent, soughtFor);
    }
  }

  public static void bfs(GraphNode start, GraphNode soughtFor) {
    LinkedList<GraphNode> q = new LinkedList<GraphNode>();

    if (start == soughtFor) {
      isBFSFound = true;
      return;
    }

    start.visit();
    q.add(start);

    while (!q.isEmpty()) {
      GraphNode node = q.remove();

      for (GraphNode adj: node.adjacentNodes) {
        if (!adj.isVisited()) {
          if (adj == soughtFor) {
            isBFSFound = true;
            return;
          }

          adj.visit();
          q.add(adj);
        }
      }
    }
  }

  public static boolean hasRouteDFS(GraphNode start, GraphNode end) {
    dfs(start, end);
    return isDFSFound;
  }

  public static boolean hasRouteBFS(GraphNode start, GraphNode end) {
    bfs(start, end);
    return isBFSFound;
  }

  public static void main(String[] args) {
    GraphNode node1 = new GraphNode(1);
    GraphNode node2 = new GraphNode(2);
    GraphNode node3 = new GraphNode(3);
    GraphNode node4 = new GraphNode(4);
    GraphNode node5 = new GraphNode(5);
    GraphNode node6 = new GraphNode(6);
    GraphNode node7 = new GraphNode(7);
    GraphNode node8 = new GraphNode(8);
    GraphNode node9 = new GraphNode(9);
    GraphNode node10 = new GraphNode(10);
    GraphNode node11 = new GraphNode(11);
    GraphNode node12 = new GraphNode(12);

    node1.pointTo(node2);
    node2.pointTo(node3);
    node3.pointTo(node4);

    node2.pointTo(node5);
    node5.pointTo(node6);
    node6.pointTo(node7);
    node7.pointTo(node8);
    node6.pointTo(node2);

    node6.pointTo(node9);
    node9.pointTo(node1);
    node9.pointTo(node2);

    node9.pointTo(node10);
    node10.pointTo(node11);

    // Node 1 has route to Node 11: true
    System.out.println("Node 1 has route to Node 11: " + hasRouteDFS(node1, node11));

    // Node 1 has route to Node 12: false
    System.out.println("Node 1 has route to Node 12: " + hasRouteDFS(node1, node12));

    // Node 11 has route to Node 1: false
    System.out.println("Node 1 has route to Node 11: " + hasRouteDFS(node11, node1));

    // Node 1 has route to Node 11: true
    System.out.println("Node 1 has route to Node 11: " + hasRouteBFS(node1, node11));

    // Node 1 has route to Node 12: false
    System.out.println("Node 1 has route to Node 12: " + hasRouteBFS(node1, node12));

    // Node 11 has route to Node 1: false
    System.out.println("Node 1 has route to Node 11: " + hasRouteBFS(node11, node1));
  }
}

class GraphNode {
  private boolean visited = false;
  private int value;
  public ArrayList<GraphNode> adjacentNodes = new ArrayList<GraphNode>();

  public GraphNode(int value) {
    this.value = value;
  }

  public void pointTo(GraphNode node) {
    this.adjacentNodes.add(node);
  }

  public int getValue() {
    return this.value;
  }

  public boolean isVisited() {
    return this.visited;
  }

  public void visit() {
    this.visited = true;
  }
}
