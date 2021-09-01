package com.example.noflandrecipe.nofland_recipe_core.etype;

/**
 * 产地
 */
public enum EHabitat {
    /**
     * 山地
     */
    MOUNTAIN("山地"),
    /**
     * 草原
     */
    PRAIRIE("草原"),
    /**
     * 湖泊
     */
    LAKE("湖泊"),
    /**
     * 火山
     */
    VOLCANO("火山"),
    /**
     * 特殊
     */
    SPECIAL("特殊");

    EHabitat() {
    }

    EHabitat(String cnName) {
        this.cnName = cnName;
    }

    private String cnName;

    public String getCnName() {
        return cnName;
    }

    public static EHabitat getByCNName(String name) {
        for (EHabitat eHabitat : EHabitat.values()) {
            if (eHabitat.cnName.equals(name))
                return eHabitat;
        }
        return null;
    }

    @Override
    public String toString() {
        return cnName;
    }
}
