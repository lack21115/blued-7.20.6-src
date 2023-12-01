package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYPersonalProfileMode.class */
public final class YYPersonalProfileMode {
    private final String img;

    public YYPersonalProfileMode(String img) {
        Intrinsics.e(img, "img");
        this.img = img;
    }

    public static /* synthetic */ YYPersonalProfileMode copy$default(YYPersonalProfileMode yYPersonalProfileMode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYPersonalProfileMode.img;
        }
        return yYPersonalProfileMode.copy(str);
    }

    public final String component1() {
        return this.img;
    }

    public final YYPersonalProfileMode copy(String img) {
        Intrinsics.e(img, "img");
        return new YYPersonalProfileMode(img);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof YYPersonalProfileMode) && Intrinsics.a((Object) this.img, (Object) ((YYPersonalProfileMode) obj).img);
    }

    public final String getImg() {
        return this.img;
    }

    public int hashCode() {
        return this.img.hashCode();
    }

    public String toString() {
        return "YYPersonalProfileMode(img=" + this.img + ')';
    }
}
