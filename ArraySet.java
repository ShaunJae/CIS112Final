//---------------------------------------------------------------------------
// GraphEdge.java             by Shaun Jaeschke                SU26-CIS112
//
// Implements the CollectionInterface and wraps the ArrayCollection data
// structure. Two constructors are provided; one is a custom size one is
// a default size.
//---------------------------------------------------------------------------

package CIS112Final;

import ch05.collections.ArrayCollection;
import ch05.collections.CollectionInterface;

public class ArraySet<T> implements CollectionInterface<T> {
   
   // Wrapper data structure
   ArrayCollection<T> set;
   
   public ArraySet() {
      set = new ArrayCollection<T>();
   }
   public ArraySet(int capacity) {
      set = new ArrayCollection<T>(capacity);
   }
   
   public boolean add(T element) {
      if (this.contains(element)) {
         return false;
      }
      
      return set.add(element);
   }
   
   public T get(T element){ return set.get(element); }
   public boolean contains(T element) { return set.contains(element); }
   public boolean remove(T element) { return set.remove(element); }
   public boolean isFull() { return set.isFull(); }
   public int size() { return set.size(); }
   public boolean isEmpty() { return set.isEmpty(); }
      
}