package mtopsdk.a;

import java.util.concurrent.CancellationException;
import mtopsdk.a.b.g;
import mtopsdk.common.util.TBSdkLog;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/a/e.class */
final class e implements Runnable {
    private f a;
    private /* synthetic */ c b;

    public e(c cVar, mtopsdk.a.b.b bVar, f fVar) {
        this.b = cVar;
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.b.a) {
                TBSdkLog.a("mtopsdk.DefaultCallImpl", "call task is canceled.");
                this.a.a(this.b);
                return;
            }
            g b = this.b.b();
            if (b == null) {
                this.a.a(this.b, new Exception("response is null"));
            } else {
                this.a.a(this.b, b);
            }
        } catch (InterruptedException e) {
            this.a.a(this.b);
        } catch (CancellationException e2) {
            this.a.a(this.b);
        } catch (Exception e3) {
            this.a.a(this.b, e3);
            TBSdkLog.b("mtopsdk.DefaultCallImpl", "do call.execute failed.", e3);
        }
    }
}
