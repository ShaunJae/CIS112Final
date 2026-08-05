//---------------------------------------------------------------------------
// WeightedGraph.java          by Shaun Jaeschke                SU26-CIS112
//
// Implements the a graph of nodes with weighted connections
//
// Implementation of removing edges is still needed.
//    When removing an edge it should be checked if a node is no
//    longer referenced by any edges.
//
// Edges are added to a sorted list.
//
// Two constructors are provided; one is a custom size one is
// a default size.
//---------------------------------------------------------------------------

package CIS112Final;

import ch06.lists.SortedABList;

public class WeightedGraph<T>{
   
   private static final int DEFAULT_CAPACITY = 32;
   private ArraySet<T> nodes;
   private SortedABList<GraphEdge<T>> edges;
   
   public WeightedGraph(){
      nodes = new ArraySet(DEFAULT_CAPACITY);
      edges = new SortedABList<GraphEdge<T>>();
   }
   
   public WeightedGraph(int capacity){
      nodes = new ArraySet(capacity);
      edges = new SortedABList<GraphEdge<T>>();
   }
   
   // Add the nodes to the set and 
   //  add the edge to the sorted list
   // TO BE IMPLEMENTED:
   //  Return false when failing to add due to size constraints
   //  or if the edge already exists
   public boolean addEdge(GraphEdge<T> edge){
      nodes.add(edge.getV());
      nodes.add(edge.getU());
      edges.add(edge);
      return true;
   }
}