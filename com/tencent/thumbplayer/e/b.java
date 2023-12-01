package com.tencent.thumbplayer.e;

import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/e/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f39301a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f39302c;
    private String d;
    private String e;

    public b(b bVar, String str) {
        this.f39301a = "";
        this.b = "";
        this.f39302c = "";
        this.d = "";
        this.e = "TPLogger";
        a(bVar, str);
    }

    public b(String str) {
        this(str, "", "", "");
    }

    public b(String str, String str2, String str3, String str4) {
        this.f39301a = "";
        this.b = "";
        this.f39302c = "";
        this.d = "";
        this.e = "TPLogger";
        this.f39301a = str;
        this.b = str2;
        this.f39302c = str3;
        this.d = str4;
        b();
    }

    private void b() {
        this.e = this.f39301a;
        if (!TextUtils.isEmpty(this.b)) {
            this.e += "_C" + this.b;
        }
        if (!TextUtils.isEmpty(this.f39302c)) {
            this.e += "_T" + this.f39302c;
        }
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        this.e += BridgeUtil.UNDERLINE_STR + this.d;
    }

    public String a() {
        return this.e;
    }

    public void a(b bVar, String str) {
        String str2;
        if (bVar != null) {
            this.f39301a = bVar.f39301a;
            this.b = bVar.b;
            str2 = bVar.f39302c;
        } else {
            str2 = "";
            this.f39301a = "";
            this.b = "";
        }
        this.f39302c = str2;
        this.d = str;
        b();
    }

    public void a(String str) {
        this.f39302c = str;
        b();
    }

    public String toString() {
        return "TPLoggerContext{prefix='" + this.f39301a + "', classId='" + this.b + "', taskId='" + this.f39302c + "', model='" + this.d + "', tag='" + this.e + "'}";
    }
}
