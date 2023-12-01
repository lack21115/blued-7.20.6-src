package com.tencent.beacon.e;

import java.util.Calendar;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/e/a.class */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f35014a;
    public boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private String f35015c = "oth.str.mdt.qq.com";
    private int d = 360;
    private int e = 100;
    private Map<String, String> f = null;
    private boolean g = false;
    private e h = new e(1);

    private a() {
    }

    public static a a() {
        if (f35014a == null) {
            synchronized (a.class) {
                try {
                    if (f35014a == null) {
                        f35014a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f35014a;
    }

    public String a(String str) {
        Map<String, String> a2;
        e eVar = this.h;
        if (eVar == null || (a2 = eVar.a()) == null) {
            return null;
        }
        return a2.get(str);
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
                com.tencent.beacon.base.util.c.a(e);
            }
            return i;
        }
    }

    public e d() {
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
