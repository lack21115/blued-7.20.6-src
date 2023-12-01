package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/DO0IX.class */
public final class DO0IX {

    /* renamed from: a  reason: collision with root package name */
    public static final DO0IX f26176a = new DO0IX();
    public static final Map<Integer, Integer> b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, Integer> f26177c = new ConcurrentHashMap();
    public final Map<Integer, Integer> d = new HashMap();
    public final Map<Integer, Integer> e = new HashMap();
    public final Object f = new Object();
    public CvowV g;
    public fenkF h;

    static {
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put(2, 0);
        hashMap.put(6, 0);
        hashMap.put(3, 0);
        hashMap.put(32, 0);
        hashMap.put(5, 0);
        hashMap.put(4, 0);
        hashMap.put(17, 1);
        hashMap.put(40, 0);
        hashMap.put(43, 0);
        hashMap.put(19, 0);
        hashMap.put(36, 0);
        hashMap.put(114, 0);
        hashMap.put(10001, 0);
        hashMap.put(45, 0);
        hashMap.put(136, 0);
        hashMap.put(139, 0);
        hashMap.put(10002, 0);
        hashMap.put(Integer.valueOf((int) GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR), 0);
        int i = com.tencent.turingcam.oqKCa.f26140a;
        if (i == 105668) {
            hashMap.put(18, 0);
        } else if (i == 105928) {
            hashMap.put(18, 0);
        } else if (i == 108168) {
            hashMap.put(18, 0);
        }
    }

    public final long a(Context context) {
        long j;
        if (this.h.a(context, "501") > 0) {
            return 0L;
        }
        synchronized (this) {
            j = 0;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                c(context);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                j = currentTimeMillis2;
                b(context);
                j = currentTimeMillis2;
            } catch (Throwable th) {
            }
        }
        return j;
    }

    /* JADX WARN: Type inference failed for: r0v39, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    public final String a() {
        HashSet hashSet = new HashSet();
        synchronized (this.f) {
            for (Integer num : this.f26177c.keySet()) {
                if (((Integer) this.f26177c.get(num)).intValue() == 0) {
                    hashSet.add(num);
                }
            }
        }
        Iterator it = hashSet.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            sb.append("" + intValue);
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    public final boolean a(int i) {
        Object obj;
        if (this.f26177c.containsKey(Integer.valueOf(i)) && (obj = this.f26177c.get(Integer.valueOf(i))) != null) {
            try {
                return ((Integer) obj).intValue() != 0;
            } catch (Throwable th) {
                return true;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
        if (r0 <= 0) goto L96;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0200 A[Catch: all -> 0x029e, TRY_ENTER, TryCatch #5 {, blocks: (B:4:0x0002, B:6:0x0014, B:10:0x0029, B:17:0x0047, B:18:0x009d, B:21:0x00ad, B:27:0x00bf, B:30:0x00c6, B:35:0x00e7, B:67:0x0200, B:68:0x0210, B:78:0x0273, B:25:0x00b9, B:69:0x0213, B:70:0x024c, B:75:0x0267, B:76:0x026d), top: B:109:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.content.Context r8, int r9, java.lang.String r10, long r11, java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 709
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.DO0IX.a(android.content.Context, int, java.lang.String, long, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r0 == null) goto L47;
     */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v33, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r0v36, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r0v45, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r0v54, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.DO0IX.b(android.content.Context):void");
    }

    public final void c(Context context) {
        try {
            if (f26176a.a(context, uAnWx.f, this.g.b(), this.h.a(context, "501"), rBDKv.f26294a.a(context).f26311a, CFgXs.a())) {
                fenkF fenkf = this.h;
                fenkf.getClass();
                fenkf.a(context, "501", "" + System.currentTimeMillis(), true);
            }
        } catch (Throwable th) {
        }
    }
}
