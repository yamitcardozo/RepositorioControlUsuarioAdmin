/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaDeNegocio;

import ControlExcepciones.ExcepcionFlujo;
import Entidades.Usuario;
import java.util.List;

/**
 * realizacion del CRUD de tranferencia de datos DAO Interfaz y otros metodos.
 * @author Yamit Cardozo
 */
public interface InterfazUsuario {

    /**
     * obtiene todos los usuarios del sistema
     * @return
     * @throws ControlExcepciones.ExcepcionFlujo
     */
    public List<Usuario> obtener() throws ExcepcionFlujo;
    /**
     * obtiene el usuario especificado con idUsuario
     * @param idUsuario
     * @return
     * @throws ControlExcepciones.ExcepcionFlujo
     */
    public Usuario obtener(String idUsuario) throws ExcepcionFlujo;
    /**
     * obtiene el usuario especificado con Usuario
     * @param usuario
     * @return
     * @throws ControlExcepciones.ExcepcionFlujo
     */
    public Usuario obtenerPorUsuario(String usuario) throws ExcepcionFlujo;
    /**
     * permite gurdar un usuario entregado como parametro
     * @param u
     * @return
     * @throws ControlExcepciones.ExcepcionFlujo
     */
    public Usuario crear(Usuario u) throws ExcepcionFlujo;
    /**
     * permite actualizar un usuario entregado como parametro
     * @param u
     * @return
     * @throws ControlExcepciones.ExcepcionFlujo
     */
     public Usuario actualizar(Usuario u) throws ExcepcionFlujo;
     /**
      * elimina el usuario ingresado como parametro
      * @param u
      * @throws ControlExcepciones.ExcepcionFlujo
      */
     public void eliminar(Usuario u) throws ExcepcionFlujo;
}
