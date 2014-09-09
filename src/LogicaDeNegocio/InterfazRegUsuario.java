/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaDeNegocio;

import Entidades.RegUsuario;


/**
 * realizacion del CRUD de tranferencia de datos DAO Interfaz.
 * @author Administrator2
 */
public interface InterfazRegUsuario {
    public void crearRegUsuario(RegUsuario s);
    public void actualizarRegUsuario(RegUsuario s,String idUsuario);
    public void borrarRegUsuario(String idUsuario);
    public RegUsuario leerRegUsuario(String idusuario);
}
