import java.util.*;
import java.util.concurrent.*;

class Graph {
	class Node {
		int data;
		boolean marked;
		LinkedList<Node> adj;
		Node(int data){
			this.data = data;
			this.marked = false;
			this.adj = new LinkedList<Node>();
		}
	}
	ArrayList<Node> nodes;
	void conectNode(Node n1, Node n2){
		if(!n1.adj.contains(n2)){
			n1.adj.add(n2);
		}
		if(!n2.adj.contains(n1)){
			n2.adj.add(n1);
		}
	}
	Node addNode(int data){
		Node n  = new Node(data);
		nodes.add(n);
		return n;
	}
	Graph(){
		nodes = new ArrayList<Node>();
	}

	void bfs(Node n){
		LinkedBlockingQueue<Node> q = new LinkedBlockingQueue<Node>();
		q.add(n);
		n.marked = true;
		while(!q.isEmpty()) {
			Node nd = q.poll();
			for(Node cn: nd.adj){
				if(!cn.marked){
					cn.marked =true;
					q.add(cn);
			
				}
			}
			System.out.print(nd.data);
		}
	}

}

public class GraphTest {
	public static void main(String[] arg){
		Graph g = new Graph();
		for(int i = 0; i < 9; i++){
			g.addNode(i);
		}
		g.conectNode(g.nodes.get(0),g.nodes.get(1));
		g.conectNode(g.nodes.get(1),g.nodes.get(2));
		g.conectNode(g.nodes.get(1),g.nodes.get(3));
		g.conectNode(g.nodes.get(2),g.nodes.get(3));
		g.conectNode(g.nodes.get(2),g.nodes.get(4));
		g.conectNode(g.nodes.get(3),g.nodes.get(4));
		g.conectNode(g.nodes.get(3),g.nodes.get(5));
		g.conectNode(g.nodes.get(5),g.nodes.get(6));
		g.conectNode(g.nodes.get(6),g.nodes.get(8));
		g.conectNode(g.nodes.get(5),g.nodes.get(7));
		g.bfs(g.nodes.get(3));
	}
}