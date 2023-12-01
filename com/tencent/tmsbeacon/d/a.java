package com.tencent.tmsbeacon.d;

import java.util.Calendar;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/d/a.class */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f39540a;
    public boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private String f39541c = "oth.str.mdt.qq.com";
    private int d = 360;
    private int e = 100;
    private Map<String, String> f = null;
    private boolean g = false;
    private d h = new d(1);

    private a() {
    }

    public static a a() {
        if (f39540a == null) {
            synchronized (a.class) {
                try {
                    if (f39540a == null) {
                        f39540a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f39540a;
    }

    @Override // com.tencent.tmsbeacon.d.c
    public String a(String str) {
        synchronized (this) {
            Map<String, String> map = this.f;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(Map<String, String> map) {
        synchronized (this) {
            this.f = map;
        }
    }

    public int b() {
        return this.d;
    }

    public String b(String str) {
        Map<String, String> a2;
        d dVar = this.h;
        if (dVar == null || (a2 = dVar.a()) == null) {
            return null;
        }
        return a2.get(str);
    }

    public int c() {
        String str;
        synchronized (this) {
            Map<String, String> map = this.f;
            if (map == null || (str = map.get("maxStrategyQueryOneDay")) == null || str.trim().equals("")) {
                return this.e;
            }
            int i = this.e;
            try {
                i = Integer.parseInt(str);
            } catch (Exception e) {
                com.tencent.tmsbeacon.base.util.c.a(e);
            }
            return i;
        }
    }

    public d d() {
        return this.h;
    }

    public boolean e() {
        synchronized (this) {
            Map<String, String> map = this.f;
            boolean z = false;
            if (map == null || !"y".equalsIgnoreCase(map.get("zeroPeak"))) {
                return false;
            }
            if (Calendar.getInstance().get(11) == 0) {
                z = true;
            }
            return z;
        }
    }
}
