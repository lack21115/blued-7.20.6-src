package cn.shuzilm.core;

/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/q.class */
class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f4194a;
    final /* synthetic */ DUHelper b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(DUHelper dUHelper, int i) {
        this.b = dUHelper;
        this.f4194a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DUHelper.getQueryID(DUHelper.mContext, "NA", "", 1, null, this.f4194a + 100);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
