package com.app.pillars.controller;

import com.app.pillars.util.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("api/user/")
public class TestController {


    @Autowired(required = true)
    DBConnection dbConnection;
    @RequestMapping("/users")
    @GetMapping
    public String getName() throws SQLException {
        if(dbConnection.isConnected==false) {
            Connection connection = dbConnection.getConnection();
        }
        else
        {
            String query = "SELECT * FROM user where id=6";

            // create the java statement
            Statement st = dbConnection.connection.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            int id=0;
            while (rs.next()) {
                id = rs.getInt("id");


                // print the results
            }

            st.close();
            return id+"";

        }
        System.out.println(dbConnection.isConnected);
        return  "users";
    }
}
