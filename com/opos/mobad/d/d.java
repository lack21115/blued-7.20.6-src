package com.opos.mobad.d;

import android.content.Context;
import com.opos.mobad.c.a;
import com.opos.mobad.c.a.a;
import com.opos.mobad.h;
import java.io.Closeable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/d.class */
public class d implements com.opos.mobad.c.a, com.opos.mobad.c.a.a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f12293a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private c f12294c;

    private d() {
    }

    public static d a() {
        d dVar;
        d dVar2 = f12293a;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            try {
                d dVar3 = f12293a;
                dVar = dVar3;
                if (dVar3 == null) {
                    dVar = new d();
                    f12293a = dVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("fLoader", "close", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02ea, code lost:
        r19.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02f4, code lost:
        r12.a(r9, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02fd, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f5, code lost:
        com.opos.cmn.an.f.a.b("fLoader", "load to cache");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0100, code lost:
        if (android.text.TextUtils.isEmpty(r10) != false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0103, code lost:
        r0 = r19.clone();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x010c, code lost:
        r20 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0122, code lost:
        if (r0.md5().hex().equals(r10) != false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x012d, code lost:
        com.opos.cmn.an.f.a.b("fLoader", "load but md5 fail");
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0136, code lost:
        if (r12 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0141, code lost:
        r12.a(r9, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x014b, code lost:
        a((java.io.Closeable) r19);
        a(r0);
        a((java.io.Closeable) r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x015e, code lost:
        if (r21 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0164, code lost:
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0168, code lost:
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x016c, code lost:
        r20 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0171, code lost:
        if (r12 == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x017c, code lost:
        r12.a(r9, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0185, code lost:
        r0 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x018d, code lost:
        r8.f12294c.a(r9, r19, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0199, code lost:
        a((java.io.Closeable) r19);
        a(r20);
        a((java.io.Closeable) r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01ac, code lost:
        if (r21 == null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01b2, code lost:
        r10 = r0;
        r11 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01bb, code lost:
        r11 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01d5, code lost:
        com.opos.cmn.an.f.a.b("fLoader", "load to file by size");
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01e0, code lost:
        a(r9, r10, r11, r18, r19, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01ee, code lost:
        a((java.io.Closeable) r19);
        a((java.io.Closeable) null);
        a((java.io.Closeable) r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0200, code lost:
        if (r21 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0206, code lost:
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x020a, code lost:
        r20 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0210, code lost:
        r11 = r19;
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x021a, code lost:
        r10 = r19;
        r19 = r21;
        r11 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r9, java.lang.String r10, java.lang.String r11, com.opos.mobad.c.a.a.InterfaceC0507a r12) {
        /*
            Method dump skipped, instructions count: 815
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.d.d.a(java.lang.String, java.lang.String, java.lang.String, com.opos.mobad.c.a.a$a):void");
    }

    private void a(String str, String str2, String str3, BufferedSource bufferedSource, Buffer buffer, a.InterfaceC0507a interfaceC0507a) {
        int i;
        int a2 = buffer == null ? this.f12294c.a(str, bufferedSource, str2, str3) : this.f12294c.a(str, bufferedSource, buffer, str2, str3);
        if (a2 == 0) {
            if (interfaceC0507a == null) {
                return;
            }
            i = 0;
        } else if (a2 == 1) {
            if (interfaceC0507a == null) {
                return;
            }
            i = 2;
        } else if (interfaceC0507a == null) {
            return;
        } else {
            i = 3;
        }
        interfaceC0507a.a(str, i);
    }

    private <T extends a.b> void b(List<T> list, final a.InterfaceC0507a interfaceC0507a, final com.opos.mobad.c.a.b bVar) {
        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
        final Set synchronizedSet = Collections.synchronizedSet(new HashSet());
        if (bVar != null && !h.a(bVar, 6, 70)) {
            if (bVar != null) {
                bVar.b();
            }
            if (interfaceC0507a != null) {
                interfaceC0507a.a();
                return;
            }
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            final T t = list.get(i2);
            final boolean z = i2 == list.size() - 1;
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.d.d.1
                @Override // java.lang.Runnable
                public void run() {
                    a.b bVar2 = t;
                    if (bVar2 != null) {
                        if (synchronizedSet.contains(bVar2.f12118a)) {
                            com.opos.cmn.an.f.a.b("fLoader", "url repeat:" + t.f12118a);
                        } else {
                            synchronizedSet.add(t.f12118a);
                            a.InterfaceC0507a interfaceC0507a2 = interfaceC0507a;
                            if (interfaceC0507a2 != null) {
                                interfaceC0507a2.a(t.f12118a);
                            }
                            if (d.this.f12294c.a(t.f12118a, t.b, t.f12119c)) {
                                a.InterfaceC0507a interfaceC0507a3 = interfaceC0507a;
                                if (interfaceC0507a3 != null) {
                                    interfaceC0507a3.a(t.f12118a, 1);
                                }
                            } else {
                                d.this.a(t.f12118a, t.b, t.f12119c, interfaceC0507a);
                            }
                        }
                    }
                    countDownLatch.countDown();
                    if (z) {
                        com.opos.cmn.an.f.a.b("fLoader", "wait for complete");
                        try {
                            try {
                                countDownLatch.await(5000L, TimeUnit.MILLISECONDS);
                            } catch (Exception e) {
                                com.opos.cmn.an.f.a.b("fLoader", "wait time out ", e);
                            }
                            if (interfaceC0507a != null) {
                                interfaceC0507a.a();
                            }
                        } finally {
                            com.opos.mobad.c.a.b bVar3 = bVar;
                            if (bVar3 != null) {
                                bVar3.b();
                            }
                        }
                    }
                }
            });
            i = i2 + 1;
        }
    }

    public void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.f12294c = new c(applicationContext);
    }

    @Override // com.opos.mobad.c.a
    public void a(String str, String str2, int i, int i2, a.InterfaceC0506a interfaceC0506a) {
        if (this.b != null) {
            this.f12294c.a(str, str2, i, i2, interfaceC0506a);
        } else if (interfaceC0506a != null) {
            interfaceC0506a.a(2, null);
        }
    }

    public <T extends a.b> void a(List<T> list, a.InterfaceC0507a interfaceC0507a) {
        a(list, interfaceC0507a, null);
    }

    public <T extends a.b> void a(List<T> list, a.InterfaceC0507a interfaceC0507a, com.opos.mobad.c.a.b bVar) {
        if (this.b != null && list != null && list.size() > 0) {
            b(list, interfaceC0507a, bVar);
        } else if (interfaceC0507a != null) {
            interfaceC0507a.a();
        }
    }
}
