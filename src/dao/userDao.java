
package dao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.User;
 

public class userDao {
    public static void save(User user){
        String query=" insert into user (name,email,mobileNumber,address,password,securityQuestion,answer,status)  values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileNumber()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getSecurityQuestion()+"','"+user.getAnswer()+"','false')";
         DbOperations.setDataorDelete(query, "Registered Successfully, Wait for Admin Approval");
    }
    
    public static  User login(String email, String password){
        
        
        User user=null;
        try{
            ResultSet rs = DbOperations.getData("select *from user where email='"+email+"' and password='"+password+"'");
            while(rs.next()){
                user =new User();
                user.setStatus(rs.getString("status"));
            }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    
    
    public static User getSecurityQuestion(String email)
    {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("select *from user where email='"+email+"' ");
            while(rs.next()){
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("Answer"));
                
            }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        return user;
    }
    public static void update(String email, String newPassword) {
        
        String query = "update user set password ='"+newPassword+"' where email='"+email+"'";
        DbOperations.setDataorDelete(query, "Password changed succefully");
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
