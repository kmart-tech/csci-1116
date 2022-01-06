/*
Author: 
Date: 

Description: 
*/
import java.util.Comparator;

public class Exercise23_03 {
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println();
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                     new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                     new Circle(3), new Circle(14), new Circle(12)};
    quickSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++) {
      System.out.println(list1[i] + " ");
    }

  }

  public static <E extends Comparable<E>> void quickSort(E[] list) {
    quickSort(list, 0, list.length - 1);
  }

  private static <E extends Comparable<E>> void quickSort(E[] list, int start, int end) {/**/
    if (end > start) {
      int pivotIndex = partition(list, start, end);
      quickSort(list, start, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, end);
    }
  }

  private static <E extends Comparable<E>> int partition(E[] list, int start, int end) {
    // choose a pivot (first element in list for now)
    int pivotIndex = (int) (Math.random() * (end - start - 1)) + start;
    E pivot = list[pivotIndex];
    int low = start;
    int high = end;

    while (low < high) {
      while (list[low].compareTo(pivot) <= 0 && low < high) {
        low++;
      }
      while (list[high].compareTo(pivot) > 0 && low < high) {
        high--;
      }

      //swap the chosen elements
      if (high > low) {
        E temp = list[low];
        list[low] = list[high];
        list[high] = temp;

        if (pivotIndex == high) pivotIndex = low;
      }
    }

    // move the pivot to be between the divided elements
    if (pivot.compareTo(list[high]) > 0) {
      list[pivotIndex] = list[high];
      list[high] = pivot;
      return high;
    }
    else if (pivot.compareTo(list[high]) < 0) {
      high--;
      list[pivotIndex] = list[high];
      list[high] = pivot;
      return high;
    }
    else return pivotIndex;
  }

  public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
    quickSort(list, comparator, 0, list.length - 1);
  }

  public static <E> void quickSort(E[] list, Comparator<? super E> comparator, int start, int end) {
    if (end > start) {
      int pivotIndex = partition(list, comparator, start, end);
      quickSort(list, comparator, start, pivotIndex - 1);
      quickSort(list, comparator, pivotIndex + 1, end);
    }
  }

  public static <E> int partition(E[] list, Comparator<? super E> comparator, int start, int end) {
    // choose a pivot (first element in list for now)
    int pivotIndex = (int) (Math.random() * (end - start - 1)) + start;
    E pivot = list[pivotIndex];
    int low = start;
    int high = end;

    while (low < high) {
      while (comparator.compare(list[low], pivot) <= 0 && low < high) {
        low++;
      }
      while (comparator.compare(list[high], pivot) > 0 && low < high) {
        high--;
      }

      //swap the chosen elements
      if (high > low) {
        E temp = list[low];
        list[low] = list[high];
        list[high] = temp;

        if (pivotIndex == high) pivotIndex = low;
      }
    }

    // move the pivot to be between the divided elements
    if (comparator.compare(pivot, list[high]) > 0) {
      list[pivotIndex] = list[high];
      list[high] = pivot;
      return high;
    }
    else if (comparator.compare(pivot, list[high]) < 0) {
      high--;
      list[pivotIndex] = list[high];
      list[high] = pivot;
      return high;
    }
    else return pivotIndex;
  }

}