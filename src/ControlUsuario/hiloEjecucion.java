/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import AccesoADatos.ImpleUsuario;
import ControlExcepciones.ExcepcionFlujo;
import Entidades.Usuario;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
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
    // controla que el administrador este en la lista de observadores
    private int  controlChatAdmin=0;

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
         String verificador;
      
         mensaje.addObserver(this);

        while (conectado) {
            try {
                // Lee un mensaje enviado por el cliente
                mensajeRecibido = dis.readUTF();
                verificador = verificaArreglo(mensajeRecibido);

                if(verificador.equalsIgnoreCase("1"))
                {
                    String[] s = mensajeRecibido.split("&");
                    Usuario us;
                    ImpleUsuario is = new ImpleUsuario();
                    us = is.obtener(s[1]);
                    if(us==null)
                    {
//                        mensaje.setMensaje("NA");
                        dos.writeUTF("NA");
                    }else
                    {
                        log.info("encontro usuario especifico");
                        dos.writeUTF(us.getIdUsuario()+"&"+us.getContraseña()+"&"+us.getPrimerNombre()+"&"+us.getPrimerApellido());
                          // Se apunta a la lista de observadores de mensajes si existe en la
                        // base de datos
//                         mensaje.addObserver(this);
                         System.out.println("estoy en el observador cliente");
//                        mensaje.setMensaje(us.getIdUsuario()+"&"+us.getContraseña()+"&"+us.getPrimerNombre()+"&"+us.getPrimerApellido());
                    }
                }else if(verificador.equalsIgnoreCase("2"))
                {
                    // Pone el mensaje recibido en mensajes para que se notifique
                // a sus observadores que hay un nuevo mensaje.
                System.out.println("cliente desconenctado");
                }else
                {
                    if(controlChatAdmin==0)
                    {
//                        mensaje.addObserver(this);
                        controlChatAdmin=1;
                    }
                    System.out.println("admin envio mensajes a los observadores");
                    mensaje.setMensaje(mensajeRecibido);
                    System.out.println("mensajes enviados");
                }
                
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
    }

    public String verificaArreglo(String h)
    {
        String hilera[] = h.split("&");
        return hilera[0];
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
