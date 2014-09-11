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

/**
 *
 * @author Administrator2
 */
public class DatosArchivo {

      private static File archivo = null;
      private FileReader fr = null;
      private BufferedReader br = null;
      private FileWriter fichero = null;
      private PrintWriter pw = null;

   // public String  lecturaArchivo(String hilera){
        public String  lecturaArchivo(String hilera,String Archivo) throws ExcepcionFlujo{
        String aux="NA";
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
             if(linea.equalsIgnoreCase(hilera)){
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
