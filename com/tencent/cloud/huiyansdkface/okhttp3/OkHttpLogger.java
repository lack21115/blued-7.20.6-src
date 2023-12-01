package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/OkHttpLogger.class */
public class OkHttpLogger {

    /* renamed from: a  reason: collision with root package name */
    private static Log f22183a = new Log() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.OkHttpLogger.1
        @Override // com.tencent.cloud.huiyansdkface.okhttp3.OkHttpLogger.Log
        public void log(String str, Throwable th) {
            Platform.get().log(4, str, th);
        }
    };

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/OkHttpLogger$Log.class */
    public interface Log {
        void log(String str, Throwable th);
    }

    public static void log(String str) {
        log(str, null);
    }

    public static void log(String str, Throwable th) {
        f22183a.log(str, th);
    }

    public static void proxy(Log log) {
        if (log != null) {
            f22183a = log;
        }
    }
}
