/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import javax.swing.JOptionPane;
import java.io.File;
/**
 *
 * @author Elii
 */
public class openPdf {
    
    public static void openById(String id)
    {
        try
        {
                 //if(new File("B:\\"+id+".pdf")).exists()) {
            if((new File("B:\\"+id+".pdf")).exists()){
                Process p = Runtime
                            .getRuntime()
                            .exec("rundll32 url.dll,FileProtocolHandler B:\\"+id+".pdf");
                
        }else
            {
                JOptionPane.showMessageDialog(null, "File does not Exists");
            }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
