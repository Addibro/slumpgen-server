package com.alming.slumpgen.__tests__.db;

import com.alming.slumpgen.storage.*;
import com.alming.slumpgen.characters.*;

import java.util.*;

public class TestFakeCharacters {
    public static void main(String[] args) {
        System.out.println("--- TESTING GETTING FAKE CHARACTERS ---");
        testGetFakeFBLCharacters();
    }

    private static void testGetFakeRPGCharacters() {
        List<? extends RPGCharacter> characters = new FakeGetCharacters().getAllCharacters();
        String expected = "[Andreas, Kuken David]";
        String result = characters.toString();

        System.out.println("EXPECTED: " + expected + ", Received: " + result);
    }

    private static void testGetFakeFBLCharacters() {
        List<? extends RPGCharacter> characters = new FakeGetCharacters().getAllCharacters();
        String expected = "[Andreas, THE BOSS]";
        System.out.println(characters);
    }
}