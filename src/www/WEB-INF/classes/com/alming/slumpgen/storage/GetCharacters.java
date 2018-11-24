package com.alming.slumpgen.storage;

import java.util.function.Predicate;
import java.util.List;

import com.alming.slumpgen.characters.*;

public interface GetCharacters<T> {
    /**
     * @return a List of RPGCharacters
     */
    List<T> getAllCharacters();
}