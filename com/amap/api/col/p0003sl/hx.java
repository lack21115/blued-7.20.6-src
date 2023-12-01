package com.amap.api.col.p0003sl;

import android.content.Context;
import android.util.Log;
import com.android.internal.content.NativeLibraryHelper;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.hx  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hx.class */
public final class hx {
    private static volatile b a = b.Unknow;
    private static volatile d b = d.Unknow;
    private static volatile String c = "";
    private static volatile String d = "";
    private static volatile long e = -1;
    private static volatile a f = a.Unknow;
    private static volatile long g = -1;
    private static volatile String h = "";
    private static volatile String i = "";
    private static volatile long j = 0;
    private static volatile long k = 0;
    private static volatile boolean l = false;
    private static volatile boolean m = true;

    /* renamed from: com.amap.api.col.3sl.hx$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hx$a.class */
    public enum a {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);
        
        private int d;

        a(int i) {
            this.d = i;
        }

        public static a a(int i) {
            return i == NotAgree.a() ? NotAgree : i == DidAgree.a() ? DidAgree : Unknow;
        }

        public final int a() {
            return this.d;
        }
    }

    /* renamed from: com.amap.api.col.3sl.hx$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hx$b.class */
    public enum b {
        Unknow(-1),
        NotContain(0),
        DidContain(1);
        
        private int d;

        b(int i) {
            this.d = i;
        }

        public static b a(int i) {
            return i == NotContain.a() ? NotContain : i == DidContain.a() ? DidContain : Unknow;
        }

        public final int a() {
            return this.d;
        }
    }

    /* renamed from: com.amap.api.col.3sl.hx$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hx$c.class */
    public enum c {
        SuccessCode(0),
        ShowUnknowCode(555570),
        ShowNoShowCode(555571),
        InfoUnknowCode(555572),
        InfoNotContainCode(555573),
        AgreeUnknowCode(555574),
        AgreeNotAgreeCode(555575),
        InvaildUserKeyCode(10001),
        IllegalArgument(20001);
        
        private final int j;

        c(int i) {
            this.j = i;
        }

        public final int a() {
            return this.j;
        }
    }

    /* renamed from: com.amap.api.col.3sl.hx$d */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hx$d.class */
    public enum d {
        Unknow(-1),
        NotShow(0),
        DidShow(1);
        
        private int d;

        d(int i) {
            this.d = i;
        }

        public static d a(int i) {
            return i == NotShow.a() ? NotShow : i == DidShow.a() ? DidShow : Unknow;
        }

        public final int a() {
            return this.d;
        }
    }

    public static hy a(final Context context, ia iaVar) {
        boolean z;
        synchronized (hx.class) {
            hy hyVar = null;
            try {
                if (context == null || iaVar == null) {
                    return new hy(c.IllegalArgument, iaVar);
                }
                if (!l) {
                    e(context);
                    l = true;
                }
                if (b != d.DidShow) {
                    if (b == d.Unknow) {
                        hyVar = new hy(c.ShowUnknowCode, iaVar);
                    } else {
                        hyVar = null;
                        if (b == d.NotShow) {
                            hyVar = new hy(c.ShowNoShowCode, iaVar);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                }
                hy hyVar2 = hyVar;
                boolean z2 = z;
                if (z) {
                    hyVar2 = hyVar;
                    z2 = z;
                    if (a != b.DidContain) {
                        if (a == b.Unknow) {
                            hyVar2 = new hy(c.InfoUnknowCode, iaVar);
                        } else {
                            hyVar2 = hyVar;
                            if (a == b.NotContain) {
                                hyVar2 = new hy(c.InfoNotContainCode, iaVar);
                            }
                        }
                        z2 = false;
                    }
                }
                hy hyVar3 = hyVar2;
                boolean z3 = z2;
                if (z2) {
                    hyVar3 = hyVar2;
                    z3 = z2;
                    if (f != a.DidAgree) {
                        if (f == a.Unknow) {
                            hyVar2 = new hy(c.AgreeUnknowCode, iaVar);
                        } else if (f == a.NotAgree) {
                            hyVar2 = new hy(c.AgreeNotAgreeCode, iaVar);
                        }
                        z3 = false;
                        hyVar3 = hyVar2;
                    }
                }
                if (k != j) {
                    final long j2 = j;
                    k = j;
                    try {
                        final JSONObject jSONObject = new JSONObject();
                        jSONObject.put("privacyInfo", a.a());
                        jSONObject.put("privacyShow", b.a());
                        jSONObject.put("showTime", e);
                        jSONObject.put("show2SDK", c);
                        jSONObject.put("show2SDKVer", d);
                        jSONObject.put("privacyAgree", f.a());
                        jSONObject.put("agreeTime", g);
                        jSONObject.put("agree2SDK", h);
                        jSONObject.put("agree2SDKVer", i);
                        final boolean z4 = m;
                        lb.a().a(new lc() { // from class: com.amap.api.col.3sl.hx.2
                            @Override // com.amap.api.col.p0003sl.lc
                            public final void runTask() {
                                if (z4) {
                                    Iterator it = hx.b(hx.f(context)).iterator();
                                    while (it.hasNext()) {
                                        hx.a(context, ((File) it.next()).getName());
                                    }
                                }
                                hx.d(context);
                                hx.a(context, jSONObject, j2);
                                boolean b2 = hx.b(context, jSONObject);
                                if (b2) {
                                    hx.b(context, hx.b(j2));
                                }
                                if (z4) {
                                    hx.b(context);
                                }
                                if (b2) {
                                    return;
                                }
                                hx.a(context, hx.b(j2));
                            }
                        });
                    } catch (Throwable th) {
                    }
                } else if (m) {
                    lb.a().a(new lc() { // from class: com.amap.api.col.3sl.hx.1
                        @Override // com.amap.api.col.p0003sl.lc
                        public final void runTask() {
                            Iterator it = hx.b(hx.f(context)).iterator();
                            while (it.hasNext()) {
                                hx.a(context, ((File) it.next()).getName());
                            }
                            hx.b(context);
                        }
                    });
                }
                m = false;
                String f2 = ho.f(context);
                if (f2 == null || f2.length() <= 0) {
                    hyVar3 = new hy(c.InvaildUserKeyCode, iaVar);
                    Log.e(iaVar.a(), String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(hyVar3.a.a()), hyVar3.b));
                }
                if (z3) {
                    hyVar3 = new hy(c.SuccessCode, iaVar);
                } else {
                    Log.e(iaVar.a(), String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(hyVar3.a.a()), hyVar3.b));
                }
                return hyVar3;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void a(Context context, a aVar, ia iaVar) {
        synchronized (hx.class) {
            if (context == null || iaVar == null) {
                return;
            }
            try {
                if (!l) {
                    e(context);
                    l = true;
                }
                Boolean bool = Boolean.FALSE;
                if (aVar != f) {
                    Boolean bool2 = Boolean.TRUE;
                    f = aVar;
                    h = iaVar.a();
                    i = iaVar.b();
                    long currentTimeMillis = System.currentTimeMillis();
                    g = currentTimeMillis;
                    j = currentTimeMillis;
                    d(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void a(Context context, d dVar, b bVar, ia iaVar) {
        synchronized (hx.class) {
            if (context == null || iaVar == null) {
                return;
            }
            try {
                if (!l) {
                    e(context);
                    l = true;
                }
                Boolean bool = Boolean.FALSE;
                if (dVar != b) {
                    bool = Boolean.TRUE;
                    b = dVar;
                }
                if (bVar != a) {
                    bool = Boolean.TRUE;
                    a = bVar;
                }
                if (bool.booleanValue()) {
                    c = iaVar.a();
                    d = iaVar.b();
                    long currentTimeMillis = System.currentTimeMillis();
                    e = currentTimeMillis;
                    j = currentTimeMillis;
                    d(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* synthetic */ void a(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            String f2 = f(context);
            File file = new File(f2 + BridgeUtil.SPLIT_MARK + str);
            if (file.exists()) {
                String g2 = g(context);
                File file2 = new File(g2 + BridgeUtil.SPLIT_MARK + str);
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                file.renameTo(file2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static /* synthetic */ void a(Context context, JSONObject jSONObject, long j2) {
        FileOutputStream fileOutputStream;
        byte[] a2;
        try {
            a2 = jj.a(context, jSONObject.toString().getBytes());
            String b2 = b(j2);
            File file = new File(f(context) + BridgeUtil.SPLIT_MARK + b2);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(a2);
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                th.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            } catch (Throwable th5) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
                throw th5;
            }
        }
    }

    public static void a(Context context, boolean z, ia iaVar) {
        a(context, z ? a.DidAgree : a.NotAgree, iaVar);
    }

    public static void a(Context context, boolean z, boolean z2, ia iaVar) {
        a(context, z2 ? d.DidShow : d.NotShow, z ? b.DidContain : b.NotContain, iaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(long j2) {
        return String.format("%d-%s", Long.valueOf(j2), "privacy.data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<File> b(String str) {
        ArrayList<File> arrayList = new ArrayList<>();
        if (str != null) {
            if (str.length() != 0) {
                File file = new File(str);
                if (!file.exists()) {
                    return arrayList;
                }
                File[] listFiles = file.listFiles();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= listFiles.length) {
                        break;
                    }
                    File file2 = listFiles[i3];
                    if (file2.isFile()) {
                        arrayList.add(file2);
                    }
                    i2 = i3 + 1;
                }
            } else {
                return arrayList;
            }
        }
        return arrayList;
    }

    static /* synthetic */ void b(Context context) {
        try {
            Iterator<File> it = b(g(context)).iterator();
            while (it.hasNext()) {
                File next = it.next();
                String name = next.getName();
                if (name.endsWith("-privacy.data")) {
                    String[] split = name.split(NativeLibraryHelper.CLEAR_ABI_OVERRIDE);
                    if (split == null && split.length != 2) {
                        next.delete();
                    } else if (Long.parseLong(split[0]) <= 0) {
                        next.delete();
                    } else {
                        FileInputStream fileInputStream = new FileInputStream(next);
                        byte[] bArr = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr);
                        if (b(context, new JSONObject(new String(jj.b(context, bArr))))) {
                            next.delete();
                        }
                    }
                } else {
                    next.delete();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static /* synthetic */ void b(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            String f2 = f(context);
            File file = new File(f2 + BridgeUtil.SPLIT_MARK + str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, JSONObject jSONObject) {
        try {
            iy iyVar = new iy();
            iyVar.b = context;
            iyVar.a = jSONObject;
            new ju();
            kc a2 = ju.a(iyVar);
            if (a2 != null) {
                JSONObject jSONObject2 = new JSONObject(ib.a(a2.a));
                if (jSONObject2.has("status")) {
                    return jSONObject2.getInt("status") == 1;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context) {
        synchronized (hx.class) {
            if (context == null) {
                return;
            }
            try {
                if (!l) {
                    e(context);
                    l = true;
                }
                jj.a(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(a.a()), Integer.valueOf(b.a()), Long.valueOf(e), c, d, Integer.valueOf(f.a()), Long.valueOf(g), h, i, Long.valueOf(j), Long.valueOf(k)));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void e(Context context) {
        String str;
        if (context == null) {
            return;
        }
        try {
            str = jj.a(context, "AMap.privacy.data", "AMap.privacy.data");
        } catch (Throwable th) {
            th.printStackTrace();
            str = null;
        }
        if (str == null) {
            return;
        }
        String[] split = str.split(com.alipay.sdk.sys.a.b);
        if (split.length != 11) {
            return;
        }
        try {
            a = b.a(Integer.parseInt(split[0]));
            b = d.a(Integer.parseInt(split[1]));
            e = Long.parseLong(split[2]);
            d = split[3];
            d = split[4];
            f = a.a(Integer.parseInt(split[5]));
            g = Long.parseLong(split[6]);
            h = split[7];
            i = split[8];
            j = Long.parseLong(split[9]);
            k = Long.parseLong(split[10]);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Upload";
    }

    private static String g(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Reload";
    }
}
