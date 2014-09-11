/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.util.Date;

/**
 *clase de creacion del DTO RegUsuario
 * @author Administrator2
 */
public class RegUsuario {

    // se utiliza string para los numero de identificación ya que no son datos
    // que se utilicen para hacer cálculos matematicos.

    private String idRegistro = "NA";
    private String frechaInicio = "NA";
    private String fechaFinal = "NA";
    private String idUsuario = "NA";

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getFrechaInicio() {
        return frechaInicio;
    }

    public void setFrechaInicio(String frechaInicio) {
        this.frechaInicio = frechaInicio;
    }

    public String getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

   

}
