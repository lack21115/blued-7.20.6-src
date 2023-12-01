package com.anythink.expressad.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.h.x;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f4109a = "mtg_retry_report=1";
    public static int b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public static final int f4110c = 1;
    public static final int d = 2;
    public static int e = 3;
    public static int f = 50;
    public static int g = 600000;
    public static int h = 0;
    public static int i = 1;
    public static int j = 2;
    public static int k = 3;
    public static int l = 4;
    public static int m = 5;
    private static String n = "RetryReportControl";
    private static int q;
    private static int r;
    private ConcurrentHashMap<String, com.anythink.expressad.a.a.b> o;
    private c p;
    private BroadcastReceiver s;
    private final Handler t;

    /* renamed from: com.anythink.expressad.a.a.a$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/a/a$1.class */
    final class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                a.this.t.sendEmptyMessage(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/a/a$a.class */
    public static final class C0040a {

        /* renamed from: a  reason: collision with root package name */
        private static a f4112a = new a((byte) 0);

        private C0040a() {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/a/a$b.class */
    static final class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                a.a(a.a());
                return;
            }
            Object obj = message.obj;
            if (obj instanceof String) {
                a.a().a((String) obj, com.anythink.expressad.a.a.b.f4113a);
            }
        }
    }

    private a() {
        this.o = new ConcurrentHashMap<>();
        this.p = new c(f);
        this.t = new b(Looper.getMainLooper());
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.a b2 = com.anythink.expressad.d.b.b();
        e = b2.U();
        b = b2.W() * 1000;
        g = b2.V() * 1000;
        q = b2.T();
        r = b2.S();
        try {
            if (this.s == null) {
                this.s = new AnonymousClass1();
                Context g2 = n.a().g();
                if (g2 != null) {
                    g2.registerReceiver(this.s, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0040a.f4112a;
    }

    static /* synthetic */ void a(a aVar) {
        c cVar = aVar.p;
        if (cVar != null) {
            for (String str : cVar.a()) {
                aVar.a(str, com.anythink.expressad.a.a.b.b);
            }
        }
    }

    private void a(String str) {
        Message obtainMessage = this.t.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = str;
        this.t.sendMessageDelayed(obtainMessage, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2) {
        String str2;
        c cVar = this.p;
        if (cVar != null) {
            com.anythink.expressad.a.a.b b2 = cVar.b(str);
            this.p.a(str);
            if (b2 == null) {
                com.anythink.expressad.a.a.b bVar = this.o.get(str);
                if (bVar == null || System.currentTimeMillis() > bVar.h() + g || bVar.g() >= e || i2 == com.anythink.expressad.a.a.b.b) {
                    return;
                }
                a(str);
            } else if (System.currentTimeMillis() > b2.h() + g) {
                if (i2 != com.anythink.expressad.a.a.b.b) {
                }
            } else {
                b2.a(i2);
                this.o.put(str, b2);
                if (x.b(str) == 0) {
                    str2 = str + "?" + f4109a;
                } else {
                    str2 = str + ContainerUtils.FIELD_DELIMITER + f4109a;
                }
                com.anythink.expressad.a.a.a(n.a().g(), b2.f(), b2.e(), str2, b2.a(), b2.b(), b2.d());
            }
        }
    }

    private void a(String str, com.anythink.expressad.a.a.b bVar) {
        if (this.p == null) {
            this.p = new c(f);
        }
        this.p.a(str, bVar);
    }

    private static boolean a(int i2) {
        return i2 == l || i2 == k;
    }

    private void b() {
        c cVar = this.p;
        if (cVar != null) {
            for (String str : cVar.a()) {
                a(str, com.anythink.expressad.a.a.b.b);
            }
        }
    }

    private static boolean b(int i2) {
        return i2 == i || i2 == j;
    }

    private void c() {
        try {
            if (this.s == null) {
                this.s = new AnonymousClass1();
                Context g2 = n.a().g();
                if (g2 != null) {
                    g2.registerReceiver(this.s, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static boolean c(int i2) {
        return a(i2) || b(i2) || i2 == m;
    }

    private void d() {
        Context g2;
        if (this.s == null || (g2 = n.a().g()) == null) {
            return;
        }
        g2.unregisterReceiver(this.s);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0108, code lost:
        if (r14 == com.anythink.expressad.a.a.a.m) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r8, java.lang.String r9, com.anythink.expressad.foundation.d.c r10, java.lang.String r11, boolean r12, boolean r13, int r14) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.a.a.a.a(java.lang.String, java.lang.String, com.anythink.expressad.foundation.d.c, java.lang.String, boolean, boolean, int):void");
    }
}
