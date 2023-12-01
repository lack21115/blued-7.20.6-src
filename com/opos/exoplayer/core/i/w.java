package com.opos.exoplayer.core.i;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/w.class */
final class w implements b {
    @Override // com.opos.exoplayer.core.i.b
    public long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.opos.exoplayer.core.i.b
    public g a(Looper looper, Handler.Callback callback) {
        return new x(new Handler(looper, callback));
    }

    @Override // com.opos.exoplayer.core.i.b
    public long b() {
        return SystemClock.uptimeMillis();
    }
}
