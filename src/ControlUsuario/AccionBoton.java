/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Elelegido
 */
public  class AccionBoton implements ActionListener {

               private String numero;
               private ClienteChat cli;
               private ClienteChat arreg[] = new ClienteChat[20];
//               private boolean controlPortal = true;
//                private boolean controlPortal2 = true;
//                private boolean controlPortal13 = true;
//                private boolean controlPortal14 = true;
//                private boolean controlPortal15 = true;
//                private boolean controlPortal16 = true;
//                private boolean controlPortal17 = true;
//                private boolean controlPortal18 = true;
//                private boolean controlPortal19 = true;
//                private boolean controlPortal20 = true;
                private int numeroEquipo;
                private boolean[] vectorControlPortal;

               public  AccionBoton(String numero,ClienteChat cli,int numeroEquipos)
               {
                   this.cli = cli;
                   this.numero = numero;
                   this.numeroEquipo = numeroEquipos;
                   vectorControlPortal = new boolean[numeroEquipos];
                   for(int i=0;i<numeroEquipos;i++)
                   {
                       vectorControlPortal[i] = true;
                   }
               }

                  public void actionPerformed(ActionEvent e) {

                      for(int i=0;i<numeroEquipo;i++)
                      {
                          if(e.getActionCommand().equalsIgnoreCase(("Equipo "+(i+1))))
                          {
                              metodoControlPortal(i);
                          }
                      }
                      System.out.println("siguio derecho");
//                      if(e.getActionCommand().equalsIgnoreCase("enviar1"))
//                      {
//
//                          if(controlPortal)
//                          {
//                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
//                            {
//                              cli.controlPortal(false);
//                              return;
//                             }
//                              cli.controlPortal(controlPortal);
//                              controlPortal = false;
//                          }else
//                          {
//                              cli.controlPortal(controlPortal);
//                              controlPortal = true;
//                          }
////                          clienteChat cli = new clienteChat(numero);
////                          arreg[0] = cli;
////                          cli.start();
//                      }else if(e.getActionCommand().equalsIgnoreCase("enviar2"))
//                      {
//                           System.out.println("entro en 2");
//                           if(controlPortal2)
//                          {
//                              cli.controlPortal(controlPortal2);
//                              controlPortal2 = false;
//                          }else
//                          {
//                              cli.controlPortal(controlPortal2);
//                              controlPortal2 = true;
//                          }
////                           clienteChat cli = new clienteChat(numero);
////                          arreg[1] = cli;
////                          cli.start();
//                      }else if(e.getActionCommand().equalsIgnoreCase("enviar13"))
//                      {
//
//                          if(controlPortal13)
//                          {
//                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
//                            {
//                              cli.controlPortal(false);
//                              return;
//                             }
//                              cli.controlPortal(controlPortal13);
//                              controlPortal13 = false;
//                          }else
//                          {
//                              cli.controlPortal(controlPortal13);
//                              controlPortal13 = true;
//                          }
////                          clienteChat cli = new clienteChat(numero);
////                          arreg[0] = cli;
////                          cli.start();
//                      }else if(e.getActionCommand().equalsIgnoreCase("enviar14"))
//                      {
//
//                          if(controlPortal14)
//                          {
//                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
//                            {
//                              cli.controlPortal(false);
//                              return;
//                             }
//                              cli.controlPortal(controlPortal14);
//                              controlPortal14 = false;
//                          }else
//                          {
//                              cli.controlPortal(controlPortal14);
//                              controlPortal14 = true;
//                          }
////                          clienteChat cli = new clienteChat(numero);
////                          arreg[0] = cli;
////                          cli.start();
//                      }else if(e.getActionCommand().equalsIgnoreCase("enviar15"))
//                      {
//
//                          if(controlPortal15)
//                          {
//                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
//                            {
//                              cli.controlPortal(false);
//                              return;
//                             }
//                              cli.controlPortal(controlPortal15);
//                              controlPortal15 = false;
//                          }else
//                          {
//                              cli.controlPortal(controlPortal15);
//                              controlPortal15 = true;
//                          }
////                          clienteChat cli = new clienteChat(numero);
////                          arreg[0] = cli;
////                          cli.start();
//                      }else if(e.getActionCommand().equalsIgnoreCase("enviar16"))
//                      {
//
//                          if(controlPortal16)
//                          {
//                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
//                            {
//                              cli.controlPortal(false);
//                              return;
//                             }
//                              cli.controlPortal(controlPortal16);
//                              controlPortal16 = false;
//                          }else
//                          {
//                              cli.controlPortal(controlPortal16);
//                              controlPortal16 = true;
//                          }
////                          clienteChat cli = new clienteChat(numero);
////                          arreg[0] = cli;
////                          cli.start();
//                      }else  if(e.getActionCommand().equalsIgnoreCase("enviar17"))
//                      {
//
//                          if(controlPortal17)
//                          {
//                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
//                            {
//                              cli.controlPortal(false);
//                              return;
//                             }
//                              cli.controlPortal(controlPortal17);
//                              controlPortal17 = false;
//                          }else
//                          {
//                              cli.controlPortal(controlPortal17);
//                              controlPortal17 = true;
//                          }
////                          clienteChat cli = new clienteChat(numero);
////                          arreg[0] = cli;
////                          cli.start();
//                      } else  if(e.getActionCommand().equalsIgnoreCase("enviar18"))
//                      {
//
//                          if(controlPortal18)
//                          {
//                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
//                            {
//                              cli.controlPortal(false);
//                              return;
//                             }
//                              cli.controlPortal(controlPortal18);
//                              controlPortal18 = false;
//                          }else
//                          {
//                              cli.controlPortal(controlPortal18);
//                              controlPortal18 = true;
//                          }
////                          clienteChat cli = new clienteChat(numero);
////                          arreg[0] = cli;
////                          cli.start();
//                      }else if(e.getActionCommand().equalsIgnoreCase("enviar19"))
//                      {
//
//                          if(controlPortal19)
//                          {
//                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
//                            {
//                              cli.controlPortal(false);
//                              return;
//                             }
//                              cli.controlPortal(controlPortal19);
//                              controlPortal19 = false;
//                          }else
//                          {
//                              cli.controlPortal(controlPortal19);
//                              controlPortal19 = true;
//                          }
////                          clienteChat cli = new clienteChat(numero);
////                          arreg[0] = cli;
////                          cli.start();
//                      }else if(e.getActionCommand().equalsIgnoreCase("enviar20"))
//                      {
//
//                          if(controlPortal20)
//                          {
//                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
//                            {
//                              cli.controlPortal(false);
//                              return;
//                             }
//                              cli.controlPortal(controlPortal20);
//                              controlPortal20 = false;
//                          }else
//                          {
//                              cli.controlPortal(controlPortal20);
//                              controlPortal20 = true;
//                          }
////                          clienteChat cli = new clienteChat(numero);
////                          arreg[0] = cli;
////                          cli.start();
//                      }else
//                      {
//                           System.out.println("siguio derecho");
//                      }
                  }
                  public void metodoControlPortal(int numeroboton)
                  {
                    if(vectorControlPortal[numeroboton])
                          {
                              if(cli.estadoRegistro().equalsIgnoreCase("ocupado"))
                            {
                              cli.controlPortal(false);
                              return;
                             }
                              cli.controlPortal(vectorControlPortal[numeroboton]);
                              vectorControlPortal[numeroboton] = false;
                          }else
                          {
                              cli.controlPortal(vectorControlPortal[numeroboton]);
                              vectorControlPortal[numeroboton] = true;
                          }
//                          clienteChat cli = new clienteChat(numero);
//                          arreg[0] = cli;
//                          cli.start();
                  }
        }
