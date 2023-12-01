package com.tencent.thumbplayer.tplayer.a;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/a/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Integer, String> f25702a;
    private int b = 1;

    static {
        HashMap hashMap = new HashMap();
        f25702a = hashMap;
        hashMap.put(1, "IDLE");
        f25702a.put(2, "PREPARING");
        f25702a.put(3, "PREPARED");
    }

    public void a(int i) {
        synchronized (this) {
            this.b = i;
        }
    }

    public boolean b(int i) {
        boolean z;
        synchronized (this) {
            z = this.b == i;
        }
        return z;
    }

    public String toString() {
        String str;
        synchronized (this) {
            str = "state[ cur : " + f25702a.get(Integer.valueOf(this.b)) + " ]";
        }
        return str;
    }
}
