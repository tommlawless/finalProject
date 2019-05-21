/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

import java.awt.Font;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author tomla
 */
public class FinalProject extends Application {
    
    private Button seeBalance;
    private Button deposit;
    private Button withdrawl; 
    
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
    
    private Button confirmDesposit;
    private Button confirmWithdrawl;
    
    private Button exit;
    
    private Label header; 
    private Label accountBalanceLabel;
    
    Double pinNumber; 
    Double accountBalance;
    Double withdrawlAmount;
    Double depositAmount;
    
    private TextField amountDeposit; 
    private TextField amountWithdrawl;
    
    private Label currentBalanceAmount;
   private ToggleGroup group;
   private VBox numberButtons;
    
    @Override
    public void start(Stage primaryStage) {
        header = new Label ("ATM Application");
        header.setMinWidth(580);
        header.setAlignment(Pos.CENTER);
       //s header.setFont( new Font(28));
        header.setTextFill(Color.web("#683200"));
        
        one = new Button("1");
        two = new Button("2");
        three = new Button("3");
        four = new Button ("4");
        five = new Button ("5");
        six = new Button ("6");
        seven = new Button ("7");
        eight = new Button ("8");
        nine = new Button ("9");
        zero = new Button ("0");
        
        confirmDesposit = new Button("Confirm Deposit");
        confirmWithdrawl = new Button("Confirm Withdawl");
        
        seeBalance = new Button("See Balance");
        deposit = new Button ("Deposit");
        withdrawl = new Button ("Withdrawl");
        
        amountDeposit = new TextField("Deposit Amount");
        amountDeposit.setOnAction( e -> handleClickAction(e));
        
        amountWithdrawl = new TextField("Withdrawl Amount");
        amountDeposit.setOnAction( e -> handleClickAction(e));
        
        accountBalanceLabel = new Label("Account Balance");
        
        
        VBox pinbuttons1 = new VBox(9, one, four, seven);
        pinbuttons1.setPadding(new Insets(3));
        
        VBox pinbuttons2 = new VBox(10,two,  five, eight);
        
        VBox pinbuttons3 = new VBox(10, three, six, nine);
        
        VBox pinbuttons4 = new VBox(10, zero);
        
        VBox functions = new VBox (5, seeBalance, deposit, withdrawl);
        
        VBox confirmButtons = new VBox (confirmDesposit, confirmWithdrawl);
        
        VBox balance = new VBox (accountBalanceLabel);
      
        GridPane grid = new GridPane();
        
        grid.addRow(0, header);
        GridPane.setColumnSpan(header, 4);
        GridPane.setHalignment(header, HPos.CENTER);
        
        grid.addRow(1, pinbuttons1);
        grid.addRow(1, pinbuttons2);
        grid.addRow(1, pinbuttons3);
        grid.addRow(1, functions);
        grid.addRow(1, confirmButtons);
        GridPane.setHalignment(header, HPos.CENTER);
        
        
    
        
      //  VBox numberButton = new VBox(20, one, two, three, four, five, six, seven, eight, nine, zero);
      //  grid.addRow(1, numberButton);
        
      //  numberButton = new VBox(20, one, two, three, four, five, six, seven, eight, nine, zero);
        
        Scene scene = new Scene(grid, 600, 345);
        primaryStage.setTitle("ATM App");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        
            }
    
 
    public static void main(String[] args) {
        launch(args);
    }


    private void handleClickAction(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    }

    
