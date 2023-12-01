package com.tencent.qmsp.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qmsp.sdk.c.a;
import com.tencent.qmsp.sdk.c.g;
import com.tencent.qmsp.sdk.c.j;
import com.tencent.qmsp.sdk.d.d;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/k.class */
public class k {
    private static final byte[][] i = {new byte[]{44, 116}, new byte[]{49, 105, -93, 69}, new byte[]{35, 124, -78, 71}, new byte[]{40, Byte.MAX_VALUE, -73, 69}, new byte[]{51, 117, -95}, new byte[]{20, 65, -125, 82, 33, 47, 114, -2, 49, 62, -126, 125, -96, 80}, new byte[]{20, 125, -96, 80, 29, 11}};
    private static k j;
    private com.tencent.qmsp.sdk.c.g d;
    private boolean f = false;
    private boolean g = false;
    private CopyOnWriteArrayList<e> h = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<f> b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private j f38566c = new j();

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Integer, f> f38565a = new ConcurrentHashMap<>();
    private Handler e = new g(com.tencent.qmsp.sdk.app.b.e().c());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/k$a.class */
    public class a implements g.c {
        a() {
        }

        @Override // com.tencent.qmsp.sdk.c.g.c
        public void a(List<Pair<Integer, Integer>> list) {
            Message obtainMessage = k.this.e.obtainMessage(2);
            obtainMessage.obj = list;
            k.this.e.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/k$b.class */
    public final class b implements a.InterfaceC0986a {

        /* renamed from: a  reason: collision with root package name */
        public f f38568a;

        b(k kVar) {
        }

        @Override // com.tencent.qmsp.sdk.c.a.InterfaceC0986a
        public void a() {
            this.f38568a.d = 26;
        }

        @Override // com.tencent.qmsp.sdk.c.a.InterfaceC0986a
        public void run() {
            f fVar;
            int i;
            String str = this.f38568a.h;
            if (str == null || str.contains("..")) {
                fVar = this.f38568a;
                i = 15;
            } else {
                File file = new File(this.f38568a.h);
                if (file.exists()) {
                    this.f38568a.i = new o();
                    int i2 = this.f38568a.b;
                    if ((i2 == 2 || i2 == 1) && !com.tencent.qmsp.sdk.d.e.b(file, null)) {
                        this.f38568a.d = 10;
                        return;
                    }
                    Object[] objArr = new Object[1];
                    f fVar2 = this.f38568a;
                    fVar2.d = com.tencent.qmsp.sdk.c.f.a(2L, fVar2.b, fVar2.f38571a, 0L, fVar2.h, null, null, objArr);
                    if (objArr[0] == null || !(objArr[0] instanceof Integer)) {
                        return;
                    }
                    this.f38568a.f = ((Integer) objArr[0]).intValue();
                    return;
                }
                fVar = this.f38568a;
                i = 12;
            }
            fVar.d = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/k$c.class */
    public class c extends i {
        c() {
            super(k.this, null);
        }

        @Override // com.tencent.qmsp.sdk.c.k.i
        public void a() {
            if (this.f38575a) {
                k.this.f38566c.a();
            }
        }

        @Override // com.tencent.qmsp.sdk.c.k.i
        public void a(String str, String str2, int i, int i2, int i3, int i4) {
            com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("visitQSecSFUItem libPath = %s libVer = %s libId = %d", str, str2, Integer.valueOf(i)));
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (i4 != 1 && i4 != 2) {
                com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Invalid mode: %d", Integer.valueOf(i4)));
                return;
            }
            j.a a2 = k.this.f38566c.a(i);
            if (a2 != null) {
                k.this.f38566c.a(a2.f38563a, false);
            } else {
                a2 = new j.a();
            }
            a2.f38563a = i;
            a2.b = i2;
            a2.f38564c = i3;
            a2.e = str;
            a2.d = str2;
            k.this.f38566c.a(a2, false);
            this.f38575a = true;
            com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("visitQSecSFUItem libId = %d", Integer.valueOf(i)));
            if (i4 == 1 && k.this.d.a(i) == 1) {
                f fVar = (f) k.this.f38565a.get(Integer.valueOf(i));
                if (fVar == null) {
                    k.this.c(k.this.a(a2));
                    return;
                }
                k.this.a(fVar, str2, str);
                if (fVar.d != 0) {
                    k.this.f38565a.remove(Integer.valueOf(fVar.f38571a));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/k$d.class */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.i();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/k$e.class */
    public interface e {
        void a(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/k$f.class */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public int f38571a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f38572c;
        public int d;
        public int e;
        public int f;
        public String g;
        public String h;
        public o i;

        private f() {
            this.d = -1;
            this.g = "";
            this.h = "";
        }

        /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/k$g.class */
    class g extends Handler {
        public g(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            int i = message.what;
            if (i == 1) {
                k.this.g();
            } else if (i == 2) {
                Object obj2 = message.obj;
                if (obj2 != null) {
                    k.this.b((List) obj2);
                }
            } else if (i == 3) {
                k.this.h();
            } else if (i == 4) {
                k.this.i();
            } else if (i == 5 && (obj = message.obj) != null) {
                k.this.c((e) obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/k$h.class */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        private i f38574a;

        public h(i iVar) {
            this.f38574a = iVar;
        }

        public void a(int i) {
            i iVar;
            com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("QSecSFUReader read, bid = %d ", Integer.valueOf(i)));
            try {
                try {
                    List<d.b> a2 = new com.tencent.qmsp.sdk.d.b().a(1L);
                    if (a2 != null) {
                        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("QSecSFUReader read updateSections count = %d ", Integer.valueOf(a2.size())));
                        for (d.b bVar : a2) {
                            if (bVar.b == i && bVar.o != null) {
                                for (d.a aVar : bVar.o) {
                                    if (!TextUtils.isEmpty(aVar.i)) {
                                        String str = aVar.f;
                                        if (!TextUtils.isEmpty(aVar.g)) {
                                            str = aVar.g;
                                        }
                                        if (str != null) {
                                            com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("ExtraInfo: %s path: %s", aVar.i, str));
                                            JSONObject jSONObject = new JSONObject(aVar.i);
                                            int i2 = jSONObject.getInt(k.b(0));
                                            int i3 = jSONObject.getInt(k.b(1));
                                            int i4 = jSONObject.getInt(k.b(2));
                                            int i5 = jSONObject.getInt(k.b(3));
                                            String string = jSONObject.getString(k.b(4));
                                            if (this.f38574a != null) {
                                                this.f38574a.a(str, string, i2, i3, i4, i5);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    iVar = this.f38574a;
                    if (iVar == null) {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    iVar = this.f38574a;
                    if (iVar == null) {
                        return;
                    }
                }
                iVar.a();
            } catch (Throwable th) {
                i iVar2 = this.f38574a;
                if (iVar2 != null) {
                    iVar2.a();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/k$i.class */
    public class i {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f38575a;

        private i() {
            this.f38575a = false;
        }

        /* synthetic */ i(k kVar, a aVar) {
            this();
        }

        public void a() {
            if (this.f38575a) {
                k.this.f38566c.a();
            }
        }

        public void a(String str, String str2, int i, int i2, int i3, int i4) {
            com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("visitQSecSFUItem libPath = %s libVer = %s libId = %d", str, str2, Integer.valueOf(i)));
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            j.a a2 = k.this.f38566c.a(i);
            if (a2 != null && str.equals(a2.e) && str2.equals(a2.d) && i2 == a2.b && i3 == a2.f38564c) {
                return;
            }
            if (a2 == null) {
                a2 = new j.a();
            } else {
                k.this.f38566c.a(i, false);
                com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Database info mismatch for lib: %d", Integer.valueOf(i)));
            }
            a2.f38563a = i;
            a2.b = i2;
            a2.f38564c = i3;
            a2.e = str;
            a2.d = str2;
            com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Add lost lib: %d,%d,%d,%s", Integer.valueOf(a2.f38563a), Integer.valueOf(a2.b), Integer.valueOf(a2.f38564c), a2.e));
            k.this.f38566c.a(a2, false);
            this.f38575a = true;
        }
    }

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f a(j.a aVar) {
        f fVar = new f(null);
        fVar.f38571a = aVar.f38563a;
        fVar.b = aVar.b;
        fVar.f38572c = aVar.f38564c;
        fVar.h = aVar.e;
        fVar.g = aVar.d;
        fVar.e = 4;
        return fVar;
    }

    private void a(int i2, int i3) {
        Iterator<e> it = this.h.iterator();
        while (it.hasNext()) {
            com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Notify listener [%d:%d]", Integer.valueOf(i2), Integer.valueOf(i3)));
            it.next().a(i2, i3);
        }
    }

    private void a(f fVar) {
        this.b.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, String str, String str2) {
        e(fVar);
        if (fVar.e == 4) {
            String str3 = fVar.h;
            if (str3 != null && !str3.equals(str2)) {
                com.tencent.qmsp.sdk.f.d.a(fVar.h, false);
                fVar.h = str2;
            }
            String str4 = fVar.g;
            if (str4 != null && !str4.equals(str)) {
                fVar.g = str;
            }
            fVar.f = 0;
            d(fVar);
            a(fVar);
        }
    }

    private void a(List<j.a> list) {
        for (j.a aVar : list) {
            this.f38566c.a(aVar.f38563a, false);
            String str = aVar.e;
            if (str != null) {
                com.tencent.qmsp.sdk.f.d.a(str, false);
            }
        }
        this.f38566c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i2) {
        return com.tencent.qmsp.sdk.f.h.a(i[i2]);
    }

    private void b(f fVar) {
        try {
            com.tencent.qmsp.sdk.a.g gVar = new com.tencent.qmsp.sdk.a.g();
            gVar.a(fVar.f38571a).a(fVar.g).a(fVar.d);
            com.tencent.qmsp.sdk.a.f.a(gVar.toString(), 3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<Pair<Integer, Integer>> list) {
        if (list == null || !this.f) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (Pair<Integer, Integer> pair : list) {
            com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("cb changed: id(%d), cb(%d)", pair.first, pair.second));
            f fVar = this.f38565a.get(pair.first);
            if (fVar == null) {
                j.a a2 = this.f38566c.a(pair.first.intValue());
                if (a2 != null) {
                    if (pair.second.intValue() == 1) {
                        c(a(a2));
                    } else if (pair.second.intValue() == 2) {
                        linkedList.add(a2);
                    }
                }
            } else if (pair.second.intValue() == 1) {
                if (fVar.e == 4) {
                    d(fVar);
                    if (fVar.d != 0) {
                        this.f38565a.remove(Integer.valueOf(fVar.f38571a));
                    }
                    a(fVar);
                }
            } else if (pair.second.intValue() == 2 && fVar.e == 4) {
                this.f38565a.remove(pair.first);
                j.a a3 = this.f38566c.a(pair.first.intValue());
                if (a3 != null) {
                    linkedList.add(a3);
                }
            }
        }
        if (linkedList.isEmpty()) {
            return;
        }
        a(linkedList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e eVar) {
        for (Map.Entry<Integer, f> entry : this.f38565a.entrySet()) {
            if (entry.getValue().e == 1) {
                com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Notify listener [%d:%d]", 1, entry.getKey()));
                eVar.a(1, entry.getKey().intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        d(fVar);
        if (fVar.d == 0) {
            this.f38565a.put(Integer.valueOf(fVar.f38571a), fVar);
            a(1, fVar.f38571a);
        }
        a(fVar);
    }

    private void d() {
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, "addLostUpgradeLibs");
        new h(new i(this, null)).a(1);
    }

    private void d(f fVar) {
        fVar.e = 2;
        b bVar = new b(this);
        bVar.f38568a = fVar;
        int i2 = 1;
        new com.tencent.qmsp.sdk.c.a(String.format("Lib%d_%s", Integer.valueOf(fVar.f38571a), fVar.g), 43200000L).a(bVar);
        String str = fVar.h;
        String str2 = str;
        if (str == null) {
            str2 = com.igexin.push.core.b.l;
        }
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("load: %s ver: %s error: %08X", str2, com.tencent.qmsp.sdk.a.c.a(fVar.f), Integer.valueOf(fVar.d)));
        if (fVar.d != 0) {
            i2 = 4;
        }
        fVar.e = i2;
    }

    public static k e() {
        if (j == null) {
            synchronized (k.class) {
                try {
                    if (j == null) {
                        j = new k();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return j;
    }

    private void e(f fVar) {
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Prepare to unload: %d,%d,%d,%d,%s,%s", Integer.valueOf(fVar.f38571a), Integer.valueOf(fVar.b), Integer.valueOf(fVar.f38572c), Integer.valueOf(fVar.e), fVar.g, fVar.h));
        if ((fVar.f38572c & 1) != 0 && fVar.e == 1) {
            fVar.e = 3;
            fVar.i.c();
            int a2 = com.tencent.qmsp.sdk.c.f.a(3L, fVar.f38571a, 0L, 0L, null, null, null, null);
            com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Unload ret: %d", Integer.valueOf(a2)));
            if (a2 == 0) {
                fVar.e = 4;
                a(2, fVar.f38571a);
                return;
            }
            fVar.e = 5;
            fVar.d = a2;
        }
    }

    private void f() {
        List<j.a> b2 = this.f38566c.b();
        if (b2 == null || b2.isEmpty()) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (j.a aVar : b2) {
            int a2 = this.d.a(aVar.f38563a);
            int i2 = aVar.f38563a;
            int i3 = aVar.b;
            int i4 = aVar.f38564c;
            String str = aVar.d;
            String str2 = aVar.e;
            String str3 = str2;
            if (str2 == null) {
                str3 = com.igexin.push.core.b.l;
            }
            com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("%d,%d,%d,%s,%s,%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str3, Integer.valueOf(a2)));
            if (a2 != 0 && -1 != a2) {
                if (2 == a2) {
                    linkedList.add(aVar);
                } else if (1 == a2) {
                    f a3 = a(aVar);
                    c(a3);
                    a(a3);
                }
                if (!linkedList.isEmpty()) {
                    a(linkedList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.f) {
            this.g = true;
            return;
        }
        this.g = false;
        new h(new c()).a(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, "onLoadLocalLibs");
        if (this.f) {
            return;
        }
        this.f = true;
        d();
        f();
        if (this.g) {
            b();
        }
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Context context;
        long j2;
        long j3;
        String uid;
        String uid2;
        context = com.tencent.qmsp.sdk.app.a.getContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences(com.tencent.qmsp.sdk.c.b.f38547a + b(6), 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        try {
            Iterator<f> it = this.b.iterator();
            j2 = 28800000;
            while (true) {
                j3 = j2;
                try {
                    if (!it.hasNext()) {
                        break;
                    }
                    f next = it.next();
                    String str = next.g;
                    if (next.f != 0) {
                        str = com.tencent.qmsp.sdk.a.c.a(next.f);
                    }
                    uid = com.tencent.qmsp.sdk.app.a.getUid();
                    String format = String.format("Lib%d_%s_%s", Integer.valueOf(next.f38571a), uid, str);
                    uid2 = com.tencent.qmsp.sdk.app.a.getUid();
                    String format2 = String.format("Lib%d_%s_%s_lpt", Integer.valueOf(next.f38571a), uid2, str);
                    int i2 = sharedPreferences.getInt(format, -1);
                    long currentTimeMillis = System.currentTimeMillis() - sharedPreferences.getLong(format2, 0L);
                    if (currentTimeMillis >= 28800000 || next.d != i2) {
                        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Rp: %d,%d,%s", Integer.valueOf(next.f38571a), Integer.valueOf(next.d), str));
                        edit.putInt(format, next.d);
                        edit.putLong(format2, System.currentTimeMillis());
                        b(next);
                        this.b.remove(next);
                    } else {
                        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Ignore rp for: %d,%08X,%s", Integer.valueOf(next.f38571a), Integer.valueOf(next.d), str));
                        long j4 = 28800000 - currentTimeMillis;
                        if (j2 > j4) {
                            j2 = j4;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    j3 = j2;
                    edit.commit();
                    com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, "next rp interval: " + j3);
                    com.tencent.qmsp.sdk.c.f.i().c().postDelayed(new d(), j3);
                }
            }
        } catch (Exception e3) {
            e = e3;
            j2 = 28800000;
        }
        edit.commit();
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, "next rp interval: " + j3);
        com.tencent.qmsp.sdk.c.f.i().c().postDelayed(new d(), j3);
    }

    private void j() {
        Handler handler = this.e;
        handler.sendMessage(handler.obtainMessage(4));
    }

    public int a(int i2, int i3, int i4, Object[] objArr, Object[] objArr2) {
        int i5;
        f fVar = this.f38565a.get(Integer.valueOf(i2));
        if (fVar == null) {
            i5 = this.f38566c.a(i2) == null ? 4 : 17;
        } else if (i3 != 0 && i3 != fVar.f) {
            i5 = 32;
        } else if (fVar.f38571a != i2) {
            i5 = 5;
        } else {
            int a2 = this.d.a(i2);
            if (1 != a2 && a2 != -1) {
                i5 = 6;
            } else if (fVar.e == 1 && fVar.i.a()) {
                i5 = com.tencent.qmsp.sdk.c.f.a(4L, fVar.f38571a, i3, i4, null, null, objArr, objArr2);
                fVar.i.b();
            } else {
                i5 = 7;
            }
        }
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("dispatch to id: %d, cmd: %d, err: %d", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5)));
        return i5;
    }

    public void a() {
        try {
            if (this.f38565a != null) {
                for (Map.Entry<Integer, f> entry : this.f38565a.entrySet()) {
                    entry.getValue().f38572c = 1;
                    e(entry.getValue());
                }
            }
            if (j != null) {
                j = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(com.tencent.qmsp.sdk.c.g gVar) {
        this.d = gVar;
        gVar.a(new a());
    }

    public void a(e eVar) {
        this.h.add(eVar);
        Handler handler = this.e;
        handler.sendMessage(handler.obtainMessage(5, eVar));
    }

    public void b() {
        Handler handler = this.e;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public void b(e eVar) {
        this.h.remove(eVar);
    }

    public void c() {
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("OnEveryLogin mHasLoadLocal = %b", Boolean.valueOf(this.f)));
        if (this.f) {
            return;
        }
        Handler handler = this.e;
        handler.sendMessage(handler.obtainMessage(3));
    }
}
