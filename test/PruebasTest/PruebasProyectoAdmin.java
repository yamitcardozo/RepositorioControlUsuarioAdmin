/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PruebasTest;

import ContenedorDeDatos.DatosArchivo;
import ControlExcepciones.ExcepcionFlujo;
import ControlUsuario.userServicio;
import Entidades.RegUsuario;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator2
 */
public class PruebasProyectoAdmin {

    public PruebasProyectoAdmin() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//     @Test
//     public void hello() {}
    @Test
    public void asigancionAtributosLoggueoTest(){
//        userServicio s = new userServicio();
//        s.asignacionAtributos("oscar&mera&28/08/2014&9:30&");
//        assertEquals("oscar",s.getUsuario());
//        assertEquals("mera",s.getContraseña());
//        assertEquals("28/08/2014",s.getFechaInicio());
//        assertEquals("9:30",s.getHoraInicio());
    }
    @Test
    public void asignacionAtributosUsuario()
    {
        userServicio s = new userServicio();
        s.asignacionAtributosUsuario("romerlo&123&");
        assertEquals("romerlo", s.getU().getIdUsuario());
        assertEquals("123",s.getU().getContraseña() );
    }
    @Test
    public void buscarUsuarioId() throws ExcepcionFlujo
    {
        DatosArchivo a = new DatosArchivo();
        String dato = a.lecturaArchivoid("1038098543", "archivoServidor.txt");
        assertEquals("1038098543&joselo&yamit&cardozo&yamit.cardozo", dato);
    }
    @Test
    public void crearRegistro() throws ExcepcionFlujo
    {
        DatosArchivo a = new DatosArchivo();
        RegUsuario re = new RegUsuario();
        Calendar c1 =  Calendar.getInstance();
        re.setIdRegistro("2");
        re.setFrechaInicio((c1.get(Calendar.DATE)+1)+"/"+(c1.get((Calendar.MONTH))+1)+
                "/"+c1.get(Calendar.YEAR)+"");
        re.setFechaFinal(c1.get(Calendar.DATE)+"/"+(c1.get((Calendar.MONTH))+1)+
                "/"+c1.get(Calendar.YEAR)+"");
        re.setEstado("ocupado");
        re.setIdComputadora("1");
        re.setIdUsuario("1234");
          String hilera = re.getIdRegistro()+"&"+re.getFrechaInicio()+"&"+
                  re.getFechaFinal()+"&"+re.getEstado()+"&"+re.getIdComputadora()+
                  "&"+re.getIdUsuario();
        a.escrituraArchivo(hilera, "archivoControl.txt");
        System.out.println("OK");
    }
    @Test
    public void editarArchivo() throws ExcepcionFlujo
    {
        DatosArchivo a = new DatosArchivo();
        RegUsuario re = new RegUsuario();
        Calendar c1 =  Calendar.getInstance();
        re.setIdRegistro("1");
        re.setFrechaInicio((c1.get(Calendar.DATE)+1)+"/"+(c1.get((Calendar.MONTH))+1)+
                "/"+c1.get(Calendar.YEAR)+"");
        re.setFechaFinal(c1.get(Calendar.DATE)+"/"+(c1.get((Calendar.MONTH))+1)+
                "/"+c1.get(Calendar.YEAR)+"");
        re.setEstado("ocupado");
        re.setIdComputadora("1");
        re.setIdUsuario("1234");
        a.editarArchivoRegi(re, "archivoControl.txt");
        System.out.println("OK");
    }
}