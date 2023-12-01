package com.meizu.cloud.pushsdk.c.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/e/d.class */
public class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<com.meizu.cloud.pushsdk.c.d.a> f10445a;

    public d(com.meizu.cloud.pushsdk.c.d.a aVar) {
        super(Looper.getMainLooper());
        this.f10445a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.meizu.cloud.pushsdk.c.d.a aVar = this.f10445a.get();
        if (message.what != 1) {
            super.handleMessage(message);
        } else if (aVar != null) {
            com.meizu.cloud.pushsdk.c.f.a aVar2 = (com.meizu.cloud.pushsdk.c.f.a) message.obj;
            aVar.a(aVar2.f10446a, aVar2.b);
        }
    }
}
