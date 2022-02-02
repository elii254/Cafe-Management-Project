
package dao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.product;
import java.sql.*;


/**
 *
 * @author Elii
 */
public class ProductDao {
    public static void save(product Product)
    {
        String query="insert into product(name,category,price) values('"+Product.getName()+"','"+Product.getCategory()+"','"+Product.getPrice()+"')";
        DbOperations.setDataorDelete(query, "Product inserted successfully");
    }
    
    public static ArrayList<product> getAllRecords()
    {
        ArrayList<product> arraylist = new ArrayList<>();
        try{
            
            ResultSet rs = DbOperations.getData("select *from product");
            while(rs.next())
            {
                product Product=new product();
                Product.setId(rs.getInt("id"));
                Product.setName(rs.getString("name"));
                Product.setCategory(rs.getString("category"));
                Product.setPrice(rs.getString("price"));
                arraylist.add(Product);
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "");
                    
        }
        return arraylist;
    }
    public static void update(product Product)
    {
        String query = "update product set name='"+Product.getName()+"',category ='"+Product.getCategory()+"',price = '"+Product.getPrice()+"' where id = '"+Product.getId()+"'";
        DbOperations.setDataorDelete(query, "Product updated successfully");
        
    }
    public static void delete(String id){
        String delete="delete from product where id='"+id+"' ";
        DbOperations.setDataorDelete(delete, "Product deleted successfully");
    }
}
