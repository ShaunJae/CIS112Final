package CIS112Final;

import ch06.lists.SortedABList;

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
      
   }
}