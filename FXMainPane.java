


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	private Button helloButton;
    private Button howdyButton;
    private Button chineseButton;
    private Button clearButton;
    private Button exitButton;
    private Label feedbackLabel;
    private TextField feedbackTextField;
    
	//  declare two HBoxes
    private HBox buttonBox;
    private HBox labelBox;
	
	//student Task #4:
	//  declare an instance of DataManager
    private DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		helloButton = new Button("Hello");
        howdyButton = new Button("Howdy");
        chineseButton = new Button("Chinese");
        clearButton = new Button("Clear");
        exitButton = new Button("Exit");

        feedbackLabel = new Label("Feedback:");
        feedbackTextField = new TextField();
        
		//  instantiate the HBoxes
        buttonBox = new HBox();
        labelBox = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
        dataManager = new DataManager();
        
        ButtonHandler handler = new ButtonHandler();
		helloButton.setOnAction(handler);
		howdyButton.setOnAction(handler);
		chineseButton.setOnAction(handler);
		clearButton.setOnAction(handler);
		exitButton.setOnAction(handler);
		//  set margins and set alignment of the components
        Insets inset = new Insets(10);
		HBox.setMargin(helloButton, inset);
		HBox.setMargin(howdyButton, inset);
		HBox.setMargin(chineseButton, inset);
		HBox.setMargin(clearButton, inset);
		HBox.setMargin(exitButton, inset);
		HBox.setMargin(feedbackLabel, inset);
		HBox.setMargin(feedbackTextField, inset);

		buttonBox.setAlignment(Pos.CENTER);
		labelBox.setAlignment(Pos.CENTER);
		setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
        labelBox.getChildren().addAll(feedbackLabel, feedbackTextField);
		//  add the buttons to the other HBox
        buttonBox.getChildren().addAll(helloButton, howdyButton, chineseButton, clearButton, exitButton);
		//  add the HBoxes to this FXMainPanel (a VBox)
        getChildren().addAll(buttonBox, labelBox);
	}
	
	//Task #4:
		//  create a private inner class to handle the button clicks
		private class ButtonHandler implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {
				Object target = event.getTarget();
				
				if (target == helloButton) {
					feedbackTextField.setText(dataManager.getHello());
				} else if (target == howdyButton) {
					feedbackTextField.setText(dataManager.getHowdy());
				} else if (target == chineseButton) {
					feedbackTextField.setText(dataManager.getChinese());
				} else if (target == clearButton) {
					feedbackTextField.setText("");
				} else if (target == exitButton) {
					Platform.exit();
					System.exit(0);
				}
			}
		}
}
	
