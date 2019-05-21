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
 * JavaFX Edition for the ATM App worked on in class
 * ATM represents an automated teller machine.
 * 
 * @author Prof. Carl B. Struck, JavaFX edit by Andy Osorio/Thomas Lawless/Justin Moran
 * @version 5/10/2018, SCCC Spring 2019
 */
public class FinalProject extends Application {
    
    // ATM application variables
    private boolean userAuthenticated;
    private int accountNumber;
    
    // Reference to associated ATM simulated objects
    private Screen screen;
    private Keypad keypad;
    private CashDispenser cashDispenser;
    private DepositSlot depositSlot;
    private BankDatabase bankDatabase;
    
    // ATM menu options
    private final static int BALANCE_INQUIRY = 1;
    private final static int WITHDRAWAL = 2;
    private final static int DEPOSIT = 3;
    private final static int EXIT = 4;
    
    // JavaFX Boiler Plate
    private Button submit;
    private Button clear;
    private Button run;
    
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
    
    private Label header; 
    
    private TextArea output;
    private TextField input;
    
    @Override
    public void start(Stage primaryStage) {
        
        // Initialization for ATM variables
        userAuthenticated = false;
        accountNumber = 0;
        
        screen = new Screen();
        cashDispenser = new CashDispenser();
        depositSlot = new DepositSlot();
        bankDatabase = new BankDatabase();
        keypad = new Keypad();
        
        // Boilerplate for UI
        header = new Label ("ATM Application");
        header.setStyle("-fx-font-size: 40px;");
        header.setMinWidth(580);
        header.setAlignment(Pos.CENTER);
        header.setTextFill(Color.web("#683200"));
        
        run = new Button("Run");
        run.setOnAction((event) ->{
           runATM(); 
        });
        
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
        
        submit = new Button ("Submit");
        clear = new Button ("Clear");
        clear.setOnAction((event)->{
            input.setText("");
        });
        
        output = new TextArea("/// ATM SCREEN ///\n");
        output.setStyle("-fx-font-size: 8pt;");
        output.setEditable(false);
        input = new TextField();
        input.setEditable(false);
      
        GridPane Keypad = new GridPane();
        // (item, column, row) or (item, x, y)
        Keypad.add(seven,0,0);
        Keypad.add(eight,1,0);
        Keypad.add(nine,2,0);
        
        Keypad.add(four,0,1);
        Keypad.add(five,1,1);
        Keypad.add(six,2,1);
        
        Keypad.add(one,0,2);
        Keypad.add(two,1,2);
        Keypad.add(three,2,2);
        
        Keypad.add(zero,0,3);
        Keypad.add(submit,3,0);
        Keypad.add(input,4,0);
        Keypad.add(clear,3,1);
        Keypad.add(run, 3, 2);
        
        Keypad.setHgap(10);
        Keypad.setVgap(10);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(header);
        borderPane.setCenter(output);
        borderPane.setBottom(Keypad);
        BorderPane.setAlignment(Keypad, Pos.CENTER);
        BorderPane.setMargin(output, new Insets(20));
        BorderPane.setMargin(Keypad, new Insets(20));
    
        
        Scene scene = new Scene(borderPane, 600, 345);
        primaryStage.setTitle("ATM App");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
 
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Starts the ATM running.  Welcomes and authenticates the user and then 
     * performs transactions.  When the user is finished, resets authentication
     * and the account number so another user may login, and says "Goodbye" to 
     * the current user.
     */
    public void runATM()
    {
        while (true)
        {
            while (! userAuthenticated)
            {
                output.appendText(screen.displayMessageLine("\nWelcome"));
                authenticateUser();
            }
            
            performTransactions();
            
            userAuthenticated = false;
            accountNumber = 0;
        
            output.appendText(screen.displayMessageLine("\nThank you!  Goodbye!!!\n\n\n\n\n"));
        }
    }
    
    /**
     * Attempts to authenticate user against database.
     */
    private void authenticateUser()
    {
        output.appendText(screen.displayMessage("\nPlease enter your account number ==> "));
        int accNum = keypad.getInt();
        output.appendText(screen.displayMessage("\nEnter your pin ==> "));
        int pin = keypad.getInt();
        
        userAuthenticated = bankDatabase.authenticateUser(accNum, pin);
        
        if (userAuthenticated)
        {
            this.accountNumber = accNum;
        }
        else
        {
            output.appendText(screen.displayMessageLine("\nInvalid account number or PIN.  Please try again."));
        }
    }
    
    /**
     * Displays the main menu and performs transactions.  The "Main Menu" loop
     * instantiates a new transaction object and executes that transaction if 
     * the selects "Balance inquiry" or "Withdrawal" or "Deposit" from the menu.
     * If the user selects "Exit" the main menu loop ends.  Any other value 
     * entered for the main menu results in an error message and the loop repeats.
     */
    private void performTransactions()
    {
        Transaction transaction = null;
        
        boolean userExited = false;
        
        while (! userExited)
        {
            int mainMenuSelection = displayMainMenu();
            
            switch (mainMenuSelection)
            {
                case BALANCE_INQUIRY:
                case WITHDRAWAL:
                case DEPOSIT:
                    transaction = createTransaction(mainMenuSelection);
                    transaction.execute();
                    break;
                    
                case EXIT:
                    output.appendText(screen.displayMessageLine("\nExiting the system..."));
                    userExited = true;
                    break;
                    
                default:
                    output.appendText(screen.displayMessageLine("\nInvalid entry - try again."));
                    break;
            }
        }
    }
    
    /**
     * Displays the main menu and returns an input selection.
     * 
     * @return the input selection
     */
    private int displayMainMenu()
    {
        output.appendText(screen.displayMessageLine("\nMain Menu:"));
        output.appendText(screen.displayMessageLine("1 - View my balance"));
        output.appendText(screen.displayMessageLine("2 - Withdraw cash"));
        output.appendText(screen.displayMessageLine("3 - Deposit funds"));
        output.appendText(screen.displayMessageLine("4 - Exit"));
        output.appendText(screen.displayMessage("\nEnter a choice: "));
        
        return keypad.getInt();
    }
     
    /**
     * Returns an object of specified Transaction type.  The type is either
     * BalanceInquiry or Withdrawal or Deposit based upon the type parameter.
     * 
     * @param type an integer selected from the "Transactions" main menu options
     * @return the newly created Transaction object
     */
    private Transaction createTransaction(int type)
    {
        Transaction transaction = null;
        
        switch(type)
        {
            case BALANCE_INQUIRY:
                transaction = new BalanceInquiry(accountNumber, screen, bankDatabase);
                break;
            case WITHDRAWAL:
                transaction = new Withdrawal(accountNumber, screen, bankDatabase,
                                             keypad, cashDispenser);
                break;  
            case DEPOSIT:
                transaction = new Deposit(accountNumber, screen, bankDatabase,
                                          keypad, depositSlot);
                break;
        }
        
        return transaction;
    }  
    }

    
