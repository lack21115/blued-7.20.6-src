package cn.shuzilm.core;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/q.class */
public class q implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ DUHelper b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(DUHelper dUHelper, int i) {
        this.b = dUHelper;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DUHelper.getQueryID(DUHelper.mContext, "NA", "", 1, null, this.a + 100);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
