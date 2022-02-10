
package dao;

import javax.swing.JOptionPane;
import java.sql.*;
import model.bill;

public class billDao {
    
    
    public static String getid()
    {
        int id = 1;
        
        try
        {
           ResultSet rs =DbOperations.getData("select Max(id) from bill");
           if(rs.next())
           {
               id= rs.getInt(1);
               id = id + 1;
           }
                   
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
        
    }
    
    public static void save(bill Bill){
        String query = "insert into bill values('"+Bill.getId()+"','"+Bill.getName()+"','"+Bill.getMobileNumber()+"','"+Bill.getEmail()+"','"+Bill.getDate()+"','"+Bill.getTatal()+'",'"+Bill.getCreatedBy()+"'   )";
        
    }
}
