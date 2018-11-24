package com.web.json;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import com.alming.slumpgen.characters.FBLCharacter;
import com.alming.slumpgen.characters.FBLCharacterBuilder;
import static com.web.json.Formatter.newline;
import static com.web.json.Formatter.quote;
import static com.web.json.Formatter.space;
import static com.web.json.Formatter.jsonAttribute;
import static com.web.json.Formatter.getStringJoiner;

public class FBLCharacterFormatter implements Formatter<FBLCharacter> {
    List<FBLCharacter> characters;

    public FBLCharacterFormatter(List<FBLCharacter> characters) {
        this.characters = characters;
    }

    @Override
    public String format() {
        StringBuilder outerJson = new StringBuilder();
        outerJson.append("[" + newline());
        outerJson.append(characters.stream()
            .map(c -> jsonObj(c))
            .collect(Collectors.joining("," + newline())));
        outerJson.append(newline() + "]");
        return outerJson.toString();
    }

    @Override
    public String jsonObj(FBLCharacter c) {
        StringJoiner obj = getStringJoiner();
        obj.add(jsonAttribute("name", c.getName()));
        obj.add(jsonAttribute("kin", c.getKin()));
        obj.add(jsonAttribute("creed", c.getCreed()));

        // TODO NEW (THIS IS UGLY AF)
        try {
            obj.add(jsonAttribute("attributes", statObj(c.getAttributes())));
        } catch (Exception e) {
            //TODO: handle exception
        }
        try {
            obj.add(jsonAttribute("skills", statObj(c.getSkills())));
        } catch (Exception e) {
            //TODO: handle exception
        }
        
        try {
            obj.add(jsonAttribute("talents", statObj(c.getTalents())));
        } catch (Exception e) {
            //TODO: handle exception
        }
        try {
            obj.add(jsonAttribute("gear", gearObj(c.getGear())));    
        } catch (Exception e) {
            //TODO: handle exception
        }
        return obj.toString();
    }

    private String statObj(Map<String, Integer> stats) {
        StringJoiner output = getStringJoiner();
        for (Map.Entry<String, Integer> stat : stats.entrySet()) {
            output.add(jsonAttribute(stat.getKey(), stat.getValue()));
        }
        return output.toString();
    }

    private String gearObj(List<String> gear) {
        StringJoiner output = getStringJoiner();
        gear.stream().forEach(g -> output.add(g));
        return output.toString();
    }
}