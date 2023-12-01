package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import com.tencent.turingface.sdk.mfa.vqARY;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/X7aJM.class */
public final class X7aJM extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ vqARY.spXPg f26236a;
    public final /* synthetic */ Context b;

    public X7aJM(vqARY.spXPg spxpg, Context context) {
        this.f26236a = spxpg;
        this.b = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        this.f26236a.f26317a.a(this.b);
    }
}
