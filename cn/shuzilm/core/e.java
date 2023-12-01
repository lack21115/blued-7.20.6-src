package cn.shuzilm.core;

import android.content.Context;
import android.os.Build;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/e.class */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4181a;
    final /* synthetic */ DUListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, DUListener dUListener) {
        this.f4181a = context;
        this.b = dUListener;
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
            aIClient = DUHelper.f4163c;
            if (aIClient == null) {
                AIClient unused3 = DUHelper.f4163c = new AIClient(this.f4181a);
                aIClient5 = DUHelper.f4163c;
                aIClient5.asynAI();
            }
            unused = DUHelper.f4163c;
            if (!AIClient.isf) {
                aIClient4 = DUHelper.f4163c;
                aIClient4.asynAI();
            }
            unused2 = DUHelper.f4163c;
            if (AIClient.isf) {
                String str = null;
                String upperCase = Build.MANUFACTURER.toUpperCase();
                aIClient2 = DUHelper.f4163c;
                if (aIClient2.m(upperCase)) {
                    aIClient3 = DUHelper.f4163c;
                    zZVTFJRA = DUHelper.zZVTFJRA(this.f4181a, aIClient3.cm(upperCase));
                    str = zZVTFJRA;
                }
                String str2 = str;
                if (str == null) {
                    str2 = "NA";
                }
                this.b.handle(str2);
            } else {
                this.b.handle("NA_F");
            }
            lock2 = DUHelper.f;
            lock2.unlock();
        }
    }
}
