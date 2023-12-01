package com.opos.mobad;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h.class */
public class h {
    public static boolean a(com.opos.mobad.c.a.b bVar, int i, int i2) {
        boolean z = true;
        if (bVar == null) {
            return true;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                z = false;
                break;
            } else if (bVar.a()) {
                break;
            } else {
                com.opos.cmn.an.f.a.a("RetryFileLockTool", "acquireFileLock but thread has acquire " + i4);
                try {
                    Thread.sleep(i2);
                } catch (InterruptedException e) {
                    com.opos.cmn.an.f.a.a("RetryFileLockTool", "", (Throwable) e);
                }
                i3 = i4 + 1;
            }
        }
        com.opos.cmn.an.f.a.b("RetryFileLockTool", "acquireFileLock retry time=" + i + ",interval =" + i2 + ",result =" + z);
        return z;
    }
}
