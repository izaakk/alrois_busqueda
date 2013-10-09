package busqueda;

import java.util.Vector;

public class StateGenerator {
	
	public static final int FRONT = 0 ;
	public static final int BACK = 1 ;
	public static final int INSERT = 2;
	
	//Constructor
	public StateGenerator(){
	
	}
	
	/*	expand(SearchNode start_node)
	 * Regresa una lista con los estados alcanzables desde 
	 * start_node.
	 * */
//	public LinkedList<SearchNode> expand(SearchNode start_node){
//		
//		LinkedList<SearchNode> hijos = new LinkedList<SearchNode>(); 
//		start_node.expanded = true;
//		expandidos.add(start_node.estado);
//		
//		//Iterar sobre las columnas de la matriz, en la fila de start_node.estado.
//		for(int columna = 0; columna<m_size; columna++){
//			
//			//Si hay camino desde estado actual y este no ha sido expandido...
//			if(matrix[start_node.estado][columna] && !expandidos.contains(columna)){
//				//Crear nuevo nodo y agregarlo a la lista a devolver
//				SearchNode nuevo_nodo = new SearchNode(columna, start_node);
//				hijos.add(nuevo_nodo);
//				
//			}
//			
//		}
//		return hijos;
//	}
	
	public void expand(SearchNode start_node, Vector<SearchNode> queue, int position) {
		  start_node.setExpanded(); 
		  for (int j = 0; j < start_node.links.size(); j++) {
		     SearchNode nextNode = (SearchNode)start_node.links.elementAt(j) ;
		     if (!nextNode.tested) {
		       nextNode.setTested(true) ; 
		       nextNode.setDepth(start_node.profundidad+1) ; 
		       nextNode.setParent(start_node);
		       switch (position) {
		        case FRONT: queue.insertElementAt(nextNode,0); 
		                break ;
		        case BACK: queue.addElement(nextNode);   
		                break ;
		        case INSERT: 
		         boolean inserted = false ;
		         float nextCost = nextNode.costo ; 
		         for (int k=0 ; k < queue.size() ; k++) { 
		           // find where to insert this node
		           if (nextCost < ((SearchNode)queue.elementAt(k)).costo) {
		             queue.insertElementAt(nextNode, k); // insert in middle 
		             inserted = true ;
		             break ;     // exit the for loop
		           } 
		         } 
		         // couldn't find place to insert, just add to end
		         if (!inserted) 
		        	 queue.addElement(nextNode) ;  
		         break;                    
		       }  
		     }
		 } 
	}
	
	
	public void print_path(SearchNode node){
		SearchNode temp = node;
		while(temp != null){
			System.out.print(temp.estado.toString() + "->");
			temp = temp.nodoPadre;
		}
		
	}
	
	

}

