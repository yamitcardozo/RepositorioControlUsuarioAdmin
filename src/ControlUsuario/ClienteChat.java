/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import ControlExcepciones.ExcepcionFlujo;
import ControlServidor.userServicio;
import Entidades.Usuario;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import org.apache.log4j.Logger;

/**
 *
 * @author Yamit Cardozo
 */
public class ClienteChat extends Thread
           {
               private Logger log = Logger.getLogger(ClienteChat.class);
               private String numero;
               private Socket socket=null;
               Usuario u;
               AbstractCotrolUsuario a;

               public ClienteChat(String numero, AbstractCotrolUsuario a) throws IOException
               {
                   this.numero = numero;
                   u = new Usuario();
                   this.a = a;

                           if(socket==null)
                {
                        try {

                            log.info(" constructor ClienteChat asignacion de IP");

//                        socket = new Socket("192.168.37.145", 10578);
                         socket = new Socket("localhost", 10578);


                    } catch(NullPointerException e)
                    {
                         log.error("constructor ClienteChat socket nulo" + e.getMessage());
                    } catch(IOException e)
                    {
                        log.error("constructor ClienteChat mala creacion  de socket" + e.toString()+" : "+e.getMessage());
                        log.info("imposible conexion a servidor terminacion programa");
                        throw new IOException();
                    }
                        catch (Exception ex) {
                         new ExcepcionFlujo(ex);
                    }
                }

               }

            /**
                 * se inicia el hilo adminUsuario para enviar mensaje de registro a servidor
                 */
                @Override
                public void run() {
                    DataOutputStream dos=null;
                    try {
                        dos = new DataOutputStream(socket.getOutputStream());
                        dos.writeUTF(numero);
                    } catch (IOException ex) {
                       System.out.println("conexion");
                    }catch (Exception e)
                    {
                        new ExcepcionFlujo(e);
                    }


                   recibirMensajesServidor();
                }

                /**
                 *  se controla la venta cliente, para enviar mensajes sobre si lo abre o lo cierra
                 * @param b
                 */
                public void controlPortal(boolean b)
                {
                     DataOutputStream dos=null;
                    if(b==true)
                    {

                    try {
                        dos = new DataOutputStream(socket.getOutputStream());
                        dos.writeUTF("abrirPortal");
                    } catch (IOException ex) {
                       System.out.println("conexion");
                    }
                    }else
                    {
                         try {
                        dos = new DataOutputStream(socket.getOutputStream());
                        dos.writeUTF("cerrarPortal");
                    } catch (IOException ex) {
                       System.out.println("conexion");
                    }
                    }
                }
                /**
                 *  se cambia estado de disponible, a ocupado
                 * @return
                 */
                public String estadoRegistro()
                {
                    return a.getEstado().getText();
                }
                /**
                 *  el adminUsuario recive los mensajes del servidor
                 */
                 public  void recibirMensajesServidor(){
                    // Obtiene el flujo de entrada del socket
                     DataOutputStream dos=null;

                    DataInputStream entradaDatos = null;
                    String mensaje;
                    userServicio us1111;

                     try {
                        dos = new DataOutputStream(socket.getOutputStream());
                    } catch (IOException ex) {
                       System.out.println(" stream limitado salida de datos");
                    }

                    try {
                        entradaDatos = new DataInputStream(socket.getInputStream());
                    } catch (IOException ex) {
//                        log.error("Error al crear el stream de entrada: " + ex.getMessage());
                    } catch (NullPointerException ex) {
//                        log.error("El socket no se creo correctamente. ");
                    }

                    // Bucle infinito que recibe mensajes del servidor
                    boolean conectado = true;
                    while (conectado) {
                        try {
                            mensaje = entradaDatos.readUTF();


                            if(mensaje.equalsIgnoreCase("inicioSesion"))
                            {

                                continue;
                            }else
                                 if(mensaje.equalsIgnoreCase("novisible"))
                                 {
                                      a.getEstado().setText("ocupado");
                                       dos.writeUTF("oknovisible");
                                      continue;
                                 }
                            else
                                if(mensaje.equalsIgnoreCase("visible"))
                                {
                                     a.getEstado().setText("disponible");
                                       dos.writeUTF("okvisible");
                                      continue;
                                }
                                else
                             if(mensaje.equalsIgnoreCase("abrirPortal"))
                            {
                                continue;
                            }else
                                 if(mensaje.equalsIgnoreCase("cerrarPortal"))
                            {
                                continue;
                            }else if(mensaje.equalsIgnoreCase("okabrirPortal"))
                            {
                                a.getEstado().setText("ocupado");
//                                a.getBoton().setEnabled(true);
                                continue;
                            }else if(mensaje.equalsIgnoreCase("okcerrarPortal"))
                            {
                                 a.getEstado().setText("disponible");
//                                a.getBoton().setEnabled(true);
                                continue;
                            }
                            else if(mensaje.equalsIgnoreCase("desconectado"))
                            {
//                                a.getEstado().setText("disponible");
                                 a.getEstado().setText("------");
                            }
//                            else if(mensaje.equalsIgnoreCase("------"))
//                            {
//                                 a.getEstado().setText("------");
//                            }
                            else
                            if(mensaje.equalsIgnoreCase("ok1038098"))
                            {
                                System.out.println("llego el mensaje ok");
                                continue;
                            }



//                            mensajesChat.append(mensaje + "\n");
//                            System.out.println(mensaje+ "que llego");
//
//
//                            us1111 = new userServicio();
//                            us1111.usuarioDivision(mensaje,u);
//                            a.getEstado().setText("ocupado");
//                            a.getNombre().setText(u.getPrimerNombre()+"."+u.getPrimerApellido());



                        } catch (IOException ex) {
//                            log.error("Error al leer del stream de entrada: " + ex.getMessage());
                            conectado = false;
                        } catch (NullPointerException ex) {
//                            log.error("El socket no se creo correctamente. ");
                            conectado = false;
                        }
                    }
    }
           }