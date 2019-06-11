/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.BDEspacos.BDSalas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class BDAuditorioTest {
    
    public BDAuditorioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addauditorio method, of class BDAuditorio.
     */


    /**
     * Test of verifiauditorio method, of class BDAuditorio.
     */
    @Test
    public void testVerifiauditorio() throws Exception {
        System.out.println("verifiauditorio");
        String nome = "São Bernardo";
        String expResult = "null";
        BDAuditorio nd = new BDAuditorio();
        String result = nd.verifiauditorio(nome);
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
}
