package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class EditorController {

	 @FXML
	    private Button button2;

	    @FXML
	    private TextArea mainTextArea;

	    @FXML
	    private Label wordsCountLabel;

	    @FXML
	    private Button clearButton;

	    @FXML
	    private MenuItem smallMenuItem;

	    @FXML
	    private Label lettersCountLabel;

	    @FXML
	    private MenuItem closeMenuItem;

	    @FXML
	    private MenuItem bigMenuItem;
    
    
    
    

    @FXML
    void initialize() {
        assert mainTextArea != null : "fx:id=\"mainTextArea\" was not injected: check your FXML file 'Editor.fxml'.";
        assert wordsCountLabel != null : "fx:id=\"wordsCountLabel\" was not injected: check your FXML file 'Editor.fxml'.";
        assert lettersCountLabel != null : "fx:id=\"lettersCountLabel\" was not injected: check your FXML file 'Editor.fxml'.";
        
        final String lettersCount = "Ilo�� znak�w: ";
        final String wordsCount = "Ilo�� s��w: ";

        //domy�lne etykiety ustawione na 0
        lettersCountLabel.setText(lettersCount + 0);
        wordsCountLabel.setText(wordsCount + 0);

        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                //kod obs�ugi zdarzenia
                mainTextArea.setText("");

                //po wci�ni�ciu przycisku zmieniamy tekst etykiet na domy�lny
                lettersCountLabel.setText(lettersCount + 0);
                wordsCountLabel.setText(wordsCount + 0);
            }
        });

        mainTextArea.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //licznik znak�w z pomini�ciem spacji
                int letters = mainTextArea.getText().trim().length();
                lettersCountLabel.setText(lettersCount + letters);

                //licznik s��w
                int words = mainTextArea.getText().split(" ").length;
                wordsCountLabel.setText(wordsCount + words);
            }
        });
        
        closeMenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				 //zamkni�cie aplikacji
                Platform.exit();
			}
		});
        
        bigMenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				 mainTextArea.setText( mainTextArea.getText().toUpperCase());
				
			}
		});
        
        smallMenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				 mainTextArea.setText( mainTextArea.getText().toLowerCase());
				
			}
		});
        
       
    }
    
    void myMethod(){
    	
    	button2.setText("Hallo, hallo!!!");
    	
    }
}
