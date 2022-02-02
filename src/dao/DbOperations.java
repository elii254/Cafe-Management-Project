
package dao;

import javax.swing.JOptionPane;
import java.sql.*;
public class DbOperations {
    public static void setDataorDelete(String Query, String msg)
    {
        try{
            
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            st.executeUpdate(Query);
            if(!msg.equals(""))
            {
                JOptionPane.showMessageDialog(null, msg);
            }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e,"message",JOptionPane.ERROR_MESSAGE);
            //System.out.println(e);
        }
    }
    public static ResultSet getData(String query){
        
        try{
            Connection con =ConnectionProvider.getCon();
            Statement st =con.createStatement();
            ResultSet rs=st.executeQuery(query);
            return rs;
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e,"message",JOptionPane.ERROR_MESSAGE);
            //System.out.println(e);
            return null;
        }
    }
    
    
    
    
    
    
    
    
}
