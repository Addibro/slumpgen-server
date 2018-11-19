package com.alming.slumpgen.storage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DBOperations {
    
    // location of db
    private static final String DB_LOCATION = "jdbc:sqlite:www/WEB-INF/db/characters.db";
    private static Connection connection;

    public static class CharactersColumnIds {
        public static final int CHARACTER_ID = 1, NAME = 2;
    }

    public static class GearColumnIds {
        public static final int ITEM = 1;
    }

    public static class AttributesColumnIds {
        public static final int STRENGTH = 1;
        public static final int AGILITY = 2;
        public static final int WITS = 3;
        public static final int EMPATHY = 4;
    }

    public static class SkillsColumnIds {
        public static final int SKILL = 1;
        public static final int SCORE = 2;

    }

    public static class TalentsColumnIds {
        public static final int TALENT = 1;
        public static final int SCORE  = 2;
    }
    
    // statically instantiate the connection (like a mini singleton)
    static {
        try {
            connection = DriverManager.getConnection(DB_LOCATION);
            System.out.println("Connection has been established...");
            DatabaseMetaData meta = connection.getMetaData();
            System.out.println("The driver name is: " + meta.getDriverName());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            // TODO throw exception to app in a very nice way
        }
    }


    public static ResultSet getAllCharactersRS() throws SQLException {
        try {
            Statement statement = connection.createStatement();
            // test to get all from character table
            StringBuilder sql = new StringBuilder("SELECT * FROM character NATURAL JOIN attributes");
            return statement.executeQuery(sql.toString());
        } catch (SQLException e) {
            //TODO: handle exception to app in a very nice way
            // throw new SQLException("Error executing the SQL: " + e.getMessage());
            System.err.println(e.getMessage());
            throw e;
        }
    }
}