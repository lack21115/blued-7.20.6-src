package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/HomeRightMenuDotModel.class */
public final class HomeRightMenuDotModel {
    private int status;
    private final String version;

    public HomeRightMenuDotModel(String version, int i) {
        Intrinsics.e(version, "version");
        this.version = version;
        this.status = i;
    }

    public static /* synthetic */ HomeRightMenuDotModel copy$default(HomeRightMenuDotModel homeRightMenuDotModel, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = homeRightMenuDotModel.version;
        }
        if ((i2 & 2) != 0) {
            i = homeRightMenuDotModel.status;
        }
        return homeRightMenuDotModel.copy(str, i);
    }

    public final String component1() {
        return this.version;
    }

    public final int component2() {
        return this.status;
    }

    public final HomeRightMenuDotModel copy(String version, int i) {
        Intrinsics.e(version, "version");
        return new HomeRightMenuDotModel(version, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HomeRightMenuDotModel) {
            HomeRightMenuDotModel homeRightMenuDotModel = (HomeRightMenuDotModel) obj;
            return Intrinsics.a((Object) this.version, (Object) homeRightMenuDotModel.version) && this.status == homeRightMenuDotModel.status;
        }
        return false;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (this.version.hashCode() * 31) + this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public String toString() {
        return "HomeRightMenuDotModel(version=" + this.version + ", status=" + this.status + ')';
    }
}
