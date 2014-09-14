/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

/**
 * Dto en el que se recibiran los datos de la tabla computadora
 * @author Yamit Cardozo :D
 */
public class Computadora {

    /**
	 * identificador de computadora
	 */
	private String id_computadora;
	/**
	 *  informacion relevante de computadora
	 */
	private String descripcion;
	/**
	 *  indica si la computadora esta disponible para ser usada.
	 */
	private String estado;
    /**
	 *
	 * @return id_computadora
	 */
	public String getId_computadora() {
		return id_computadora;
	}
	/**
	 * Asigna el id de la computadora
	 * @param id_computadora
	 */
	public void setId_computadora(String id_computadora) {
		this.id_computadora = id_computadora;
	}
	/**
	 *
	 * @return la descripcion de la computadora
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * asigna la descripcion de la computadora
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 *
	 * @return el estado de la computadora
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * asigna el estado de la computadora
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
