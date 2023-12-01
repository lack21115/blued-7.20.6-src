package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipSuccessImMode.class */
public final class YYRelationShipSuccessImMode {
    private final YYRelationShipSuccessBuriedPointDataImMode buried_point_data;
    private boolean isUp;
    private final String message;
    private final int status;

    public YYRelationShipSuccessImMode(String message, int i, YYRelationShipSuccessBuriedPointDataImMode buried_point_data, boolean z) {
        Intrinsics.e(message, "message");
        Intrinsics.e(buried_point_data, "buried_point_data");
        this.message = message;
        this.status = i;
        this.buried_point_data = buried_point_data;
        this.isUp = z;
    }

    public /* synthetic */ YYRelationShipSuccessImMode(String str, int i, YYRelationShipSuccessBuriedPointDataImMode yYRelationShipSuccessBuriedPointDataImMode, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, yYRelationShipSuccessBuriedPointDataImMode, (i2 & 8) != 0 ? false : z);
    }

    public static /* synthetic */ YYRelationShipSuccessImMode copy$default(YYRelationShipSuccessImMode yYRelationShipSuccessImMode, String str, int i, YYRelationShipSuccessBuriedPointDataImMode yYRelationShipSuccessBuriedPointDataImMode, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = yYRelationShipSuccessImMode.message;
        }
        if ((i2 & 2) != 0) {
            i = yYRelationShipSuccessImMode.status;
        }
        if ((i2 & 4) != 0) {
            yYRelationShipSuccessBuriedPointDataImMode = yYRelationShipSuccessImMode.buried_point_data;
        }
        if ((i2 & 8) != 0) {
            z = yYRelationShipSuccessImMode.isUp;
        }
        return yYRelationShipSuccessImMode.copy(str, i, yYRelationShipSuccessBuriedPointDataImMode, z);
    }

    public final String component1() {
        return this.message;
    }

    public final int component2() {
        return this.status;
    }

    public final YYRelationShipSuccessBuriedPointDataImMode component3() {
        return this.buried_point_data;
    }

    public final boolean component4() {
        return this.isUp;
    }

    public final YYRelationShipSuccessImMode copy(String message, int i, YYRelationShipSuccessBuriedPointDataImMode buried_point_data, boolean z) {
        Intrinsics.e(message, "message");
        Intrinsics.e(buried_point_data, "buried_point_data");
        return new YYRelationShipSuccessImMode(message, i, buried_point_data, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipSuccessImMode) {
            YYRelationShipSuccessImMode yYRelationShipSuccessImMode = (YYRelationShipSuccessImMode) obj;
            return Intrinsics.a((Object) this.message, (Object) yYRelationShipSuccessImMode.message) && this.status == yYRelationShipSuccessImMode.status && Intrinsics.a(this.buried_point_data, yYRelationShipSuccessImMode.buried_point_data) && this.isUp == yYRelationShipSuccessImMode.isUp;
        }
        return false;
    }

    public final YYRelationShipSuccessBuriedPointDataImMode getBuried_point_data() {
        return this.buried_point_data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getStatus() {
        return this.status;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final boolean isUp() {
        return this.isUp;
    }

    public final void setUp(boolean z) {
        this.isUp = z;
    }

    public String toString() {
        return "YYRelationShipSuccessImMode(message=" + this.message + ", status=" + this.status + ", buried_point_data=" + this.buried_point_data + ", isUp=" + this.isUp + ')';
    }
}
