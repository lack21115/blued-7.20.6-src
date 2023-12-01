package com.xiaomi.push;

import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fv.class */
public class fv implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static String f41423a = "wcc-ml-test10.bj";
    public static final String b = ae.f41245a;

    /* renamed from: c  reason: collision with root package name */
    public static String f41424c = null;

    /* renamed from: a  reason: collision with other field name */
    private int f496a;

    /* renamed from: a  reason: collision with other field name */
    private fy f497a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f498a = fu.f481a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f499b = true;
    private String d;
    private String e;
    private String f;

    public fv(Map<String, Integer> map, int i, String str, fy fyVar) {
        a(map, i, str, fyVar);
    }

    public static final String a() {
        String str = f41424c;
        return str != null ? str : aa.m11495a() ? "sandbox.xmpush.xiaomi.com" : aa.b() ? b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        if (j.m12048a(r.m12066a()) && aa.b()) {
            return;
        }
        f41424c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fy fyVar) {
        this.f496a = i;
        this.d = str;
        this.f497a = fyVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m11792a() {
        return this.f496a;
    }

    public void a(boolean z) {
        this.f498a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11793a() {
        return this.f498a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] mo11794a() {
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
