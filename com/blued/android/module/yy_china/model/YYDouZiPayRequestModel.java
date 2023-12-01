package com.blued.android.module.yy_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYDouZiPayRequestModel.class */
public final class YYDouZiPayRequestModel implements Serializable {
    private final String day;
    private String pay_code;
    private String pay_token;
    private final String prop_id;
    private boolean remember_me;

    public YYDouZiPayRequestModel(String prop_id, String day, String pay_code, String pay_token, boolean z) {
        Intrinsics.e(prop_id, "prop_id");
        Intrinsics.e(day, "day");
        Intrinsics.e(pay_code, "pay_code");
        Intrinsics.e(pay_token, "pay_token");
        this.prop_id = prop_id;
        this.day = day;
        this.pay_code = pay_code;
        this.pay_token = pay_token;
        this.remember_me = z;
    }

    public static /* synthetic */ YYDouZiPayRequestModel copy$default(YYDouZiPayRequestModel yYDouZiPayRequestModel, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYDouZiPayRequestModel.prop_id;
        }
        if ((i & 2) != 0) {
            str2 = yYDouZiPayRequestModel.day;
        }
        if ((i & 4) != 0) {
            str3 = yYDouZiPayRequestModel.pay_code;
        }
        if ((i & 8) != 0) {
            str4 = yYDouZiPayRequestModel.pay_token;
        }
        if ((i & 16) != 0) {
            z = yYDouZiPayRequestModel.remember_me;
        }
        return yYDouZiPayRequestModel.copy(str, str2, str3, str4, z);
    }

    public final String component1() {
        return this.prop_id;
    }

    public final String component2() {
        return this.day;
    }

    public final String component3() {
        return this.pay_code;
    }

    public final String component4() {
        return this.pay_token;
    }

    public final boolean component5() {
        return this.remember_me;
    }

    public final YYDouZiPayRequestModel copy(String prop_id, String day, String pay_code, String pay_token, boolean z) {
        Intrinsics.e(prop_id, "prop_id");
        Intrinsics.e(day, "day");
        Intrinsics.e(pay_code, "pay_code");
        Intrinsics.e(pay_token, "pay_token");
        return new YYDouZiPayRequestModel(prop_id, day, pay_code, pay_token, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYDouZiPayRequestModel) {
            YYDouZiPayRequestModel yYDouZiPayRequestModel = (YYDouZiPayRequestModel) obj;
            return Intrinsics.a((Object) this.prop_id, (Object) yYDouZiPayRequestModel.prop_id) && Intrinsics.a((Object) this.day, (Object) yYDouZiPayRequestModel.day) && Intrinsics.a((Object) this.pay_code, (Object) yYDouZiPayRequestModel.pay_code) && Intrinsics.a((Object) this.pay_token, (Object) yYDouZiPayRequestModel.pay_token) && this.remember_me == yYDouZiPayRequestModel.remember_me;
        }
        return false;
    }

    public final String getDay() {
        return this.day;
    }

    public final String getPay_code() {
        return this.pay_code;
    }

    public final String getPay_token() {
        return this.pay_token;
    }

    public final String getProp_id() {
        return this.prop_id;
    }

    public final boolean getRemember_me() {
        return this.remember_me;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final void setPay_code(String str) {
        Intrinsics.e(str, "<set-?>");
        this.pay_code = str;
    }

    public final void setPay_token(String str) {
        Intrinsics.e(str, "<set-?>");
        this.pay_token = str;
    }

    public final void setRemember_me(boolean z) {
        this.remember_me = z;
    }

    public String toString() {
        return "YYDouZiPayRequestModel(prop_id=" + this.prop_id + ", day=" + this.day + ", pay_code=" + this.pay_code + ", pay_token=" + this.pay_token + ", remember_me=" + this.remember_me + ')';
    }
}
