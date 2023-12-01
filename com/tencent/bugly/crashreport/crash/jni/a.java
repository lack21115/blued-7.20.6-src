package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/crash/jni/a.class */
public final class a implements NativeExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f21491a;
    private final com.tencent.bugly.crashreport.crash.b b;

    /* renamed from: c  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f21492c;
    private final com.tencent.bugly.crashreport.common.strategy.a d;

    public a(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        this.f21491a = context;
        this.b = bVar;
        this.f21492c = aVar;
        this.d = aVar2;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        x.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0431 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01c4 A[Catch: all -> 0x0405, TryCatch #1 {all -> 0x0405, blocks: (B:3:0x000a, B:6:0x001a, B:15:0x00a1, B:18:0x00b1, B:23:0x00c3, B:25:0x00e9, B:26:0x00fc, B:29:0x011a, B:31:0x012b, B:33:0x0135, B:35:0x0145, B:37:0x0158, B:40:0x0163, B:43:0x0180, B:45:0x0191, B:48:0x019c, B:50:0x01bc, B:52:0x01c4, B:54:0x01dd, B:58:0x021d, B:61:0x028c, B:63:0x02b8, B:65:0x02c3, B:67:0x02d3, B:69:0x02dd, B:59:0x024f, B:41:0x0175, B:27:0x010e, B:10:0x005a, B:12:0x0063, B:14:0x006e), top: B:107:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x021d A[Catch: all -> 0x0405, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0405, blocks: (B:3:0x000a, B:6:0x001a, B:15:0x00a1, B:18:0x00b1, B:23:0x00c3, B:25:0x00e9, B:26:0x00fc, B:29:0x011a, B:31:0x012b, B:33:0x0135, B:35:0x0145, B:37:0x0158, B:40:0x0163, B:43:0x0180, B:45:0x0191, B:48:0x019c, B:50:0x01bc, B:52:0x01c4, B:54:0x01dd, B:58:0x021d, B:61:0x028c, B:63:0x02b8, B:65:0x02c3, B:67:0x02d3, B:69:0x02dd, B:59:0x024f, B:41:0x0175, B:27:0x010e, B:10:0x005a, B:12:0x0063, B:14:0x006e), top: B:107:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02b8 A[Catch: all -> 0x0405, TryCatch #1 {all -> 0x0405, blocks: (B:3:0x000a, B:6:0x001a, B:15:0x00a1, B:18:0x00b1, B:23:0x00c3, B:25:0x00e9, B:26:0x00fc, B:29:0x011a, B:31:0x012b, B:33:0x0135, B:35:0x0145, B:37:0x0158, B:40:0x0163, B:43:0x0180, B:45:0x0191, B:48:0x019c, B:50:0x01bc, B:52:0x01c4, B:54:0x01dd, B:58:0x021d, B:61:0x028c, B:63:0x02b8, B:65:0x02c3, B:67:0x02d3, B:69:0x02dd, B:59:0x024f, B:41:0x0175, B:27:0x010e, B:10:0x005a, B:12:0x0063, B:14:0x006e), top: B:107:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02d3 A[Catch: all -> 0x0405, TRY_ENTER, TryCatch #1 {all -> 0x0405, blocks: (B:3:0x000a, B:6:0x001a, B:15:0x00a1, B:18:0x00b1, B:23:0x00c3, B:25:0x00e9, B:26:0x00fc, B:29:0x011a, B:31:0x012b, B:33:0x0135, B:35:0x0145, B:37:0x0158, B:40:0x0163, B:43:0x0180, B:45:0x0191, B:48:0x019c, B:50:0x01bc, B:52:0x01c4, B:54:0x01dd, B:58:0x021d, B:61:0x028c, B:63:0x02b8, B:65:0x02c3, B:67:0x02d3, B:69:0x02dd, B:59:0x024f, B:41:0x0175, B:27:0x010e, B:10:0x005a, B:12:0x0063, B:14:0x006e), top: B:107:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0362 A[Catch: all -> 0x0400, TRY_ENTER, TryCatch #0 {all -> 0x0400, blocks: (B:71:0x0334, B:73:0x0362, B:75:0x036d), top: B:106:0x0334 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x036d A[Catch: all -> 0x0400, TRY_ENTER, TryCatch #0 {all -> 0x0400, blocks: (B:71:0x0334, B:73:0x0362, B:75:0x036d), top: B:106:0x0334 }] */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleNativeException2(int r20, int r21, long r22, long r24, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, int r30, java.lang.String r31, int r32, int r33, int r34, java.lang.String r35, java.lang.String r36, java.lang.String[] r37) {
        /*
            Method dump skipped, instructions count: 1083
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.a.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i;
        String str12;
        int indexOf;
        boolean l = c.a().l();
        if (l) {
            x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.b = 1;
        crashDetailBean.e = this.f21492c.h();
        crashDetailBean.f = this.f21492c.k;
        crashDetailBean.g = this.f21492c.q();
        crashDetailBean.m = this.f21492c.g();
        crashDetailBean.n = str3;
        crashDetailBean.o = l ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.p = str4;
        if (str5 == null) {
            str5 = "";
        }
        crashDetailBean.q = str5;
        crashDetailBean.r = j;
        crashDetailBean.u = z.a(crashDetailBean.q.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.I = this.f21492c.s();
        crashDetailBean.h = this.f21492c.p();
        crashDetailBean.i = this.f21492c.B();
        crashDetailBean.v = str8;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String a2 = b.a(dumpFilePath, str8);
        if (!z.a(a2)) {
            crashDetailBean.V = a2;
        }
        crashDetailBean.W = b.b(dumpFilePath);
        crashDetailBean.w = b.a(str9, c.e, null, false);
        crashDetailBean.x = b.a(str10, c.e, null, true);
        crashDetailBean.J = str7;
        crashDetailBean.K = str6;
        crashDetailBean.L = str11;
        crashDetailBean.F = this.f21492c.k();
        crashDetailBean.G = this.f21492c.j();
        crashDetailBean.H = this.f21492c.l();
        if (!z) {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.M = -1L;
            crashDetailBean.Q = -1;
            crashDetailBean.R = -1;
            crashDetailBean.S = map;
            crashDetailBean.T = this.f21492c.y();
            crashDetailBean.z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.y = bArr;
            }
            return crashDetailBean;
        }
        crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
        crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
        crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
        if (crashDetailBean.w == null) {
            crashDetailBean.w = z.a(this.f21491a, c.e, (String) null);
        }
        crashDetailBean.y = y.a();
        crashDetailBean.M = this.f21492c.f21438a;
        crashDetailBean.N = this.f21492c.a();
        crashDetailBean.z = z.a(c.f, false);
        int indexOf2 = crashDetailBean.q.indexOf("java:\n");
        if (indexOf2 > 0 && (i = indexOf2 + 6) < crashDetailBean.q.length()) {
            String substring = crashDetailBean.q.substring(i, crashDetailBean.q.length() - 1);
            if (substring.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B) && (indexOf = (str12 = crashDetailBean.z.get(crashDetailBean.B)).indexOf(substring)) > 0) {
                String substring2 = str12.substring(indexOf);
                crashDetailBean.z.put(crashDetailBean.B, substring2);
                crashDetailBean.q = crashDetailBean.q.substring(0, i);
                crashDetailBean.q += substring2;
            }
        }
        if (str == null) {
            crashDetailBean.A = this.f21492c.d;
        }
        this.b.d(crashDetailBean);
        crashDetailBean.Q = this.f21492c.z();
        crashDetailBean.R = this.f21492c.A();
        crashDetailBean.S = this.f21492c.t();
        crashDetailBean.T = this.f21492c.y();
        return crashDetailBean;
    }
}
