package com.tencent.liteav.txcplayer.a;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcplayer/a/a.class */
public final class a extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    public static ThreadPoolExecutor f22782a;

    private a() {
        super(1, 3, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    }

    public static ThreadPoolExecutor a() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (a.class) {
            try {
                if (f22782a == null || f22782a.isShutdown()) {
                    f22782a = new a();
                }
                threadPoolExecutor = f22782a;
            } finally {
            }
        }
        return threadPoolExecutor;
    }
}
