/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PruebasTest;

import ControlUsuario.userServicio;
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

}