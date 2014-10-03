/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlServidor;

import Entidades.RegUsuario;
import Entidades.Usuario;

/**
 *
 * @author Administrator2
 * es un procesador de mensajes modifica la estructura del mensaje enviado
 */
public class userServicio {

     private RegUsuario RU;
     private Usuario U;

     public userServicio()
     {
         U = new Usuario();
         RU = new RegUsuario();
     }
    /**
     *  particiona los datos y los ubica en su respectivo campo
     * @param mensaje
     * @param u
     */
      public void usuarioDivision(String mensaje, Usuario u)
    {
        String lista[] = mensaje.split("&");
            u.setIdUsuario(lista[0]);
            u.setContraseña(lista[1]);
            u.setPrimerNombre(lista[2]);
            u.setPrimerApellido(lista[3]);
    }

    public RegUsuario getRU() {
        return RU;
    }

    public void setRU(RegUsuario RU) {
        this.RU = RU;
    }

    public Usuario getU() {
        return U;
    }

    public void setU(Usuario U) {
        this.U = U;
    }

    /////////////////////////

    /**
     * recoge el string de mensaje completo y asigna a cada atributo su valor
     */
//    public void asignacionAtributos(String mensaje){
//        int tamaño = mensaje.length();
//        String hilera="";
//        char caracter;
//        int indicador1=0;
//        int indicador2=0;
//        int indicador3=0;
//        for(int i=0;i<tamaño;i++){
//            caracter = mensaje.charAt(i);
//
//            if(caracter=='&'){
//                if(indicador1==0){
//                    RU.setIdUsuario(hilera);
//                    indicador1=1;
//                }else if (indicador2==0){
//                    RU. = hilera;
//                    indicador2=1;
//                }else if(indicador3==0){
//                    FechaInicio = hilera;
//                    indicador3=1;
//                }
//                else{
//                    horaInicio=hilera;
//                }
//                hilera="";
//            }else{
//            hilera=hilera+caracter;
//            }
//        }
//    }

     public void asignacionAtributosUsuario(String mensaje)
     {
         int tamaño = mensaje.length();
         char caracter;
         int indicador=0;
         String hilera="";
         
         for(int i=0;i<tamaño;i++)
         {
            caracter = mensaje.charAt(i);
            if(caracter=='&')
            {
                if(indicador==0)
                {
                    U.setIdUsuario(hilera);
                    indicador=1;
                }else
                {
                    U.setContraseña(hilera);
                }
                hilera="";
            }else
            {
                hilera = hilera+caracter;
            }
         }
     }
}
