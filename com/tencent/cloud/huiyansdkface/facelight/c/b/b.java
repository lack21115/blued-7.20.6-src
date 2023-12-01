package com.tencent.cloud.huiyansdkface.facelight.c.b;

import android.os.Handler;
import android.os.Looper;
import com.tencent.cloud.huiyansdkface.facelight.common.WbThreadFactory;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f35544a = b.class.getName();
    private static Handler b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private static ExecutorService f35545c = Executors.newFixedThreadPool(1, new WbThreadFactory("wbcfFaceDetect"));

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/b/b$a.class */
    public interface a<T> {
        void a(T t);
    }

    public static void a(Runnable runnable) {
        f35545c.submit(runnable);
    }

    public static <T> void a(final Callable<T> callable, final a<T> aVar) {
        if (f35545c.isShutdown()) {
            WLogger.w(f35544a, "already shutDown!");
        } else {
            f35545c.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    Object obj;
                    try {
                        obj = Callable.this.call();
                    } catch (Exception e) {
                        e.printStackTrace();
                        obj = null;
                    }
                    final Object obj2 = obj;
                    b.b.post(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.b.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (aVar != null) {
                                try {
                                    aVar.a(obj2);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    });
                }
            });
        }
    }
}
