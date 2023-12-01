package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ToolMode.class */
public final class ToolMode {
    private final String icon;
    private final int img;
    private boolean isRed;
    private final int na;
    private final String name;
    private final int red_dot;
    private final String target_url;
    private final String type;

    public ToolMode(String name, String icon, String type, String target_url, int i, int i2, int i3, boolean z) {
        Intrinsics.e(name, "name");
        Intrinsics.e(icon, "icon");
        Intrinsics.e(type, "type");
        Intrinsics.e(target_url, "target_url");
        this.name = name;
        this.icon = icon;
        this.type = type;
        this.target_url = target_url;
        this.red_dot = i;
        this.na = i2;
        this.img = i3;
        this.isRed = z;
    }

    public /* synthetic */ ToolMode(String str, String str2, String str3, String str4, int i, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, i, (i4 & 32) != 0 ? -1 : i2, i3, z);
    }

    public static /* synthetic */ ToolMode copy$default(ToolMode toolMode, String str, String str2, String str3, String str4, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = toolMode.name;
        }
        if ((i4 & 2) != 0) {
            str2 = toolMode.icon;
        }
        if ((i4 & 4) != 0) {
            str3 = toolMode.type;
        }
        if ((i4 & 8) != 0) {
            str4 = toolMode.target_url;
        }
        if ((i4 & 16) != 0) {
            i = toolMode.red_dot;
        }
        if ((i4 & 32) != 0) {
            i2 = toolMode.na;
        }
        if ((i4 & 64) != 0) {
            i3 = toolMode.img;
        }
        if ((i4 & 128) != 0) {
            z = toolMode.isRed;
        }
        return toolMode.copy(str, str2, str3, str4, i, i2, i3, z);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.target_url;
    }

    public final int component5() {
        return this.red_dot;
    }

    public final int component6() {
        return this.na;
    }

    public final int component7() {
        return this.img;
    }

    public final boolean component8() {
        return this.isRed;
    }

    public final ToolMode copy(String name, String icon, String type, String target_url, int i, int i2, int i3, boolean z) {
        Intrinsics.e(name, "name");
        Intrinsics.e(icon, "icon");
        Intrinsics.e(type, "type");
        Intrinsics.e(target_url, "target_url");
        return new ToolMode(name, icon, type, target_url, i, i2, i3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ToolMode) {
            ToolMode toolMode = (ToolMode) obj;
            return Intrinsics.a((Object) this.name, (Object) toolMode.name) && Intrinsics.a((Object) this.icon, (Object) toolMode.icon) && Intrinsics.a((Object) this.type, (Object) toolMode.type) && Intrinsics.a((Object) this.target_url, (Object) toolMode.target_url) && this.red_dot == toolMode.red_dot && this.na == toolMode.na && this.img == toolMode.img && this.isRed == toolMode.isRed;
        }
        return false;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getImg() {
        return this.img;
    }

    public final int getNa() {
        return this.na;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRed_dot() {
        return this.red_dot;
    }

    public final String getTarget_url() {
        return this.target_url;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final boolean isRed() {
        return this.isRed;
    }

    public final void setRed(boolean z) {
        this.isRed = z;
    }

    public String toString() {
        return "ToolMode(name=" + this.name + ", icon=" + this.icon + ", type=" + this.type + ", target_url=" + this.target_url + ", red_dot=" + this.red_dot + ", na=" + this.na + ", img=" + this.img + ", isRed=" + this.isRed + ')';
    }
}
