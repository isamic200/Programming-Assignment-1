// ConceptDemo.java
// Isaiah Clark
// October 31, 2026
// Demonstrates the Adapter pattern and Java Collections.

// Import collection classes.
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Main application class.
public class ConceptDemo {

   public static void main(String[] args) {

      // Create an Integer array with several values.
      Integer[] numbers = {5, 2, 9, 1, 4, 7};

      // Create an ArrayAdapter to adapt the array to a List.
      ArrayAdapter adapter = new ArrayAdapter(numbers);

      // Convert the array into a mutable ArrayList.
      List<Integer> numberList = adapter.toList();

      // Display the original list before sorting.
      System.out.println("Before sorting: " + numberList);

      // Sort the list in ascending numerical order.
      Collections.sort(numberList);

      // Display the sorted list.
      System.out.println("After sorting: " + numberList);

      // Remove the value 4 instead of removing index 4.
      numberList.remove(Integer.valueOf(4));

      // Display the list after removing the value.
      System.out.println("After removing 4: " + numberList);

      // Display the list using an unbounded wildcard.
      printList(numberList);
   }

   // Accepts a List containing any type of object.
   public static void printList(List<?> list) {

      System.out.println(
         "Printing list using unbounded wildcard: " + list
      );
   }
}

// Object Adapter class.
class ArrayAdapter {

   // Store the Integer array as a component.
   private Integer[] elements;

   // Constructor receives the array to be adapted.
   public ArrayAdapter(Integer[] elements) {
      this.elements = elements;
   }

   // Adapt the array into a new mutable List<Integer>.
   public List<Integer> toList() {

      // Use the Diamond Operator to create the ArrayList.
      List<Integer> list = new ArrayList<>();

      // Add all array elements to the new list.
      Collections.addAll(list, elements);

      // Return the newly created list.
      return list;
   }
}
