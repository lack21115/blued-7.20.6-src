package com.anythink.expressad.videocommon.b;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.videocommon.b.j;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/n.class */
public final class n {

    /* renamed from: c  reason: collision with root package name */
    private static final String f8756c = "UnitCacheCtroller";
    private com.anythink.expressad.videocommon.d.b f;
    private ConcurrentHashMap<String, com.anythink.expressad.videocommon.d.b> g;
    private ExecutorService k;
    private String m;
    private com.anythink.expressad.videocommon.e.d n;
    private int p;
    private com.anythink.expressad.d.c q;
    private List<com.anythink.expressad.foundation.d.c> d = new ArrayList();
    private boolean e = true;
    private f h = new f() { // from class: com.anythink.expressad.videocommon.b.n.1
        @Override // com.anythink.expressad.videocommon.b.f
        public final void a(long j, int i) {
            if (i == 5 || i == 4) {
                n.a(n.this);
                n.this.a();
            }
            if (i == 2) {
                n.a(n.this);
            }
        }
    };
    private CopyOnWriteArrayList<Map<String, c>> i = new CopyOnWriteArrayList<>();
    private long l = com.anythink.expressad.d.a.b.P;
    private int o = 2;

    /* renamed from: a  reason: collision with root package name */
    com.anythink.expressad.d.c f8757a = null;
    com.anythink.expressad.d.c b = null;
    private Context j = com.anythink.core.common.b.n.a().g();

    public n(com.anythink.expressad.foundation.d.c cVar, ExecutorService executorService, String str, int i) {
        this.p = 1;
        List<com.anythink.expressad.foundation.d.c> list = this.d;
        if (list != null && cVar != null) {
            list.add(cVar);
        }
        this.k = executorService;
        this.m = str;
        this.p = i;
        b(this.d);
    }

    public n(List<com.anythink.expressad.foundation.d.c> list, ExecutorService executorService, String str, int i) {
        this.p = 1;
        List<com.anythink.expressad.foundation.d.c> list2 = this.d;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        this.k = executorService;
        this.m = str;
        this.p = i;
        b(this.d);
    }

    private static void a(c cVar) {
        synchronized (n.class) {
            com.anythink.expressad.foundation.d.c cVar2 = null;
            if (cVar != null) {
                try {
                    cVar2 = cVar.n();
                } finally {
                }
            }
            if (cVar2 == null) {
                return;
            }
            if (cVar2.w() == 94 || cVar2.w() == 287) {
                cVar.a(c(cVar));
            }
        }
    }

    private boolean a(com.anythink.expressad.foundation.d.c cVar, String str) {
        if (TextUtils.isEmpty(cVar.ar())) {
            com.anythink.expressad.foundation.h.o.a(f8756c, "check template pre load ".concat(String.valueOf(str)));
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            l a2 = l.a();
            boolean d = a2.d(this.m + BridgeUtil.UNDERLINE_STR + cVar.Z() + BridgeUtil.UNDERLINE_STR + str);
            com.anythink.expressad.foundation.h.o.a(f8756c, "check template 预加载情况：".concat(String.valueOf(d)));
            return d;
        }
        return true;
    }

    private static boolean a(c cVar, int i) {
        long p = cVar.p();
        long f = cVar.f();
        if (TextUtils.isEmpty(cVar.a())) {
            com.anythink.expressad.foundation.h.o.a(f8756c, "checkVideoDownload video done return true");
            return true;
        } else if (i == 0) {
            if (cVar.n() == null || TextUtils.isEmpty(cVar.n().S())) {
                return false;
            }
            a(cVar);
            return true;
        } else if (f <= 0 || p * 100 < f * i) {
            return false;
        } else {
            a(cVar);
            return true;
        }
    }

    static /* synthetic */ boolean a(n nVar) {
        nVar.e = true;
        return true;
    }

    private static boolean a(String str, com.anythink.expressad.foundation.d.c cVar) {
        try {
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(f8756c, th.getMessage(), th);
        }
        if (cVar.aB() != null && cVar.aB().size() > 0 && cVar.aB().contains(2)) {
            com.anythink.expressad.foundation.h.o.b(f8756c, "Is not check endCard download status : ".concat(String.valueOf(str)));
            return true;
        } else if (!cVar.j() || t.f(str)) {
            if (w.a(str)) {
                com.anythink.expressad.foundation.h.o.b(f8756c, "checkEndcardDownload endcardUrl is null return true");
                return true;
            }
            if (b(str, cVar)) {
                com.anythink.expressad.foundation.h.o.b(f8756c, "checkEndcardDownload endcardUrl done return true");
                return true;
            }
            com.anythink.expressad.foundation.h.o.b(f8756c, "checkEndcardDownload endcardUrl return false");
            return false;
        } else {
            return true;
        }
    }

    private static boolean a(CopyOnWriteArrayList<Map<String, c>> copyOnWriteArrayList) {
        try {
            Iterator<Map<String, c>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                Map<String, c> next = it.next();
                if (next != null) {
                    for (Map.Entry<String, c> entry : next.entrySet()) {
                        if (entry.getValue().k() == 1) {
                            return true;
                        }
                    }
                    continue;
                }
            }
            return false;
        } catch (Throwable th) {
            if (com.anythink.expressad.a.f6941a) {
                th.printStackTrace();
                return false;
            }
            return false;
        }
    }

    private int b(com.anythink.expressad.foundation.d.c cVar) {
        int i = -1;
        if (cVar != null) {
            if (cVar.ao() != -1) {
                int ao = cVar.ao();
                com.anythink.expressad.foundation.h.o.a(f8756c, "ready_rate(campaign): ".concat(String.valueOf(ao)));
                return ao;
            }
            i = d(cVar);
            com.anythink.expressad.foundation.h.o.a(f8756c, "ready_rate(reward_unit_setting): ".concat(String.valueOf(i)));
        }
        return i;
    }

    private static String b(c cVar) {
        String c2;
        synchronized (n.class) {
            try {
                c2 = c(cVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return c2;
    }

    private void b(List<com.anythink.expressad.foundation.d.c> list) {
        String str;
        CopyOnWriteArrayList<Map<String, c>> copyOnWriteArrayList;
        boolean z;
        if (list == null || list.size() == 0) {
            return;
        }
        f();
        e();
        int i = this.p;
        if (i != 1) {
            if (i != 287) {
                if (i == 298) {
                    com.anythink.expressad.d.b.a();
                    com.anythink.expressad.d.c d = com.anythink.expressad.d.b.d(com.anythink.expressad.foundation.b.a.b().e(), this.m);
                    this.b = d;
                    if (d == null) {
                        com.anythink.expressad.d.b.a();
                        this.b = com.anythink.expressad.d.b.b(com.anythink.expressad.foundation.b.a.b().e(), this.m);
                    }
                    com.anythink.expressad.d.c cVar = this.b;
                    if (cVar != null) {
                        this.l = cVar.i();
                        this.o = this.b.m();
                    }
                } else if (i != 94) {
                    if (i == 95) {
                        try {
                            if (!TextUtils.isEmpty(this.m)) {
                                com.anythink.expressad.d.b.a();
                                com.anythink.expressad.d.c c2 = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.m);
                                com.anythink.expressad.d.c cVar2 = c2;
                                if (c2 == null) {
                                    cVar2 = com.anythink.expressad.d.c.d(this.m);
                                }
                                if (cVar2 != null) {
                                    this.l = cVar2.i();
                                    this.o = cVar2.m();
                                }
                            }
                        } catch (Exception e) {
                            com.anythink.expressad.foundation.h.o.d(f8756c, "make sure your had put feeds jar into your project");
                            return;
                        }
                    }
                }
            }
            try {
                com.anythink.expressad.videocommon.e.a b = com.anythink.expressad.videocommon.e.c.a().b();
                if (b == null) {
                    com.anythink.expressad.videocommon.e.c.a();
                    com.anythink.expressad.videocommon.e.c.c();
                }
                if (b != null) {
                    this.l = b.e();
                }
                if (!TextUtils.isEmpty(this.m)) {
                    this.n = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.m);
                }
                if (this.n != null) {
                    this.o = this.n.F();
                }
            } catch (Exception e2) {
                com.anythink.expressad.foundation.h.o.d(f8756c, "make sure your had put reward jar into your project");
                return;
            }
        } else {
            try {
                if (!TextUtils.isEmpty(this.m)) {
                    com.anythink.expressad.d.b.a();
                    com.anythink.expressad.d.c c3 = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.m);
                    this.f8757a = c3;
                    if (c3 == null) {
                        this.f8757a = com.anythink.expressad.d.c.c(this.m);
                    }
                    if (this.f8757a != null) {
                        this.l = this.f8757a.i();
                        this.o = this.f8757a.m();
                    }
                }
            } catch (Exception e3) {
                com.anythink.expressad.foundation.h.o.d(f8756c, "make sure your had put feeds jar into your project");
                return;
            }
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                break;
            }
            com.anythink.expressad.foundation.d.c cVar3 = list.get(i3);
            if (cVar3 != null) {
                int i4 = this.p;
                if (i4 == 94 || i4 == 287) {
                    str = cVar3.Z() + cVar3.aZ() + cVar3.S();
                } else {
                    str = cVar3.aZ() + cVar3.S() + cVar3.B();
                }
                if ((c(cVar3) || !TextUtils.isEmpty(cVar3.S())) && (copyOnWriteArrayList = this.i) != null) {
                    synchronized (copyOnWriteArrayList) {
                        int i5 = 0;
                        while (true) {
                            try {
                                int i6 = i5;
                                if (i6 >= this.i.size()) {
                                    z = false;
                                    break;
                                }
                                Map<String, c> map = this.i.get(i6);
                                if (map != null && map.containsKey(str)) {
                                    c cVar4 = map.get(str);
                                    cVar4.a(cVar3);
                                    cVar4.a(this.o);
                                    cVar4.a(false);
                                    map.remove(str);
                                    map.put(str, cVar4);
                                    this.i.set(i6, map);
                                    z = true;
                                    break;
                                }
                                i5 = i6 + 1;
                            } catch (Throwable th) {
                            }
                        }
                        if (!z) {
                            c cVar5 = new c(this.j, cVar3, this.k, this.m);
                            cVar5.a(this.o);
                            cVar5.e(this.p);
                            HashMap hashMap = new HashMap();
                            hashMap.put(str, cVar5);
                            this.i.add(hashMap);
                        }
                    }
                }
            }
            i2 = i3 + 1;
        }
        List<com.anythink.expressad.foundation.d.c> list2 = this.d;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        this.d.clear();
    }

    private static boolean b(com.anythink.expressad.foundation.d.c cVar, String str) {
        com.anythink.expressad.foundation.h.o.a(f8756c, "check template ".concat(String.valueOf(str)));
        if (cVar.j()) {
            return true;
        }
        if (cVar.aB() != null && cVar.aB().size() > 0 && cVar.aB().contains(1)) {
            com.anythink.expressad.foundation.h.o.b(f8756c, "Is not check template download status");
            return true;
        } else if (TextUtils.isEmpty(str) || cVar.av() != 0) {
            return true;
        } else {
            com.anythink.expressad.foundation.h.o.a(f8756c, "check template 下载情况：" + i.a().c(str));
            return i.a().c(str) != null;
        }
    }

    private static boolean b(c cVar, int i) {
        return a(cVar, i);
    }

    private static boolean b(String str, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar.H() || TextUtils.isEmpty(str)) {
            com.anythink.expressad.foundation.h.o.b(f8756c, "Campaign is Mraid, do not need download endcardurl or Campaign load timeout");
            return true;
        } else if (cVar.av() != 1 || c(cVar)) {
            if (cVar.aB() != null && cVar.aB().size() > 0 && cVar.aB().contains(2)) {
                com.anythink.expressad.foundation.h.o.b(f8756c, "Is not check endCard download status : ".concat(String.valueOf(str)));
                return true;
            } else if (w.b(i.a().c(str))) {
                com.anythink.expressad.foundation.h.o.b(f8756c, "endcard zip 下载完成 return true endcardUrl:".concat(String.valueOf(str)));
                return true;
            } else if (w.b(j.a.f8748a.b(str))) {
                com.anythink.expressad.foundation.h.o.b(f8756c, "endcard url 源码 下载完成 return true endcardUrl:".concat(String.valueOf(str)));
                return true;
            } else {
                com.anythink.expressad.foundation.h.o.b(f8756c, "checkEndcardZipOrSourceDownLoad endcardUrl return false endcardUrl:".concat(String.valueOf(str)));
                return false;
            }
        } else {
            return true;
        }
    }

    private static String c(c cVar) {
        synchronized (n.class) {
            if (cVar == null) {
                return "";
            }
            try {
                String S = cVar.n().S();
                String str = S;
                if (cVar.k() == 5) {
                    String e = cVar.e();
                    str = S;
                    if (!w.a(e)) {
                        str = S;
                        if (new File(e).exists()) {
                            str = e;
                        }
                    }
                }
                return str;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean c(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            try {
                return cVar.J() == 2;
            } catch (Throwable th) {
                if (com.anythink.expressad.a.f6941a) {
                    th.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    private int d(com.anythink.expressad.foundation.d.c cVar) {
        try {
            if (cVar.w() == 298) {
                if (this.b == null) {
                    com.anythink.expressad.d.b.a();
                    this.b = com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e(), this.m);
                }
                return this.b.f();
            } else if (cVar.w() == 42) {
                return h();
            } else {
                if (this.n == null) {
                    this.n = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.m, false);
                }
                return this.n.v();
            }
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(f8756c, th.getMessage(), th);
            return 100;
        }
    }

    private void e() {
        CopyOnWriteArrayList<Map<String, c>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < this.i.size()) {
                            Map<String, c> map = this.i.get(i2);
                            for (Map.Entry<String, c> entry : map.entrySet()) {
                                c value = entry.getValue();
                                if (value != null) {
                                    int i3 = i2;
                                    if (currentTimeMillis - value.c() > this.l * 1000) {
                                        i3 = i2;
                                        if (value.k() == 1) {
                                            value.j();
                                            value.a(this.o);
                                            this.i.remove(map);
                                            i3 = i2 - 1;
                                        }
                                    }
                                    i2 = i3;
                                    if (value.k() != 1) {
                                        i2 = i3;
                                        if (value.k() != 5) {
                                            i2 = i3;
                                            if (value.k() != 0) {
                                                this.i.remove(map);
                                                i2 = i3 - 1;
                                            }
                                        }
                                    }
                                }
                            }
                            i = i2 + 1;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void f() {
        CopyOnWriteArrayList<Map<String, c>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < this.i.size()) {
                            Map<String, c> map = this.i.get(i2);
                            for (Map.Entry<String, c> entry : map.entrySet()) {
                                c value = entry.getValue();
                                if (value != null && value.n() != null && value.b() && value.d()) {
                                    value.o();
                                    this.i.remove(map);
                                    i2--;
                                }
                            }
                            i = i2 + 1;
                        }
                    }
                }
            } catch (Throwable th) {
                com.anythink.expressad.foundation.h.o.d(f8756c, "cleanDisplayTask ERROR");
            }
        }
    }

    private static boolean g() {
        return true;
    }

    private int h() {
        int i = 100;
        try {
            if (this.f8757a != null) {
                i = this.f8757a.f();
            }
            return i;
        } catch (Exception e) {
            return 100;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x02ed, code lost:
        if (r7.p == 94) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x03ca, code lost:
        if (r7.p == 287) goto L146;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.anythink.expressad.videocommon.b.c a(int r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 1095
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.videocommon.b.n.a(int, boolean):com.anythink.expressad.videocommon.b.c");
    }

    public final c a(String str) {
        CopyOnWriteArrayList<Map<String, c>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            synchronized (copyOnWriteArrayList) {
                Iterator<Map<String, c>> it = this.i.iterator();
                while (it.hasNext()) {
                    Map<String, c> next = it.next();
                    if (next != null && next.containsKey(str)) {
                        return next.get(str);
                    }
                }
                return null;
            }
        }
        return null;
    }

    public final List<c> a(boolean z, List<com.anythink.expressad.foundation.d.c> list) {
        int i;
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList<Map<String, c>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList == null) {
            return arrayList;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.i.size()) {
                        break;
                    }
                    Map<String, c> map = this.i.get(i3);
                    for (Map.Entry<String, c> entry : map.entrySet()) {
                        c value = entry.getValue();
                        if (value != null && value.n() != null) {
                            com.anythink.expressad.foundation.d.c n = value.n();
                            boolean z2 = false;
                            for (com.anythink.expressad.foundation.d.c cVar : list) {
                                if (n != null && cVar != null && !TextUtils.isEmpty(n.Z()) && !TextUtils.isEmpty(cVar.Z()) && n.aZ().equals(cVar.aZ()) && n.Z().equals(cVar.Z())) {
                                    z2 = true;
                                }
                            }
                            if (!z2) {
                                com.anythink.expressad.foundation.h.o.b(f8756c, "UnitCache isReady ==== Campaign isAvailable = ".concat(String.valueOf(z2)));
                            } else if ((!z || n.A()) && (z || !n.A())) {
                                String I = n.I();
                                String S = n.S();
                                String str = "";
                                if (n != null) {
                                    str = "";
                                    if (n.M() != null) {
                                        str = n.M().e();
                                    }
                                }
                                n.M();
                                if (TextUtils.isEmpty(str) || str.contains(com.anythink.expressad.foundation.d.c.d) || b(n, str)) {
                                    if (b(I, n)) {
                                        if (value.b()) {
                                            value.o();
                                            com.anythink.expressad.foundation.h.o.b(f8756c, "isready endcard下载完 但是offer展示过 continue");
                                        } else if (w.a(S)) {
                                            com.anythink.expressad.foundation.h.o.b(f8756c, "endcard为基准 endcard和图片下载完成 videourl为空不用下载 return task");
                                            arrayList.add(value);
                                        } else if (a(value, b(n))) {
                                            com.anythink.expressad.foundation.h.o.b(f8756c, "endcard为基准 endcard 图片 和 videourl 下载完成 return task");
                                            arrayList.add(value);
                                        }
                                    }
                                    boolean isEmpty = TextUtils.isEmpty(value.m());
                                    int k = value.k();
                                    com.anythink.expressad.foundation.h.o.a(f8756c, "isready unit state:".concat(String.valueOf(k)));
                                    if (k != 5) {
                                        long c2 = value.c();
                                        if (value.k() == 1 && currentTimeMillis - c2 > this.l * 1000) {
                                            value.j();
                                            this.i.remove(map);
                                            i = i3 - 1;
                                            com.anythink.expressad.foundation.h.o.b(f8756c, "isready download !timeout continue");
                                        } else if (k == 4 || k == 2) {
                                            this.i.remove(map);
                                            i = i3 - 1;
                                            com.anythink.expressad.foundation.h.o.b(f8756c, "isready stop continue");
                                        } else {
                                            if (k == 1) {
                                                if (value.b()) {
                                                    com.anythink.expressad.foundation.h.o.b(f8756c, "isready run 已经被展示过 continue");
                                                    i = i3;
                                                } else if (!com.anythink.expressad.a.p && a(value, b(n)) && a(I, n)) {
                                                    com.anythink.expressad.foundation.h.o.b(f8756c, "isready  IS_DOWANLOAD_FINSH_PLAY is :" + com.anythink.expressad.a.p);
                                                    arrayList.add(value);
                                                    i = i3;
                                                }
                                            }
                                            i = i3;
                                            if (a(value, b(n))) {
                                                i = i3;
                                                if (a(I, n)) {
                                                    arrayList.add(value);
                                                    i = i3;
                                                }
                                            }
                                        }
                                        i3 = i;
                                    } else if (value.b()) {
                                        value.o();
                                        this.i.remove(map);
                                        i3--;
                                        com.anythink.expressad.foundation.h.o.b(f8756c, "isready state == DownLoadConstant.DOWNLOAD_DONE 但是offer展示过 continue");
                                    } else if (!isEmpty) {
                                        value.l();
                                        com.anythink.expressad.foundation.h.o.b(f8756c, "isready !isEffectivePath continue");
                                    } else if (!a(I, n)) {
                                        com.anythink.expressad.foundation.h.o.b(f8756c, "isready done but continue");
                                        return null;
                                    } else {
                                        com.anythink.expressad.foundation.h.o.b(f8756c, "isready videourl为基准 state＝done endcard 图片 和 videourl 下载完成 return task");
                                        arrayList.add(value);
                                    }
                                } else {
                                    com.anythink.expressad.foundation.h.o.b(f8756c, "UnitCache isReady ====  templateZipDownload check false continue");
                                }
                            } else {
                                com.anythink.expressad.foundation.h.o.b(f8756c, "UnitCache isReady ==== isBidCampaign = " + z + " campaign.isBidCampaign() = " + n.A());
                            }
                            i = i3;
                            i3 = i;
                        }
                        com.anythink.expressad.foundation.h.o.b(f8756c, "UnitCache isReady ==== task 或者 campaign为空 continue");
                        i = i3;
                        i3 = i;
                    }
                    i2 = i3 + 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x027d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0053 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0136 A[Catch: all -> 0x02ef, TryCatch #0 {, blocks: (B:6:0x0012, B:8:0x001c, B:10:0x0022, B:12:0x002c, B:14:0x0034, B:16:0x0045, B:18:0x0055, B:20:0x005d, B:22:0x0076, B:24:0x007e, B:26:0x0087, B:28:0x008e, B:30:0x00b1, B:32:0x00b8, B:34:0x00bf, B:36:0x00cb, B:38:0x00d1, B:40:0x00de, B:42:0x00e8, B:45:0x00f4, B:47:0x00fe, B:49:0x0105, B:51:0x011b, B:53:0x0121, B:55:0x012e, B:57:0x0136, B:59:0x013d, B:62:0x0154, B:64:0x015b, B:76:0x01b1, B:78:0x01bc, B:79:0x01c5, B:81:0x0216, B:83:0x021d, B:85:0x0227, B:88:0x0232, B:90:0x0240, B:92:0x0246, B:94:0x0250, B:98:0x026b, B:108:0x028f, B:111:0x0298, B:113:0x02a8, B:115:0x02b1, B:118:0x02bd, B:119:0x02c3, B:121:0x02cb, B:123:0x02d4, B:128:0x02e5, B:126:0x02df, B:65:0x0166, B:67:0x016d, B:71:0x0190, B:73:0x01a0, B:75:0x01a6, B:130:0x02ed), top: B:142:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01bc A[Catch: all -> 0x02ef, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0012, B:8:0x001c, B:10:0x0022, B:12:0x002c, B:14:0x0034, B:16:0x0045, B:18:0x0055, B:20:0x005d, B:22:0x0076, B:24:0x007e, B:26:0x0087, B:28:0x008e, B:30:0x00b1, B:32:0x00b8, B:34:0x00bf, B:36:0x00cb, B:38:0x00d1, B:40:0x00de, B:42:0x00e8, B:45:0x00f4, B:47:0x00fe, B:49:0x0105, B:51:0x011b, B:53:0x0121, B:55:0x012e, B:57:0x0136, B:59:0x013d, B:62:0x0154, B:64:0x015b, B:76:0x01b1, B:78:0x01bc, B:79:0x01c5, B:81:0x0216, B:83:0x021d, B:85:0x0227, B:88:0x0232, B:90:0x0240, B:92:0x0246, B:94:0x0250, B:98:0x026b, B:108:0x028f, B:111:0x0298, B:113:0x02a8, B:115:0x02b1, B:118:0x02bd, B:119:0x02c3, B:121:0x02cb, B:123:0x02d4, B:128:0x02e5, B:126:0x02df, B:65:0x0166, B:67:0x016d, B:71:0x0190, B:73:0x01a0, B:75:0x01a6, B:130:0x02ed), top: B:142:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0216 A[Catch: all -> 0x02ef, TryCatch #0 {, blocks: (B:6:0x0012, B:8:0x001c, B:10:0x0022, B:12:0x002c, B:14:0x0034, B:16:0x0045, B:18:0x0055, B:20:0x005d, B:22:0x0076, B:24:0x007e, B:26:0x0087, B:28:0x008e, B:30:0x00b1, B:32:0x00b8, B:34:0x00bf, B:36:0x00cb, B:38:0x00d1, B:40:0x00de, B:42:0x00e8, B:45:0x00f4, B:47:0x00fe, B:49:0x0105, B:51:0x011b, B:53:0x0121, B:55:0x012e, B:57:0x0136, B:59:0x013d, B:62:0x0154, B:64:0x015b, B:76:0x01b1, B:78:0x01bc, B:79:0x01c5, B:81:0x0216, B:83:0x021d, B:85:0x0227, B:88:0x0232, B:90:0x0240, B:92:0x0246, B:94:0x0250, B:98:0x026b, B:108:0x028f, B:111:0x0298, B:113:0x02a8, B:115:0x02b1, B:118:0x02bd, B:119:0x02c3, B:121:0x02cb, B:123:0x02d4, B:128:0x02e5, B:126:0x02df, B:65:0x0166, B:67:0x016d, B:71:0x0190, B:73:0x01a0, B:75:0x01a6, B:130:0x02ed), top: B:142:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 781
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.videocommon.b.n.a():void");
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        List<com.anythink.expressad.foundation.d.c> list = this.d;
        if (list != null && cVar != null) {
            list.add(cVar);
        }
        b(this.d);
    }

    public final void a(com.anythink.expressad.videocommon.d.b bVar) {
        this.f = bVar;
    }

    public final void a(String str, com.anythink.expressad.videocommon.d.b bVar) {
        if (this.g == null) {
            this.g = new ConcurrentHashMap<>();
        }
        this.g.put(str, bVar);
    }

    public final void a(List<com.anythink.expressad.foundation.d.c> list) {
        List<com.anythink.expressad.foundation.d.c> list2 = this.d;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        b(this.d);
    }

    public final c b(int i, boolean z) {
        try {
            return a(i, z);
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(f8756c, th.getMessage(), th);
            return null;
        }
    }

    public final void b() {
        try {
            if (this.i != null) {
                synchronized (this.i) {
                    Iterator<Map<String, c>> it = this.i.iterator();
                    while (it.hasNext()) {
                        Map<String, c> next = it.next();
                        if (next != null) {
                            for (Map.Entry<String, c> entry : next.entrySet()) {
                                c value = entry.getValue();
                                if (value != null) {
                                    int k = value.k();
                                    if (k != 1 && k != 5) {
                                        if (com.anythink.expressad.foundation.h.k.a() != 9 && this.o == 2) {
                                            return;
                                        }
                                        if (k == 2 || k == 0) {
                                            value.h();
                                            return;
                                        }
                                    }
                                }
                            }
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public final void b(String str) {
        try {
            synchronized (this.i) {
                if (!TextUtils.isEmpty(str) && this.i != null && this.i.size() > 0) {
                    Iterator<Map<String, c>> it = this.i.iterator();
                    while (it.hasNext()) {
                        Map<String, c> next = it.next();
                        if (next != null) {
                            for (Map.Entry<String, c> entry : next.entrySet()) {
                                if (entry != null && TextUtils.equals(entry.getKey(), str)) {
                                    this.i.remove(next);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public final void c() {
        CopyOnWriteArrayList<Map<String, c>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    Iterator<Map<String, c>> it = this.i.iterator();
                    while (it.hasNext()) {
                        Map<String, c> next = it.next();
                        if (next != null) {
                            for (Map.Entry<String, c> entry : next.entrySet()) {
                                c value = entry.getValue();
                                if (value != null && value.k() == 1) {
                                    com.anythink.expressad.foundation.h.o.b(f8756c, "暂停所有下载");
                                    value.j();
                                    this.i.remove(next);
                                    return;
                                }
                            }
                            continue;
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public final void d() {
        CopyOnWriteArrayList<Map<String, c>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    Iterator<Map<String, c>> it = this.i.iterator();
                    while (it.hasNext()) {
                        Map<String, c> next = it.next();
                        if (next == null) {
                            return;
                        }
                        for (Map.Entry<String, c> entry : next.entrySet()) {
                            c value = entry.getValue();
                            if (value != null) {
                                value.o();
                            }
                        }
                    }
                    this.i.clear();
                }
            } catch (Throwable th) {
                com.anythink.expressad.foundation.h.o.d(f8756c, "campaignDownLoadTaskList clean failed");
            }
        }
        List<com.anythink.expressad.foundation.d.c> list = this.d;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.d.clear();
    }
}
