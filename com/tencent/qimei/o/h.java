package com.tencent.qimei.o;

import android.os.MessageQueue;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/h.class */
public class h implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f38374a;

    public h(j jVar) {
        this.f38374a = jVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        this.f38374a.b();
        return false;
    }
}
