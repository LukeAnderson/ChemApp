/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChemApp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JEditorPane;


public class AboutPageController extends Pages implements Initializable {
    @FXML 
    private WebView browser;
    
    @FXML
    private Label AboutChemApp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WebEngine webEngine = browser.getEngine(); 
        webEngine.load("https://resume.com/share/lukeanderson");
        AboutChemApp.setText("This application is very helpful\n "
                + "for those wanting to study for\n"
                + " chemistry. There is  a way to \n"
                + "search for elements\n"
                + "or play a game\n"
                + "or calculate between moles \n"
                + "and grams.\n\n\n\n"
                + "To the right I've provided \n"
                + "some information about myself \n"
                + "in a resume.");
      
    }    

    @Override
    void clear_input() {
       //no input on this page method not needed
    }
}
