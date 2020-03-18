import java.util.*;

class Graph{
	int V;
    LinkedList<Integer> addList[];
    boolean[] visited;
	int[] components;
	int count = 0;
	Graph(int V){
		this.V = V;
		addList = new LinkedList[V];
		for(int i =0;i<V;i++){
			addList[i] = new LinkedList();
		}
		visited = new boolean[V];
		components = new int[V];
	}

	void addEdge(int src,int dest){
		addList[src].add(dest);
		addList[dest].add(src);
	}
	void dfs(int node){
			if(visited[node])return;
			visited[node] = true;
			components[node] = count;
			for(Integer crawl:addList[node]){
				if(visited[crawl] != true){
				dfs(crawl);
				}
			}

	}
	int findComponet(){
		for(int i =0;i<V;i++){
			if(!visited[i]){
				count++;
				dfs(i);
			}
		}
		return count;
	}
}
class DFS {
  public static void main(String[] args) {
   Graph graph = new Graph(5);
	 graph.addEdge(1,3);
	 graph.addEdge(2,4);
	 System.out.println(graph.findComponet());
  }
}