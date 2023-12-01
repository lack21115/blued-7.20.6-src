package com.blued.android.module.yy_china.model;

import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYGoodsWallListMode.class */
public class YYGoodsWallListMode {
    private YYcollectorMode collector;
    private ArrayList<YYCollectorConfigMode> collector_config;
    private Goods_wallMode goods_wall;
    private long jewel;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYGoodsWallListMode$Goods_wallMode.class */
    public class Goods_wallMode {
        private String jewel;
        private String light_goods_num;
        private ArrayList<YYGoodsWallMode> lights;
        private ArrayList<YYGoodsWallMode> no_lights;

        public Goods_wallMode() {
        }

        public String getJewel() {
            return this.jewel;
        }

        public String getLight_goods_num() {
            return this.light_goods_num;
        }

        public ArrayList<YYGoodsWallMode> getLights() {
            return this.lights;
        }

        public ArrayList<YYGoodsWallMode> getNo_lights() {
            return this.no_lights;
        }

        public void setJewel(String str) {
            this.jewel = str;
        }

        public void setLight_goods_num(String str) {
            this.light_goods_num = str;
        }

        public void setLights(ArrayList<YYGoodsWallMode> arrayList) {
            this.lights = arrayList;
        }

        public void setNo_lights(ArrayList<YYGoodsWallMode> arrayList) {
            this.no_lights = arrayList;
        }
    }

    public YYcollectorMode getCollector() {
        return this.collector;
    }

    public ArrayList<YYCollectorConfigMode> getCollector_config() {
        return this.collector_config;
    }

    public Goods_wallMode getGoods_wall() {
        return this.goods_wall;
    }

    public long getJewel() {
        return this.jewel;
    }

    public void setCollector(YYcollectorMode yYcollectorMode) {
        this.collector = yYcollectorMode;
    }

    public void setCollector_config(ArrayList<YYCollectorConfigMode> arrayList) {
        this.collector_config = arrayList;
    }

    public void setGoods_wall(Goods_wallMode goods_wallMode) {
        this.goods_wall = goods_wallMode;
    }

    public void setJewel(long j) {
        this.jewel = j;
    }
}
