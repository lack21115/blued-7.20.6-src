package com.anythink.expressad.foundation.g.f;

import android.os.Process;
import com.anythink.expressad.foundation.h.o;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7911a = h.class.getSimpleName();
    private com.anythink.expressad.foundation.g.f.e.a b;

    /* renamed from: c  reason: collision with root package name */
    private g f7912c;
    private c d;

    public h(SSLSocketFactory sSLSocketFactory, c cVar) {
        this.b = new com.anythink.expressad.foundation.g.f.e.b(sSLSocketFactory, null);
        this.f7912c = new com.anythink.expressad.foundation.g.f.f.a(this.b, cVar);
        this.d = cVar;
    }

    private void b(i iVar) {
        try {
            this.d.c(iVar);
            if (iVar.f()) {
                iVar.c();
                this.d.b(iVar);
                this.d.a(iVar);
                return;
            }
            this.d.d(iVar);
            this.d.a(iVar, iVar.a(this.f7912c.a(iVar)));
        } catch (com.anythink.expressad.foundation.g.f.a.a e) {
            this.d.a(iVar, i.a(e));
        } catch (Exception e2) {
            String str = f7911a;
            o.d(str, "Unhandled exception " + e2.getMessage());
            this.d.a(iVar, new com.anythink.expressad.foundation.g.f.a.a(4, null));
        }
    }

    public final void a(i iVar) {
        Process.setThreadPriority(10);
        try {
            this.d.c(iVar);
            if (iVar.f()) {
                iVar.c();
                this.d.b(iVar);
                this.d.a(iVar);
                return;
            }
            this.d.d(iVar);
            this.d.a(iVar, iVar.a(this.f7912c.a(iVar)));
        } catch (com.anythink.expressad.foundation.g.f.a.a e) {
            this.d.a(iVar, i.a(e));
        } catch (Exception e2) {
            String str = f7911a;
            o.d(str, "Unhandled exception " + e2.getMessage());
            this.d.a(iVar, new com.anythink.expressad.foundation.g.f.a.a(4, null));
        }
    }
}
