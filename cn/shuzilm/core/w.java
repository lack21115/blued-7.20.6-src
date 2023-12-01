package cn.shuzilm.core;

/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/w.class */
final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4200a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f4201c;
    final /* synthetic */ DUListener d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(String str, String str2, String str3, DUListener dUListener) {
        this.f4200a = str;
        this.b = str2;
        this.f4201c = str3;
        this.d = dUListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        Main.mLock.lock();
        try {
            try {
                IDUService iDUService = DUConnection.duService;
                if (iDUService != null && iDUService.asBinder().isBinderAlive()) {
                    iDUService.onEventAsyn(this.f4200a, this.b, this.f4201c, this.d);
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
