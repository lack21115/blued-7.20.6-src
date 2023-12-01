package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/ConstellationAnchorUserDataModel.class */
public final class ConstellationAnchorUserDataModel implements Serializable {
    private int count;
    private int is_hide;
    private int uid;
    private String avatar = "";
    private String name = "";

    public final String getAvatar() {
        return this.avatar;
    }

    public final int getCount() {
        return this.count;
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

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setCount(int i) {
        this.count = i;
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
