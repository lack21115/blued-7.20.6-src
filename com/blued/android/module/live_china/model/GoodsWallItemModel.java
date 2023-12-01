package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GoodsWallItemModel.class */
public final class GoodsWallItemModel implements Serializable {
    private int count;
    private int is_hide;
    private int limited;
    private int progress;
    private int goods_id = 1;
    private String goods_image = "";
    private String goods_name = "";
    private String uid = "";
    private String avatar = "";
    private String username = "";
    private String first_time = "";
    private int start = 1;

    public final String getAvatar() {
        return this.avatar;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getFirst_time() {
        return this.first_time;
    }

    public final int getGoods_id() {
        return this.goods_id;
    }

    public final String getGoods_image() {
        return this.goods_image;
    }

    public final String getGoods_name() {
        return this.goods_name;
    }

    public final int getLimited() {
        return this.limited;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getStart() {
        return this.start;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getUsername() {
        return this.username;
    }

    public final int is_hide() {
        return this.is_hide;
    }

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setFirst_time(String str) {
        Intrinsics.e(str, "<set-?>");
        this.first_time = str;
    }

    public final void setGoods_id(int i) {
        this.goods_id = i;
    }

    public final void setGoods_image(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_image = str;
    }

    public final void setGoods_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_name = str;
    }

    public final void setLimited(int i) {
        this.limited = i;
    }

    public final void setProgress(int i) {
        this.progress = i;
    }

    public final void setStart(int i) {
        this.start = i;
    }

    public final void setUid(String str) {
        Intrinsics.e(str, "<set-?>");
        this.uid = str;
    }

    public final void setUsername(String str) {
        Intrinsics.e(str, "<set-?>");
        this.username = str;
    }

    public final void set_hide(int i) {
        this.is_hide = i;
    }
}
