public class TestSearch{
  public static void main(String[] args){
    MyTrie m = new MyTrie();
    String s = "1111";
    System.out.println(m.insert("111"));
    System.out.println(m.search("111"));
    System.out.println(m.insert("1110"));
    System.out.println(m.search("11100"));

    
      
  }
}