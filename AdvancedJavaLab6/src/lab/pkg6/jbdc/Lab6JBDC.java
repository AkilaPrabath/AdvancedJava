/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg6.jbdc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Akila
 */
public class Lab6JBDC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
       String url ="jdbc:mysql://127.0.0.1:3306/jdbc?useSSL=false&serverTimezone=UTC"; //update connection string
        
        String user = "root";
        String password = "";
        
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Successfully connected");
        
        //insert employee record into database
        Statement stmt = conn.createStatement();
        int rows = stmt.executeUpdate("insert into employee(age,name) values(25,'Akila')");
        System.out.println("Rows inserted = "+ rows);
        
        //update employee record
        rows= stmt.executeUpdate("Update employee set age=26 where name='Akila'");
        System.out.println("Rows updated = "+ rows);
        
        //read employee records
        ResultSet rs = stmt.executeQuery("Select * from employee");
        while(rs.next()){
            System.out.println("Emp Id : " + rs.getInt("id") + ", Name : " + rs.getString("name") + ", Age : " + rs.getInt("age"));
        }
        
        //delete employee record
        rows = stmt.executeUpdate("delete from employee where name = 'Akila'");
        System.out.println("Rows deleted = "+ rows);
    }
    
}
