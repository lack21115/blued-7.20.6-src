package com.blued.android.module.common.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/ext/AnyExtKt.class */
public final class AnyExtKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T a(Object obj) {
        Intrinsics.e(obj, "<this>");
        return obj;
    }
}
