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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Luke
 */
public class ElementSearchPageController extends Pages implements Initializable {
    private static final PeriodicTable elements = new PeriodicTable();
    
    @FXML 
    private SplitMenuButton search_menu; 
    
    @FXML
    private TextField query;
    
    @FXML
    private Label result;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //Nothing to do
    }     
    
    
    
    @FXML 
    private void menu_selection(ActionEvent event) throws IOException{
        MenuItem selection = (MenuItem)event.getSource();
        search_menu.setText(selection.getText());    
    }
    
    @FXML
    private void search(ActionEvent event){
        SplitMenuButton selection = (SplitMenuButton)event.getSource();
        String search_by_this = selection.getText();
        String search_for_this = query.getText();
        if(search_by_this.equals("Name"))
            name_search(search_for_this);
        else if(search_by_this.equals("Atomic Number"))
            atomic_number_search(search_for_this);
        else if(search_by_this.equals("Symbol"))
            symbol_search(search_for_this);
        else if(search_by_this.equals("Atomic Weight"))
            atomic_weight_search(search_for_this);

    }

    private void name_search(String name) {
        name = name.toUpperCase();
        if(elements.getElementName(name) != null)
            result.setText("\n"+elements.getElementName(name)+"\n");
        else
           result.setText("There is no such element: " + name);
    }

    private void atomic_number_search(String search_for_this) {
       int number;
        try{
            number = Integer.parseInt(search_for_this);
        }
        catch(NumberFormatException e){
                result.setText("Please enter in an atomic number!");
                return;
        }
        if(elements.getElementNum(number) != null)
            result.setText("\n"+elements.getElementNum(number)+"\n");
        else
           result.setText("There is no such element that has atomic number: " + search_for_this);
    }

    private void symbol_search(String symbol) {
        symbol = symbol.toUpperCase();
        if(elements.getElementSymbol(symbol) != null)
            result.setText("\n"+elements.getElementSymbol(symbol)+"\n");
        else
           result.setText("There is no such element with symbol: " + symbol);
    }

    private void atomic_weight_search(String weightStr) {
        double weight;
        try{
            weight = Double.parseDouble(weightStr);
        }
        catch(NumberFormatException e){
                result.setText("Please enter in an atomic weight!");
                return;
        }
        weight = Math.round(weight);
        if(elements.getElementWeight(weight) != null)
            result.setText("\n"+elements.getElementWeight(weight)+"\n");
        else
           result.setText("There is no such element that has atomic weight of: " + weight);
    }

    @Override
    void clear_input() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
        
}
    
    
    
    
    
    