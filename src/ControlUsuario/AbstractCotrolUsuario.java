/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * clase que muestra cada equipo en la intrerfaz de equipos del administrador
 * @author yamit Cardozo
 */
public  class AbstractCotrolUsuario {

    /**
     *  numero de equipo en la interfaz
     */
    JLabel equipo;
    /**
     * nombre de la persona que lo presto
     */
    JLabel nombre;
    /**
     *  estado de ocupacion
     */
    JLabel estado;
    /**
     *  boton
     */
    JButton boton;
    /**
     * panel para cada conjunto de datos
     */
    JPanel panel;
    /**
     * boton para enviar mensajes al cliente 
     */
    JButton botonMensaje;
    /**
     *  constructor que asigna valores a los atributos
     */
     public AbstractCotrolUsuario()
    {
        equipo = new JLabel("equipo NA");
        nombre = new JLabel("nombre NAuno");
        estado = new JLabel("------");
        boton = new JButton("equipo1");
        botonMensaje = new JButton();
        panel = new JPanel();
//        boton.setEnabled(false);
    }
    /**
     * obtiene boton para enviar mensaje al servidor
     * @return
     */
    public JButton getBotonMensaje() {
        return botonMensaje;
    }
    /**
     *  asigna boton para enviar mensaje al servidor
     * @param botonMensaje
     */
    public void setBotonMensaje(JButton botonMensaje) {
        this.botonMensaje = botonMensaje;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

     /**
      * retorna el boton que cambia estdo de computadora
      * @return
      */
    public JButton getBoton() {
        return boton;
    }
    /**
     * asigan un boton que cambia estado de la computadora
     * @param boton
     */
    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    /**
     * retorna el numero de equipo
     * @return
     */
    public JLabel getEquipo() {
        return equipo;
    }

    /**
     *  asigna numero de equipo
     * @param equipo
     */
    public void setEquipo(JLabel equipo) {
        this.equipo = equipo;
    }

    /**
     *  retorna el estado del equipo
     * @return
     */
    public JLabel getEstado() {
        return estado;
    }

    /**
     * asigna el estado del equipo
     * @param estado
     */
    public void setEstado(JLabel estado) {
        this.estado = estado;
    }

    /**
     * retorna el nombre de la persona que se le presto
     * @return
     */
    public JLabel getNombre() {
        return nombre;
    }

    /**
     * asigna nombre persona a prestar
     * @param nombre
     */
    public void setNombre(JLabel nombre) {
        this.nombre = nombre;
    }

}
