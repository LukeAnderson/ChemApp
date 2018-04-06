package ChemApp;

import java.util.*;
public class Game extends Element
{
    //used to get random ints
    private Random random = new Random();
    
    //to get an arraylist with all the elements
    private final PeriodicTable periodic_table = new PeriodicTable();
    private final ArrayList<Element> elements =  periodic_table.getElements();

    
    
    //if any of these are true then that means we gave them the hint
    private boolean hint_name = false;
    private boolean hint_symbol = false;
    private boolean hint_number = false;
    private boolean hint_weight = false;
    
    public void Game(){
        //pick a random element out of all the elements
        int randomElementIndex = random.nextInt(elements.size());
       
        this.setName(elements.get(randomElementIndex).getName());
        this.setSymbol(elements.get(randomElementIndex).getSymbol());
        this.setNumber(elements.get(randomElementIndex).getNumber());
        this.setWeight(elements.get(randomElementIndex).getWeight());
    }
    
    public String[] getHints(){
        String name = this.getName();
        String symbol = this.getSymbol();
        String number = this.getNumber()+"";
        String weight = this.getWeight()+"";
        
        String[] hintStr = new String[2];
        
        
        int r = random.nextInt(4);
        int previous_hint = r;
       
        if(r == 0){
            hintStr[0] = "The name of the element is " + name;
            hint_name = true;
        }
        if(r == 1){
            hintStr[0] = "The symbol of the element is " + symbol;
            hint_symbol = true;
        }
        if(r == 2){
            hintStr[0] = "The number of the element is " + number;
            hint_number = true;
        }
        if(r == 3){
            hintStr[0] = "The weight of the element is " + weight;  
            hint_weight = true;
        }                
         do{
            r = random.nextInt(4);
        }while(r == previous_hint);
        
        if(r == 0){
            hintStr[1] = "The name of the element is " + name;
            hint_name = true;
        }
        if(r == 1){
            hintStr[1] = "The symbol of the element is " + symbol;
            hint_symbol = true;
        }
        if(r == 2){
            hintStr[1] = "The number of the element is " + number;
            hint_number = true;
        }
        if(r == 3){
            hintStr[1] = "The weight of the element is " + weight;  
            hint_weight = true;
        }                
        
        return hintStr;
    }    
   
    //returns true if correct
    public boolean checkGuess(String guess,String[] hints){
        boolean correct = false;
        if(guess == null || guess.equals("")) return false;
        if(Character.isDigit(guess.charAt(0)))
            guess =(Math.round(Double.parseDouble(guess))+""); 
        
        guess = guess.toUpperCase();
        
        if(guess.equals(this.getName().toUpperCase()))
            correct = !hint_name;
        if(guess.equals(this.getSymbol().toUpperCase()))
            correct = !hint_symbol;
        if(guess.equals(this.getNumber()+""))
            correct = !hint_number;
        if(guess.equals(Math.round(this.getWeight())+""))
            correct = !hint_weight;
        return correct;
    }
}
