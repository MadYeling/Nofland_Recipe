package com.example.noflandrecipe.nofland_recipe_core.etype;

public enum EResearch {
    /**
     * 大量
     */
    QUANTITY("大量"),
    /**
     * 少量
     */
    LITTLE("少量");

    EResearch() {
    }

    EResearch(String cnName) {
        this.cnName = cnName;
    }

    private String cnName;

    public String getCnName() {
        return cnName;
    }

    public static EResearch getByCNName(String name) {
        for (EResearch eCollectPlace : EResearch.values()) {
            if (eCollectPlace.cnName.equals(name))
                return eCollectPlace;
        }
        return null;
    }

    @Override
    public String toString() {
        return cnName;
    }
}
