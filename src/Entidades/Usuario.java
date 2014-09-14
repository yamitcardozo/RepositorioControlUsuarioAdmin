/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

/**
 * Dto en el que se recibiran los datos de la tabla Usuario
 * @author Yamit Cardozo :)
 */
public class Usuario {

   // se utiliza string para los numero de identificación ya que no son datos
    // que se utilicen para hacer cálculos matematicos.

    /**
     * identificador usuario
     */
    private String idUsuario;
    /**
     * contraseña del usuario
     */
    private String contraseña;
    /**
     * primer nombre del usuario
     */
    private String primerNombre;
    /**
     * primer apellido del usuario
     */
    private String primerApellido;
    /**
     * se le asigna un usuario
     */
    private String usuario;

    /**
     *  retorna usuario asignado
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    public Usuario(String idUsuario, String contraseña, String primerNombre,String primerApellido, String usuario)
    {
        this.idUsuario = idUsuario;
        this.contraseña = contraseña;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.usuario = usuario;
    }

    /**
     *  asiga usuario
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     *  retorna la contraseña del usuario
     * @return
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * asigana contraseña del usuario
     * @param contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * retorna el identificador del usuario
     * @return
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     *  asigan un identificador al usuario
     * @param idUsuario
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * retorna el primer apellido del usuario
     * @return
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * asigna el primer apellido al usuario
     * @param primerApellido
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     *  retorna el primer nombre del usuario
     * @return
     */
    public String getPrimerNombre() {
        return primerNombre;
    }

    /**
     * asiga el primer nombre al usuario
     * @param primerNombre
     */
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

}
