package com.opos.mobad.service.j;

import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/j/i.class */
public class i implements d {

    /* renamed from: a  reason: collision with root package name */
    private long f13707a = 0;
    private int b;

    public i(int i) {
        this.b = i;
    }

    @Override // com.opos.mobad.service.j.d
    public boolean a(Object obj) {
        long j = this.f13707a;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j <= 0) {
            this.f13707a = elapsedRealtime;
            return false;
        } else if (elapsedRealtime - this.f13707a >= this.b) {
            this.f13707a = SystemClock.elapsedRealtime();
            return true;
        } else {
            return false;
        }
    }
}
