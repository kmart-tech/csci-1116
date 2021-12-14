/*
Kevin Martinsen
CSCI 1116 - Algorithms and Data Structures
12/14/2021

Exercise 20_21 - generic selection sort using a comparator
*/
import java.util.Comparator;

public class Exercise20_21 {
  public static void main(String[] args) {
    GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
        new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
        new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
        new Circle(6.5), new Rectangle(4, 5)};

    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
      new Circle(5), new Circle(6), new Circle(1), new Circle(2),
      new Circle(3), new Circle(14), new Circle(12)};
    selectionSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++)
      System.out.println(list1[i].getArea() + " ");
  }
  
  public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
    for (int i = 0; i < list.length; i++) {
      E currentMin = list[i];
      int swapPos = i;
      for (int j = i; j < list.length; j++) {
        if (comparator.compare(list[j],currentMin) < 0) {
          currentMin = list[j];
          swapPos = j;
        }
      }
      E temp = list[i];
      list[i] = currentMin;
      list[swapPos] = temp;
    }
  }
}