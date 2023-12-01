package cn.shuzilm.core;

import android.content.Context;
import android.os.Build;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/f.class */
public final class f implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Listener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, Listener listener) {
        this.a = context;
        this.b = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        Lock lock;
        AIClient aIClient;
        Lock lock2;
        AIClient aIClient2;
        AIClient aIClient3;
        String zZVTFJRA;
        AIClient aIClient4;
        AIClient aIClient5;
        AIClient unused;
        AIClient unused2;
        try {
            lock = DUHelper.f;
            lock.lock();
            aIClient = DUHelper.c;
            if (aIClient == null) {
                AIClient unused3 = DUHelper.c = new AIClient(this.a);
                aIClient5 = DUHelper.c;
                aIClient5.asynAI();
            }
            unused = DUHelper.c;
            if (!AIClient.isf) {
                aIClient4 = DUHelper.c;
                aIClient4.asynAI();
            }
            unused2 = DUHelper.c;
            if (AIClient.isf) {
                String str = null;
                String upperCase = Build.MANUFACTURER.toUpperCase();
                aIClient2 = DUHelper.c;
                if (aIClient2.m(upperCase)) {
                    aIClient3 = DUHelper.c;
                    zZVTFJRA = DUHelper.zZVTFJRA(this.a, aIClient3.cm(upperCase));
                    str = zZVTFJRA;
                }
                String str2 = str;
                if (str == null) {
                    str2 = "NA";
                }
                this.b.handler(str2);
            } else {
                this.b.handler("NA_F");
            }
            lock2 = DUHelper.f;
            lock2.unlock();
        }
    }
}
