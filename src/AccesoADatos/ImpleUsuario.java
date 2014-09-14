/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoADatos;

import ContenedorDeDatos.DatosArchivo;
import ControlExcepciones.ExcepcionFlujo;
import Entidades.Usuario;
import LogicaDeNegocio.InterfazUsuario;
import java.util.List;

/**
 *
 * @author Elelegido
 */
public class ImpleUsuario implements InterfazUsuario {

    public List<Usuario> obtener() throws ExcepcionFlujo {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *  returna el usuario encontrado con el parametro especificador idUsuario,
     * si no encuentra retorna null
     * @param idUsuario
     * @return
     * @throws ControlExcepciones.ExcepcionFlujo
     */
    public Usuario obtener(String idUsuario) throws ExcepcionFlujo
    {
        DatosArchivo a = new DatosArchivo();
        Usuario u;
        String dato = a.lecturaArchivoid(idUsuario, "archivoServidor.txt");
        if(dato==null) return null;
        String arreglo[] = dato.split("&");
        u = new Usuario(arreglo[0], arreglo[1], arreglo[2], arreglo[3], arreglo[4]);
        return u;
    }

    public Usuario obtenerPorUsuario(String usuario) throws ExcepcionFlujo {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Usuario crear(Usuario u) throws ExcepcionFlujo {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Usuario actualizar(Usuario u) throws ExcepcionFlujo {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void eliminar(Usuario u) throws ExcepcionFlujo {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
