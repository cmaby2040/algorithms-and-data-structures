
/*** 
 * This is class implements a compressed trie that holds a set of strings.
 * MyCompressedTrie stores nodes using class TreeNodeWithData
 * 
 * Name: Christopher Maby
 * Student Number: 8241271
 * Uottawa Email: Cmaby076@uottawa.ca
 * 
 *
 */
public class MyCompressedTrie {
 
  private TreeNodeWithData root;
 
  private int numNodes;
 
  public MyCompressedTrie() { // simple constructor (empty trie consisting of root only)
    root = new TreeNodeWithData(null, null, null,false,null);
    numNodes=1;
  }
 
 // to be implemented by you see handout Part 2A
 // Constructor that receives a regular trie and creates this
 // instance that is a compressed trie
 public MyCompressedTrie( MyTrie trie) {
   this();
   if (trie.root().getLeftChild()!=null){ 
     LeftSideTrie((trie.root()).getLeftChild(),root,"0"); 
                    
   }
   if (trie.root().getRightChild()!=null){ 
     RightSideTrie((trie.root()).getRightChild(),root,"1"); 
   }
                
 }
 private void LeftSideTrie(TreeNode parentUncompressed, TreeNodeWithData parentCompressed, String s){
   TreeNodeWithData t = parentCompressed; 
   if (parentUncompressed.getIsUsed()==true){
     t = new TreeNodeWithData(parentCompressed, null, null, true, s); 
     numNodes++;
     parentCompressed.setLeftChild(t); 

   }
   else if(parentUncompressed.getLeftChild()!=null && parentUncompressed.getRightChild()!=null){
     t = new TreeNodeWithData(parentCompressed, null, null, false,s);
     parentCompressed.setLeftChild(t);
     numNodes++;
   }
   if (parentUncompressed.getLeftChild()!=null){ 
     LeftSideTrie(parentUncompressed.getLeftChild(),t,s+"0");
   } 
   if( parentUncompressed.getRightChild()!=null){               
     RightSideTrie(parentUncompressed.getRightChild(),t,s+"1");
   }           
 }
 private void RightSideTrie(TreeNode parentUncompressed, TreeNodeWithData parentCompressed, String s){
   TreeNodeWithData t = parentCompressed; 
   if (parentUncompressed.getIsUsed()){
     t = new TreeNodeWithData(parentCompressed, null, null, true,s);
     parentCompressed.setRightChild(t);
     numNodes++;
   }
   else if (parentUncompressed.getLeftChild()!=null && parentUncompressed.getRightChild()!=null){
     t = new TreeNodeWithData(parentCompressed,null,null,false,s);
     parentCompressed.setRightChild(t);
     numNodes++;          
   }
   if (parentUncompressed.getLeftChild()!=null){
     LeftSideTrie(parentUncompressed.getLeftChild(),t,s+"0");
   } 
   if( parentUncompressed.getRightChild()!=null){                
     RightSideTrie(parentUncompressed.getRightChild(),t,s+"1");
   }
 }
 // Method to be implemented by you. See handout part 2A 
 public void printStringsInLexicoOrder() {
   printStringsInLexicoOrderrecursivily(root);
 }

 public void printStringsInLexicoOrderrecursivily(TreeNodeWithData t){
   if(t.getIsUsed()==true && t.getData()!=null){ 
     System.out.print(t.getData()+",");
   }
   if(t.getLeftChild()!=null){
     printStringsInLexicoOrderrecursivily((TreeNodeWithData)(t.getLeftChild()));
   }
   if(t.getRightChild()!=null){
     printStringsInLexicoOrderrecursivily((TreeNodeWithData)t.getRightChild());
   }
 }

 // the following method that calls its recursive counterpart
 // prints the tree and its data values at nodes in 
 // in-order traversal order
 
 public void printInOrder() { // not to be changed
  printInOrder(root);
 }
 
 private void printInOrder(TreeNode N) { // not to be changed
  System.out.print("(");
  if (N!=null) {
   printInOrder(N.getLeftChild());
   System.out.print(((TreeNodeWithData)N).getData());
   printInOrder(N.getRightChild());

  }
  System.out.print(")");
 }
 

 
 public int numNodes() {
  return numNodes; 
 }
 

}
