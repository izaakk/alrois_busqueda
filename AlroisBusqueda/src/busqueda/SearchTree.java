package busqueda;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class SearchTree extends Hashtable<String, SearchNode>{
	
	private static final long serialVersionUID = 1L;
	public String name;
	public StateGenerator state_gen;
	
	
	
	
	SearchTree(String name, StateGenerator state_gen){
		this.name = name;
		this.state_gen = state_gen;
		
	}
	
	// reset each SearhNode in the graph
	// clear expanded and tested flags, set depth=0
	void reset() {
	 Enumeration<SearchNode> enume = this.elements() ;
	 while (enume.hasMoreElements()) {
	     SearchNode nextNode = enume.nextElement();
	     nextNode.reset() ;
	 }
	}

	// add node to Hashtable, using node label as key
	void put(SearchNode node) {
	  put(node.label, node) ;
	}
	
	public SearchNode depthFirstSearch(SearchNode initialNode, Object goalState)
	 {
	     Vector<SearchNode> queue = new Vector<SearchNode>() ;
	     queue.addElement(initialNode) ;
	     initialNode.setTested(true) ;  // test each node once

	     while (queue.size()> 0) {
	       SearchNode testNode = queue.firstElement() ;
	       queue.removeElementAt(0) ;
	       testNode.trace() ;           // display trace information
	       if (testNode.estado.equals(goalState)) return testNode ; // found it

	       if (!testNode.expanded) {
	         state_gen.expand(testNode, queue,SearchNode.FRONT);
	       }
	     }
	     return null ;
	 }

}
