package com.blued.android.module.common.base.mvi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/EmptyState.class */
public final class EmptyState implements UiState {
    private final String a;

    public EmptyState() {
        this(null, 1, null);
    }

    public EmptyState(String str) {
        this.a = str;
    }

    public /* synthetic */ EmptyState(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EmptyState) && Intrinsics.a((Object) this.a, (Object) ((EmptyState) obj).a);
    }

    public int hashCode() {
        String str = this.a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "EmptyState(empty=" + ((Object) this.a) + ')';
    }
}
