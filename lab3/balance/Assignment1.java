class Assignment1{

  public int medianArrayValue (int[] o){
     int median = 0;
     int[] counterValue = new int[o.length];
     for (int i=0; i<o.length;i++){
       for (int j=0;j<o.length; j++){
         if (o[i]> o[j]){
           int a= counterValue[i];
           counterValue[i] = counterValue[i]+1;
         }
       }
       if(counterValue[i]== ((o.length-1)/2)){
         median = o[i];
         break;
       } 
     }
   return median;
  }
    
  public static void main(String[] args){
    Assignment1 a = new Assignment1();
    int [] b = new int[]{5,2,7,3,13,4,7};
    int answer = a.medianArrayValue(b);
    System.out.println(answer);
  }
    
}