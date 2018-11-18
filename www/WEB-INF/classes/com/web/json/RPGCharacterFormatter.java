package com.web.json;

import java.util.List;

import com.alming.slumpgen.characters.FBLCharacter;
import com.alming.slumpgen.characters.RPGCharacter;
import static com.web.json.Formatter.newline;
import static com.web.json.Formatter.quote;

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
        StringBuilder output = new StringBuilder("[\n");
        for (RPGCharacter c : characters) {
            output.append(jsonObj(c));
        }
        output.append("\n]");
        return output.toString();
    }

    @Override
    public String jsonObj(RPGCharacter c) {
        StringBuilder obj = new StringBuilder("     {" + newline());
        obj.append("     ").append(quote() +  "name" + quote() + ": ").append(quote() + c.getName() + quote()).append(newline());
        obj.append(newline() + "     }");
        return obj.toString();
    }
 }