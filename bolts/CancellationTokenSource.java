package bolts;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/* loaded from: source-8756600-dex2jar.jar:bolts/CancellationTokenSource.class */
public class CancellationTokenSource implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3641a = new Object();
    private final List<CancellationTokenRegistration> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f3642c = BoltsExecutors.b();
    private ScheduledFuture<?> d;
    private boolean e;
    private boolean f;

    /* renamed from: bolts.CancellationTokenSource$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:bolts/CancellationTokenSource$1.class */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancellationTokenSource f3643a;

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f3643a.f3641a) {
                this.f3643a.d = null;
            }
            this.f3643a.c();
        }
    }

    private void a(List<CancellationTokenRegistration> list) {
        for (CancellationTokenRegistration cancellationTokenRegistration : list) {
            cancellationTokenRegistration.a();
        }
    }

    private void d() {
        if (this.f) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void e() {
        ScheduledFuture<?> scheduledFuture = this.d;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(CancellationTokenRegistration cancellationTokenRegistration) {
        synchronized (this.f3641a) {
            d();
            this.b.remove(cancellationTokenRegistration);
        }
    }

    public boolean a() {
        boolean z;
        synchronized (this.f3641a) {
            d();
            z = this.e;
        }
        return z;
    }

    public CancellationToken b() {
        CancellationToken cancellationToken;
        synchronized (this.f3641a) {
            d();
            cancellationToken = new CancellationToken(this);
        }
        return cancellationToken;
    }

    public void c() {
        synchronized (this.f3641a) {
            d();
            if (this.e) {
                return;
            }
            e();
            this.e = true;
            a(new ArrayList(this.b));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f3641a) {
            if (this.f) {
                return;
            }
            e();
            for (CancellationTokenRegistration cancellationTokenRegistration : this.b) {
                cancellationTokenRegistration.close();
            }
            this.b.clear();
            this.f = true;
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(a()));
    }
}
