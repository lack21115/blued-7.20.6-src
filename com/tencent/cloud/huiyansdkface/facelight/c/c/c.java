package com.tencent.cloud.huiyansdkface.facelight.c.c;

import android.content.Context;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/c/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final b f35565a;
    private static boolean b;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/c/c$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static com.tencent.cloud.huiyansdkface.facelight.c.c.a f35566a = new com.tencent.cloud.huiyansdkface.facelight.c.c.a();

        public static com.tencent.cloud.huiyansdkface.facelight.c.c.a a() {
            return f35566a;
        }
    }

    static {
        try {
            Class.forName("com.tencent.bugly.idasc.crashreport.CrashReport");
            b = true;
        } catch (ClassNotFoundException e) {
            b = false;
        }
        f35565a = new b() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.c.c.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.c.c.b
            public void a() {
                WLogger.d("WbCrashReportProviders", "close empty crash report");
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.c.c.b
            public void a(Context context) {
                WLogger.d("WbCrashReportProviders", "init empty crash report");
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.c.c.b
            public void a(String str) {
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.c.c.b
            public void a(String str, String str2) {
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.c.c.b
            public void b(String str, String str2) {
            }
        };
    }

    public static b a() {
        return b ? a.a() : f35565a;
    }
}
