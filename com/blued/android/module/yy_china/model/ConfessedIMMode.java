package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ConfessedIMMode.class */
public final class ConfessedIMMode {
    private final ConfessedMode confession_info;
    private final String confession_type;

    public ConfessedIMMode(ConfessedMode confession_info, String confession_type) {
        Intrinsics.e(confession_info, "confession_info");
        Intrinsics.e(confession_type, "confession_type");
        this.confession_info = confession_info;
        this.confession_type = confession_type;
    }

    public static /* synthetic */ ConfessedIMMode copy$default(ConfessedIMMode confessedIMMode, ConfessedMode confessedMode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            confessedMode = confessedIMMode.confession_info;
        }
        if ((i & 2) != 0) {
            str = confessedIMMode.confession_type;
        }
        return confessedIMMode.copy(confessedMode, str);
    }

    public final ConfessedMode component1() {
        return this.confession_info;
    }

    public final String component2() {
        return this.confession_type;
    }

    public final ConfessedIMMode copy(ConfessedMode confession_info, String confession_type) {
        Intrinsics.e(confession_info, "confession_info");
        Intrinsics.e(confession_type, "confession_type");
        return new ConfessedIMMode(confession_info, confession_type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConfessedIMMode) {
            ConfessedIMMode confessedIMMode = (ConfessedIMMode) obj;
            return Intrinsics.a(this.confession_info, confessedIMMode.confession_info) && Intrinsics.a((Object) this.confession_type, (Object) confessedIMMode.confession_type);
        }
        return false;
    }

    public final ConfessedMode getConfession_info() {
        return this.confession_info;
    }

    public final String getConfession_type() {
        return this.confession_type;
    }

    public int hashCode() {
        return (this.confession_info.hashCode() * 31) + this.confession_type.hashCode();
    }

    public String toString() {
        return "ConfessedIMMode(confession_info=" + this.confession_info + ", confession_type=" + this.confession_type + ')';
    }
}
