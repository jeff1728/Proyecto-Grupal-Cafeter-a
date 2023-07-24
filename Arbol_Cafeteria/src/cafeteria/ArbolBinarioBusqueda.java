package cafeteria;
public class ArbolBinarioBusqueda extends ArbolBinario {
	public ArbolBinarioBusqueda () {
		super();
	}

	public Nodo buscar(Object buscado)
	{
		Comparador dato;
		dato = (Comparador) buscado;
		if (raiz == null)
			//System.out.println("no encontrado");
			return null;
		else {
			System.out.println("encontrado");
			return localizar(raizArbol(), dato);
		}
	}
	public Nodo localizar(Nodo raizSub, Comparador buscado)
	{
		if (raizSub == null)
			return null;
		else if (buscado.igualQue(raizSub.valorNodo()))
			return raiz;
		else if (buscado.menorQue(raizSub.valorNodo()))
			return localizar(raizSub.subarbolIzdo(), buscado);
		else
			return localizar (raizSub.subarbolDcho(), buscado);
	}

	public Nodo buscarIterativo (Object buscado)
	{
		Comparador dato;
		boolean encontrado = false;
		Nodo raizSub = raiz;
		dato = (Comparador) buscado;
		while (!encontrado && raizSub != null)
		{
			if (dato.igualQue(raizSub.valorNodo()))
				encontrado = true;
			else if (dato.menorQue(raizSub.valorNodo()))
				raizSub = raizSub.subarbolIzdo();
			else 
				raizSub = raizSub.subarbolDcho();
		}	
		return raizSub;
	}

	public void insertar (Object valor )throws Exception
	{
		Comparador dato;
		dato = (Comparador) valor;
		raiz = insertar(raiz, dato);
	}
	
	
	//método interno para realizar la operación
	protected Nodo insertar(Nodo raizSub, Comparador dato) throws Exception {
		if (raizSub == null)
			raizSub = new Nodo(dato);
		else if (dato.menorQue(raizSub.valorNodo()))
		{
			Nodo iz;
			iz = insertar(raizSub.subarbolIzdo(), dato);
			raizSub.ramaIzdo(iz);
		}
		else if (dato.mayorQue(raizSub.valorNodo()))
		{
			Nodo dr;
			dr = insertar(raizSub.subarbolDcho(), dato);
			raizSub.ramaDcho(dr);
		}
		else
			throw new Exception("Nodo duplicado");
		return raizSub;
	}

	public void eliminar (Object valor) throws Exception
	{
		Comparador dato;
		dato = (Comparador) valor;
		raiz = eliminar(raiz, dato);
		
	}
	//método interno para realizar la operación
	protected Nodo eliminar (Nodo raizSub, Comparador dato) throws Exception {
		if (raizSub == null)
			throw new Exception ("No encontrado el nodo con la clave");
		else if (dato.menorQue(raizSub.valorNodo()))
		{
			Nodo iz;
			iz = eliminar(raizSub.subarbolIzdo(), dato);
			raizSub.ramaIzdo(iz);
		}
		else if (dato.mayorQue(raizSub.valorNodo()))
		{
			Nodo dr;
			dr = eliminar(raizSub.subarbolDcho(), dato);
			raizSub.ramaDcho(dr);
		}
		else // Nodo encontrado 
		{
			Nodo q;
			q = raizSub; // nodo a quitar del árbol
			if (q.subarbolIzdo() == null)
				raizSub = q.subarbolDcho();
			else if (q.subarbolDcho() == null)
				raizSub = q.subarbolIzdo();
			else
			{ // tiene rama izquierda y derecha 
				q = reemplazar(q);
			}
			q = null;
		}
		return raizSub;
	}
	
	// método interno para sustituir  por el mayor de los menores
	private Nodo reemplazar(Nodo act)
	{
		Nodo a, p;
		p = act;
		a = act.subarbolIzdo(); // rama de nodos menores
		while (a.subarbolDcho() != null)
		{
			p = a;
			a = a.subarbolDcho();
		}
		act.nuevoValor(a.valorNodo());
		if (p == act)
			p.ramaIzdo(a.subarbolIzdo());
		else
			p.ramaDcho(a.subarbolIzdo());
		return a;
	}
	
	//-----------------------------------------------------------------------
	
	 public int contarHojas() {
	        return contarHojasRecursivo(raizArbol());
	    }

	    private int contarHojasRecursivo(Nodo raizSub) {
	        if (raizSub == null) {
	            return 0;
	        }

	        if (raizSub.subarbolIzdo() == null && raizSub.subarbolDcho() == null) {
	            // Nodo hoja encontrado, retornamos 1
	            return 1;
	        }

	        // Continuamos buscando hojas en los subárboles izquierdo y derecho
	        int hojasIzquierdas = contarHojasRecursivo(raizSub.subarbolIzdo());
	        int hojasDerechas = contarHojasRecursivo(raizSub.subarbolDcho());

	        // Sumamos el número de hojas encontradas en ambos subárboles
	        return hojasIzquierdas + hojasDerechas;
	    }
	    
	    public int sumarElementos() {
	        return sumarElementosRecursivo(raizArbol());
	    }

	    private int sumarElementosRecursivo(Nodo raizSub) {
	        if (raizSub == null) {
	            return 0;
	        }

	        Integer valorActual = (Integer) raizSub.valorNodo();
	        int sumaIzquierda = sumarElementosRecursivo(raizSub.subarbolIzdo());
	        int sumaDerecha = sumarElementosRecursivo(raizSub.subarbolDcho());

	        return valorActual + sumaIzquierda + sumaDerecha;
	    }

	    public int sumarMultiplosDeTres() {
	        return sumarMultiplosDeTresRecursivo(raizArbol());
	    }

	    private int sumarMultiplosDeTresRecursivo(Nodo raizSub) {
	        if (raizSub == null) {
	            return 0;
	        }

	        Integer valorActual = (Integer) raizSub.valorNodo();
	        int sumaIzquierda = sumarMultiplosDeTresRecursivo(raizSub.subarbolIzdo());
	        int sumaDerecha = sumarMultiplosDeTresRecursivo(raizSub.subarbolDcho());

	        if (valorActual % 3 == 0) {
	            return valorActual + sumaIzquierda + sumaDerecha;
	        } else {
	            return sumaIzquierda + sumaDerecha;
	        }
	    }
	    
	  //------------------------------------------------------------------
	    public Nodo encontrarNodoMaximo() {
	        return encontrarNodoMaximoRecursivo(raizArbol());
	    }

	    private Nodo encontrarNodoMaximoRecursivo(Nodo raizSub) {
	        if (raizSub == null) {
	            return null;
	        }

	        if (raizSub.subarbolDcho() == null) {
	            // Si no hay rama derecha, este es el nodo máximo
	            return raizSub;
	        }

	        // Continuar buscando en la rama derecha
	        return encontrarNodoMaximoRecursivo(raizSub.subarbolDcho());
	    }

		@Override
		public String toString() {
			return "Nodo encontrado: ";
		}
	    

}
