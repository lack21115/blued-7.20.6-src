package mtopsdk.a;

import java.util.concurrent.CancellationException;
import mtopsdk.a.b.g;
import mtopsdk.common.util.TBSdkLog;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/a/e.class */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private f f43674a;
    private /* synthetic */ c b;

    public e(c cVar, mtopsdk.a.b.b bVar, f fVar) {
        this.b = cVar;
        this.f43674a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.b.f43671a) {
                TBSdkLog.a("mtopsdk.DefaultCallImpl", "call task is canceled.");
                this.f43674a.a(this.b);
                return;
            }
            g b = this.b.b();
            if (b == null) {
                this.f43674a.a(this.b, new Exception("response is null"));
            } else {
                this.f43674a.a(this.b, b);
            }
        } catch (InterruptedException e) {
            this.f43674a.a(this.b);
        } catch (CancellationException e2) {
            this.f43674a.a(this.b);
        } catch (Exception e3) {
            this.f43674a.a(this.b, e3);
            TBSdkLog.b("mtopsdk.DefaultCallImpl", "do call.execute failed.", e3);
        }
    }
}
