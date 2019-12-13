import java.util.*;
import java.io.*;

class Groceries{
   //ArrayList for Groceries
   private ArrayList<String>groceries = new ArrayList<>();
   private String filename = "Groceries.txt";
   
   //Default Constructor: Shopping list name
   public Groceries(){
      loadShoppingList();
   }
   
   //Overloaded Constructor: Custom shopping list name
   public Groceries(String filename){
      this.filename = filename;
      loadShoppingList();
   }
   
   //Allows the user to add an item to the list
   public void addItem(String item){
      groceries.add(item);
   }
     
   //Allows the user to remove an item from the list
   public void removeItem(String item){
      groceries.remove(item);
   }  
   
   //Loads the shopping list from the file
   public void loadShoppingList(){
       try{
         //Use the Scanner and File to open the file
         File groceriesFile = new File("groceries.txt");
         if(groceriesFile.exists()){
            Scanner fileIn = new Scanner(groceriesFile);
            //Keep reading so long as there are more items in the file
            while(fileIn.hasNext()){
               //Read an English word, then the pirate translation
               groceries.add(fileIn.nextLine());
            }
            fileIn.close();
          }
          else{
            //Creates empty file
            groceriesFile.createNewFile();
          }
      }
      //If the file is not found, display the error message
      catch(FileNotFoundException e){
         System.out.println("Error: " + e.getMessage());
      }
      //If any other error occures, display the message
      catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
   }
   
   //Saves the shopinglist to a file
   public void saveShoppingList(){
      try{
         //Creates a PrintWriter to write to the file
         PrintWriter fileOut = new PrintWriter(new FileWriter(filename));
         //Iterates through the file
         for(String g: groceries){
            //Writes each item to the file
            fileOut.println(g);
         }
         //Closes the file
         fileOut.close();
      }
      catch(IOException e){
         //Prints error message 
         System.out.println("Error: " + e.getMessage());
      }
   }
   
   //Returns a string of the list 
   public String toString(){
      String str = "";
      for(String g: groceries){
        str += g + "\n";
      }
      return str;
   }
  }