package CIS112Final;

import ch06.lists.SortedABList;
import java.util.*;

public class Main{

   public static void main(String[] args){
      WeightedGraph<String> nodeGraph = new WeightedGraph<String>(12);
   
      nodeGraph.addEdge(new GraphEdge<String>("a", "b", 1));
      nodeGraph.addEdge(new GraphEdge<String>("b", "c", 3));
      nodeGraph.addEdge(new GraphEdge<String>("c", "d", 1));
      
      nodeGraph.addEdge(new GraphEdge<String>("a", "e", 1));
      nodeGraph.addEdge(new GraphEdge<String>("b", "f", 1));
      nodeGraph.addEdge(new GraphEdge<String>("c", "g", 4));
      nodeGraph.addEdge(new GraphEdge<String>("d", "h", 1));
      
      nodeGraph.addEdge(new GraphEdge<String>("e", "f", 2));
      nodeGraph.addEdge(new GraphEdge<String>("f", "g", 6));
      nodeGraph.addEdge(new GraphEdge<String>("g", "h", 14));
      
      nodeGraph.addEdge(new GraphEdge<String>("e", "i", 4));
      nodeGraph.addEdge(new GraphEdge<String>("f", "j", 3));
      nodeGraph.addEdge(new GraphEdge<String>("g", "k", 1));
      nodeGraph.addEdge(new GraphEdge<String>("h", "l", 4));
      
      nodeGraph.addEdge(new GraphEdge<String>("i", "j", 11));
      nodeGraph.addEdge(new GraphEdge<String>("j", "k", 2));
      nodeGraph.addEdge(new GraphEdge<String>("k", "l", 2));
      
      UnionFind<String> nodeRelations = new UnionFind<String>();
      WeightedGraph<String> minimumSpanningTree = new WeightedGraph<String>(12);
      
      for (int i = 0; i < nodeGraph.edgeCount(); i++){
         GraphEdge<String> currentEdge = nodeGraph.getEdge(i);
         if (nodeRelations.union(currentEdge.getV(), currentEdge.getU())){
            minimumSpanningTree.addEdge(currentEdge);
         }
      }
      
      // Add a new edge to our MST, inherently creates a loop
      minimumSpanningTree.addEdge(new GraphEdge<String>("i", "j", 1));
      
      // B, The edge is unknown. Find and remove it:
      //  1. Collect all edges of the MST with the new edge
      //  2. Sort those edges by weight (Weighted Graph does this automatically with a SortedABList)
      //  3. Create a new Union-Find to sort nodes into groups by calling union(v, u) on the edges
      //  4. When union(v, u) returns false remove the edge that triggered that from your MST
      nodeRelations = new UnionFind<String>();
      for (int i = 0; i < minimumSpanningTree.edgeCount(); i++){
         GraphEdge<String> currentEdge = minimumSpanningTree.getEdge(i);
         if (!nodeRelations.union(currentEdge.getV(), currentEdge.getU())){
            minimumSpanningTree.removeEdge(currentEdge);
            break;
         }
      }
   }
   
}