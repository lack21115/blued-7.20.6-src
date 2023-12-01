package c.t.m.g;

import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import c.t.m.g.j3;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/g.class */
public class g extends c2 {
    public final File f;
    public volatile long n;
    public volatile int o;
    public volatile int p;
    public volatile int q;
    public volatile float r;
    public volatile float s;
    public final StringBuilder e = new StringBuilder();
    public volatile long g = 0;
    public volatile long h = 0;
    public final long[] i = new long[2];
    public final int[] j = new int[2];
    public ArrayList<Float> k = new ArrayList<>();
    public ArrayList<Float> l = new ArrayList<>();
    public HashSet<Integer> m = new HashSet<>();
    public AtomicBoolean t = new AtomicBoolean(false);

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/g$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.t.get()) {
                return;
            }
            g.this.t.set(true);
            try {
                g.this.l();
            } catch (Throwable th) {
            }
            g.this.t.set(false);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/g$b.class */
    public class b implements t1 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f3766a;

        public b(g gVar, File file) {
            this.f3766a = file;
        }

        @Override // c.t.m.g.t1
        public void a(String str) {
            g3.a();
        }

        @Override // c.t.m.g.t1
        public void b(String str) {
            g3.a();
            this.f3766a.delete();
        }
    }

    public g(File file) {
        this.f = file;
    }

    public final float a(List<Float> list) {
        int size = list.size();
        if (size == 0) {
            return 0.0f;
        }
        if (size % 2 == 0) {
            int i = size / 2;
            return (list.get(i - 1).floatValue() + list.get(i).floatValue()) / 2.0f;
        }
        return list.get((size - 1) / 2).floatValue();
    }

    @Override // c.t.m.g.f2
    public int a(Looper looper) {
        this.n = 0L;
        this.q = -1;
        this.p = -1;
        a(1001, 0L);
        return 0;
    }

    @Override // c.t.m.g.f2
    public String a() {
        return "UserTrackPro";
    }

    public void a(int i, long j, Object obj) {
        int i2;
        Iterator<GpsSatellite> it;
        int i3;
        if (obj == null) {
            return;
        }
        synchronized (this.b) {
            this.k.clear();
            this.l.clear();
            this.m.clear();
            int i4 = 0;
            if (i == 1) {
                Iterable<GpsSatellite> satellites = ((GpsStatus) obj).getSatellites();
                if (satellites == null) {
                    it = null;
                    i3 = 0;
                } else {
                    it = satellites.iterator();
                    i3 = 0;
                }
                while (true) {
                    i2 = i3;
                    if (it == null) {
                        break;
                    }
                    i2 = i3;
                    if (!it.hasNext()) {
                        break;
                    }
                    GpsSatellite next = it.next();
                    float snr = next.getSnr();
                    if (next.usedInFix()) {
                        this.l.add(Float.valueOf(snr));
                    }
                    int i5 = i3 + 1;
                    i3 = i5;
                    if (!k3.a(snr, 0.0f)) {
                        this.k.add(Float.valueOf(snr));
                        i3 = i5;
                    }
                }
            } else {
                i2 = 0;
                if (i == 2) {
                    i2 = 0;
                    if (Build.VERSION.SDK_INT >= 24) {
                        GnssStatus gnssStatus = (GnssStatus) obj;
                        int i6 = 0;
                        while (true) {
                            int i7 = i6;
                            i2 = i7;
                            if (i4 >= gnssStatus.getSatelliteCount()) {
                                break;
                            }
                            i2 = i7;
                            try {
                                int svid = gnssStatus.getSvid(i4) + (gnssStatus.getConstellationType(i4) * 1000);
                                int i8 = i7;
                                if (!this.m.contains(Integer.valueOf(svid))) {
                                    this.m.add(Integer.valueOf(svid));
                                    float cn0DbHz = gnssStatus.getCn0DbHz(i4);
                                    if (gnssStatus.usedInFix(i4)) {
                                        this.l.add(Float.valueOf(cn0DbHz));
                                    }
                                    int i9 = i7 + 1;
                                    i8 = i9;
                                    if (!k3.a(cn0DbHz, 0.0f)) {
                                        this.k.add(Float.valueOf(cn0DbHz));
                                        i8 = i9;
                                    }
                                }
                                i4++;
                                i6 = i8;
                            } catch (Throwable th) {
                            }
                        }
                    }
                }
            }
            Collections.sort(this.k);
            Collections.sort(this.l);
            this.n = j;
            this.o = i2;
            this.p = this.k.size();
            this.q = this.l.size();
            this.r = a(this.k);
            this.s = a(this.l);
        }
    }

    public void a(int i, Location location) {
        String format;
        synchronized (this.b) {
            if (b()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.i[0] < 900) {
                    return;
                }
                this.i[0] = currentTimeMillis;
                int[] iArr = this.j;
                iArr[0] = iArr[0] + 1;
                if (location != null && "gps".equals(location.getProvider())) {
                    if (j.h || Build.VERSION.SDK_INT < 18 || !location.isFromMockProvider()) {
                        if (currentTimeMillis - this.n > 2000) {
                            format = String.format(Locale.ENGLISH, "%d,G,%d,%d,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,-1,-1,0,-1,0", Long.valueOf(currentTimeMillis), Long.valueOf(location.getTime()), Integer.valueOf(i), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getSpeed()), Float.valueOf(location.getBearing()));
                        } else {
                            format = String.format(Locale.ENGLISH, "%d,G,%d,%d,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,%d,%d,%.2f,%d,%.2f", Long.valueOf(currentTimeMillis), Long.valueOf(location.getTime()), Integer.valueOf(i), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getSpeed()), Float.valueOf(location.getBearing()), Integer.valueOf(this.o), Integer.valueOf(this.p), Float.valueOf(this.r), Integer.valueOf(this.q), Float.valueOf(this.s));
                        }
                        c3.b(d(), 1003, 0, 0, format);
                    }
                }
            }
        }
    }

    public void a(long j, int i, double d, double d2, double d3) {
    }

    @Override // c.t.m.g.c2
    public void a(Message message) throws Exception {
        switch (message.what) {
            case 1001:
                k();
                this.g = System.currentTimeMillis() - 40000;
                a(1004, 300000L);
                return;
            case 1002:
                c3.b(d());
                int[] iArr = this.j;
                if (iArr[0] + iArr[1] >= 3) {
                    b(this.e.toString());
                }
                k();
                h();
                return;
            case 1003:
                a((String) message.obj);
                return;
            case 1004:
                a(1004, 1800000L);
                h();
                return;
            default:
                return;
        }
    }

    public final void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.e.length() == 0) {
            this.e.append(i());
            this.h = currentTimeMillis;
        }
        StringBuilder sb = this.e;
        sb.append('$');
        sb.append(str);
        if (this.e.length() >= 15360 || (this.h != 0 && currentTimeMillis - this.h >= 600000)) {
            int[] iArr = this.j;
            if (iArr[0] + iArr[1] >= 3) {
                b(this.e.toString());
            }
            this.e.setLength(0);
            Arrays.fill(this.j, 0);
        }
    }

    public final void b(String str) {
        if (m3.a(str)) {
            return;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            byte[] a2 = l.a(bytes, 3);
            if (g3.a()) {
                int length = bytes.length;
                int length2 = a2.length;
            }
            File file = new File(this.f, "utr_" + i3.a(e.class.getName(), "SHA-256").substring(0, 8) + "_" + t2.a("yyyyMMdd"));
            z2.a(file, a2, true);
            if (file.length() > 51200) {
                String parent = file.getParent();
                file.renameTo(new File(parent, file.getName() + "_" + t2.a("HHmmss")));
            }
        } catch (Throwable th) {
            g3.a();
        }
    }

    @Override // c.t.m.g.f2
    public void c() {
        a(1002, 0L);
        this.k.clear();
        this.l.clear();
        this.m.clear();
    }

    public void c(long j) {
        long j2 = j;
        if (j < 0) {
            j2 = 0;
        }
        a(1004, j2);
    }

    public final void h() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.g < 60000) {
            g3.a();
            return;
        }
        this.g = currentTimeMillis;
        j3.a b2 = j3.b();
        if (b2 == j3.a.NETWORK_NONE) {
            z = false;
        } else {
            z = true;
            if (b2 == j3.a.NETWORK_MOBILE) {
                z = j.f;
                if (!z && j.g && currentTimeMillis - ((Long) p3.a("LocationSDK", "log_utr_up_in_m", Long.valueOf(currentTimeMillis))).longValue() > 86400000) {
                    p3.b("LocationSDK", "log_utr_up_in_m", Long.valueOf(currentTimeMillis));
                    g3.a();
                    z = true;
                }
            }
        }
        if (z) {
            a3.a("th_loc_task_t_consume", new a());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x009c, code lost:
        if ("0123456789ABCDEF".equals(r0) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String i() {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.g.i():java.lang.String");
    }

    public final String j() {
        String str = j.h ? "https://testdatalbs.sparta.html5.qq.com/tr?utr" : "https://analytics.map.qq.com/tr?utr";
        String str2 = str;
        if (!j.e) {
            str2 = str.replace("https:", "http:");
        }
        return str2;
    }

    public final void k() {
        this.h = System.currentTimeMillis();
        this.e.setLength(0);
        Arrays.fill(this.j, 0);
        Arrays.fill(this.i, 0L);
    }

    public final void l() {
        File file = this.f;
        File[] listFiles = (file == null || !file.exists()) ? null : this.f.listFiles();
        if (m3.c(listFiles)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        j3.a b2 = j3.b();
        String a2 = t2.a("yyyyMMdd");
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= listFiles.length) {
                return;
            }
            File file2 = listFiles[i];
            String name = file2.getName();
            int i4 = i3;
            if (file2.exists()) {
                i4 = i3;
                if (file2.isFile()) {
                    i4 = i3;
                    if (!name.startsWith("utr_")) {
                        continue;
                    } else if (name.contains(a2)) {
                        i4 = i3;
                    } else if (currentTimeMillis - file2.lastModified() > 1296000000) {
                        if (g3.a()) {
                            file2.getName();
                        }
                        file2.delete();
                        i4 = i3;
                    } else {
                        byte[] b3 = z2.b(file2);
                        int length = i3 + b3.length;
                        if (g3.a()) {
                            String str = "upload file:" + file2.getName() + ",len=" + b3.length + ",sum=" + length + ",netType=" + b2;
                        }
                        if (b3.length == 0) {
                            file2.delete();
                            i4 = length;
                        } else {
                            j.k.a(j(), b3, new b(this, file2));
                            if (b2 == j3.a.NETWORK_MOBILE) {
                                return;
                            }
                            i4 = length;
                            if (length >= 512000) {
                                return;
                            }
                        }
                    }
                } else {
                    continue;
                }
            }
            i++;
            i2 = i4;
        }
    }
}
