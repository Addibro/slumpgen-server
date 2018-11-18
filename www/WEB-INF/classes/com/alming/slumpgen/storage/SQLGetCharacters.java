package com.alming.slumpgen.storage;

import java.util.*;
import java.util.function.Predicate;
import java.sql.*;

import com.alming.slumpgen.characters.*;
import com.alming.slumpgen.storage.DBOperations;

public class SQLGetCharacters implements GetCharacters {
    private List<RPGCharacter> characters;

    @Override
    public List<RPGCharacter> getAllCharacters() {
        if (characters == null) {
            readFromDB();
        }
        return characters;
    }

    private void readFromDB() {
        characters = new ArrayList<>();
        try {
            ResultSet rs = DBOperations.getAllCharactersRS();
            while (rs.next()) {
                String id       = rs.getString(DBOperations.CharactersColumnIds.CHARACTER_ID);
                String name     = rs.getString(DBOperations.CharactersColumnIds.NAME);
                // String nickname   = rs.getString(DBOperations.CharactersColumnIds.NICKNAME);
                // String kin        = rs.getString(DBOperations.CharactersColumnIds.KIN);
                // String profession = rs.getString(DBOperations.CharactersColumnIds.PROFESSION);
                // String appearance = rs.getString(DBOperations.CharactersColumnIds.APPEARANCE);
                // String age        = rs.getString(DBOperations.CharactersColumnIds.AGE);
                characters.add(new RPGCharacter(name));
            }
        } catch (SQLException e) {
            // throw new SQLException("Error fetching data: " + e.getMessage());
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}