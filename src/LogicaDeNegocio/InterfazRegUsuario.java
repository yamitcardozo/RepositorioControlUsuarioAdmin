/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaDeNegocio;

import ControlExcepciones.ExcepcionFlujo;
import Entidades.RegUsuario;


/**
 * realizacion del CRUD de tranferencia de datos DAO Interfaz.
 * @author Administrator2
 */
public interface InterfazRegUsuario  {
    public void crearRegUsuario(RegUsuario s) throws ExcepcionFlujo;
    public void actualizarRegUsuario(RegUsuario s,String idUsuario) throws ExcepcionFlujo;
    public void borrarRegUsuario(String idUsuario) throws ExcepcionFlujo;
    public RegUsuario leerRegUsuario(String idusuario) throws ExcepcionFlujo;
}
