package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.av;
import java.lang.Thread;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bd.class */
class bd implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bc f6494a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar) {
        this.f6494a = bcVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        av.a h = av.h("ThreadPoolFactory");
        h.c("线程名字=" + thread.getName() + "线程crash信息", th);
    }
}
