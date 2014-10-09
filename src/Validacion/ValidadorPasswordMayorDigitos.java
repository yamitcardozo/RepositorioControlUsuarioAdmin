/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validacion;

import Registro.FrameRegistro;
import javax.swing.JFrame;

/**
 *
 * @author Yamit Cardozo
 */
public class ValidadorPasswordMayorDigitos implements Validador{

    public void Validador(Object o, JFrame f, ErrorValidacion e) {
        
        Registro r = (Registro) o;
        FrameRegistro v = (FrameRegistro) f;
        boolean valida = false;

        String password = r.getContraseña();
        if(password.length()<5)
        {
            v.mostrarFallo(2, 4);
            valida = true;
            
        }
        if(valida)
        {
            e.setMensaje(e.getMensaje()+"cantidad de digitos de contraseña debe ser mayor que 5"+"\n");
        }
    }

    public String mensaje()
    {
        String f = "cantidad de digitos de contraseña debe ser mayor que 5"+"\n";
        return f;
    }
}
