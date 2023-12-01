package com.youzan.spiderman.cache;

import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private Set<String> f28113a;

    public d() {
        this.f28113a = null;
        this.f28113a = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(String str) {
        return this.f28113a.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str) {
        this.f28113a.add(str);
    }
}
