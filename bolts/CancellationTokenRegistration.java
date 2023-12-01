package bolts;

import java.io.Closeable;

/* loaded from: source-8756600-dex2jar.jar:bolts/CancellationTokenRegistration.class */
public class CancellationTokenRegistration implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3687a;
    private CancellationTokenSource b;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f3688c;
    private boolean d;

    private void b() {
        if (this.d) {
            throw new IllegalStateException("Object already closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        synchronized (this.f3687a) {
            b();
            this.f3688c.run();
            close();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f3687a) {
            if (this.d) {
                return;
            }
            this.d = true;
            this.b.a(this);
            this.b = null;
            this.f3688c = null;
        }
    }
}
