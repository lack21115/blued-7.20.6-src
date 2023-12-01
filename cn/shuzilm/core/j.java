package cn.shuzilm.core;

/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/j.class */
final class j implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            System.loadLibrary(com.umeng.analytics.pro.d.W);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
