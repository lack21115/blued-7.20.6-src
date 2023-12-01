package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/TabItemTextModel.class */
public final class TabItemTextModel {
    private boolean checked;
    private final int position;
    private final String tabName;
    private final String type;

    public TabItemTextModel(int i, String type, String tabName, boolean z) {
        Intrinsics.e(type, "type");
        Intrinsics.e(tabName, "tabName");
        this.position = i;
        this.type = type;
        this.tabName = tabName;
        this.checked = z;
    }

    public /* synthetic */ TabItemTextModel(int i, String str, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, (i2 & 8) != 0 ? false : z);
    }

    public static /* synthetic */ TabItemTextModel copy$default(TabItemTextModel tabItemTextModel, int i, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = tabItemTextModel.position;
        }
        if ((i2 & 2) != 0) {
            str = tabItemTextModel.type;
        }
        if ((i2 & 4) != 0) {
            str2 = tabItemTextModel.tabName;
        }
        if ((i2 & 8) != 0) {
            z = tabItemTextModel.checked;
        }
        return tabItemTextModel.copy(i, str, str2, z);
    }

    public final int component1() {
        return this.position;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.tabName;
    }

    public final boolean component4() {
        return this.checked;
    }

    public final TabItemTextModel copy(int i, String type, String tabName, boolean z) {
        Intrinsics.e(type, "type");
        Intrinsics.e(tabName, "tabName");
        return new TabItemTextModel(i, type, tabName, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TabItemTextModel) {
            TabItemTextModel tabItemTextModel = (TabItemTextModel) obj;
            return this.position == tabItemTextModel.position && Intrinsics.a((Object) this.type, (Object) tabItemTextModel.type) && Intrinsics.a((Object) this.tabName, (Object) tabItemTextModel.tabName) && this.checked == tabItemTextModel.checked;
        }
        return false;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final void setChecked(boolean z) {
        this.checked = z;
    }

    public String toString() {
        return "TabItemTextModel(position=" + this.position + ", type=" + this.type + ", tabName=" + this.tabName + ", checked=" + this.checked + ')';
    }
}
