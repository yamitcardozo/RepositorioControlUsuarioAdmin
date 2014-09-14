/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.util.Date;

/**
 *Dto en el que se recibiran los datos de la tabla RegUsuario
 * @author Yamit Cardozo :D
 */
public class RegUsuario {

    // se utiliza string para los numero de identificación ya que no son datos
    // que se utilicen para hacer cálculos matematicos.

    /**
     * id registro para cuando se realiza un presta de computadora
     */
    private String idRegistro;
    /**
     *  fecha de inicio prestamo de computadora
     */
    private Date frechaInicio;
    /**
     * fecha fianl del prestamo de computadora
     */
    private Date fechaFinal;
    /**
     *  estado del registro ocupado,libre,pendiente para prestamo
     */
    private String estado;
    /**
     * referencia al id de la computadora en preoceso
     */
    private Computadora idComputadora;
    /**
     *  referencia a nombre de usuario asignado al cual se le realiza el prestamo
     */
    private Usuario nombreUsuario;

    /**
     * retorna id de la computadora prestada
     * @return
     */
    public Computadora getIdComputadora() {
        return idComputadora;
    }

    /**
     *  asiga id de computadora a prestar
     * @param idComputadora
     */
    public void setIdComputadora(Computadora idComputadora) {
        this.idComputadora = idComputadora;
    }
    /**
     * retorna estado del prestamo
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     * asigan el estaod al prestamo por defecto esta libre
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * retorna el nombre del usuario que hace el prestamo
     * @return
     */
    public Usuario getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * asigan el nombre del usuario a prestar computadora
     * @param nombreUsuario
     */
    public void setNombreUsuario(Usuario nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * retorna la fecha final para terminar  prestamo
     * @return
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     *  asigna fecha final terminar prestamo
     * @param fechaFinal
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     *  retorna fecha inicial para hacer un prestamo
     * @return
     */
    public Date getFrechaInicio() {
        return frechaInicio;
    }

    /**
     * asigna fecha inicial para hacer un prestamo
     * @param frechaInicio
     */
    public void setFrechaInicio(Date frechaInicio) {
        this.frechaInicio = frechaInicio;
    }

    /**
     * retorna id registro del prestamo
     * @return
     */
    public String getIdRegistro() {
        return idRegistro;
    }

    /**
     * asigana ide registro a un prestamo
     * @param idRegistro
     */
    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }

    /**
     * retorna un usuario que hace prestamo
     * @return
     */
    public Usuario getIdUsuario() {
        return nombreUsuario;
    }

    /**
     * asiga un usuario que hace prestamo
     * @param idUsuario
     */
    public void setIdUsuario(Usuario idUsuario) {
        this.nombreUsuario = idUsuario;
    }
}
