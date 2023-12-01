package com.zk_oaction.adengine.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/c.class */
public class c {
    private HandlerThread h;
    private d i;
    private HandlerC0931c j;
    private HandlerC0931c k;
    private b l;

    /* renamed from: a  reason: collision with root package name */
    HashMap<String, com.zk_oaction.adengine.bitmap.b> f28177a = new HashMap<>();
    com.zk_oaction.adengine.bitmap.a b = new com.zk_oaction.adengine.bitmap.a();

    /* renamed from: c  reason: collision with root package name */
    com.zk_oaction.adengine.bitmap.d f28178c = new com.zk_oaction.adengine.bitmap.d();
    Handler d = new Handler(Looper.getMainLooper());
    private int e = 1;
    private float f = 1.0f;
    private float g = 1.0f;
    private ArrayList<com.zk_oaction.adengine.bitmap.b> m = new ArrayList<>();
    private HashMap<com.zk_oaction.adengine.bitmap.b, Long> n = new HashMap<>();
    private long o = 0;
    private int p = -1;
    private int q = -1;
    private int r = 4;
    private int s = 0;
    private boolean t = false;
    private int u = -1;
    private boolean v = false;
    private boolean w = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/c$a.class */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f28179a;
        final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f28180c;

        a(String str, float f, boolean z) {
            this.f28179a = str;
            this.b = f;
            this.f28180c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.c(this.f28179a, this.b, this.f28180c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/c$b.class */
    public class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f28181a;
        public volatile boolean b;
        private volatile long d;

        public b(Looper looper) {
            super(looper);
            this.f28181a = false;
            this.b = false;
            this.d = 0L;
        }

        public void a() {
            synchronized (this) {
                this.b = false;
                notify();
            }
        }

        public void a(long j) {
            synchronized (this) {
                this.b = true;
                this.d = j;
            }
        }

        public void a(boolean z) {
            synchronized (this) {
                this.f28181a = z;
                a();
                removeMessages(0);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f28181a) {
                return;
            }
            synchronized (this) {
                if (this.b) {
                    try {
                        wait(this.d);
                    } catch (InterruptedException e) {
                    }
                    this.b = false;
                }
            }
            if (this.f28181a) {
                return;
            }
            com.zk_oaction.adengine.bitmap.b bVar = (com.zk_oaction.adengine.bitmap.b) message.obj;
            if (bVar.e() == null) {
                if (message.what == 0) {
                    c.this.b.a(bVar.f28175a);
                    return;
                }
                Bitmap c2 = c.this.c(bVar.f28175a, bVar.b);
                if (c2 != null) {
                    if (this.f28181a) {
                        c2.recycle();
                        return;
                    }
                    bVar.a(c2);
                    c.this.b(bVar.f28175a, bVar.b, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zk_oaction.adengine.bitmap.c$c  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/c$c.class */
    public class HandlerC0931c extends Handler {
        public void a(boolean z) {
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/c$d.class */
    public class d extends Handler {
    }

    public c() {
        f();
    }

    private BitmapFactory.Options a(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    private com.zk_oaction.adengine.bitmap.b a(String str, float f, boolean z) {
        com.zk_oaction.adengine.bitmap.b bVar;
        synchronized (this) {
            String b2 = b(str, f);
            com.zk_oaction.adengine.bitmap.b bVar2 = this.f28177a.get(b2);
            bVar = bVar2;
            if (z) {
                bVar = bVar2;
                if (bVar2 == null) {
                    bVar = new com.zk_oaction.adengine.bitmap.b(str, f);
                    this.f28177a.put(b2, bVar);
                }
            }
        }
        return bVar;
    }

    private void a(com.zk_oaction.adengine.bitmap.b bVar, boolean z) {
        synchronized (this) {
            if (this.l == null) {
                this.l = new b(this.h.getLooper());
            }
            if (this.w) {
                int i = !z ? 1 : 0;
                if (!this.l.hasMessages(i, bVar)) {
                    this.l.sendMessage(this.l.obtainMessage(i, bVar));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, float f, boolean z) {
        if (this.v) {
            return;
        }
        this.d.post(new a(str, f, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap c(String str, float f) {
        int i;
        int i2;
        if (f == -1.0f) {
            synchronized (this) {
                i = this.p;
                i2 = this.q;
            }
        } else {
            i = 0;
            i2 = 0;
        }
        Bitmap bitmap = null;
        try {
            com.zk_oaction.adengine.bitmap.d dVar = this.f28178c;
            if (dVar != null) {
                bitmap = dVar.a(str, f, i, i2, this.b.a(str));
            }
            return bitmap;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, float f, boolean z) {
        com.zk_oaction.adengine.bitmap.b a2;
        if (this.v || (a2 = a(str, f, false)) == null || a2.a() == 0) {
            return;
        }
        a2.a(z);
    }

    private void f() {
        HandlerThread handlerThread = new HandlerThread("BitmapManager", -1);
        this.h = handlerThread;
        handlerThread.start();
    }

    private void g() {
        synchronized (this) {
            HandlerC0931c handlerC0931c = this.k;
            if (handlerC0931c != null) {
                handlerC0931c.a(true);
            }
        }
    }

    private void h() {
        synchronized (this) {
            HandlerC0931c handlerC0931c = this.j;
            if (handlerC0931c != null) {
                handlerC0931c.a(true);
            }
        }
    }

    private void i() {
        synchronized (this) {
            d dVar = this.i;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (r10 >= r0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap a(java.lang.String r8, float r9, int r10) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.bitmap.c.a(java.lang.String, float, int):android.graphics.Bitmap");
    }

    public com.zk_oaction.adengine.bitmap.b a(String str, float f) {
        com.zk_oaction.adengine.bitmap.b bVar;
        synchronized (this) {
            bVar = this.f28177a.get(b(str, f));
        }
        return bVar;
    }

    public void a() {
        synchronized (this) {
            h();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.m.size()) {
                    com.zk_oaction.adengine.bitmap.b bVar = this.m.get(i2);
                    bVar.b();
                    b(bVar.f28175a, bVar.b, false);
                    i = i2 + 1;
                }
            }
        }
    }

    public void a(int i) {
        synchronized (this) {
            this.e = i;
        }
    }

    public void a(int i, int i2) {
        synchronized (this) {
            int i3 = i2;
            if (i == 480) {
                i3 = i2;
                if (i2 == 853) {
                    i3 = 854;
                }
            }
            this.p = i;
            this.q = i3;
            this.o = i * i3 * 4;
        }
    }

    public void a(long j) {
        synchronized (this) {
            if (this.l == null) {
                this.l = new b(this.h.getLooper());
            }
            this.l.a(j);
        }
    }

    public void a(String str, float f, h hVar) {
        a(str, f, true).a(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b(String str, float f) {
        return str + "_" + f;
    }

    public void b() {
        synchronized (this) {
            g();
            this.b.a();
        }
    }

    public void c() {
        synchronized (this) {
            b bVar = this.l;
            if (bVar != null) {
                bVar.a(true);
                this.l = null;
            }
        }
    }

    public void d() {
        synchronized (this) {
            this.v = true;
            c();
            a();
            b();
            this.h.quit();
            i();
            this.f28177a.clear();
            this.b.a();
            this.f28178c = null;
            this.m.clear();
            this.n.clear();
        }
    }

    public void e() {
        synchronized (this) {
            b bVar = this.l;
            if (bVar != null) {
                bVar.a();
            }
        }
    }
}
