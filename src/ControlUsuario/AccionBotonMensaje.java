/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import ControlChat.AdminChat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Elelegido
 */
public class AccionBotonMensaje implements ActionListener {

    ClienteChat cli;
    String numero;
    int numeroEquipos;
     AdminChat EnvioMensaje=null;
    

    public  AccionBotonMensaje(String numero,ClienteChat cli,int numeroEquipos)
    {
        this.cli = cli;
        this.numero = numero;
        this.numeroEquipos = numeroEquipos;
    }

    public void actionPerformed(ActionEvent e) {
         for(int i=0;i<numeroEquipos;i++)
                      {
            
                          if(e.getActionCommand().equalsIgnoreCase(("Mensaje "+(i+1))))
                          {
                               System.out.println("numero de quipos" +numero);
                              if(EnvioMensaje==null){
                              EnvioMensaje = new AdminChat(numero,cli);
                              }
                              cli.setAdm(EnvioMensaje);
                              System.out.println("entro aqui");
                          }
                      }
    }

}
