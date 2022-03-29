package BFS;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;

public class BreadthFirstSearch {

    public static Set<Vertex> visited = new HashSet<Vertex>(){
        public boolean contains(Object obj) {
            Vertex vertex = (Vertex) obj;
        
            for (Vertex v : this) {
                if (v.equals(vertex)) {
                    return true;
                }
            }
        
            return false;
        }
    };
    
    public void bfs(Vertex initialVertex){
		
	    Queue<Vertex> queue = new LinkedList<>();
        
	    visited.add(initialVertex);
	    queue.add(initialVertex);
		               
	    while(!queue.isEmpty()){

            Vertex actualVertex = queue.remove();
            System.out.print(actualVertex + " ");

            ArrayList<Vertex> adjacentVertices = actualVertex.getAdjacentVertices();
                        
            for (int i = 0; i < adjacentVertices.size(); i++){
                Vertex v = adjacentVertices.get(i);
                            
                if(!visited.contains(v)){
                    visited.add(v);
                    queue.add(v);
                }
            }
	    }
    }
}
