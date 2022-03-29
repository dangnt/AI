package BFS;

import java.util.ArrayList;

public class Vertex<T> {

    private   T state;
    private ArrayList<Vertex> adjacentVertices;
	
    public Vertex(T state){
        this.state = state;
        this.adjacentVertices = new ArrayList<>();
    }

    public T getState() {
	return state;
}

    public void setState(T state) {
	this.state = state;
    }

    public ArrayList<Vertex> getAdjacentVertices() {
	return adjacentVertices;
    }

    public void addAdjacentVertex(Vertex adjacentVertex) {
	this.adjacentVertices.add(adjacentVertex);
    }
        	
    @Override
    public boolean equals(Object obj) {
        Vertex vertex = (Vertex) obj;        
        
	if (!(vertex instanceof Vertex))
            return false;	

        return (vertex.getState() == this.getState());
    }
    
    @Override
    public String toString() {
	return "" + this.state;
    }
}
