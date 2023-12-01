package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ToolkitItemMode.class */
public final class ToolkitItemMode {
    private final ArrayList<ToolMode> items;
    private final String name;

    public ToolkitItemMode(String name, ArrayList<ToolMode> items) {
        Intrinsics.e(name, "name");
        Intrinsics.e(items, "items");
        this.name = name;
        this.items = items;
    }

    public static /* synthetic */ ToolkitItemMode copy$default(ToolkitItemMode toolkitItemMode, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toolkitItemMode.name;
        }
        if ((i & 2) != 0) {
            arrayList = toolkitItemMode.items;
        }
        return toolkitItemMode.copy(str, arrayList);
    }

    public final String component1() {
        return this.name;
    }

    public final ArrayList<ToolMode> component2() {
        return this.items;
    }

    public final ToolkitItemMode copy(String name, ArrayList<ToolMode> items) {
        Intrinsics.e(name, "name");
        Intrinsics.e(items, "items");
        return new ToolkitItemMode(name, items);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ToolkitItemMode) {
            ToolkitItemMode toolkitItemMode = (ToolkitItemMode) obj;
            return Intrinsics.a((Object) this.name, (Object) toolkitItemMode.name) && Intrinsics.a(this.items, toolkitItemMode.items);
        }
        return false;
    }

    public final ArrayList<ToolMode> getItems() {
        return this.items;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.items.hashCode();
    }

    public String toString() {
        return "ToolkitItemMode(name=" + this.name + ", items=" + this.items + ')';
    }
}
