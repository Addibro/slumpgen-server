package com.alming.slumpgen.storage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DBOperations {
    public static class CharactersColumnIds {
        public static final int NAME = 1;
        public static final int NICKNAME = 2;
        public static final int KIN = 3;
        public static final int AGE = 5;
        public static final int PROFESSION = 6;
        public static final int APPEARANCE = 7;
        public static final int GEAR = 8;
        public static final int ATTRIBUTES = 9;
        public static final int SKILLS = 10;
        public static final int TALENTS = 11;
        public static final int ORIGIN = 12;
        public static final int LIFE_EVENTS = 13;
    }

    public static class AppearanceColumnIds {
        public static final int FACE = 1;
        public static final int BODY = 2;
        public static final int CLOTHING = 3;
    }

    public static class GearColumnIds {
        public static final int item = 1;
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

    public static class OriginColumnIds {
        public static final int NAME = 1;
    }

    // location of db
    private static final String DB_LOCATION = "jdbc:sqlite:www/WEB-INF/db/characters.db";
    
    // try connection
    private static Connection connection;

    // statically instantiate the connection (like a mini singleton)
    static {
        try {
            connection = DriverManager.getConnection(DB_LOCATION);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            // TODO throw exception to app in a very nice way
        }
    }


    public static ResultSet getCharacterResultSet() {
        try {
            Statement statement = connection.createStatement();
            StringBuilder sql = new StringBuilder("SELECT * FROM characters;");
            return statement.executeQuery(sql.toString());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            //TODO: handle exception to app in a very nice way
            return null;
        }
    }

}