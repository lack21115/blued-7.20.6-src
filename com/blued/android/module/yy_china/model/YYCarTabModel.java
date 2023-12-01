package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYCarTabModel.class */
public final class YYCarTabModel {
    private int complete_status;
    private int id;
    private String name;
    private int status;

    public YYCarTabModel(int i, String name, int i2, int i3) {
        Intrinsics.e(name, "name");
        this.id = i;
        this.name = name;
        this.status = i2;
        this.complete_status = i3;
    }

    public static /* synthetic */ YYCarTabModel copy$default(YYCarTabModel yYCarTabModel, int i, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = yYCarTabModel.id;
        }
        if ((i4 & 2) != 0) {
            str = yYCarTabModel.name;
        }
        if ((i4 & 4) != 0) {
            i2 = yYCarTabModel.status;
        }
        if ((i4 & 8) != 0) {
            i3 = yYCarTabModel.complete_status;
        }
        return yYCarTabModel.copy(i, str, i2, i3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.status;
    }

    public final int component4() {
        return this.complete_status;
    }

    public final YYCarTabModel copy(int i, String name, int i2, int i3) {
        Intrinsics.e(name, "name");
        return new YYCarTabModel(i, name, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYCarTabModel) {
            YYCarTabModel yYCarTabModel = (YYCarTabModel) obj;
            return this.id == yYCarTabModel.id && Intrinsics.a((Object) this.name, (Object) yYCarTabModel.name) && this.status == yYCarTabModel.status && this.complete_status == yYCarTabModel.complete_status;
        }
        return false;
    }

    public final int getComplete_status() {
        return this.complete_status;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((this.id * 31) + this.name.hashCode()) * 31) + this.status) * 31) + this.complete_status;
    }

    public final void setComplete_status(int i) {
        this.complete_status = i;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public String toString() {
        return "YYCarTabModel(id=" + this.id + ", name=" + this.name + ", status=" + this.status + ", complete_status=" + this.complete_status + ')';
    }
}
