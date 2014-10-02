/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import ControlExcepciones.ExcepcionFlujo;
import Entidades.Usuario;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import org.jvnet.substance.skin.SubstanceMagmaLookAndFeel;

/**
 *
 * @author Elelegido
 */
public class interfazControlUsuarios extends JFrame{
        static AdminChat adm;
        ArrayList lista = new ArrayList();
        AbstractCotrolUsuario a;
        JLabel equipo;

    
        JScrollPane p;
        int numeroComputadoras =20;
        int x = 0;
        int y = 0;
        static int r=0;
        ArrayList<AbstractCotrolUsuario> list;
    public interfazControlUsuarios()
    {
        super("Computadoras en sala de Enfermeria");
       // p = new JScrollPane(this);
        
        equipo = new JLabel("equipo");
        JLabel nombre = new JLabel("nombre");
        JLabel estado = new JLabel("estado");
        JButton b1;
         list = new ArrayList<AbstractCotrolUsuario>();
        //colocacion de componentes
//        Container c = getContentPane();
//        c.setLayout( new GridBagLayout());

        final JPanel c = new JPanel(new GridBagLayout());
        c.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JScrollPane scrollPane = new JScrollPane(c);
        scrollPane.setPreferredSize(new Dimension(900, 600));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);

        gbc.ipadx = 100;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        c.add(equipo, gbc);

         gbc.gridx = 1;
        gbc.gridy = 0;
        c.add(nombre, gbc);

         gbc.gridx = 2;
        gbc.gridy = 0;
        c.add(estado, gbc);

       

        for(int i=1;i<=numeroComputadoras;i++)
        {
            a= new AbstractCotrolUsuario();
            equipo = a.getEquipo();
            equipo.setText(""+i);
            equipo.setName("lblequipo"+i);
            nombre = a.getNombre();
            nombre.setName("lblnombre"+i);
            estado = a.getEstado();
            estado.setName("lblestado"+i);
            b1 = a.getBoton();
            b1.setText("enviar"+i);
            b1.setActionCommand("enviar"+i);

                gbc.ipadx = 100;
                gbc.fill = GridBagConstraints.HORIZONTAL;

                gbc.gridx = 0;
                gbc.gridy = i;
                c.add(equipo, gbc);

                 gbc.gridx = 1;
                gbc.gridy = i;
                c.add(nombre, gbc);

                 gbc.gridx = 2;
                gbc.gridy = i;
                c.add(estado, gbc);

                 gbc.gridx = 3;
                gbc.gridy = i;
                c.add(b1, gbc);

                list.add(a);
            
        }
        for(int i=0;i<numeroComputadoras;i++)
        {
            String numeroEquipo = list.get(i).getEquipo().getText();
            JButton boto = list.get(i).getBoton();
            clienteChat cli = new clienteChat((i+1)+"",list.get(i));
            boto.addActionListener(new AccionBoton(numeroEquipo,cli));
            cli.start();
        }
       
//        JButton b = new JButton("meron");
//         gbc.gridx = 0;
//         gbc.gridy = (numeroComputadoras+1);
//         gbc.gridwidth= 3;
//        c.add(b, gbc);
//        b.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
////                adm.visible();
////                adm.capturarDatos();
////                adm.iniciacionSocket();
//                r=1;
//            }
//        });

         

//         new clienteChat("3").start();
//         new clienteChat("4");

         

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(scrollPane);
        this.pack();
        this.setLocation(200, 0);
        //this.setBounds(450, 200,300,200);
        //this.setLocationByPlatform(true);
        this.setVisible(true);
    }

            public ArrayList<AbstractCotrolUsuario> getList() {
                    return list;
                }

                public void setList(ArrayList<AbstractCotrolUsuario> list) {
                    this.list = list;
                }
            /**
             * metodo principal de ejecucion innicio del programa administrador
             * @param args
             * @throws ControlExcepciones.ExcepcionFlujo
             */
           public static void main(String[] args){

             try
            {
                 JFrame.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(new SubstanceMagmaLookAndFeel());
//            SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


            servidor s = new servidor();
            s.start();

            interfazControlUsuarios d = new interfazControlUsuarios();

            
           }


           class AccionBoton implements ActionListener {

               private String numero;
               private clienteChat cli;
               private clienteChat arreg[] = new clienteChat[20];
               private boolean controlPortal = true;
                private boolean controlPortal2 = true;
                private boolean controlPortal13 = true;
                private boolean controlPortal14 = true;
                private boolean controlPortal15 = true;
                private boolean controlPortal16 = true;
                private boolean controlPortal17 = true;
                private boolean controlPortal18 = true;
                private boolean controlPortal19 = true;
                private boolean controlPortal20 = true;

               public  AccionBoton(String numero,clienteChat cli)
               {
                   this.cli = cli;
                   this.numero = numero;
               }

                  public void actionPerformed(ActionEvent e) {

                      if(e.getActionCommand().equalsIgnoreCase("enviar1"))
                      {
                          
                          if(controlPortal)
                          {
                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
                            {
                              cli.controlPortal(false);
                              return;
                             }
                              cli.controlPortal(controlPortal);
                              controlPortal = false;
                          }else
                          {
                              cli.controlPortal(controlPortal);
                              controlPortal = true;
                          }
//                          clienteChat cli = new clienteChat(numero);
//                          arreg[0] = cli;
//                          cli.start();
                      }else if(e.getActionCommand().equalsIgnoreCase("enviar2"))
                      {
                           System.out.println("entro en 2");
                           if(controlPortal2)
                          {
                              cli.controlPortal(controlPortal2);
                              controlPortal2 = false;
                          }else
                          {
                              cli.controlPortal(controlPortal2);
                              controlPortal2 = true;
                          }
//                           clienteChat cli = new clienteChat(numero);
//                          arreg[1] = cli;
//                          cli.start();
                      }else if(e.getActionCommand().equalsIgnoreCase("enviar13"))
                      {

                          if(controlPortal13)
                          {
                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
                            {
                              cli.controlPortal(false);
                              return;
                             }
                              cli.controlPortal(controlPortal13);
                              controlPortal13 = false;
                          }else
                          {
                              cli.controlPortal(controlPortal13);
                              controlPortal13 = true;
                          }
//                          clienteChat cli = new clienteChat(numero);
//                          arreg[0] = cli;
//                          cli.start();
                      }else if(e.getActionCommand().equalsIgnoreCase("enviar14"))
                      {

                          if(controlPortal14)
                          {
                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
                            {
                              cli.controlPortal(false);
                              return;
                             }
                              cli.controlPortal(controlPortal14);
                              controlPortal14 = false;
                          }else
                          {
                              cli.controlPortal(controlPortal14);
                              controlPortal14 = true;
                          }
//                          clienteChat cli = new clienteChat(numero);
//                          arreg[0] = cli;
//                          cli.start();
                      }else if(e.getActionCommand().equalsIgnoreCase("enviar15"))
                      {

                          if(controlPortal15)
                          {
                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
                            {
                              cli.controlPortal(false);
                              return;
                             }
                              cli.controlPortal(controlPortal15);
                              controlPortal15 = false;
                          }else
                          {
                              cli.controlPortal(controlPortal15);
                              controlPortal15 = true;
                          }
//                          clienteChat cli = new clienteChat(numero);
//                          arreg[0] = cli;
//                          cli.start();
                      }else if(e.getActionCommand().equalsIgnoreCase("enviar16"))
                      {

                          if(controlPortal16)
                          {
                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
                            {
                              cli.controlPortal(false);
                              return;
                             }
                              cli.controlPortal(controlPortal16);
                              controlPortal16 = false;
                          }else
                          {
                              cli.controlPortal(controlPortal16);
                              controlPortal16 = true;
                          }
//                          clienteChat cli = new clienteChat(numero);
//                          arreg[0] = cli;
//                          cli.start();
                      }else  if(e.getActionCommand().equalsIgnoreCase("enviar17"))
                      {

                          if(controlPortal17)
                          {
                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
                            {
                              cli.controlPortal(false);
                              return;
                             }
                              cli.controlPortal(controlPortal17);
                              controlPortal17 = false;
                          }else
                          {
                              cli.controlPortal(controlPortal17);
                              controlPortal17 = true;
                          }
//                          clienteChat cli = new clienteChat(numero);
//                          arreg[0] = cli;
//                          cli.start();
                      } else  if(e.getActionCommand().equalsIgnoreCase("enviar18"))
                      {

                          if(controlPortal18)
                          {
                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
                            {
                              cli.controlPortal(false);
                              return;
                             }
                              cli.controlPortal(controlPortal18);
                              controlPortal18 = false;
                          }else
                          {
                              cli.controlPortal(controlPortal18);
                              controlPortal18 = true;
                          }
//                          clienteChat cli = new clienteChat(numero);
//                          arreg[0] = cli;
//                          cli.start();
                      }else if(e.getActionCommand().equalsIgnoreCase("enviar19"))
                      {

                          if(controlPortal19)
                          {
                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
                            {
                              cli.controlPortal(false);
                              return;
                             }
                              cli.controlPortal(controlPortal19);
                              controlPortal19 = false;
                          }else
                          {
                              cli.controlPortal(controlPortal19);
                              controlPortal19 = true;
                          }
//                          clienteChat cli = new clienteChat(numero);
//                          arreg[0] = cli;
//                          cli.start();
                      }else if(e.getActionCommand().equalsIgnoreCase("enviar20"))
                      {

                          if(controlPortal20)
                          {
                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
                            {
                              cli.controlPortal(false);
                              return;
                             }
                              cli.controlPortal(controlPortal20);
                              controlPortal20 = false;
                          }else
                          {
                              cli.controlPortal(controlPortal20);
                              controlPortal20 = true;
                          }
//                          clienteChat cli = new clienteChat(numero);
//                          arreg[0] = cli;
//                          cli.start();
                      }else
                      {
                           System.out.println("siguio derecho");
                      }
                  }

        }
           static class servidor extends Thread
           {

                @Override
                public void run() {

              ConectorServer c = new ConectorServer();
            try {
                c.iniciar();
            } catch (ExcepcionFlujo ex) {
                System.out.println("inicio servidor");
            }
                }

           }

           class clienteChat extends Thread
           {

               private String numero;
               private Socket socket=null;
               Usuario u;
               AbstractCotrolUsuario a;
               
               

               public clienteChat(String numero, AbstractCotrolUsuario a)
               {
                   this.numero = numero;
                   u = new Usuario();
                   this.a = a;

                           if(socket==null)
                {
                    try {

        //                log.info("asignacion de IP");

                    socket = new Socket("192.168.37.145", 10578);
//                     socket = new Socket("localhost", 10578);

        //            log.info("acepto la IP suministrada");

                } catch (Exception ex) {
        //            log.info(" constructor hilosEjecucion declaracion socket");
        //            new ExceptionFlujo(ex);
                    System.out.println("creacion socketc mal");
                }
                }

               }

                @Override
                public void run() {
                    DataOutputStream dos=null;
                    try {
                        dos = new DataOutputStream(socket.getOutputStream());
                        dos.writeUTF(numero);
                    } catch (IOException ex) {
                       System.out.println("conexion");
                    }

                    
                   recibirMensajesServidor();
                }

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
                public String estadoRegistro()
                {
                    return a.getEstado().getText();
                }
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
                                a.getEstado().setText("disponible");
                            }
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
}

