package com.alming.slumpgen.storage;

import java.util.*;

import com.alming.slumpgen.characters.*;
import com.alming.slumpgen.storage.*;

public class FakeGetCharacters implements GetCharacters {

    private List<RPGCharacter> characters;

    @Override
    public List<RPGCharacter> getAllCharacters() {
        if (characters == null) {
            // getFakeRPGCharacters();
            fillFakeRPGCharacters();
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
        characters.add(new FBLCharacter("Andreas", "THE BOSS", "human", "pro", new HashMap<>(), "1", new HashMap<>(), new HashMap<>(), new HashMap<>(), new ArrayList<>()));
    }
}