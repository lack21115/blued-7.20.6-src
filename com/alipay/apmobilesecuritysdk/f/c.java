package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/f/c.class */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4560a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f4560a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        try {
            Process.setThreadPriority(0);
            while (true) {
                linkedList = this.f4560a.f4559c;
                if (linkedList.isEmpty()) {
                    break;
                }
                linkedList2 = this.f4560a.f4559c;
                Runnable runnable = (Runnable) linkedList2.get(0);
                linkedList3 = this.f4560a.f4559c;
                linkedList3.remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception e) {
        } catch (Throwable th) {
            b.b(this.f4560a);
            throw th;
        }
        b.b(this.f4560a);
    }
}
