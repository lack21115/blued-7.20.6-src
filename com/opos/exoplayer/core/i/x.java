package com.opos.exoplayer.core.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/x.class */
final class x implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f25513a;

    public x(Handler handler) {
        this.f25513a = handler;
    }

    @Override // com.opos.exoplayer.core.i.g
    public Looper a() {
        return this.f25513a.getLooper();
    }

    @Override // com.opos.exoplayer.core.i.g
    public Message a(int i, int i2, int i3) {
        return this.f25513a.obtainMessage(i, i2, i3);
    }

    @Override // com.opos.exoplayer.core.i.g
    public Message a(int i, int i2, int i3, Object obj) {
        return this.f25513a.obtainMessage(i, i2, i3, obj);
    }

    @Override // com.opos.exoplayer.core.i.g
    public Message a(int i, Object obj) {
        return this.f25513a.obtainMessage(i, obj);
    }

    @Override // com.opos.exoplayer.core.i.g
    public boolean a(int i) {
        return this.f25513a.sendEmptyMessage(i);
    }

    @Override // com.opos.exoplayer.core.i.g
    public boolean a(int i, long j) {
        return this.f25513a.sendEmptyMessageAtTime(i, j);
    }

    @Override // com.opos.exoplayer.core.i.g
    public void b(int i) {
        this.f25513a.removeMessages(i);
    }
}
