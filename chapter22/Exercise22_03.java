import java.util.Scanner;

/*
Kevin Martinsen
CSCI 1116 - Algorithms and Data Structures
12/20/2021

Exercise 22_3 - Find a substring in O(n) time.
 */
public class Exercise22_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Test if the second string is a substring of the first.");
        System.out.print("Enter a string s1: ");
        String s1 = input.nextLine();
        System.out.print("Enter a string s2: ");
        String s2 = input.nextLine();

        int index = findSubString(s1,s2);
        if (index != -1) {
            System.out.println("Substring found at index: " + index);
        }
        else System.out.println("Substring not found.");

    }

    // Returns the index in the full string if there is a substring and -1 if it is not found
    public static int findSubString(String full, String subString) {
        int count = 0;
        for (int i = 0; i < full.length(); i++) {
            if (full.charAt(i) == subString.charAt(count)) {
                count++;
                if (count == subString.length()) {
                    return i - (count - 1);
                }
            }
            else count = 0;
        }
        return -1;
    }
}
