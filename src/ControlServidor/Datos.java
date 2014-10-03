/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlServidor;

import ControlServidor.MensajeObserver;

/**
 *
 * @author Elelegido
 */
public class Datos
{
    private MensajeObserver mensaje;
    private String ip;

    public Datos(MensajeObserver m, String ip)
    {
       this.mensaje = m;
       this.ip = ip;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public MensajeObserver getMensaje() {
        return mensaje;
    }

    public void setMensaje(MensajeObserver mensaje) {
        this.mensaje = mensaje;
    }


}
