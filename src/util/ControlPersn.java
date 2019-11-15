
package util;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ControlPersn {
    conectoBanco conecta = new conectoBanco();
    public void inserir (ModelPersn mod) {
        try {
            
        conecta. Conecxao();
        PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO persn(first_name, last_name, office, dob,id) values (?, ?, ?, ?,?)");
        pst.setInt(5, mod.getId());
        pst.setString(1, mod.getFirst_name());
        pst.setString(2, mod.getLast_name());
        pst.setString(4, mod.getDob());
        pst.setString(3, mod.getOffice());
        pst.executeUpdate();
        System.out.println("Dados do(a): " + mod.getFirst_name() + "cadastrados");
        
        conecta.desconnecto();
        } catch (SQLException ex){
            System.out.println("Error: " + ex);
            
        }
        
    }
    
}
