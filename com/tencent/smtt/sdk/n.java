package com.tencent.smtt.sdk;

import android.os.HandlerThread;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/n.class */
class n extends HandlerThread {

    /* renamed from: a  reason: collision with root package name */
    private static n f25172a;

    public n(String str) {
        super(str);
    }

    public static n a() {
        n nVar;
        synchronized (n.class) {
            try {
                if (f25172a == null) {
                    n nVar2 = new n("TbsHandlerThread");
                    f25172a = nVar2;
                    nVar2.start();
                }
                nVar = f25172a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }
}
