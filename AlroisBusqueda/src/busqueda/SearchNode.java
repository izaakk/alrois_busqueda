package busqueda;

import java.util.Vector;

public class SearchNode {
	public String label;
	public Object estado;
	public Object oper;
	public Vector<SearchNode> links;
	public SearchNode nodoPadre;
	public int operador;
	public int profundidad = 0;
	public float costo;
	public Boolean expanded;
	public Boolean tested;
	
	public static final int FRONT = 0 ;
	public static final int BACK = 1 ;
	public static final int INSERT = 2;
	
	
	public SearchNode(Object estado, SearchNode padre){
		this.estado = estado;
		this.nodoPadre = padre;
		//this.profundidad = padre.profundidad +1;
		this.expanded = false;
		this.tested = false;
	}
	
	public boolean leaf() { return (links.size() == 0) ; }
	public void setDepth(int Depth) { profundidad = Depth; }
	public void setOperator(Object Oper) { oper = Oper; }
	public void setExpanded() { expanded = true; } 
	public void setExpanded(boolean state) { expanded = state; } 
	public void setTested(boolean state) { tested = state ; }
	public void setParent(SearchNode parent){nodoPadre = parent;}
	
	public void reset() {
		  profundidad = 0 ;
		  expanded = false ;
		  tested = false ; 
		}
	
	public void addLink(SearchNode Node) { 
        links.addElement(Node);
	}
	
	public void addLinks(SearchNode n1, SearchNode n2) {
	        links.addElement(n1) ; 
	        links.addElement(n2) ;
	}
	
	public void addLinks(SearchNode n1, SearchNode n2, SearchNode n3) {
	        links.addElement(n1) ;
	        links.addElement(n2) ; 
	        links.addElement(n3) ; 
	}
	
	public void addLinks(SearchNode n1, SearchNode n2, 
	               SearchNode n3, SearchNode n4) {
	        links.addElement(n1) ; links.addElement(n2) ; 
	        links.addElement(n3) ; links.addElement(n4) ; 
	}
	
	public void addLinks(Vector<SearchNode> Nodes) {
	       for (int i=0 ; i < Nodes.size() ; i++) {
	          links.addElement(Nodes.elementAt(i)) ; 
	       }
	}
	
	public void trace(){}
}
