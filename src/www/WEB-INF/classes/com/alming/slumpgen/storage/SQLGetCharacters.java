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
            ResultSet charRs = DBOperations.getAllCharactersRS();
            while (charRs.next()) {
                int id          = charRs.getInt(DBOperations.CharactersColumnLabels.CHARACTER_ID);
                String name     = charRs.getString(DBOperations.CharactersColumnLabels.NAME);
                String nickname = charRs.getString(DBOperations.CharactersColumnLabels.NICKNAME);
                int strength = charRs.getInt(DBOperations.AttributesColumnLabels.STRENGTH);
                int agility  = charRs.getInt(DBOperations.AttributesColumnLabels.AGILITY);
                int wits     = charRs.getInt(DBOperations.AttributesColumnLabels.WITS);
                int empathy  = charRs.getInt(DBOperations.AttributesColumnLabels.EMPATHY);

                Map<String, Integer> attributes = new HashMap<>();
                attributes.put("strength", strength); 
                attributes.put("agility", agility); 
                attributes.put("wits", wits); 
                attributes.put("empathy", empathy); 
                
                characters.add(new FBLCharacterBuilder().with(c -> {
                    c.name = name;
                    c.nickname = nickname;
                    c.attributes = attributes;
                }).createFBLCharacter());
            }
        } catch (SQLException e) {
            // throw new SQLException("Error fetching data: " + e.getMessage());
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}