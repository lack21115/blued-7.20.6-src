package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/f/c.class */
public final class c implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        try {
            Process.setThreadPriority(0);
            while (true) {
                linkedList = this.a.c;
                if (linkedList.isEmpty()) {
                    break;
                }
                linkedList2 = this.a.c;
                Runnable runnable = (Runnable) linkedList2.get(0);
                linkedList3 = this.a.c;
                linkedList3.remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception e) {
        } catch (Throwable th) {
            b.b(this.a);
            throw th;
        }
        b.b(this.a);
    }
}
