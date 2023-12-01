package com.tencent.qmsp.sdk.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qmsp.sdk.c.a;
import com.tencent.qmsp.sdk.c.k;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/f.class */
public final class f {
    private static boolean j = false;
    private Handler d;
    private l e;
    private k f;
    private g h;
    private static final byte[][] i = {new byte[]{52, 125, -93}, new byte[]{41, 121, -79, 113, 35, 43, 57, -18, 42}};
    private static ConcurrentHashMap<Long, InterfaceC0817f> k = new ConcurrentHashMap<>();
    private static Handler l = null;
    private static volatile f m = null;

    /* renamed from: a  reason: collision with root package name */
    private int f24858a = -1;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24859c = false;
    private com.tencent.qmsp.sdk.d.c g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/f$a.class */
    public class a implements a.InterfaceC0816a {
        a(f fVar) {
        }

        @Override // com.tencent.qmsp.sdk.c.a.InterfaceC0816a
        public void a() {
            com.tencent.qmsp.sdk.f.g.a("Qp.QFW", 1, "Something wrong when load native so.");
        }

        @Override // com.tencent.qmsp.sdk.c.a.InterfaceC0816a
        public void run() {
            if (f.j) {
                return;
            }
            try {
                if (!f.h()) {
                    System.loadLibrary(f.c(0));
                }
                boolean unused = f.j = true;
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/f$b.class */
    class b implements a.InterfaceC0816a {
        b() {
        }

        @Override // com.tencent.qmsp.sdk.c.a.InterfaceC0816a
        public void a() {
            com.tencent.qmsp.sdk.f.g.a("Qp.QFW", 1, "Something wrong when init native.");
        }

        @Override // com.tencent.qmsp.sdk.c.a.InterfaceC0816a
        public void run() {
            Context context;
            if (!f.j || f.this.b) {
                return;
            }
            try {
                Object[] objArr = new Object[1];
                l lVar = f.this.e;
                context = com.tencent.qmsp.sdk.app.a.getContext();
                if (f.a(1L, 512L, com.tencent.qmsp.sdk.a.c.g(), 0L, lVar, context, null, objArr) == 0 && objArr[0] != null && (objArr[0] instanceof Integer)) {
                    f.this.f24858a = ((Integer) objArr[0]).intValue();
                    int unused = f.this.f24858a;
                    f.this.b = true;
                }
                com.tencent.qmsp.sdk.f.g.a("Qp.QFW", 1, String.format("Native ver: %d(%s)", Integer.valueOf(f.this.f24858a), com.tencent.qmsp.sdk.a.c.a(f.this.f24858a)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/f$c.class */
    class c extends Handler {
        c(f fVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                long parseLong = Long.parseLong((String) message.obj);
                if (message.what != 1 || parseLong == 0) {
                    return;
                }
                com.tencent.qmsp.sdk.f.g.a("Qp.QFW", 1, String.format("handle native msg for cookie: %08X", Long.valueOf(parseLong)));
                f.a(6L, parseLong, 0L, 0L, null, null, null, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/f$d.class */
    class d implements InterfaceC0817f {
        d() {
        }

        @Override // com.tencent.qmsp.sdk.c.f.InterfaceC0817f
        public int a(long j, long j2, long j3, Object obj, Object obj2, Object[] objArr, Object[] objArr2) {
            if (j != 0) {
                com.tencent.qmsp.sdk.f.g.a("Qp.QFW", 1, String.format("Native msg, cookie: %08X, delay: %d", Long.valueOf(j), Long.valueOf(j2)));
                String valueOf = String.valueOf(j);
                if (j2 != 0) {
                    f.this.d.sendMessageDelayed(f.this.d.obtainMessage(1, valueOf), j2 * 1000);
                    return 0;
                }
                f.this.d.sendMessage(f.this.d.obtainMessage(1, valueOf));
                return 0;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/f$e.class */
    public class e implements k.e {
        e() {
        }

        @Override // com.tencent.qmsp.sdk.c.k.e
        public void a(int i, int i2) {
            f.this.f.b(this);
        }
    }

    /* renamed from: com.tencent.qmsp.sdk.c.f$f  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/f$f.class */
    public interface InterfaceC0817f {
        int a(long j, long j2, long j3, Object obj, Object obj2, Object[] objArr, Object[] objArr2);
    }

    private f() {
        Context context;
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = null;
        context = com.tencent.qmsp.sdk.app.a.getContext();
        if (context == null) {
            return;
        }
        j();
        l lVar = new l();
        this.e = lVar;
        lVar.a(n.b());
        new com.tencent.qmsp.sdk.c.a(c(0), 86400000L).a(new b());
        this.h = g.d();
        k e2 = k.e();
        this.f = e2;
        e2.a(this.h);
        this.d = new c(this, com.tencent.qmsp.sdk.app.b.e().c());
        a(2L, new d());
    }

    public static int a(long j2, long j3, long j4, long j5, Object obj, Object obj2, Object[] objArr, Object[] objArr2) {
        if (j) {
            try {
                return goingDownInternal(j2, j3, j4, j5, obj, obj2, objArr, objArr2);
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return 29;
            }
        }
        return 27;
    }

    public static String a(int i2, int i3, int i4, int i5, Object obj, Object obj2) {
        if ((obj instanceof String) && obj != null && j) {
            try {
                return goingDownInternal(i2, i3, i4, i5, obj, obj2);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static void a(long j2, InterfaceC0817f interfaceC0817f) {
        if (interfaceC0817f != null) {
            k.put(Long.valueOf(j2), interfaceC0817f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(int i2) {
        return com.tencent.qmsp.sdk.f.h.a(i[i2]);
    }

    private static native int goingDownInternal(long j2, long j3, long j4, long j5, Object obj, Object obj2, Object[] objArr, Object[] objArr2);

    private static native String goingDownInternal(long j2, long j3, long j4, long j5, Object obj, Object obj2);

    private static int goingUp(long j2, long j3, long j4, long j5, Object obj, Object obj2, Object[] objArr, Object[] objArr2) {
        InterfaceC0817f interfaceC0817f = k.get(Long.valueOf(j2));
        if (interfaceC0817f != null) {
            return interfaceC0817f.a(j3, j4, j5, obj, obj2, objArr, objArr2);
        }
        return 30;
    }

    static /* synthetic */ boolean h() {
        return k();
    }

    public static f i() {
        if (m == null) {
            synchronized (f.class) {
                try {
                    if (m == null) {
                        m = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return m;
    }

    private void j() {
        new com.tencent.qmsp.sdk.c.a(c(0), 86400000L).a(new a(this));
        l = new Handler(com.tencent.qmsp.sdk.app.b.e().c());
    }

    private static boolean k() {
        if (j) {
            return true;
        }
        String str = com.tencent.qmsp.sdk.a.b.b() + File.separator + c(1);
        File file = new File(str);
        if (file.exists() && com.tencent.qmsp.sdk.d.e.b(file, null)) {
            try {
                System.load(str);
                return true;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public int a(int i2, int i3, int i4, Object[] objArr, Object[] objArr2) {
        return this.f.a(i2, i3, i4, objArr, objArr2);
    }

    public Boolean a(int i2) {
        g gVar = this.h;
        boolean z = true;
        if (1 != (gVar != null ? gVar.a(i2) : -1)) {
            z = !com.tencent.qmsp.sdk.c.b.b;
        }
        return Boolean.valueOf(z);
    }

    public void a() {
        g gVar = this.h;
        if (gVar != null) {
            gVar.a();
        }
        k kVar = this.f;
        if (kVar != null) {
            kVar.a();
        }
        if (m != null) {
            m = null;
        }
    }

    public void a(com.tencent.qmsp.sdk.d.c cVar) {
        this.g = cVar;
    }

    public g b() {
        return this.h;
    }

    public Handler c() {
        return l;
    }

    public com.tencent.qmsp.sdk.d.c d() {
        return this.g;
    }

    public void e() {
        this.f.b();
    }

    public void f() {
        if (!this.f24859c) {
            this.f24859c = true;
        }
        if (com.tencent.qmsp.sdk.c.b.b) {
            com.tencent.qmsp.sdk.e.a.a();
            com.tencent.qmsp.sdk.e.c.a();
        }
        com.tencent.qmsp.sdk.e.b.a();
        if (com.tencent.qmsp.sdk.c.b.b) {
            this.f.a(new e());
            this.f.c();
        }
    }
}
