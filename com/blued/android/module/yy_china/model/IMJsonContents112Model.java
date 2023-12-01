package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/IMJsonContents112Model.class */
public final class IMJsonContents112Model {
    private final String name;
    private final RegionModel regions;
    private final int type;
    private final String uid;

    public IMJsonContents112Model(int i, String uid, String name, RegionModel regions) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(name, "name");
        Intrinsics.e(regions, "regions");
        this.type = i;
        this.uid = uid;
        this.name = name;
        this.regions = regions;
    }

    public static /* synthetic */ IMJsonContents112Model copy$default(IMJsonContents112Model iMJsonContents112Model, int i, String str, String str2, RegionModel regionModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = iMJsonContents112Model.type;
        }
        if ((i2 & 2) != 0) {
            str = iMJsonContents112Model.uid;
        }
        if ((i2 & 4) != 0) {
            str2 = iMJsonContents112Model.name;
        }
        if ((i2 & 8) != 0) {
            regionModel = iMJsonContents112Model.regions;
        }
        return iMJsonContents112Model.copy(i, str, str2, regionModel);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.name;
    }

    public final RegionModel component4() {
        return this.regions;
    }

    public final IMJsonContents112Model copy(int i, String uid, String name, RegionModel regions) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(name, "name");
        Intrinsics.e(regions, "regions");
        return new IMJsonContents112Model(i, uid, name, regions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMJsonContents112Model) {
            IMJsonContents112Model iMJsonContents112Model = (IMJsonContents112Model) obj;
            return this.type == iMJsonContents112Model.type && Intrinsics.a((Object) this.uid, (Object) iMJsonContents112Model.uid) && Intrinsics.a((Object) this.name, (Object) iMJsonContents112Model.name) && Intrinsics.a(this.regions, iMJsonContents112Model.regions);
        }
        return false;
    }

    public final String getName() {
        return this.name;
    }

    public final RegionModel getRegions() {
        return this.regions;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((this.type * 31) + this.uid.hashCode()) * 31) + this.name.hashCode()) * 31) + this.regions.hashCode();
    }

    public String toString() {
        return "IMJsonContents112Model(type=" + this.type + ", uid=" + this.uid + ", name=" + this.name + ", regions=" + this.regions + ')';
    }
}
