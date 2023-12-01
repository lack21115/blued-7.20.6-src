package com.blued.android.module.common.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/StateTuple1.class */
public final class StateTuple1<A> {
    private final A a;

    public StateTuple1(A a) {
        this.a = a;
    }

    public final A a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StateTuple1) && Intrinsics.a(this.a, ((StateTuple1) obj).a);
    }

    public int hashCode() {
        A a = this.a;
        if (a == null) {
            return 0;
        }
        return a.hashCode();
    }

    public String toString() {
        return "StateTuple1(a=" + this.a + ')';
    }
}
