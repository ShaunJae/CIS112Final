//---------------------------------------------------------------------------
// GraphEdge.java             by Shaun Jaeschke                SU26-CIS112
//
// Implements a comparable connection of two nodes with a weight.
//---------------------------------------------------------------------------

package CIS112Final;

public class GraphEdge<T> implements Comparable<GraphEdge<T>>{
   private T vertexV;
   private T vertexU;
   private int weight;
   
   public GraphEdge(T v, T u, int weight){
      this.vertexV = v;
      this.vertexU = u;
      this.weight = weight;
   }
   
   // Compare the weights of this GraphEdge and the other GraphEdge
   @Override
   public int compareTo(GraphEdge<T> other){
      if(this.getWeight() == other.getWeight()){
         return 0;
      }
      return this.getWeight() >= other.getWeight() ? 1 : -1;
   }
   
   public T getV(){ return this.vertexV; }
   public T getU(){ return this.vertexU; }
   public int getWeight(){ return this.weight; }
}