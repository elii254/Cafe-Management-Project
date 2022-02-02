/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
//import java.util.Locale.Category;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.category;
import java.sql.*;
/**
 *
 * @author Elii
 */
public class categoryDao {
    
    public static void save(category Category)
    {
        String query ="insert into category (name) values('"+ Category.getName()+"')";
        DbOperations.setDataorDelete(query, "Category added successfuly");
        
    }
    public static ArrayList<category> getAllRecords()
    {
        ArrayList<category> arrayList = new  ArrayList<>();
        try
        {
            ResultSet rs =DbOperations.getData("select * from category");
            while(rs.next())
            {
                category Category = new category();
                Category.setId(rs.getInt("id"));
                Category.setName(rs.getString("name"));
                arrayList.add(Category);
                 
            }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public  static void delete(String id)
    {
        String query ="delete from category where id='"+id+"' ";
        DbOperations.setDataorDelete(query, "category deleted successfully");
        
    }
   
    
}
