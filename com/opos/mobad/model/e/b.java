package com.opos.mobad.model.e;

import android.os.SystemClock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/e/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Long> f26484a = new ConcurrentHashMap();
    private Map<String, Integer> b = new ConcurrentHashMap();

    public void a(String str) {
        this.f26484a.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public void a(String str, int i) {
        this.b.put(str, Integer.valueOf(i));
    }

    public boolean b(String str) {
        Integer num;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Long l = this.f26484a.get(str);
        long longValue = l != null ? l.longValue() : 0L;
        boolean z = false;
        if (elapsedRealtime >= Integer.valueOf(this.b.get(str) != null ? num.intValue() : 0).intValue() + Long.valueOf(longValue).longValue()) {
            z = true;
        }
        return z;
    }
}
