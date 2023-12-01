package com.blued.android.module.live_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GiftConstellationAwardItemModel.class */
public final class GiftConstellationAwardItemModel {
    private String name = "";
    private String type_name = "";
    private String image = "";

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType_name() {
        return this.type_name;
    }

    public final void setImage(String str) {
        Intrinsics.e(str, "<set-?>");
        this.image = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setType_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.type_name = str;
    }
}
