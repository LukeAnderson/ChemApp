/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChemApp;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class GramsAndMolesCalculatorPageController extends Pages implements Initializable {
    @FXML 
    private SplitMenuButton GramsAndMolesMenu; 
    
    @FXML
    private TextField symbol;
    
    @FXML
    private TextField subscript;
    
    @FXML
    private TextField GramsAndMoles;
    
    @FXML
    private Label compoundText;
    
    @FXML
    private Label error;
    
    @FXML
    private Label result;
    
    @FXML
    private Label GramsMoles;
    
    @FXML
    private MenuItem one;
    
    @FXML
    private MenuItem two;
    
    @FXML
    private MenuItem three;
    
    @FXML
    private MenuItem four;
    
    @FXML
    private MenuItem five;
    
    
    private  ArrayList<Compound> recentCompounds;  
    private Compound compound = new Compound();
    private final PeriodicTable elements = new PeriodicTable();
    private ArrayList<Element> compoundElements = new ArrayList();
    private ArrayList<Integer> compoundSubscripts = new ArrayList();
   
    //add element to compound
    @FXML 
    private void addElementButton(ActionEvent event) throws IOException{
        if(compound.getElements() != null || compound.getSubscripts()!=null){
        compoundElements = compound.getElements();
        compoundSubscripts = compound.getSubscripts();
        }
        error.setText(null);
        String symbolText = symbol.getText();
        String subscriptText = subscript.getText();
        
             
        if(symbolText == null || subscriptText == null){
            error.setText("You must enter in an element symbol\nand a subscript in their appropriate textfields.");
            return;
        }
          
        Element compoundElement = elements.getElementSymbol(symbolText);
        if(compoundElement == null){
             error.setText(symbolText + " is not a element symbol");
             return;
        }
           
        
        int subscriptNum;
        try{
           subscriptNum = Integer.parseInt(subscriptText);
        }
        catch(NumberFormatException e){
                error.setText("Enter a number into the subscript textfield.");
                return;
        }
        if(subscriptNum < 1){
            error.setText("Enter a positive number into the subscript textfield.");
            return;
        }
        
        //INPUT IS GOOD ADD THEM TO COMPOUND LISTS        
        compoundElements.add(compoundElement);
        compoundSubscripts.add(subscriptNum);
        
        compound.setElements(compoundElements);
        compound.setSubscripts(compoundSubscripts);
      
        compoundText.setText(compound.toString());
        clear_input();
    }
    
    //Are we converting Grams to Moles or Moles to Grams
    @FXML 
    private void menu_selection(ActionEvent event) throws IOException{
        MenuItem selection = (MenuItem)event.getSource();
        GramsAndMolesMenu.setText(selection.getText());    
        if(selection.getText().equals("Grams to Moles"))
            GramsMoles.setText("Grams");
        else
            GramsMoles.setText("Moles");
    }
    
 
    @FXML 
    private void calculate(ActionEvent event) throws IOException{
        SplitMenuButton selection = (SplitMenuButton)event.getSource();
        String selectionText = selection.getText();
        if(selectionText.equals("Calculate . . .")){
            error.setText("Please choose to convert from grams to moles\nor moles to grams");
            return;
        }
        
        double GramsAndMolesNum;
        try{
             GramsAndMolesNum = Double.parseDouble(GramsAndMoles.getText());
        }
        catch(NumberFormatException e){
            error.setText("Please enter in the number of grams or moles.");
            return;
        }
              
        switch (selectionText) {
            case "Grams to Moles":
                try{
                result.setText(compound.GramsToMoles(GramsAndMolesNum)+" Moles");
                }
                catch(NullPointerException e){
                    error.setText("You must add elements first before calculating.");
                }
                break;
            case "Moles to Grams":
                try{
                result.setText(compound.MolesToGrams(GramsAndMolesNum)+" Grams");
                }
                catch(NullPointerException e){
                    error.setText("You must add elements first before calculating.");
                }
                break;
        }
    }
        
    @FXML 
    private void save_button(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException{
        if(compound.getElements() == null) return;
        FileOutputStream fos = new FileOutputStream("JavaChemistryApp.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        ArrayList<Compound> recentlySaved = getSavedCompounds("JavaChemistryApp.ser");
        if(compound.getSubscripts() != null){
            if(recentlySaved == null)
                recentlySaved = new ArrayList<Compound>();
            if(recentlySaved.size() == 5)
                recentlySaved.remove(4);
            recentlySaved.add(0,compound);
            oos.writeObject(recentlySaved);      
            System.out.println("we saved "+compound.toString());
            set_saves();
        }  
    }
    
    
    private void set_saves() throws IOException, FileNotFoundException, ClassNotFoundException{
        getSavedCompounds("JavaChemistryApp.ser");   
        try{
        one.setText(recentCompounds.get(0).toString());
        two.setText(recentCompounds.get(1).toString());
        three.setText(recentCompounds.get(2).toString());
        four.setText(recentCompounds.get(3).toString());
        five.setText(recentCompounds.get(4).toString());
        }
        catch(IndexOutOfBoundsException | NullPointerException e){
            //error.setText("Save file corrupted delete JavaChemistryApp.ser");
            //They haven't saved 5 elements yet
            
        }
        catch(Exception e){
             //error.setText("Save file corrupted delete JavaChemistryApp.ser"); 
        }
        
        
        
        
    }
    
    
    

    
    private ArrayList<Compound> getSavedCompounds(String file) throws FileNotFoundException, IOException, ClassNotFoundException  {
        FileInputStream fis;
        try{
            fis = new FileInputStream(file);
        }
        catch(FileNotFoundException e){
            return null;
        }
        ObjectInputStream ois = new ObjectInputStream(fis);;
        try{
            recentCompounds = (ArrayList<Compound>) ois.readObject();
        }
        catch(ClassNotFoundException e){
            error.setText("Save file couldn't be read from");   
        }
        catch(EOFException e){
            //read till the end of the file
        }
        catch(FileNotFoundException fnf){
            
        }
        if(ois == null)
            return null;
        ois.close();
        return recentCompounds;
    }
    
    @FXML 
    private void loadCompound(ActionEvent event){
        MenuItem selection = (MenuItem)event.getSource();
        try{
        switch (selection.getId()) {
            case "one":
                compound = recentCompounds.get(0);
                break;
            case "two":
                compound = recentCompounds.get(1);
                break;
            case "three":
                compound = recentCompounds.get(2);
                break;
            case "four":
                compound = recentCompounds.get(3);
                break;
            case "five":
                compound = recentCompounds.get(4);
                break;
            }
        compoundText.setText(compound.toString());
        }
        catch(NullPointerException | IndexOutOfBoundsException e){}
    }
    
    @FXML
    private void clear_compound(ActionEvent event){
        compound.setElements(null);
        compound.setSubscripts(null);
        compoundElements = null;
        compoundElements = new ArrayList();
        compoundSubscripts = null;
        compoundSubscripts = new ArrayList();
        compoundText.setText("");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clear_input();
        try {
            set_saves();
        } catch (IOException | ClassNotFoundException ex ) {
            Logger.getLogger(GramsAndMolesCalculatorPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    @Override
    void clear_input() {
        symbol.setText(null);
        subscript.setText(null);
    }
}