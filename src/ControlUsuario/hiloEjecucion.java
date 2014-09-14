/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import ControlExcepciones.ExcepcionFlujo;
import Entidades.Usuario;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import org.apache.log4j.Logger;
//import java.util.logging.*; buscar como utilizar 

/**
 *
 * @author Administrator2
 */
public class hiloEjecucion extends Thread implements Observer{

    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private int idSessio;
    private MensajeObserver mensaje;
    private Logger log = Logger.getLogger(hiloEjecucion.class);

    public hiloEjecucion(Socket socket, int id, MensajeObserver mensaje) throws ExcepcionFlujo {
        this.socket = socket;
        this.idSessio = id;
        this.mensaje = mensaje;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        }catch (Exception e) {
            log.error("hiloEjecucion : constructor error al crear flujos de datos socket");
            throw new ExcepcionFlujo(e);
        }
    }

    public void desconnectar() throws ExcepcionFlujo {
        try {
            socket.close();
        } catch (Exception e) {
             log.error("hiloEjecucion: desconectar error al cerra el socket");
            throw new ExcepcionFlujo(e);
        }
    }

    @Override
    public void run() {
         String mensajeRecibido;
         boolean conectado = true;
        // Se apunta a la lista de observadores de mensajes
        mensaje.addObserver(this);

        while (conectado) {
            try {
                // Lee un mensaje enviado por el cliente
                mensajeRecibido = dis.readUTF();
                // Pone el mensaje recibido en mensajes para que se notifique
                // a sus observadores que hay un nuevo mensaje.
                mensaje.setMensaje(mensajeRecibido);
            } catch (Exception ex) {
                log.info("Cliente con la IP " + socket.getInetAddress().getHostName() + " desconectado.");
                conectado = false;
                // Si se ha producido un error al recibir datos del cliente se cierra la conexion con el.
                try {
                    dis.close();
                    dos.close();
                } catch (Exception ex2) {
                    log.error("hiloEjecución : run Error al cerrar los stream de entrada y salida :");
                    new ExcepcionFlujo(ex2);
                }
            }
        }
//        DatosArchivo archivoServidor = new DatosArchivo();
//        String datosArchivo;
//        String accion = "";
//        userServicio s = new userServicio();
//        Usuario u = s.getU();
//        String uUsuario;
//        String uContraseña;
//        try {
//           accion = dis.readUTF();
//           s.asignacionAtributosUsuario(accion);
//           uUsuario = u.getIdUsuario();
//           uContraseña = u.getContraseña();
//           datosArchivo = archivoServidor.lecturaArchivo(uUsuario+"&"+uContraseña+"&");
//           if(datosArchivo.equalsIgnoreCase(uUsuario+"&"+uContraseña+"&")){
//                log.info("El cliente con idSesion "+this.idSessio+" saluda");
//                dos.writeUTF("aceptado");
////               datosArchivo=datosArchivo+s.getFechaInicio()+"&";
////               datosArchivo=datosArchivo+s.getHoraInicio()+"&";
////               archivoServidor.escrituraArchivo(datosArchivo);
//           }else{
//               log.info("El cliente con idSesion "+this.idSessio+"no se encuentra en la base de datos"+ uUsuario+"&"+uContraseña+"&");
//               dos.writeUTF("denegado");
//           }
//        } catch (Exception e) {
//            log.info("hiloEjecucion:run");
//           new ExcepcionFlujo(e);
//        }
//        try {
//            desconnectar();
//        } catch (Exception ex) {
//            new ExcepcionFlujo(ex);
//        }
    }

    public void update(Observable o, Object arg) {
       try {
            // Envia el mensaje al cliente
            dos.writeUTF(arg.toString());
        } catch (Exception ex) {
            log.error("hiloEjecucion : update Error al enviar mensaje al cliente ");
            new ExcepcionFlujo(ex);
        }
    }
}
