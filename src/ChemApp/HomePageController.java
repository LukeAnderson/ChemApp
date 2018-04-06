/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChemApp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Luke
 */
public class HomePageController implements Initializable {

    @FXML 
    private void ToFindElementPage(ActionEvent event) throws IOException{
        toPage(event,"ElementSearchPage.fxml");
    }
    
    @FXML
    private void ToGamePage(ActionEvent event) throws IOException{
        toPage(event,"GamePage.fxml");
    }
    
    @FXML
    private void ToGramsAndMolesCalculatorPage(ActionEvent event) throws IOException{
        toPage(event,"GramsAndMolesCalculatorPage.fxml");
    }
    
    @FXML
    private void ToAboutPage(ActionEvent event) throws IOException{
            toPage(event,"AboutPage.fxml");
    }    
    
    private void toPage(ActionEvent event,String pageFXML) throws IOException{
        Parent element_page_parent = FXMLLoader.load(getClass().getResource(pageFXML));
        Scene scene = new Scene(element_page_parent); 
        Stage app_stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene.getStylesheets().add(Lsa3m4ChemApp.class.getResource("JavaChemApp.css").toExternalForm());
        app_stage.setScene(scene);
        app_stage.show();        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Nothing to do
    }
    
   
    
}
