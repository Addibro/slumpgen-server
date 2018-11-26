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
                String kin      = charRs.getString(DBOperations.CharactersColumnLabels.KIN);
                String creed = charRs.getString(DBOperations.CharactersColumnLabels.CREED);
                int strength = charRs.getInt(DBOperations.AttributesColumnLabels.STRENGTH);
                int agility  = charRs.getInt(DBOperations.AttributesColumnLabels.AGILITY);
                int wits     = charRs.getInt(DBOperations.AttributesColumnLabels.WITS);
                int empathy  = charRs.getInt(DBOperations.AttributesColumnLabels.EMPATHY);

                Map<String, Integer> attributes = new HashMap<>();
                attributes.put("strength", strength); 
                attributes.put("agility", agility); 
                attributes.put("wits", wits); 
                attributes.put("empathy", empathy); 

                ResultSet skillsRs = DBOperations.getCharacterSkillsRS(id);
                Map<String, Integer> skills = new HashMap<>();
                while (skillsRs.next()) {
                    String skill = skillsRs.getString(DBOperations.SkillsColumnIds.SKILL);
                    int score = skillsRs.getInt(DBOperations.SkillsColumnIds.SCORE);
                    skills.put(skill, score);
                }
                
                characters.add(new FBLCharacterBuilder().with(c -> {
                    c.name = name;
                    c.kin = kin;
                    c.creed = creed;
                    c.attributes = attributes;
                    c.skills = skills;
                }).createFBLCharacter());
            }
        } catch (SQLException e) {
            // throw new SQLException("Error fetching data: " + e.getMessage());
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}