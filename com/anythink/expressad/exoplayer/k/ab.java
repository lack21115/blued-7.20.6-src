package com.anythink.expressad.exoplayer.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/ab.class */
final class ab implements k {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f4788a;

    public ab(Handler handler) {
        this.f4788a = handler;
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final Looper a() {
        return this.f4788a.getLooper();
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final Message a(int i) {
        return this.f4788a.obtainMessage(i);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final Message a(int i, int i2) {
        return this.f4788a.obtainMessage(i, i2, 0);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final Message a(int i, int i2, Object obj) {
        return this.f4788a.obtainMessage(0, i, i2, obj);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final Message a(int i, Object obj) {
        return this.f4788a.obtainMessage(i, obj);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final void a(Object obj) {
        this.f4788a.removeCallbacksAndMessages(obj);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final boolean a(long j) {
        return this.f4788a.sendEmptyMessageAtTime(2, j);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final boolean a(Runnable runnable) {
        return this.f4788a.post(runnable);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final boolean a(Runnable runnable, long j) {
        return this.f4788a.postDelayed(runnable, j);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final void b() {
        this.f4788a.removeMessages(2);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final boolean b(int i) {
        return this.f4788a.sendEmptyMessage(i);
    }
}
