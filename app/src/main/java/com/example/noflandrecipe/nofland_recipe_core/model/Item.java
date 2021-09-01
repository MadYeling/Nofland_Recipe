package com.example.noflandrecipe.nofland_recipe_core.model;

import com.example.noflandrecipe.nofland_recipe_core.etype.ECollectPlace;
import com.example.noflandrecipe.nofland_recipe_core.etype.EHabitat;
import com.example.noflandrecipe.nofland_recipe_core.etype.EItemType;

import java.io.Serializable;

public class Item implements Serializable {
    private final int id;
    private final String name;
    private final EItemType itemType;
    private final EHabitat habitat;
    private final ECollectPlace collectPlace;

    public Item(int id, String name, EItemType itemType, EHabitat habitat, ECollectPlace collectPlace) {
        this.id = id;
        this.name = name;
        this.itemType = itemType;
        this.habitat = habitat;
        this.collectPlace = collectPlace;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EItemType getItemType() {
        return itemType;
    }

    public EHabitat getHabitat() {
        return habitat;
    }

    public ECollectPlace getCollectPlace() {
        return collectPlace;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemType=" + itemType +
                ", habitat=" + habitat +
                ", collectPlace=" + collectPlace +
                '}';
    }
}
