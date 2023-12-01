package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/u.class */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final long f21651a = System.currentTimeMillis();
    private static u b;

    /* renamed from: c  reason: collision with root package name */
    private Context f21652c;
    private SharedPreferences f;
    private Map<Integer, Map<String, t>> e = new HashMap();
    private String d = aa.b().d;

    private u(Context context) {
        this.f21652c = context;
        this.f = context.getSharedPreferences("crashrecord", 0);
    }

    public static u a() {
        u uVar;
        synchronized (u.class) {
            try {
                uVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uVar;
    }

    public static u a(Context context) {
        u uVar;
        synchronized (u.class) {
            try {
                if (b == null) {
                    b = new u(context);
                }
                uVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends List<?>> void a(int i, T t) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        synchronized (this) {
            if (t == null) {
                return;
            }
            try {
                try {
                    try {
                        objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(new File(this.f21652c.getDir("crashrecord", 0), String.valueOf(i))));
                    } catch (IOException e) {
                        e = e;
                        objectOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        ObjectOutputStream objectOutputStream3 = null;
                        if (0 != 0) {
                            objectOutputStream3.close();
                        }
                        throw th;
                    }
                    try {
                        objectOutputStream2.writeObject(t);
                        objectOutputStream2.close();
                    } catch (IOException e2) {
                        objectOutputStream = objectOutputStream2;
                        e = e2;
                        e.printStackTrace();
                        ObjectOutputStream objectOutputStream4 = objectOutputStream;
                        al.a("open record file error", new Object[0]);
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    }
                } catch (Exception e3) {
                    al.e("writeCrashRecord error", new Object[0]);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    static /* synthetic */ boolean a(t tVar, t tVar2) {
        return tVar.g == tVar2.g && tVar.b != null && tVar.b.equalsIgnoreCase(tVar2.b);
    }

    static /* synthetic */ boolean b(t tVar, t tVar2) {
        if (tVar.e == null || tVar.e.equalsIgnoreCase(tVar2.e)) {
            return !(tVar.f == null || tVar.f.equalsIgnoreCase(tVar2.f)) || tVar.d <= 0;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(int i) {
        synchronized (this) {
            try {
                List<t> d = d(i);
                if (d == null) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (t tVar : d) {
                    if (tVar.b != null && tVar.b.equalsIgnoreCase(this.d) && tVar.d > 0) {
                        arrayList.add(tVar);
                    }
                    if (tVar.f21650c + 86400000 < currentTimeMillis) {
                        arrayList2.add(tVar);
                    }
                }
                Collections.sort(arrayList);
                if (arrayList.size() < 2) {
                    d.removeAll(arrayList2);
                    a(i, (int) d);
                    return false;
                } else if (arrayList.size() <= 0 || ((t) arrayList.get(arrayList.size() - 1)).f21650c + 86400000 >= currentTimeMillis) {
                    return true;
                } else {
                    d.clear();
                    a(i, (int) d);
                    return false;
                }
            } catch (Exception e) {
                al.e("isFrequentCrash failed", new Object[0]);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
        if (r10 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0069, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0083, code lost:
        if (r10 == null) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.io.ObjectInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T extends java.util.List<?>> T d(int r7) {
        /*
            Method dump skipped, instructions count: 199
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.u.d(int):java.util.List");
    }

    public final void a(final int i) {
        ak.a().a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.u.1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f21653a = 1004;

            @Override // java.lang.Runnable
            public final void run() {
                t tVar;
                try {
                    if (TextUtils.isEmpty(u.this.d)) {
                        return;
                    }
                    List d = u.this.d(this.f21653a);
                    List<t> list = d;
                    if (d == null) {
                        list = new ArrayList();
                    }
                    if (u.this.e.get(Integer.valueOf(this.f21653a)) == null) {
                        u.this.e.put(Integer.valueOf(this.f21653a), new HashMap());
                    }
                    if (((Map) u.this.e.get(Integer.valueOf(this.f21653a))).get(u.this.d) == null) {
                        tVar = new t();
                        tVar.f21649a = this.f21653a;
                        tVar.g = u.f21651a;
                        tVar.b = u.this.d;
                        tVar.f = aa.b().o;
                        tVar.e = aa.b().h;
                        tVar.f21650c = System.currentTimeMillis();
                        tVar.d = i;
                        ((Map) u.this.e.get(Integer.valueOf(this.f21653a))).put(u.this.d, tVar);
                    } else {
                        tVar = (t) ((Map) u.this.e.get(Integer.valueOf(this.f21653a))).get(u.this.d);
                        tVar.d = i;
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (t tVar2 : list) {
                        boolean z2 = z;
                        if (u.a(tVar2, tVar)) {
                            z2 = true;
                            tVar2.d = tVar.d;
                        }
                        z = z2;
                        if (u.b(tVar2, tVar)) {
                            arrayList.add(tVar2);
                            z = z2;
                        }
                    }
                    list.removeAll(arrayList);
                    if (!z) {
                        list.add(tVar);
                    }
                    u.this.a(this.f21653a, (int) list);
                } catch (Exception e) {
                    al.e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    public final boolean b(final int i) {
        boolean z;
        synchronized (this) {
            boolean z2 = true;
            try {
                SharedPreferences sharedPreferences = this.f;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append("_");
                sb.append(this.d);
                z = sharedPreferences.getBoolean(sb.toString(), true);
                z2 = z;
                ak.a().a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.u.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean c2 = u.this.c(i);
                        SharedPreferences.Editor edit = u.this.f.edit();
                        edit.putBoolean(i + "_" + u.this.d, !c2).commit();
                    }
                });
            } catch (Exception e) {
                al.e("canInit error", new Object[0]);
                return z2;
            }
        }
        return z;
    }
}
