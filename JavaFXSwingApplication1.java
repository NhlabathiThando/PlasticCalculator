/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxswingapplication1;    
   import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class JavaFXSwingApplication1 extends Application {

    private TextField display;
    private Label quoteLabel;
    private double firstNumber;
    private String operation;
    private boolean startNewInput = true;
    private final Random random = new Random();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
    private final String[] MEAN_GIRLS_QUOTES = {
            "That's so fetch!",
            "On Wednesdays we wear pink!",
            "The limit does not exist!",
            "You go, Glen Coco!",
            "She doesn't even go here!",
            "Stop trying to make fetch happen!",
            "You can't sit with us!",
            "Get in loser, we're going shopping!",
            "I'm not a regular calculator, I'm a cool calculator.",
            "Boo, you whore!",
            "Is butter a carb?",
            "That's why her hair is so big. It's full of secrets.",
            "Math isn't just for nerds, it's for Plastics too!"
    };

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Plastic Calculator");

        BorderPane root = new BorderPane();
        root.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));

        display = new TextField("0");
        display.setFont(Font.font("Arial", 24));
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setEditable(false);
        display.setStyle("-fx-background-color: white; -fx-border-color: hotpink; -fx-border-width: 3px;");
        display.setPadding(new Insets(10));

        GridPane buttons = createButtons();
        quoteLabel = new Label(getRandomQuote());
        quoteLabel.setFont(Font.font("Arial", 14));
        quoteLabel.setTextFill(Color.WHITE);
        quoteLabel.setStyle("-fx-background-color: hotpink;");
        quoteLabel.setMaxWidth(Double.MAX_VALUE);
        quoteLabel.setAlignment(Pos.CENTER);
        quoteLabel.setPadding(new Insets(10));

        VBox top = new VBox(10, display);
        top.setPadding(new Insets(20, 20, 10, 20));

        root.setTop(top);
        root.setCenter(buttons);
        root.setBottom(quoteLabel);

        Scene scene = new Scene(root, 350, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createButtons() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);

        String[][] layout = {
                {"C", "⌫", "Fetch", "÷"},
                {"7", "8", "9", "×"},
                {"4", "5", "6", "-"},
                {"1", "2", "3", "+"},
                {"Limit", "0", ".", "="}
        };

        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[row].length; col++) {
                String text = layout[row][col];
                Button btn = createButton(text);
                grid.add(btn, col, row);
            }
        }

        return grid;
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setFont(Font.font("Arial", 18));
        button.setStyle("-fx-background-color: deeppink; -fx-text-fill: white;");
        button.setMinSize(60, 60);

        button.setOnAction(e -> handleButtonClick(text));

        return button;
    }

    private void handleButtonClick(String text) {
        switch (text) {
            case "C":
                display.setText("0");
                startNewInput = true;
                break;
            case "⌫":
                String currentText = display.getText();
                if (currentText.length() > 1) {
                    display.setText(currentText.substring(0, currentText.length() - 1));
                } else {
                    display.setText("0");
                    startNewInput = true;
                }
                break;
            case "+":
            case "-":
            case "×":
            case "÷":
                firstNumber = Double.parseDouble(display.getText());
                operation = text;
                startNewInput = true;
                updateQuote();
                break;
            case "=":
                calculateResult();
                break;
            case ".":
                if (!display.getText().contains(".")) {
                    display.setText(display.getText() + ".");
                }
                break;
            case "Fetch":
                fetchAction();
                break;
            case "Limit":
                limitAction();
                break;
            default:
                numberClicked(text);
        }
    }

    private void numberClicked(String number) {
        if (startNewInput || display.getText().equals("0")) {
            display.setText(number);
        } else {
            display.setText(display.getText() + number);
        }
        startNewInput = false;
        updateQuote();
    }

    private void calculateResult() {
        try {
            double secondNumber = Double.parseDouble(display.getText());
            double result = 0;

switch (operation) {
    case "+":
        result = firstNumber + secondNumber;
        break;
    case "-":
        result = firstNumber - secondNumber;
        break;
    case "×":
        result = firstNumber * secondNumber;
        break;
    case "÷":
        if (secondNumber == 0) {
            display.setText("Division by zero? That's not fetch!");
            startNewInput = true;
            return;
        }
        result = firstNumber / secondNumber;
        break;
}

            display.setText((result % 1 == 0) ? String.valueOf((int) result) : String.valueOf(result));
            startNewInput = true;
            quoteLabel.setText("The limit does not exist!");

        } catch (NumberFormatException e) {
            display.setText("Error");
            startNewInput = true;
        }
    }

    private void fetchAction() {
        quoteLabel.setText("Stop trying to make fetch happen!");
        try {
            double value = Double.parseDouble(display.getText());
            value *= 1.5;
            display.setText((value % 1 == 0) ? String.valueOf((int) value) : String.valueOf(value));
            startNewInput = true;
        } catch (NumberFormatException e) {
            display.setText("Error");
            startNewInput = true;
        }
    }

    private void limitAction() {
        quoteLabel.setText("The limit does not exist!");
        try {
            double value = Double.parseDouble(display.getText());
            value = Math.pow(value, 2);
            display.setText((value % 1 == 0) ? String.valueOf((int) value) : String.valueOf(value));
            startNewInput = true;
        } catch (NumberFormatException e) {
            display.setText("Error");
            startNewInput = true;
        }
    }

    private String getRandomQuote() {
        return MEAN_GIRLS_QUOTES[random.nextInt(MEAN_GIRLS_QUOTES.length)];
    }

    private void updateQuote() {
        quoteLabel.setText(getRandomQuote());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
