package com.tencent.bugly.idasc.proguard;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/bd.class */
public final class bd implements NativeExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f35289a;
    private final as b;

    /* renamed from: c  reason: collision with root package name */
    private final aa f35290c;
    private final ac d;

    public bd(Context context, aa aaVar, as asVar, ac acVar) {
        this.f35289a = context;
        this.b = asVar;
        this.f35290c = aaVar;
        this.d = acVar;
    }

    private static Map<String, String> a(String[] strArr) {
        HashMap hashMap = new HashMap(strArr == null ? 1 : strArr.length);
        if (strArr != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= strArr.length) {
                    break;
                }
                String str = strArr[i2];
                if (str != null) {
                    al.a("Extra message[%d]: %s", Integer.valueOf(i2), str);
                    String[] split = str.split("=");
                    if (split.length == 2) {
                        hashMap.put(split[0], split[1]);
                    } else {
                        al.d("bad extraMsg %s", str);
                    }
                }
                i = i2 + 1;
            }
        } else {
            al.c("not found extraMsg", new Object[0]);
        }
        return hashMap;
    }

    @Override // com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler
    public final boolean getAndUpdateAnrState() {
        if (ay.a() == null) {
            return false;
        }
        ay a2 = ay.a();
        if (a2.f35277a.get()) {
            al.c("anr is processing, return", new Object[0]);
            return false;
        }
        ActivityManager activityManager = a2.b;
        if (!((z.a(activityManager) || az.a(activityManager, 0L) == null) ? false : true)) {
            al.c("proc is not in anr, wait next check", new Object[0]);
            return false;
        } else if (a2.a(System.currentTimeMillis())) {
            return false;
        } else {
            return a2.a(true);
        }
    }

    @Override // com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        al.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e6 A[Catch: all -> 0x033a, TryCatch #2 {all -> 0x033a, blocks: (B:4:0x000f, B:5:0x0042, B:7:0x0063, B:9:0x006d, B:11:0x007d, B:13:0x0096, B:16:0x00a1, B:19:0x00bc, B:21:0x00e6, B:23:0x0118, B:25:0x014b, B:27:0x0179, B:29:0x0184, B:31:0x0194, B:33:0x019e, B:39:0x0207, B:42:0x0212, B:44:0x021f, B:24:0x0120, B:17:0x00b3), top: B:89:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0120 A[Catch: all -> 0x033a, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x033a, blocks: (B:4:0x000f, B:5:0x0042, B:7:0x0063, B:9:0x006d, B:11:0x007d, B:13:0x0096, B:16:0x00a1, B:19:0x00bc, B:21:0x00e6, B:23:0x0118, B:25:0x014b, B:27:0x0179, B:29:0x0184, B:31:0x0194, B:33:0x019e, B:39:0x0207, B:42:0x0212, B:44:0x021f, B:24:0x0120, B:17:0x00b3), top: B:89:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0179 A[Catch: all -> 0x033a, TryCatch #2 {all -> 0x033a, blocks: (B:4:0x000f, B:5:0x0042, B:7:0x0063, B:9:0x006d, B:11:0x007d, B:13:0x0096, B:16:0x00a1, B:19:0x00bc, B:21:0x00e6, B:23:0x0118, B:25:0x014b, B:27:0x0179, B:29:0x0184, B:31:0x0194, B:33:0x019e, B:39:0x0207, B:42:0x0212, B:44:0x021f, B:24:0x0120, B:17:0x00b3), top: B:89:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0284 A[Catch: all -> 0x0335, TRY_ENTER, TryCatch #1 {all -> 0x0335, blocks: (B:46:0x0256, B:48:0x0284, B:50:0x028f), top: B:88:0x0256 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x028f A[Catch: all -> 0x0335, TRY_ENTER, TryCatch #1 {all -> 0x0335, blocks: (B:46:0x0256, B:48:0x0284, B:50:0x028f), top: B:88:0x0256 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleNativeException2(int r20, int r21, long r22, long r24, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, int r30, java.lang.String r31, int r32, int r33, int r34, java.lang.String r35, java.lang.String r36, java.lang.String[] r37) {
        /*
            Method dump skipped, instructions count: 876
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.bd.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i;
        String str12;
        int indexOf;
        boolean i2 = at.a().i();
        if (i2) {
            al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.b = 1;
        crashDetailBean.e = this.f35290c.g();
        crashDetailBean.f = this.f35290c.o;
        crashDetailBean.g = this.f35290c.q();
        crashDetailBean.m = this.f35290c.f();
        crashDetailBean.n = str3;
        crashDetailBean.o = i2 ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.p = str4;
        if (str5 == null) {
            str5 = "";
        }
        crashDetailBean.q = str5;
        crashDetailBean.r = j;
        crashDetailBean.u = ap.c(crashDetailBean.q.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.L = this.f35290c.s();
        crashDetailBean.h = this.f35290c.p();
        crashDetailBean.i = this.f35290c.A();
        crashDetailBean.v = str8;
        String dumpFilePath = NativeCrashHandler.getInstance() != null ? NativeCrashHandler.getDumpFilePath() : null;
        String a2 = be.a(dumpFilePath, str8);
        if (!ap.b(a2)) {
            crashDetailBean.Z = a2;
        }
        crashDetailBean.aa = be.b(dumpFilePath);
        crashDetailBean.w = be.a(str9, at.f, at.k, at.p);
        crashDetailBean.x = be.a(str10, at.f, null, true);
        crashDetailBean.N = str7;
        crashDetailBean.O = str6;
        crashDetailBean.P = str11;
        crashDetailBean.F = this.f35290c.k();
        crashDetailBean.G = this.f35290c.j();
        crashDetailBean.H = this.f35290c.l();
        crashDetailBean.I = ab.b(this.f35289a);
        crashDetailBean.J = ab.g();
        crashDetailBean.K = ab.h();
        if (!z) {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "This crash occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.Q = -1L;
            crashDetailBean.U = -1;
            crashDetailBean.V = -1;
            crashDetailBean.W = map;
            crashDetailBean.X = this.f35290c.y();
            crashDetailBean.z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.y = bArr;
            }
            return crashDetailBean;
        }
        crashDetailBean.C = ab.j();
        crashDetailBean.D = ab.f();
        crashDetailBean.E = ab.l();
        crashDetailBean.y = ao.a();
        crashDetailBean.Q = this.f35290c.f35211a;
        crashDetailBean.R = this.f35290c.a();
        crashDetailBean.z = ap.a(this.f35290c.Q, at.h);
        int indexOf2 = crashDetailBean.q.indexOf("java:\n");
        if (indexOf2 > 0 && (i = indexOf2 + 6) < crashDetailBean.q.length()) {
            String str13 = crashDetailBean.q;
            String substring = str13.substring(i, str13.length() - 1);
            if (substring.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B) && (indexOf = (str12 = crashDetailBean.z.get(crashDetailBean.B)).indexOf(substring)) > 0) {
                String substring2 = str12.substring(indexOf);
                crashDetailBean.z.put(crashDetailBean.B, substring2);
                crashDetailBean.q = crashDetailBean.q.substring(0, i);
                crashDetailBean.q += substring2;
            }
        }
        if (str == null) {
            crashDetailBean.A = this.f35290c.d;
        }
        crashDetailBean.U = this.f35290c.z();
        crashDetailBean.V = this.f35290c.x;
        crashDetailBean.W = this.f35290c.t();
        crashDetailBean.X = this.f35290c.y();
        return crashDetailBean;
    }
}
