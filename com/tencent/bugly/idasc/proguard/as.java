package com.tencent.bugly.idasc.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.opos.acs.st.utils.ErrorContants;
import com.tencent.bugly.idasc.BuglyStrategy;
import com.tencent.bugly.idasc.crashreport.common.info.PlugInBean;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.idasc.proguard.ag;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/as.class */
public final class as {

    /* renamed from: a  reason: collision with root package name */
    public static int f21565a;
    private static final Map<Integer, Pair<String, String>> h = new HashMap<Integer, Pair<String, String>>() { // from class: com.tencent.bugly.idasc.proguard.as.1
        {
            put(3, new Pair("203", "103"));
            put(7, new Pair("208", "108"));
            put(0, new Pair(BasicPushStatus.SUCCESS_CODE, "100"));
            put(1, new Pair(ErrorContants.REALTIME_LOADAD_ERROR, "101"));
            put(2, new Pair(ErrorContants.INIT_LOADAD_ERROR, "102"));
            put(4, new Pair("204", "104"));
            put(6, new Pair("206", "106"));
            put(5, new Pair("207", "107"));
        }
    };
    private static final ArrayList<a> i = new ArrayList<a>() { // from class: com.tencent.bugly.idasc.proguard.as.2
        {
            add(new b((byte) 0));
            add(new c((byte) 0));
            add(new d((byte) 0));
            add(new e((byte) 0));
            add(new h((byte) 0));
            add(new i((byte) 0));
            add(new f((byte) 0));
            add(new g((byte) 0));
        }
    };
    private static final Map<Integer, Integer> j = new HashMap<Integer, Integer>() { // from class: com.tencent.bugly.idasc.proguard.as.3
        {
            put(3, 4);
            put(7, 7);
            put(2, 1);
            put(0, 0);
            put(1, 2);
            put(4, 3);
            put(5, 5);
            put(6, 6);
        }
    };
    private static final Map<Integer, String> k = new HashMap<Integer, String>() { // from class: com.tencent.bugly.idasc.proguard.as.4
        {
            put(3, "BuglyAnrCrash");
            put(0, "BuglyJavaCrash");
            put(1, "BuglyNativeCrash");
        }
    };
    private static final Map<Integer, String> l = new HashMap<Integer, String>() { // from class: com.tencent.bugly.idasc.proguard.as.5
        {
            put(3, "BuglyAnrCrashReport");
            put(0, "BuglyJavaCrashReport");
            put(1, "BuglyNativeCrashReport");
        }
    };
    protected final Context b;

    /* renamed from: c  reason: collision with root package name */
    protected final ai f21566c;
    protected final w d;
    protected final ac e;
    protected aw f;
    protected BuglyStrategy.a g;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/as$a.class */
    static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        final int f21569a;

        private a(int i) {
            this.f21569a = i;
        }

        /* synthetic */ a(int i, byte b) {
            this(i);
        }

        abstract boolean a();
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/as$b.class */
    static final class b extends a {
        private b() {
            super(3, (byte) 0);
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        final boolean a() {
            return at.a().k();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/as$c.class */
    static final class c extends a {
        private c() {
            super(7, (byte) 0);
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        final boolean a() {
            return true;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/as$d.class */
    static final class d extends a {
        private d() {
            super(2, (byte) 0);
        }

        /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        final boolean a() {
            return true;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/as$e.class */
    static final class e extends a {
        private e() {
            super(0, (byte) 0);
        }

        /* synthetic */ e(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        final boolean a() {
            return at.a().j();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/as$f.class */
    static final class f extends a {
        private f() {
            super(5, (byte) 0);
        }

        /* synthetic */ f(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        final boolean a() {
            return (at.a().B & 2) > 0;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/as$g.class */
    static final class g extends a {
        private g() {
            super(6, (byte) 0);
        }

        /* synthetic */ g(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        final boolean a() {
            return (at.a().B & 1) > 0;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/as$h.class */
    static final class h extends a {
        private h() {
            super(1, (byte) 0);
        }

        /* synthetic */ h(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        final boolean a() {
            return at.a().j();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/as$i.class */
    static final class i extends a {
        private i() {
            super(4, (byte) 0);
        }

        /* synthetic */ i(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        final boolean a() {
            return (at.a().B & 4) > 0;
        }
    }

    public as(Context context, ai aiVar, w wVar, ac acVar, BuglyStrategy.a aVar) {
        f21565a = 1004;
        this.b = context;
        this.f21566c = aiVar;
        this.d = wVar;
        this.e = acVar;
        this.g = aVar;
        this.f = null;
    }

    private static CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) ap.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f21507a = j2;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private static CrashDetailBean a(List<ar> list, CrashDetailBean crashDetailBean) {
        if (list.isEmpty()) {
            return crashDetailBean;
        }
        ArrayList arrayList = new ArrayList(10);
        for (ar arVar : list) {
            if (arVar.e) {
                arrayList.add(arVar);
            }
        }
        CrashDetailBean crashDetailBean2 = null;
        if (!arrayList.isEmpty()) {
            List<CrashDetailBean> c2 = c(arrayList);
            crashDetailBean2 = null;
            if (c2 != null) {
                crashDetailBean2 = null;
                if (!c2.isEmpty()) {
                    Collections.sort(c2);
                    crashDetailBean2 = c2.get(0);
                    a(crashDetailBean2, c2);
                }
            }
        }
        CrashDetailBean crashDetailBean3 = crashDetailBean2;
        if (crashDetailBean2 == null) {
            crashDetailBean.j = true;
            crashDetailBean.t = 0;
            crashDetailBean.s = "";
            crashDetailBean3 = crashDetailBean;
        }
        b(crashDetailBean3, list);
        if (crashDetailBean3.r != crashDetailBean.r) {
            String str = crashDetailBean3.s;
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.r);
            if (!str.contains(sb.toString())) {
                crashDetailBean3.t++;
                crashDetailBean3.s += crashDetailBean.r + "\n";
            }
        }
        return crashDetailBean3;
    }

    private static bn a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 == null || context == null) {
            al.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
            return null;
        }
        al.c("zip %s", str2);
        File file = new File(str2);
        File file2 = new File(context.getCacheDir(), str);
        if (!ap.a(file, file2)) {
            al.d("zip fail!", new Object[0]);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file2);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
                byteArrayOutputStream.flush();
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            al.c("read bytes :%d", Integer.valueOf(byteArray.length));
            bn bnVar = new bn((byte) 2, file2.getName(), byteArray);
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                if (!al.a(e2)) {
                    e2.printStackTrace();
                }
            }
            if (file2.exists()) {
                al.c("del tmp", new Object[0]);
                file2.delete();
            }
            return bnVar;
        } catch (Throwable th2) {
            th = th2;
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        if (!al.a(e3)) {
                            e3.printStackTrace();
                        }
                    }
                }
                if (file2.exists()) {
                    al.c("del tmp", new Object[0]);
                    file2.delete();
                    return null;
                }
                return null;
            } catch (Throwable th3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        if (!al.a(e4)) {
                            e4.printStackTrace();
                        }
                    }
                }
                if (file2.exists()) {
                    al.c("del tmp", new Object[0]);
                    file2.delete();
                }
                throw th3;
            }
        }
    }

    private static bo a(Context context, CrashDetailBean crashDetailBean, aa aaVar) {
        boolean z = false;
        if (context == null || crashDetailBean == null || aaVar == null) {
            al.d("enExp args == null", new Object[0]);
            return null;
        }
        bo boVar = new bo();
        boVar.f21612a = e(crashDetailBean);
        boVar.b = crashDetailBean.r;
        boVar.f21613c = crashDetailBean.n;
        boVar.d = crashDetailBean.o;
        boVar.e = crashDetailBean.p;
        boVar.g = crashDetailBean.q;
        boVar.h = crashDetailBean.z;
        boVar.i = crashDetailBean.f21508c;
        boVar.j = null;
        boVar.l = crashDetailBean.m;
        boVar.m = crashDetailBean.e;
        boVar.f = crashDetailBean.B;
        boVar.n = null;
        ArrayList<bl> arrayList = null;
        if (crashDetailBean.h != null) {
            if (!crashDetailBean.h.isEmpty()) {
                ArrayList<bl> arrayList2 = new ArrayList<>(crashDetailBean.h.size());
                Iterator<Map.Entry<String, PlugInBean>> it = crashDetailBean.h.entrySet().iterator();
                while (true) {
                    arrayList = arrayList2;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, PlugInBean> next = it.next();
                    bl blVar = new bl();
                    blVar.f21606a = next.getValue().f21503a;
                    blVar.f21607c = next.getValue().f21504c;
                    blVar.e = next.getValue().b;
                    arrayList2.add(blVar);
                }
            } else {
                arrayList = null;
            }
        }
        boVar.p = arrayList;
        al.c("libInfo %s", boVar.o);
        ArrayList<bn> arrayList3 = new ArrayList<>(20);
        a(arrayList3, crashDetailBean);
        a(arrayList3, crashDetailBean.w);
        b(arrayList3, crashDetailBean.x);
        c(arrayList3, crashDetailBean.Z);
        a(arrayList3, crashDetailBean.aa, context);
        a(arrayList3, crashDetailBean.y);
        a(arrayList3, crashDetailBean, context);
        b(arrayList3, crashDetailBean, context);
        a(arrayList3, aaVar.L);
        b(arrayList3, crashDetailBean.Y);
        boVar.q = arrayList3;
        if (crashDetailBean.j) {
            boVar.k = crashDetailBean.t;
        }
        boVar.r = a(crashDetailBean, aaVar);
        boVar.s = new HashMap();
        if (crashDetailBean.S != null && crashDetailBean.S.size() > 0) {
            boVar.s.putAll(crashDetailBean.S);
            al.a("setted message size %d", Integer.valueOf(boVar.s.size()));
        }
        Map<String, String> map = boVar.s;
        al.c("pss:" + crashDetailBean.I + " vss:" + crashDetailBean.J + " javaHeap:" + crashDetailBean.K, new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(crashDetailBean.I);
        map.put("SDK_UPLOAD_U1", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(crashDetailBean.J);
        map.put("SDK_UPLOAD_U2", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(crashDetailBean.K);
        map.put("SDK_UPLOAD_U3", sb3.toString());
        String str = crashDetailBean.n;
        String str2 = crashDetailBean.f21508c;
        String d2 = aaVar.d();
        long j2 = (crashDetailBean.r - crashDetailBean.Q) / 1000;
        boolean z2 = crashDetailBean.k;
        boolean z3 = crashDetailBean.R;
        boolean z4 = crashDetailBean.j;
        if (crashDetailBean.b == 1) {
            z = true;
        }
        al.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", str, str2, d2, Long.valueOf(j2), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z), Integer.valueOf(crashDetailBean.t), crashDetailBean.s, Boolean.valueOf(crashDetailBean.d), Integer.valueOf(boVar.r.size()));
        return boVar;
    }

    private static bp a(Context context, List<CrashDetailBean> list, aa aaVar) {
        if (context == null || list == null || list.size() == 0 || aaVar == null) {
            al.d("enEXPPkg args == null!", new Object[0]);
            return null;
        }
        bp bpVar = new bp();
        bpVar.f21614a = new ArrayList<>();
        for (CrashDetailBean crashDetailBean : list) {
            bpVar.f21614a.add(a(context, crashDetailBean, aaVar));
        }
        return bpVar;
    }

    public static List<CrashDetailBean> a() {
        StrategyBean c2 = ac.a().c();
        if (c2 == null) {
            al.d("have not synced remote!", new Object[0]);
            return null;
        } else if (!c2.f) {
            al.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            al.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long b2 = ap.b();
            List<ar> b3 = b();
            al.c("Size of crash list loaded from DB: %s", Integer.valueOf(b3.size()));
            if (b3 == null || b3.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.addAll(a(b3));
            b3.removeAll(arrayList);
            Iterator<ar> it = b3.iterator();
            while (it.hasNext()) {
                ar next = it.next();
                if (next.b < b2 - at.j) {
                    arrayList2.add(next);
                } else if (next.d) {
                    if (next.b >= currentTimeMillis - 86400000) {
                        it.remove();
                    } else if (!next.e) {
                    }
                } else if (next.f >= 3 && next.b < currentTimeMillis - 86400000) {
                }
                it.remove();
                arrayList.add(next);
            }
            b(arrayList2);
            if (arrayList.size() > 0) {
                d(arrayList);
            }
            ArrayList arrayList3 = new ArrayList();
            List<CrashDetailBean> c3 = c(b3);
            if (c3 != null && c3.size() > 0) {
                String str = aa.b().o;
                Iterator<CrashDetailBean> it2 = c3.iterator();
                while (it2.hasNext()) {
                    CrashDetailBean next2 = it2.next();
                    if (!str.equals(next2.f)) {
                        it2.remove();
                        arrayList3.add(next2);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                e(arrayList3);
            }
            return c3;
        }
    }

    private static List<ar> a(List<ar> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (ar arVar : list) {
            if (arVar.d && arVar.b <= currentTimeMillis - 86400000) {
                arrayList.add(arVar);
            }
        }
        return arrayList;
    }

    private static Map<String, String> a(CrashDetailBean crashDetailBean, aa aaVar) {
        HashMap hashMap = new HashMap(30);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.C);
            hashMap.put("A9", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.D);
            hashMap.put("A11", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.E);
            hashMap.put("A10", sb3.toString());
            hashMap.put("A23", crashDetailBean.f);
            StringBuilder sb4 = new StringBuilder();
            aaVar.getClass();
            hashMap.put("A7", sb4.toString());
            hashMap.put("A6", aa.n());
            hashMap.put("A5", aaVar.m());
            hashMap.put("A22", aaVar.g());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(crashDetailBean.G);
            hashMap.put("A2", sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(crashDetailBean.F);
            hashMap.put("A1", sb6.toString());
            hashMap.put("A24", aaVar.k);
            StringBuilder sb7 = new StringBuilder();
            sb7.append(crashDetailBean.H);
            hashMap.put("A17", sb7.toString());
            hashMap.put("A25", aaVar.g());
            hashMap.put("A15", aaVar.q());
            StringBuilder sb8 = new StringBuilder();
            sb8.append(aaVar.r());
            hashMap.put("A13", sb8.toString());
            hashMap.put("A34", crashDetailBean.A);
            if (aaVar.G != null) {
                hashMap.put("productIdentify", aaVar.G);
            }
            hashMap.put("A26", URLEncoder.encode(crashDetailBean.L, "utf-8"));
            boolean z = true;
            if (crashDetailBean.b == 1) {
                hashMap.put("A27", crashDetailBean.O);
                hashMap.put("A28", crashDetailBean.N);
                StringBuilder sb9 = new StringBuilder();
                sb9.append(crashDetailBean.k);
                hashMap.put("A29", sb9.toString());
            }
            hashMap.put("A30", crashDetailBean.P);
            StringBuilder sb10 = new StringBuilder();
            sb10.append(crashDetailBean.Q);
            hashMap.put("A18", sb10.toString());
            StringBuilder sb11 = new StringBuilder();
            if (crashDetailBean.R) {
                z = false;
            }
            sb11.append(z);
            hashMap.put("A36", sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(aaVar.z);
            hashMap.put("F02", sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(aaVar.A);
            hashMap.put("F03", sb13.toString());
            hashMap.put("F04", aaVar.d());
            StringBuilder sb14 = new StringBuilder();
            sb14.append(aaVar.B);
            hashMap.put("F05", sb14.toString());
            hashMap.put("F06", aaVar.y);
            hashMap.put("F08", aaVar.E);
            hashMap.put("F09", aaVar.F);
            StringBuilder sb15 = new StringBuilder();
            sb15.append(aaVar.C);
            hashMap.put("F10", sb15.toString());
            a(hashMap, crashDetailBean);
            return hashMap;
        } catch (Exception e2) {
            e2.printStackTrace();
            al.a(e2);
            return hashMap;
        }
    }

    private static void a(CrashDetailBean crashDetailBean, List<CrashDetailBean> list) {
        String[] split;
        StringBuilder sb = new StringBuilder(128);
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                crashDetailBean.s += sb.toString();
                return;
            }
            CrashDetailBean crashDetailBean2 = list.get(i3);
            if (crashDetailBean2.s != null && (split = crashDetailBean2.s.split("\n")) != null) {
                int length = split.length;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < length) {
                        String str = split[i5];
                        if (!crashDetailBean.s.contains(str)) {
                            crashDetailBean.t++;
                            sb.append(str);
                            sb.append("\n");
                        }
                        i4 = i5 + 1;
                    }
                }
            }
            i2 = i3 + 1;
        }
    }

    private static void a(CrashDetailBean crashDetailBean, Map<String, String> map) {
        String value;
        if (map == null || map.isEmpty()) {
            al.d("extra map is empty. CrashBean won't have userDatas.", new Object[0]);
            return;
        }
        crashDetailBean.S = new LinkedHashMap(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!ap.b(entry.getKey())) {
                String key = entry.getKey();
                String str = key;
                if (key.length() > 100) {
                    str = key.substring(0, 100);
                    al.d("setted key length is over limit %d substring to %s", 100, str);
                }
                if (ap.b(entry.getValue()) || entry.getValue().length() <= 100000) {
                    value = entry.getValue();
                } else {
                    value = entry.getValue().substring(entry.getValue().length() - 100000);
                    al.d("setted %s value length is over limit %d substring", str, 100000);
                }
                crashDetailBean.S.put(str, value);
                al.a("add setted key %s value size:%d", str, Integer.valueOf(value.length()));
            }
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        aa b2 = aa.b();
        if (b2 == null) {
            return;
        }
        al.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        al.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        al.e("# PKG NAME: %s", b2.f21522c);
        al.e("# APP VER: %s", b2.o);
        al.e("# SDK VER: %s", b2.h);
        al.e("# LAUNCH TIME: %s", ap.a(new Date(aa.b().f21520a)));
        al.e("# CRASH TYPE: %s", str);
        al.e("# CRASH TIME: %s", str2);
        al.e("# CRASH PROCESS: %s", str3);
        al.e("# CRASH FOREGROUND: %s", Boolean.valueOf(b2.a()));
        al.e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            al.e("# REPORT ID: %s", crashDetailBean.f21508c);
            al.e("# CRASH DEVICE: %s %s", b2.h(), b2.r().booleanValue() ? "ROOTED" : "UNROOT");
            al.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
            al.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
            if (!ap.b(crashDetailBean.O)) {
                al.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.O, crashDetailBean.N);
            } else if (crashDetailBean.b == 3) {
                if (crashDetailBean.T == null) {
                    str6 = com.igexin.push.core.b.l;
                } else {
                    str6 = crashDetailBean.T.get("BUGLY_CR_01");
                }
                al.e("# EXCEPTION ANR MESSAGE:\n %s", str6);
            }
        }
        if (!ap.b(str5)) {
            al.e("# CRASH STACK: ", new Object[0]);
            al.e(str5, new Object[0]);
        }
        al.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean) {
        if (crashDetailBean.j && crashDetailBean.s != null && crashDetailBean.s.length() > 0) {
            try {
                arrayList.add(new bn((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes("utf-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        bn a2;
        if (crashDetailBean.b != 3) {
            return;
        }
        al.c("crashBean.anrMessages:%s", crashDetailBean.T);
        try {
            if (crashDetailBean.T != null && crashDetailBean.T.containsKey("BUGLY_CR_01")) {
                if (!TextUtils.isEmpty(crashDetailBean.T.get("BUGLY_CR_01"))) {
                    arrayList.add(new bn((byte) 1, "anrMessage.txt", crashDetailBean.T.get("BUGLY_CR_01").getBytes("utf-8")));
                    al.c("attach anr message", new Object[0]);
                }
                crashDetailBean.T.remove("BUGLY_CR_01");
            }
            if (crashDetailBean.v == null || (a2 = a("trace.zip", context, crashDetailBean.v)) == null) {
                return;
            }
            al.c("attach traces", new Object[0]);
            arrayList.add(a2);
        } catch (Exception e2) {
            e2.printStackTrace();
            al.a(e2);
        }
    }

    private static void a(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "log.txt", str.getBytes("utf-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, String str, Context context) {
        if (str != null) {
            try {
                bn a2 = a("backupRecord.zip", context, str);
                if (a2 != null) {
                    al.c("attach backup record", new Object[0]);
                    arrayList.add(a2);
                }
            } catch (Exception e2) {
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        try {
            arrayList.add(new bn((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
            al.c("attach pageTracingList", new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            bn bnVar = new bn((byte) 2, "buglylog.zip", bArr);
            al.c("attach user log", new Object[0]);
            arrayList.add(bnVar);
        } catch (Exception e2) {
            al.a(e2);
        }
    }

    static /* synthetic */ void a(List list, boolean z, long j2, String str, String str2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CrashDetailBean crashDetailBean = (CrashDetailBean) it.next();
            String str3 = l.get(Integer.valueOf(crashDetailBean.b));
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new ag.c(crashDetailBean.f21508c, str3, crashDetailBean.r, z, j2, str, str2));
            }
        }
        ag.a.a().a(arrayList);
    }

    private static void a(Map<String, String> map, CrashDetailBean crashDetailBean) {
        if (crashDetailBean.U >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.U);
            map.put("C01", sb.toString());
        }
        if (crashDetailBean.V >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.V);
            map.put("C02", sb2.toString());
        }
        if (crashDetailBean.W != null && crashDetailBean.W.size() > 0) {
            for (Map.Entry<String, String> entry : crashDetailBean.W.entrySet()) {
                map.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        if (crashDetailBean.X == null || crashDetailBean.X.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry2 : crashDetailBean.X.entrySet()) {
            map.put("C04_" + entry2.getKey(), entry2.getValue());
        }
    }

    public static void a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            al.c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                al.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f21508c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j));
                crashDetailBean.l++;
                crashDetailBean.d = z;
                al.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f21508c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j));
            }
            for (CrashDetailBean crashDetailBean2 : list) {
                at.a().a(crashDetailBean2);
            }
            al.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        al.b("[crash] upload fail.", new Object[0]);
    }

    private static boolean a(CrashDetailBean crashDetailBean, List<ar> list, List<ar> list2) {
        boolean z = false;
        for (ar arVar : list) {
            if (crashDetailBean.u.equals(arVar.f21564c)) {
                if (arVar.e) {
                    z = true;
                }
                list2.add(arVar);
            }
        }
        return z;
    }

    private static boolean a(String str) {
        if (at.r == null || at.r.isEmpty()) {
            return false;
        }
        try {
            al.c("Crash regular filter for crash stack is: %s", at.r);
            if (Pattern.compile(at.r).matcher(str).find()) {
                al.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
            return false;
        } catch (Exception e2) {
            al.a(e2);
            al.d("Failed to compile " + at.r, new Object[0]);
            return false;
        }
    }

    private static ar b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ar arVar = new ar();
            arVar.f21563a = cursor.getLong(cursor.getColumnIndex("_id"));
            arVar.b = cursor.getLong(cursor.getColumnIndex("_tm"));
            arVar.f21564c = cursor.getString(cursor.getColumnIndex("_s1"));
            arVar.d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            boolean z = false;
            if (cursor.getInt(cursor.getColumnIndex("_me")) == 1) {
                z = true;
            }
            arVar.e = z;
            arVar.f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return arVar;
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private static List<ar> b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor a2 = w.a().a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, (String) null);
            if (a2 == null) {
                if (a2 != null) {
                    a2.close();
                    return null;
                }
                return null;
            }
            try {
                if (a2.getCount() <= 0) {
                    if (a2 != null) {
                        a2.close();
                    }
                    return arrayList;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("_id in (");
                int i2 = 0;
                while (a2.moveToNext()) {
                    ar b2 = b(a2);
                    if (b2 != null) {
                        arrayList.add(b2);
                    } else {
                        sb.append(a2.getLong(a2.getColumnIndex("_id")));
                        sb.append(",");
                        i2++;
                    }
                }
                StringBuilder sb2 = sb;
                if (sb.toString().contains(",")) {
                    sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb2.append(")");
                String sb3 = sb2.toString();
                sb2.setLength(0);
                if (i2 > 0) {
                    al.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb3)));
                }
                if (a2 != null) {
                    a2.close();
                }
                return arrayList;
            } catch (Throwable th) {
                cursor = a2;
                th = th;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    return arrayList;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void b(CrashDetailBean crashDetailBean, List<ar> list) {
        StringBuilder sb = new StringBuilder(64);
        for (ar arVar : list) {
            if (!arVar.e && !arVar.d) {
                String str = crashDetailBean.s;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(arVar.b);
                if (!str.contains(sb2.toString())) {
                    crashDetailBean.t++;
                    sb.append(arVar.b);
                    sb.append("\n");
                }
            }
        }
        crashDetailBean.s += sb.toString();
    }

    private static void b(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        if (crashDetailBean.b == 1 && crashDetailBean.v != null) {
            try {
                bn a2 = a("tomb.zip", context, crashDetailBean.v);
                if (a2 != null) {
                    al.c("attach tombs", new Object[0]);
                    arrayList.add(a2);
                }
            } catch (Exception e2) {
                al.a(e2);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "jniLog.txt", str.getBytes("utf-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            arrayList.add(new bn((byte) 1, "userExtraByteData", bArr));
            al.c("attach extraData", new Object[0]);
        } catch (Exception e2) {
            al.a(e2);
        }
    }

    private static void b(List<ar> list) {
        List<CrashDetailBean> c2 = c(list);
        if (c2 == null || c2.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CrashDetailBean crashDetailBean : c2) {
            String str = l.get(Integer.valueOf(crashDetailBean.b));
            if (!TextUtils.isEmpty(str)) {
                al.c("find expired data,crashId:%s eventType:%s", crashDetailBean.f21508c, str);
                arrayList.add(new ag.c(crashDetailBean.f21508c, str, crashDetailBean.r, false, 0L, "expired", null));
            }
        }
        ag.a.a().a(arrayList);
    }

    private boolean b(CrashDetailBean crashDetailBean, List<ar> list, List<ar> list2) {
        int i2 = crashDetailBean.b;
        if (!p.f21637c ? ((i2 == 3) || (i2 == 0 || i2 == 1)) ? at.e : true : false) {
            ArrayList<ar> arrayList = new ArrayList(10);
            if (!a(crashDetailBean, list, arrayList)) {
                try {
                    if (arrayList.size() < at.d) {
                        return false;
                    }
                } catch (Exception e2) {
                    al.a(e2);
                    al.d("Failed to merge crash.", new Object[0]);
                    return false;
                }
            }
            al.a("same crash occur too much do merged!", new Object[0]);
            CrashDetailBean a2 = a((List<ar>) arrayList, crashDetailBean);
            for (ar arVar : arrayList) {
                if (arVar.f21563a != a2.f21507a) {
                    list2.add(arVar);
                }
            }
            b(a2);
            d(list2);
            al.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
            return true;
        }
        return false;
    }

    private static ContentValues c(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.f21507a > 0) {
                contentValues.put("_id", Long.valueOf(crashDetailBean.f21507a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.r));
            contentValues.put("_s1", crashDetailBean.u);
            contentValues.put("_up", Integer.valueOf(crashDetailBean.d ? 1 : 0));
            contentValues.put("_me", Integer.valueOf(crashDetailBean.j ? 1 : 0));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.l));
            contentValues.put("_dt", ap.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Finally extract failed */
    private static List<CrashDetailBean> c(List<ar> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in (");
        for (ar arVar : list) {
            sb.append(arVar.f21563a);
            sb.append(",");
        }
        StringBuilder sb2 = sb;
        if (sb.toString().contains(",")) {
            sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        }
        sb2.append(")");
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            Cursor a2 = w.a().a("t_cr", (String[]) null, sb3);
            if (a2 == null) {
                if (a2 != null) {
                    a2.close();
                    return null;
                }
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb2.append("_id in (");
                int i2 = 0;
                while (a2.moveToNext()) {
                    CrashDetailBean a3 = a(a2);
                    if (a3 != null) {
                        arrayList.add(a3);
                    } else {
                        sb2.append(a2.getLong(a2.getColumnIndex("_id")));
                        sb2.append(",");
                        i2++;
                    }
                }
                StringBuilder sb4 = sb2;
                if (sb2.toString().contains(",")) {
                    sb4 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
                }
                sb4.append(")");
                String sb5 = sb4.toString();
                if (i2 > 0) {
                    al.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb5)));
                }
                if (a2 != null) {
                    a2.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = a2;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                        return null;
                    }
                    return null;
                } catch (Throwable th2) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    private static void c(ArrayList<bn> arrayList, String str) {
        if (ap.b(str)) {
            return;
        }
        try {
            bn bnVar = new bn((byte) 1, "crashInfos.txt", str.getBytes("utf-8"));
            al.c("attach crash infos", new Object[0]);
            arrayList.add(bnVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            al.a(e2);
        }
    }

    private static void d(List<ar> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in (");
        for (ar arVar : list) {
            sb.append(arVar.f21563a);
            sb.append(",");
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        sb2.append(")");
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb3)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private boolean d(CrashDetailBean crashDetailBean) {
        try {
            al.c("save eup logs", new Object[0]);
            aa b2 = aa.b();
            String str = "#--------\npackage:" + b2.e() + "\nversion:" + b2.o + "\nsdk:" + b2.h + "\nprocess:" + crashDetailBean.A + "\ndate:" + ap.a(new Date(crashDetailBean.r)) + "\ntype:" + crashDetailBean.n + "\nmessage:" + crashDetailBean.o + "\nstack:\n" + crashDetailBean.q + "\neupID:" + crashDetailBean.f21508c + "\n";
            String str2 = null;
            if (at.m != null) {
                File file = new File(at.m);
                File file2 = file;
                if (file.isFile()) {
                    file2 = file.getParentFile();
                }
                str2 = file2.getAbsolutePath();
            } else if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/" + this.b.getPackageName();
            }
            am.a(str2 + "/euplog.txt", str, at.n);
            return true;
        } catch (Throwable th) {
            al.d("rqdp{  save error} %s", th.toString());
            if (al.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private static String e(CrashDetailBean crashDetailBean) {
        try {
            Pair<String, String> pair = h.get(Integer.valueOf(crashDetailBean.b));
            if (pair != null) {
                return crashDetailBean.j ? pair.first : pair.second;
            }
            al.e("crash type error! %d", Integer.valueOf(crashDetailBean.b));
            return "";
        } catch (Exception e2) {
            al.a(e2);
            return "";
        }
    }

    private static void e(List<CrashDetailBean> list) {
        try {
            if (list.size() == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (CrashDetailBean crashDetailBean : list) {
                sb.append(" or _id = ");
                sb.append(crashDetailBean.f21507a);
            }
            String sb2 = sb.toString();
            String str = sb2;
            if (sb2.length() > 0) {
                str = sb2.substring(4);
            }
            sb.setLength(0);
            al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", str)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void a(CrashDetailBean crashDetailBean) {
        int i2 = crashDetailBean.b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 3 && !at.a().k()) {
                    return;
                }
            } else if (!at.a().j()) {
                return;
            }
        } else if (!at.a().j()) {
            return;
        }
        if (this.f != null) {
            al.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
        }
    }

    public final void a(final List<CrashDetailBean> list, long j2, final boolean z, boolean z2, boolean z3) {
        if (!aa.a(this.b).f) {
            al.d("warn: not upload process", new Object[0]);
            return;
        }
        ai aiVar = this.f21566c;
        if (aiVar == null) {
            al.d("warn: upload manager is null", new Object[0]);
        } else if (!z3 && !aiVar.b(at.f21570a)) {
            al.d("warn: not crashHappen or not should upload", new Object[0]);
        } else {
            StrategyBean c2 = this.e.c();
            if (!c2.f) {
                al.d("remote report is disable!", new Object[0]);
                al.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            } else if (list == null || list.size() == 0) {
                al.d("warn: crashList is null or crashList num is 0", new Object[0]);
            } else {
                try {
                    String str = c2.r;
                    String str2 = StrategyBean.b;
                    bp a2 = a(this.b, list, aa.b());
                    if (a2 == null) {
                        al.d("create eupPkg fail!", new Object[0]);
                        return;
                    }
                    byte[] a3 = ae.a((m) a2);
                    if (a3 == null) {
                        al.d("send encode fail!", new Object[0]);
                        return;
                    }
                    bq a4 = ae.a(this.b, 830, a3);
                    if (a4 == null) {
                        al.d("request package is null.", new Object[0]);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    ah ahVar = new ah() { // from class: com.tencent.bugly.idasc.proguard.as.6
                        @Override // com.tencent.bugly.idasc.proguard.ah
                        public final void a(boolean z4, String str3) {
                            as.a(list, z4, System.currentTimeMillis() - currentTimeMillis, z ? "realtime" : "cache", str3);
                            as.a(z4, list);
                        }
                    };
                    if (z) {
                        this.f21566c.a(f21565a, a4, str, str2, ahVar, j2, z2);
                    } else {
                        this.f21566c.a(f21565a, a4, str, str2, ahVar, false);
                    }
                } catch (Throwable th) {
                    al.e("req cr error %s", th.toString());
                    if (al.b(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x03ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x035d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 1062
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.as.a(com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean, boolean):boolean");
    }

    public final void b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues c2 = c(crashDetailBean);
        if (c2 != null) {
            long a2 = w.a().a("t_cr", c2, (v) null);
            if (a2 >= 0) {
                al.c("insert %s success!", "t_cr");
                crashDetailBean.f21507a = a2;
            }
        }
        if (at.l) {
            d(crashDetailBean);
        }
    }

    public final void b(CrashDetailBean crashDetailBean, boolean z) {
        if (!at.o) {
            al.a("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
            return;
        }
        al.a("try to upload right now", new Object[0]);
        ArrayList arrayList = new ArrayList();
        arrayList.add(crashDetailBean);
        a(arrayList, com.anythink.expressad.video.module.a.a.m.ag, z, crashDetailBean.b == 7, z);
    }
}
