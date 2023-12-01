package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRoomBasicPropItemMode.class */
public final class YYRoomBasicPropItemMode {
    private final String icon;
    private final String img;
    private final int width;

    public YYRoomBasicPropItemMode(String icon, String img, int i) {
        Intrinsics.e(icon, "icon");
        Intrinsics.e(img, "img");
        this.icon = icon;
        this.img = img;
        this.width = i;
    }

    public /* synthetic */ YYRoomBasicPropItemMode(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, i);
    }

    public static /* synthetic */ YYRoomBasicPropItemMode copy$default(YYRoomBasicPropItemMode yYRoomBasicPropItemMode, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = yYRoomBasicPropItemMode.icon;
        }
        if ((i2 & 2) != 0) {
            str2 = yYRoomBasicPropItemMode.img;
        }
        if ((i2 & 4) != 0) {
            i = yYRoomBasicPropItemMode.width;
        }
        return yYRoomBasicPropItemMode.copy(str, str2, i);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.img;
    }

    public final int component3() {
        return this.width;
    }

    public final YYRoomBasicPropItemMode copy(String icon, String img, int i) {
        Intrinsics.e(icon, "icon");
        Intrinsics.e(img, "img");
        return new YYRoomBasicPropItemMode(icon, img, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRoomBasicPropItemMode) {
            YYRoomBasicPropItemMode yYRoomBasicPropItemMode = (YYRoomBasicPropItemMode) obj;
            return Intrinsics.a((Object) this.icon, (Object) yYRoomBasicPropItemMode.icon) && Intrinsics.a((Object) this.img, (Object) yYRoomBasicPropItemMode.img) && this.width == yYRoomBasicPropItemMode.width;
        }
        return false;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getImg() {
        return this.img;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((this.icon.hashCode() * 31) + this.img.hashCode()) * 31) + this.width;
    }

    public String toString() {
        return "YYRoomBasicPropItemMode(icon=" + this.icon + ", img=" + this.img + ", width=" + this.width + ')';
    }
}
