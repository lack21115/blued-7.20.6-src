package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GoodsWallTaskAwardItemModel.class */
public final class GoodsWallTaskAwardItemModel implements Serializable {
    private String badge = "";
    private String icon = "";
    private String name = "";
    private String type = "";

    public final String getBadge() {
        return this.badge;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final void setBadge(String str) {
        Intrinsics.e(str, "<set-?>");
        this.badge = str;
    }

    public final void setIcon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setType(String str) {
        Intrinsics.e(str, "<set-?>");
        this.type = str;
    }
}
