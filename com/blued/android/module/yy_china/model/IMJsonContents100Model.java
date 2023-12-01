package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/IMJsonContents100Model.class */
public final class IMJsonContents100Model {
    private final YYMsgRedEnvExtra body;
    private final int type;

    public IMJsonContents100Model(int i, YYMsgRedEnvExtra body) {
        Intrinsics.e(body, "body");
        this.type = i;
        this.body = body;
    }

    public static /* synthetic */ IMJsonContents100Model copy$default(IMJsonContents100Model iMJsonContents100Model, int i, YYMsgRedEnvExtra yYMsgRedEnvExtra, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = iMJsonContents100Model.type;
        }
        if ((i2 & 2) != 0) {
            yYMsgRedEnvExtra = iMJsonContents100Model.body;
        }
        return iMJsonContents100Model.copy(i, yYMsgRedEnvExtra);
    }

    public final int component1() {
        return this.type;
    }

    public final YYMsgRedEnvExtra component2() {
        return this.body;
    }

    public final IMJsonContents100Model copy(int i, YYMsgRedEnvExtra body) {
        Intrinsics.e(body, "body");
        return new IMJsonContents100Model(i, body);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMJsonContents100Model) {
            IMJsonContents100Model iMJsonContents100Model = (IMJsonContents100Model) obj;
            return this.type == iMJsonContents100Model.type && Intrinsics.a(this.body, iMJsonContents100Model.body);
        }
        return false;
    }

    public final YYMsgRedEnvExtra getBody() {
        return this.body;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type * 31) + this.body.hashCode();
    }

    public String toString() {
        return "IMJsonContents100Model(type=" + this.type + ", body=" + this.body + ')';
    }
}
