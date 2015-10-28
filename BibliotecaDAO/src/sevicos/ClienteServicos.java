/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevicos;

import dao.ClienteDAOBD;
import model.Cliente;

/**
 *
 * @author 771400163
 */
public class ClienteServicos {
    public void addCliente (Cliente c){
        new ClienteDAOBD().adicionar(c);
    }
}
