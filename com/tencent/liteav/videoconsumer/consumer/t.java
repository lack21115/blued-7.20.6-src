package com.tencent.liteav.videoconsumer.consumer;

import android.os.Handler;
import android.os.Message;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/t.class */
final /* synthetic */ class t implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final j f23035a;

    private t(j jVar) {
        this.f23035a = jVar;
    }

    public static Handler.Callback a(j jVar) {
        return new t(jVar);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        return this.f23035a.a(message);
    }
}
