package com.web.json;

import java.util.List;

import com.alming.slumpgen.characters.FBLCharacter;
import com.alming.slumpgen.characters.FBLCharacterBuilder;

public class FBLCharacterFormatter implements Formatter<FBLCharacter> {
    List<FBLCharacter> characters;

    public FBLCharacterFormatter(List<FBLCharacter> characters) {
        this.characters = characters;
    }

    @Override
    public String format() {
        return null;       
    }

    @Override
    public String jsonObj(FBLCharacter c) {
        return null;
    }

}