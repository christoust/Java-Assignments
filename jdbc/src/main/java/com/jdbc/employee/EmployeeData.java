package com.jdbc.employee;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    private static final String URL = "jdbc:mysql://localhost:3306/employee";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
             Statement statement=connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employee"))
        {
            while (resultSet.next())
            {
                String info = resultSet.getString(3);
                data.add(info);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println(data);
    }
}
