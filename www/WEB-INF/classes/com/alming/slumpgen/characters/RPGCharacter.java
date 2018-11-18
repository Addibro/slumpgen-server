package com.alming.slumpgen.characters;

public class RPGCharacter {
    private String name;

    public RPGCharacter(String name){
        this.name = name;
    }

    /**
     * @return the name of the character
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}
