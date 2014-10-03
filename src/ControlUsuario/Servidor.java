/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import ControlExcepciones.ExcepcionFlujo;
import ControlServidor.ConectorServer;

/**
 *
 * @author Yamit Cardozo
 */
   public  class Servidor extends Thread
           {

                @Override
                public void run() {

              ConectorServer c = new ConectorServer();
            try {
                c.iniciar();
            } catch (ExcepcionFlujo ex) {
                System.out.println("inicio servidor");
            }
                }

           }
