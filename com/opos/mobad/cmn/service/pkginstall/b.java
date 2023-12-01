package com.opos.mobad.cmn.service.pkginstall;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.widget.Toast;
import com.alipay.sdk.widget.j;
import com.opos.cmn.e.a.c.c.e;
import com.opos.mobad.cmn.a.b.d;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.model.data.AdItemData;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/service/pkginstall/b.class */
public final class b implements com.opos.cmn.e.a.c.a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f25925a = new byte[0];
    private static volatile b b;
    private Context d;
    private LruCache<String, Set<InterfaceC0687b>> e;
    private e f;
    private LruCache<String, List<AdItemData>> g;

    /* renamed from: c  reason: collision with root package name */
    private int f25926c = -1;
    private final Handler h = new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.cmn.service.pkginstall.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                try {
                    String str = (String) message.obj;
                    int i = message.what;
                    if (i == 0) {
                        b.this.a(str);
                    } else if (i != 1) {
                        if (i != 2) {
                            return;
                        }
                        b.this.a(str, (int[]) null);
                    } else if (!b.this.f() || !f.l()) {
                        com.opos.cmn.an.f.a.b("PkgInstallMgr", "show Toast but lack of conditions to show");
                    } else {
                        Bundle data = message.getData();
                        if (data != null) {
                            boolean z = data.getBoolean("gbClick");
                            if (b.this.f == null) {
                                b.this.f = new com.opos.cmn.e.a.c.c.f(b.this.d.getApplicationContext(), b.this);
                            }
                            b.this.f.a(str, z, new Object[0]);
                        }
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
                }
            }
        }
    };
    private final com.opos.mobad.cmn.service.pkginstall.a i = new com.opos.mobad.cmn.service.pkginstall.a() { // from class: com.opos.mobad.cmn.service.pkginstall.b.2
        @Override // com.opos.mobad.cmn.service.pkginstall.a
        public void a(Object... objArr) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("PKG_ADDED_BR_LISTENER onReceive objects=");
                sb.append(objArr != null ? objArr : com.igexin.push.core.b.l);
                com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
                if (objArr == null || objArr.length <= 0 || objArr[0] == null) {
                    return;
                }
                String str = (String) objArr[0];
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "installPkgName=" + str);
                if (b.this.d(str)) {
                    b.this.g(str);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/service/pkginstall/b$a.class */
    public interface a {
        void a();
    }

    /* renamed from: com.opos.mobad.cmn.service.pkginstall.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/service/pkginstall/b$b.class */
    public interface InterfaceC0687b {
        void a(AdItemData adItemData, String str);

        void b(AdItemData adItemData, String str);

        void c(AdItemData adItemData, String str);
    }

    private b(Context context) {
        this.d = context.getApplicationContext();
        b();
    }

    public static b a(Context context) {
        b bVar;
        b bVar2 = b;
        if (bVar2 == null) {
            synchronized (f25925a) {
                b bVar3 = b;
                bVar = bVar3;
                if (bVar3 == null) {
                    bVar = new b(context);
                    b = bVar;
                }
            }
            return bVar;
        }
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        b(str);
        c(str);
    }

    private void a(final String str, final a aVar) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("notifyLaunchEvent pkgName=");
            sb.append(str != null ? str : com.igexin.push.core.b.l);
            com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
            this.h.post(new Runnable() { // from class: com.opos.mobad.cmn.service.pkginstall.b.6
                @Override // java.lang.Runnable
                public void run() {
                    Set<InterfaceC0687b> f;
                    if (!com.opos.cmn.an.c.a.a(str) && (f = b.this.f(str)) != null && f.size() > 0) {
                        for (InterfaceC0687b interfaceC0687b : f) {
                            if (interfaceC0687b != null) {
                                List e = b.this.e(str);
                                if (e == null || e.size() <= 0 || e.get(0) == null) {
                                    com.opos.cmn.an.f.a.b("PkgInstallMgr", "notify but data empty");
                                } else {
                                    interfaceC0687b.b((AdItemData) e.get(0), str);
                                }
                            }
                        }
                    }
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            });
        } catch (Exception e) {
            if (aVar != null) {
                aVar.a();
            }
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d A[Catch: Exception -> 0x0062, TRY_ENTER, TryCatch #0 {Exception -> 0x0062, blocks: (B:2:0x0000, B:4:0x0007, B:7:0x001c, B:9:0x0028, B:15:0x004d, B:17:0x005c, B:10:0x0033, B:12:0x003e), top: B:23:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005c A[Catch: Exception -> 0x0062, TRY_ENTER, TryCatch #0 {Exception -> 0x0062, blocks: (B:2:0x0000, B:4:0x0007, B:7:0x001c, B:9:0x0028, B:15:0x004d, B:17:0x005c, B:10:0x0033, B:12:0x003e), top: B:23:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(final java.lang.String r8, int[] r9) {
        /*
            r7 = this;
            r0 = r8
            boolean r0 = com.opos.cmn.an.c.a.a(r0)     // Catch: java.lang.Exception -> L62
            if (r0 != 0) goto L6b
            r0 = r7
            r1 = r8
            java.lang.String r0 = r0.l(r1)     // Catch: java.lang.Exception -> L62
            r12 = r0
            r0 = r12
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L62
            r11 = r0
            r0 = 0
            r10 = r0
            r0 = r11
            if (r0 != 0) goto L33
            r0 = r7
            android.content.Context r0 = r0.d     // Catch: java.lang.Exception -> L62
            r1 = r12
            boolean r0 = com.opos.mobad.cmn.a.b.f.b(r0, r1)     // Catch: java.lang.Exception -> L62
            if (r0 == 0) goto L33
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = 1
            r4 = 1
            r0.a(r1, r2, r3, r4)     // Catch: java.lang.Exception -> L62
            goto L6c
        L33:
            r0 = r7
            android.content.Context r0 = r0.d     // Catch: java.lang.Exception -> L62
            r1 = r8
            boolean r0 = com.opos.mobad.cmn.a.b.f.a(r0, r1)     // Catch: java.lang.Exception -> L62
            if (r0 == 0) goto L49
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = 0
            r4 = 1
            r0.a(r1, r2, r3, r4)     // Catch: java.lang.Exception -> L62
            goto L6c
        L49:
            r0 = r10
            if (r0 == 0) goto L5c
            r0 = r7
            r1 = r8
            com.opos.mobad.cmn.service.pkginstall.b$4 r2 = new com.opos.mobad.cmn.service.pkginstall.b$4     // Catch: java.lang.Exception -> L62
            r3 = r2
            r4 = r7
            r5 = r8
            r3.<init>()     // Catch: java.lang.Exception -> L62
            r0.a(r1, r2)     // Catch: java.lang.Exception -> L62
            return
        L5c:
            r0 = r7
            r1 = r8
            r0.a(r1)     // Catch: java.lang.Exception -> L62
            return
        L62:
            r8 = move-exception
            java.lang.String r0 = "PkgInstallMgr"
            java.lang.String r1 = ""
            r2 = r8
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L6b:
            return
        L6c:
            r0 = 1
            r10 = r0
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.service.pkginstall.b.a(java.lang.String, int[]):void");
    }

    private void a(String str, int[] iArr, boolean z, boolean z2) {
        AdItemData adItemData;
        List<AdItemData> e = e(str);
        if (e == null || e.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= e.size()) {
                return;
            }
            if (e.get(i2) != null && (adItemData = e.get(i2)) != null) {
                if (z) {
                    d.c(this.d, adItemData.g(), adItemData, adItemData.i().get(0), z2, iArr, null);
                } else {
                    d.a(this.d, adItemData, adItemData.i().get(0), z2, iArr);
                }
            }
            i = i2 + 1;
        }
    }

    private boolean a(List<AdItemData> list, AdItemData adItemData) {
        boolean z;
        if (list.size() <= 0) {
            return false;
        }
        Iterator<AdItemData> it = list.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            AdItemData next = it.next();
            if (next != null && !TextUtils.isEmpty(next.i().get(0).aa()) && !TextUtils.isEmpty(adItemData.i().get(0).aa()) && next.i().get(0).aa().equals(adItemData.i().get(0).aa())) {
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "addAdItemData but has contain ,traceId = " + next.i().get(0).aa());
                z = true;
                break;
            }
        }
        return z;
    }

    private void b() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "init");
        try {
            if (this.g == null) {
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "init sAdItemDataCache");
                this.g = new LruCache<>(50);
            }
            if (this.e == null) {
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "init sListenerMap");
                this.e = new LruCache<>(20);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
        }
    }

    private void b(String str) {
        try {
            if (!com.opos.cmn.an.c.a.a(str) && this.g.get(str) != null) {
                this.g.remove(str);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "", e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("removeAdItemDataList pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",sAdItemDataCache.size=");
        sb.append(this.g.size());
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    private void b(String str, InterfaceC0687b interfaceC0687b) {
        Set<InterfaceC0687b> f;
        try {
            if (!com.opos.cmn.an.c.a.a(str) && interfaceC0687b != null && (f = f(str)) != null) {
                if (f.size() > 0) {
                    for (InterfaceC0687b interfaceC0687b2 : f) {
                        if (interfaceC0687b2 != null && interfaceC0687b2.equals(interfaceC0687b)) {
                            com.opos.cmn.an.f.a.b("PkgInstallMgr", "addListener but has contain");
                            return;
                        }
                    }
                }
                f.add(interfaceC0687b);
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "addListener pkgName=" + str + ",listenerList.size=" + f.size());
                this.e.put(str, f);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("addListener pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",listener=");
        if (interfaceC0687b == null) {
            interfaceC0687b = com.igexin.push.core.b.l;
        }
        sb.append(interfaceC0687b);
        sb.append(",sListenerMap.size=");
        sb.append(this.e.size());
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    private void b(String str, AdItemData adItemData) {
        List<AdItemData> e;
        try {
            if (!com.opos.cmn.an.c.a.a(str) && adItemData != null && (e = e(str)) != null && !a(e, adItemData)) {
                e.add(adItemData);
                this.g.put(str, e);
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "addAdItemData pkgName=" + str + ",adItemDataList.size=" + e.size());
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("addAdItemData pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",sAdItemDataCache.size=");
        sb.append(this.g.size());
        sb.append(",adItemData=");
        if (adItemData == null) {
            adItemData = com.igexin.push.core.b.l;
        }
        sb.append(adItemData);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    private void c() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "clearDataMap");
        this.g.evictAll();
        this.e.evictAll();
    }

    private void c(String str) {
        try {
            if (!com.opos.cmn.an.c.a.a(str)) {
                this.e.remove(str);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "", e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("removeListenerList pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",sListenerMap.size=");
        sb.append(this.e.size());
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    private void d() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "registerPkgInstallBR sDownloadBRListenerId=" + this.f25926c);
        if (-1 == this.f25926c) {
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "really registerPkgInstallBR!!!");
            this.f25926c = c.a().a(0, this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(String str) {
        boolean z;
        if (!com.opos.cmn.an.c.a.a(str)) {
            if (this.g.get(str) != null) {
                z = true;
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "isContainPkgName result=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "isContainPkgName result=" + z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.opos.mobad.model.data.AdItemData> e(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r4
            android.util.LruCache<java.lang.String, java.util.List<com.opos.mobad.model.data.AdItemData>> r0 = r0.g     // Catch: java.lang.Exception -> L27
            r1 = r5
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L27
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Exception -> L27
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r7
            if (r0 != 0) goto L32
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList     // Catch: java.lang.Exception -> L1d
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L1d
            r6 = r0
            goto L32
        L1d:
            r8 = move-exception
            r0 = r7
            r6 = r0
            r0 = r8
            r7 = r0
            goto L2a
        L27:
            r7 = move-exception
            r0 = 0
            r6 = r0
        L2a:
            java.lang.String r0 = "PkgInstallMgr"
            java.lang.String r1 = ""
            r2 = r7
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L32:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "getAdItemDataList pkgName="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = ",adItemDataList.size="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            if (r0 == 0) goto L61
            r0 = r6
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5 = r0
            goto L64
        L61:
            java.lang.String r0 = "null"
            r5 = r0
        L64:
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "PkgInstallMgr"
            r1 = r7
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.service.pkginstall.b.e(java.lang.String):java.util.List");
    }

    private void e() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "unregisterPkgInstallBR sDownloadBRListenerId=" + this.f25926c);
        if (-1 != this.f25926c) {
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "really unregisterPkgInstallBR!!!");
            c.a().a(0, this.f25926c);
            this.f25926c = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<InterfaceC0687b> f(String str) {
        HashSet hashSet;
        try {
            hashSet = this.e.get(str) != null ? this.e.get(str) : new HashSet();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
            hashSet = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getListenerMap pkgName=");
        sb.append(str);
        sb.append(",listenerMap.size=");
        sb.append(hashSet != null ? Integer.valueOf(hashSet.size()) : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (com.opos.cmn.an.h.d.a.a(r4.d, android.Manifest.permission.SYSTEM_ALERT_WINDOW) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean f() {
        /*
            r4 = this;
            int r0 = com.opos.cmn.an.b.c.b()     // Catch: java.lang.Exception -> L1c
            r1 = 19
            if (r0 >= r1) goto L17
            r0 = r4
            android.content.Context r0 = r0.d     // Catch: java.lang.Exception -> L1c
            java.lang.String r1 = "android.permission.SYSTEM_ALERT_WINDOW"
            boolean r0 = com.opos.cmn.an.h.d.a.a(r0, r1)     // Catch: java.lang.Exception -> L1c
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L25
        L17:
            r0 = 1
            r5 = r0
            goto L27
        L1c:
            r6 = move-exception
            java.lang.String r0 = "PkgInstallMgr"
            java.lang.String r1 = ""
            r2 = r6
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L25:
            r0 = 0
            r5 = r0
        L27:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            java.lang.String r1 = "hasAlertWindowPermission="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "PkgInstallMgr"
            r1 = r6
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.service.pkginstall.b.f():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        try {
            if (com.opos.cmn.an.c.a.a(str)) {
                return;
            }
            j(str);
            m(str);
            if (com.opos.cmn.an.h.a.a.d(this.d)) {
                i(str);
            } else {
                a(str);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
        }
    }

    private boolean h(String str) {
        boolean z;
        try {
            List<AdItemData> e = e(str);
            z = false;
            if (e != null) {
                z = false;
                if (e.size() > 0) {
                    z = false;
                    if (e.get(0) != null) {
                        z = false;
                        if (e.get(0) != null) {
                            z = e.get(0).i().get(0).E();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
            z = false;
        }
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "isGbClickToast pkgName=" + str + ",result=" + z);
        return z;
    }

    private void i(final String str) {
        try {
            if (com.opos.cmn.an.c.a.a(str)) {
                return;
            }
            int k = k(str);
            Message obtainMessage = this.h.obtainMessage(k);
            obtainMessage.obj = str;
            Bundle bundle = new Bundle();
            bundle.putBoolean("gbClick", h(str));
            obtainMessage.setData(bundle);
            if (2 != k) {
                this.h.sendMessage(obtainMessage);
                return;
            }
            this.h.post(new Runnable() { // from class: com.opos.mobad.cmn.service.pkginstall.b.3
                @Override // java.lang.Runnable
                public void run() {
                    Context applicationContext = b.this.d.getApplicationContext();
                    Toast.makeText(applicationContext, f.c(b.this.d, str) + "已经安装完成", 0).show();
                }
            });
            this.h.sendMessageDelayed(obtainMessage, 2000L);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
        }
    }

    private void j(String str) {
        List<AdItemData> e;
        try {
            if (com.opos.cmn.an.c.a.a(str) || (e = e(str)) == null || e.size() <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= e.size()) {
                    return;
                }
                if (e.get(i2) != null && e.get(i2) != null) {
                    AdItemData adItemData = e.get(i2);
                    d.a(this.d, adItemData, adItemData.i().get(0));
                }
                i = i2 + 1;
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
        }
    }

    private int k(String str) {
        List<AdItemData> e;
        try {
            if (com.opos.cmn.an.c.a.a(str) || (e = e(str)) == null || e.size() <= 0 || e.get(0) == null || e.get(0) == null) {
                return 0;
            }
            return e.get(0).i().get(0).C();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
            return 0;
        }
    }

    private String l(String str) {
        String str2 = "";
        try {
            if (!com.opos.cmn.an.c.a.a(str)) {
                List<AdItemData> e = e(str);
                str2 = "";
                if (e != null) {
                    str2 = "";
                    if (e.size() > 0) {
                        str2 = "";
                        if (e.get(0) != null) {
                            str2 = "";
                            if (e.get(0) != null) {
                                str2 = e.get(0).i().get(0).s();
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
            str2 = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getDeepLinkUrl pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",result=");
        String str3 = com.igexin.push.core.b.l;
        if (str2 != null) {
            str3 = str2;
        }
        sb.append(str3);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
        return str2;
    }

    private void m(final String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("notifyInstallCompletedEvent pkgName=");
            sb.append(str != null ? str : com.igexin.push.core.b.l);
            com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
            this.h.post(new Runnable() { // from class: com.opos.mobad.cmn.service.pkginstall.b.5
                @Override // java.lang.Runnable
                public void run() {
                    Set<InterfaceC0687b> f;
                    if (com.opos.cmn.an.c.a.a(str) || (f = b.this.f(str)) == null || f.size() <= 0) {
                        return;
                    }
                    for (InterfaceC0687b interfaceC0687b : f) {
                        com.opos.cmn.an.f.a.b("PkgInstallMgr", "notifyInstallCompletedEvent getListenerMap =" + interfaceC0687b);
                        if (interfaceC0687b != null) {
                            List e = b.this.e(str);
                            if (e == null || e.size() <= 0 || e.get(0) == null) {
                                com.opos.cmn.an.f.a.b("PkgInstallMgr", "notify but data empty");
                            } else {
                                com.opos.cmn.an.f.a.b("PkgInstallMgr", "notifyInstallCompletedEvent listener = " + interfaceC0687b);
                                interfaceC0687b.a((AdItemData) e.get(0), str);
                            }
                        }
                    }
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
        }
    }

    public void a() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", j.o);
        try {
            e();
            c();
            if (this.f != null) {
                this.f.b();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
        }
    }

    @Override // com.opos.cmn.e.a.c.a
    public void a(View view, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("onToastShow pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",objects=");
        if (objArr == null) {
            objArr = com.igexin.push.core.b.l;
        }
        sb.append(objArr);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    @Override // com.opos.cmn.e.a.c.a
    public void a(View view, int[] iArr, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("onToastClick pkgName=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        sb.append(",objects=");
        if (objArr == null) {
            objArr = com.igexin.push.core.b.l;
        }
        sb.append(objArr);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
        try {
            a(str, iArr);
            if (this.f != null) {
                this.f.a();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
        }
    }

    public void a(InterfaceC0687b interfaceC0687b) {
        if (interfaceC0687b != null) {
            for (Set<InterfaceC0687b> set : this.e.snapshot().values()) {
                set.remove(interfaceC0687b);
            }
        }
    }

    public void a(String str, InterfaceC0687b interfaceC0687b) {
        if (interfaceC0687b != null) {
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    d();
                    b(str, interfaceC0687b);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("addPkgInstallBRListener downloadPkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",Listener=");
        sb.append(interfaceC0687b);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    public void a(String str, InterfaceC0687b interfaceC0687b, AdItemData adItemData) {
        if (interfaceC0687b != null && adItemData != null) {
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    d();
                    b(str, interfaceC0687b);
                    b(str, adItemData);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "addPkgInstallBRListener downloadPkgName=", str, "Listener=", interfaceC0687b, "adItemData=", adItemData);
    }

    public void a(String str, AdItemData adItemData) {
        if (adItemData != null) {
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    d();
                    b(str, adItemData);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "addPkgInstallBRListener downloadPkgName=", str, "adItemData=", adItemData);
    }

    @Override // com.opos.cmn.e.a.c.a
    public void b(View view, int[] iArr, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("onToastClose pkgName=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        sb.append(",objects=");
        if (objArr == null) {
            objArr = com.igexin.push.core.b.l;
        }
        sb.append(objArr);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
        try {
            if (this.f != null) {
                this.f.a();
            }
            a(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
        }
    }
}
