package com.tencent.bugly.proguard;

import android.content.Context;
import java.util.Map;
import java.util.UUID;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/v.class */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private int f35410a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f35411c;
    private final int d;
    private final byte[] e;
    private final com.tencent.bugly.crashreport.common.info.a f;
    private final com.tencent.bugly.crashreport.common.strategy.a g;
    private final s h;
    private final u i;
    private final int j;
    private final t k;
    private final t l;
    private String m;
    private final String n;
    private final Map<String, String> o;
    private int p;
    private long q;
    private long r;
    private boolean s;

    public v(Context context, int i, int i2, byte[] bArr, String str, String str2, t tVar, int i3, int i4, boolean z, Map<String, String> map) {
        this.f35410a = 2;
        this.b = 30000;
        this.m = null;
        this.p = 0;
        this.q = 0L;
        this.r = 0L;
        this.s = false;
        this.f35411c = context;
        this.f = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.e = bArr;
        this.g = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.h = s.a(context);
        this.i = u.a();
        this.j = i;
        this.m = str;
        this.n = str2;
        this.k = tVar;
        this.l = null;
        this.d = i2;
        if (i3 > 0) {
            this.f35410a = i3;
        }
        if (i4 > 0) {
            this.b = i4;
        }
        this.s = z;
        this.o = map;
    }

    public v(Context context, int i, int i2, byte[] bArr, String str, String str2, t tVar, boolean z, boolean z2) {
        this(context, i, i2, bArr, str, str2, tVar, 2, 30000, z2, null);
    }

    private static String a(String str) {
        if (z.a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            x.a(th);
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.tencent.bugly.proguard.an r7, boolean r8, int r9, java.lang.String r10) {
        /*
            r6 = this;
            r0 = r6
            int r0 = r0.d
            r11 = r0
            r0 = r11
            r1 = 630(0x276, float:8.83E-43)
            if (r0 == r1) goto L35
            r0 = r11
            r1 = 640(0x280, float:8.97E-43)
            if (r0 == r1) goto L2f
            r0 = r11
            r1 = 830(0x33e, float:1.163E-42)
            if (r0 == r1) goto L35
            r0 = r11
            r1 = 840(0x348, float:1.177E-42)
            if (r0 == r1) goto L2f
            r0 = r11
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r7 = r0
            goto L38
        L2f:
            java.lang.String r0 = "userinfo"
            r7 = r0
            goto L38
        L35:
            java.lang.String r0 = "crash"
            r7 = r0
        L38:
            r0 = r8
            if (r0 == 0) goto L4d
            java.lang.String r0 = "[Upload] Success: %s"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = r1
            r3 = 0
            r4 = r7
            r2[r3] = r4
            boolean r0 = com.tencent.bugly.proguard.x.a(r0, r1)
            goto L67
        L4d:
            java.lang.String r0 = "[Upload] Failed to upload(%d) %s: %s"
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = r1
            r3 = 0
            r4 = r9
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            r2 = r1
            r3 = 1
            r4 = r7
            r2[r3] = r4
            r2 = r1
            r3 = 2
            r4 = r10
            r2[r3] = r4
            boolean r0 = com.tencent.bugly.proguard.x.e(r0, r1)
        L67:
            r0 = r6
            long r0 = r0.q
            r1 = r6
            long r1 = r1.r
            long r0 = r0 + r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto La1
            r0 = r6
            com.tencent.bugly.proguard.u r0 = r0.i
            r1 = r6
            boolean r1 = r1.s
            long r0 = r0.a(r1)
            r12 = r0
            r0 = r6
            long r0 = r0.q
            r14 = r0
            r0 = r6
            long r0 = r0.r
            r16 = r0
            r0 = r6
            com.tencent.bugly.proguard.u r0 = r0.i
            r1 = r12
            r2 = r14
            long r1 = r1 + r2
            r2 = r16
            long r1 = r1 + r2
            r2 = r6
            boolean r2 = r2.s
            r0.a(r1, r2)
        La1:
            r0 = r6
            com.tencent.bugly.proguard.t r0 = r0.k
            r7 = r0
            r0 = r7
            if (r0 == 0) goto Lb1
            r0 = r7
            r1 = r8
            r0.a(r1)
        Lb1:
            r0 = r6
            com.tencent.bugly.proguard.t r0 = r0.l
            r7 = r0
            r0 = r7
            if (r0 == 0) goto Lc1
            r0 = r7
            r1 = r8
            r0.a(r1)
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.v.a(com.tencent.bugly.proguard.an, boolean, int, java.lang.String):void");
    }

    private static boolean a(an anVar, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        if (anVar == null) {
            x.d("resp == null!", new Object[0]);
            return false;
        } else if (anVar.f35373a != 0) {
            x.e("resp result error %d", Byte.valueOf(anVar.f35373a));
            return false;
        } else {
            try {
                if (!z.a(anVar.e) && !com.tencent.bugly.crashreport.common.info.a.b().i().equals(anVar.e)) {
                    p.a().a(com.tencent.bugly.crashreport.common.strategy.a.f35135a, "device", anVar.e.getBytes("UTF-8"), (o) null, true);
                    aVar.e(anVar.e);
                }
            } catch (Throwable th) {
                x.a(th);
            }
            aVar.j = anVar.d;
            if (anVar.b == 510) {
                if (anVar.f35374c == null) {
                    x.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(anVar.b));
                    return false;
                }
                ap apVar = (ap) a.a(anVar.f35374c, ap.class);
                if (apVar == null) {
                    x.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(anVar.b));
                    return false;
                }
                aVar2.a(apVar);
                return true;
            }
            return true;
        }
    }

    public final void a(long j) {
        this.p++;
        this.q += j;
    }

    public final void b(long j) {
        this.r += j;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x03a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x030b A[Catch: all -> 0x0550, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0550, blocks: (B:3:0x0004, B:5:0x0023, B:9:0x0032, B:12:0x003b, B:14:0x0056, B:16:0x005d, B:18:0x0064, B:21:0x006e, B:23:0x007c, B:25:0x0087, B:27:0x00db, B:29:0x00e8, B:31:0x012e, B:33:0x013b, B:37:0x014b, B:39:0x0156, B:42:0x0182, B:47:0x0194, B:49:0x01b3, B:51:0x01bc, B:53:0x01d7, B:55:0x01fb, B:57:0x0238, B:59:0x024d, B:60:0x0259, B:62:0x0267, B:65:0x0274, B:67:0x0285, B:79:0x030b, B:81:0x0345, B:83:0x0355, B:85:0x035d, B:86:0x0392, B:91:0x03d9, B:93:0x03f9, B:95:0x0413, B:97:0x0423, B:99:0x042b, B:100:0x0459, B:104:0x0469, B:106:0x0474, B:110:0x0489, B:112:0x0495, B:114:0x04a0, B:120:0x04bd, B:122:0x04e3, B:124:0x04ef, B:118:0x04b3, B:126:0x04fb, B:68:0x0299, B:70:0x02a5, B:71:0x02b8, B:73:0x02d1, B:74:0x02e4, B:76:0x02f9, B:127:0x052e, B:129:0x053a, B:131:0x0545), top: B:148:0x0004 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.v.run():void");
    }
}
