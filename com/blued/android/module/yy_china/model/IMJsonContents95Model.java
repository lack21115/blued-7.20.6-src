package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/IMJsonContents95Model.class */
public final class IMJsonContents95Model {
    private final int business;
    private final String extra;
    private final String material;
    private final int type;

    public IMJsonContents95Model(String material, int i, int i2, String extra) {
        Intrinsics.e(material, "material");
        Intrinsics.e(extra, "extra");
        this.material = material;
        this.type = i;
        this.business = i2;
        this.extra = extra;
    }

    public static /* synthetic */ IMJsonContents95Model copy$default(IMJsonContents95Model iMJsonContents95Model, String str, int i, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = iMJsonContents95Model.material;
        }
        if ((i3 & 2) != 0) {
            i = iMJsonContents95Model.type;
        }
        if ((i3 & 4) != 0) {
            i2 = iMJsonContents95Model.business;
        }
        if ((i3 & 8) != 0) {
            str2 = iMJsonContents95Model.extra;
        }
        return iMJsonContents95Model.copy(str, i, i2, str2);
    }

    public final String component1() {
        return this.material;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.business;
    }

    public final String component4() {
        return this.extra;
    }

    public final IMJsonContents95Model copy(String material, int i, int i2, String extra) {
        Intrinsics.e(material, "material");
        Intrinsics.e(extra, "extra");
        return new IMJsonContents95Model(material, i, i2, extra);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMJsonContents95Model) {
            IMJsonContents95Model iMJsonContents95Model = (IMJsonContents95Model) obj;
            return Intrinsics.a((Object) this.material, (Object) iMJsonContents95Model.material) && this.type == iMJsonContents95Model.type && this.business == iMJsonContents95Model.business && Intrinsics.a((Object) this.extra, (Object) iMJsonContents95Model.extra);
        }
        return false;
    }

    public final int getBusiness() {
        return this.business;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getMaterial() {
        return this.material;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.material.hashCode() * 31) + this.type) * 31) + this.business) * 31) + this.extra.hashCode();
    }

    public String toString() {
        return "IMJsonContents95Model(material=" + this.material + ", type=" + this.type + ", business=" + this.business + ", extra=" + this.extra + ')';
    }
}
