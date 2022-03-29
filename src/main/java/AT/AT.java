/*
    Nguyen Tuan Dang
    Faculty of Information Technology, Saigon University
    dangnt@sgu.edu.vn
*/

package AT;

import java.util.*;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;

public class AT {

    public static Set<Vertex> visited = new HashSet<Vertex>();
    public static Set<Vertex> destinations = new HashSet<Vertex>();

    public AT(ArrayList<Vertex> destinations) {
        for (Vertex v : destinations) {
            this.destinations.add(v);
        }
    }

    public void ATSearch(Vertex initialVertex) {

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();

        initialVertex.setG(0);
        visited.add(initialVertex);
        priorityQueue.add(initialVertex);

        while(!priorityQueue.isEmpty()){

            Vertex currentVertex = priorityQueue.poll();

            if(destinations.contains(currentVertex)) {
                currentVertex.tracePath().printPath();
                break;
            }

            // System.out.print(actualVertex + "(" + actualVertex.getG() + ")" + "\n");

            ArrayList<Vertex> adjacentVertices = currentVertex.getAdjacentVertices();

            for (int i = 0; i < adjacentVertices.size(); i++) {
                Vertex v = adjacentVertices.get(i);

                if(!visited.contains(v)) {
                    v.setG(currentVertex.getG() + v.getD());
                    visited.add(v);
                    priorityQueue.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {

        Vertex vertex0 = new Vertex("Start");
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Vertex vertex4 = new Vertex("D");
        Vertex vertex5 = new Vertex("E");
        Vertex vertex6 = new Vertex("F");
        Vertex vertex7 = new Vertex("G");
        Vertex vertex8 = new Vertex("H");
        Vertex vertex9 = new Vertex("I");
        Vertex vertex10 = new Vertex("J");
        Vertex vertex11 = new Vertex("K");
        Vertex vertex12 = new Vertex("L");
        Vertex vertex13 = new Vertex("M");
        Vertex vertex14 = new Vertex("N");
        Vertex vertex15 = new Vertex("O");
        Vertex vertex16 = new Vertex("P");
        Vertex vertex17 = new Vertex("Q");
        Vertex vertex18 = new Vertex("R");
        Vertex vertex19 = new Vertex("S");
        Vertex vertex20 = new Vertex("T");
        Vertex vertex21 = new Vertex("U");
        Vertex vertex22 = new Vertex("V");

        vertex0.addAdjacentVertex(vertex1, 100);
        vertex0.addAdjacentVertex(vertex2, 17);
        vertex0.addAdjacentVertex(vertex3, 1);
        vertex0.addAdjacentVertex(vertex4, 1);
        vertex1.addAdjacentVertex(vertex5, 1);
        vertex2.addAdjacentVertex(vertex6, 1);
        vertex3.addAdjacentVertex(vertex7, 10);
        vertex3.addAdjacentVertex(vertex8, 20);
        vertex4.addAdjacentVertex(vertex9, 12);
        vertex4.addAdjacentVertex(vertex10, 1);
        vertex7.addAdjacentVertex(vertex12, 1);
        vertex8.addAdjacentVertex(vertex13, 1);
        vertex10.addAdjacentVertex(vertex14, 1);
        vertex14.addAdjacentVertex(vertex16, 1);
        vertex16.addAdjacentVertex(vertex18, 1);
        vertex5.addAdjacentVertex(vertex11, 1);
        vertex11.addAdjacentVertex(vertex15, 1);
        vertex15.addAdjacentVertex(vertex17, 1);
        vertex17.addAdjacentVertex(vertex19, 1);
        vertex17.addAdjacentVertex(vertex20, 1);
        vertex20.addAdjacentVertex(vertex21, 1);
        vertex21.addAdjacentVertex(vertex22, 1);

        ArrayList<Vertex> destinations = new ArrayList<Vertex>();

        destinations.add(vertex6);
        destinations.add(vertex9);
        destinations.add(vertex12);
        destinations.add(vertex13);
        destinations.add(vertex18);

        AT at = new AT(destinations);

        at.ATSearch(vertex0);
    }
}
