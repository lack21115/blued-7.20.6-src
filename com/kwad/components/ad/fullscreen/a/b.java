package com.kwad.components.ad.fullscreen.a;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/fullscreen/a/b.class */
public class b extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat gp = new SimpleDateFormat("yyyy-MM-dd");
    public long gq;
    public int gr;

    public b() {
        this.gq = -1L;
        this.gr = -1;
    }

    public b(long j, int i) {
        this.gq = -1L;
        this.gr = -1;
        this.gq = j;
        this.gr = 1;
    }

    public final boolean e(long j) {
        if (this.gq <= 0 || j <= 0) {
            return false;
        }
        try {
            return gp.format(new Date(this.gq)).equals(gp.format(new Date(j)));
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return false;
        }
    }

    public final boolean z(int i) {
        int i2 = this.gr;
        return i2 > 0 && i2 >= i;
    }
}
