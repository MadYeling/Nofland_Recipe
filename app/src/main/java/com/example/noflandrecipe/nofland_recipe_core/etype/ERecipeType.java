package com.example.noflandrecipe.nofland_recipe_core.etype;

public enum ERecipeType {
    /**
     * 研制
     */
    DEVELOPMENT("研制"),
    /**
     * 调和
     */
    BLEND("调和"),
    /**
     * 秘方
     */
    SECRET_RECIPE("秘方"),
    /**
     * 活动
     */
    EVENT("活动");


    ERecipeType() {
    }

    ERecipeType(String cnName) {
        this.cnName = cnName;
    }

    private String cnName;

    public String getCnName() {
        return cnName;
    }

    public static ERecipeType getByCNName(String name) {
        for (ERecipeType eItemType : ERecipeType.values()) {
            if (eItemType.cnName.equals(name))
                return eItemType;
        }
        return null;
    }

    @Override
    public String toString() {
        return cnName;
    }
}
