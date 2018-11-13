package com.alming.slumpgen.storage;

import java.util.*;

import com.alming.slumpgen.characters.*;
import com.alming.slumpgen.storage.*;

public class FakeGetCharacters implements GetCharacters {

    private List<RPGCharacter> characters;

    @Override
    public List<? extends RPGCharacter> getAllCharacters() {
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

    // private void fillFakeFBLCharacter() {
    //     characters = new ArrayList<>();
    //     characters.add(new FBLCharacter("Andreas", "THE BOSS", "human", "pro", new HashMap<String>(), "1", new HashMap<String>(), new HashMap<String>(), new HashMap<String>(), new ArrayList<String>()));
    // }
}