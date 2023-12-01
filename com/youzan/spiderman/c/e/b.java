package com.youzan.spiderman.c.e;

import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/e/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Set<String> f41757a = new HashSet();

    public final Set<String> a() {
        return this.f41757a;
    }

    public final void a(Set<String> set) {
        synchronized (this) {
            this.f41757a = set;
        }
    }
}
