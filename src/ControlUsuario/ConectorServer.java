package ControlUsuario;

import ControlExcepciones.ExcepcionFlujo;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// servidor


/**
 *
 * @author Yamit Cardozo
 */
public class ConectorServer {
        private Logger log = Logger.getLogger(ConectorServer.class);
     public void iniciar() throws ExcepcionFlujo{
        
        ServerSocket ss=null;
        Socket socket=null;
        int puerto = 10578;
        int maximoDeConexiones = 30;  // maximo de conexiones simultaneas
        //MensajeObserver mensaje = new MensajeObserver();
        MensajeObserver mensaje = new MensajeObserver();
        try {
            // se crea el server socket
            ss = new ServerSocket(puerto,maximoDeConexiones);
            int idSession = 0;
            // bucle infinito para esperar conexion
            while (true) {
                log.info("ConectorServer : Servidor a la espera de conexion");
                socket = ss.accept();
                
                log.info("ConectorServer : Cliente con la IP " + socket.getInetAddress().getHostName() + " conectado.");
                // se crea un hilo por cada conexion cliente
                hiloEjecucion hi = new hiloEjecucion(socket, idSession,mensaje);
                hi.start();
                idSession++;
            }

        } catch (Exception e) {
            log.error("ConectorServer : conectar servidor ");
            throw new ExcepcionFlujo(e);
        }finally
        {
             try {
                socket.close();
                ss.close();
            } catch (Exception ex) {
                log.error("ConectorServer : Error al cerrar el servidor: ");
                throw new ExcepcionFlujo(ex);
            }
        }
     }
    
}
