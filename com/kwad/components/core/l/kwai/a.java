package com.kwad.components.core.l.kwai;

import android.os.SystemClock;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/l/kwai/a.class */
public final class a {
    private String NY;
    private long NZ;
    private long Oa;
    private long Ob;
    private boolean Oc;

    public final void ax(String str) {
        this.NY = str;
    }

    public final void pa() {
        if (this.Oc) {
            return;
        }
        this.Oc = true;
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.l.kwai.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.Ob = SystemClock.uptimeMillis();
                a.this.report();
            }
        });
    }

    public final void report() {
        b bVar = new b();
        bVar.NY = this.NY;
        long j = this.NZ;
        bVar.Of = j != 0 ? this.Oa - j : 0L;
        long j2 = this.Oa;
        bVar.Og = j2 != 0 ? this.Ob - j2 : 0L;
        long j3 = this.NZ;
        long j4 = 0;
        if (j3 != 0) {
            j4 = this.Ob - j3;
        }
        bVar.Oe = j4;
        com.kwad.components.core.m.a.pb().a(bVar);
        com.kwad.sdk.core.d.b.d("PageMonitor", bVar.toString());
    }

    public final void u(long j) {
        this.NZ = j;
        this.Oa = SystemClock.uptimeMillis();
    }
}
