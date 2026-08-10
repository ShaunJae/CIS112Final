//---------------------------------------------------------------------------
// UnionFind.java             by Julian Lee                  SU26-CIS112
//
// Implements Union-Find ADT
//
// find(x)    - tells you which group x belongs to
// union(x,y) - merges x's group and y's group into one
//
// Used by Kruskal's algorithm to check for cycles: before adding an
// edge (u, v) to the MST, we check if u and v are already in the
// same group. If they are, the edge would just create a loop, so
// it's skipped. Otherwise, the edge is kept and the groups are merged.
//
// Works with any node type T, matching WeightedGraph<T> / GraphEdge<T>.
//
// Runs in near-constant time per operation thanks to two small
// optimizations (path compression and union by rank) that keep
// the internal structure flat and fast to search.
//---------------------------------------------------------------------------

package CIS112Final;

import java.util.HashMap;
import java.util.Map;

public class UnionFind<T> 
{
   private Map<T, T> parent;
   private Map<T, Integer> rank;
   private int count; // number of union-find sets currently remaining

   public UnionFind()
   {
      parent = new HashMap<T, T>();
      rank = new HashMap<T, Integer>();
      count = 0;
   }

   // adds a new node as its own set, if not already there
   // must be called  before a node is used since this ADT does not assume a fixed-size index range
   public void makeSet(T x) //O(1)
   {
      if(!parent.containsKey(x))
      {
         parent.put(x, x);
         rank.put(x, 0);
         count++;
      }
   }

   // return the root/representative of the set containing x
   // path compression: every node visited on the way up is re-pointed directly to the root, flattening the tree for future calls.
   public T find(T x) //O(a(n))
   {
      if(!parent.containsKey(x))
      {
         makeSet(x);
         return x;
      }
      T p = parent.get(x);

      if(!p.equals(x))
      {
         T root = find(p);
         parent.put(x, root); // path compression
         return root;
      }
      return x;
   }

   // combines the sets containing x and y
   // 
   // union by rank: the shorter tree's root is attached under the taller tree's root, so tree height grows very slowly.
   // returns true if a merge happened (x and y were in different sets), returns false if they were already in the same set (like here)
   // this is the signal Kruskal's algorithm uses to know that adding edge (x, y) would create a cycle.
   public boolean union(T x, T y) //O(a(n))
   {
      T rootX = find(x);
      T rootY = find(y);

      if(rootX.equals(rootY))
      {
         return false; //already connected, would form a cycle
      }

      int rankX = rank.get(rootX);
      int rankY = rank.get(rootY);

      if(rankX < rankY)
      {
         parent.put(rootX, rootY);
      } 
      else if(rankX > rankY)
      {
         parent.put(rootY, rootX);
      } 
      else
      {
         parent.put(rootY, rootX);
         rank.put(rootX, rankX + 1);
      }

      count--;
      return true;
   }

   // convenience method: true if x and y are currently in the same set.
   public boolean connected(T x, T y) //O(a(n))
   {
      return find(x).equals(find(y));
   }

   // amount of disjoint sets remaining; for a connected graph, this should equal 1 once 
   // Kruskal's algorithm has processed enough edges to build a spanning tree
   public int getCount() // O(1)
   {
      return count;
   }
}
