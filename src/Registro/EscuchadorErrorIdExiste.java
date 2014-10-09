/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Registro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Yamit Cardozo
 */
public class EscuchadorErrorIdExiste implements ActionListener {

      private Timer timer;
      private FrameRegistro frameRegistro;

    public EscuchadorErrorIdExiste(JFrame frameRegistro)
    {
       this.frameRegistro = (FrameRegistro) frameRegistro;
       timer = new Timer(500, this); // cada 10ms llama actionPerformed
       timer.start();
    }

    public void actionPerformed(ActionEvent e) {

        
    }


}
