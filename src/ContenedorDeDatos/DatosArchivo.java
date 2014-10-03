/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ContenedorDeDatos;

import ControlExcepciones.ExcepcionFlujo;
import Entidades.RegUsuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yamit Cardozo
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
               fr=null;
            }
            if(null != br)
            {
                br.close();
                br=null;
            }
            if(archivo!=null)
            {
                archivo=null;
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
             System.out.println("guardar2"+dato);
            //fichero = new FileWriter("archivoControl.txt",true);
            fichero = new FileWriter(Archivo,true);
            pw = new PrintWriter(fichero);
             System.out.println("guardar3"+dato);

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

         /**
          *  editar un registro de algun archivo, para el registro especifico
          * @param hilera
          * @param Archivo
          * @throws ControlExcepciones.ExcepcionFlujo
          */
  public void editarArchivoRegi(RegUsuario reg,String Archivo) throws ExcepcionFlujo
  {
              String linea;
              String aux=null;
              String h;
              String subHilera[];
              File fichero1;
 try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("archivoServidor.txt");
         archivo = new File (Archivo);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);


         // perteneciente al archivo1 auxiliar
         fichero1 = new File("aux11.txt"); 
         if(fichero1.createNewFile())
         {
             System.out.println("fichero1 creado correctamente");
         }else
         {
             System.out.println("error en la creacion de fichero1");
         }
         fichero = new FileWriter(fichero1);
         pw = new PrintWriter(fichero);
 


         // Lectura y escritura de ficheros
         while((linea=br.readLine())!=null){
             
             subHilera = linea.split("&");
              h = subHilera[0];
              if(h.equalsIgnoreCase(reg.getIdRegistro()))
              {
                  aux = reg.getIdRegistro()+"&"+reg.getFrechaInicio()+"&"+
                          reg.getFechaFinal()+"&"+reg.getEstado()+"&"+
                          reg.getIdComputadora()+"&"+reg.getIdUsuario();
                 
                  pw.println(aux);
                  continue;
              }
              pw.println(linea);
         }

        //elimina archivo especifico principal para ser editado
              if( null != fr ){
               fr.close();
              }
              if( null != br ){
               br.close();
               }
               if(archivo.delete()){
              System.out.println("archivo eliminado"+archivo);
               }else
               {
                    System.out.println("no eliminado");
               }


           // se crea una intancia de archivo en blanco y se cierra buffer de lectura de aux
          pw.close();
           archivo = new File("archivoControl.txt");
        


           // se renombre el fiche au por archivoControl
            boolean renombrado=fichero1.renameTo(archivo);
            if(renombrado)
            {
                System.out.println("renombrado correctamente");
            }else
            {
                System.out.println("no renombrado");
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
             // se cierra todo buffer o instancias abiertas
             if(null!=pw){
                 pw.close();
             }

              if (null != fichero)
              fichero.close();

            if( null != fr ){
               fr.close();
            }

              if( null != br ){
               br.close();
            }

         }catch (Exception e2){
            //e2.printStackTrace();
           throw new ExcepcionFlujo(e2);
         }
      }
  }
}
