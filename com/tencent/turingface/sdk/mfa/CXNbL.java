package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/CXNbL.class */
public final class CXNbL extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f26173a;

    public CXNbL(Context context) {
        this.f26173a = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        long j;
        Context context = this.f26173a;
        String str = fenkF.f26261a;
        try {
            j = Long.valueOf(fenkF.b(context, "801")).longValue();
        } catch (Throwable th) {
            j = 0;
        }
        if (j == 0) {
            Context context2 = this.f26173a;
            HashMap hashMap = new HashMap();
            StringBuilder b = com.tencent.turingcam.oqKCa.b("");
            b.append(System.currentTimeMillis());
            hashMap.put("801", b.toString());
            fenkF.a(context2, hashMap);
        }
    }
}
