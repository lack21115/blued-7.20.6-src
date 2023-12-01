package com.vivo.push;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/c.class */
public final class c implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f41060a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f41060a = bVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (message == null) {
            com.vivo.push.util.p.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i = message.what;
        if (i == 1) {
            com.vivo.push.util.p.a("AidlManager", "In connect, bind core service time out");
            atomicInteger = this.f41060a.f;
            if (atomicInteger.get() != 2) {
                return true;
            }
        } else if (i != 2) {
            com.vivo.push.util.p.b("AidlManager", "unknow msg what [" + message.what + "]");
            return true;
        } else {
            atomicInteger2 = this.f41060a.f;
            if (atomicInteger2.get() == 4) {
                this.f41060a.f();
            }
        }
        this.f41060a.a(1);
        return true;
    }
}
