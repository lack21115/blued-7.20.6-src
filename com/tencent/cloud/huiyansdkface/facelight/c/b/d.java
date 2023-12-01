package com.tencent.cloud.huiyansdkface.facelight.c.b;

import android.os.Handler;
import android.os.Looper;
import com.tencent.cloud.huiyansdkface.facelight.common.WbThreadFactory;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/b/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21861a = d.class.getName();
    private Handler b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f21862c = Executors.newFixedThreadPool(1, new WbThreadFactory("wbcfSub"));

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/b/d$a.class */
    public interface a<T> {
        void a(T t);
    }

    public <T> void a(final Callable<T> callable, final a<T> aVar) {
        if (this.f21862c.isShutdown()) {
            WLogger.w(f21861a, "already shutDown!");
        } else {
            this.f21862c.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.b.d.1
                @Override // java.lang.Runnable
                public void run() {
                    Object obj;
                    try {
                        obj = callable.call();
                    } catch (Exception e) {
                        e.printStackTrace();
                        obj = null;
                    }
                    final Object obj2 = obj;
                    d.this.b.post(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.b.d.1.1
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
