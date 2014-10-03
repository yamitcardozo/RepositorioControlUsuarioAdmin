/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControlServidor;

import ControlUsuario.*;
import ControlServidor.Datos;
import java.util.ArrayList;

/**
 *
 * @author Elelegido
 */
public class IpConectada {

   
    private ArrayList<Datos> lista;

    public IpConectada()
    {
        lista = new ArrayList<Datos>();
    }
    public ArrayList<Datos> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Datos> lista) {
        this.lista = lista;
    }

   public void addLista(MensajeObserver m, String h)
   {
       Datos d = new Datos(m,h);
       lista.add(d);
   }

   public Datos buscarValor(String h)
   {
       if(h==null)
       return null;

       Datos d;
       int cantidad = lista.size();
       if(cantidad!=0)
       {
           for(int i=0;i<cantidad;i++)
           {
                d = lista.get(i);
                String ip = d.getIp();
                MensajeObserver mensaje = d.getMensaje();
                if(ip.equalsIgnoreCase(h))
                {
                    return d;
                }
           }
       }else
       {
           return null;
       }

       return null;
   }
   public boolean existe(String h)
   {
       Datos d = buscarValor(h);
       if(d!=null)
       {
           return true;
       }
       return false;
   }
}