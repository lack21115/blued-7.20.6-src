package com.tencent.cloud.huiyansdkface.a.a.b;

import android.hardware.Camera;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/a/b/b.class */
public class b {
    public static com.tencent.cloud.huiyansdkface.a.a.g<String> a() {
        return a("off");
    }

    public static com.tencent.cloud.huiyansdkface.a.a.g<String> a(String str) {
        return new g(str);
    }

    public static <T> com.tencent.cloud.huiyansdkface.a.a.g<T> a(com.tencent.cloud.huiyansdkface.a.a.g<T>... gVarArr) {
        return new a(gVarArr);
    }

    public static com.tencent.cloud.huiyansdkface.a.a.g<String> b() {
        return a("auto");
    }

    public static com.tencent.cloud.huiyansdkface.a.a.g<String> c() {
        return a("torch");
    }

    public static com.tencent.cloud.huiyansdkface.a.a.g<String> d() {
        return a(Camera.Parameters.FLASH_MODE_RED_EYE);
    }
}
