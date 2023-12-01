package com.tencent.turingface.sdk.mfa;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/afk8T.class */
public final class afk8T implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f39935a;
    public final /* synthetic */ AtomicReference b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f39936c;

    public afk8T(AtomicBoolean atomicBoolean, AtomicReference atomicReference, Object obj) {
        this.f39935a = atomicBoolean;
        this.b = atomicReference;
        this.f39936c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f39935a.get()) {
            return;
        }
        try {
            throw new Exception("");
        } catch (Exception e) {
            String a2 = kC0XR.a(kC0XR.G0);
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    synchronized (this.f39936c) {
                        this.f39936c.notify();
                        return;
                    }
                }
                StackTraceElement stackTraceElement = stackTrace[i2];
                if (a2.equals(stackTraceElement.getClassName() + BridgeUtil.UNDERLINE_STR + stackTraceElement.getMethodName())) {
                    this.b.set(Boolean.TRUE);
                }
                i = i2 + 1;
            }
        }
    }
}
