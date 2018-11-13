package com.alming.slumpgen.characters;

public class RPGCharacter {
    private String name;

    public RPGCharacter(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
