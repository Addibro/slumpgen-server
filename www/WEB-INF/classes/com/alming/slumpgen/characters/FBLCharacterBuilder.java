package com.alming.slumpgen.characters;

import com.alming.slumpgen.characters.FBLCharacter;

import java.util.*;
import java.util.function.*;

public class FBLCharacterBuilder {
    public String name;
    public String nickname;
    public String kin;
    public String profession;
    public String appearance;
    public String age;
    public Map<String, String> attributes;
    public Map<String, String> skills;
    public Map<String, String> talents;
    public List<String> gear;

    public FBLCharacterBuilder with(
        Consumer<FBLCharacterBuilder> b) {
            b.accept(this);
            return this;
    }

    public FBLCharacter createFBLCharacter() {
        return new FBLCharacter(name, 
                                nickname, 
                                kin, 
                                profession, 
                                appearance, 
                                age, 
                                attributes, 
                                skills, 
                                talents, 
                                gear);
    }
}