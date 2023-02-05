/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class UserService {
    public static boolean doSignup(User emp)
    {
        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection();
        
        String sql="INSERT INTO users(emailAddress,password,firstName,lastName,status)"+ "VALUES(? ,? ,? ,? ,?);";
        
        try {
            
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1, emp.getEmailAddress());
            preparedStatement.setString(2, emp.getPassword());
            preparedStatement.setString(3, emp.getFirstName());
            preparedStatement.setString(4, emp.getLastName());
            preparedStatement.setInt(5, 1);
            
            int rs = preparedStatement.executeUpdate();

            if(rs!=0)
            {
                result=true;
            }
            
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
            
        }
        
        return result;
    }
}
