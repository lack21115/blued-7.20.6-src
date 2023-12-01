package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.expressad.video.module.a.a.m;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.opos.acs.st.utils.ErrorContants;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.k;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/crash/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f35159a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private u f35160c;
    private p d;
    private com.tencent.bugly.crashreport.common.strategy.a e;
    private o f;
    private BuglyStrategy.a g;

    public b(int i, Context context, u uVar, p pVar, com.tencent.bugly.crashreport.common.strategy.a aVar, BuglyStrategy.a aVar2, o oVar) {
        f35159a = i;
        this.b = context;
        this.f35160c = uVar;
        this.d = pVar;
        this.e = aVar;
        this.g = aVar2;
        this.f = oVar;
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
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) z.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f35141a = j;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private CrashDetailBean a(List<a> list, CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2;
        if (list != null && list.size() != 0) {
            CrashDetailBean crashDetailBean3 = null;
            ArrayList arrayList = new ArrayList(10);
            for (a aVar : list) {
                if (aVar.e) {
                    arrayList.add(aVar);
                }
            }
            CrashDetailBean crashDetailBean4 = null;
            if (arrayList.size() > 0) {
                List<CrashDetailBean> b = b(arrayList);
                crashDetailBean4 = null;
                if (b != null) {
                    crashDetailBean4 = null;
                    if (b.size() > 0) {
                        Collections.sort(b);
                        int i = 0;
                        while (true) {
                            crashDetailBean4 = crashDetailBean3;
                            if (i >= b.size()) {
                                break;
                            }
                            CrashDetailBean crashDetailBean5 = b.get(i);
                            if (i == 0) {
                                crashDetailBean2 = crashDetailBean5;
                            } else {
                                crashDetailBean2 = crashDetailBean3;
                                if (crashDetailBean5.s != null) {
                                    String[] split = crashDetailBean5.s.split("\n");
                                    crashDetailBean2 = crashDetailBean3;
                                    if (split != null) {
                                        int length = split.length;
                                        int i2 = 0;
                                        while (true) {
                                            int i3 = i2;
                                            crashDetailBean2 = crashDetailBean3;
                                            if (i3 < length) {
                                                String str = split[i3];
                                                if (!crashDetailBean3.s.contains(str)) {
                                                    crashDetailBean3.t++;
                                                    crashDetailBean3.s += str + "\n";
                                                }
                                                i2 = i3 + 1;
                                            }
                                        }
                                    }
                                }
                            }
                            i++;
                            crashDetailBean3 = crashDetailBean2;
                        }
                    }
                }
            }
            CrashDetailBean crashDetailBean6 = crashDetailBean4;
            if (crashDetailBean4 == null) {
                crashDetailBean.j = true;
                crashDetailBean.t = 0;
                crashDetailBean.s = "";
                crashDetailBean6 = crashDetailBean;
            }
            for (a aVar2 : list) {
                if (!aVar2.e && !aVar2.d) {
                    String str2 = crashDetailBean6.s;
                    StringBuilder sb = new StringBuilder();
                    sb.append(aVar2.b);
                    if (!str2.contains(sb.toString())) {
                        crashDetailBean6.t++;
                        crashDetailBean6.s += aVar2.b + "\n";
                    }
                }
            }
            if (crashDetailBean6.r != crashDetailBean.r) {
                String str3 = crashDetailBean6.s;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(crashDetailBean.r);
                if (!str3.contains(sb2.toString())) {
                    crashDetailBean6.t++;
                    crashDetailBean6.s += crashDetailBean.r + "\n";
                }
            }
            return crashDetailBean6;
        }
        return crashDetailBean;
    }

    private static aj a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 == null || context == null) {
            x.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
            return null;
        }
        x.c("zip %s", str2);
        File file = new File(str2);
        File file2 = new File(context.getCacheDir(), str);
        if (!z.a(file, file2, 5000)) {
            x.d("zip fail!", new Object[0]);
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
            x.c("read bytes :%d", Integer.valueOf(byteArray.length));
            aj ajVar = new aj((byte) 2, file2.getName(), byteArray);
            try {
                fileInputStream.close();
            } catch (IOException e) {
                if (!x.a(e)) {
                    e.printStackTrace();
                }
            }
            if (file2.exists()) {
                x.c("del tmp", new Object[0]);
                file2.delete();
            }
            return ajVar;
        } catch (Throwable th2) {
            th = th2;
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        if (!x.a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (file2.exists()) {
                    x.c("del tmp", new Object[0]);
                    file2.delete();
                    return null;
                }
                return null;
            } catch (Throwable th3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        if (!x.a(e3)) {
                            e3.printStackTrace();
                        }
                    }
                }
                if (file2.exists()) {
                    x.c("del tmp", new Object[0]);
                    file2.delete();
                }
                throw th3;
            }
        }
    }

    private static ak a(Context context, CrashDetailBean crashDetailBean, com.tencent.bugly.crashreport.common.info.a aVar) {
        aj a2;
        aj a3;
        aj ajVar;
        if (context == null || crashDetailBean == null || aVar == null) {
            x.d("enExp args == null", new Object[0]);
            return null;
        }
        ak akVar = new ak();
        switch (crashDetailBean.b) {
            case 0:
                akVar.f35368a = crashDetailBean.j ? BasicPushStatus.SUCCESS_CODE : "100";
                break;
            case 1:
                akVar.f35368a = crashDetailBean.j ? ErrorContants.REALTIME_LOADAD_ERROR : "101";
                break;
            case 2:
                akVar.f35368a = crashDetailBean.j ? ErrorContants.INIT_LOADAD_ERROR : ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB;
                break;
            case 3:
                akVar.f35368a = crashDetailBean.j ? "203" : ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_NORMAL;
                break;
            case 4:
                akVar.f35368a = crashDetailBean.j ? "204" : "104";
                break;
            case 5:
                akVar.f35368a = crashDetailBean.j ? "207" : "107";
                break;
            case 6:
                akVar.f35368a = crashDetailBean.j ? "206" : "106";
                break;
            case 7:
                akVar.f35368a = crashDetailBean.j ? "208" : "108";
                break;
            default:
                x.e("crash type error! %d", Integer.valueOf(crashDetailBean.b));
                break;
        }
        akVar.b = crashDetailBean.r;
        akVar.f35369c = crashDetailBean.n;
        akVar.d = crashDetailBean.o;
        akVar.e = crashDetailBean.p;
        akVar.g = crashDetailBean.q;
        akVar.h = crashDetailBean.z;
        akVar.i = crashDetailBean.f35142c;
        akVar.j = null;
        akVar.l = crashDetailBean.m;
        akVar.m = crashDetailBean.e;
        akVar.f = crashDetailBean.B;
        akVar.n = null;
        x.c("libInfo %s", akVar.o);
        if (crashDetailBean.h != null && crashDetailBean.h.size() > 0) {
            akVar.p = new ArrayList<>();
            for (Map.Entry<String, PlugInBean> entry : crashDetailBean.h.entrySet()) {
                ah ahVar = new ah();
                ahVar.f35362a = entry.getValue().f35127a;
                ahVar.b = entry.getValue().f35128c;
                ahVar.f35363c = entry.getValue().b;
                akVar.p.add(ahVar);
            }
        }
        if (crashDetailBean.j) {
            akVar.k = crashDetailBean.t;
            if (crashDetailBean.s != null && crashDetailBean.s.length() > 0) {
                if (akVar.q == null) {
                    akVar.q = new ArrayList<>();
                }
                try {
                    akVar.q.add(new aj((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    akVar.q = null;
                }
            }
            x.c("crashcount:%d sz:%d", Integer.valueOf(akVar.k), Integer.valueOf(akVar.q != null ? akVar.q.size() : 0));
        }
        if (crashDetailBean.w != null) {
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            try {
                akVar.q.add(new aj((byte) 1, "log.txt", crashDetailBean.w.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                akVar.q = null;
            }
        }
        if (crashDetailBean.x != null) {
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            try {
                akVar.q.add(new aj((byte) 1, "jniLog.txt", crashDetailBean.x.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                akVar.q = null;
            }
        }
        if (!z.a(crashDetailBean.V)) {
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            try {
                ajVar = new aj((byte) 1, "crashInfos.txt", crashDetailBean.V.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
                ajVar = null;
            }
            if (ajVar != null) {
                x.c("attach crash infos", new Object[0]);
                akVar.q.add(ajVar);
            }
        }
        if (crashDetailBean.W != null) {
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            aj a4 = a("backupRecord.zip", context, crashDetailBean.W);
            if (a4 != null) {
                x.c("attach backup record", new Object[0]);
                akVar.q.add(a4);
            }
        }
        if (crashDetailBean.y != null && crashDetailBean.y.length > 0) {
            aj ajVar2 = new aj((byte) 2, "buglylog.zip", crashDetailBean.y);
            x.c("attach user log", new Object[0]);
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            akVar.q.add(ajVar2);
        }
        if (crashDetailBean.b == 3) {
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            x.c("crashBean.anrMessages:%s", crashDetailBean.P);
            if (crashDetailBean.P != null && crashDetailBean.P.containsKey("BUGLY_CR_01")) {
                try {
                    if (!TextUtils.isEmpty(crashDetailBean.P.get("BUGLY_CR_01"))) {
                        akVar.q.add(new aj((byte) 1, "anrMessage.txt", crashDetailBean.P.get("BUGLY_CR_01").getBytes("utf-8")));
                        x.c("attach anr message", new Object[0]);
                    }
                } catch (UnsupportedEncodingException e5) {
                    e5.printStackTrace();
                    akVar.q = null;
                }
                crashDetailBean.P.remove("BUGLY_CR_01");
            }
            if (crashDetailBean.v != null && NativeCrashHandler.getInstance().isEnableCatchAnrTrace() && (a3 = a("trace.zip", context, crashDetailBean.v)) != null) {
                x.c("attach traces", new Object[0]);
                akVar.q.add(a3);
            }
        }
        if (crashDetailBean.b == 1) {
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            if (crashDetailBean.v != null && (a2 = a("tomb.zip", context, crashDetailBean.v)) != null) {
                x.c("attach tombs", new Object[0]);
                akVar.q.add(a2);
            }
        }
        if (aVar.D != null && !aVar.D.isEmpty()) {
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            StringBuilder sb = new StringBuilder();
            for (String str : aVar.D) {
                sb.append(str);
            }
            try {
                akVar.q.add(new aj((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
                x.c("attach pageTracingList", new Object[0]);
            } catch (UnsupportedEncodingException e6) {
                e6.printStackTrace();
            }
        }
        if (crashDetailBean.U != null && crashDetailBean.U.length > 0) {
            if (akVar.q == null) {
                akVar.q = new ArrayList<>();
            }
            akVar.q.add(new aj((byte) 1, "userExtraByteData", crashDetailBean.U));
            x.c("attach extraData", new Object[0]);
        }
        akVar.r = new HashMap();
        Map<String, String> map = akVar.r;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(crashDetailBean.C);
        map.put("A9", sb2.toString());
        Map<String, String> map2 = akVar.r;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(crashDetailBean.D);
        map2.put("A11", sb3.toString());
        Map<String, String> map3 = akVar.r;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(crashDetailBean.E);
        map3.put("A10", sb4.toString());
        akVar.r.put("A23", crashDetailBean.f);
        akVar.r.put("A7", aVar.g);
        akVar.r.put("A6", aVar.n());
        akVar.r.put("A5", aVar.m());
        akVar.r.put("A22", aVar.h());
        Map<String, String> map4 = akVar.r;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(crashDetailBean.G);
        map4.put("A2", sb5.toString());
        Map<String, String> map5 = akVar.r;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(crashDetailBean.F);
        map5.put("A1", sb6.toString());
        akVar.r.put("A24", aVar.i);
        Map<String, String> map6 = akVar.r;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(crashDetailBean.H);
        map6.put("A17", sb7.toString());
        akVar.r.put("A25", aVar.h());
        akVar.r.put("A15", aVar.q());
        Map<String, String> map7 = akVar.r;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(aVar.r());
        map7.put("A13", sb8.toString());
        akVar.r.put("A34", crashDetailBean.A);
        if (aVar.y != null) {
            akVar.r.put("productIdentify", aVar.y);
        }
        try {
            akVar.r.put("A26", URLEncoder.encode(crashDetailBean.I, "utf-8"));
        } catch (UnsupportedEncodingException e7) {
            e7.printStackTrace();
        }
        if (crashDetailBean.b == 1) {
            akVar.r.put("A27", crashDetailBean.K);
            akVar.r.put("A28", crashDetailBean.J);
            Map<String, String> map8 = akVar.r;
            StringBuilder sb9 = new StringBuilder();
            sb9.append(crashDetailBean.k);
            map8.put("A29", sb9.toString());
        }
        akVar.r.put("A30", crashDetailBean.L);
        Map<String, String> map9 = akVar.r;
        StringBuilder sb10 = new StringBuilder();
        sb10.append(crashDetailBean.M);
        map9.put("A18", sb10.toString());
        Map<String, String> map10 = akVar.r;
        StringBuilder sb11 = new StringBuilder();
        sb11.append(!crashDetailBean.N);
        map10.put("A36", sb11.toString());
        Map<String, String> map11 = akVar.r;
        StringBuilder sb12 = new StringBuilder();
        sb12.append(aVar.r);
        map11.put("F02", sb12.toString());
        Map<String, String> map12 = akVar.r;
        StringBuilder sb13 = new StringBuilder();
        sb13.append(aVar.s);
        map12.put("F03", sb13.toString());
        akVar.r.put("F04", aVar.e());
        Map<String, String> map13 = akVar.r;
        StringBuilder sb14 = new StringBuilder();
        sb14.append(aVar.t);
        map13.put("F05", sb14.toString());
        akVar.r.put("F06", aVar.q);
        akVar.r.put("F08", aVar.w);
        akVar.r.put("F09", aVar.x);
        Map<String, String> map14 = akVar.r;
        StringBuilder sb15 = new StringBuilder();
        sb15.append(aVar.u);
        map14.put("F10", sb15.toString());
        if (crashDetailBean.Q >= 0) {
            Map<String, String> map15 = akVar.r;
            StringBuilder sb16 = new StringBuilder();
            sb16.append(crashDetailBean.Q);
            map15.put("C01", sb16.toString());
        }
        if (crashDetailBean.R >= 0) {
            Map<String, String> map16 = akVar.r;
            StringBuilder sb17 = new StringBuilder();
            sb17.append(crashDetailBean.R);
            map16.put("C02", sb17.toString());
        }
        if (crashDetailBean.S != null && crashDetailBean.S.size() > 0) {
            for (Map.Entry<String, String> entry2 : crashDetailBean.S.entrySet()) {
                akVar.r.put("C03_" + entry2.getKey(), entry2.getValue());
            }
        }
        if (crashDetailBean.T != null && crashDetailBean.T.size() > 0) {
            for (Map.Entry<String, String> entry3 : crashDetailBean.T.entrySet()) {
                akVar.r.put("C04_" + entry3.getKey(), entry3.getValue());
            }
        }
        akVar.s = null;
        if (crashDetailBean.O != null && crashDetailBean.O.size() > 0) {
            akVar.s = crashDetailBean.O;
            x.a("setted message size %d", Integer.valueOf(akVar.s.size()));
        }
        x.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", crashDetailBean.n, crashDetailBean.f35142c, aVar.e(), Long.valueOf((crashDetailBean.r - crashDetailBean.M) / 1000), Boolean.valueOf(crashDetailBean.k), Boolean.valueOf(crashDetailBean.N), Boolean.valueOf(crashDetailBean.j), Boolean.valueOf(crashDetailBean.b == 1), Integer.valueOf(crashDetailBean.t), crashDetailBean.s, Boolean.valueOf(crashDetailBean.d), Integer.valueOf(akVar.r.size()));
        return akVar;
    }

    private static List<a> a(List<a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            if (aVar.d && aVar.b <= currentTimeMillis - 86400000) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
        if (b == null) {
            return;
        }
        x.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        x.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        x.e("# PKG NAME: %s", b.f35130c);
        x.e("# APP VER: %s", b.k);
        x.e("# SDK VER: %s", b.f);
        x.e("# LAUNCH TIME: %s", z.a(new Date(com.tencent.bugly.crashreport.common.info.a.b().f35129a)));
        x.e("# CRASH TYPE: %s", str);
        x.e("# CRASH TIME: %s", str2);
        x.e("# CRASH PROCESS: %s", str3);
        x.e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            x.e("# REPORT ID: %s", crashDetailBean.f35142c);
            x.e("# CRASH DEVICE: %s %s", b.h, b.r().booleanValue() ? "ROOTED" : "UNROOT");
            x.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
            x.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
            if (!z.a(crashDetailBean.K)) {
                x.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.K, crashDetailBean.J);
            } else if (crashDetailBean.b == 3) {
                if (crashDetailBean.P == null) {
                    str6 = com.igexin.push.core.b.l;
                } else {
                    str6 = crashDetailBean.P.get("BUGLY_CR_01");
                }
                x.e("# EXCEPTION ANR MESSAGE:\n %s", str6);
            }
        }
        if (!z.a(str5)) {
            x.e("# CRASH STACK: ", new Object[0]);
            x.e(str5, new Object[0]);
        }
        x.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }

    public static void a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            x.c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                x.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f35142c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j));
                crashDetailBean.l++;
                crashDetailBean.d = z;
                x.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f35142c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j));
            }
            for (CrashDetailBean crashDetailBean2 : list) {
                c.a().a(crashDetailBean2);
            }
            x.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        x.b("[crash] upload fail.", new Object[0]);
    }

    private static a b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            a aVar = new a();
            aVar.f35143a = cursor.getLong(cursor.getColumnIndex("_id"));
            aVar.b = cursor.getLong(cursor.getColumnIndex("_tm"));
            aVar.f35144c = cursor.getString(cursor.getColumnIndex("_s1"));
            aVar.d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            boolean z = false;
            if (cursor.getInt(cursor.getColumnIndex("_me")) == 1) {
                z = true;
            }
            aVar.e = z;
            aVar.f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return aVar;
        } catch (Throwable th) {
            if (x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private List<a> b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor a2 = p.a().a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
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
                sb.append("_id in ");
                sb.append("(");
                int i = 0;
                while (a2.moveToNext()) {
                    a b = b(a2);
                    if (b != null) {
                        arrayList.add(b);
                    } else {
                        sb.append(a2.getLong(a2.getColumnIndex("_id")));
                        sb.append(",");
                        i++;
                    }
                }
                StringBuilder sb2 = sb;
                if (sb.toString().contains(",")) {
                    sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb2.append(")");
                String sb3 = sb2.toString();
                sb2.setLength(0);
                if (i > 0) {
                    x.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(p.a().a("t_cr", sb3, (String[]) null, (o) null, true)));
                }
                if (a2 != null) {
                    a2.close();
                }
                return arrayList;
            } catch (Throwable th) {
                cursor = a2;
                th = th;
                try {
                    if (!x.a(th)) {
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

    /* JADX WARN: Finally extract failed */
    private List<CrashDetailBean> b(List<a> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in ");
        sb.append("(");
        for (a aVar : list) {
            sb.append(aVar.f35143a);
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
            Cursor a2 = p.a().a("t_cr", null, sb3, null, null, true);
            if (a2 == null) {
                if (a2 != null) {
                    a2.close();
                    return null;
                }
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb2.append("_id in ");
                sb2.append("(");
                int i = 0;
                while (a2.moveToNext()) {
                    CrashDetailBean a3 = a(a2);
                    if (a3 != null) {
                        arrayList.add(a3);
                    } else {
                        sb2.append(a2.getLong(a2.getColumnIndex("_id")));
                        sb2.append(",");
                        i++;
                    }
                }
                StringBuilder sb4 = sb2;
                if (sb2.toString().contains(",")) {
                    sb4 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
                }
                sb4.append(")");
                String sb5 = sb4.toString();
                if (i > 0) {
                    x.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(p.a().a("t_cr", sb5, (String[]) null, (o) null, true)));
                }
                if (a2 != null) {
                    a2.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = a2;
                try {
                    if (!x.a(th)) {
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

    private static void c(List<a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in ");
        sb.append("(");
        for (a aVar : list) {
            sb.append(aVar.f35143a);
            sb.append(",");
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        sb2.append(")");
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            x.c("deleted %s data %d", "t_cr", Integer.valueOf(p.a().a("t_cr", sb3, (String[]) null, (o) null, true)));
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb.append(" or _id");
                    sb.append(" = ");
                    sb.append(crashDetailBean.f35141a);
                }
                String sb2 = sb.toString();
                String str = sb2;
                if (sb2.length() > 0) {
                    str = sb2.substring(4);
                }
                sb.setLength(0);
                x.c("deleted %s data %d", "t_cr", Integer.valueOf(p.a().a("t_cr", str, (String[]) null, (o) null, true)));
            } catch (Throwable th) {
                if (x.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    private static ContentValues f(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.f35141a > 0) {
                contentValues.put("_id", Long.valueOf(crashDetailBean.f35141a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.r));
            contentValues.put("_s1", crashDetailBean.u);
            contentValues.put("_up", Integer.valueOf(crashDetailBean.d ? 1 : 0));
            contentValues.put("_me", Integer.valueOf(crashDetailBean.j ? 1 : 0));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.l));
            contentValues.put("_dt", z.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public final List<CrashDetailBean> a() {
        StrategyBean c2 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (c2 == null) {
            x.d("have not synced remote!", new Object[0]);
            return null;
        } else if (!c2.e) {
            x.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            x.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long b = z.b();
            List<a> b2 = b();
            x.c("Size of crash list loaded from DB: %s", Integer.valueOf(b2.size()));
            if (b2 == null || b2.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a(b2));
            b2.removeAll(arrayList);
            Iterator<a> it = b2.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.b < b - c.g) {
                    it.remove();
                    arrayList.add(next);
                } else if (next.d) {
                    if (next.b >= currentTimeMillis - 86400000) {
                        it.remove();
                    } else if (!next.e) {
                        it.remove();
                        arrayList.add(next);
                    }
                } else if (next.f >= 3 && next.b < currentTimeMillis - 86400000) {
                    it.remove();
                    arrayList.add(next);
                }
            }
            if (arrayList.size() > 0) {
                c(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            List<CrashDetailBean> b3 = b(b2);
            if (b3 != null && b3.size() > 0) {
                String str = com.tencent.bugly.crashreport.common.info.a.b().k;
                Iterator<CrashDetailBean> it2 = b3.iterator();
                while (it2.hasNext()) {
                    CrashDetailBean next2 = it2.next();
                    if (!str.equals(next2.f)) {
                        it2.remove();
                        arrayList2.add(next2);
                    }
                }
            }
            if (arrayList2.size() > 0) {
                d(arrayList2);
            }
            return b3;
        }
    }

    public final void a(CrashDetailBean crashDetailBean, long j, boolean z) {
        if (c.l) {
            x.a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, m.ag, z, crashDetailBean.b == 7, z);
        }
    }

    public final void a(final List<CrashDetailBean> list, long j, boolean z, boolean z2, boolean z3) {
        u uVar;
        al alVar;
        if (com.tencent.bugly.crashreport.common.info.a.a(this.b).e && (uVar = this.f35160c) != null) {
            if (z3 || uVar.b(c.f35162a)) {
                StrategyBean c2 = this.e.c();
                if (!c2.e) {
                    x.d("remote report is disable!", new Object[0]);
                    x.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
                } else if (list == null || list.size() == 0) {
                } else {
                    try {
                        String str = c2.q;
                        String str2 = StrategyBean.b;
                        Context context = this.b;
                        com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
                        if (context != null && list != null && list.size() != 0 && b != null) {
                            al alVar2 = new al();
                            alVar2.f35370a = new ArrayList<>();
                            Iterator<CrashDetailBean> it = list.iterator();
                            while (true) {
                                alVar = alVar2;
                                if (!it.hasNext()) {
                                    break;
                                }
                                alVar2.f35370a.add(a(context, it.next(), b));
                            }
                        } else {
                            x.d("enEXPPkg args == null!", new Object[0]);
                            alVar = null;
                        }
                        if (alVar == null) {
                            x.d("create eupPkg fail!", new Object[0]);
                            return;
                        }
                        byte[] a2 = com.tencent.bugly.proguard.a.a((k) alVar);
                        if (a2 == null) {
                            x.d("send encode fail!", new Object[0]);
                            return;
                        }
                        am a3 = com.tencent.bugly.proguard.a.a(this.b, 830, a2);
                        if (a3 == null) {
                            x.d("request package is null.", new Object[0]);
                            return;
                        }
                        t tVar = new t() { // from class: com.tencent.bugly.crashreport.crash.b.1
                            @Override // com.tencent.bugly.proguard.t
                            public final void a(boolean z4) {
                                b.a(z4, list);
                            }
                        };
                        if (z) {
                            this.f35160c.a(f35159a, a3, str, str2, tVar, j, z2);
                        } else {
                            this.f35160c.a(f35159a, a3, str, str2, tVar, false);
                        }
                    } catch (Throwable th) {
                        x.e("req cr error %s", th.toString());
                        if (x.b(th)) {
                            return;
                        }
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    public final boolean a(CrashDetailBean crashDetailBean) {
        return b(crashDetailBean);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0217, code lost:
        if (r0.size() >= com.tencent.bugly.crashreport.crash.c.f35163c) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(com.tencent.bugly.crashreport.crash.CrashDetailBean r12) {
        /*
            Method dump skipped, instructions count: 669
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.b.b(com.tencent.bugly.crashreport.crash.CrashDetailBean):boolean");
    }

    public final void c(CrashDetailBean crashDetailBean) {
        int i = crashDetailBean.b;
        if (i != 0) {
            if (i != 1) {
                if (i == 3 && !c.a().q()) {
                    return;
                }
            } else if (!c.a().p()) {
                return;
            }
        } else if (!c.a().p()) {
            return;
        }
        if (this.f != null) {
            x.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            int i2 = crashDetailBean.b;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0128 A[Catch: all -> 0x0358, TRY_ENTER, TryCatch #0 {all -> 0x0358, blocks: (B:10:0x0014, B:11:0x0018, B:14:0x004b, B:35:0x008d, B:38:0x00b8, B:40:0x00de, B:46:0x0128, B:48:0x0132, B:50:0x0154, B:52:0x015c, B:54:0x0178, B:56:0x0188, B:58:0x0192, B:60:0x01b6, B:62:0x01c4, B:64:0x01d7, B:67:0x0234, B:65:0x0213, B:68:0x025f, B:70:0x0271, B:76:0x02b7, B:78:0x02c1, B:80:0x02ca, B:82:0x02f6, B:84:0x0308, B:86:0x030e, B:88:0x034c, B:72:0x028e, B:74:0x0295, B:41:0x00f8, B:43:0x00ff, B:18:0x0057, B:22:0x0063, B:26:0x006f, B:29:0x0079, B:32:0x0083), top: B:101:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015c A[Catch: all -> 0x0358, TryCatch #0 {all -> 0x0358, blocks: (B:10:0x0014, B:11:0x0018, B:14:0x004b, B:35:0x008d, B:38:0x00b8, B:40:0x00de, B:46:0x0128, B:48:0x0132, B:50:0x0154, B:52:0x015c, B:54:0x0178, B:56:0x0188, B:58:0x0192, B:60:0x01b6, B:62:0x01c4, B:64:0x01d7, B:67:0x0234, B:65:0x0213, B:68:0x025f, B:70:0x0271, B:76:0x02b7, B:78:0x02c1, B:80:0x02ca, B:82:0x02f6, B:84:0x0308, B:86:0x030e, B:88:0x034c, B:72:0x028e, B:74:0x0295, B:41:0x00f8, B:43:0x00ff, B:18:0x0057, B:22:0x0063, B:26:0x006f, B:29:0x0079, B:32:0x0083), top: B:101:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0271 A[Catch: all -> 0x0358, TRY_LEAVE, TryCatch #0 {all -> 0x0358, blocks: (B:10:0x0014, B:11:0x0018, B:14:0x004b, B:35:0x008d, B:38:0x00b8, B:40:0x00de, B:46:0x0128, B:48:0x0132, B:50:0x0154, B:52:0x015c, B:54:0x0178, B:56:0x0188, B:58:0x0192, B:60:0x01b6, B:62:0x01c4, B:64:0x01d7, B:67:0x0234, B:65:0x0213, B:68:0x025f, B:70:0x0271, B:76:0x02b7, B:78:0x02c1, B:80:0x02ca, B:82:0x02f6, B:84:0x0308, B:86:0x030e, B:88:0x034c, B:72:0x028e, B:74:0x0295, B:41:0x00f8, B:43:0x00ff, B:18:0x0057, B:22:0x0063, B:26:0x006f, B:29:0x0079, B:32:0x0083), top: B:101:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02c1 A[Catch: all -> 0x0358, TRY_ENTER, TryCatch #0 {all -> 0x0358, blocks: (B:10:0x0014, B:11:0x0018, B:14:0x004b, B:35:0x008d, B:38:0x00b8, B:40:0x00de, B:46:0x0128, B:48:0x0132, B:50:0x0154, B:52:0x015c, B:54:0x0178, B:56:0x0188, B:58:0x0192, B:60:0x01b6, B:62:0x01c4, B:64:0x01d7, B:67:0x0234, B:65:0x0213, B:68:0x025f, B:70:0x0271, B:76:0x02b7, B:78:0x02c1, B:80:0x02ca, B:82:0x02f6, B:84:0x0308, B:86:0x030e, B:88:0x034c, B:72:0x028e, B:74:0x0295, B:41:0x00f8, B:43:0x00ff, B:18:0x0057, B:22:0x0063, B:26:0x006f, B:29:0x0079, B:32:0x0083), top: B:101:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x030e A[Catch: all -> 0x0358, TryCatch #0 {all -> 0x0358, blocks: (B:10:0x0014, B:11:0x0018, B:14:0x004b, B:35:0x008d, B:38:0x00b8, B:40:0x00de, B:46:0x0128, B:48:0x0132, B:50:0x0154, B:52:0x015c, B:54:0x0178, B:56:0x0188, B:58:0x0192, B:60:0x01b6, B:62:0x01c4, B:64:0x01d7, B:67:0x0234, B:65:0x0213, B:68:0x025f, B:70:0x0271, B:76:0x02b7, B:78:0x02c1, B:80:0x02ca, B:82:0x02f6, B:84:0x0308, B:86:0x030e, B:88:0x034c, B:72:0x028e, B:74:0x0295, B:41:0x00f8, B:43:0x00ff, B:18:0x0057, B:22:0x0063, B:26:0x006f, B:29:0x0079, B:32:0x0083), top: B:101:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(com.tencent.bugly.crashreport.crash.CrashDetailBean r7) {
        /*
            Method dump skipped, instructions count: 918
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.b.d(com.tencent.bugly.crashreport.crash.CrashDetailBean):void");
    }

    public final void e(CrashDetailBean crashDetailBean) {
        ContentValues f;
        if (crashDetailBean == null || (f = f(crashDetailBean)) == null) {
            return;
        }
        long a2 = p.a().a("t_cr", f, (o) null, true);
        if (a2 >= 0) {
            x.c("insert %s success!", "t_cr");
            crashDetailBean.f35141a = a2;
        }
    }
}
