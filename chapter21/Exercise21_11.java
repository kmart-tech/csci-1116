/*
Kevin Martinsen
CSCI 1116 - Algorithms and Data Structures
12/16/2021

Exercise 21_11 - Baby name popularity ranking
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
  private Map<String, Integer>[] mapForBoy = new HashMap[10];
  private Map<String, Integer>[] mapForGirl = new HashMap[10];
  
  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  private Label lblResult = new Label();
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {

    ArrayList<HashMap<String, Integer>> boyYears = new ArrayList<HashMap<String, Integer>>(10);
    ArrayList<HashMap<String, Integer>> girlYears = new ArrayList<HashMap<String, Integer>>(10);

    String websitePrefix = "http://liveexample.pearsoncmg.com/data/babynamesranking"; // append .txt after the year


    GridPane gridPane = new GridPane();
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(lblResult);
    BorderPane.setAlignment(lblResult, Pos.CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 370, 160);
    primaryStage.setTitle("Exercise21_11"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    for (int year = 2001; year <= 2010; year++) {
      cboYear.getItems().add(year);

      //get the data from the website
      try{
        URL url = new URL(websitePrefix + year + ".txt");
        Scanner input = new Scanner(url.openStream());
        HashMap<String, Integer> boyRankings = new HashMap<>();
        HashMap<String, Integer> girlRankings = new HashMap<>();

        while (input.hasNext()) {
          String[] lineArray = input.nextLine().split("\\s+");
          int ranking = Integer.parseInt(lineArray[0]);
          boyRankings.put(lineArray[1], ranking);
          girlRankings.put(lineArray[3], ranking);
        }

        boyYears.add(boyRankings);
        girlYears.add(girlRankings);
      }
      catch (MalformedURLException ex) {
        System.out.println("Website not found.");
      }
      catch (IOException ex) {
        System.out.println("IO error: no file found at website url.");
      }
    }

    cboYear.setValue(2001);
        
    cboGender.getItems().addAll("Male", "Female");
    cboGender.setValue("Male");

    btFindRanking.setOnAction(event -> {
      if(!tfName.getText().equals("")) {
        Integer ranking = null;
        if (cboGender.getValue().equals("Male")) {
          ranking = boyYears.get(cboYear.getValue() - 2001).get(tfName.getText());
        }
        else if (cboGender.getValue().equals("Female")) {
          ranking = girlYears.get(cboYear.getValue() - 2001).get(tfName.getText());
        }

        if (ranking == null) {
          lblResult.setText("No ranking for that name.");
        }
        else {
          lblResult.setText(ranking.toString());
        }
      }
    });
    
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
