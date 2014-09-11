
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoADatos;

import ControlExcepciones.ExcepcionFlujo;
import ControlUsuario.DatosArchivo;
import ControlUsuario.userServicio;
import Entidades.RegUsuario;
import LogicaDeNegocio.InterfazRegUsuario;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator2
 */
public class impleRegUsuario implements InterfazRegUsuario {

    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private int idSessio;
    private Logger log = Logger.getLogger(ExcepcionFlujo.class);

    public void crearRegUsuario(RegUsuario s){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void actualizarRegUsuario(RegUsuario s, String idUsuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void borrarRegUsuario(String idUsuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public RegUsuario leerRegUsuario(String idusuario) throws ExcepcionFlujo {



        throw new UnsupportedOperationException("Not supported yet.");
    }

}
