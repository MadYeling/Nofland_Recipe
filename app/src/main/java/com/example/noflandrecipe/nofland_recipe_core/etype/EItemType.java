package com.example.noflandrecipe.nofland_recipe_core.etype;

/**
 * 材料类别
 */
public enum EItemType {
    /**
     * 素材
     */
    MATERIAL("素材"),
    /**
     * 生物
     */
    BIOLOGY("生物"),
    /**
     * 活动
     */
    EVENT("活动");


    EItemType() {
    }

    EItemType(String cnName) {
        this.cnName = cnName;
    }

    private String cnName;

    public String getCnName() {
        return cnName;
    }

    public static EItemType getByCNName(String name) {
        for (EItemType eItemType : EItemType.values()) {
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
