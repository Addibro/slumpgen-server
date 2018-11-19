package com.alming.slumpgen.storage;

import java.util.*;
import java.util.function.Predicate;
import java.sql.*;

import com.alming.slumpgen.characters.*;
import com.alming.slumpgen.storage.DBOperations;

public class SQLGetCharacters implements GetCharacters {
    private List<FBLCharacter> characters;

    @Override
    public List<FBLCharacter> getAllCharacters() {
        if (characters == null) {
            readFromDB();
        }
        return characters;
    }

    private void readFromDB() {
        characters = new ArrayList<>();
        try {
            ResultSet characters = DBOperations.getAllCharactersRS();
            while (characters.next()) {
                int id          = characters.getInt(DBOperations.CharactersColumnIds.CHARACTER_ID);
                String name     = characters.getString(DBOperations.CharactersColumnIds.NAME);
                String nickname = characters.getString(DBOperations.CharactersColumnIds.NICKNAME);
                String strength = characters.getString("strength");
                String agility  = characters.getString("agility");
                String empathy  = characters.getString("wits");
                // String nickname   = rs.getString(DBOperations.CharactersColumnIds.NICKNAME);
                // String kin        = rs.getString(DBOperations.CharactersColumnIds.KIN);
                // String profession = rs.getString(DBOperations.CharactersColumnIds.PROFESSION);
                // String appearance = rs.getString(DBOperations.CharactersColumnIds.APPEARANCE);
                // String age        = rs.getString(DBOperations.CharactersColumnIds.AGE);
                characters.add(new FBLCharacterBuilder().with(c -> {
                    c.name = name;
                }));
            }
        } catch (SQLException e) {
            // throw new SQLException("Error fetching data: " + e.getMessage());
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}