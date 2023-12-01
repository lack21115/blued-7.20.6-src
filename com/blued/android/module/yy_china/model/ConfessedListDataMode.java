package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ConfessedListDataMode.class */
public final class ConfessedListDataMode {
    private final ConfessedMode confession_exclusive;
    private final ArrayList<ConfessedMode> confession_lists;
    private final String empty_exclusive_ramake;
    private final ConfessedMode my_confession_info;
    private final String ramake;

    public ConfessedListDataMode(ConfessedMode my_confession_info, ConfessedMode confession_exclusive, ArrayList<ConfessedMode> confession_lists, String ramake, String empty_exclusive_ramake) {
        Intrinsics.e(my_confession_info, "my_confession_info");
        Intrinsics.e(confession_exclusive, "confession_exclusive");
        Intrinsics.e(confession_lists, "confession_lists");
        Intrinsics.e(ramake, "ramake");
        Intrinsics.e(empty_exclusive_ramake, "empty_exclusive_ramake");
        this.my_confession_info = my_confession_info;
        this.confession_exclusive = confession_exclusive;
        this.confession_lists = confession_lists;
        this.ramake = ramake;
        this.empty_exclusive_ramake = empty_exclusive_ramake;
    }

    public static /* synthetic */ ConfessedListDataMode copy$default(ConfessedListDataMode confessedListDataMode, ConfessedMode confessedMode, ConfessedMode confessedMode2, ArrayList arrayList, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            confessedMode = confessedListDataMode.my_confession_info;
        }
        if ((i & 2) != 0) {
            confessedMode2 = confessedListDataMode.confession_exclusive;
        }
        if ((i & 4) != 0) {
            arrayList = confessedListDataMode.confession_lists;
        }
        if ((i & 8) != 0) {
            str = confessedListDataMode.ramake;
        }
        if ((i & 16) != 0) {
            str2 = confessedListDataMode.empty_exclusive_ramake;
        }
        return confessedListDataMode.copy(confessedMode, confessedMode2, arrayList, str, str2);
    }

    public final ConfessedMode component1() {
        return this.my_confession_info;
    }

    public final ConfessedMode component2() {
        return this.confession_exclusive;
    }

    public final ArrayList<ConfessedMode> component3() {
        return this.confession_lists;
    }

    public final String component4() {
        return this.ramake;
    }

    public final String component5() {
        return this.empty_exclusive_ramake;
    }

    public final ConfessedListDataMode copy(ConfessedMode my_confession_info, ConfessedMode confession_exclusive, ArrayList<ConfessedMode> confession_lists, String ramake, String empty_exclusive_ramake) {
        Intrinsics.e(my_confession_info, "my_confession_info");
        Intrinsics.e(confession_exclusive, "confession_exclusive");
        Intrinsics.e(confession_lists, "confession_lists");
        Intrinsics.e(ramake, "ramake");
        Intrinsics.e(empty_exclusive_ramake, "empty_exclusive_ramake");
        return new ConfessedListDataMode(my_confession_info, confession_exclusive, confession_lists, ramake, empty_exclusive_ramake);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConfessedListDataMode) {
            ConfessedListDataMode confessedListDataMode = (ConfessedListDataMode) obj;
            return Intrinsics.a(this.my_confession_info, confessedListDataMode.my_confession_info) && Intrinsics.a(this.confession_exclusive, confessedListDataMode.confession_exclusive) && Intrinsics.a(this.confession_lists, confessedListDataMode.confession_lists) && Intrinsics.a((Object) this.ramake, (Object) confessedListDataMode.ramake) && Intrinsics.a((Object) this.empty_exclusive_ramake, (Object) confessedListDataMode.empty_exclusive_ramake);
        }
        return false;
    }

    public final ConfessedMode getConfession_exclusive() {
        return this.confession_exclusive;
    }

    public final ArrayList<ConfessedMode> getConfession_lists() {
        return this.confession_lists;
    }

    public final String getEmpty_exclusive_ramake() {
        return this.empty_exclusive_ramake;
    }

    public final ConfessedMode getMy_confession_info() {
        return this.my_confession_info;
    }

    public final String getRamake() {
        return this.ramake;
    }

    public int hashCode() {
        return (((((((this.my_confession_info.hashCode() * 31) + this.confession_exclusive.hashCode()) * 31) + this.confession_lists.hashCode()) * 31) + this.ramake.hashCode()) * 31) + this.empty_exclusive_ramake.hashCode();
    }

    public String toString() {
        return "ConfessedListDataMode(my_confession_info=" + this.my_confession_info + ", confession_exclusive=" + this.confession_exclusive + ", confession_lists=" + this.confession_lists + ", ramake=" + this.ramake + ", empty_exclusive_ramake=" + this.empty_exclusive_ramake + ')';
    }
}
