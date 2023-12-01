package cn.shuzilm.core;

/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/w.class */
final class w implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ DUListener d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(String str, String str2, String str3, DUListener dUListener) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = dUListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        Main.mLock.lock();
        try {
            try {
                IDUService iDUService = DUConnection.duService;
                if (iDUService != null && iDUService.asBinder().isBinderAlive()) {
                    iDUService.onEventAsyn(this.a, this.b, this.c, this.d);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Main.mLock.unlock();
        } catch (Throwable th) {
            Main.mLock.unlock();
            throw th;
        }
    }
}
