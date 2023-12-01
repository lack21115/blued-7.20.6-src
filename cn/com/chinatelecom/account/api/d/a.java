package cn.com.chinatelecom.account.api.d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/d/a.class */
public class a {
    private static Executor b = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    public Handler f4075a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        b.execute(runnable);
    }
}
