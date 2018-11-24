package com.alming.slumpgen.characters;

import com.alming.slumpgen.characters.FBLCharacter;

import java.util.*;
import java.util.function.*;

public class FBLCharacterBuilder {
    public String name;
    public String kin;
    public String creed;
    public Map<String, Integer> attributes;
    public Map<String, Integer> skills;
    public Map<String, Integer> talents;
    public List<String> gear;

    public FBLCharacterBuilder with(Consumer<FBLCharacterBuilder> b) {
            b.accept(this);
            return this;
    }

    public FBLCharacter createFBLCharacter() {
        return new FBLCharacter(name,  
                                kin, 
                                creed, 
                                attributes, 
                                skills, 
                                talents, 
                                gear);
    }
}