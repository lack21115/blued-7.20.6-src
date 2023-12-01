package com.kwad.components.core.i;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/i/a.class */
public class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    private static SimpleDateFormat JQ = new SimpleDateFormat("yyyy-MM-dd");
    public int JR;
    public long JS;

    public final boolean h(int i, int i2) {
        com.kwad.sdk.core.d.b.d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i + ", forceActiveThreshold: " + i2);
        if (this.JS <= 0) {
            nE();
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String format = JQ.format(new Date(this.JS));
        String format2 = JQ.format(new Date(currentTimeMillis));
        com.kwad.sdk.core.d.b.d("AdForceActiveInfo", "checkAndAddCount lastDate: " + format + ", currentDate: " + format2);
        if (!format.equals(format2)) {
            this.JR = 0;
            nE();
            return true;
        }
        long j = this.JS + (i * 60 * 60 * 1000);
        com.kwad.sdk.core.d.b.d("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j + ", currentActiveCount: " + this.JR);
        if (j >= currentTimeMillis || this.JR > i2) {
            return false;
        }
        nE();
        return true;
    }

    public final void nE() {
        this.JS = System.currentTimeMillis();
        this.JR++;
        com.kwad.sdk.core.d.b.d("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.JS + ", currentActiveCount " + this.JR);
    }
}
