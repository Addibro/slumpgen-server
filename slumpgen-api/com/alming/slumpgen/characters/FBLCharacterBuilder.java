package com.alming.slumpgen.characters;

import com.alming.slumpgen.characters.FBLCharacter;

import java.util.*;
import java.util.function.*;

public class FBLCharacterBuilder {
    public String name;
    public String nickname;
    public String kin;
    public String profession;
    public Map appearance;
    public String age;
    public Map attributes;
    public Map skills;
    public Map talents;
    public List gear;

    public FBLCharacterBuilder with(
        Consumer<FBLCharacterBuilder> builderFunction) {
            builderFunction.accept(this);
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