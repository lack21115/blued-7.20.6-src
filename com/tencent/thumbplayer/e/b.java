package com.tencent.thumbplayer.e;

import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/e/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f25610a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f25611c;
    private String d;
    private String e;

    public b(b bVar, String str) {
        this.f25610a = "";
        this.b = "";
        this.f25611c = "";
        this.d = "";
        this.e = "TPLogger";
        a(bVar, str);
    }

    public b(String str) {
        this(str, "", "", "");
    }

    public b(String str, String str2, String str3, String str4) {
        this.f25610a = "";
        this.b = "";
        this.f25611c = "";
        this.d = "";
        this.e = "TPLogger";
        this.f25610a = str;
        this.b = str2;
        this.f25611c = str3;
        this.d = str4;
        b();
    }

    private void b() {
        this.e = this.f25610a;
        if (!TextUtils.isEmpty(this.b)) {
            this.e += "_C" + this.b;
        }
        if (!TextUtils.isEmpty(this.f25611c)) {
            this.e += "_T" + this.f25611c;
        }
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        this.e += "_" + this.d;
    }

    public String a() {
        return this.e;
    }

    public void a(b bVar, String str) {
        String str2;
        if (bVar != null) {
            this.f25610a = bVar.f25610a;
            this.b = bVar.b;
            str2 = bVar.f25611c;
        } else {
            str2 = "";
            this.f25610a = "";
            this.b = "";
        }
        this.f25611c = str2;
        this.d = str;
        b();
    }

    public void a(String str) {
        this.f25611c = str;
        b();
    }

    public String toString() {
        return "TPLoggerContext{prefix='" + this.f25610a + "', classId='" + this.b + "', taskId='" + this.f25611c + "', model='" + this.d + "', tag='" + this.e + "'}";
    }
}
