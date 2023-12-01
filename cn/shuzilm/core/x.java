package cn.shuzilm.core;

/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/x.class */
final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4202a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ DUListener f4203c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(String str, String str2, DUListener dUListener) {
        this.f4202a = str;
        this.b = str2;
        this.f4203c = dUListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Main.mLock.lock();
            IDUService iDUService = DUConnection.duService;
            if (iDUService != null && iDUService.asBinder().isBinderAlive()) {
                iDUService.getQueryIDAsyn(this.f4202a, this.b, this.f4203c);
            }
            Main.mLock.unlock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
