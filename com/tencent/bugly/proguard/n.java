package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/n.class */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final long f35391a = System.currentTimeMillis();
    private static n b;

    /* renamed from: c  reason: collision with root package name */
    private Context f35392c;
    private SharedPreferences f;
    private Map<Integer, Map<String, m>> e = new HashMap();
    private String d = com.tencent.bugly.crashreport.common.info.a.b().d;

    private n(Context context) {
        this.f35392c = context;
        this.f = context.getSharedPreferences("crashrecord", 0);
    }

    public static n a() {
        n nVar;
        synchronized (n.class) {
            try {
                nVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }

    public static n a(Context context) {
        n nVar;
        synchronized (n.class) {
            try {
                if (b == null) {
                    b = new n(context);
                }
                nVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e A[Catch: all -> 0x0094, Exception -> 0x00a9, TRY_ENTER, TryCatch #3 {Exception -> 0x00a9, blocks: (B:9:0x0009, B:10:0x0032, B:15:0x004e, B:27:0x007f, B:34:0x008e, B:36:0x0093), top: B:52:0x0009, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T extends java.util.List<?>> void a(int r7, T r8) {
        /*
            r6 = this;
            r0 = r6
            monitor-enter(r0)
            r0 = r8
            if (r0 != 0) goto L9
            r0 = r6
            monitor-exit(r0)
            return
        L9:
            r0 = r6
            android.content.Context r0 = r0.f35392c     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> La9
            java.lang.String r1 = "crashrecord"
            r2 = 0
            java.io.File r0 = r0.getDir(r1, r2)     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> La9
            r9 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> La9
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> La9
            r10 = r0
            r0 = r10
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> La9
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> La9
            r1 = r0
            r2 = r9
            r3 = r10
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> La9
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> La9
            r9 = r0
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L64 java.lang.Throwable -> L94 java.lang.Exception -> La9
            r1 = r0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L64
            r3 = r2
            r4 = r9
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L64
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L64
            r10 = r0
            r0 = r10
            r9 = r0
            r0 = r10
            r1 = r8
            r0.writeObject(r1)     // Catch: java.io.IOException -> L54 java.lang.Throwable -> L89
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> La9
            goto La2
        L54:
            r9 = move-exception
            r0 = r10
            r8 = r0
            r0 = r9
            r10 = r0
            goto L68
        L5e:
            r8 = move-exception
            r0 = 0
            r9 = r0
            goto L8a
        L64:
            r10 = move-exception
            r0 = 0
            r8 = r0
        L68:
            r0 = r8
            r9 = r0
            r0 = r10
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L89
            r0 = r8
            r9 = r0
            java.lang.String r0 = "open record file error"
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L89
            boolean r0 = com.tencent.bugly.proguard.x.a(r0, r1)     // Catch: java.lang.Throwable -> L89
            r0 = r8
            if (r0 == 0) goto L86
            r0 = r8
            r0.close()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> La9
            goto La2
        L86:
            r0 = r6
            monitor-exit(r0)
            return
        L89:
            r8 = move-exception
        L8a:
            r0 = r9
            if (r0 == 0) goto L92
            r0 = r9
            r0.close()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> La9
        L92:
            r0 = r8
            throw r0     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> La9
        L94:
            r8 = move-exception
            goto La5
        L98:
            java.lang.String r0 = "writeCrashRecord error"
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L94
            boolean r0 = com.tencent.bugly.proguard.x.e(r0, r1)     // Catch: java.lang.Throwable -> L94
        La2:
            r0 = r6
            monitor-exit(r0)
            return
        La5:
            r0 = r6
            monitor-exit(r0)
            r0 = r8
            throw r0
        La9:
            r8 = move-exception
            goto L98
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.n.a(int, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i) {
        synchronized (this) {
            try {
                List<m> c2 = c(i);
                if (c2 == null) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (m mVar : c2) {
                    if (mVar.b != null && mVar.b.equalsIgnoreCase(this.d) && mVar.d > 0) {
                        arrayList.add(mVar);
                    }
                    if (mVar.f35390c + 86400000 < currentTimeMillis) {
                        arrayList2.add(mVar);
                    }
                }
                Collections.sort(arrayList);
                if (arrayList.size() < 2) {
                    c2.removeAll(arrayList2);
                    a(i, (int) c2);
                    return false;
                } else if (arrayList.size() <= 0 || ((m) arrayList.get(arrayList.size() - 1)).f35390c + 86400000 >= currentTimeMillis) {
                    return true;
                } else {
                    c2.clear();
                    a(i, (int) c2);
                    return false;
                }
            } catch (Exception e) {
                x.e("isFrequentCrash failed", new Object[0]);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0079, code lost:
        if (r10 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007c, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0096, code lost:
        if (r10 == null) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.io.ObjectInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T extends java.util.List<?>> T c(int r7) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.n.c(int):java.util.List");
    }

    public final void a(int i, final int i2) {
        w.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.n.1
            @Override // java.lang.Runnable
            public final void run() {
                m mVar;
                try {
                    if (TextUtils.isEmpty(n.this.d)) {
                        return;
                    }
                    List c2 = n.this.c(r5);
                    List<m> list = c2;
                    if (c2 == null) {
                        list = new ArrayList();
                    }
                    if (n.this.e.get(Integer.valueOf(r5)) == null) {
                        n.this.e.put(Integer.valueOf(r5), new HashMap());
                    }
                    if (((Map) n.this.e.get(Integer.valueOf(r5))).get(n.this.d) == null) {
                        mVar = new m();
                        mVar.f35389a = r5;
                        mVar.g = n.f35391a;
                        mVar.b = n.this.d;
                        mVar.f = com.tencent.bugly.crashreport.common.info.a.b().k;
                        mVar.e = com.tencent.bugly.crashreport.common.info.a.b().f;
                        mVar.f35390c = System.currentTimeMillis();
                        mVar.d = i2;
                        ((Map) n.this.e.get(Integer.valueOf(r5))).put(n.this.d, mVar);
                    } else {
                        mVar = (m) ((Map) n.this.e.get(Integer.valueOf(r5))).get(n.this.d);
                        mVar.d = i2;
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (m mVar2 : list) {
                        boolean z2 = z;
                        if (mVar2.g == mVar.g) {
                            z2 = z;
                            if (mVar2.b != null) {
                                z2 = z;
                                if (mVar2.b.equalsIgnoreCase(mVar.b)) {
                                    z2 = true;
                                    mVar2.d = mVar.d;
                                }
                            }
                        }
                        if ((mVar2.e == null || mVar2.e.equalsIgnoreCase(mVar.e)) && (mVar2.f == null || mVar2.f.equalsIgnoreCase(mVar.f))) {
                            z = z2;
                            if (mVar2.d <= 0) {
                            }
                        }
                        arrayList.add(mVar2);
                        z = z2;
                    }
                    list.removeAll(arrayList);
                    if (!z) {
                        list.add(mVar);
                    }
                    n.this.a(r5, (int) list);
                } catch (Exception e) {
                    x.e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    public final boolean a(final int i) {
        boolean z;
        synchronized (this) {
            boolean z2 = true;
            try {
                SharedPreferences sharedPreferences = this.f;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append(BridgeUtil.UNDERLINE_STR);
                sb.append(this.d);
                z = sharedPreferences.getBoolean(sb.toString(), true);
                z2 = z;
                w.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.n.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean b2 = n.this.b(i);
                        SharedPreferences.Editor edit = n.this.f.edit();
                        edit.putBoolean(i + BridgeUtil.UNDERLINE_STR + n.this.d, !b2).commit();
                    }
                });
            } catch (Exception e) {
                x.e("canInit error", new Object[0]);
                return z2;
            }
        }
        return z;
    }
}
