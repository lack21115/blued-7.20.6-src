package com.tencent.turingface.sdk.mfa;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/afk8T.class */
public final class afk8T implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f26244a;
    public final /* synthetic */ AtomicReference b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f26245c;

    public afk8T(AtomicBoolean atomicBoolean, AtomicReference atomicReference, Object obj) {
        this.f26244a = atomicBoolean;
        this.b = atomicReference;
        this.f26245c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f26244a.get()) {
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
                    synchronized (this.f26245c) {
                        this.f26245c.notify();
                        return;
                    }
                }
                StackTraceElement stackTraceElement = stackTrace[i2];
                if (a2.equals(stackTraceElement.getClassName() + "_" + stackTraceElement.getMethodName())) {
                    this.b.set(Boolean.TRUE);
                }
                i = i2 + 1;
            }
        }
    }
}
