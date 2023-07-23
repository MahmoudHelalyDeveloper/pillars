package com.app.pillars.util;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
@Scope("singleton")
public class DBConnection {
    @Autowired
    private DataSource dataSource;

   public  boolean isConnected=false;

   public Connection connection=null;

    @PostConstruct
    public Connection getConnection()  {
        isConnected=true;
        try {
            connection= this.dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            isConnected=false;
            throw new RuntimeException(e);
        }
    }

}
