package com.tencent.smtt.sdk;

import android.os.HandlerThread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/n.class */
public class n extends HandlerThread {

    /* renamed from: a  reason: collision with root package name */
    private static n f38863a;

    public n(String str) {
        super(str);
    }

    public static n a() {
        n nVar;
        synchronized (n.class) {
            try {
                if (f38863a == null) {
                    n nVar2 = new n("TbsHandlerThread");
                    f38863a = nVar2;
                    nVar2.start();
                }
                nVar = f38863a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }
}
