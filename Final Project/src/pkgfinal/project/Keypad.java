package pkgfinal.project;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * Class Keypad represents the keypad of the ATM.
 * 
 * @author Prof. Carl B. Struck, JavaFX edit by Andy Osorio/Thomas Lawless/Justin Moran
 * @version 5/10/2018, SCCC Spring 2019
 */
public class Keypad 
{
    // JavaFX Boiler Plate
    private Button submit;
    private Button clear;
    
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    
    private TextField input;
    
    private GridPane pad;
    private BorderPane pane;
    
    
    //return string
    private String results;

    public Keypad(){
    }
    
    /**
     * Returns an integer value entered by the user.
     * 
     * @return an integer value
     */
    public int getInt()
    {
        // initialization and event handlers
        one = new Button("1");
        one.setOnAction((event) ->{
            input.appendText("1");
        });
        two = new Button("2");
        two.setOnAction((event) ->{
            input.appendText("2");
        });
        three = new Button("3");
        three.setOnAction((event) ->{
            input.appendText("3");
        });
        four = new Button ("4");
        four.setOnAction((event) ->{
            input.appendText("4");
        });
        five = new Button ("5");
        five.setOnAction((event) ->{
            input.appendText("5");
        });
        six = new Button ("6");
        six.setOnAction((event) ->{
            input.appendText("6");
        });
        seven = new Button ("7");
        seven.setOnAction((event) ->{
            input.appendText("7");
        });
        eight = new Button ("8");
        eight.setOnAction((event) ->{
            input.appendText("8");
        });
        nine = new Button ("9");
        nine.setOnAction((event) ->{
            input.appendText("9");
        });
        zero = new Button ("0");
        zero.setOnAction((event) ->{
            input.appendText("0");
        });
        
        clear = new Button ("Clear");
        clear.setOnAction((event)->{
            input.setText("");
        });
        
        input = new TextField();
        input.setEditable(false);
        
        
        // layout
        pad = new GridPane();
        pane = new BorderPane();
        // (item, column, row) or (item, x, y)
        pad.add(seven,0,0);
        pad.add(eight,1,0);
        pad.add(nine,2,0);
        
        pad.add(four,0,1);
        pad.add(five,1,1);
        pad.add(six,2,1);
        
        pad.add(one,0,2);
        pad.add(two,1,2);
        pad.add(three,2,2);
        
        pad.add(zero,0,3);
        pad.add(submit,3,0);
        pad.add(input,4,0);
        pad.add(clear,3,1);
        
        pad.setHgap(10);
        pad.setVgap(10);
        
        // place the keypad into the pane
        pane.setCenter(pad);
        
       
        Stage keyPadStage = new Stage();
        Scene keyPadScene = new Scene(pane, 300, 300);
        keyPadStage.setTitle("KeyPad Input");
        keyPadStage.setResizable(false);
        keyPadStage.setScene(keyPadScene);
        
        /**
         * The submit button takes whatever is in the input textfield, sets it as
         * the results variable, then closes the dialog to continue with the program
         */
        submit = new Button ("Submit");
        submit.setOnAction((event)->{
         this.results = input.getText();
         keyPadStage.close();
        });
        
        keyPadStage.showAndWait();
        
        
        return Integer.parseInt(this.results);
    }
    
    /**
     * Returns a double value entered by the user.
     * 
     * @return a double value
     */
    public double getDouble()
    {
        // initialization and event handlers
        one = new Button("1");
        one.setOnAction((event) ->{
            input.appendText("1");
        });
        two = new Button("2");
        two.setOnAction((event) ->{
            input.appendText("2");
        });
        three = new Button("3");
        three.setOnAction((event) ->{
            input.appendText("3");
        });
        four = new Button ("4");
        four.setOnAction((event) ->{
            input.appendText("4");
        });
        five = new Button ("5");
        five.setOnAction((event) ->{
            input.appendText("5");
        });
        six = new Button ("6");
        six.setOnAction((event) ->{
            input.appendText("6");
        });
        seven = new Button ("7");
        seven.setOnAction((event) ->{
            input.appendText("7");
        });
        eight = new Button ("8");
        eight.setOnAction((event) ->{
            input.appendText("8");
        });
        nine = new Button ("9");
        nine.setOnAction((event) ->{
            input.appendText("9");
        });
        zero = new Button ("0");
        zero.setOnAction((event) ->{
            input.appendText("0");
        });
        
        clear = new Button ("Clear");
        clear.setOnAction((event)->{
            input.setText("");
        });
        
        input = new TextField();
        input.setEditable(false);
        
        
        // layout
        pad = new GridPane();
        pane = new BorderPane();
        // (item, column, row) or (item, x, y)
        pad.add(seven,0,0);
        pad.add(eight,1,0);
        pad.add(nine,2,0);
        
        pad.add(four,0,1);
        pad.add(five,1,1);
        pad.add(six,2,1);
        
        pad.add(one,0,2);
        pad.add(two,1,2);
        pad.add(three,2,2);
        
        pad.add(zero,0,3);
        pad.add(submit,3,0);
        pad.add(input,4,0);
        pad.add(clear,3,1);
        
        pad.setHgap(10);
        pad.setVgap(10);
        
        // place the keypad into the pane
        pane.setCenter(pad);
        
       
        Stage keyPadStage = new Stage();
        Scene keyPadScene = new Scene(pane, 300, 300);
        keyPadStage.setTitle("KeyPad Input");
        keyPadStage.setResizable(false);
        keyPadStage.setScene(keyPadScene);
        
        /**
         * The submit button takes whatever is in the input textfield, sets it as
         * the results variable, then closes the dialog to continue with the program
         */
        submit = new Button ("Submit");
        submit.setOnAction((event)->{
         this.results = input.getText();
         keyPadStage.close();
        });
        
        keyPadStage.showAndWait();
        
        
        return Double.parseDouble(this.results);
    }
}
