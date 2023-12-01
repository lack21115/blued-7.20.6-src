package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/RegionModel.class */
public final class RegionModel {
    private final int id;
    private final String image;
    private final String name;
    private final int type;

    public RegionModel(int i, String name, String image, int i2) {
        Intrinsics.e(name, "name");
        Intrinsics.e(image, "image");
        this.id = i;
        this.name = name;
        this.image = image;
        this.type = i2;
    }

    public static /* synthetic */ RegionModel copy$default(RegionModel regionModel, int i, String str, String str2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = regionModel.id;
        }
        if ((i3 & 2) != 0) {
            str = regionModel.name;
        }
        if ((i3 & 4) != 0) {
            str2 = regionModel.image;
        }
        if ((i3 & 8) != 0) {
            i2 = regionModel.type;
        }
        return regionModel.copy(i, str, str2, i2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.image;
    }

    public final int component4() {
        return this.type;
    }

    public final RegionModel copy(int i, String name, String image, int i2) {
        Intrinsics.e(name, "name");
        Intrinsics.e(image, "image");
        return new RegionModel(i, name, image, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RegionModel) {
            RegionModel regionModel = (RegionModel) obj;
            return this.id == regionModel.id && Intrinsics.a((Object) this.name, (Object) regionModel.name) && Intrinsics.a((Object) this.image, (Object) regionModel.image) && this.type == regionModel.type;
        }
        return false;
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

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.id * 31) + this.name.hashCode()) * 31) + this.image.hashCode()) * 31) + this.type;
    }

    public String toString() {
        return "RegionModel(id=" + this.id + ", name=" + this.name + ", image=" + this.image + ", type=" + this.type + ')';
    }
}
