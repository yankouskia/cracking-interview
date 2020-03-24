## DAY 5. Trees and Graphs

List of tasks:

- [Route Between Nodes](https://github.com/yankouskia/cracking-interview/tree/master/DAY%205/RouteBetweenNodes.java)  
  *Given a directed graph, design an algorithm to find out whether there is a route between two nodes*

- [Minimal Tree](https://github.com/yankouskia/cracking-interview/tree/master/DAY%205/MinimalTree.java)  
  *Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.*

- [List of Depths](https://github.com/yankouskia/cracking-interview/tree/master/DAY%205/ListOfDepths.java)  
  *Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).*

- [Check Balanced](https://github.com/yankouskia/cracking-interview/tree/master/DAY%205/CheckBalanced.java)  
  *Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.*


## Theory

### Tree Types

__Binary Tree__
A binary tree is a tree in which each node has up to two children.  
  
__Binary Search Tree__
A binary search tree is a binary tree in which every node fits a specific ordering property: all left descendent s <= n < all right descendants. This must be true for each node n.  
  
__Balanced Tree__
Balanced tree is a tree, where for each node, the two subtrees differ in height by no more than one.  
  
__Complete Binary Tree__
A complete binary tree is a binary tree in which every level of the tree is fully filled, except for perhaps the last level. To the extent that the last level is filled, it is filled left to right.  
  
__Full Binary Tree__
A full binary tree is a binary tree in which every node has either zero or two children. That is, no nodes have
only one child.  
  
__Perfect Binary Tree__
A perfect binary tree is one that is both full and complete. All leaf nodes will be at the same level, and this level has the maximum number of nodes.  

### Binary Tree Traversal

__In-Order Traversal__ 

In-order traversal means to "visit" (often, print) the left branch, then the current node, and finally, the right
branch.  

```java
void inOrderTraversal(TreeNode node) {
  if (node != null) {
    inOrderTraversal(node.left);
    visit(node);
    inOrderTraversal(node.right);
  }
}
```
  
When performed on a binary search tree, it visits the nodes in ascending order (hence the name "in-order").  

__Pre-Order Traversal__  
Pre-order traversal visits the current node before its child nodes (hence the name "pre-order").  

```java
void preOrderTraversal(TreeNode node) {
  if (node != null) {
    visit(node);
    preOrderTraversal(node,left);
    preOrderTraversal(node.right);
  }
}
```

In a pre-order traversal, the root is always the first node visited.  

__Post-Order Traversal__  

Post-order traversal visits the current node after its child nodes (hence the name "post-order").  

```java
void postOrderTraversal(TreeNode node) {
  if (node != null) {
    postOrderTraversal(node,left);
    postOrderTraversal(node.right);
    visit(node);
  }
}
```

In a post-order traversal, the root is always the last node visited. 


### Binary Heaps

A min-heap is a complete binary tree (that is, totally filled other than the rightmost elements on the last level) where each node is smaller than its children. The root, therefore, is the minimum element in the tree.  
We have two key operations on a min-heap: `insert` and `extractMin`.  

__Insert:__
When we insert into a min-heap, we always start by inserting the element at the bottom. We insert at the rightmost spot so as to maintain the *complete* tree property.  
Then, we *fix* the tree by swapping the new element with its parent, until we find an appropriate spot for the element. We essentially bubble up the minimum element.  

__Extract Minimum Element:__
Finding the minimum element of a min-heap is easy: it's always at the top. The trickier part is how to remove it.  
First, we remove the minimum element and swap it with the last element in the heap (the bottommost, rightmost element). Then, we bubble down this element, swapping it with one of its children until the min-heap property is restored.  
Do we swap it with the left child or the right child? That depends on their values. There's no inherent ordering between the left and right element, but you'll need to take the smaller one in order to maintain the min-heap ordering.  


### Graphs Search

__Depth-First Search (DFS)__  
In DFS, we visit a node a and then iterate through each of a's neighbors. When visiting a node b that is a neighbor of a, we visit all of b's neighbors before going on to a's other neighbors. That is, a exhaustively searches b's branch before any of its other neighbors.  
Note that pre-order and other forms of tree traversal are a form of DFS. The key difference is that when implementing this algorithm for a graph, we must check if the node has been visited. If we don't, we risk getting stuck in an infinite loop. The pseudocode below implements DFS:  

```java
void search(Node root) {
  if (root == null) return;
  visit(root);
  root.visited = true;

  for each (Node n in root.adjacent) {
    if (n.visited == false) {
      search(n);
    }
  }
}
```


__Breadth-First Search (BFS)__
BFS is a bit less intuitive, and many interviewees struggle with the implementation unless they are already familiar with it. The main tripping point is the (false) assumption that BFS is recursive. It's not. Instead, it uses a queue.  
In BFS, node a visits each of a's neighbors before visiting any of their neighbors. You can think of this as searching level by level out from a. An iterative solution involving a queue usually works best.  

```java
void search(Node root) {
  Queue queue = new Queue();
  root.marked = true ;
  queue.enqueue(root); // Add to the end of queue

  while (!queue.isEmpty()) {
    Node r = queue.dequeue(); // Remove from the front of the queue
    visit(r);
    foreach (Node n in r.adjacent) {
      if (n.marked == false) {
        n.marked = true;
        queue.enqueue(n);
      }
    }
  }
}
```

If you are asked to implement BFS, the key thing to remember is the use of the queue. The rest of the algorithm flows from this fact.  


__Bidirectional Search__  

Bidirectional search is used to find the shortest path between a source and destination node. It operates by essentially running two simultaneous breadth-first searches, one from each node. When their searches collide, we have found a path.  
