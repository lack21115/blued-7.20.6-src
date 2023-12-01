package cn.shuzilm.core;

/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/j.class */
final class j implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            System.loadLibrary("du");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
