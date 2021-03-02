import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class ParisMetro {

 private static int[][] graph = new int[400][400];  
 private int node,edge;
 private static int numberofvertices;
    public static final int INFINITY = 9999999;
    
 
 public static void readeMetro(String file)throws Exception,IOException 
 {
  numberofvertices = 376 ;
  BufferedReader br = new BufferedReader(new FileReader(file));
  String line,line2;
  do{
   line = br.readLine();
   StringTokenizer st = new StringTokenizer(line);
   line2 = st.nextToken();
  }
  while(!line2.equals("$"));
  

  while ((line = br.readLine()) != null) {
   StringTokenizer st = new StringTokenizer(line);
   if (st.countTokens() != 3)
    throw new IOException("Incorrect input file at line " + line);
   int source = new Integer(st.nextToken()).intValue();
   int dest = new Integer(st.nextToken()).intValue();
   int weight = new Integer(st.nextToken()).intValue();
   graph[source][dest]=weight;
   graph[dest][source]=weight;
  }
 }
 
    public void dfs(int adjacency_matrix[][], int source)
    {
     Stack<Integer> stack;
     stack = new Stack<Integer>();
        int number_of_nodes = adjacency_matrix[source].length - 1;
 
        int visited[] = new int[number_of_nodes + 1];  
        int element = source;  
        int i = source;  
        System.out.print(element + " ");  
        visited[source] = 1;  
        stack.push(source);
 
        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = element; 
     while (i <= number_of_nodes)
     {
              if (adjacency_matrix[element][i] > 0 && visited[i] == 0)
         {
                    stack.push(i);
                    visited[i] = 1;
                    element = i;
                    i = 1;
                    System.out.print(element + " ");
             continue;
                }
                i++;
     }
            stack.pop(); 
        } 
    }
    
    public void floydwarshall(int adjacencymatrix[][],int src,int dest)
    {
     int[][] distancematrix = new int[numberofvertices + 1][numberofvertices + 1];
     int[][] next = new int[numberofvertices+1][numberofvertices+1];
     
     for (int source = 0; source <= numberofvertices; source++)
        {
            for (int destination = 0; destination <= numberofvertices; destination++)
            {
                if (source == destination)
                {
                 adjacencymatrix[source][destination] = 0;
                    continue;
                }
                else {
                 next[source][destination] = destination + 1;
                }
                if (adjacencymatrix[source][destination] == 0)
                {
                 adjacencymatrix[source][destination] = INFINITY;
                }
            }
        }
     
        for (int source = 0; source <= numberofvertices; source++)
        {
            for (int destination = 0; destination <= numberofvertices; destination++)
            {
                distancematrix[source][destination] = adjacencymatrix[source][destination];
             if(distancematrix[source][destination]==-1) distancematrix[source][destination]=90;
            }
        }
 
        for (int intermediate = 0; intermediate <= numberofvertices; intermediate++)
        {
            for (int source = 0; source <= numberofvertices; source++)
            {
                for (int destination = 0; destination <= numberofvertices; destination++)
                {
                    if (distancematrix[source][intermediate] + distancematrix[intermediate][destination]
                         < distancematrix[source][destination]){
                        distancematrix[source][destination] = distancematrix[source][intermediate] 
                            + distancematrix[intermediate][destination];
                    next[source][destination] = next[source][intermediate];
                    }
                }
            }
        }
        System.out.println("Time :"+ distancematrix[src ][dest]);
//        numberofvertices=100;
//        for (int source = 0; source <= numberofvertices; source++)
//            System.out.print("\t" + source);
// 
//        System.out.println();
//        for (int source = 0; source <= numberofvertices; source++)
//        {
//            System.out.print(source + "\t");
//            for (int destination = 0; destination <= numberofvertices; destination++)
//            {
//                System.out.print(distancematrix[source][destination]+":"+next[source][destination] + "\t");
//            }
//            System.out.println();
//        }
        System.out.print("Path : ");
        int u=src+1;
        int v=dest+1;
        String path= u-1 +" ";
        do {
            u = next[u - 1][v - 1];
            path += " " + (u-1);
        } while (u != v);
        System.out.print(path);
    }
    
    public void dfs_n_fw(int adjacencymatrix[][],int src,int dest,int broken)
    {
     Stack<Integer> stack;
     HashSet<Integer> brokenLine = new HashSet<Integer>();
     stack = new Stack<Integer>();
        int number_of_nodes = adjacencymatrix[broken].length - 1;
 
        int visited[] = new int[number_of_nodes + 1];  
        int element = broken;  
        int i = broken;    
        visited[broken] = 1;  
        stack.push(broken);
 
        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = element; 
     while (i <= number_of_nodes)
     {
          if (adjacencymatrix[element][i] > 0 && visited[i] == 0)
         {
                    stack.push(i);
                    visited[i] = 1;
                    element = i;
                    i = 1;
                    brokenLine.add(element);
                    //System.out.print(element + " ");
             continue;
                }
                i++;
     }
            stack.pop(); 
        }
        
        
     int[][] distancematrix = new int[numberofvertices + 1][numberofvertices + 1];
     int[][] next = new int[numberofvertices+1][numberofvertices+1];
     
     for (int source = 0; source <= numberofvertices; source++)
        {
            for (int destination = 0; destination <= numberofvertices; destination++)
            {
                if (source == destination)
                {
                 adjacencymatrix[source][destination] = 0;
                    continue;
                }
                else {
                 next[source][destination] = destination + 1;
                }
                if (adjacencymatrix[source][destination] == 0)
                {
                 adjacencymatrix[source][destination] = INFINITY;
                }
            }
        }
     
        for (int source = 0; source <= numberofvertices; source++)
        {
            for (int destination = 0; destination <= numberofvertices; destination++)
            {
                distancematrix[source][destination] = adjacencymatrix[source][destination];
             if(distancematrix[source][destination]==-1) distancematrix[source][destination]=90;
            }
        }
 
        for (int intermediate = 0; intermediate <= numberofvertices; intermediate++)
        {
         if(brokenLine.contains(intermediate)) continue;
            for (int source = 0; source <= numberofvertices; source++)
            {
                for (int destination = 0; destination <= numberofvertices; destination++)
                {
                    if (distancematrix[source][intermediate] + distancematrix[intermediate][destination]
                         < distancematrix[source][destination]){
                        distancematrix[source][destination] = distancematrix[source][intermediate] 
                            + distancematrix[intermediate][destination];
                    next[source][destination] = next[source][intermediate];
                    }
                }
            }
        }
        System.out.println("Time :"+ distancematrix[src ][dest]);
        System.out.print("Path : ");
        int u=src+1;
        int v=dest+1;
        String path= u-1 +" ";
        do {
            u = next[u - 1][v - 1];
            path += " " + (u-1);
        } while (u != v);
        System.out.print(path);
    }
    
    public static void main(String args[])
 {
  ParisMetro sGraph = new ParisMetro();
  try {
   sGraph.readeMetro("metro.txt");
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (Exception e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  if(args.length==1)
  {
   int a=Integer.parseInt(args[0]);
   sGraph.dfs(graph,a);
  }
  else if(args.length==2)
  {
   int a1 = Integer.parseInt(args[0]);
   int a2 = Integer.parseInt(args[1]);
   sGraph.floydwarshall(graph,a1,a2);

  }
  else if(args.length==3)
  {
   int a1 = Integer.parseInt(args[0]);
   int a2 = Integer.parseInt(args[1]);
   int a3 = Integer.parseInt(args[2]);
   sGraph.dfs_n_fw(graph,a1,a2,a3);
  }
  else System.out.println("Give 1 to 3 args to work with!");
 }
}
