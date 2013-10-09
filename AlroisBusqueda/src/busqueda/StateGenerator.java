package busqueda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StateGenerator {
	
	public Boolean[][] matrix;
	public int m_size;
	public List<Integer> expandidos;
	
	//Constructor
	public StateGenerator(Boolean[][] matrix, int size){
		this.matrix = matrix;
		this.m_size = size;
		this.expandidos = new ArrayList<Integer>();
	}
	
	/*	expand(SearchNode start_node)
	 * Regresa una lista con los estados alcanzables desde 
	 * start_node.
	 * */
	public LinkedList<SearchNode> expand(SearchNode start_node){
		LinkedList<SearchNode> hijos = new LinkedList<SearchNode>(); 
		
		start_node.expanded = true;
		expandidos.add(start_node.estado);
		
		//Iterar sobre las columnas de la matriz, en la fila de start_node.estado.
		for(int columna = 0; columna<m_size; columna++){
			
			//Si hay camino desde estado actual y este no ha sido expandido...
			if(matrix[start_node.estado][columna] && !expandidos.contains(columna)){
				//Crear nuevo nodo y agregarlo a la lista a devolver
				SearchNode nuevo_nodo = new SearchNode(columna, start_node);
				hijos.add(nuevo_nodo);
				
			}
			
		}
		return hijos;
	}
	
	public void print_path(SearchNode node){
		SearchNode temp = node;
		while(temp != null){
			System.out.print(temp.estado.toString() + "->");
			temp = temp.nodoPadre;
		}
		
	}
	
	

}

