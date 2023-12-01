package com.amap.api.col.p0003sl;

import android.os.Build;
import com.igexin.assist.util.AssistUtils;

/* renamed from: com.amap.api.col.3sl.iq  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/iq.class */
public enum iq {
    MIUI(AssistUtils.BRAND_XIAOMI),
    Flyme(AssistUtils.BRAND_MZ),
    EMUI(AssistUtils.BRAND_HW),
    ColorOS(AssistUtils.BRAND_OPPO),
    FuntouchOS(AssistUtils.BRAND_VIVO),
    SmartisanOS("smartisan"),
    AmigoOS("amigo"),
    EUI("letv"),
    Sense("htc"),
    LG("lge"),
    Google("google"),
    NubiaUI("nubia"),
    Other("");
    
    private String n;
    private int o;
    private String p;
    private String q;
    private String r = Build.MANUFACTURER;

    iq(String str) {
        this.n = str;
    }

    public final String a() {
        return this.n;
    }

    public final void a(int i) {
        this.o = i;
    }

    public final void a(String str) {
        this.p = str;
    }

    public final String b() {
        return this.p;
    }

    public final void b(String str) {
        this.q = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.o + ", versionName='" + this.q + "',ma=" + this.n + "',manufacturer=" + this.r + "'}";
    }
}
