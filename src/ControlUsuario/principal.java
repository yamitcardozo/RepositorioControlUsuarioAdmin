/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import ControlExcepciones.ExcepcionFlujo;

/**
 *
 * @author Administrator2
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExcepcionFlujo {
        // TODO code application logic here
        ConectorServer c = new ConectorServer();
        c.iniciar();
    }

}
