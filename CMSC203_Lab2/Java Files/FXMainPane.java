


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
	Button helloButton;
	Button howdyButton;
	Button chineseButton;
	Button clearButton;
	Button exitButton;
	Label feedbackLabel;
	TextField textField;
	//  declare two HBoxes
	HBox hbox1;
	HBox hbox2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;
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
		feedbackLabel = new Label("Feedback");
		textField = new TextField();
		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		//  set margins and set alignment of the components
		Insets inset1 = new Insets(250, 0, 25, 0);
		Insets inset2 = new Insets(0);
		//WHY CAN'T I USE HBOX1 AND HBOX2 FOR MARGIN???
		HBox.setMargin(helloButton, new Insets(250, 0, 25, 250));
		HBox.setMargin(howdyButton, inset1);
		HBox.setMargin(chineseButton, inset1);
		HBox.setMargin(clearButton, inset1);
		HBox.setMargin(exitButton, new Insets(250, 250, 25, 0));
		HBox.setMargin(feedbackLabel, inset2);
		HBox.setMargin(textField, inset2);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		//  add onAction
		helloButton.setOnAction(new ButtonHandler());
		howdyButton.setOnAction(new ButtonHandler());
		chineseButton.setOnAction(new ButtonHandler());
		clearButton.setOnAction(new ButtonHandler());
		exitButton.setOnAction(new ButtonHandler());
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hbox1.getChildren().addAll(helloButton, howdyButton,chineseButton, clearButton, exitButton);
		//  add the buttons to the other HBox
		hbox2.getChildren().addAll(feedbackLabel, textField);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hbox1, hbox2);
		
	}
	
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			if(event.getTarget().equals(helloButton)) {
				feedbackLabel.setText(dataManager.getHello());
			}
			else if(event.getTarget().equals(howdyButton)) {
				feedbackLabel.setText(dataManager.getHowdy());
			}
			else if(event.getTarget().equals(chineseButton)) {
				feedbackLabel.setText(dataManager.getChinese());
			}
			else if(event.getTarget().equals(clearButton)) {
				feedbackLabel.setText("");
			}
			else {
				Platform.exit();
				System.exit(0);
			}
		}
		
	}
}
	
