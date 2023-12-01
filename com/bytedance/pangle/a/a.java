package com.bytedance.pangle.a;

import com.bytedance.pangle.d.e;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    final CountDownLatch f21352a;
    Throwable b;

    /* renamed from: com.bytedance.pangle.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/a/a$a.class */
    public interface InterfaceC0314a {
        void a();
    }

    private a(InterfaceC0314a[] interfaceC0314aArr) {
        this.f21352a = new CountDownLatch(interfaceC0314aArr.length);
        int length = interfaceC0314aArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            final InterfaceC0314a interfaceC0314a = interfaceC0314aArr[i2];
            e.a(new Runnable() { // from class: com.bytedance.pangle.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        interfaceC0314a.a();
                    } catch (Throwable th) {
                        a.this.b = th;
                    }
                    a.this.f21352a.countDown();
                }
            });
            i = i2 + 1;
        }
    }

    public static void a(InterfaceC0314a... interfaceC0314aArr) {
        a aVar = new a(interfaceC0314aArr);
        try {
            aVar.f21352a.await();
            Throwable th = aVar.b;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
