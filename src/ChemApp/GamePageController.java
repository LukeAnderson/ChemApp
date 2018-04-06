/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChemApp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Luke
 */
public class GamePageController extends Pages implements Initializable {
    @FXML 
    private Button guess_button;
      
    @FXML
    private TextField guess_field;
    
    @FXML
    private Label hint1; 
    
    @FXML
    private Label hint2;
    
    @FXML
    private Label win;
    
    private Game game;
    private String[] hints;
    
    
    
    
       @Override
    public void initialize(URL url, ResourceBundle rb) {
        setGame();
    }    
    
     private void setGame() {
        game = new Game();
        game.Game();
        guess_button.setText("Guess");
        hints = game.getHints();
        hint1.setText("Give another fact about this element\n" + hints[0]);
        clear_input();
    }
    
    @FXML
    private void play(ActionEvent event){
        String guess = guess_field.getText();
        if(win.getText() != null){
             setGame();  
             return;
        }     
        else if(game.checkGuess(guess,hints) == true){
           win.setText("Correct!\n"+game);
           guess_button.setText("Play Again");
        }
        else if(hint1.getText() != null && hint2.getText() != null){
             win.setText("Incorrect! Better luck next time.\n"+game);
             guess_button.setText("Play Again");
             return;
        }
        else{
            hint2.setText("Incorrect! here's another hint.\nCan you give another fact?\n"+hints[1]);
        }
    }

    @Override
     void clear_input() {
       hint2.setText(null);
       win.setText(null);
    }
    
}
