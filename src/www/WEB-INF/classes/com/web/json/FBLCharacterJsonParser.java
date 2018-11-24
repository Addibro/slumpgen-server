package com.web.json;

import java.util.ArrayList;
import java.util.List;

import com.alming.slumpgen.characters.FBLCharacterBuilder;
import com.alming.slumpgen.characters.FBLCharacter;

import org.json.*;

public class FBLCharacterJsonParser implements JsonParser<FBLCharacter> {

    @Override
    public List<FBLCharacter> parse(String json) {
        List<FBLCharacter> characters = new ArrayList<>();
        JSONTokener jt = new JSONTokener(json);
        JSONArray outerJson = new JSONArray(jt);
        for (int i = 0; i < outerJson.length(); i++) {
            JSONObject obj = outerJson.getJSONObject(i);
            String name = obj.getString("name");
            characters.add(new FBLCharacterBuilder().with(c -> {
                c.name = name;
            }).createFBLCharacter());
        }
        return characters;
    }
}