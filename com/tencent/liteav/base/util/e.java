package com.tencent.liteav.base.util;

import android.os.MessageQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/e.class */
public final /* synthetic */ class e implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    private final b f22638a;

    private e(b bVar) {
        this.f22638a = bVar;
    }

    public static MessageQueue.IdleHandler a(b bVar) {
        return new e(bVar);
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        return b.a(this.f22638a);
    }
}
