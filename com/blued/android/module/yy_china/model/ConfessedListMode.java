package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ConfessedListMode.class */
public final class ConfessedListMode implements MultiItemEntity {
    private final ConfessedMode data;
    private final int type;

    public ConfessedListMode(int i, ConfessedMode confessedMode) {
        this.type = i;
        this.data = confessedMode;
    }

    public /* synthetic */ ConfessedListMode(int i, ConfessedMode confessedMode, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : confessedMode);
    }

    public static /* synthetic */ ConfessedListMode copy$default(ConfessedListMode confessedListMode, int i, ConfessedMode confessedMode, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = confessedListMode.type;
        }
        if ((i2 & 2) != 0) {
            confessedMode = confessedListMode.data;
        }
        return confessedListMode.copy(i, confessedMode);
    }

    public final int component1() {
        return this.type;
    }

    public final ConfessedMode component2() {
        return this.data;
    }

    public final ConfessedListMode copy(int i, ConfessedMode confessedMode) {
        return new ConfessedListMode(i, confessedMode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConfessedListMode) {
            ConfessedListMode confessedListMode = (ConfessedListMode) obj;
            return this.type == confessedListMode.type && Intrinsics.a(this.data, confessedListMode.data);
        }
        return false;
    }

    public final ConfessedMode getData() {
        return this.data;
    }

    public int getItemType() {
        return this.type;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.type;
        ConfessedMode confessedMode = this.data;
        return (i * 31) + (confessedMode == null ? 0 : confessedMode.hashCode());
    }

    public String toString() {
        return "ConfessedListMode(type=" + this.type + ", data=" + this.data + ')';
    }
}
