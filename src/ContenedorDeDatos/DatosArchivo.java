/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ContenedorDeDatos;

import ControlExcepciones.ExcepcionFlujo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yamit Cardozo
 */
public class DatosArchivo {

     /**
      * archivo escritura y lectura
      */
      private static File archivo = null;
      /**
       * formato de lectura para el archivo
       */
      private FileReader fr = null;
      /**
       * flujo de lectura del formato del archivo
       */
      private BufferedReader br = null;
      /**
       *  formato de escritura para el archivo
       */
      private FileWriter fichero = null;
      /**
       *  flujo de escritura para el archivo
       */
      private PrintWriter pw = null;

      /**
       * retorna la lista contodos los registros de la de la tabla usuario
       * @param Archivo
       * @return
       * @throws ControlExcepciones.ExcepcionFlujo
       */
       public List  lecturaArchivoAll(String Archivo) throws ExcepcionFlujo{

           List<String> l = new ArrayList<String>();
           String linea;
           

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("archivoServidor.txt");
         archivo = new File (Archivo);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         while((linea=br.readLine())!=null){
            l.add(linea);
         }

      }
      catch(Exception e){
         //e.printStackTrace();
          throw new ExcepcionFlujo(e);
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta
         // una excepcion.
         try{
            if( null != fr ){
               fr.close();
            }
         }catch (Exception e2){
            //e2.printStackTrace();
           throw new ExcepcionFlujo(e2);
         }
      }
      return l;
    }

        /**
         * retorna el registro especificado por el campo hilera si no lo encuentra
         * retorna null.
         * @param hilera
         * @param Archivo
         * @return
         * @throws ControlExcepciones.ExcepcionFlujo
         */
        public String  lecturaArchivoid(String hilera,String Archivo) throws ExcepcionFlujo{
        String aux=null;
        String h;
        String subHilera[];
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("archivoServidor.txt");
         archivo = new File (Archivo);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null){
              subHilera = linea.split("&");
              h = subHilera[0];
              if(h.equalsIgnoreCase(hilera))
              {
                  aux = linea;
              }
         }
         
      }
      catch(Exception e){
         //e.printStackTrace();
          throw new ExcepcionFlujo(e);
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            //e2.printStackTrace();
           throw new ExcepcionFlujo(e2);
         }
      }
      return aux;
    }


        
    //public void escrituraArchivo(String dato){
         public void escrituraArchivo(String dato,String Archivo) throws ExcepcionFlujo{

        try
        {
            //fichero = new FileWriter("archivoControl.txt",true);
            fichero = new FileWriter(Archivo,true);
            pw = new PrintWriter(fichero);

                pw.println(dato);

        } catch (Exception e) {
            //e.printStackTrace();
           throw  new ExcepcionFlujo(e);
        } finally {
           try {
           // Nuevamente aprovechamos el finally para
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
             // e2.printStackTrace();
              throw  new ExcepcionFlujo(e2);
           }
        }
    }


}
