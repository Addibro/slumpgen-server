package com.alming.slumpgen.characters;

import java.util.Map;
import java.util.List;

public class FBLCharacter extends RPGCharacter {
    private String nickname;
    private String kin;
    private String profession;
    private Map appearance;
    private String age;
    private Map attributes;
    private Map skills;
    private Map talents;
    private List gear;

    public FBLCharacter(String name,
                        String nickname,
                        String kin,
                        String profession,
                        Map appearance,
                        String age,
                        Map attributes,
                        Map skills,
                        Map talents,
                        List gear){
                            super(name);
                            this.nickname = nickname;
                            this.kin = kin;
                            this.profession = profession;
                            this.appearance = appearance;
                            this.age = age;
                            this.attributes = attributes;
                            this.skills = skills;
                            this.talents = talents;
                            this.gear = gear;
                        }

    public String toString(){
        return super.toString() + " " + nickname;
    }
}