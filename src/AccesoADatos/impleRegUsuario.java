
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoADatos;

import ContenedorDeDatos.DatosArchivo;
import ControlExcepciones.ExcepcionFlujo;
//import ControlUsuario.DatosArchivo;
import ControlServidor.userServicio;
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
 * @author Yamit Cardozo
 */
public class impleRegUsuario implements InterfazRegUsuario {

    DatosArchivo archi;

    public void impleRegUsuario()
    {
       
    }

    public List<RegUsuario> obtener() throws ExcepcionFlujo {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public RegUsuario obtenerPorCodigo(String idRegistro) throws ExcepcionFlujo {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public RegUsuario crearRegUsuario(RegUsuario s) throws ExcepcionFlujo {
        
         archi = new DatosArchivo();

        System.out.println(s.getIdRegistro()+"&"+s.getFrechaInicio()
                +"&"+s.getFechaFinal()+"&"+s.getEstado()+"&"+s.getIdComputadora()
                +"&"+s.getIdUsuario());

          System.out.println("guardar");
          String hilera = "1"+"&"+s.getFrechaInicio()
                +"&"+s.getFechaFinal()+"&"+s.getEstado()+"&"+s.getIdComputadora()
                +"&"+s.getIdUsuario();

           System.out.println("guardar5");

          archi.escrituraArchivo(hilera,"archivoControl.txt");
        System.out.println("guardo bien");
       
        return s;
    }

    public RegUsuario actualizarRegUsuario(RegUsuario s) throws ExcepcionFlujo {

        System.out.println(s.getIdRegistro()+"&"+s.getFrechaInicio()
                +"&"+s.getFechaFinal()+"&"+s.getEstado()+"&"+s.getIdComputadora()
                +"&"+s.getIdUsuario());
        
        archi.editarArchivoRegi(s, "archivoControl.txt");
        return s;
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