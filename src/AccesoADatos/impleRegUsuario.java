
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

    public void crearRegUsuario(RegUsuario s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void actualizarRegUsuario(RegUsuario s, String idUsuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void borrarRegUsuario(String idUsuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public RegUsuario leerRegUsuario(String idusuario) {


//          DatosArchivo archivoServidor = new DatosArchivo();
//          String datosArchivo;
//          String accion = "";
//         userServicio s = new userServicio();
//          RegUsuario sr = new RegUsuario();
//            try {
//            accion = dis.readUTF();
//            s.asignacionAtributos(accion);
//            datosArchivo = archivoServidor.lecturaArchivo(s.getUsuario()+"&"+s.getContraseña()+"&");
//            if(datosArchivo.equalsIgnoreCase(s.getUsuario()+"&"+s.getContraseña()+"&")){
//                datosArchivo=datosArchivo+s.getFechaInicio()+"&";
//                datosArchivo=datosArchivo+s.getHoraInicio()+"&";
//                archivoServidor.escrituraArchivo(datosArchivo);
//            }else{
//                datosArchivo = "no encontro el usuario especificado";
//            }
//
//
//            log.info(" datos archivo necesario "+ datosArchivo+"   "+accion );
//              if(accion.equals(datosArchivo)){
//                 log.info("El cliente con idSesion "+this.idSessio+" saluda");
//                 dos.writeUTF(datosArchivo);
//             }else{
//                dos.writeUTF("error envio de informacion");
//             }
//
//         } catch (/*IOException ex*/ Exception e) {
////           // Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
//             new ExcepcionFlujo(e);
////        }
////        desconnectar();
//     }
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
