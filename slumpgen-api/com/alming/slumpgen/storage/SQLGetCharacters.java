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
            getCharacters();
        }
        return characters;
    }

    private void getCharacters() {
        characters = new ArrayList<>();

        ResultSet rs = DBOperations.getCharacterResultSet();
        try {
            while (rs.next()) {

            }
        } catch (SQLException e) {
            
        }
    }
}