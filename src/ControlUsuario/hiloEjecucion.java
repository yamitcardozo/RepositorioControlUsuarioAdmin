/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlUsuario;

import ControlExcepciones.ExcepcionFlujo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
//import java.util.logging.*; buscar como utilizar 

/**
 *
 * @author Administrator2
 */
public class hiloEjecucion extends Thread {

    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private int idSessio;

    public hiloEjecucion(Socket socket, int id) /*throws IOException*/ {
        this.socket = socket;
        this.idSessio = id;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        }catch (/*IOException ex*/ Exception e) {
            //Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
            new ExcepcionFlujo(e);
        }
    }

    public void desconnectar() {
        try {
            socket.close();
        } catch (/*IOException ex*/ Exception e) {
            //Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
            new ExcepcionFlujo(e);
        }
    }

    @Override
    public void run() {
        DatosArchivo archivoServidor = new DatosArchivo();
        String datosArchivo;
        String accion = "";
        userServicio s = new userServicio();
        try {
           accion = dis.readUTF();
           s.asignacionAtributos(accion);
           datosArchivo = archivoServidor.lecturaArchivo(s.getUsuario()+"&"+s.getContraseña()+"&");
           if(datosArchivo.equalsIgnoreCase(s.getUsuario()+"&"+s.getContraseña()+"&")){
               datosArchivo=datosArchivo+s.getFechaInicio()+"&";
               datosArchivo=datosArchivo+s.getHoraInicio()+"&";
               archivoServidor.escrituraArchivo(datosArchivo);
           }else{
               datosArchivo = "no encontro el usuario especificado";
           }
           

           System.out.println(" datos archivo necesario "+ datosArchivo+"   "+accion );
            if(accion.equals(datosArchivo)){
                System.out.println("El cliente con idSesion "+this.idSessio+" saluda");
                dos.writeUTF(datosArchivo);
            }else{
               dos.writeUTF("error envio de informacion");
            }

        } catch (/*IOException ex*/ Exception e) {
           // Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconnectar();
    }
}
