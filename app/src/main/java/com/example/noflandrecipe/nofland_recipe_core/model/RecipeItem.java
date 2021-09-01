package com.example.noflandrecipe.nofland_recipe_core.model;

import com.example.noflandrecipe.nofland_recipe_core.etype.EResearch;

import java.io.Serializable;

public class RecipeItem implements Serializable {
    /**
     * 素材物品
     */
    private final Item item;
    /**
     * 调制需求数量
     */
    private final int nub;
    /**
     * 研发需求数量
     */
    private final EResearch research;

    public RecipeItem(Item item, int nub, EResearch research) {
        this.item = item;
        this.nub = nub;
        this.research = research;
    }

    public Item getItem() {
        return item;
    }

    public int getNub() {
        return nub;
    }

    public EResearch getResearch() {
        return research;
    }

    @Override
    public String toString() {
        return "RecipeItem{" +
                "item=" + item +
                ", nub=" + nub +
                ", research=" + research +
                '}';
    }
}
