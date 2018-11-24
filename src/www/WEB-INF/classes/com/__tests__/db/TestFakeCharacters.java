package com.__tests__.db;

import com.alming.slumpgen.storage.*;
import com.alming.slumpgen.characters.FBLCharacter;

import java.util.*;

public class TestFakeCharacters {
    public static void main(String[] args) {
        System.out.println("--- TESTING GETTING FAKE CHARACTERS ---");
        testGetFakeFBLCharacters();
    }

    private static void testGetFakeFBLCharacters() {
        List<FBLCharacter> characters = new FakeGetCharacters().getAllCharacters();
        String expected = "[Andreas, THE BOSS]";
        System.out.println(characters);
    }
}