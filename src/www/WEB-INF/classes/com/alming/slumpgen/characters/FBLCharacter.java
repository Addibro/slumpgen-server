package com.alming.slumpgen.characters;

import java.util.Map;
import java.util.Collections;
import java.util.List;

public class FBLCharacter {
    private String name;
    private String kin;
    private String creed;
    private Map<String, Integer> attributes;
    private Map<String, Integer> skills;
    private Map<String, Integer> talents;
    private List<String> gear;

    public FBLCharacter(String name,
                        String kin,
                        String creed,
                        Map<String, Integer> attributes,
                        Map<String, Integer> skills,
                        Map<String, Integer> talents,
                        List<String> gear){
                            this.name = name;
                            this.kin = kin;
                            this.creed = creed;
                            this.attributes = attributes;
                            this.skills = skills;
                            this.talents = talents;
                            this.gear = gear;
                        }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return the kin
     */
    public String getKin() {
        return kin;
    }

    /**
     * @return the creed
     */
    public String getCreed() {
        return creed;
    }

    /**
     * @return the attributes
     */
    public Map<String, Integer> getAttributes() {
        return Collections.unmodifiableMap(attributes);
    }

    /**
     * @return the talents
     */
    public Map<String, Integer> getTalents() {
        return Collections.unmodifiableMap(talents);
    }

    /**
     * @return the skills
     */
    public Map<String, Integer> getSkills() {
        return Collections.unmodifiableMap(skills);
    }

    /**
     * @return the gear
     */
    public List<String> getGear() {
        return Collections.unmodifiableList(gear);
    }

    public String toString(){
        return "Name: " + name + "\nAttributes: " + attributes;
    }
}