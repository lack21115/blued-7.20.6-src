package com.tencent.turingface.sdk.mfa;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/HnGHR.class */
public final class HnGHR extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ rBDKv f39882a;

    public HnGHR(rBDKv rbdkv) {
        this.f39882a = rbdkv;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            rBDKv.a(this.f39882a);
        } catch (Throwable th) {
        }
    }
}
