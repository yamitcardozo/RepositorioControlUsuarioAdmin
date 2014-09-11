/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import java.util.Observable;

/**
 *
 * @author Elelegido
 */
public class MensajeObserver extends Observable {

    private String mensaje;

    public MensajeObserver(){
    }

    public String getMensaje(){
        return mensaje;
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
        // Indica que el mensaje ha cambiado
        this.setChanged();
        // Notifica a los observadores que el mensaje ha cambiado y se lo pasa
        // (Internamente notifyObservers llama al metodo update del observador)
        this.notifyObservers(this.getMensaje());
    }
}
