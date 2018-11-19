package com.web.json;

import java.util.List;
import java.util.StringJoiner;

import com.alming.slumpgen.characters.FBLCharacter;
import com.alming.slumpgen.characters.RPGCharacter;
import static com.web.json.Formatter.newline;
import static com.web.json.Formatter.quote;
import static com.web.json.Formatter.space;
import static com.web.json.Formatter.jsonAttribute;

/**
 * Json formatter
 */

 public class RPGCharacterFormatter implements Formatter<RPGCharacter> {
    private List<RPGCharacter> characters;
    public RPGCharacterFormatter(List<RPGCharacter> characters) {
        this.characters = characters;
    }

    @Override
    public String format(){
        StringBuilder outerJson = new StringBuilder();
        outerJson.append("[\n");
        StringJoiner jsonObjects = new StringJoiner(",", space() + "{" + newline(), space() + "}");
        for (RPGCharacter c : characters) {
            jsonObjects.add(jsonObj(c));
        }
        outerJson.append(jsonObjects.toString());
        outerJson.append("\n]");
        return outerJson.toString();
    }

    @Override
    public String jsonObj(RPGCharacter c) {
        StringBuilder obj = new StringBuilder();
        System.out.println(obj.toString());
        System.out.println(c);
        obj.append(jsonAttribute("name", c.getName()));
        return obj.toString();
    }
 }