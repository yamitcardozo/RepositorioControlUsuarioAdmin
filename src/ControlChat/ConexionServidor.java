/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlChat;

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

    public ConexionServidor(Socket socket, JTextField tfMensaje, String usuario,String numEquipo) {
        this.socket = socket;
        this.tfMensaje = tfMensaje;
        this.usuario = usuario;
        this.numEquipo = numEquipo;
        try {
            this.salidaDatos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            log.error("Error al crear el stream de salida : " + ex.getMessage());
        } catch (NullPointerException ex) {
            log.error("El socket no se creo correctamente. ");
        }

    }

  

//    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            salidaDatos.writeUTF(numEquipo+"&"+usuario + ": " + tfMensaje.getText() );
            tfMensaje.setText("");
        } catch (IOException ex) {
            log.error("Error al intentar enviar un mensaje: " + ex.getMessage());
        }
    }

}
