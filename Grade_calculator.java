package application; 
import javafx.application.Application; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.GridPane; 
import javafx.stage.Stage; 
public class GradeCalculator extends Application { 
@Override
public void start(Stage primaryStage) { 
primaryStage.setTitle("Student Grade Calculator"); 
GridPane grid = new GridPane(); 
grid.setAlignment(Pos.CENTER); 
grid.setHgap(10); 
grid.setVgap(10); 
grid.setPadding(new Insets(25, 25, 25, 25));
// Create an array to store labels and text fields for each subject
Label[] subjectLabels = new Label[6]; 
TextField[] subjectTextFields = new TextField[6]; 
for (int i = 0; i < 6; i++) { 
subjectLabels[i] = new Label("Subject " + (i + 1) + ":"); 
subjectTextFields[i] = new TextField(); 
grid.add(subjectLabels[i], 0, i); 
grid.add(subjectTextFields[i], 1, i); 
} 
Button calculateButton = new Button("Calculate Grade"); 
grid.add(calculateButton, 1, 6); 
Label resultLabel = new Label(); 
grid.add(resultLabel, 1, 7); 
calculateButton.setOnAction(e -> { 
try { 
double[] subjectGrades = new double[6]; 
// Parse grades from text fields
for (int i = 0; i < 6; i++) { 
subjectGrades[i] = 
Double.parseDouble(subjectTextFields[i].getText()); 
} 
double averageGrade = calculateAverage(subjectGrades); 
String letterGrade = calculateLetterGrade(averageGrade); 
resultLabel.setText("Average Grade: " + averageGrade + "\nLetter Grade: "+ 
letterGrade);
} catch (NumberFormatException ex) { 
resultLabel.setText("Please enter valid numeric grades for all subjects."); 
} 
}); 
Scene scene = new Scene(grid, 400, 300); 
primaryStage.setScene(scene); 
primaryStage.show(); 
} 
private double calculateAverage(double[] grades) { 
double sum = 0; 
for (double grade : grades) { 
sum += grade; 
} 
return sum / grades.length; 
} 
private String calculateLetterGrade(double averageGrade) { 
if (averageGrade >= 90) { 
return "A"; 
} else if (averageGrade >= 80) { 
return "B"; 
} else if (averageGrade >= 70) { 
return "C"; 
} else if (averageGrade >= 60) { 
return "D"; 
} else { 
return "F"; 
} 
} 
public static void main(String[] args) { 
launch(args); 
} 
} 