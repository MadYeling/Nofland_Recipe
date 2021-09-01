package com.example.noflandrecipe.nofland_recipe_core.model;

public class RecipeRecovery {
    /**
     * 一星
     */
    private final int Star1;
    /**
     * 二星
     */
    private final int Star2;
    /**
     * 三星
     */
    private final int Star3;
    /**
     * 彩星
     */
    private final int StarColor;

    public RecipeRecovery(int star1, int star2, int star3, int starColor) {
        Star1 = star1;
        Star2 = star2;
        Star3 = star3;
        StarColor = starColor;
    }

    public int getStar1() {
        return Star1;
    }

    public int getStar2() {
        return Star2;
    }

    public int getStar3() {
        return Star3;
    }

    public int getStarColor() {
        return StarColor;
    }

    @Override
    public String toString() {
        return "RecipeRecovery{" +
                "Star1=" + Star1 +
                ", Star2=" + Star2 +
                ", Star3=" + Star3 +
                ", StarColor=" + StarColor +
                '}';
    }
}
