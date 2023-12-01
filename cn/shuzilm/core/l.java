package cn.shuzilm.core;

import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/l.class */
public final class l implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Lock lock;
        Lock lock2;
        Lock lock3;
        AIClient aIClient;
        lock = DUHelper.f;
        if (lock.tryLock()) {
            try {
                AIClient unused = DUHelper.f4163c = new AIClient(DUHelper.mContext);
                aIClient = DUHelper.f4163c;
                aIClient.asynAI();
            } catch (Exception e) {
            } catch (Throwable th) {
                lock2 = DUHelper.f;
                lock2.unlock();
                throw th;
            }
            lock3 = DUHelper.f;
            lock3.unlock();
        }
    }
}
