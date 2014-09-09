package ControlUsuario;

import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// servidor


/**
 *
 * @author Administrator2
 */
public class ConectorServer {

     public void iniciar(){
           ServerSocket ss;
        System.out.print("Inicializando servidor... ");
        try {
            ss = new ServerSocket(10578);
            System.out.println("\t[OK]");
            int idSession = 0;
            while (true) {
                Socket socket;
                socket = ss.accept();
                System.out.println("Nueva conexión entrante: "+socket);
                ((hiloEjecucion) new hiloEjecucion(socket, idSession)).start();
                idSession++;
            }

        } catch (/*IOException ex*/ Exception e) {
            //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    /*ServerSocket server;
    Socket socket;
    int puerto = 9000;
    DataOutputStream salida;
    BufferedReader entrada;
    DatosArchivo archivo;

    public void iniciar(){
        archivo = new DatosArchivo();
        String dato;
        String verificado="noverificado";
        try{
            
            server = new ServerSocket(puerto);
            socket = new Socket();
            System.out.println("esperando cliente");
            socket = server.accept();
            
            System.out.println("cliente conectado");
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje  = entrada.readLine();
            dato = archivo.lecturaArchivo(mensaje);
            System.out.println(dato +"  dato de archivo"+mensaje);
            archivo.escrituraArchivo("oscar.11:30.1:30.2014");
            if(dato.equalsIgnoreCase(mensaje)){
                verificado = "verificado";
            }
            salida = new DataOutputStream(socket.getOutputStream());
            salida.writeUTF(verificado + " malongo");
            socket.close();
            
        }catch(Exception e){}
    }*/
}
