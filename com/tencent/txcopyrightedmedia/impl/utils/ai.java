package com.tencent.txcopyrightedmedia.impl.utils;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/ai.class */
public final class ai {

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f26363a;
    public Handler b;

    public ai() {
        HandlerThread handlerThread = new HandlerThread("AME-Callback");
        this.f26363a = handlerThread;
        handlerThread.start();
        this.b = new Handler(this.f26363a.getLooper());
    }

    public final void a(Runnable runnable) {
        this.b.post(runnable);
    }
}
