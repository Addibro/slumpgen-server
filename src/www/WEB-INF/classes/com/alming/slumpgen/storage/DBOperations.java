package com.alming.slumpgen.storage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.DatabaseMetaData;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DBOperations {
    
    // location of db
    private static final String DB_LOCATION = "jdbc:sqlite:www/WEB-INF/db/characters.db";
    private static Connection connection;

    public static class CharactersColumnLabels {
        public static final String CHARACTER_ID = "character_id", NAME = "name", NICKNAME = "nickname", KIN = "kin", AGE = "age", CREED = "creed", APPEARANCE = "appearance";
    }

    public static class GearColumnLabels {
        public static final String ITEM = "item";
    }

    public static class AttributesColumnLabels {
        public static final String STRENGTH = "strength", AGILITY = "agility", WITS = "wits", EMPATHY = "empathy";
    }

    public static class SkillsColumnIds {
        public static final String SKILL = "skill", SCORE = "score";

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

    public static ResultSet getCharacterSkillsRS(int i) throws SQLException {
        StringBuilder sql = new StringBuilder("SELECT * FROM has_skills NATURAL JOIN skills WHERE character_id = ? ");
        try  {
            PreparedStatement statement = connection.prepareStatement(sql.toString());
            statement.setInt(1, i);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }


}