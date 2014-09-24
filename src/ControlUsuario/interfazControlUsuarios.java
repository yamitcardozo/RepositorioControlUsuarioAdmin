/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import ControlExcepciones.ExcepcionFlujo;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.apache.log4j.Logger;

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
        int numeroComputadoras =30;
        int x = 0;
        int y = 0;
        static int r=0;
    public interfazControlUsuarios()
    {
        super("Computadoras en sala de Enfermeria");
       // p = new JScrollPane(this);
        
        equipo = new JLabel("equipo");
        JLabel nombre = new JLabel("nombre");
        JLabel estado = new JLabel("estado");
        JButton b1;

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
            nombre = a.getNombre();
            estado = a.getEstado();
            b1 = a.getBoton();

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

                
            
        }
        JButton b = new JButton("meron");
         gbc.gridx = 0;
         gbc.gridy = (numeroComputadoras+1);
         gbc.gridwidth= 3;
        c.add(b, gbc);
        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
//                adm.visible();
//                adm.capturarDatos();
//                adm.iniciacionSocket();
                r=1;
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(scrollPane);
        this.pack();
        this.setLocation(200, 0);
        //this.setBounds(450, 200,300,200);
        //this.setLocationByPlatform(true);
        this.setVisible(true);
    }


           public static void main(String[] args) throws ExcepcionFlujo {

            interfazControlUsuarios c = new interfazControlUsuarios();
            int i=0;
            while(i==0){
                if(r==1){
             AdminChat a = new AdminChat();
            adm = a;
            adm.recibirMensajesServidor();
            break;
                }
            }     
    }
}
