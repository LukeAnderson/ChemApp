package ChemApp;

import java.io.Serializable;
import java.util.*;
/*
 * puts elements "together" 
 * 
 */
public class Compound implements Serializable{
    
    /*
        A Compound is made up of Elements and subscripts
    
        ie. 
        Compound H2O
        is made up of 
        
        elements    subscripts
         H               2
         O               1    
    */
    
    private ArrayList<Element> elements;
    private ArrayList<Integer> subscripts;
    
    
    public Compound(ArrayList <Element> elements, ArrayList<Integer> subscripts){
       this.elements = elements;
       this.subscripts = subscripts;   
    }
    public Compound(){};
    
    //gets the total atomic weight of the compound
    public double getCompoundWeight(){
       double weight = 0;
        for(int i = elements.size()-1; i!=-1; i--){ 
        weight += elements.get(i).getWeight()*subscripts.get(i);
       }
       return weight;
    }
    
    /*
        to go from grams to moles or moles to grams
        you need atomic weight of the compound then
        either divide or multiply
    */
    public double GramsToMoles(double grams){
       double moles=grams / getCompoundWeight();       
       return moles;
    }
    
    public double MolesToGrams(double moles){
      double grams = getCompoundWeight() * moles ;
      return grams;
    }
    
    public void setElements(ArrayList<Element> elements){
        this.elements = elements;
    }
   public void setSubscripts(ArrayList<Integer> subscripts){
        this.subscripts = subscripts;
    }
   
   public ArrayList<Element> getElements(){
       return elements;
   }
   
   public ArrayList<Integer> getSubscripts(){
       return subscripts;
   }
    

    public String toString(){
      String str = "";
      for(int i = 0; i < elements.size(); i++){ 
          str += elements.get(i).getSymbol();
          if(subscripts.get(i) != 1)
              str += subscripts.get(i);
      }
      return str;
    }
}
