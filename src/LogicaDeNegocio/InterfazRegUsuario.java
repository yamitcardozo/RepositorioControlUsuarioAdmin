/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaDeNegocio;

import ControlExcepciones.ExcepcionFlujo;
import Entidades.RegUsuario;
import java.util.Date;
import java.util.List;


/**
 * realizacion del CRUD de tranferencia de datos DAO Interfaz y otros metodos.
 * @author Yamit Cardozo :)
 */
public interface InterfazRegUsuario  {

    /**
     * entrega todos los registros existentes en la base de datos
     * @return
     * @throws ControlExcepciones.ExcepcionFlujo
     */
    public List<RegUsuario> obtener() throws  ExcepcionFlujo;
    /**
     * entrega el registro con idRegistro si no lo encuentra retorna null
     * @param idRegistro
     * @return
     * @throws ControlExcepciones.ExcepcionFlujo
     */
    public RegUsuario obtenerPorCodigo(String idRegistro) throws ExcepcionFlujo;
    /**
     * guarda el registro  s , retorna el registro guardado
     * @param s
     * @return
     * @throws ControlExcepciones.ExcepcionFlujo
     */
    public RegUsuario crearRegUsuario(RegUsuario s) throws ExcepcionFlujo;
    /**
     * actualiza el registro s, retorna registro actualizado
     * @param s
     * @return
     * @throws ControlExcepciones.ExcepcionFlujo
     */
    public RegUsuario actualizarRegUsuario(RegUsuario s) throws ExcepcionFlujo;
    /**
     * elimina registro s, se le puedenpasar solo el id
     * @param idRegistro
     * @throws ControlExcepciones.ExcepcionFlujo
     */
    public void borrarRegUsuario(RegUsuario s) throws ExcepcionFlujo;

    /**
     * lista todos los registros pendientes
     * @return
     * @throws ControlExcepciones.ExcepcionFlujo
     */
    public List<RegUsuario> registrosPendientes() throws ExcepcionFlujo;
    /**
     * lista todos los registros en ese rango de fecha
     * @param fechaInicial
     * @param fechaFinal
     * @return
     * @throws ControlExcepciones.ExcepcionFlujo
     */
    public List<RegUsuario> registrosEntreFechas(Date fechaInicial,Date fechaFinal) throws ExcepcionFlujo;
}
