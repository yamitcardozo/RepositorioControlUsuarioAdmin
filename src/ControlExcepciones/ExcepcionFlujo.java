/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlExcepciones;

import org.apache.log4j.Logger;
/**
 *
 * @author Administrator2
 */
public class ExcepcionFlujo extends Exception {
     private Logger log = Logger.getLogger(ExcepcionFlujo.class);

    public ExcepcionFlujo(Throwable cause) {
        super(cause);
        log.error(cause.getMessage(),cause);
    }

    public ExcepcionFlujo(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public ExcepcionFlujo(String message) {
        super(message);
        log.error(message,this);
    }

    public ExcepcionFlujo() {
        log.error(this.getMessage(),this);
    }
}
