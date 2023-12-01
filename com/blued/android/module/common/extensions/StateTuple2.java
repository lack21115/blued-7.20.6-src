package com.blued.android.module.common.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/StateTuple2.class */
public final class StateTuple2<A, B> {
    private final A a;
    private final B b;

    public StateTuple2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StateTuple2) {
            StateTuple2 stateTuple2 = (StateTuple2) obj;
            return Intrinsics.a(this.a, stateTuple2.a) && Intrinsics.a(this.b, stateTuple2.b);
        }
        return false;
    }

    public int hashCode() {
        A a = this.a;
        int i = 0;
        int hashCode = a == null ? 0 : a.hashCode();
        B b = this.b;
        if (b != null) {
            i = b.hashCode();
        }
        return (hashCode * 31) + i;
    }

    public String toString() {
        return "StateTuple2(a=" + this.a + ", b=" + this.b + ')';
    }
}
