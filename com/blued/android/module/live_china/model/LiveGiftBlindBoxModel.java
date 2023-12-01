package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftBlindBoxModel.class */
public final class LiveGiftBlindBoxModel implements Serializable {
    private int current;
    private int show_type = 3;
    private String img = "https://web.bldimg.com/image-manager/1688006140_49352.png";
    private String blind_goods_image = "";
    private String desc = "";
    private int max = 15;
    private String goods_beans = "";
    private String goods_name = "";
    private String goods_image = "";
    private String goods_id = "";

    public final String getBlind_goods_image() {
        return this.blind_goods_image;
    }

    public final int getCurrent() {
        return this.current;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getGoods_beans() {
        return this.goods_beans;
    }

    public final String getGoods_id() {
        return this.goods_id;
    }

    public final String getGoods_image() {
        return this.goods_image;
    }

    public final String getGoods_name() {
        return this.goods_name;
    }

    public final String getImg() {
        return this.img;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getShow_type() {
        return this.show_type;
    }

    public final void setBlind_goods_image(String str) {
        Intrinsics.e(str, "<set-?>");
        this.blind_goods_image = str;
    }

    public final void setCurrent(int i) {
        this.current = i;
    }

    public final void setDesc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.desc = str;
    }

    public final void setGoods_beans(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_beans = str;
    }

    public final void setGoods_id(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_id = str;
    }

    public final void setGoods_image(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_image = str;
    }

    public final void setGoods_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_name = str;
    }

    public final void setImg(String str) {
        Intrinsics.e(str, "<set-?>");
        this.img = str;
    }

    public final void setMax(int i) {
        this.max = i;
    }

    public final void setShow_type(int i) {
        this.show_type = i;
    }
}
