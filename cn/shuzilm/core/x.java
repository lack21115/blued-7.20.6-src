package cn.shuzilm.core;

/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/x.class */
final class x implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ DUListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(String str, String str2, DUListener dUListener) {
        this.a = str;
        this.b = str2;
        this.c = dUListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Main.mLock.lock();
            IDUService iDUService = DUConnection.duService;
            if (iDUService != null && iDUService.asBinder().isBinderAlive()) {
                iDUService.getQueryIDAsyn(this.a, this.b, this.c);
            }
            Main.mLock.unlock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
