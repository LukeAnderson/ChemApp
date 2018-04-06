package ChemApp;

import java.io.Serializable;

/*
* Makes a element obj. 
    elements have 4 variables 
    name,symbol,number, and weight
*/
public class Element implements Serializable{
   private String name;
   private String symbol;
   private int number;
   private double weight;   
 
   public Element(String name, String symbol, int number, double weight){
     this.name = name;
     this.symbol = symbol;
     this.number = number;
     this.weight = weight;
   }
   
   public Element(){}
   
   public void setName(String name){
       this.name = name;
   }   
   
   public void setSymbol(String symbol){
       this.symbol = symbol;
   }
   
   public void setNumber(int number){
       this.number = number;
   }
   
   public void setWeight(double weight){
       this.weight = weight;
   }
   

   public String getName(){ 
     return name;  
   }     

   public String getSymbol(){
     return symbol;
   }
   
   public int getNumber(){
     return number;
   }
   
   public double getWeight(){
     return weight;
   }
   
   @Override
   public String toString(){
     String str ="Name: " + name + "\nSymbol: " + symbol + "\nAtomic number: " + number + "\nAtomic weight: " + weight;
     return str;
   } 
}
