package com.kwad.components.ad.splashscreen.local;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/local/a.class */
public class a extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat gp = new SimpleDateFormat("yyyy-MM-dd");
    public Map<Long, Integer> BT;
    public String BU;
    public long gq;

    public a() {
        this.gq = -1L;
        this.BT = new HashMap();
    }

    public a(long j, long j2, int i) {
        this.gq = -1L;
        HashMap hashMap = new HashMap();
        this.BT = hashMap;
        this.gq = j;
        hashMap.put(Long.valueOf(j2), 1);
    }

    public final boolean a(long j, int i) {
        return this.BT.get(Long.valueOf(j)) != null && this.BT.get(Long.valueOf(j)).intValue() >= i;
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
}
