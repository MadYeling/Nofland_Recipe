package com.example.noflandrecipe.nofland_recipe_core.etype;

public enum ECollectPlace {
    /**
     * 乱石滩
     */
    RIPRAP_BEACH("乱石滩"),
    /**
     * 微风草原
     */
    BREEZE_GRASSLAND("微风草原"),
    /**
     * 落日山
     */
    SUNSET_MOUNTAIN("落日山"),
    /**
     * 裂谷边缘
     */
    RIFT_EDGE("裂谷边缘"),
    /**
     * 碎溪流
     */
    BROKEN_STREAM("碎溪流"),
    /**
     * 火山
     */
    VOLCANO_ECP("火山"),
    /**
     * 陨坑边缘
     */
    CRATER_EDGE("陨坑边缘"),
    /**
     * 微风野地
     */
    BREEZE_FIELD("微风野地"),

    /**
     * 种子培养架
     */
    SEED_CULTURE_RACK("种子培养架"),

    /**
     * 腐朽树干
     */
    ROTTEN_TRUNK("腐朽树干"),

    /**
     * 水培槽
     */
    HYDROPONIC_TANK("水培槽"),
    /**
     * 水果培养架
     */
    _CULTURE_RACK("水果培养架"),
    /**
     * 奇怪树干
     */
    STRANGE_TRUNK("奇怪树干"),
    /**
     * 山岩培养架
     */
    MOUNTAIN_ROCK_CULTURE_RACK("山岩培养架"),
    /**
     * 火山培养架
     */
    VOLCANO_CULTURE_RACK("火山培养架"),
    /**
     * 珊瑚培养架
     */
    CORAL_CULTURE_RACK("珊瑚培养架"),
    /**
     * 风蚀岩培养架
     */
    AEOLIAN_ROCK_CULTURE_RACK("风蚀岩培养架");

    ECollectPlace() {
    }

    ECollectPlace(String cnName) {
        this.cnName = cnName;
    }

    private String cnName;

    public String getCnName() {
        return cnName;
    }

    public static ECollectPlace getByCNName(String name) {
        for (ECollectPlace eCollectPlace : ECollectPlace.values()) {
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
