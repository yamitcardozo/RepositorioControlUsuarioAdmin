/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaDeNegocio;

import ControlExcepciones.ExcepcionFlujo;
import Entidades.Computadora;
import java.util.List;

/**
 * realizacion del CRUD de tranferencia de datos DAO Interfaz y otros metodos.
 * @author Yamit Cardozo
 */
public interface InterfazComputadora {

   /**
    * Entrega todos las computadoras que se encuentran almacenados en el sistema
    * @return
    * @throws ControlExcepciones.ExcepcionFlujo
    */
	public List<Computadora> obtener() throws ExcepcionFlujo;

	/**
     * Entrega los datos de una Computadora dado su id, si la computadora no exite retorna null
     * @param id_computadora
     * @return
     * @throws ControlExcepciones.ExcepcionFlujo
     */
	public Computadora obtenerPorId(String id_computadora) throws ExcepcionFlujo;
    /**
     * permite guardar la computadora pasado como parametro
     * @param computadora
     * @return
     * @throws ControlExcepciones.ExcepcionFlujo
     */
	public Computadora crear(Computadora computadora) throws ExcepcionFlujo;
   /**
    * permite actualizar los valores de la computadora pasado como parametro
    * @param computadora
    * @return
    * @throws ControlExcepciones.ExcepcionFlujo
    */
	public Computadora actualizar(Computadora computadora) throws ExcepcionFlujo;
   /**
    * permite eliminar la computadora  pasado como parametro
    * @param computadora
    * @throws ControlExcepciones.ExcepcionFlujo
    */
	public void eliminar(Computadora computadora) throws ExcepcionFlujo;
   /**
    * permite listar todos las computadoras que esten disponibles
    * @return
    * @throws ControlExcepciones.ExcepcionFlujo
    */
	public List<Computadora> verDispositivoDisponible () throws ExcepcionFlujo;
}
