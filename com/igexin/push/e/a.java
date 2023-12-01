package com.igexin.push.e;

import android.os.Message;
import com.igexin.push.core.d;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/a.class */
public final class a implements com.igexin.push.e.b.c {
    private static final long b = 360000;

    /* renamed from: a  reason: collision with root package name */
    private long f9984a = 0;

    @Override // com.igexin.push.e.b.c
    public final void a() {
        Message obtain = Message.obtain();
        obtain.what = com.igexin.push.core.b.P;
        d.a.f9866a.a(obtain);
    }

    @Override // com.igexin.push.e.b.c
    public final void a(long j) {
        this.f9984a = j;
    }

    @Override // com.igexin.push.e.b.c
    public final boolean b() {
        return System.currentTimeMillis() - this.f9984a > b;
    }
}
