package com.tencent.qimei.sdk;

import android.text.TextUtils;
import com.tencent.qimei.v.d;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/sdk/Qimei.class */
public final class Qimei {

    /* renamed from: a  reason: collision with root package name */
    public String f38414a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f38415c;

    public Qimei() {
        this("", "");
    }

    public Qimei(String str, String str2) {
        this.b = str == null ? "" : str;
        this.f38415c = str2 == null ? "" : str2;
    }

    public String a() {
        return this.b;
    }

    @Deprecated
    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.f38415c;
    }

    public void b(String str) {
        this.f38415c = str;
    }

    public String getQimei16() {
        return !d.a(this.f38414a).i() ? "" : this.b;
    }

    public String getQimei36() {
        return !d.a(this.f38414a).G() ? "" : this.f38415c;
    }

    public boolean isEmpty() {
        String str = this.b;
        if (str == null || str.isEmpty()) {
            String str2 = this.f38415c;
            return str2 == null || str2.isEmpty();
        }
        return false;
    }

    public void setAppKey(String str) {
        this.f38414a = str;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Q16:");
        sb.append(this.b);
        if (TextUtils.isEmpty(this.f38415c)) {
            str = "";
        } else {
            str = "\nQ36:" + this.f38415c;
        }
        sb.append(str);
        return sb.toString();
    }
}
