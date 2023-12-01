package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GiftConstellationHonourTopModel.class */
public final class GiftConstellationHonourTopModel implements Serializable {
    private int count;
    private int is_hide;
    private int uid = 1;
    private String avatar = "";
    private String name = "";
    private String anchor = "";
    private String anchor_avatar = "";
    private String anchor_name = "";
    private String hall_name = "";
    private String constellation_name = "";

    public final String getAnchor() {
        return this.anchor;
    }

    public final String getAnchor_avatar() {
        return this.anchor_avatar;
    }

    public final String getAnchor_name() {
        return this.anchor_name;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getConstellation_name() {
        return this.constellation_name;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getHall_name() {
        return this.hall_name;
    }

    public final String getName() {
        return this.name;
    }

    public final int getUid() {
        return this.uid;
    }

    public final int is_hide() {
        return this.is_hide;
    }

    public final void setAnchor(String str) {
        Intrinsics.e(str, "<set-?>");
        this.anchor = str;
    }

    public final void setAnchor_avatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.anchor_avatar = str;
    }

    public final void setAnchor_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.anchor_name = str;
    }

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setConstellation_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.constellation_name = str;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setHall_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.hall_name = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setUid(int i) {
        this.uid = i;
    }

    public final void set_hide(int i) {
        this.is_hide = i;
    }
}
