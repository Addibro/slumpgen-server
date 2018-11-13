package com.alming.slumpgen.storage;

import java.util.function.Predicate;
import java.util.List;

import com.alming.slumpgen.characters.*;

public interface GetCharacters {
    /**
     * @return a List of RPGCharacters
     */
    List<? extends RPGCharacter> getAllCharacters();
}