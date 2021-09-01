package com.example.noflandrecipe.nofland_recipe_core.model;

public class RecipeSell {
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
     * 营业时间
     */
    private final int Time;
    /**
     * 秒金
     * 秒金=三星生疏价格/时间
     */
    private final float Mj;

    public RecipeSell(int star1, int star2, int star3, int time, float Mj) {
        Star1 = star1;
        Star2 = star2;
        Star3 = star3;
        Time = time;
        this.Mj = Mj;
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

    public int getTime() {
        return Time;
    }

    public float getMj() {
        return Mj;
    }

    @Override
    public String toString() {
        return "RecipeSell{" +
                "Star1=" + Star1 +
                ", Star2=" + Star2 +
                ", Star3=" + Star3 +
                ", Time=" + Time +
                ", Mj=" + Mj +
                '}';
    }
}
