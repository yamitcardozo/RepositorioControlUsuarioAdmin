/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import ControlChat.AdminChat;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        int numeroComputadoras =28;
        int x = 0;
        int y = 0;
        static int r=0;
        ArrayList<AbstractCotrolUsuario> list;
    public interfazControlUsuarios()
    {
        super("Computadoras en sala de Enfermeria");
       // p = new JScrollPane(this);

       
        equipo = new JLabel("                EQUIPO");
//        equipo = new JLabel("nombre NAuno");
        JLabel nombre = new JLabel("              USUARIO             ");
        // etiqueta de mensaje al servidor
        JLabel lblmensaje = new JLabel("Mensaje");
        JLabel estado = new JLabel("estado");
        JButton b1 = null ;
        JButton btnmensaje = null;
        JPanel panel = null;
         list = new ArrayList<AbstractCotrolUsuario>();
        //colocacion de componentes

         // padre Pane
          final JPanel p12 = new JPanel(new GridBagLayout());
          p12.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
              //hijo Jpane
             JPanel c = new JPanel(new GridBagLayout());
            c.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,0));

        // scroll Jpane padre :D
        JScrollPane scrollPane = new JScrollPane(p12);
        scrollPane.setPreferredSize(new Dimension(900, 600));

            // para el Jpane hijo
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(2, 2, 2, 2);

            gbc.ipadx = 80;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.WEST;

            gbc.gridx = 0;
            gbc.gridy = 0;
            c.add(nombre, gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            c.add(equipo, gbc);
//            c.add(new JButton("rejos"), gbc);

             gbc.gridx = 2;
            gbc.gridy = 0;
            c.add(lblmensaje, gbc);

        // para el Jpane padre
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.insets = new Insets(2, 2, 2, 2);

        gbc1.ipadx = 100;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        p12.add(c,gbc1);
        

        for(int i=1;i<=numeroComputadoras;i++)
        {
            // asignacion de valores componentes
            a= new AbstractCotrolUsuario();
//            equipo = a.getEquipo();
//            equipo.setText(""+i);
//            equipo.setName("lblequipo"+i);
            nombre = a.getNombre();
            nombre.setName("lblnombre"+i);
//            estado = a.getEstado();
//            estado.setName("lblestado"+i);
            b1 = a.getBoton();
            b1.setText("Equipo "+i);
            b1.setActionCommand("Equipo "+i);

            // configuracion boton para enviar mensaje al servidor
            btnmensaje = a.getBotonMensaje();
            btnmensaje.setText("Mensaje "+i);
            btnmensaje.setActionCommand("Mensaje "+i);
            btnmensaje.setEnabled(false);
            

                // Jpane hijo
                panel = a.getPanel();
                panel.setBackground(Color.black);
                panel.setLayout(new GridBagLayout());
                panel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2,2));

                gbc.ipadx = 80;
                gbc.fill = GridBagConstraints.NONE;
                gbc.anchor = GridBagConstraints.WEST;
//                gbc.gridx = 0;
//                c.add(equipo, gbc);
                 gbc.gridx = 0;
                panel.add(nombre, gbc);

//                 gbc.gridx = 2;
//                c.add(estado, gbc);
                 gbc.gridx = 1;
                panel.add(b1, gbc);

                // asignacion lugar ventana a boton enviar mensaje
                gbc.gridx=2;
                panel.add(btnmensaje,gbc);
              
//           // para Jpanepadre
             gbc1.ipadx = 100;
            gbc1.fill = GridBagConstraints.HORIZONTAL;

             gbc1.gridx = 0;
            gbc1.gridy = i;
            p12.add(panel,gbc1);
                  list.add(a);
//
        }
        for(int i=0;i<numeroComputadoras;i++)
        {
            String numeroEquipo = list.get(i).getBoton().getText();
            JButton boto = list.get(i).getBoton();
            JButton botoMensaje = list.get(i).getBotonMensaje();
            ClienteChat cli = null;
            try {
                cli = new ClienteChat((i + 1) + "", list.get(i));
            }catch (IOException e)
            {
               JOptionPane.showMessageDialog(rootPane,"imposible conexion a servidor","Servidor no encontrado",JOptionPane.ERROR_MESSAGE);
               System.exit(1);
            }
            boto.addActionListener(new AccionBoton(numeroEquipo,cli,numeroComputadoras));
            botoMensaje.addActionListener(new AccionBotonMensaje(numeroEquipo,cli,numeroComputadoras));
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
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/images_1.png")).getImage());
        this.setVisible(true);
    }

            public ArrayList<AbstractCotrolUsuario> getList() {
                    return list;
                }

                public void setList(ArrayList<AbstractCotrolUsuario> list) {
                    this.list = list;
                }

                public void mostrarMensajeError(String mensaje,String titulo)
                {
                    JOptionPane.showMessageDialog(rootPane, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
                }
//                public void mostrarMensajeDesconectado(String mensaje, String titulo)
//                {
//                    JOptionPane.showMessageDialog(rootPane, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
//                }
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


            Servidor s = new Servidor();
            s.start();

            interfazControlUsuarios d = new interfazControlUsuarios();

            
           }          
}