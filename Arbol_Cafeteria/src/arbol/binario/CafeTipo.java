package arbol.binario;

import cafeteria.Comparador;

public class CafeTipo implements Comparador{
String tipoCafe;
int precio;
public String getTipoCafe() {
	return tipoCafe;
}
public void setTipoCafe(String tipoCafe) {
	this.tipoCafe = tipoCafe;
}
public int getPrecio() {
	return precio;
}
public void setPrecio(int precio) {
	this.precio = precio;
}
@Override
public boolean igualQue(Object q) {
	CafeTipo p2=(CafeTipo) q;
	return precio==p2.precio;
}
@Override
public boolean menorQue(Object q) {
	CafeTipo p2=(CafeTipo) q;
	return precio<p2.precio;
}
@Override
public boolean menorIgualQue(Object q) {
	CafeTipo p2=(CafeTipo) q;
	return precio<=p2.precio;
}
@Override
public boolean mayorQue(Object q) {
	CafeTipo p2=(CafeTipo) q;
	return precio > p2.precio;
}
@Override
public boolean mayorIgualQue(Object q) {
	CafeTipo p2=(CafeTipo) q;
	return precio >= p2.precio;
}


}
