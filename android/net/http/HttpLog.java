package android.net.http;

import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/net/http/HttpLog.class */
public class HttpLog {
    private static final boolean DEBUG = false;
    private static final String LOGTAG = "http";
    static final boolean LOGV = false;

    HttpLog() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(String str) {
        Log.e("http", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void v(String str) {
        Log.v("http", SystemClock.uptimeMillis() + " " + Thread.currentThread().getName() + " " + str);
    }
}
