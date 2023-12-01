package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.DownloadPriority;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kb.class */
public class kb {
    private ExecutorService b;

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f37587c;
    private ib d;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, d> f37586a = new Hashtable();
    private final Set<jb> e = new CopyOnWriteArraySet();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kb$a.class */
    public class a implements Runnable {
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ib f37588c;
        public final /* synthetic */ int d;

        public a(String str, ib ibVar, int i) {
            this.b = str;
            this.f37588c = ibVar;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            kb.this.b(this.b, this.f37588c, this.d);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kb$b.class */
    public class b implements Runnable {
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ lb f37589c;
        public final /* synthetic */ byte[] d;

        public b(String str, lb lbVar, byte[] bArr) {
            this.b = str;
            this.f37589c = lbVar;
            this.d = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                for (jb jbVar : kb.this.e) {
                    if (kb.this.f37587c.isShutdown() || kb.this.f37587c.isTerminated()) {
                        return;
                    }
                    jbVar.a(this.b, this.f37589c);
                    int ordinal = this.f37589c.ordinal();
                    if (ordinal != 0) {
                        if (ordinal != 1) {
                            if (ordinal == 2) {
                                jbVar.c(this.b);
                                jbVar.a(this.b, this.d);
                            } else if (ordinal == 3) {
                                if (this.d == null) {
                                    jbVar.b(this.b);
                                }
                                jbVar.a(this.b, this.d);
                                jbVar.a(this.b);
                            } else if (ordinal != 4) {
                            }
                        }
                        if (this.d == null) {
                            jbVar.b(this.b);
                        }
                        jbVar.a(this.b, this.d);
                    } else {
                        jbVar.d(this.b);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kb$c.class */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37590a;

        static {
            lb.values();
            int[] iArr = new int[5];
            f37590a = iArr;
            try {
                lb lbVar = lb.START;
                iArr[0] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f37590a;
                lb lbVar2 = lb.CANCEL;
                iArr2[2] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f37590a;
                lb lbVar3 = lb.ERROR;
                iArr3[4] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                int[] iArr4 = f37590a;
                lb lbVar4 = lb.RUNNING;
                iArr4[1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                int[] iArr5 = f37590a;
                lb lbVar5 = lb.FINISH;
                iArr5[3] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kb$d.class */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public Runnable f37591a;
        public Future b;

        /* renamed from: c  reason: collision with root package name */
        public ib f37592c;
        public lb d;

        private d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }

        public void a() {
            synchronized (this) {
                lb lbVar = this.d;
                if (lbVar != null && lbVar != lb.RUNNING) {
                    d();
                }
            }
        }

        public void a(ExecutorService executorService) {
            synchronized (this) {
                if (this.d == null && this.f37591a != null && executorService != null && !h7.a(executorService)) {
                    this.d = lb.START;
                    this.b = executorService.submit(this.f37591a);
                }
            }
        }

        public void b() {
            synchronized (this) {
                lb lbVar = this.d;
                if (lbVar != lb.FINISH && lbVar != lb.CANCEL) {
                    this.d = lb.ERROR;
                }
            }
        }

        public void c() {
            synchronized (this) {
                lb lbVar = this.d;
                if (lbVar == lb.RUNNING || lbVar == lb.FINISH) {
                    this.d = lb.FINISH;
                }
            }
        }

        public void d() {
            synchronized (this) {
                if (this.d == null) {
                    return;
                }
                Future future = this.b;
                if (future != null) {
                    future.cancel(true);
                }
                ib ibVar = this.f37592c;
                if (ibVar != null) {
                    ibVar.a(true);
                }
                this.d = lb.CANCEL;
            }
        }

        public boolean e() {
            return this.d == lb.CANCEL;
        }

        public void f() {
            synchronized (this) {
                if (this.d == lb.START) {
                    this.d = lb.RUNNING;
                }
            }
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("RequestBody{");
            stringBuffer.append("runnable=");
            stringBuffer.append(this.f37591a);
            stringBuffer.append(", requestFuture=");
            stringBuffer.append(this.b);
            stringBuffer.append(", executor=");
            stringBuffer.append(this.f37592c);
            stringBuffer.append(", status=");
            stringBuffer.append(this.d);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    private void a(String str, byte[] bArr, lb lbVar) {
        if (this.e.isEmpty() || lbVar == null) {
            return;
        }
        ExecutorService executorService = this.f37587c;
        if (executorService == null || h7.a(executorService)) {
            this.f37587c = h7.e();
        }
        if (this.f37587c.isShutdown()) {
            return;
        }
        this.f37587c.execute(new b(str, lbVar, bArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, ib ibVar, int i) {
        d dVar;
        d dVar2;
        byte[] bArr;
        try {
            try {
                if (DownloadPriority.get(i) != DownloadPriority.NONE) {
                    Thread.currentThread().setPriority(DownloadPriority.getThreadPriority(i));
                }
                dVar2 = this.f37586a.get(str);
                try {
                } catch (Exception e) {
                    dVar = dVar2;
                    e = e;
                    e.printStackTrace();
                    if (dVar != null) {
                        dVar.b();
                    }
                    a(str, (byte[]) null, dVar != null ? dVar.d : lb.ERROR);
                }
            } finally {
                ibVar.a();
            }
        } catch (Exception e2) {
            e = e2;
            dVar = null;
        }
        if (dVar2 == null) {
            a(str, (byte[]) null, lb.ERROR);
        } else if (dVar2.e()) {
            a(str, (byte[]) null, lb.CANCEL);
        } else {
            InputStream f = ibVar.f(str);
            a(str, (byte[]) null, dVar2.d);
            dVar2.f();
            lb lbVar = dVar2.d;
            if (f != null) {
                bArr = new byte[102400];
                do {
                    if (bArr.length != 0) {
                        bArr = ha.a(f, 102400);
                        if (bArr == null) {
                            throw new IllegalStateException("下载过程读取失败");
                        }
                        a(str, bArr, lbVar);
                    } else {
                        ha.a((Closeable) f);
                    }
                } while (!dVar2.e());
                a(str, (byte[]) null, lb.CANCEL);
                return;
            }
            byte[] e3 = ibVar.e(str);
            bArr = e3;
            if (e3 != null) {
                bArr = e3;
                if (e3.length == 0) {
                    bArr = null;
                }
            }
            if (dVar2.e()) {
                a(str, (byte[]) null, lb.CANCEL);
                return;
            }
            dVar2.c();
            a(str, bArr, dVar2.d);
        }
    }

    public void a() {
        synchronized (this) {
            a((Runnable) null);
        }
    }

    public void a(jb jbVar) {
        if (jbVar != null) {
            this.e.remove(jbVar);
            this.e.add(jbVar);
        }
    }

    public void a(Runnable runnable) {
        synchronized (this) {
            this.d = null;
            ExecutorService executorService = this.b;
            if (executorService != null) {
                executorService.shutdownNow();
                this.b = null;
            }
            ExecutorService executorService2 = this.f37587c;
            if (executorService2 != null) {
                executorService2.shutdownNow();
                this.f37587c = null;
            }
            this.e.clear();
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void a(String str) {
        synchronized (this) {
            d remove = this.f37586a.remove(str);
            if (remove != null) {
                remove.a();
            }
        }
    }

    public void a(String str, ib ibVar) {
        synchronized (this) {
            a(str, ibVar, DownloadPriority.NONE.getValue());
        }
    }

    public void a(String str, ib ibVar, int i) {
        synchronized (this) {
            if (ibVar == null) {
                return;
            }
            ExecutorService executorService = this.b;
            if (executorService == null || h7.a(executorService)) {
                this.b = h7.b();
            }
            try {
                if (!h7.a(this.b)) {
                    d dVar = new d(null);
                    this.f37586a.put(str, dVar);
                    dVar.f37591a = new a(str, ibVar, i);
                    dVar.f37592c = ibVar;
                    dVar.a(this.b);
                }
            } catch (IllegalMonitorStateException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(ExecutorService executorService) {
        this.b = executorService;
    }

    public void b(jb jbVar) {
        this.e.remove(jbVar);
    }

    public void b(String str) {
        synchronized (this) {
            d remove = this.f37586a.remove(str);
            if (remove != null) {
                remove.d();
            }
        }
    }

    public Runnable c(String str) {
        d dVar = this.f37586a.get(str);
        if (dVar != null) {
            return dVar.f37591a;
        }
        return null;
    }
}
