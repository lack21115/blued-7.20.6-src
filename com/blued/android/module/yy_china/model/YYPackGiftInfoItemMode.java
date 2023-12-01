package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYPackGiftInfoItemMode.class */
public final class YYPackGiftInfoItemMode {
    private final String icon;
    private final String name;

    public YYPackGiftInfoItemMode(String icon, String name) {
        Intrinsics.e(icon, "icon");
        Intrinsics.e(name, "name");
        this.icon = icon;
        this.name = name;
    }

    public static /* synthetic */ YYPackGiftInfoItemMode copy$default(YYPackGiftInfoItemMode yYPackGiftInfoItemMode, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYPackGiftInfoItemMode.icon;
        }
        if ((i & 2) != 0) {
            str2 = yYPackGiftInfoItemMode.name;
        }
        return yYPackGiftInfoItemMode.copy(str, str2);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.name;
    }

    public final YYPackGiftInfoItemMode copy(String icon, String name) {
        Intrinsics.e(icon, "icon");
        Intrinsics.e(name, "name");
        return new YYPackGiftInfoItemMode(icon, name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYPackGiftInfoItemMode) {
            YYPackGiftInfoItemMode yYPackGiftInfoItemMode = (YYPackGiftInfoItemMode) obj;
            return Intrinsics.a((Object) this.icon, (Object) yYPackGiftInfoItemMode.icon) && Intrinsics.a((Object) this.name, (Object) yYPackGiftInfoItemMode.name);
        }
        return false;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.icon.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "YYPackGiftInfoItemMode(icon=" + this.icon + ", name=" + this.name + ')';
    }
}
