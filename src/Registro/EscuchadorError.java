/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Registro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author Elelegido
 */
public class EscuchadorError implements ActionListener {

    private Timer timer;
    private FrameRegistro frameRegistro;
    private JTextField[] o  = new JTextField[3];
    private JPasswordField pwtPassword;
    private String aux;

    public EscuchadorError(JFrame frameRegistro)
    {
       this.frameRegistro = (FrameRegistro) frameRegistro;
       timer = new Timer(500, this); // cada 10ms llama actionPerformed
       timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("entro escuchador de error");

        o[0] = frameRegistro.getTxtPrimerNombre();
        o[1] = frameRegistro.getTxtPrimerApellido();
        o[2] = frameRegistro.getTxtUsuario();
        pwtPassword = frameRegistro.getPtwPassword();
      aux = new String(pwtPassword.getPassword());

        JTextField[] f = frameRegistro.getTxtValidacion();

          System.out.println("asignando valores aquiaa"+ aux+" se puso");
        for(int i=0; i<4;i++)
        {
            if(f[i]!=null)
            {
                if(i!=3)
                {
                     System.out.println(i+"colorverde");
                    aux = o[i].getText();
                }else{
                  aux = new String(pwtPassword.getPassword());
                }
                if(!aux.equalsIgnoreCase("") && (f[i].getBackground()==Color.red))
                {
                    System.out.println(aux+"colorverde");
                   f[i].setText("");
                   f[i].setBackground(Color.GREEN);
                }
            }
        }
        
       
        if(!o[0].getText().equalsIgnoreCase("") && (!o[1].getText().equalsIgnoreCase("")) &&
                (!o[2].getText().equalsIgnoreCase("")) && (!aux.equalsIgnoreCase("")))
                {
            System.out.println("entro quitar titulo");
                    frameRegistro.quitarTitulo();
                    frameRegistro.validarUsuario();
                    timer.stop();
                }
        
    }
}
