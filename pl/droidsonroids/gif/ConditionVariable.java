package pl.droidsonroids.gif;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/ConditionVariable.class */
class ConditionVariable {
    private volatile boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        synchronized (this) {
            boolean z = this.a;
            this.a = true;
            if (!z) {
                notify();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        synchronized (this) {
            if (z) {
                a();
            } else {
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        synchronized (this) {
            this.a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() throws InterruptedException {
        synchronized (this) {
            while (!this.a) {
                wait();
            }
        }
    }
}
