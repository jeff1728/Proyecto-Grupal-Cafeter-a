package cafeteria;
public class ArbolBinario {
	
	protected Nodo raiz;

	public ArbolBinario(){
		raiz = null;
	}

	public ArbolBinario(Nodo raiz){
		this.raiz = raiz;
	}

	public Nodo raizArbol(){
		return raiz;
	}

	// Comprueba el estatus del árbol
	public boolean esVacio(){
		return raiz == null;
	}

	public static Nodo nuevoArbol(Nodo ramaIzqda, Object dato, Nodo ramaDrcha){
		return new Nodo(ramaIzqda, dato, ramaDrcha);
	}

	// Recorrido de un árbol binario en preorden
	public static void preorden(Nodo r){
		if (r != null)
		{
			r.visitar();
			preorden (r.subarbolIzdo());
			preorden (r.subarbolDcho());
		}
	}
	// Recorrido de un árbol binario en inorden
	public static void inorden(Nodo r){
		if (r != null)
		{
			inorden (r.subarbolIzdo());
			r.visitar();
			inorden (r.subarbolDcho());
		}
	}
	// Recorrido de un árbol binario en postorden
	public static void postorden(Nodo r){
		if (r != null)
		{
			postorden (r.subarbolIzdo());
			postorden (r.subarbolDcho());
			r.visitar();
		}
	}
	
	public static int numNodos(Nodo raiz){
		if (raiz == null)
			return 0;
		else
			return 1 + numNodos(raiz.subarbolIzdo()) +
					numNodos(raiz.subarbolDcho());
	}
	
	

	/*protected Nodo raiz;

	public ArbolBinario() {
		raiz = null;
	}

	public ArbolBinario(Nodo raiz) {
		this.raiz = raiz;
	}

	public Nodo raizArbol() {
		return raiz;
	}

	boolean esVacio() {
		return raiz == null;
	}

	public static void preorden(Nodo r) {
		if (r != null) {
			r.visitar();
			preorden(r.subarbolIzdo());
			preorden(r.subarbolDcho());
		}
	}

	public static void inorden(Nodo r) {
		if (r != null) {
			inorden(r.subarbolIzdo());
			r.visitar();
			inorden(r.subarbolDcho());
		}
	}

	public static void postorden(Nodo r) {
		if (r != null) {
			postorden(r.subarbolIzdo());
			postorden(r.subarbolDcho());
			r.visitar();
		}
	}

	public static int numNodos(Nodo raiz) {
		if (raiz == null)
			return 0;
		else
			return 1 + numNodos(raiz.subarbolIzdo()) + numNodos(raiz.subarbolDcho());
	}

	public int sumarElementos() {
		return sumarElementos(raizArbol());
	}

	public static int sumarElementos(Nodo raizSub) {
		if (raizSub == null) {
			return 0;
		}

		Integer valorActual = (Integer) raizSub.valorNodo();
		int sumaIzquierda = sumarElementos(raizSub.subarbolIzdo());
		int sumaDerecha = sumarElementos(raizSub.subarbolDcho());

		return valorActual + sumaIzquierda + sumaDerecha;
	}

		public void insertar(Object valor) throws Exception {
		Comparador dato;
		dato = (Comparador) valor;
		raiz = insertar(raiz, dato);
	}

	public static Nodo insertar(Nodo raizSub, Comparador dato) throws Exception {
		if (raizSub == null)
			raizSub = new Nodo(dato);
		else if (dato.menorQue(raizSub.valorNodo())) {
			Nodo iz;
			iz = insertar(raizSub.subarbolIzdo(), dato);
			raizSub.ramaIzdo(iz);
		} else if (dato.mayorQue(raizSub.valorNodo())) {
			Nodo dr;
			dr = insertar(raizSub.subarbolDcho(), dato);
			raizSub.ramaDcho(dr);
		} else 
			throw new Exception("Nodo duplicado");
		return raizSub;
	}

	public void eliminar(Object valor) throws Exception {
		Comparador dato;
		dato = (Comparador) valor;
		raiz = eliminar(raiz, dato);
	}

	// método interno para realizar la operación
	protected Nodo eliminar(Nodo raizSub, Comparador dato) throws Exception {
		if (raizSub == null)
			throw new Exception("No encontrado el nodo con la clave");
		else if (dato.menorQue(raizSub.valorNodo())) {
			Nodo iz;
			iz = eliminar(raizSub.subarbolIzdo(), dato);
			raizSub.ramaIzdo(iz);
		} else if (dato.mayorQue(raizSub.valorNodo())) {
			Nodo dr;
			dr = eliminar(raizSub.subarbolDcho(), dato);
			raizSub.ramaDcho(dr);
		} else // Nodo encontrado
		{
			Nodo q;
			q = raizSub; // nodo a quitar del árbol
			if (q.subarbolIzdo() == null)
				raizSub = q.subarbolDcho();
			else if (q.subarbolDcho() == null)
				raizSub = q.subarbolIzdo();
			else { // tiene rama izquierda y derecha
				q = reemplazar(q);
			}
			q = null;
		}
		return raizSub;
	}

	private Nodo reemplazar(Nodo act) {
		Nodo a, p;
		p = act;
		a = act.subarbolIzdo(); // rama de nodos menores
		while (a.subarbolDcho() != null) {
			p = a;
			a = a.subarbolDcho();
		}
		act.nuevovalor(a.valorNodo());
		if (p == act)
			p.ramaIzdo(a.subarbolIzdo());
		else
			p.ramaDcho(a.subarbolIzdo());
		return a;
	}
	
	public Nodo izquierda(Nodo valor) {
		Nodo nuevo= null;
		return nuevo.subarbolIzdo();
	}
	public Nodo derecha(Nodo valor) {
		Nodo nuevo= null;
		return nuevo.subarbolDcho();
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	public static Nodo nuevoArbol(Nodo ramaIzqda, Object dato, Nodo ramaDrcha) {
		return new Nodo(ramaIzqda, dato, ramaDrcha);
	}*/

}
