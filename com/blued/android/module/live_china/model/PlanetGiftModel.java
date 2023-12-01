package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/PlanetGiftModel.class */
public final class PlanetGiftModel implements Serializable {
    private int count;
    private int id;
    private String name = "";
    private String image = "";

    public final int getCount() {
        return this.count;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setImage(String str) {
        Intrinsics.e(str, "<set-?>");
        this.image = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }
}
