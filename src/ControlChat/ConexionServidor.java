/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlChat;

import ControlUsuario.ClienteChat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

/**
 *
 * @author Elelegido
 */
public class ConexionServidor implements ActionListener {

    private Logger log = Logger.getLogger(ConexionServidor.class);
    private Socket socket;
    private JTextField tfMensaje;
    private String usuario;
    private DataOutputStream salidaDatos;
    private String numEquipo;
    private ClienteChat cli;

    public ConexionServidor(JTextField tfMensaje, String usuario,String numEquipo,ClienteChat cli) {
        this.tfMensaje = tfMensaje;
        this.usuario = usuario;
        this.numEquipo = numEquipo;
        this.cli = cli;
    }

  

//    @Override
    public void actionPerformed(ActionEvent e) {
            cli.enviarMensajeChat(numEquipo+ ": " + tfMensaje.getText());
            tfMensaje.setText("");
}
}