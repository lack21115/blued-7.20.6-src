package com.tencent.cloud.huiyansdkface.a.b;

import android.os.Build;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/b/c.class */
public class c extends Throwable {

    /* renamed from: c  reason: collision with root package name */
    private static String f21749c = a();

    /* renamed from: a  reason: collision with root package name */
    private int f21750a;
    private String b;

    public c(int i, String str, Throwable th, String str2) {
        super(str, th);
        this.b = "type_normal";
        this.f21750a = i;
        this.b = str2;
    }

    public static c a(int i, String str) {
        return new c(i, str, null, "type_status");
    }

    public static c a(int i, String str, Throwable th) {
        return new c(i, str, th, "type_device");
    }

    public static String a() {
        return "BRAND:" + Build.BRAND + "\nMODEL:" + Build.MODEL + "\nSDK_INT:" + Build.VERSION.SDK_INT + "\nVERSION:release_1.0.41.14\nVERSION_CODE:58\n";
    }

    public static c b(int i, String str, Throwable th) {
        return new c(i, str, th, "type_fatal");
    }

    public int b() {
        return this.f21750a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return super.getMessage();
    }
}
