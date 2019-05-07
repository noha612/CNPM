/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import Control.DAO;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ntnhu
 */
public class TestDAO extends DAO{
    @Test
    public void testGetInstance(){
        //Standard test case 1
        DAO.getInstance();
        Assert.assertNotNull(DAO.con);
    }
}
