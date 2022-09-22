/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Dao.ClienteDao;

/**
 *
 * @author FRANCO IS
 */
public class Pruebala {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MySQLConexion.getConexion();
        
        ClienteDao dao = new ClienteDao();
        System.out.println(dao.ListarTodos());
    }
    
}
