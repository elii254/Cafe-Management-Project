package dao;

import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        try {
            String userTable = "create table user(id int AUTO_INCREMENT primary key, name varchar(200), email varchar(200),mobileNumber varchar(200),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(200),UNIQUE (email))";
            String adminDetails = "insert into user (name,email,mobileNumber,address,password,securityQuestion,answer,status) values('Admin', 'admin@gmail.com','0788453218','india','admin123','who was your childhood hero?','Jesus','true')";
            String categoryTable ="create table category (id int AUTO_INCREMENT primary key, name varchar(200))";
            String productTable ="create table product (id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200))";
            //DbOperations.setDataorDelete(userTable, "User Table created successfully");
            //DbOperations.setDataorDelete(adminDetails, "Admin details added successfully");
           // DbOperations.setDataorDelete(categoryTable, "Category table created successfully");
            DbOperations.setDataorDelete(productTable, "Product table created successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            //  System.out.println(e);
        }
    }

}
