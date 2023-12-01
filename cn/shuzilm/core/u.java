package cn.shuzilm.core;

/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/u.class */
final class u implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Main.mLock.lock();
            IDUService iDUService = DUConnection.duService;
            if (iDUService != null && iDUService.asBinder().isBinderAlive()) {
                int unused = Main.e = iDUService.setData(this.a, this.b);
            }
            Main.mLock.unlock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
