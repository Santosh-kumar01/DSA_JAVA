import java.util.*;
public class Breadth_First_Search {
    static class Edge{
        int src;
        int dest;
       
         public Edge(int s, int d){
            this.src=s;
            this.dest=d;
           
         }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
    }

    //vertes-0
    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 2));

     //vertes-1
     graph[1].add(new Edge(1,0));
     graph[1].add(new Edge(1, 3));

     //vertes-2
     graph[2].add(new Edge(2,0));
     graph[2].add(new Edge(2,4));

       //vertes-3
       graph[3].add(new Edge(3,1));
       graph[3].add(new Edge(3,4));
       graph[3].add(new Edge(3,5));

       //vertes-4
       graph[4].add(new Edge(4,2));
       graph[4].add(new Edge(4,3));
       graph[4].add(new Edge(4,5));


       //vertes-5
       graph[5].add(new Edge(5,3));
       graph[5].add(new Edge(5,3));
       graph[5].add(new Edge(5,6));

       //vertes-6
       graph[6].add(new Edge(6,5));
     

}
    
    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);//source = 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]) // visit curr
            {
                System.out.print(curr+" ");
              
                vis[curr] = true;
                for(int i =0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }

            }
            
        }
    }

    public static void main(String[] args){

        int v=7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        bfs(graph);
        
        }

        
    
    
}
