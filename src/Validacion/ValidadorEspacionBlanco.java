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
public class ValidadorEspacionBlanco implements Validador {

    public void Validador(Object o,JFrame f,ErrorValidacion e) {

        Registro r = (Registro) o;
        FrameRegistro v = (FrameRegistro) f;
        boolean valida = false;

        if(r.getPrimerNombre().equalsIgnoreCase(""))
        {
            v.mostrarFallo(2, 1);
            valida= true;
        }
        if(r.getPrimerApellido().equalsIgnoreCase(""))
        {
            v.mostrarFallo(2, 2);
            valida = true;
        }
        if(r.getUsuario().equalsIgnoreCase(""))
        {
            v.mostrarFallo(2, 3);
            valida = true;
        }
        if(r.getContraseña().equalsIgnoreCase(""))
        {
            v.mostrarFallo(2, 4);
            valida = true;
        }
        if(valida)
        {
            e.setMensaje(e.getMensaje()+"* \n"+"Campo no puede estar vacio"+"\n");
        }else
        {
            System.out.println("todos los campos tienen caracteres");
        }
    }
    public String mensaje()
    {
        String f = "* \n"+"Campo no puede estar vacio"+"\n";
        return f;
    }
    
}
