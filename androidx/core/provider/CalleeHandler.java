package androidx.core.provider;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/CalleeHandler.class */
class CalleeHandler {
    private CalleeHandler() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Handler a() {
        return Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
    }
}
