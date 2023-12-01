package com.igexin.push.core.b;

import com.igexin.push.core.d;
import com.igexin.push.extension.mod.BaseActionBean;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/b/q.class */
public final class q extends BaseActionBean {

    /* renamed from: a  reason: collision with root package name */
    public String f9848a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9849c;
    public String d;

    private void a(String str) {
        this.f9848a = str;
    }

    private String b() {
        return this.f9848a;
    }

    private void b(String str) {
        this.d = str;
    }

    private boolean c() {
        return this.b;
    }

    private void d() {
        this.b = true;
    }

    private boolean e() {
        return this.f9849c;
    }

    private void f() {
        this.f9849c = true;
    }

    private String g() {
        return this.d;
    }

    public final String a() {
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        String str2;
        String str3 = this.f9848a;
        String str4 = str3;
        if (this.b) {
            if (str3.indexOf("?") > 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str3);
                str2 = "&cid=";
                sb2 = sb3;
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str3);
                sb2 = sb4;
                str2 = "?cid=";
            }
            sb2.append(str2);
            sb2.append(com.igexin.push.core.e.A);
            str4 = sb2.toString();
        }
        String str5 = str4;
        if (this.f9849c) {
            com.igexin.push.core.d unused = d.a.f9866a;
            String d = com.igexin.push.core.d.d();
            str5 = str4;
            if (d != null) {
                if (str4.indexOf("?") > 0) {
                    sb = new StringBuilder();
                    sb.append(str4);
                    str = "&nettype=";
                } else {
                    sb = new StringBuilder();
                    sb.append(str4);
                    str = "?nettype=";
                }
                sb.append(str);
                sb.append(d);
                str5 = sb.toString();
            }
        }
        return str5;
    }
}
