/** 
 * Proyecto: Juego de la vida.
 * @since: prototipo1.2
 * @source: Nif.java 
 * @version: 2.1 - 2017.05.05
 * @author: Fran
 * @author: Grupo 3
 */
import java.io.Serializable;


public class Nif implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String texto;

	public Nif(String texto) throws ModeloException{
		setTexto(texto);
	}

	public Nif() throws ModeloException{
		this("00000000T");
	}

	public Nif(Nif nif) throws ModeloException{
		this(new String(nif.texto));
	}
	public String getTexto() throws ModeloException{
		return texto;
	}

	public void setTexto(String texto) throws ModeloException{
		if (nifValido(texto)){
		this.texto = texto;
		return;
	}
	throw new ModeloException("El texto: " + texto + " no es válido...");
}

	private boolean nifValido(String texto) {
		assert texto != null;
			return	texto.matches(Formato.PATRON_NIF) 
					&& letraNIFValida(texto);
		}

	/*
	 Comprueba la validez de la letra de un NIF
	 */
	private boolean letraNIFValida(String texto) {
		int numeroNIF = Integer.parseInt(texto.substring(0,8));
		if (texto.charAt(8) == "TRWAGMYFPDXBNJZSQVHLCKE".charAt(numeroNIF % 23)) {
			return true;
		}
		return false;
	} 

	@Override
	public String toString() {
		return texto;
	}

	/**
	 * hashCode() complementa al metodo equals y sirve para comparar objetos de forma 
	 * rapida en estructuras Hash. 
	 * Cuando Java compara dos objetos en estructuras de tipo hash (HashMap, HashSet etc)
	 * primero invoca al metodo hashcode y luego el equals.
	 * @return un numero entero de 32 bit.
	 */
	@Override
	public int hashCode() {
		final int primo = 31;
		int result = 1;
		result = primo * result + ((texto == null) ? 0 : texto.hashCode());
		return result;
	}

	/**
	 * Dos objetos son iguales si: 
	 * Son de la misma clase.
	 * Tienen los mismos valores en los atributos; o son el mismo objeto.
	 * @return falso si no cumple las condiciones.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			if (this == obj) {
				return true;
			}
			if (texto.equals(((Nif) obj).texto)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Genera un clon del propio objeto realizando una copia profunda.
	 * @return el objeto clonado.
	 */
	@Override
	public Object clone() {
		// Utiliza el constructor copia.
		Object nif = null;
		try {
			nif = new Nif(this);
		}
		catch (ModeloException e){
			e.printStackTrace();
		}
		return nif;
	}
} // class
