package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.util.Pair;
import java.util.Map;
import java.util.UUID;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/aj.class */
public final class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected int f21542a;
    protected long b;

    /* renamed from: c  reason: collision with root package name */
    protected long f21543c;
    private int d;
    private int e;
    private final Context f;
    private final int g;
    private final byte[] h;
    private final aa i;
    private final ac j;
    private final af k;
    private final ai l;
    private final int m;
    private final ah n;
    private final ah o;
    private String p;
    private final String q;
    private final Map<String, String> r;
    private boolean s;

    public aj(Context context, int i, int i2, byte[] bArr, String str, String str2, ah ahVar, int i3, int i4, boolean z) {
        this.d = 2;
        this.e = 30000;
        this.p = null;
        this.f21542a = 0;
        this.b = 0L;
        this.f21543c = 0L;
        this.s = false;
        this.f = context;
        this.i = aa.a(context);
        this.h = bArr;
        this.j = ac.a();
        if (af.f21528a == null) {
            af.f21528a = new af(context);
        }
        this.k = af.f21528a;
        ai a2 = ai.a();
        this.l = a2;
        this.m = i;
        this.p = str;
        this.q = str2;
        this.n = ahVar;
        this.o = a2.f21537a;
        this.g = i2;
        if (i3 > 0) {
            this.d = i3;
        }
        if (i4 > 0) {
            this.e = i4;
        }
        this.s = z;
        this.r = null;
    }

    public aj(Context context, int i, int i2, byte[] bArr, String str, String str2, ah ahVar, boolean z) {
        this(context, i, i2, bArr, str, str2, ahVar, 2, 30000, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.Pair<java.lang.Boolean, java.lang.Boolean> a(java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.aj.a(java.util.Map):android.util.Pair");
    }

    private Pair<Boolean, Boolean> a(byte[] bArr, Map<String, String> map) {
        if (bArr == null) {
            a("Failed to upload for no response!");
            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
        }
        al.c("[Upload] Received %d bytes", Integer.valueOf(bArr.length));
        if (bArr.length != 0) {
            Boolean bool = Boolean.TRUE;
            return new Pair<>(bool, bool);
        }
        a(false, 1, "response data from server is empty");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                al.c("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
            }
        }
        Boolean bool2 = Boolean.FALSE;
        return new Pair<>(bool2, bool2);
    }

    private static void a(String str) {
        al.e("[Upload] Failed to upload(%d): %s", 1, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(boolean r7, int r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.aj.a(boolean, int, java.lang.String):void");
    }

    private static boolean a(br brVar, aa aaVar, ac acVar) {
        if (brVar == null) {
            al.d("resp == null!", new Object[0]);
            return false;
        } else if (brVar.f21617a != 0) {
            al.e("resp result error %d", Byte.valueOf(brVar.f21617a));
            return false;
        } else {
            try {
                if (!ap.b(brVar.g) && !aa.b().i().equals(brVar.g)) {
                    w.a().a(ac.f21525a, "device", brVar.g.getBytes("UTF-8"), true);
                    aaVar.d(brVar.g);
                }
            } catch (Throwable th) {
                al.a(th);
            }
            aaVar.m = brVar.e;
            if (brVar.b == 510) {
                if (brVar.f21618c == null) {
                    al.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(brVar.b));
                    return false;
                }
                bt btVar = (bt) ae.a(brVar.f21618c, bt.class);
                if (btVar == null) {
                    al.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(brVar.b));
                    return false;
                }
                acVar.a(btVar);
                return true;
            }
            return true;
        }
    }

    private static String b(String str) {
        if (ap.b(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            al.a(th);
            return str;
        }
    }

    public final void a(long j) {
        this.f21542a++;
        this.b += j;
    }

    public final void b(long j) {
        this.f21543c += j;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x0361 A[LOOP:0: B:38:0x0156->B:91:0x0361, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x036c A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 877
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.aj.run():void");
    }
}
