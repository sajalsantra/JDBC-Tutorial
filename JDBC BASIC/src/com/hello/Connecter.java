package com.hello;

import java.sql.*;

public class Connecter {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hello";
        String uname = "root";
        String password = "Sajal@123#123";
        String query = "SELECT SNAME, MARKS FROM STUDENT1";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection conn = DriverManager.getConnection(url, uname, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString(1);
                int marks = rs.getInt(2);
                System.out.println(name + " : " + marks);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
