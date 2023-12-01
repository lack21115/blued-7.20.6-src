package com.tencent.cloud.huiyansdkface.a.a.b;

import android.hardware.Camera;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/a/b/c.class */
public class c {
    public static g<String> a() {
        return a(Camera.Parameters.FOCUS_MODE_FIXED);
    }

    private static g<String> a(String str) {
        return new g<>(str);
    }

    public static g<String> b() {
        return a("auto");
    }

    public static g<String> c() {
        return a("continuous-picture");
    }

    public static g<String> d() {
        return a("continuous-video");
    }

    public static com.tencent.cloud.huiyansdkface.a.a.g<String> e() {
        return b.a(d(), b(), a());
    }
}
