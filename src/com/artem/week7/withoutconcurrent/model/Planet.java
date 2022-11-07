package com.artem.week7.withoutconcurrent.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Planet {

    private final Object lock = new Object();
    private final List<CrystalType> crystals = new LinkedList<>();

    public void add(CrystalType crystal) {
        crystals.add(crystal);
    }

    public CrystalType remove(int index) {
        return crystals.remove(index);
    }

    public List<CrystalType> removeAll() {
        List<CrystalType> robotDetails = new ArrayList<>(crystals);
        crystals.clear();
        return robotDetails;
    }

    public int size() {
        return crystals.size();
    }

    public boolean isNotEmpty() {
        return !crystals.isEmpty();
    }

    public Object getLock() {
        return lock;
    }
}
