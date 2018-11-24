package com.alming.slumpgen.storage;

import java.util.*;

import com.alming.slumpgen.characters.*;
import com.alming.slumpgen.storage.*;

public class FakeGetCharacters implements GetCharacters<FBLCharacter> {

    private List<FBLCharacter> characters;

    /**
     * Returns fake RPGCharacters
     * @return a List of characters of RPGCharacters
     */
    @Override
    public List<FBLCharacter> getAllCharacters() { 
        if (characters == null) {
            // getFakeRPGCharacters();
            fillFakeFBLCharacters();
        }
        return characters;
    }

    private void fillFakeFBLCharacters() {
        characters = new ArrayList<>();
        characters.add(new FBLCharacterBuilder()
            .with(f -> {
                f.name = "Andreas";
            })
            .with(f -> {
                f.kin = "human";
                f.creed= "pro";
                f.attributes = new HashMap<String, Integer>();
                f.skills = new HashMap<String, Integer>();
                f.talents = new HashMap<String, Integer>();
                f.gear = new ArrayList<String>();
            })
            .createFBLCharacter()
        );
    }
}