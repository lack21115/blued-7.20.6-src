package com.bytedance.pangle.a;

import com.bytedance.pangle.d.e;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    final CountDownLatch f7746a;
    Throwable b;

    /* renamed from: com.bytedance.pangle.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/a/a$a.class */
    public interface InterfaceC0144a {
        void a();
    }

    private a(InterfaceC0144a[] interfaceC0144aArr) {
        this.f7746a = new CountDownLatch(interfaceC0144aArr.length);
        int length = interfaceC0144aArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            final InterfaceC0144a interfaceC0144a = interfaceC0144aArr[i2];
            e.a(new Runnable() { // from class: com.bytedance.pangle.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        interfaceC0144a.a();
                    } catch (Throwable th) {
                        a.this.b = th;
                    }
                    a.this.f7746a.countDown();
                }
            });
            i = i2 + 1;
        }
    }

    public static void a(InterfaceC0144a... interfaceC0144aArr) {
        a aVar = new a(interfaceC0144aArr);
        try {
            aVar.f7746a.await();
            Throwable th = aVar.b;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
