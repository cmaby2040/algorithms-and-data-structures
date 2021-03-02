/*** 
 * This is class implements a trie that holds a set of strings.
 * MyTrie stores stores nodes using class TreeNode
 * 
 * Name: Christopher Maby 
 * Student Number: 8241271
 * Uottawa Email: Cmaby076@uottawa.ca
 * 
 *
 */
import java.util.*;

public class MyTrie {
 
 private TreeNode root = null;
 private int numNodes;

    // Constructor. Note that an empty trie (no strings added) contains the root node 
 public MyTrie() {
  root = new TreeNode(null,null, null,false); 
  numNodes=1;
 }

 // Method to be implemented by you. See handout part 1A
 public boolean insert(String s) {//done
   boolean insert= false;
   if(s=="" || s == null){
     return false;
   }else{//case that arnt the general ones.
     //System.out.println("1 final and a child node");
     TreeNode temp = root;
     int i=0;   
     while(i<=s.length()){//find a way to activae certian noedes using this while loop
       if(i==s.length()-1){
         TreeNode t = new TreeNode(null, null,null,true);
         if(s.charAt(i)=='1' && temp.getRightChild()!=null){
           //System.out.println("1 final and a child node");
           if(temp.getRightChild().getIsUsed()==true){
             insert=false;
           }else{
             temp.getRightChild().setIsUsed(true);
             insert= true;
           }
         }else if(s.charAt(i)=='0' && temp.getLeftChild()!=null){
          // System.out.println("0 final and a child node");
           if(temp.getLeftChild().getIsUsed()==true){
             insert=false;
           }else{
             temp.getLeftChild().setIsUsed(true);
             insert= true;
           }

         }else if(s.charAt(i)=='1' && temp.getRightChild()==null){
          // System.out.println("1 final and no child node");
           t.setParent(temp);
           temp.setRightChild(t);
           insert= true;
           numNodes++;
         }else if(s.charAt(i)== '0' && temp.getLeftChild()==null){
          // System.out.println("0 final and node child node");
           t.setParent(temp);
           temp.setLeftChild(t);
           insert= true;
           numNodes++;
         }
       }else if(i<=s.length()-1){
         TreeNode t = new TreeNode(null, null,null,false);
         if(s.charAt(i)=='1' && temp.getRightChild()!=null){
           //System.out.println("1 and a child node");
           temp= temp.getRightChild();
           insert= false;
         }else if(s.charAt(i)=='0' && temp.getLeftChild()!=null){
           //System.out.println("0 and a child node");
           temp = temp.getLeftChild();
           insert=false;
         }else if(s.charAt(i)=='1' && temp.getRightChild()==null){
           //System.out.println("1 and no child node");
           t.setParent(temp);
           temp.setRightChild(t);
           temp = t;
           insert=false;
           numNodes++;
         }else if(s.charAt(i)== '0' && temp.getLeftChild()==null){
           //System.out.println("0 and no child node");
           t.setParent(temp);
           temp.setLeftChild(t);
           temp =t;
           insert=false;
           numNodes++;
         }  
       }
       i++;
     
     }
   }
   return insert;
 }
    
   
 
 // Method to be implemented by you. See handout part 1A
 public boolean search(String s) {//done
  // **** method code to be added in this class *****
  // now we just have a dummy that prints  message and returns true.
   boolean search = false;
   if (s=="" || s==null){
     return false;
   }else{
     int i = 0;
     TreeNode temp = root;
     while (i<=s.length() && search == false){       
       if(temp==null){
         search=false;
       }else if(i==s.length()){
           if(temp.getIsUsed()==true){
           System.out.println("true, index ==s.length");
           search = true;
         }else if(temp.getIsUsed()==false){
           System.out.println("false, index ==s.length");
           search=false;
         }
       }else if (i!=s.length()){
         if(s.charAt(i)=='1' && temp.getRightChild()!=null){
           System.out.println("has and moved right child");
           temp= temp.getRightChild();
         }else if(s.charAt(i)=='0' && temp.getLeftChild()!=null){
           System.out.println("has and moved left child");
           temp = temp.getLeftChild();
         }else if (s.charAt(i)=='1' && temp.getRightChild()==null){
           temp=null;
         }else if(s.charAt(i)=='0' && temp.getLeftChild()==null){
           temp=null;
         }
       }    
       i++;
     }
   }
   return search;
   }

 

 // Method to be implemented by you. See handout part 1A 
 public void printStringsInLexicoOrder() {
   printStringsInLexicoOrder(root, "");
  // ***** method code to be added in this class *****
  // now we just have a dummy method that prints a message.
 }
 public void printStringsInLexicoOrder(TreeNode temp, String s){
   if(temp.getIsUsed()==true){
     System.out.print(s+",");
   }
   if (temp.getLeftChild()!=null){
     printStringsInLexicoOrder(temp.getLeftChild(),s+'0');
   }
   if(temp.getRightChild() != null){
     printStringsInLexicoOrder(temp.getRightChild(),s+'1');
   }
 }
   
     
    
 
 
 
 // the following method that calls its recursive counterpart
 // prints the tree and its boolean values at nodes in 
 // in-order traversal order
 
 public void printInOrder() { // not to be changed
  printInOrder(root);
 }
 private void printInOrder(TreeNode N) { // not to be changed
  System.out.print("(");
  if (N!=null) {
   printInOrder(N.getLeftChild());
   System.out.print(N.getIsUsed());
   printInOrder(N.getRightChild());

  }
  System.out.print(")");
 }
 

 
 public TreeNode root() { // not to be changed
  return root;
 }
 
 public int numNodes() { // not to be changed
  return numNodes;
 }
 public boolean hasTwoChildren(TreeNode temp){
   if(temp.getRightChild()!=null && temp.getLeftChild()!=null){
     return true;
   }else{
     return false;
   }
 }
 public boolean hasAChild(TreeNode temp){
   if(temp.getRightChild()==null || temp.getLeftChild()==null){
     return true;
   }else{
     return false;
   }
 }


}
