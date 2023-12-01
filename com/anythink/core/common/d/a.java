package com.anythink.core.common.d;

import android.content.Context;
import com.anythink.core.common.c.j;
import com.anythink.core.common.e.x;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/d/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    j f6607a;
    protected int b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context) {
        this.f6607a = j.a(com.anythink.core.common.c.c.a(context));
    }

    private List<x> a() {
        return this.f6607a.a(this.b);
    }

    public final List<x> a(List<String> list) {
        return this.f6607a.a(list, this.b);
    }

    public final void a(String str, int i, int i2) {
        this.f6607a.a(this.b, str, i, i2);
    }

    public final void a(String str, long j) {
        this.f6607a.a(this.b, str, j);
    }

    public final void a(String str, String str2) {
        this.f6607a.a(str, this.b, str2);
    }
}
