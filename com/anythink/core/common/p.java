package com.anythink.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/p.class */
public final class p {
    public static final String b = "Y29tLnhpYW9taS5tYXJrZXQuRE1fUEFHRV9PUEVORUQ=";

    /* renamed from: c  reason: collision with root package name */
    public static final String f6869c = "Y29tLnhpYW9taS5tYXJrZXQuRE1fUEFHRV9DTE9TRUQ=";
    public static final String d = "Y29tLnhpYW9taS5tYXJrZXQuRElSRUNUX01BSUxfU1RBVFVT";
    public static final String e = "Y29udGVudDovL2NvbS54aWFvbWkubWFya2V0LnByb3ZpZGVyLkRpcmVjdE1haWxQcm92aWRlcg==";
    private static final String f = "code";
    private static final String g = "packageName";
    private static volatile String j;
    private static volatile p n;

    /* renamed from: a  reason: collision with root package name */
    BroadcastReceiver f6870a;
    private CopyOnWriteArrayList<com.anythink.core.common.e.i> h = new CopyOnWriteArrayList<>();
    private final AtomicBoolean i = new AtomicBoolean(false);
    private volatile Boolean k;
    private com.anythink.core.common.e.i l;
    private Context m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.common.p$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/p$2.class */
    public final class AnonymousClass2 extends BroadcastReceiver {
        AnonymousClass2() {
        }

        private com.anythink.core.common.e.i a(String str) {
            if (p.this.l == null || !TextUtils.equals(p.this.l.B(), str)) {
                if (p.this.h == null || p.this.h.size() <= 0) {
                    return null;
                }
                Iterator it = p.this.h.iterator();
                while (it.hasNext()) {
                    com.anythink.core.common.e.i iVar = (com.anythink.core.common.e.i) it.next();
                    if (iVar != null && TextUtils.equals(iVar.B(), str)) {
                        return iVar;
                    }
                }
                return null;
            }
            return p.this.l;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Bundle extras;
            com.anythink.core.common.e.i iVar;
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || action.equals(com.anythink.core.common.k.c.b(p.b)) || action.equals(com.anythink.core.common.k.c.b(p.f6869c)) || !action.equals(com.anythink.core.common.k.c.b(p.d)) || (extras = intent.getExtras()) == null) {
                return;
            }
            int i = extras.getInt("code", -1);
            String string = extras.getString("packageName", "");
            if (i == -1 || TextUtils.isEmpty(string)) {
                return;
            }
            if (p.this.l == null || !TextUtils.equals(p.this.l.B(), string)) {
                if (p.this.h != null && p.this.h.size() > 0) {
                    Iterator it = p.this.h.iterator();
                    while (it.hasNext()) {
                        iVar = (com.anythink.core.common.e.i) it.next();
                        if (iVar != null && TextUtils.equals(iVar.B(), string)) {
                            break;
                        }
                    }
                }
                iVar = null;
            } else {
                iVar = p.this.l;
            }
            if (iVar == null) {
                return;
            }
            if (i == 4) {
                p.this.b(iVar);
            }
            com.anythink.core.common.j.c.a(iVar.j(), iVar.p(), "", i, "", 0L, 0L);
        }
    }

    private p() {
    }

    public static p a() {
        if (n == null) {
            synchronized (p.class) {
                try {
                    if (n == null) {
                        n = new p();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return n;
    }

    public static String b() {
        try {
            return j == null ? "" : String.format("[%s]", j);
        } catch (Throwable th) {
            return "";
        }
    }

    private void b(Context context) {
        BroadcastReceiver broadcastReceiver = this.f6870a;
        if (broadcastReceiver == null || context == null) {
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
        }
        this.l = null;
        this.h.clear();
        this.h = null;
        this.f6870a = null;
        this.m = null;
    }

    static /* synthetic */ void b(p pVar) {
        if (pVar.k == null || !pVar.k.booleanValue() || pVar.m == null) {
            return;
        }
        try {
            pVar.f6870a = new AnonymousClass2();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.anythink.core.common.k.c.b(b));
            intentFilter.addAction(com.anythink.core.common.k.c.b(f6869c));
            intentFilter.addAction(com.anythink.core.common.k.c.b(d));
            pVar.m.registerReceiver(pVar.f6870a, intentFilter);
        } catch (Throwable th) {
        }
    }

    static /* synthetic */ Boolean d() {
        return g();
    }

    private com.anythink.core.common.e.i e() {
        return this.l;
    }

    private void f() {
        if (this.k == null || !this.k.booleanValue() || this.m == null) {
            return;
        }
        try {
            this.f6870a = new AnonymousClass2();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.anythink.core.common.k.c.b(b));
            intentFilter.addAction(com.anythink.core.common.k.c.b(f6869c));
            intentFilter.addAction(com.anythink.core.common.k.c.b(d));
            this.m.registerReceiver(this.f6870a, intentFilter);
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
        if (r0.equalsIgnoreCase("true") != false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Boolean g() {
        /*
            com.anythink.core.common.b.n r0 = com.anythink.core.common.b.n.a()
            android.content.Context r0 = r0.g()
            r8 = r0
            r0 = 0
            r10 = r0
            r0 = 0
            r9 = r0
            r0 = r10
            r7 = r0
            r0 = r8
            if (r0 == 0) goto La4
            r0 = r10
            r7 = r0
            r0 = r8
            android.content.ContentResolver r0 = r0.getContentResolver()
            if (r0 == 0) goto La4
            r0 = r8
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> La6
            java.lang.String r1 = "Y29udGVudDovL2NvbS54aWFvbWkubWFya2V0LnByb3ZpZGVyLkRpcmVjdE1haWxQcm92aWRlcg=="
            java.lang.String r1 = com.anythink.core.common.k.c.b(r1)     // Catch: java.lang.Throwable -> La6
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> La6
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> La6
            r8 = r0
            goto L33
        L31:
            r0 = 0
            r8 = r0
        L33:
            r0 = r10
            r7 = r0
            r0 = r8
            if (r0 == 0) goto La4
            r0 = r9
            r7 = r0
        L3b:
            r0 = r8
            boolean r0 = r0.moveToNext()
            if (r0 == 0) goto L9e
            r0 = r8
            r1 = r8
            java.lang.String r2 = "support"
            int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Laa
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> Laa
            r10 = r0
            r0 = r7
            r9 = r0
            r0 = r10
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Laa
            if (r0 != 0) goto L83
            r0 = r7
            r9 = r0
            r0 = r10
            java.lang.String r1 = "null"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> Laa
            if (r0 != 0) goto L83
            r0 = r10
            java.lang.String r1 = "false"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> Laa
            if (r0 != 0) goto L7b
            r0 = r7
            r9 = r0
            r0 = r10
            java.lang.String r1 = "true"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> Laa
            if (r0 == 0) goto L83
        L7b:
            r0 = r10
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch: java.lang.Throwable -> Laa
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> Laa
            r9 = r0
        L83:
            r0 = r8
            r1 = r8
            java.lang.String r2 = "detailStyle"
            int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Exception -> Lb0
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Exception -> Lb0
            com.anythink.core.common.p.j = r0     // Catch: java.lang.Exception -> Lb0
            r0 = r9
            r7 = r0
            goto L3b
        L99:
            r0 = r9
            r7 = r0
            goto L3b
        L9e:
            r0 = r8
            r0.close()     // Catch: java.lang.Throwable -> Lb4
        La4:
            r0 = r7
            return r0
        La6:
            r7 = move-exception
            goto L31
        Laa:
            r9 = move-exception
            r0 = r7
            r9 = r0
            goto L83
        Lb0:
            r7 = move-exception
            goto L99
        Lb4:
            r8 = move-exception
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.p.g():java.lang.Boolean");
    }

    public final void a(Context context) {
        this.m = context;
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.p.1
            @Override // java.lang.Runnable
            public final void run() {
                if (p.this.i.compareAndSet(false, true)) {
                    try {
                        p.this.k = p.d();
                        p.b(p.this);
                    } catch (Throwable th) {
                    }
                }
            }
        });
    }

    public final void a(com.anythink.core.common.e.i iVar) {
        if (this.k == null || iVar == null || !this.k.booleanValue()) {
            return;
        }
        this.l = iVar;
        this.h.add(iVar);
    }

    public final void b(com.anythink.core.common.e.i iVar) {
        if (this.k == null || iVar == null || !this.k.booleanValue()) {
            return;
        }
        this.l = null;
        try {
            this.h.remove(iVar);
        } catch (Exception e2) {
        }
    }

    public final int c() {
        if (this.k != null) {
            return this.k.booleanValue() ? 1 : 0;
        }
        return -1;
    }
}
