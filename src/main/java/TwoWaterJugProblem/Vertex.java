/*
    Nguyen Tuan Dang
    Faculty of Information Technology, Saigon University
    dangnt@sgu.edu.vn
*/

package TwoWaterJugProblem;

import java.util.List;

public class Vertex {
    private State state;
    private Vertex parent;
    
    public Vertex(){
        this.state = new State();
        this.parent = null;
    }
    
    public Vertex(State state){
        this.state = state;        
        this.parent = null;
    }
    
    public static void setMaxJugsCapacity(int maxJug1, int maxJug2){
        State.setMaxJugsCapacity(maxJug1, maxJug2);
    }
    
    public State getState(){
        return state;
    }        
    
    public Vertex full_jug1(){
	return new Vertex(state.full_jug1());
    }
    
    public Vertex full_jug2(){
	return new Vertex (state.full_jug2());
    }
    
    public Vertex empty_jug1(){
	return new Vertex(state.empty_jug1());
    }
    
    public Vertex empty_jug2(){
	return new Vertex(state.empty_jug2());
    }
    
    public Vertex pour_jug1_jug2(){
        return new Vertex(state.pour_jug1_jug2());
    }
    
    public Vertex pour_jug2_jug1(){
        return new Vertex(state.pour_jug2_jug1());
    }        
    
    public Path tracePath(){
        Path<Vertex> path = new Path();
        Vertex v = new Vertex();
        
        v = this;
        
        while (v != null){
            path.addVertex(v);
            v = v.getParent();
        }
        
        return path;
    }
    
    public void setParent(Vertex vertex){
        this.parent = vertex;
    }    
    
    public Vertex getParent(){
        return parent;
    }

    @Override
    public boolean equals(Object obj) {
        Vertex v = (Vertex) obj;        
        
	if (!(v instanceof Vertex))
            return false;	
        
        return (this.state.equals(v.getState()));
    }        
    
    @Override
    public String toString(){
        return state.toString();
    }
}
