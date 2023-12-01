package cn.shuzilm.core;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/v.class */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4199a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(String str, String str2) {
        this.f4199a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Main.mLock.lock();
            IDUService iDUService = DUConnection.duService;
            if (iDUService != null && iDUService.asBinder().isBinderAlive()) {
                int unused = Main.e = iDUService.setConfig(this.f4199a, this.b);
            }
            Main.mLock.unlock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
