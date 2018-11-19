package com.alming.slumpgen.storage;

import java.util.*;

import com.alming.slumpgen.characters.*;
import com.alming.slumpgen.storage.*;

public class FakeGetCharacters implements GetCharacters {

    private List<RPGCharacter> characters;

    /**
     * Returns fake RPGCharacters
     * @return a List of characters of RPGCharacters
     */
    @Override
    public List<? extends RPGCharacter> getAllCharacters() { 
        if (characters == null) {
            // getFakeRPGCharacters();
            fillFakeFBLCharacters();
        }
        return characters;
    }

    private void fillFakeRPGCharacters() {
        characters = new ArrayList<>();
        characters.add(new RPGCharacter("Andreas"));
        characters.add(new RPGCharacter("Kuken David"));
    }

    private void fillFakeFBLCharacters() {
        characters = new ArrayList<>();
        characters.add(new FBLCharacterBuilder()
            .with(f -> {
                f.name = "Andreas";
            })
            .with(f -> {
                f.nickname = "the boss";
                f.kin = "human";
                f.profession = "pro";
                f.appearance = "nice";
                f.age = "1";
                f.attributes = new HashMap<String, Integer>();
                f.skills = new HashMap<String, Integer>();
                f.talents = new HashMap<String, Integer>();
                f.gear = new ArrayList<String>();
            })
            .createFBLCharacter()
        );
    }
}