/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validacion;

import AccesoADatos.ImpleUsuario;
import ControlExcepciones.ExcepcionFlujo;
import Entidades.Usuario;
import Registro.FrameRegistro;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Yamit Cardozo
 */
public class ValidadorUsuario implements Validador {

    public void Validador(Object o, JFrame f, ErrorValidacion e) {

        Registro r = (Registro) o;
        FrameRegistro v = (FrameRegistro) f;
        Usuario u = null;
        try {
            u = new ImpleUsuario().obtener(r.getUsuario());
        } catch (ExcepcionFlujo ex) {
             System.out.println("error al buscar usuario desconocido");
        }

        if(u == null)
        {
            System.out.println("error al buscar usuario");
            e.setMensaje("");
        }else
        {
            String usuario = u.getIdUsuario();
            e.setMensaje(e.getMensaje()+"Usuario : "+ usuario + " ya existe \n");
        }
        
    }

}
