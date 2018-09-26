/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedjava;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author akila
 */
public class AdvancedJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner user_input = new Scanner( System.in );        
        AdvancedJava obj = new AdvancedJava();  
        int selection;
        System.out.println("Please Enter a number\n 1. Comapre Strings\n 2. Count Words\n"
                + "3. calculate sum of  digits\n 4. Read a file\n 5. Sarch Item in arrayList\n"
                + "6. Sort ArrayList ");
        selection = user_input.nextInt();
        switch(selection){
            case 1 : 
                 obj.compareStrringslexicographically();
                 break;
            case 2:
                obj.countWords();
                break;
            case 3:
                obj.calculateSumOfDigits();
                break;
            case 4:
                obj.readFileLineByLine();
                break;
            case 5:
                obj.searchInArrayList();
                break;
            case 6:
                 ArrayList<String> itemList = new ArrayList<String>();
                 int listLength;
                 String item, searchItem;
                 System.out.println("Please enter length of arrayList ");
                 listLength = user_input.nextInt();
                 System.out.println("Please enter the items of arrayList ");
                 for(int i=0; i < listLength; i++){
                     item = user_input.next( );
                     itemList.add(item);
                 }
                 obj.sortArrayList(itemList);
        }

        // TODO code application logic here
        
           
       
    }
    
    public void compareStrringslexicographically(){
        Scanner user_input = new Scanner( System.in );
        String a,b;
        System.out.print("Enter the first string: ");
        a = user_input.next( );
        System.out.print("Enter the second string: ");
        b = user_input.next();
           int result = a.compareTo(b);

        // Display the results of the comparison.
        if (result < 0)
        {
            System.out.println("\"" + a + "\"" +
                " is less than " +
                "\"" + b + "\"");
        }
        else if (result == 0)
        {
            System.out.println("\"" + a + "\"" +
                " is equal to " +
                "\"" + b + "\"");
        }
        else // if (result > 0)
        {
            System.out.println("\"" + a + "\"" +
                " is greater than " +
                "\"" + b + "\"");
        }
        
    }
    public void countWords(){
        String a;
        Scanner user_input = new Scanner( System.in );
        System.out.print("Enter a string: ");
         a = user_input.nextLine();
         if (a.isEmpty()){
             System.out.println("String is empty");
    
         } else {
                String[] words = a.split("\\s+");

              System.out.println(words.length + " words in the string");
         }
        
    }
    public void calculateSumOfDigits(){
        int number;
        Scanner user_input = new Scanner( System.in );   
         System.out.print("Enter a Number ");
        number = user_input.nextInt();
        String no = Integer.toString(number);
        int sum = 0;
        
        for(int i=0; i < no.length(); i++){
            sum = sum + Character.getNumericValue(no.charAt(i));
        }
        System.out.print("Sum of Digits: "+ sum);
          
    }
    public void readFileLineByLine(){
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"/Users/akila/Documents/NetBeansProjects/advancedJava/onlyTest.txt"));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public void searchInArrayList(){
        Scanner user_input = new Scanner( System.in );
        ArrayList<String> itemList = new ArrayList<String>();
        int listLength;
        String item, searchItem;
        System.out.println("Please enter length of arrayList ");
        listLength = user_input.nextInt();
        System.out.println("Please enter the items of arrayList ");
        for(int i=0; i < listLength; i++){
            item = user_input.next( );
            itemList.add(item);
        }
        System.out.println("Please enter the item to search ");
        searchItem = user_input.next( );
        boolean Found = itemList.contains(searchItem);
        System.out.println("ArrayList contains " +searchItem+" ? : " + Found);
        
        
    }
    public void sortArrayList(ArrayList<String> items){
           Collections.sort(items);
	   System.out.println("After Sorting:");
	   for(String counter: items){
			System.out.println(counter);
		}
        
    }
     
}


