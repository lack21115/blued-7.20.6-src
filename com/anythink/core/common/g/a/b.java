package com.anythink.core.common.g.a;

import android.text.TextUtils;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/a/b.class */
public final class b extends c {
    String a;
    int c;
    private final String k = getClass().getSimpleName();
    boolean b = true;

    public b(String str, int i) {
        this.c = 1;
        this.a = str;
        if (i == 1000) {
            this.c = 1;
        } else if (i == 1001) {
            this.c = 2;
        }
    }

    @Override // com.anythink.core.common.g.a.c
    public final void a(String str, String str2, String str3, int i) {
    }

    @Override // com.anythink.core.common.g.a.c
    public final int c() {
        return this.c;
    }

    @Override // com.anythink.core.common.g.a.c
    public final int d() {
        return 3;
    }

    @Override // com.anythink.core.common.g.a.c
    public final byte[] e() {
        return !TextUtils.isEmpty(this.a) ? a(this.a) : new byte[0];
    }

    @Override // com.anythink.core.common.g.a.c
    public final boolean f() {
        return this.b;
    }
}
