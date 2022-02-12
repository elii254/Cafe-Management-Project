
package dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.bill;

public class billDao {
    
    
    public static String getId()
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
        String query = "insert into bill values('"+Bill.getId()+"',"+Bill.getName()+"','"+Bill.getEmail()+"','"+Bill.getMobileNumber()+"','"+Bill.getTatal()+"','"+Bill.getTatal()+"','"+Bill.getTatal()+"')";
        //String query = "insert into bill values('"+Bill.getId()+"','"+Bill.getName()+"','"+Bill.getMobileNumber()+"','"+Bill.getEmail()+"','"+Bill.getDate()+"','"+Bill.getTatal()+'",'"+Bill.getCreatedBy()+"'   )";
        
    }
    public static ArrayList<bill> getAllRecordsByInc(String date){
        ArrayList<bill> arrayList = new ArrayList<>();
            
        try
        {
            ResultSet rs = DbOperations.getData("select *from bill where date like '%"+date+"%'");
            while(rs.next()){
            bill Bill = new bill();
            Bill.setId(rs.getInt("id"));
            Bill.setName(rs.getString("name"));
            Bill.setMobileNumber(rs.getString("MobileNumber"));
            Bill.setEmail(rs.getString("email"));
            Bill.setDate(rs.getString("date"));
            Bill.setTatal(rs.getString("total"));
            Bill.setCreatedBy(rs.getString("createdby"));
            arrayList.add(Bill);
            
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
     public static ArrayList<bill> getAllRecordsByDec(String date){
        ArrayList<bill> arrayList = new ArrayList<>();
            
        try
        {
            ResultSet rs = DbOperations.getData("select *from bill where date like '%"+date+"%' order by DESC");
            while(rs.next()){
            bill Bill = new bill();
            Bill.setId(rs.getInt("id"));
            Bill.setName(rs.getString("name"));
            Bill.setMobileNumber(rs.getString("MobileNumber"));
            Bill.setEmail(rs.getString("email"));
            Bill.setDate(rs.getString("date"));
            Bill.setTatal(rs.getString("total"));
            Bill.setCreatedBy(rs.getString("createdby"));
            arrayList.add(Bill);
            
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
}
