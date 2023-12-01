package com.blued.android.module.yy_china.model;

import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYGoodsWallMode.class */
public class YYGoodsWallMode {
    private long beans;
    private String goods_id;
    private String images_static;
    private long jewel;
    private long light;
    private long max_light;
    private String name;
    private ArrayList<SponsorMode> sponsor;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYGoodsWallMode$SponsorMode.class */
    public class SponsorMode {
        private String avatar;
        private String is_sponsor;
        private String name;
        private String send_num;
        private String uid;

        public SponsorMode() {
        }

        public String getAvatar() {
            return this.avatar;
        }

        public String getIs_sponsor() {
            return this.is_sponsor;
        }

        public String getName() {
            return this.name;
        }

        public String getSend_num() {
            return this.send_num;
        }

        public String getUid() {
            return this.uid;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public void setIs_sponsor(String str) {
            this.is_sponsor = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setSend_num(String str) {
            this.send_num = str;
        }

        public void setUid(String str) {
            this.uid = str;
        }
    }

    public long getBeans() {
        return this.beans;
    }

    public String getGoods_id() {
        return this.goods_id;
    }

    public String getImages_static() {
        return this.images_static;
    }

    public long getJewel() {
        return this.jewel;
    }

    public long getLight() {
        return this.light;
    }

    public long getMax_light() {
        return this.max_light;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<SponsorMode> getSponsor() {
        return this.sponsor;
    }

    public void setBeans(long j) {
        this.beans = j;
    }

    public void setGoods_id(String str) {
        this.goods_id = str;
    }

    public void setImages_static(String str) {
        this.images_static = str;
    }

    public void setJewel(long j) {
        this.jewel = j;
    }

    public void setLight(long j) {
        this.light = j;
    }

    public void setMax_light(long j) {
        this.max_light = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSponsor(ArrayList<SponsorMode> arrayList) {
        this.sponsor = arrayList;
    }
}
