package com.anythink.china.common.a.a;

import com.anythink.core.common.k.b.b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/a/a/a.class */
public final class a {
    public static final int a = 1;
    public static final int b = 2;
    private static a c;
    private ExecutorService d;

    /* renamed from: com.anythink.china.common.a.a.a$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/a/a/a$1.class */
    final class AnonymousClass1 extends b {
        final /* synthetic */ long a = 0;
        final /* synthetic */ Runnable b;

        AnonymousClass1(Runnable runnable) {
            this.b = runnable;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x0022 -> B:3:0x0007). Please submit an issue!!! */
        @Override // com.anythink.core.common.k.b.b
        public final void a() {
            try {
                Thread.sleep(this.a);
            } catch (InterruptedException e) {
            }
            new StringBuilder("thread-").append(b());
            this.b.run();
        }
    }

    protected a() {
        this.d = null;
        this.d = Executors.newSingleThreadExecutor();
    }

    public static a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    private static void a(a aVar) {
        c = aVar;
    }

    private void a(Runnable runnable) {
        if (runnable != null) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(runnable);
            anonymousClass1.a(Long.valueOf(System.currentTimeMillis() / 1000).intValue());
            a((b) anonymousClass1);
        }
    }

    private void b() {
        this.d.shutdown();
    }

    private void b(b bVar) {
        a(bVar);
    }

    private void b(Runnable runnable) {
        if (runnable != null) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(runnable);
            anonymousClass1.a(Long.valueOf(System.currentTimeMillis() / 1000).intValue());
            a((b) anonymousClass1);
        }
    }

    public final void a(b bVar) {
        this.d.execute(bVar);
    }
}
