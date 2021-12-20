/*
Kevin Martinsen
CSCI 1116 - Algorithms and Data Structures
12/20/2021

Exercise 22_1 - Maximum consecutive increasingly ordered substring
 */
import java.util.Scanner;

public class Exercise22_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Find the longest consecutive increasingly ordered substring.");
        System.out.print("Enter a string: ");
        String string = input.nextLine();

        System.out.println(findMaxSubstring(string));

    }

    public static String findMaxSubstring(String string) {
        int maxPos = 0;
        int maxLength = 1;
        int count = 1;
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i - 1) < string.charAt(i)) {
                count++;
            }
            else {
                if (count > maxLength) {
                    maxLength = count;
                    maxPos = i - count;
                    count = 1;
                }
            }
        }
        return string.substring(maxPos, maxPos + maxLength);
    }
}
