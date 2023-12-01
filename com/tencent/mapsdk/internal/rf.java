package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.mapsdk.core.components.protocol.jce.conf.CSFileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateRsp;
import com.tencent.mapsdk.vector.VectorMap;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/rf.class */
public class rf {
    private static volatile Map<String, List<WeakReference<h1>>> k = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f37751a = false;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private ic f37752c;
    private mc d;
    private WeakReference<h1> e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/rf$a.class */
    public static class a implements Runnable {
        private final WeakReference<rf> b;

        /* renamed from: c  reason: collision with root package name */
        private final String f37753c;
        private final s5 d;

        public a(rf rfVar, String str, s5 s5Var) {
            this.b = new WeakReference<>(rfVar);
            this.f37753c = str;
            this.d = s5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<rf> weakReference = this.b;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            rf rfVar = this.b.get();
            List<FileUpdateRsp> b = rfVar.b(this.f37753c, this.d);
            if (b == null) {
                rfVar.f37751a = false;
                rfVar.a(false);
                return;
            }
            if (rfVar.f37751a) {
                if (!rfVar.a(rfVar.i, rfVar.g) || !rfVar.a(rfVar.j, rfVar.h)) {
                    rfVar.f37751a = false;
                    rfVar.a(false);
                    return;
                }
                for (int i = 0; i < b.size(); i++) {
                    rfVar.a(b.get(i));
                }
            }
            rfVar.a(true);
        }
    }

    public rf(Context context, h1 h1Var, String str) {
        this.d = mc.b(context);
        this.b = "";
        if (h1Var != null && h1Var.l() != null && h1Var.l().getMap() != null) {
            this.b = h1Var.l().getMap().y();
        }
        this.e = new WeakReference<>(h1Var);
        this.f = str;
        this.f37752c = kc.a(context, str);
        a();
    }

    private void a() {
        ic icVar = this.f37752c;
        if (icVar == null) {
            return;
        }
        icVar.a(new String[]{"mapPoiIconIndoorVersion", "poiIconIndoorMd5"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e0, code lost:
        if (r0.equals(com.tencent.mapsdk.internal.k4.m) == false) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateRsp r5) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.rf.a(com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateRsp):void");
    }

    private void a(String str, WeakReference<h1> weakReference) {
        synchronized (this) {
            if (k.containsKey(str)) {
                List<WeakReference<h1>> list = k.get(str);
                if (list != null) {
                    list.add(weakReference);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(weakReference);
                k.put(str, arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        h1 h1Var;
        yi l;
        this.f37752c.a(m4.b, System.currentTimeMillis());
        ha.a(this.i);
        ha.a(this.j);
        long currentTimeMillis = System.currentTimeMillis();
        if (!z) {
            currentTimeMillis = 0;
        }
        List<WeakReference<h1>> list = k.get(b());
        if (list == null) {
            return;
        }
        int size = list.size();
        WeakReference[] weakReferenceArr = (WeakReference[]) list.toArray(new WeakReference[size]);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                k.clear();
                kc.c();
                ra.i(qa.V);
                return;
            }
            if (weakReferenceArr[i2] != null && (h1Var = (h1) weakReferenceArr[i2].get()) != null && (l = h1Var.l()) != null && l.getMap() != null) {
                VectorMap map = l.getMap();
                w6 w = l.A().w();
                if (this.f37751a) {
                    map.t0();
                    if (h1Var.m() != null) {
                        h1Var.m().a(l.getMapContext());
                    }
                    map.v0();
                    l.b(1);
                    l.l(true);
                    if (w != null) {
                        w.l().b(false, currentTimeMillis);
                        w.l().a(z, currentTimeMillis);
                    }
                } else if (!z && w != null) {
                    w.l().a(z, currentTimeMillis);
                }
                map.c(true);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2) {
        h1 h1Var;
        FileInputStream fileInputStream;
        boolean z;
        byte[] bArr;
        boolean b;
        WeakReference<h1> weakReference = this.e;
        if (weakReference == null || (h1Var = weakReference.get()) == null || h1Var.l() == null || h1Var.l().getMap() == null) {
            return false;
        }
        VectorMap map = h1Var.l().getMap();
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            na.b("Config temp dir not exists:" + str);
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        FileInputStream fileInputStream2 = null;
        int length = listFiles.length;
        boolean z2 = true;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return z2;
            }
            File file2 = listFiles[i2];
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (FileNotFoundException | IOException e) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                int length2 = (int) file2.length();
                bArr = new byte[length2];
                fileInputStream.read(bArr, 0, length2);
            } catch (FileNotFoundException | IOException e2) {
                z = z2;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                ha.a((Closeable) fileInputStream2);
                throw th;
            }
            if (str2.equals(this.g)) {
                b = map.a(file2.getName(), bArr);
            } else {
                z = z2;
                if (str2.equals(this.h)) {
                    b = map.b(file2.getName(), bArr);
                }
                fileInputStream2 = fileInputStream;
                z2 = z;
                ha.a((Closeable) fileInputStream2);
                i = i2 + 1;
            }
            z = b & z2;
            fileInputStream2 = fileInputStream;
            z2 = z;
            ha.a((Closeable) fileInputStream2);
            i = i2 + 1;
        }
    }

    private String b() {
        String str = this.f;
        String str2 = str;
        if (f7.b(str)) {
            str2 = c7.t();
        }
        return str2;
    }

    public void a(String str, s5 s5Var) {
        String b = b();
        if (k.containsKey(b)) {
            a(b, this.e);
            return;
        }
        a(b, this.e);
        ra.h(qa.V);
        ca.a(new a(this, str, s5Var));
    }

    public List<FileUpdateRsp> b(String str, s5 s5Var) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FileUpdateReq(k4.i, this.f37752c.b(m4.f37627a), this.f37752c.d(m4.t)));
        arrayList.add(new FileUpdateReq("poi_icon", this.f37752c.b(m4.f37628c), this.f37752c.d(m4.u)));
        arrayList.add(new FileUpdateReq(k4.j, this.f37752c.b(m4.d), this.f37752c.d(m4.v)));
        arrayList.add(new FileUpdateReq(k4.p, this.f37752c.b("escalator_night_version"), this.f37752c.d("escalator_night_md5")));
        if (s5Var != null && s5Var.e()) {
            arrayList.add(new FileUpdateReq(k4.l, this.f37752c.b("indoormap_style_version"), this.f37752c.d("indoormap_style_md5")));
            arrayList.add(new FileUpdateReq(k4.m, this.f37752c.b("indoormap_style_night_version"), this.f37752c.d("indoormap_style_night_md5")));
            arrayList.add(new FileUpdateReq(k4.n, this.f37752c.b(m4.s), this.f37752c.d(m4.y)));
            arrayList.add(new FileUpdateReq(k4.o, this.f37752c.b("indoorpoi_icon_3d_night_version"), this.f37752c.d("indoorpoi_icon_3d_night_md5")));
        }
        String b = b();
        CSFileUpdateReq cSFileUpdateReq = new CSFileUpdateReq(arrayList, b, c7.E(), null, this.b, str);
        this.g = this.d.c(this.f);
        this.h = this.d.a(this.f);
        this.i = this.d.d(this.f) + "config/";
        this.j = this.d.d(this.f) + "assets/";
        ha.b(this.i);
        ha.b(this.j);
        return new pf().a(this.d.d(this.f) + "config/", this.d.d(this.f) + "assets/", b, cSFileUpdateReq, this);
    }

    public WeakReference<h1>[] c() {
        List<WeakReference<h1>> list = k.get(b());
        if (list == null) {
            return null;
        }
        return (WeakReference[]) list.toArray(new WeakReference[list.size()]);
    }
}
