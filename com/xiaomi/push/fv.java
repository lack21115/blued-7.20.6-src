package com.xiaomi.push;

import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fv.class */
public class fv implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static String f27732a = "wcc-ml-test10.bj";
    public static final String b = ae.f27554a;

    /* renamed from: c  reason: collision with root package name */
    public static String f27733c = null;

    /* renamed from: a  reason: collision with other field name */
    private int f449a;

    /* renamed from: a  reason: collision with other field name */
    private fy f450a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f451a = fu.f434a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f452b = true;
    private String d;
    private String e;
    private String f;

    public fv(Map<String, Integer> map, int i, String str, fy fyVar) {
        a(map, i, str, fyVar);
    }

    public static final String a() {
        String str = f27733c;
        return str != null ? str : aa.m8445a() ? "sandbox.xmpush.xiaomi.com" : aa.b() ? b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        if (j.m8998a(r.m9016a()) && aa.b()) {
            return;
        }
        f27733c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fy fyVar) {
        this.f449a = i;
        this.d = str;
        this.f450a = fyVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m8742a() {
        return this.f449a;
    }

    public void a(boolean z) {
        this.f451a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8743a() {
        return this.f451a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] mo8744a() {
        return null;
    }

    public String b() {
        return this.f;
    }

    public void b(String str) {
        this.f = str;
    }

    public String c() {
        if (this.e == null) {
            this.e = a();
        }
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }
}
