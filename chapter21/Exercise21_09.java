/*
Kevin Martinsen
CSCI 1116 - Algorithms and Data Structures
12/16/2021

Exercise 21_09 - Rewrite Exercise 08_37 to use a map instead
 */
import java.util.HashMap;
import java.util.Scanner;

public class Exercise21_09 {
  static int correctCount = 0;

  public static void main(String[] args) {
    String[][] stateCapital = {
      {"Alabama", "Montgomery"},
      {"Alaska", "Juneau"},
      {"Arizona", "Phoenix"},
      {"Arkansas", "Little Rock"},
      {"California", "Sacramento"},
      {"Colorado", "Denver"},
      {"Connecticut", "Hartford"},
      {"Delaware", "Dover"},
      {"Florida", "Tallahassee"},
      {"Georgia", "Atlanta"},
      {"Hawaii", "Honolulu"},
      {"Idaho", "Boise"},
      {"Illinois", "Springfield"},
      {"Indiana", "Indianapolis"},
      {"Iowa", "Des Moines"},
      {"Kansas", "Topeka"},
      {"Kentucky", "Frankfort"},
      {"Louisiana", "Baton Rouge"},
      {"Maine", "Augusta"},
      {"Maryland", "Annapolis"},
      {"Massachusettes", "Boston"},
      {"Michigan", "Lansing"},
      {"Minnesota", "Saint Paul"},
      {"Mississippi", "Jackson"},
      {"Missouri", "Jefferson City"},
      {"Montana", "Helena"},
      {"Nebraska", "Lincoln"},
      {"Nevada", "Carson City"},
      {"New Hampshire", "Concord"},
      {"New Jersey", "Trenton"},
      {"New York", "Albany"},
      {"New Mexico", "Santa Fe"},
      {"North Carolina", "Raleigh"},
      {"North Dakota", "Bismarck"},
      {"Ohio", "Columbus"},
      {"Oklahoma", "Oklahoma City"},
      {"Oregon", "Salem"},
      {"Pennsylvania", "Harrisburg"},
      {"Rhode Island", "Providence"},
      {"South Carolina", "Columbia"},
      {"South Dakota", "Pierre"},
      {"Tennessee", "Nashville"},
      {"Texas", "Austin"},
      {"Utah", "Salt Lake City"},
      {"Vermont", "Montpelier"},
      {"Virginia", "Richmond"},
      {"Washington", "Olympia"},
      {"West Virginia", "Charleston"},
      {"Wisconsin", "Madison"},
      {"Wyoming", "Cheyenne"}
    };

    HashMap<String, String> stateMap = new HashMap<>(stateCapital.length);
    for (String[] pair: stateCapital) {
      stateMap.put(pair[0], pair[1]);
    }

    Scanner input = new Scanner(System.in);
    
    //int correctCount = 0;


    stateMap.forEach((state, capital) -> {
      // Prompt the user with a question
      System.out.print("What is the capital of " + state + "? ");
      String guess = input.nextLine().trim().toLowerCase();

      if (guess.equals(capital.toLowerCase())) {
        System.out.println("Your answer is correct");
        correctCount++;
      }
      else
        System.out.println("The correct answer should be " + capital);
    });

    System.out.println("The correct count is " + correctCount);
  }
}
