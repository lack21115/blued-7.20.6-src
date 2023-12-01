package com.tencent.liteav.base.util;

import android.os.MessageQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/f.class */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final b f36330a;
    private final MessageQueue.IdleHandler b;

    private f(b bVar, MessageQueue.IdleHandler idleHandler) {
        this.f36330a = bVar;
        this.b = idleHandler;
    }

    public static Runnable a(b bVar, MessageQueue.IdleHandler idleHandler) {
        return new f(bVar, idleHandler);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.a(this.f36330a, this.b);
    }
}
