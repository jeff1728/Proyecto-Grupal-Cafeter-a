package cafeteria;
import javax.swing.JOptionPane;

import arbol.binario.CafeTipo;

public class Nodo {
	protected Object dato;
	protected Nodo izdo;
	protected Nodo dcho;
	Interfaz i=new Interfaz();
	public Nodo(Object valor)
	{
		dato = valor;
		izdo = dcho = null;
	}
	public Nodo(Nodo ramaIzdo, Object valor, Nodo ramaDcho)
	{
		this.dato = valor;
		izdo = ramaIzdo;
		dcho = ramaDcho;
	}
	// operaciones de acceso 
	public Object valorNodo(){ 
		return dato; 
	}
	
	public Nodo subarbolIzdo(){
		return izdo; 
	}
	
	public Nodo subarbolDcho(){
		return dcho; 
	}
	
	public void nuevoValor(Object d){
		dato = d; 
	}
	
	public void ramaIzdo(Nodo n){
		izdo = n; 
	}
	
	public void ramaDcho(Nodo n){ 
		dcho = n;
	}
	
	public void visitar(){
		CafeTipo E1 = (CafeTipo) valorNodo();
		System.out.print("Cafe:"+ E1.getTipoCafe() + "precio: "+ E1.getPrecio() + "\n");
		JOptionPane.showMessageDialog(null, "Cafe:"+ E1.getTipoCafe() + "precio: "+ E1.getPrecio() + "\n","Orden por Precio",1);
		//i.textArea1.setText("Cafe:"+ E1.getTipoCafe() + "precio: "+ E1.getPrecio() + "\n");
	}
}
