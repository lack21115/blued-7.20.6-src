package com.opos.cmn.an.j;

import com.opos.cmn.an.j.a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/j/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static com.opos.cmn.an.j.a f10892a;
    private static com.opos.cmn.an.j.a b;

    /* renamed from: c  reason: collision with root package name */
    private static com.opos.cmn.an.j.a f10893c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/j/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final com.opos.cmn.an.j.a f10894a;
        private static final int b;

        /* renamed from: c  reason: collision with root package name */
        private static final int f10895c;
        private static final int d;

        static {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            b = availableProcessors;
            f10895c = Math.max(2, Math.min(availableProcessors - 1, 4));
            d = (b * 2) + 1;
            f10894a = new a.C0452a().a(f10895c).b(d).c(30000).a("comp_thread").a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.cmn.an.j.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/j/b$b.class */
    public static final class C0453b {

        /* renamed from: a  reason: collision with root package name */
        static com.opos.cmn.an.j.a f10898a;
        static final com.opos.cmn.an.j.a b;

        static {
            com.opos.cmn.an.j.a a2 = new a.C0452a().a(2).b(20).c(3000).a(new SynchronousQueue()).a("io_thread").a();
            b = a2;
            a2.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: com.opos.cmn.an.j.b.b.1
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    synchronized (this) {
                        if (C0453b.f10898a == null) {
                            C0453b.f10898a = new a.C0452a().a(5).b(5).c(3000).a(new LinkedBlockingQueue()).a("io_backup_thread").a();
                            C0453b.f10898a.allowCoreThreadTimeOut(true);
                        }
                    }
                    C0453b.f10898a.execute(runnable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/j/b$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        static final com.opos.cmn.an.j.a f10899a = new a.C0452a().a(1).b(1).a("single_thread").a();
    }

    public static com.opos.cmn.an.j.a a() {
        if (f10892a == null) {
            f10892a = C0453b.b;
        }
        return f10892a;
    }

    public static void a(Runnable runnable) {
        c().execute(runnable);
    }

    public static com.opos.cmn.an.j.a b() {
        if (b == null) {
            b = a.f10894a;
        }
        return b;
    }

    public static void b(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeNetTask", e);
        }
    }

    public static com.opos.cmn.an.j.a c() {
        if (f10893c == null) {
            f10893c = c.f10899a;
        }
        return f10893c;
    }

    public static void c(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeIOTask", e);
        }
    }

    public static void d(Runnable runnable) {
        try {
            b().execute(runnable);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeBizTask", e);
        }
    }

    public static void e(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeDLTask", e);
        }
    }
}
