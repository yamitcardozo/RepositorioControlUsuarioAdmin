/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Registro;

import Validacion.ErrorValidacion;
import Validacion.Registro;
import Validacion.ValidadorEspacionBlanco;
import Validacion.ValidadorUsuario;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Elelegido
 */
public class FrameRegistro extends JFrame implements ActionListener{

    private static FrameRegistro f;
    Registro r=null;
    ValidadorEspacionBlanco val=null;
    ValidadorUsuario valUsu = null;
    ErrorValidacion  erro=null;
    EscuchadorError esErr;

    private final GridBagConstraints constraints;
    private final Border border =
        BorderFactory.createLoweredBevelBorder();
    private final JLabel lblUsuario,lblPassword,lblPrimerNombre,lblPrimerApellido;
    private JTextField[] txtValidacion = new JTextField[4];
    private JTextField txtValidacionTitulo;
    private JTextField txtUsuario,txtPrimerNombre,txtPrimerApellido;
    private JPasswordField ptwPassword;
    private final JButton btnEnviar;

       private JLabel makeLabel(String text) {
        JLabel t = new JLabel(text);
        t.setFont(new Font("Arial",Font.BOLD,18));
        getContentPane().add(t, constraints);
        return t;
       }

       private JTextField makeText() {
        JTextField t = new JTextField(15);
        t.setBorder(border);
        getContentPane().add(t, constraints);
        return t;
       }

       private JPasswordField makePasswordFiel()
    {
        JPasswordField t = new JPasswordField(15);
        t.setBorder(border);
        getContentPane().add(t, constraints);
        return t;
    }

        private JButton makeButton(String caption) {
        JButton b = new JButton();
        b.setActionCommand(caption);
        b.addActionListener(this);
        getContentPane().add(b, constraints);
        return b;
    }

        private JTextField makeTextValidador(String dato) {
        JTextField t = new JTextField(dato);
        t.setEditable(false);
        t.setBorder(border);
        getContentPane().add(t, constraints);
        return t;
       }

       public FrameRegistro()
       {
           int posy=1;

           // padre Pane
          getContentPane().setLayout(new GridBagLayout());
          constraints = new GridBagConstraints();
          constraints.insets = new Insets(20, 5, 20,5);
          constraints.fill = GridBagConstraints.HORIZONTAL;
//          constraints.ipadx = 100;
//          constraints.ipady = 100;

           constraints.gridx = 0;
           constraints.gridy = posy;
           lblPrimerNombre = makeLabel("PrimerNombre");

           constraints.gridx = 1;
           constraints.gridy = posy;
           txtPrimerNombre = makeText();
           txtPrimerNombre.setText("yamit");

           posy=posy+1;
           constraints.gridx = 0;
           constraints.gridy = posy;
           lblPrimerApellido = makeLabel("PrimerApellido");

           constraints.gridx = 1;
           constraints.gridy = posy;
           txtPrimerApellido = makeText();
           txtPrimerApellido.setText("cardozo");

           posy=posy+1;
           constraints.gridx = 0;
           constraints.gridy = posy;
           lblUsuario = makeLabel("Usuario");

           constraints.gridx = 1;
           constraints.gridy = posy;
           txtUsuario = makeText();
           txtUsuario.setText("yamit.cardozo");

           posy=posy+1;
           constraints.gridx = 0;
           constraints.gridy = posy;
           lblPassword = makeLabel("Password");

           constraints.gridx = 1;
           constraints.gridy = posy;
           ptwPassword = makePasswordFiel();
           ptwPassword.setText("1038098543");

           posy=posy+1;
           constraints.gridx = 0;
           constraints.gridy = posy;
           constraints.ipadx = 0;
           constraints.ipady = 0;
           constraints.gridwidth = 2;
           constraints.fill = GridBagConstraints.NONE;
           constraints.anchor = GridBagConstraints.CENTER;
           btnEnviar = makeButton("btnEnviar");
           btnEnviar.setText("Enviar");
           
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
            this.setLocation(200, 0);
            setVisible(true);
       }

        public JTextField[] getTxtValidacion() {
        return txtValidacion;
    }

    public void setTxtValidacion(JTextField[] txtValidacion) {
        this.txtValidacion = txtValidacion;
    }

       public void mostrarFallo(int x, int y)
       {
           if(x>=0 && y>=0){
               constraints.insets = new Insets(20, 5, 20,5);
               constraints.fill = GridBagConstraints.HORIZONTAL;
               constraints.gridx = x;
               constraints.gridy = y;
               constraints.gridwidth = 1;
               txtValidacion[(y-1)] = makeTextValidador("*");
               txtValidacion[(y-1)].setBackground(Color.red);
               txtValidacion[(y-1)].setForeground(Color.WHITE);
           }
       }
       public void mostrarTituloFallo(String dato)
       {
           constraints.insets = new Insets(20, 5, 20,5);
               constraints.fill = GridBagConstraints.HORIZONTAL;
               constraints.gridx = 0;
               constraints.gridy = 0;
               constraints.gridwidth = 3;
               txtValidacionTitulo = makeTextValidador(dato);
               txtValidacionTitulo.setBackground(Color.red);
               txtValidacionTitulo.setForeground(Color.WHITE);
                pack();
       }

       public void quitarTitulo()
       {
           if(txtValidacionTitulo!=null)
           {
           txtValidacionTitulo.setText("");
           txtValidacionTitulo.setBackground(Color.GREEN);
           }
       }
       public JPasswordField getPtwPassword() {
        return ptwPassword;
    }

    public void setPtwPassword(JPasswordField ptwPassword) {
        this.ptwPassword = ptwPassword;
    }

    public JTextField getTxtPrimerApellido() {
        return txtPrimerApellido;
    }

    public void setTxtPrimerApellido(JTextField txtPrimerApellido) {
        this.txtPrimerApellido = txtPrimerApellido;
    }

    public JTextField getTxtPrimerNombre() {
        return txtPrimerNombre;
    }

    public void setTxtPrimerNombre(JTextField txtPrimerNombre) {
        this.txtPrimerNombre = txtPrimerNombre;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public static void main(String[] args)
    {
        f = new FrameRegistro();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("entro boton enviar de registro");

        if(r==null && val==null && erro==null)
        {
        r = new Registro();
        val = new ValidadorEspacionBlanco();
        valUsu = new ValidadorUsuario();
        erro = new ErrorValidacion();
        }

        r.setPrimerNombre(txtPrimerNombre.getText());
        r.setPrimerApellido(txtPrimerApellido.getText());
        r.setUsuario(txtUsuario.getText());
        String password = new String(ptwPassword.getPassword());
        r.setContraseña(password);

        val.Validador(r,f,erro);

        if(!erro.getMensaje().equalsIgnoreCase(""))
        {
            System.out.println("entro boton enviar de registro" + erro.getMensaje());
            mostrarTituloFallo(erro.getMensaje());
        }
          esErr = new EscuchadorError(f);
        erro.setMensaje("");        
    }

    public void validarUsuario()
    {
         esErr = null;

            r.setUsuario(txtUsuario.getText());

            valUsu.Validador(r, f, erro);

            if(!erro.getMensaje().equalsIgnoreCase(""))
            {
                System.out.println("mostro mensaje de usuario repetido");
                if(txtValidacionTitulo==null)
                {
                mostrarTituloFallo(erro.getMensaje());
                }else
                {
                    txtValidacionTitulo.setText(erro.getMensaje());
                    txtValidacionTitulo.setBackground(Color.red);
                }
            }else
            {
                // guardar el usuario especifico
            }
            erro.setMensaje("");
    }
}
