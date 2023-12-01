package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYShareAchievementModel.class */
public final class YYShareAchievementModel {
    private String description;
    private final String name;
    private final boolean showIcon;
    private final String value;

    public YYShareAchievementModel(String name, String value, String description, boolean z) {
        Intrinsics.e(name, "name");
        Intrinsics.e(value, "value");
        Intrinsics.e(description, "description");
        this.name = name;
        this.value = value;
        this.description = description;
        this.showIcon = z;
    }

    public static /* synthetic */ YYShareAchievementModel copy$default(YYShareAchievementModel yYShareAchievementModel, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYShareAchievementModel.name;
        }
        if ((i & 2) != 0) {
            str2 = yYShareAchievementModel.value;
        }
        if ((i & 4) != 0) {
            str3 = yYShareAchievementModel.description;
        }
        if ((i & 8) != 0) {
            z = yYShareAchievementModel.showIcon;
        }
        return yYShareAchievementModel.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.value;
    }

    public final String component3() {
        return this.description;
    }

    public final boolean component4() {
        return this.showIcon;
    }

    public final YYShareAchievementModel copy(String name, String value, String description, boolean z) {
        Intrinsics.e(name, "name");
        Intrinsics.e(value, "value");
        Intrinsics.e(description, "description");
        return new YYShareAchievementModel(name, value, description, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYShareAchievementModel) {
            YYShareAchievementModel yYShareAchievementModel = (YYShareAchievementModel) obj;
            return Intrinsics.a((Object) this.name, (Object) yYShareAchievementModel.name) && Intrinsics.a((Object) this.value, (Object) yYShareAchievementModel.value) && Intrinsics.a((Object) this.description, (Object) yYShareAchievementModel.description) && this.showIcon == yYShareAchievementModel.showIcon;
        }
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getShowIcon() {
        return this.showIcon;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final void setDescription(String str) {
        Intrinsics.e(str, "<set-?>");
        this.description = str;
    }

    public String toString() {
        return "YYShareAchievementModel(name=" + this.name + ", value=" + this.value + ", description=" + this.description + ", showIcon=" + this.showIcon + ')';
    }
}
