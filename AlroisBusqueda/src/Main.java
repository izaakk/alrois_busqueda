import java.util.LinkedList;

import busqueda.*;


public class Main {

	
	public static void main(String[] args) {
		Boolean[][] matrix = 
				{{false, true, true, false, true, false},
				 {true, false, true, true, true, false},
				 {true, true, false, false, false, false},
				 {false, true, false, false, false, true},
				 {true, true, false, false, false, false},
				 {false, false, false, true, false, false}};
		
		StateGenerator gen = new StateGenerator(matrix, 6);
		LinkedList<SearchNode> lista = new LinkedList<SearchNode>();
		//SearchNode raiz
		SearchNode A = new SearchNode(0, null);
		
		lista.addAll(gen.expand(A));
		
		while(!lista.isEmpty())
		lista.addAll(gen.expand(lista.removeFirst()));
	}

}
