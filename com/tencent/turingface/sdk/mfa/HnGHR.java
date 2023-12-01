package com.tencent.turingface.sdk.mfa;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/HnGHR.class */
public final class HnGHR extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ rBDKv f26191a;

    public HnGHR(rBDKv rbdkv) {
        this.f26191a = rbdkv;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            rBDKv.a(this.f26191a);
        } catch (Throwable th) {
        }
    }
}
