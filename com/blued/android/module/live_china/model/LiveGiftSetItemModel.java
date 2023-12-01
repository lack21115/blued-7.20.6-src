package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftSetItemModel.class */
public final class LiveGiftSetItemModel implements Serializable {
    private int animation;
    private int beans;
    private ArrayList<String> bg_color;
    private int count;
    private int expire_time;
    private int total;
    private String goods_id = "";
    private String image = "";
    private String name = "";
    private String url = "";
    private String bg_img = "";
    private String avatar_frame_url = "";
    private String images_apng = "";
    private String images_gif = "";
    private String images_mp4 = "";
    private String images_static = "";

    public final int getAnimation() {
        return this.animation;
    }

    public final String getAvatar_frame_url() {
        return this.avatar_frame_url;
    }

    public final int getBeans() {
        return this.beans;
    }

    public final ArrayList<String> getBg_color() {
        return this.bg_color;
    }

    public final String getBg_img() {
        return this.bg_img;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getExpire_time() {
        return this.expire_time;
    }

    public final String getGoods_id() {
        return this.goods_id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getImages_apng() {
        return this.images_apng;
    }

    public final String getImages_gif() {
        return this.images_gif;
    }

    public final String getImages_mp4() {
        return this.images_mp4;
    }

    public final String getImages_static() {
        return this.images_static;
    }

    public final String getName() {
        return this.name;
    }

    public final int getTotal() {
        return this.total;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setAnimation(int i) {
        this.animation = i;
    }

    public final void setAvatar_frame_url(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar_frame_url = str;
    }

    public final void setBeans(int i) {
        this.beans = i;
    }

    public final void setBg_color(ArrayList<String> arrayList) {
        this.bg_color = arrayList;
    }

    public final void setBg_img(String str) {
        Intrinsics.e(str, "<set-?>");
        this.bg_img = str;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setExpire_time(int i) {
        this.expire_time = i;
    }

    public final void setGoods_id(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_id = str;
    }

    public final void setImage(String str) {
        Intrinsics.e(str, "<set-?>");
        this.image = str;
    }

    public final void setImages_apng(String str) {
        Intrinsics.e(str, "<set-?>");
        this.images_apng = str;
    }

    public final void setImages_gif(String str) {
        Intrinsics.e(str, "<set-?>");
        this.images_gif = str;
    }

    public final void setImages_mp4(String str) {
        Intrinsics.e(str, "<set-?>");
        this.images_mp4 = str;
    }

    public final void setImages_static(String str) {
        Intrinsics.e(str, "<set-?>");
        this.images_static = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    public final void setUrl(String str) {
        Intrinsics.e(str, "<set-?>");
        this.url = str;
    }
}
