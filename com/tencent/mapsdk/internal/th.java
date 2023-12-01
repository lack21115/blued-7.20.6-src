package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.internal.ca;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/th.class */
public class th {
    private static ConcurrentHashMap<String, x5[]> g = new ConcurrentHashMap<>();
    private static volatile th h;
    public static final String i = "china";
    public static final String j = "inland";
    public static final String k = "taiwan";
    public static final String l = "outOfChina";
    private static final String m = "124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.959229,21.677848:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666";
    private static final String n = "124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666";
    private static final String o = "121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:121.959229,21.677848";
    private volatile boolean e;

    /* renamed from: a  reason: collision with root package name */
    private ReentrantReadWriteLock f38030a = new ReentrantReadWriteLock();
    private String b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f38031c = null;
    private boolean d = false;
    private AtomicInteger f = new AtomicInteger(0);

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/th$a.class */
    public class a extends ca.i<Boolean> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            th.this.e = true;
            if (th.this.f.getAndIncrement() <= 0) {
                String d = th.this.d();
                if (TextUtils.isEmpty(d)) {
                    th.g.put(th.i, th.b(th.m));
                    th.g.put(th.j, th.b(th.n));
                    th.g.put(th.k, th.b(th.o));
                } else {
                    th.this.d(d);
                }
            }
            th.this.e = false;
            th.this.d = true;
            return Boolean.TRUE;
        }
    }

    private th() {
    }

    public static boolean a(x5 x5Var, x5[] x5VarArr) {
        boolean z;
        if (x5VarArr == null || x5VarArr.length < 3) {
            return false;
        }
        int length = x5VarArr.length - 1;
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            boolean z3 = z2;
            if (i2 >= x5VarArr.length) {
                return z3;
            }
            if (x5VarArr[i2].c() >= x5Var.c() || x5VarArr[length].c() < x5Var.c()) {
                z = z3;
                if (x5VarArr[length].c() < x5Var.c()) {
                    z = z3;
                    if (x5VarArr[i2].c() < x5Var.c()) {
                    }
                }
                length = i2;
                i2++;
                z2 = z;
            }
            if (x5VarArr[i2].b() > x5Var.b()) {
                z = z3;
                if (x5VarArr[length].b() > x5Var.b()) {
                    length = i2;
                    i2++;
                    z2 = z;
                }
            }
            z = z3 ^ (x5VarArr[i2].b() + (((x5Var.c() - x5VarArr[i2].c()) / (x5VarArr[length].c() - x5VarArr[i2].c())) * (x5VarArr[length].b() - x5VarArr[i2].b())) < x5Var.b());
            length = i2;
            i2++;
            z2 = z;
        }
    }

    public static boolean a(x5[] x5VarArr, x5[] x5VarArr2) {
        boolean z;
        int length = x5VarArr.length;
        boolean z2 = false;
        int i2 = 0;
        boolean z3 = false;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            z3 |= a(x5VarArr[i2], x5VarArr2);
            if (z3) {
                z = true;
                break;
            }
            i2++;
        }
        boolean z4 = false;
        boolean z5 = false;
        for (x5 x5Var : x5VarArr2) {
            z4 |= a(x5Var, x5VarArr);
            if (z4) {
                z5 = true;
            }
        }
        return (z || z5) ? true : true;
    }

    public static th b() {
        if (h == null) {
            synchronized (th.class) {
                try {
                    if (h == null) {
                        h = new th();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static x5[] b(String str) {
        x5[] x5VarArr = null;
        if (str != null) {
            if (str.length() != 0) {
                String[] split = str.split(":");
                if (split.length != 0) {
                    x5[] x5VarArr2 = new x5[split.length];
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        x5VarArr = x5VarArr2;
                        if (i3 >= split.length) {
                            break;
                        }
                        String[] split2 = split[i3].split(",");
                        x5VarArr2[i3] = y.b(new GeoPoint((int) (Double.parseDouble(split2[1]) * 1000000.0d), (int) (Double.parseDouble(split2[0]) * 1000000.0d)));
                        i2 = i3 + 1;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return x5VarArr;
    }

    public void a(Context context) {
        if (this.d || this.e) {
            return;
        }
        if (context != null) {
            this.b = context.getFilesDir() + "/frontiers.dat";
            this.f38031c = this.b + ".bak";
        }
        ca.a((ca.i) new a()).b((ca.d.b) Boolean.FALSE);
    }

    public void c() {
        if (this.f.decrementAndGet() == 0) {
            g.clear();
            this.d = false;
        }
    }

    public x5[] c(String str) {
        return g.get(str);
    }

    public int d(String str) {
        int i2 = 0;
        int i3 = 0;
        if (str != null) {
            if (str.length() == 0) {
                return 0;
            }
            int i4 = 0;
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (true) {
                    int i5 = i3;
                    if (!keys.hasNext()) {
                        break;
                    }
                    int i6 = i3;
                    String next = keys.next();
                    int i7 = i3;
                    if ("version".equals(next)) {
                        int i8 = i3;
                        i3 = jSONObject.optInt(next);
                    } else {
                        x5[] b = b(jSONObject.optString(next));
                        if (b != null) {
                            g.put(next, b);
                        }
                    }
                }
                if (!g.containsKey(i)) {
                    int i9 = i3;
                    x5[] b2 = b(m);
                    if (b2 != null) {
                        g.put(i, b2);
                    }
                }
                int i10 = i3;
                if (!g.containsKey(j)) {
                    int i11 = i3;
                    x5[] b3 = b(n);
                    if (b3 != null) {
                        g.put(j, b3);
                    }
                }
                i2 = i3;
                if (!g.containsKey(k)) {
                    int i12 = i3;
                    x5[] b4 = b(o);
                    i2 = i3;
                    if (b4 != null) {
                        i4 = i3;
                        g.put(k, b4);
                        i2 = i3;
                    }
                }
            } catch (Throwable th) {
                return i4;
            }
        }
        return i2;
    }

    public String d() {
        FileInputStream fileInputStream;
        this.f38030a.readLock().lock();
        try {
            fileInputStream = new FileInputStream(new File(this.b));
        } catch (Throwable th) {
            fileInputStream = null;
        }
        try {
            String str = new String(ha.b(fileInputStream), "UTF-8");
            ha.a((Closeable) fileInputStream);
            this.f38030a.readLock().unlock();
            return str;
        } catch (Throwable th2) {
            ha.a((Closeable) fileInputStream);
            this.f38030a.readLock().unlock();
            return null;
        }
    }

    public boolean e(String str) {
        FileOutputStream fileOutputStream;
        this.f38030a.writeLock().lock();
        File file = new File(this.b);
        File file2 = new File(this.f38031c);
        if (file2.exists() && !file2.delete()) {
            file2.deleteOnExit();
            return false;
        }
        try {
            if (file.exists() && !file.renameTo(file2)) {
                ha.a((Closeable) null);
                file2.renameTo(file);
                this.f38030a.writeLock().unlock();
                return false;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(str.getBytes("UTF-8"));
                fileOutputStream2.flush();
                ha.a(fileOutputStream2);
                file2.delete();
                this.f38030a.writeLock().unlock();
                return true;
            } catch (Throwable th) {
                fileOutputStream = fileOutputStream2;
                ha.a(fileOutputStream);
                file2.renameTo(file);
                this.f38030a.writeLock().unlock();
                return false;
            }
        } catch (Throwable th2) {
            fileOutputStream = null;
        }
    }
}
