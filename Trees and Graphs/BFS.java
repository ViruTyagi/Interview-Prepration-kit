import java.util.*;

class Graph{
	int V;
    LinkedList<Integer> addList[];
    int[] prev; 

	Graph(int V){
		this.V = V;
		addList = new LinkedList[V];
		for(int i =0;i<V;i++){
			addList[i] = new LinkedList();
        }
        prev = new int[V];
        Arrays.fill(prev,-1);
	}

	void addEdge(int src,int dest){
		addList[src].add(dest);
		addList[dest].add(src);
    }
    int[] solve(int src){
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[V];
        visited[src] = true;
        System.out.print(src + " ");
        queue.add(src);
        while(!queue.isEmpty()){
            int node = queue.remove();
            for(Integer crawl:addList[node]){
                if(!visited[crawl]){
                    queue.add(crawl);
                    visited[crawl]=true;
                    prev[crawl] = node;
                }
            }
        }
        return prev;
    }
    String bfs(int src,int end){
        prev = solve(src);
        for(int i=0;i<prev.length;i++){
            System.out.print(prev[i] + " ");
        }
        System.out.println();
        System.out.print(reconstructPath(src, end, prev));
        return "lol";
    }

    String reconstructPath(int src,int end,int[] prev){
        String path = "";
        for(int at = end;at !=-1;at=prev[at]){
            path = Integer.toString(at) + path;
        }
    
        if(path.charAt(0) == Integer.toString(src).charAt(0)){
            return path;
        }else{
            return "";
        }

        
    }
}


class BFS {
  public static void main(String[] args) {
   Graph graph = new Graph(13);
	 graph.addEdge(0,9);
     graph.addEdge(0,7);
     graph.addEdge(0, 11);
     graph.addEdge(9, 10);
     graph.addEdge(9,8);
     graph.addEdge(10, 1);
     graph.addEdge(8, 1);
     graph.addEdge(8, 12);
     graph.addEdge(12, 2);
     graph.addEdge(2, 3);
     graph.addEdge(3, 4);
     graph.addEdge(3, 7);
     graph.addEdge(7, 6);
     graph.addEdge(6, 5);
     graph.addEdge(7, 3);
     graph.addEdge(3, 4);
     graph.addEdge(11, 7);
	 System.out.print(graph.bfs(0,6));
  }
}