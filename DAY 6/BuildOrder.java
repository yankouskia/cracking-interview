import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class BuildOrder {
  public static boolean dfs(LinkedList<GraphNode> nodes, Stack<String> stack) {
    for (GraphNode n: nodes) {
      if (n.getStatus() == Status.IN_PROGRESS) return false;

      if (n.getStatus() == Status.DRAFT) {
        n.setStatus(Status.IN_PROGRESS);

        if (!dfs(n.getChildren(), stack)) {
          return false;
        }

        n.setStatus(Status.CHECKED);
        stack.push(n.getName());
      }
    }
    return true;
  }

  public static Stack<String> getPath(Graph graph) {
    Stack<String> stack = new Stack<String>();
    boolean isDone = dfs(graph.getNodes(), stack);

    return isDone ? stack : null;
  }

  public static void main(String[] args) {
    Graph graph = new Graph();

    graph.addEdge("G", "F");
    graph.addEdge("F", "B");
    graph.addEdge("A", "C");
    graph.addEdge("B", "C");
    graph.addEdge("C", "E");
    graph.addEdge("C", "D");

    Stack<String> path = getPath(graph);

    // E->D->C->B->F->G->A
    for (int i = 0; i < path.size(); i++) {
      System.out.printf("->%s", path.get(i));
    }
    System.out.println("");
  }
}

class Graph {
  private HashMap<String, GraphNode> graph = new HashMap<String, GraphNode>();
  private LinkedList<GraphNode> nodes = new LinkedList<GraphNode>();

  public void addNode(String name) {
    if (graph.containsKey(name)) {
      return;
    }

    GraphNode node = new GraphNode(name);
    graph.put(name, node);
    nodes.add(node);
  }

  public void addEdge(String from, String to) {
    if (!graph.containsKey(from)) {
      GraphNode node = new GraphNode(from);
      graph.put(from, node);
      nodes.add(node);
    }

    if (!graph.containsKey(to)) {
      GraphNode node = new GraphNode(to);
      graph.put(to, node);
      nodes.add(node);
    }

    graph.get(from).linkTo(graph.get(to));
  }

  public LinkedList<GraphNode> getNodes() {
    return this.nodes;
  }
}

enum Status {
  DRAFT,
  IN_PROGRESS,
  CHECKED,
};

class GraphNode {
  private LinkedList<GraphNode> children = new LinkedList<GraphNode>();
  private Status status = Status.DRAFT;
  private String name;

  public GraphNode(String name) {
    this.name = name;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public LinkedList<GraphNode> getChildren() {
    return children;
  }

  public void linkTo(GraphNode node) {
    this.children.add(node);
  }
}
