package com.blued.android.module.common.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/StateTuple1.class */
public final class StateTuple1<A> {

    /* renamed from: a  reason: collision with root package name */
    private final A f10796a;

    public StateTuple1(A a2) {
        this.f10796a = a2;
    }

    public final A a() {
        return this.f10796a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StateTuple1) && Intrinsics.a(this.f10796a, ((StateTuple1) obj).f10796a);
    }

    public int hashCode() {
        A a2 = this.f10796a;
        if (a2 == null) {
            return 0;
        }
        return a2.hashCode();
    }

    public String toString() {
        return "StateTuple1(a=" + this.f10796a + ')';
    }
}
