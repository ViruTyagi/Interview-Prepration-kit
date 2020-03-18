import java.util.*;

class Graph{
	int V;
    LinkedList<Integer> addList[];

	Graph(int V){
		this.V = V;
		addList = new LinkedList[V];
		for(int i =0;i<V;i++){
			addList[i] = new LinkedList();
		}
	}

	void addEdge(int src,int dest){
		addList[src].add(dest);
		addList[dest].add(src);
    }

    void bfs(int src){
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
                    System.out.print(crawl + " ");
                }
            }
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
	 graph.bfs(0);
  }
}