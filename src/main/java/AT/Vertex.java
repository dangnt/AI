package AT;

import java.util.ArrayList;
import java.util.Objects;

public class Vertex<T> implements Comparable<Vertex> {

    private T state;
    private Vertex parent;
    private int g;  // total distance from starting vertex
    private int d;  // distance from parent
    private ArrayList<Vertex> adjacentVertices;

    public Vertex() {}

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

    public void addAdjacentVertex(Vertex adjacentVertex, int d) {
        adjacentVertex.setParent(this);
        adjacentVertex.setD(d);
	    this.adjacentVertices.add(adjacentVertex);
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "" + this.state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex vertex = (Vertex) o;
        return getState().equals(vertex.getState()) && parent.equals(vertex.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getState(), parent);
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

    @Override
    public int compareTo(Vertex v) {
        if (this.getG() > v.getG())
            return 1;
        else if (this.getG() < v.getG())
            return -1;
        else
            return 0;
    }
}
