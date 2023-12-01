package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/FunctionRedPModelJson.class */
public final class FunctionRedPModelJson implements Serializable {
    private String goods_pack_point_info;
    private String point_info;
    private int red_point_action;
    private boolean red_point_cancel;
    private int red_point_type;
    private String red_point_word;

    public FunctionRedPModelJson(String point_info, String goods_pack_point_info, String red_point_word, boolean z, int i, int i2) {
        Intrinsics.e(point_info, "point_info");
        Intrinsics.e(goods_pack_point_info, "goods_pack_point_info");
        Intrinsics.e(red_point_word, "red_point_word");
        this.point_info = point_info;
        this.goods_pack_point_info = goods_pack_point_info;
        this.red_point_word = red_point_word;
        this.red_point_cancel = z;
        this.red_point_type = i;
        this.red_point_action = i2;
    }

    public static /* synthetic */ FunctionRedPModelJson copy$default(FunctionRedPModelJson functionRedPModelJson, String str, String str2, String str3, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = functionRedPModelJson.point_info;
        }
        if ((i3 & 2) != 0) {
            str2 = functionRedPModelJson.goods_pack_point_info;
        }
        if ((i3 & 4) != 0) {
            str3 = functionRedPModelJson.red_point_word;
        }
        if ((i3 & 8) != 0) {
            z = functionRedPModelJson.red_point_cancel;
        }
        if ((i3 & 16) != 0) {
            i = functionRedPModelJson.red_point_type;
        }
        if ((i3 & 32) != 0) {
            i2 = functionRedPModelJson.red_point_action;
        }
        return functionRedPModelJson.copy(str, str2, str3, z, i, i2);
    }

    public final String component1() {
        return this.point_info;
    }

    public final String component2() {
        return this.goods_pack_point_info;
    }

    public final String component3() {
        return this.red_point_word;
    }

    public final boolean component4() {
        return this.red_point_cancel;
    }

    public final int component5() {
        return this.red_point_type;
    }

    public final int component6() {
        return this.red_point_action;
    }

    public final FunctionRedPModelJson copy(String point_info, String goods_pack_point_info, String red_point_word, boolean z, int i, int i2) {
        Intrinsics.e(point_info, "point_info");
        Intrinsics.e(goods_pack_point_info, "goods_pack_point_info");
        Intrinsics.e(red_point_word, "red_point_word");
        return new FunctionRedPModelJson(point_info, goods_pack_point_info, red_point_word, z, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FunctionRedPModelJson) {
            FunctionRedPModelJson functionRedPModelJson = (FunctionRedPModelJson) obj;
            return Intrinsics.a((Object) this.point_info, (Object) functionRedPModelJson.point_info) && Intrinsics.a((Object) this.goods_pack_point_info, (Object) functionRedPModelJson.goods_pack_point_info) && Intrinsics.a((Object) this.red_point_word, (Object) functionRedPModelJson.red_point_word) && this.red_point_cancel == functionRedPModelJson.red_point_cancel && this.red_point_type == functionRedPModelJson.red_point_type && this.red_point_action == functionRedPModelJson.red_point_action;
        }
        return false;
    }

    public final String getGoods_pack_point_info() {
        return this.goods_pack_point_info;
    }

    public final String getPoint_info() {
        return this.point_info;
    }

    public final int getRed_point_action() {
        return this.red_point_action;
    }

    public final boolean getRed_point_cancel() {
        return this.red_point_cancel;
    }

    public final int getRed_point_type() {
        return this.red_point_type;
    }

    public final String getRed_point_word() {
        return this.red_point_word;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final void setGoods_pack_point_info(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_pack_point_info = str;
    }

    public final void setPoint_info(String str) {
        Intrinsics.e(str, "<set-?>");
        this.point_info = str;
    }

    public final void setRed_point_action(int i) {
        this.red_point_action = i;
    }

    public final void setRed_point_cancel(boolean z) {
        this.red_point_cancel = z;
    }

    public final void setRed_point_type(int i) {
        this.red_point_type = i;
    }

    public final void setRed_point_word(String str) {
        Intrinsics.e(str, "<set-?>");
        this.red_point_word = str;
    }

    public String toString() {
        return "FunctionRedPModelJson(point_info='" + this.point_info + "', goods_pack_point_info='" + this.goods_pack_point_info + "', red_point_word='" + this.red_point_word + "', red_point_cancel=" + this.red_point_cancel + ", red_point_type=" + this.red_point_type + ", red_point_action=" + this.red_point_action + ')';
    }
}
