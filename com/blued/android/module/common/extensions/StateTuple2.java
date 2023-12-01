package com.blued.android.module.common.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/StateTuple2.class */
public final class StateTuple2<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final A f10797a;
    private final B b;

    public StateTuple2(A a2, B b) {
        this.f10797a = a2;
        this.b = b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StateTuple2) {
            StateTuple2 stateTuple2 = (StateTuple2) obj;
            return Intrinsics.a(this.f10797a, stateTuple2.f10797a) && Intrinsics.a(this.b, stateTuple2.b);
        }
        return false;
    }

    public int hashCode() {
        A a2 = this.f10797a;
        int i = 0;
        int hashCode = a2 == null ? 0 : a2.hashCode();
        B b = this.b;
        if (b != null) {
            i = b.hashCode();
        }
        return (hashCode * 31) + i;
    }

    public String toString() {
        return "StateTuple2(a=" + this.f10797a + ", b=" + this.b + ')';
    }
}
