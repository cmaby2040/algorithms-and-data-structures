/*  CSI2114 Lab 3 - lab3.java
 *  
 *  Class to check balanced brackets in math expressions  
 *
 *  Usage: java bracketsBalance <exp>
 *  
 *  by Jeff Souza
 *
 */
import java.util.*;

class bracketsBalance {

    private boolean bBalance (String exp){ 
     /* int sum1=0;
      int sum2=0;
      int sum3=0;
      */
      Boolean error = true;
      ArrayStack array = new ArrayStack();
      Character roundBracket = new Character('(');
      Character squigilyBracket = new Character('{');
      Character squareBracket = new Character('[');
      for(int i = 0; i<exp.length(); i++){
        Character c = exp.charAt(i);
        if ( (c =='(' || c == ')' || c== '{' || c== '}' || c== '[' ||  c==']')){
          if (c=='(' ||c== '{' || c== '['){
            array.push(c);
          }else{
            Character temp = new Character(((Character)array.pop()));
            System.out.println(array.top());
              if ((temp.compareTo(roundBracket)==0) && (c==')')){
              } 
              else if((temp.compareTo(squigilyBracket)==0) && (c=='}')){
              }else if ((temp.compareTo(squareBracket)==0) && (c==']')){
              }else{
                error = false;
                
              }
          }
        }
      }
      return error;
    }     

    public static void main(String[] args) {

        bracketsBalance b = new bracketsBalance();
        boolean result = b.bBalance("{[()]}");
   
        if (result) System.out.println("The expression is balanced."); 
        else        System.out.println("The expression is NOT balanced."); 
    }
}