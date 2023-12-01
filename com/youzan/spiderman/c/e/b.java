package com.youzan.spiderman.c.e;

import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/e/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Set<String> f28066a = new HashSet();

    public final Set<String> a() {
        return this.f28066a;
    }

    public final void a(Set<String> set) {
        synchronized (this) {
            this.f28066a = set;
        }
    }
}
