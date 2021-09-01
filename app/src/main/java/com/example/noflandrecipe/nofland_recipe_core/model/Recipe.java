package com.example.noflandrecipe.nofland_recipe_core.model;

import com.example.noflandrecipe.nofland_recipe_core.etype.EHabitat;
import com.example.noflandrecipe.nofland_recipe_core.etype.ERecipeType;

import java.util.Arrays;
import java.util.List;

public class Recipe {
    /**
     * 编号
     */
    private final int id;
    /**
     * 名称
     */
    private final String name;
    /**
     * 种类
     */
    private final ERecipeType recipeType;
    /**
     * 所属类型
     */
    private final EHabitat habitat;
    /**
     * 炼金配方与研发条件
     */
    private final List<RecipeItem> item;
    /**
     * 营业
     */
    private final RecipeSell Sell;
    /**
     * 回收
     */
    private final RecipeRecovery recovery;

    public Recipe(int id, String name, ERecipeType recipeType, EHabitat habitat, RecipeSell sell, RecipeRecovery recovery, RecipeItem... item) {
        this.id = id;
        this.name = name;
        this.recipeType = recipeType;
        this.habitat = habitat;
        Sell = sell;
        this.recovery = recovery;
        this.item = Arrays.asList(item);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ERecipeType getRecipeType() {
        return recipeType;
    }

    public EHabitat getHabitat() {
        return habitat;
    }

    public RecipeSell getSell() {
        return Sell;
    }

    public RecipeRecovery getRecovery() {
        return recovery;
    }

    public List<RecipeItem> getRecipeItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recipeType=" + recipeType +
                ", habitat=" + habitat +
                ", item=" + item +
                ", Sell=" + Sell +
                ", recovery=" + recovery +
                '}';
    }

    public Recipe haveThisItem(Item item) {
        for (RecipeItem ri : this.item) {
            if (ri.getItem() == item)
                return this;
        }
        return null;
    }
}
