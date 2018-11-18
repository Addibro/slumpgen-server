package com.web.json;

import java.util.List;
import java.util.StringJoiner;

import com.alming.slumpgen.characters.FBLCharacter;
import com.alming.slumpgen.characters.FBLCharacterBuilder;
import static com.web.json.Formatter.newline;
import static com.web.json.Formatter.quote;
import static com.web.json.Formatter.space;
import static com.web.json.Formatter.jsonAttribute;

public class FBLCharacterFormatter implements Formatter<FBLCharacter> {
    List<FBLCharacter> characters;

    public FBLCharacterFormatter(List<FBLCharacter> characters) {
        this.characters = characters;
    }

    @Override
    public String format() {
        StringBuilder outerJson = new StringBuilder();
        outerJson.append("[\n");
        StringJoiner jsonObjects = new StringJoiner(",", space() + "{" + newline(), space() + "}");
        for (FBLCharacter c : characters) {
            jsonObjects.add(jsonObj(c));
        }
        outerJson.append(jsonObjects.toString());
        outerJson.append("\n]");
        return outerJson.toString();
    }

    @Override
    public String jsonObj(FBLCharacter c) {
        StringJoiner obj = new StringJoiner(",");
        System.out.println(obj.toString());
        System.out.println(c);
        obj.add(jsonAttribute("name", c.getName()));
        obj.add(jsonAttribute("nickname", c.getNickname()));
        obj.add(jsonAttribute("kin", c.getKin()));
        obj.add(jsonAttribute("profession", c.getProfession()));
        obj.add(jsonAttribute("appearance", c.getAppearance()));
        obj.add(jsonAttribute("age", c.getAge()));

        // TODO NEW (THIS IS UGLY AF)
        try {
            obj.add(jsonAttribute("attributes", c.getAttributes().toString()));
        } catch (Exception e) {
            //TODO: handle exception
        }
        try {
            obj.add(jsonAttribute("skills", c.getSkills().toString()));
        } catch (Exception e) {
            //TODO: handle exception
        }
        
        try {
            obj.add(jsonAttribute("talents", c.getTalents().toString()));
        } catch (Exception e) {
            //TODO: handle exception
        }
        try {
            obj.add(jsonAttribute("gear", c.getGear().toString()));    
        } catch (Exception e) {
            //TODO: handle exception
        }
        return obj.toString();
    }
}