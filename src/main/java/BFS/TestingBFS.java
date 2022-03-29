package BFS;

public class TestingBFS {

	public static void main(String[] args) {
		
		BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
		
		Vertex vertex1 = new Vertex("TP.HCM");
		Vertex vertex2 = new Vertex("Bien-Hoa");
		Vertex vertex3 = new Vertex("My-Tho");
		Vertex vertex4 = new Vertex("Tay-Ninh");
		Vertex vertex5 = new Vertex("Cao-Lanh");
		Vertex vertex6 = new Vertex("Sa-Dec");
		
		vertex1.addAdjacentVertex(vertex2);
		vertex1.addAdjacentVertex(vertex3);
                vertex2.addAdjacentVertex(vertex3);
		vertex1.addAdjacentVertex(vertex4);
		vertex3.addAdjacentVertex(vertex5);
                vertex3.addAdjacentVertex(vertex6);
                vertex5.addAdjacentVertex(vertex6);
		
		breadthFirstSearch.bfs(vertex1);

	}
}
