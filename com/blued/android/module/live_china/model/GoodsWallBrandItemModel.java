package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GoodsWallBrandItemModel.class */
public final class GoodsWallBrandItemModel implements Serializable {
    private int goods_count;
    private int is_hide;
    private String goods_image = "";
    private String goods_name = "";
    private String uid = "";
    private String avatar = "";
    private String avatar_frame = "";
    private String username = "";

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getAvatar_frame() {
        return this.avatar_frame;
    }

    public final int getGoods_count() {
        return this.goods_count;
    }

    public final String getGoods_image() {
        return this.goods_image;
    }

    public final String getGoods_name() {
        return this.goods_name;
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

    public final void setAvatar_frame(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar_frame = str;
    }

    public final void setGoods_count(int i) {
        this.goods_count = i;
    }

    public final void setGoods_image(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_image = str;
    }

    public final void setGoods_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_name = str;
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
