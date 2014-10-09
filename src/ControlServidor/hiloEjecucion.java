/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlServidor;

import AccesoADatos.ImpleUsuario;
import AccesoADatos.impleRegUsuario;
import ControlExcepciones.ExcepcionFlujo;
import Entidades.RegUsuario;
import Entidades.Usuario;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Semaphore;
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
    private IpConectada conIp;
    private String equipoUsuario;
    private boolean estaEnobservador = false;
    private String numequi;
    private String idUsuario;
    private int numRegistros=0;
    private boolean entro= true;
    private Logger log = Logger.getLogger(hiloEjecucion.class);
    // controla que el administrador este en la lista de observadores
    private int  controlChatAdmin=0;
    private Semaphore sep;
    private boolean entro11=true;
    private boolean entro1Usuario=true;
    private ImpleUsuario is;
    private impleRegUsuario regUsu;
    private boolean chat;

    public hiloEjecucion(Socket socket, int id, MensajeObserver mensaje,IpConectada arrayIp,String equipoUsuario, Semaphore sep) throws ExcepcionFlujo {
        this.equipoUsuario = equipoUsuario;
        this.conIp = arrayIp;
        this.socket = socket;
        this.idSessio = id;
        this.mensaje = mensaje;
        this.sep = sep;
        is = new ImpleUsuario();
       
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
//         String verificador1;
//         boolean a=false;
//         boolean b=false;

         
//         Datos d = conIp.buscarValor(mostrar);
//         mensaje = d.getMensaje();
//          mensaje.addObserver(this);

//          esto hay que ponerlo
//         if("datoseEncontroEnLaLista".equalsIgnoreCase(equipoUsuario))
//         {
//              entro1Usuario = false;
//         }else
//         {
//             entro11 = false;
//         }
//
//         if(entro1Usuario)
//                {
//                   for(int i=0;i<28;i++)
//                {
//                    int equipo = (i+1);
//                    System.out.println(equipoUsuario + "  numerode equipos");
//                    if(equipoUsuario.equalsIgnoreCase(""+equipo) && entro)
//                    {
//                        mensaje = conIp.getLista().get(i).getMensaje();
//                        mensaje.addObserver(this);
//                        estaEnobservador = true;
//                        numequi = ""+equipo;
//                        entro=false;
//                        System.out.println("se conecto el equipoUsuario "+ numequi);
//                        System.out.println("se conecto el equipoUsuario cantidad "+ mensaje.countObservers());
//                        if(mensaje.countObservers()==2)
//                        mensaje.setMensaje("inicioSesion");
//                    }
//                }
//                   entro1Usuario = false;
//                }
         
        while (conectado) {
            try {
               
                // Lee un mensaje enviado por el cliente
                mensajeRecibido = dis.readUTF();

              
                System.out.println(sep.availablePermits()+"hilo esperando");
//                try{
//                sep.acquire();
//                }catch(InterruptedException e)
//                {
//                    System.out.println(e.getMessage());
//                }
                
                 if(entro11)
                {
                for(int i=0;i<28;i++)
                {
                    int equipo = (i+1);
                    if(mensajeRecibido.equalsIgnoreCase(""+equipo) && entro)
                    {      
                        mensaje = conIp.getLista().get(i).getMensaje();
                        mensaje.addObserver(this);
                        estaEnobservador = true;
                        numequi = ""+equipo;
                        entro=false;
                        entro11 = true;
                        System.out.println("se conecto el equipo "+ numequi);
                        System.out.println("se conecto el equipo "+ mensaje.countObservers());
                        if(mensaje.countObservers()==2)
                        mensaje.setMensaje("inicioSesion");
                    }
                }
                entro11=false;
                continue;
                }else
                if(mensajeRecibido.equalsIgnoreCase("novisible"))
                {
                    mensaje.setMensaje(mensajeRecibido);
                    continue;
                }else if(mensajeRecibido.equalsIgnoreCase("visible"))
                {
                    mensaje.setMensaje(mensajeRecibido);
                }
                else
                if(mensajeRecibido.equalsIgnoreCase("abrirPortal"))
                {
                    mensaje.setMensaje(mensajeRecibido);
                    continue;
                }else
                if(mensajeRecibido.equalsIgnoreCase("cerrarPortal"))
                {
                     mensaje.setMensaje(mensajeRecibido);
                    continue;
                }else if(mensajeRecibido.equalsIgnoreCase("oknovisible"))
                {
                    mensaje.setMensaje(mensajeRecibido);
                    continue;
                }else if(mensajeRecibido.equalsIgnoreCase("okvisible"))
                {
                    mensaje.setMensaje(mensajeRecibido);
                    continue;
                }else if(mensajeRecibido.equalsIgnoreCase("okabrirPortal"))
                {
                    mensaje.setMensaje(mensajeRecibido);
                    continue;
                }else if(mensajeRecibido.equalsIgnoreCase("okcerrarPortal"))
                {
                    mensaje.setMensaje(mensajeRecibido);
                    continue;
                }else if(mensajeRecibido.equalsIgnoreCase("chat"))
                {
                    mensaje.setMensaje("okchat");
                    chat = true;
                    continue;
                }else if(mensajeRecibido.equalsIgnoreCase("apagar")) {
                    mensaje.setMensaje(mensajeRecibido);
                    continue;
                } else if(chat = true)
                {
                    mensaje.setMensaje(mensajeRecibido);
                    continue;
                }
                
//               sep.release();
//                verificador1 = verificaArreglo(mensajeRecibido);
                verificador = verificaArreglo(mensajeRecibido);
               System.out.println(verificador+"   entro este mensaje");
                if(verificador.equalsIgnoreCase("1") && estaEnobservador)
                {
                           System.out.println(verificador+"   entro este mensaje mal");
                    String[] s = mensajeRecibido.split("&");
                    Usuario us;
                    us = is.obtener(s[1]);
                    if(us==null)
                    {
//                        mensaje.setMensaje("NA");
                        dos.writeUTF("NA");
                    }else
                    {
                        log.info("encontro usuario especifico");
                        idUsuario = us.getIdUsuario();
                        mensaje.setMensaje(idUsuario+"&"+us.getContraseña()+"&"+us.getPrimerNombre()+"&"+us.getPrimerApellido());
//  dos.writeUTF(us.getIdUsuario()+"&"+us.getContraseña()+"&"+us.getPrimerNombre()+"&"+us.getPrimerApellido());
                    }
                }else if(verificador.equalsIgnoreCase("2") && estaEnobservador)
                {
                    // Pone el mensaje recibido en mensajes para que se notifique
                // a sus observadores que hay un nuevo mensaje.
                System.out.println("cliente desconenctado"+numequi);
                }else if(verificador.equalsIgnoreCase("3") && estaEnobservador)
                {
                    numRegistros = numRegistros+1;
                    log.info("debe enviar verificacion para asignar valores"+ numRegistros);
                     regUsu = new impleRegUsuario();

                    RegUsuario re = new RegUsuario();
                    Calendar c1 =  Calendar.getInstance();
                  
                    re.setIdRegistro(""+numRegistros);
                    
                    re.setFrechaInicio((c1.get(Calendar.DATE)+1)+"/"+(c1.get((Calendar.MONTH))+1)+
                "/"+c1.get(Calendar.YEAR)+"");
                    re.setFechaFinal((c1.get(Calendar.DATE)+1)+"/"+(c1.get((Calendar.MONTH))+1)+
                "/"+c1.get(Calendar.YEAR)+"");
                    re.setEstado("ocupado");
                    re.setIdComputadora(numequi);
                    re.setIdUsuario(idUsuario);

                      System.out.println(re.getIdRegistro()+"&"+re.getFrechaInicio()
                +"&"+re.getFechaFinal()+"&"+re.getEstado()+"&"+re.getIdComputadora()
                +"&"+re.getIdUsuario());


                    regUsu.crearRegUsuario(re);
                    mensaje.setMensaje("ok1038098");
                    log.info("mensaje ok enviado");
                }
                else if(estaEnobservador)
                {
                    System.out.println("admin envio mensajes a los observadores");
                    mensaje.setMensaje(mensajeRecibido);
                    System.out.println("mensajes enviados");
                }else
                {
                    System.out.println("este hilo no fue asignado a un observador reinicie la cesion");
                }
            }catch(IOException e)
            {
                log.info("Cliente con la IP " + socket.getInetAddress().getHostName() + " desconectado.");
                log.error(e.getMessage());
                mensaje.deleteObserver(this);
                mensaje.setMensaje("desconectado");
                conectado = false;
                 new ExcepcionFlujo(e);
            }
            catch (Exception ex) {         
                // Si se ha producido un error al recibir datos del cliente se cierra la conexion con el.
                System.out.println("otra dificultad");
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
