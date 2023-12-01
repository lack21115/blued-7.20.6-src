package com.blued.android.module.common.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/api/Error.class */
public final class Error extends ApiState {
    private final int a;
    private final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Error(int i, String errorMsg) {
        super(null);
        Intrinsics.e(errorMsg, "errorMsg");
        this.a = i;
        this.b = errorMsg;
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }
}
