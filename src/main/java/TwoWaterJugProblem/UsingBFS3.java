package TwoWaterJugProblem;

/* 
    Nguyen Tuan Dang
    Faculty of Information Technology, Saigon University
    dangnt@sgu.edu.vn
*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
        
public class UsingBFS3 {
    public static int MAX_JUG1, MAX_JUG2, GOAL;
    
    public static Queue<Vertex> queue = new LinkedList<>();
    
    public static Set<Vertex> visited = new HashSet<Vertex>(){
        public boolean contains(Object obj) {
            Vertex vertex = (Vertex) obj;
        
            for (Vertex v : this) {
                if (vertex.equals(v)) {
                    return true;
                }
            }
        
            return false;
        }
    };
    
    public static void main(String[] args) {
        MAX_JUG1 = 3;
        MAX_JUG2 = 4;
        GOAL = 2;

        Vertex.setMaxJugsCapacity(MAX_JUG1, MAX_JUG2);
        
	Vertex initialVertex = new Vertex(new State(0,0));
        queue.add(initialVertex);      
        visited.add(initialVertex);
        
	while(!queue.isEmpty()){             
            Vertex currentVertex = queue.poll();                                                          
            
            if(currentVertex.getState().getJug1() == GOAL || currentVertex.getState().getJug2() == GOAL){
                currentVertex.tracePath().printPath();                                                   
                continue;
            }            
            
            ArrayList<Vertex> newVertices = new ArrayList<>();
            
            newVertices.add(currentVertex.full_jug1());
            newVertices.add(currentVertex.full_jug2());
            newVertices.add(currentVertex.empty_jug1()); 
            newVertices.add(currentVertex.empty_jug2());                        
            newVertices.add(currentVertex.pour_jug1_jug2());
            newVertices.add(currentVertex.pour_jug2_jug1());
            
            for (Vertex newVertex : newVertices){                                    
                if(!currentVertex.tracePath().getPath().contains(newVertex)){
                    newVertex.setParent(currentVertex);
                    
                    if (!visited.contains(newVertex)){
                        queue.add(newVertex);                   
                        visited.add(newVertex);       
                    }
                }                                         
            }                       
	}
    }        
}
