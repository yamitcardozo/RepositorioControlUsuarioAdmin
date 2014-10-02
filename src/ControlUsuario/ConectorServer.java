package ControlUsuario;

import ControlExcepciones.ExcepcionFlujo;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
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
        int maximoDeConexiones = 35;  // maximo de conexiones simultaneas
        //MensajeObserver mensaje = new MensajeObserver();
        MensajeObserver mensaje=null;

        IpConectada arrayIp = new IpConectada();
        for(int i=0;i<20;i++)
        {
            arrayIp.addLista(new MensajeObserver(), ""+i);
        }
        Semaphore sep = new Semaphore(1,true);
//        ArrayList<hiloEjecucion> lis = new ArrayList<hiloEjecucion>();
        try {
            // se crea el server socket
            ss = new ServerSocket(puerto,maximoDeConexiones);
            int idSession = 0;
            // bucle infinito para esperar conexion
            while (true) {
                log.info("ConectorServer : Servidor a la espera de conexion");
                socket = ss.accept();

                String mostrar = socket.getInetAddress().toString() ;
                log.info("ConectorServer : Cliente con la IP "+mostrar+ " conectado.");
                // se crea un hilo por cada conexion cliente
                hiloEjecucion hi = new hiloEjecucion(socket, idSession,mensaje ,arrayIp,mostrar,sep);
//                lis.add(hi);
                hi.start();
                idSession++;
            }

        } catch (Exception e) {
            log.error("ConectorServer : conectar servidor ");
            throw new ExcepcionFlujo(e);
        }finally
        {
//            for(int i=0; i< lis.size();i++)
//            {
//                lis.get(i).stop();
//            }
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
