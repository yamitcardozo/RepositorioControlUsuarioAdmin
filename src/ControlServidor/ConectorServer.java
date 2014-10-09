package ControlServidor;

import ContenedorDeDatos.DatosArchivo;
import ControlExcepciones.ExcepcionFlujo;
import ControlServidor.IpConectada;
import ControlServidor.MensajeObserver;
import ControlServidor.hiloEjecucion;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
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
        private List<String> listIp;
     public void iniciar() throws ExcepcionFlujo{
        
        ServerSocket ss=null;
        Socket socket=null;
        int puerto = 10578;
        int maximoDeConexiones = 35;  // maximo de conexiones simultaneas
        MensajeObserver mensaje=null;
        DatosArchivo operadorArchivo;

        IpConectada arrayIp = new IpConectada();
        for(int i=0;i<28;i++)
        {
            arrayIp.addLista(new MensajeObserver(), ""+i);
        }
        Semaphore sep = new Semaphore(1,true);
        operadorArchivo = new DatosArchivo();
        listIp = operadorArchivo.lecturaArchivoAll("listaIp.txt");
//      ArrayList<hiloEjecucion> lis = new ArrayList<hiloEjecucion>();
        try {
            // se crea el server socket
            ss = new ServerSocket(puerto,maximoDeConexiones);
            int idSession = 0;
            // bucle infinito para esperar conexion
            while (true) {
                log.info("ConectorServer : Servidor a la espera de conexion");
                socket = ss.accept();

                 String equipoUsuario = "datoseEncontroEnLaLista";

                String mostrar = socket.getInetAddress().toString() ;
                log.info("ConectorServer : Cliente con la IP "+mostrar+ " conectado.");

                String aux = buscarEnLista(mostrar);
                   System.out.println(aux + "   equipo");
                if(!aux.equalsIgnoreCase("0"))
                {
                    equipoUsuario = aux;
                 
                    System.out.println(equipoUsuario+"  encontrado "+ aux);
                }

                // se crea un hilo por cada conexion cliente
                hiloEjecucion hi = new hiloEjecucion(socket, idSession,mensaje ,arrayIp,equipoUsuario,sep);
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

     public String  buscarEnLista(String hilera)
     {
         for(int i=0; i<listIp.size();i++)
         {
             if(listIp.get(i).equalsIgnoreCase(hilera))
             {
                return ((i+1)+"");
             }
         }
         return "0";
     }
    
}
