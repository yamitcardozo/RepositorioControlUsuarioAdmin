
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoADatos;

import ControlExcepciones.ExcepcionFlujo;
//import ControlUsuario.DatosArchivo;
import ControlUsuario.userServicio;
import Entidades.RegUsuario;
import LogicaDeNegocio.InterfazRegUsuario;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator2
 */
public class impleRegUsuario implements InterfazRegUsuario {

    public List<RegUsuario> obtener() throws ExcepcionFlujo {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public RegUsuario obtenerPorCodigo(String idRegistro) throws ExcepcionFlujo {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public RegUsuario crearRegUsuario(RegUsuario s) throws ExcepcionFlujo {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public RegUsuario actualizarRegUsuario(RegUsuario s) throws ExcepcionFlujo {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void borrarRegUsuario(RegUsuario s) throws ExcepcionFlujo {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<RegUsuario> registrosPendientes() throws ExcepcionFlujo {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<RegUsuario> registrosEntreFechas(Date fechaInicial, Date fechaFinal) throws ExcepcionFlujo {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
