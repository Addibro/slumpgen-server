package com.alming.slumpgen.characters;

import java.util.Map;
import java.util.List;

public class FBLCharacter extends RPGCharacter {
    private String nickname;
    private String kin;
    private String profession;
    private String appearance;
    private String age;
    private Map<String, String> attributes;
    private Map<String, String> skills;
    private Map<String, String> talents;
    private List<String> gear;

    public FBLCharacter(String name,
                        String nickname,
                        String kin,
                        String profession,
                        String appearance,
                        String age,
                        Map<String, String> attributes,
                        Map<String, String> skills,
                        Map<String, String> talents,
                        List<String> gear){
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