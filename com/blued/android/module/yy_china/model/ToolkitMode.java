package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ToolkitMode.class */
public final class ToolkitMode {
    private final ToolkitItemMode fun_modes;
    private final ToolkitItemMode tools;

    public ToolkitMode(ToolkitItemMode fun_modes, ToolkitItemMode tools) {
        Intrinsics.e(fun_modes, "fun_modes");
        Intrinsics.e(tools, "tools");
        this.fun_modes = fun_modes;
        this.tools = tools;
    }

    public static /* synthetic */ ToolkitMode copy$default(ToolkitMode toolkitMode, ToolkitItemMode toolkitItemMode, ToolkitItemMode toolkitItemMode2, int i, Object obj) {
        if ((i & 1) != 0) {
            toolkitItemMode = toolkitMode.fun_modes;
        }
        if ((i & 2) != 0) {
            toolkitItemMode2 = toolkitMode.tools;
        }
        return toolkitMode.copy(toolkitItemMode, toolkitItemMode2);
    }

    public final ToolkitItemMode component1() {
        return this.fun_modes;
    }

    public final ToolkitItemMode component2() {
        return this.tools;
    }

    public final ToolkitMode copy(ToolkitItemMode fun_modes, ToolkitItemMode tools) {
        Intrinsics.e(fun_modes, "fun_modes");
        Intrinsics.e(tools, "tools");
        return new ToolkitMode(fun_modes, tools);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ToolkitMode) {
            ToolkitMode toolkitMode = (ToolkitMode) obj;
            return Intrinsics.a(this.fun_modes, toolkitMode.fun_modes) && Intrinsics.a(this.tools, toolkitMode.tools);
        }
        return false;
    }

    public final ToolkitItemMode getFun_modes() {
        return this.fun_modes;
    }

    public final ToolkitItemMode getTools() {
        return this.tools;
    }

    public int hashCode() {
        return (this.fun_modes.hashCode() * 31) + this.tools.hashCode();
    }

    public String toString() {
        return "ToolkitMode(fun_modes=" + this.fun_modes + ", tools=" + this.tools + ')';
    }
}
