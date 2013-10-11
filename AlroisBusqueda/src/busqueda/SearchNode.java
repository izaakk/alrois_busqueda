package busqueda;

public class SearchNode {
	public Integer estado;
	public SearchNode nodoPadre;
	public int operador;
	public int profundidad = 0;
	public float costo;
	public Boolean expanded;
	
	
	public SearchNode(int estado, SearchNode padre){
		this.estado = new Integer(estado);
		this.nodoPadre = padre;
		//this.profundidad = padre.profundidad +1;
		this.expanded = false;
	}
	
}
