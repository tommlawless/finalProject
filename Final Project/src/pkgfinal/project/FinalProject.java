package pkgfinal.project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Simplified JavaFX Edition for the ATM App worked on in class
 * ATM represents an automated teller machine.
 * 
 * @author Prof. Carl B. Struck, JavaFX edit by Andy Osorio/Thomas Lawless/Justin Moran
 * @version 5/10/2018, FX version SCCC Spring 2019
 */
public class FinalProject extends Application {
    
    // ATM bank database
    private final BankDatabase bankDatabase = new BankDatabase();
    
    // JavaFX Boiler Plate
    private Button clearPIN;
    private Button clearACC;
    
    private Button oneP;
    private Button twoP;
    private Button threeP;
    private Button fourP;
    private Button fiveP;
    private Button sixP;
    private Button sevenP;
    private Button eightP;
    private Button nineP;
    private Button zeroP;
    
    private Button oneA;
    private Button twoA;
    private Button threeA;
    private Button fourA;
    private Button fiveA;
    private Button sixA;
    private Button sevenA;
    private Button eightA;
    private Button nineA;
    private Button zeroA;
    
    private Button viewBTN;
    private Button depositBTN;
    private Button withdrawlBTN;
    
    private Label header;
    private Label lblACC;
    private Label lblPIN;
    
    private TextArea output;
    private TextField inputACC;
    private TextField inputPIN;
    private TextField inputWithdrawl;
    private TextField inputDeposit;
    
    @Override
    public void start(Stage primaryStage) {
        
        // Boilerplate for UI
        
        // Labels
        header = new Label ("ATM Application");
        header.setStyle("-fx-font-size: 40px;");
        header.setMinWidth(580);
        header.setAlignment(Pos.CENTER);
        header.setTextFill(Color.web("#683200"));
        
        lblPIN = new Label ("PIN NUMBER");
        lblACC = new Label ("ACCOUNT NUM.");
        
        // Input Fields
        inputACC = new TextField("");
        inputACC.setEditable(false);
        inputPIN = new TextField("");
        inputPIN.setEditable(false);
        
        // Transaction inputs
        inputWithdrawl = new TextField("");
        inputDeposit = new TextField("");
        
        // PIN PAD BUTTONS
        oneP = new Button("1");
        oneP.setOnAction((event) ->{
            inputPIN.appendText("1");
        });
        twoP = new Button("2");
        twoP.setOnAction((event) ->{
            inputPIN.appendText("2");
        });
        threeP = new Button("3");
        threeP.setOnAction((event) ->{
            inputPIN.appendText("3");
        });
        fourP = new Button ("4");
        fourP.setOnAction((event) ->{
            inputPIN.appendText("4");
        });
        fiveP = new Button ("5");
        fiveP.setOnAction((event) ->{
            inputPIN.appendText("5");
        });
        sixP = new Button ("6");
        sixP.setOnAction((event) ->{
            inputPIN.appendText("6");
        });
        sevenP = new Button ("7");
        sevenP.setOnAction((event) ->{
            inputPIN.appendText("7");
        });
        eightP = new Button ("8");
        eightP.setOnAction((event) ->{
            inputPIN.appendText("8");
        });
        nineP = new Button ("9");
        nineP.setOnAction((event) ->{
            inputPIN.appendText("9");
        });
        zeroP = new Button ("0");
        zeroP.setOnAction((event) ->{
            inputPIN.appendText("0");
        });
        
        clearPIN = new Button ("Clear");
        clearPIN.setOnAction((event)->{
            inputPIN.setText("");
        });
        
        // ACC PAD BUTTONS
        oneA = new Button("1");
        oneA.setOnAction((event) ->{
            inputACC.appendText("1");
        });
        twoA = new Button("2");
        twoA.setOnAction((event) ->{
            inputACC.appendText("2");
        });
        threeA = new Button("3");
        threeA.setOnAction((event) ->{
            inputACC.appendText("3");
        });
        fourA = new Button ("4");
        fourA.setOnAction((event) ->{
            inputACC.appendText("4");
        });
        fiveA = new Button ("5");
        fiveA.setOnAction((event) ->{
            inputACC.appendText("5");
        });
        sixA = new Button ("6");
        sixA.setOnAction((event) ->{
            inputACC.appendText("6");
        });
        sevenA = new Button ("7");
        sevenA.setOnAction((event) ->{
            inputACC.appendText("7");
        });
        eightA = new Button ("8");
        eightA.setOnAction((event) ->{
            inputACC.appendText("8");
        });
        nineA = new Button ("9");
        nineA.setOnAction((event) ->{
            inputACC.appendText("9");
        });
        zeroA = new Button ("0");
        zeroA.setOnAction((event) ->{
            inputACC.appendText("0");
        });
        
        clearACC = new Button ("Clear");
        clearACC.setOnAction((event)->{
            inputACC.setText("");
        });
        
        // Transaction Buttons
        viewBTN = new Button ("View Balance");
        viewBTN.setOnAction((event)->{
             viewBalance(Integer.parseInt(inputACC.getText()), 
             Integer.parseInt(inputPIN.getText()));    
        });
        depositBTN = new Button ("Deposit ($)");
        depositBTN.setOnAction((event)->{
            deposit(Integer.parseInt(inputACC.getText()), 
                    Integer.parseInt(inputPIN.getText()), 
                    Double.parseDouble(inputDeposit.getText()));
        });
        withdrawlBTN = new Button ("Withdrawl ($)");
        withdrawlBTN.setOnAction((event)->{
            withdrawl(Integer.parseInt(inputACC.getText()), 
                    Integer.parseInt(inputPIN.getText()),
                    Double.parseDouble(inputWithdrawl.getText()));
        });
        
        // Output Screen
        output = new TextArea("////////// ATM SCREEN ////////////\n"
                + "Welcome!\nUse the keypads to enter the Account\nNumber and PIN.\n"
                + "Then use the buttons on the bottom\n"
                + "to issue request a transaction\n"
                + "================================\n");
        output.setStyle("-fx-font-size: 8pt;");
        output.setEditable(false);
      
        GridPane padPIN = new GridPane();
        GridPane padACC = new GridPane();
        GridPane gridPIN = new GridPane();
        GridPane gridACC = new GridPane();
        GridPane padTRAN = new GridPane();
        
        // (item, column, row) or (item, x, y)
        
        // Transaction PAD
        padTRAN.add(inputWithdrawl,0,0);
        padTRAN.add(withdrawlBTN,0,1);
        padTRAN.add(inputDeposit,1,0);
        padTRAN.add(depositBTN,1,1);
        padTRAN.add(viewBTN,2,0);
        
        padTRAN.setHgap(5);
        padTRAN.setVgap(5);
        
        // PIN PAD
        padPIN.add(sevenP,0,0);
        padPIN.add(eightP,1,0);
        padPIN.add(nineP,2,0);
        
        padPIN.add(fourP,0,1);
        padPIN.add(fiveP,1,1);
        padPIN.add(sixP,2,1);
        
        padPIN.add(oneP,0,2);
        padPIN.add(twoP,1,2);
        padPIN.add(threeP,2,2);
        
        padPIN.add(zeroP,0,3);
        padPIN.add(inputPIN,4,0);
        padPIN.add(clearPIN,3,1);
        
        padPIN.setHgap(5);
        padPIN.setVgap(5);
        
        gridPIN.add(lblPIN,0,0);
        gridPIN.add(inputPIN,0,1);
        gridPIN.add(padPIN, 0, 2);
        
        // ACC PAD
        padACC.add(sevenA,0,0);
        padACC.add(eightA,1,0);
        padACC.add(nineA,2,0);
        
        padACC.add(fourA,0,1);
        padACC.add(fiveA,1,1);
        padACC.add(sixA,2,1);
        
        padACC.add(oneA,0,2);
        padACC.add(twoA,1,2);
        padACC.add(threeA,2,2);
        
        padACC.add(zeroA,0,3);
        padACC.add(inputACC,4,0);
        padACC.add(clearACC,3,1);
        
        padACC.setHgap(5);
        padACC.setVgap(5);
        
        gridACC.add(lblACC,0,0);
        gridACC.add(inputACC,0,1);
        gridACC.add(padACC, 0, 2);
        
        // LAYOUT
        BorderPane bp = new BorderPane();
        bp.setTop(header);
        bp.setCenter(output);
        bp.setLeft(gridPIN);
        bp.setRight(gridACC);
        bp.setBottom(padTRAN);
        BorderPane.setMargin(output, new Insets(10));
        BorderPane.setMargin(gridPIN, new Insets(5));
        BorderPane.setMargin(gridACC, new Insets(5));
        BorderPane.setMargin(padTRAN, new Insets(40));
        
    
        
        Scene scene = new Scene(bp, 600, 400);
        primaryStage.setTitle("ATM App");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
 
    public static void main(String[] args) {
        launch(args);
    }
    
    private void viewBalance(int accnum, int pin){
        if(bankDatabase.authenticateUser(accnum, pin)){
            output.appendText("Account Validated!\n");
            output.appendText("Account Balance: $" + String.format("%.2f",
                    bankDatabase.getTotalBalance(accnum)) + "\n\n");
        }else{
            output.appendText("Error! Either PIN or Account Number is invalid!\n\n");
        }
    }
    private void deposit(int accnum, int pin, double amount){
        if(bankDatabase.authenticateUser(accnum, pin)){
            output.appendText("Account Validated!\n");
            bankDatabase.credit(accnum, amount);
            output.appendText("New Account Balance: $" + String.format("%.2f",
                    bankDatabase.getTotalBalance(accnum)) + "\n\n");
        }else{
            output.appendText("Error! Either PIN or Account Number is invalid!\n\n");
        }
    }
    private void withdrawl(int accnum, int pin, double amount){
        if(bankDatabase.authenticateUser(accnum, pin)){
            output.appendText("Account Validated!\n");
            bankDatabase.debit(accnum, amount);
            output.appendText("New Account Balance: $" + String.format("%02f",
                    bankDatabase.getTotalBalance(accnum) + "\n\n"));
        }else{
            output.appendText("Error! Either PIN or Account Number is invalid!\n\n");
        }
    }
}

    
