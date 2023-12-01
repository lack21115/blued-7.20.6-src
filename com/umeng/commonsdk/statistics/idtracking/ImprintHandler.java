package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bz;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/idtracking/ImprintHandler.class */
public class ImprintHandler implements FileLockCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40911a = "ImprintHandler";
    private static Context k;
    private static FileLockUtil l;
    private static final int m = 0;
    private static final int n = 1;
    private com.umeng.commonsdk.statistics.internal.d e;
    private a h = new a();
    private com.umeng.commonsdk.statistics.proto.d i = null;
    private static Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final String f40912c = at.b().b("imp");
    private static final byte[] d = "pbl0".getBytes();
    private static Map<String, ArrayList<UMImprintChangeCallback>> f = new HashMap();
    private static Object g = new Object();
    private static ImprintHandler j = null;
    private static Map<String, UMImprintPreProcessCallback> o = new HashMap();
    private static Object p = new Object();

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/idtracking/ImprintHandler$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, String> f40913a = new HashMap();

        a() {
        }

        a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        private void b(com.umeng.commonsdk.statistics.proto.d dVar) {
            com.umeng.commonsdk.statistics.proto.e eVar;
            synchronized (this) {
                if (dVar != null) {
                    if (dVar.e()) {
                        Map<String, com.umeng.commonsdk.statistics.proto.e> c2 = dVar.c();
                        for (String str : c2.keySet()) {
                            if (!TextUtils.isEmpty(str) && (eVar = c2.get(str)) != null) {
                                String b = eVar.b();
                                if (!TextUtils.isEmpty(b)) {
                                    this.f40913a.put(str, b);
                                    if (AnalyticsConstants.UM_DEBUG) {
                                        Log.i(ImprintHandler.f40911a, "imKey is " + str + ", imValue is " + b);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        public String a(String str, String str2) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str) && this.f40913a.size() > 0) {
                    String str3 = this.f40913a.get(str);
                    return !TextUtils.isEmpty(str3) ? str3 : str2;
                }
                return str2;
            }
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar == null) {
                return;
            }
            b(dVar);
        }

        public void a(String str) {
            synchronized (this) {
                if (this.f40913a != null && this.f40913a.size() > 0 && !TextUtils.isEmpty(str) && this.f40913a.containsKey(str)) {
                    this.f40913a.remove(str);
                }
            }
        }
    }

    private ImprintHandler(Context context) {
        k = context.getApplicationContext();
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2, Map<String, String> map) {
        boolean z;
        ArrayList<UMImprintChangeCallback> arrayList;
        if (dVar2 == null) {
            return dVar;
        }
        Map<String, com.umeng.commonsdk.statistics.proto.e> c2 = dVar.c();
        for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar2.c().entrySet()) {
            if (entry.getValue().d()) {
                String key = entry.getKey();
                String str = entry.getValue().f40955a;
                synchronized (p) {
                    z = false;
                    if (!TextUtils.isEmpty(key)) {
                        z = false;
                        if (o.containsKey(key)) {
                            UMImprintPreProcessCallback uMImprintPreProcessCallback = o.get(key);
                            z = false;
                            if (uMImprintPreProcessCallback != null) {
                                z = false;
                                if (uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                                    z = true;
                                }
                            }
                        }
                    }
                }
                if (z) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> merge: [" + key + "] should be ignored.");
                } else {
                    c2.put(entry.getKey(), entry.getValue());
                    synchronized (g) {
                        if (!TextUtils.isEmpty(key) && f.containsKey(key) && f.get(key) != null) {
                            map.put(key, str);
                        }
                    }
                }
            } else {
                String key2 = entry.getKey();
                synchronized (g) {
                    if (!TextUtils.isEmpty(key2) && f.containsKey(key2) && (arrayList = f.get(key2)) != null) {
                        for (int i = 0; i < arrayList.size(); i++) {
                            arrayList.get(i).onImprintValueChanged(key2, null);
                        }
                    }
                }
                c2.remove(key2);
                this.h.a(key2);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private void a(File file) {
        if (this.i == null) {
            return;
        }
        try {
            synchronized (b) {
                byte[] a2 = new bz().a(this.i);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(a2);
                fileOutputStream.flush();
                HelperUtils.safeClose(fileOutputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (g) {
            if (!f.containsKey(str)) {
                ArrayList<UMImprintChangeCallback> arrayList = new ArrayList<>();
                int size = arrayList.size();
                ULog.i("--->>> addCallback: before add: callbacks size is: " + size);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        arrayList.add(uMImprintChangeCallback);
                        ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
                        f.put(str, arrayList);
                        break;
                    } else if (uMImprintChangeCallback == arrayList.get(i2)) {
                        ULog.i("--->>> addCallback: callback has exist, just exit");
                        return;
                    } else {
                        i = i2 + 1;
                    }
                }
            } else {
                ArrayList<UMImprintChangeCallback> arrayList2 = f.get(str);
                int size2 = arrayList2.size();
                ULog.i("--->>> addCallback: before add: callbacks size is: " + size2);
                for (int i3 = 0; i3 < size2; i3++) {
                    if (uMImprintChangeCallback == arrayList2.get(i3)) {
                        ULog.i("--->>> addCallback: callback has exist, just exit");
                        return;
                    }
                }
                arrayList2.add(uMImprintChangeCallback);
                ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
            }
        }
    }

    private boolean a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    private static void b(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        synchronized (g) {
            try {
                if (f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f.get(str);
                    if (uMImprintChangeCallback != null && arrayList.size() > 0) {
                        int size = arrayList.size();
                        ULog.i("--->>> removeCallback: before remove: callbacks size is: " + size);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= size) {
                                break;
                            } else if (uMImprintChangeCallback == arrayList.get(i2)) {
                                ULog.i("--->>> removeCallback: remove index " + i2);
                                arrayList.remove(i2);
                                break;
                            } else {
                                i = i2 + 1;
                            }
                        }
                        ULog.i("--->>> removeCallback: after remove: callbacks size is: " + arrayList.size());
                        if (arrayList.size() == 0) {
                            ULog.i("--->>> removeCallback: remove key from map: key = " + str);
                            f.remove(str);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0020, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(com.umeng.commonsdk.statistics.proto.d r5) {
        /*
            r4 = this;
            r0 = r5
            java.lang.String r0 = r0.i()
            r1 = r4
            r2 = r5
            java.lang.String r1 = r1.a(r2)
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L11
            r0 = 0
            return r0
        L11:
            r0 = r5
            java.util.Map r0 = r0.c()
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
        L20:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L6b
            r0 = r5
            java.lang.Object r0 = r0.next()
            com.umeng.commonsdk.statistics.proto.e r0 = (com.umeng.commonsdk.statistics.proto.e) r0
            r7 = r0
            r0 = r7
            java.lang.String r0 = r0.h()
            r8 = r0
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L44
            goto L20
        L44:
            r0 = r8
            byte[] r0 = com.umeng.commonsdk.statistics.common.DataHelper.reverseHexString(r0)
            r8 = r0
            r0 = r4
            r1 = r7
            byte[] r0 = r0.a(r1)
            r7 = r0
            r0 = 0
            r6 = r0
        L53:
            r0 = r6
            r1 = 4
            if (r0 >= r1) goto L20
            r0 = r8
            r1 = r6
            r0 = r0[r1]
            r1 = r7
            r2 = r6
            r1 = r1[r2]
            if (r0 == r1) goto L64
            r0 = 0
            return r0
        L64:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L53
        L6b:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.c(com.umeng.commonsdk.statistics.proto.d):boolean");
    }

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.e> c2 = dVar.c();
        if (c2.containsKey(bh.f)) {
            c2.remove(bh.f);
            this.h.a(bh.f);
            dVar.a(dVar.f());
            dVar.a(a(dVar));
        }
        return dVar;
    }

    private com.umeng.commonsdk.statistics.proto.d e(com.umeng.commonsdk.statistics.proto.d dVar) {
        ArrayList<UMImprintChangeCallback> arrayList;
        boolean z;
        ArrayList<UMImprintChangeCallback> arrayList2;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        Map<String, com.umeng.commonsdk.statistics.proto.e> c2 = dVar.c();
        ArrayList<String> arrayList3 = new ArrayList(c2.size() / 2);
        for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : c2.entrySet()) {
            if (entry.getValue().d()) {
                String key = entry.getKey();
                String str = entry.getValue().f40955a;
                synchronized (p) {
                    z = !TextUtils.isEmpty(key) && o.containsKey(key) && (uMImprintPreProcessCallback = o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                }
                if (z) {
                    arrayList3.add(key);
                }
                synchronized (g) {
                    if (!TextUtils.isEmpty(key) && f.containsKey(key) && (arrayList2 = f.get(key)) != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= arrayList2.size()) {
                                break;
                            }
                            arrayList2.get(i2).onImprintValueChanged(key, str);
                            i = i2 + 1;
                        }
                    }
                }
            } else {
                arrayList3.add(entry.getKey());
            }
        }
        for (String str2 : arrayList3) {
            synchronized (g) {
                if (!TextUtils.isEmpty(str2) && f.containsKey(str2) && (arrayList = f.get(str2)) != null) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= arrayList.size()) {
                            break;
                        }
                        arrayList.get(i4).onImprintValueChanged(str2, null);
                        i3 = i4 + 1;
                    }
                }
            }
            c2.remove(str2);
        }
        return dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v19, types: [com.umeng.analytics.pro.bt] */
    /* JADX WARN: Type inference failed for: r0v29, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r2v2, types: [byte[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            r1 = r0
            android.content.Context r2 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.k
            java.io.File r2 = r2.getFilesDir()
            java.lang.String r3 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f40912c
            r1.<init>(r2, r3)
            r6 = r0
            java.lang.Object r0 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.b
            r10 = r0
            r0 = r10
            monitor-enter(r0)
            r0 = r6
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L9d
            if (r0 != 0) goto L24
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9d
            return
        L24:
            r0 = 0
            r9 = r0
            android.content.Context r0 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.k     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L4b
            java.lang.String r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f40912c     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L4b
            java.io.FileInputStream r0 = r0.openFileInput(r1)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L4b
            r6 = r0
            r0 = r6
            r7 = r0
            r0 = r6
            byte[] r0 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r0)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> La3
            r8 = r0
            r0 = r8
            r7 = r0
        L3a:
            r0 = r6
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r0)     // Catch: java.lang.Throwable -> L9d
            goto L5a
        L41:
            r8 = move-exception
            goto L4e
        L45:
            r6 = move-exception
            r0 = 0
            r7 = r0
            goto L97
        L4b:
            r8 = move-exception
            r0 = 0
            r6 = r0
        L4e:
            r0 = r6
            r7 = r0
            r0 = r8
            r0.printStackTrace()     // Catch: java.lang.Throwable -> La3
            r0 = r9
            r7 = r0
            goto L3a
        L5a:
            r0 = r7
            if (r0 == 0) goto L93
            com.umeng.commonsdk.statistics.proto.d r0 = new com.umeng.commonsdk.statistics.proto.d     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L9d
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L9d
            r6 = r0
            com.umeng.analytics.pro.bt r0 = new com.umeng.analytics.pro.bt     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L9d
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L9d
            r1 = r6
            r2 = r7
            r0.a(r1, r2)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L9d
            r0 = r5
            r1 = r6
            r0.i = r1     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L9d
            r0 = r5
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a r0 = r0.h     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L9d
            r1 = r6
            r0.a(r1)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L9d
            r0 = r5
            r1 = r5
            r2 = r5
            com.umeng.commonsdk.statistics.proto.d r2 = r2.i     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L9d
            com.umeng.commonsdk.statistics.proto.d r1 = r1.d(r2)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L9d
            r0.i = r1     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L9d
            goto L93
        L8e:
            r6 = move-exception
            r0 = r6
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L9d
        L93:
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9d
            return
        L97:
            r0 = r7
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r0)     // Catch: java.lang.Throwable -> L9d
            r0 = r6
            throw r0     // Catch: java.lang.Throwable -> L9d
        L9d:
            r6 = move-exception
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9d
            r0 = r6
            throw r0
        La3:
            r6 = move-exception
            goto L97
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.e():void");
    }

    public static ImprintHandler getImprintService(Context context) {
        ImprintHandler imprintHandler;
        synchronized (ImprintHandler.class) {
            try {
                if (j == null) {
                    j = new ImprintHandler(context);
                    FileLockUtil fileLockUtil = new FileLockUtil();
                    l = fileLockUtil;
                    if (fileLockUtil != null) {
                        l.doFileOperateion(new File(k.getFilesDir(), f40912c), j, 0);
                    }
                }
                imprintHandler = j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return imprintHandler;
    }

    public String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(dVar.c()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).d()) {
                sb.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).b());
            }
        }
        sb.append(dVar.b);
        return HelperUtils.MD5(sb.toString()).toLowerCase(Locale.US);
    }

    public void a(com.umeng.commonsdk.statistics.internal.d dVar) {
        this.e = dVar;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (p) {
            try {
                if (o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                    f.remove(str);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                }
            }
        }
    }

    public byte[] a() {
        try {
            synchronized (this) {
                if (this.i == null) {
                    return null;
                }
                if (this.i.b() <= 0) {
                    return null;
                }
                return new bz().a(this.i);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(k, th);
            return null;
        }
    }

    public byte[] a(com.umeng.commonsdk.statistics.proto.e eVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(eVar.e());
        byte[] array = allocate.array();
        byte[] bArr = d;
        byte[] bArr2 = new byte[4];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 4) {
                return bArr2;
            }
            bArr2[i2] = (byte) (array[i2] ^ bArr[i2]);
            i = i2 + 1;
        }
    }

    public com.umeng.commonsdk.statistics.proto.d b() {
        com.umeng.commonsdk.statistics.proto.d dVar;
        synchronized (this) {
            dVar = this.i;
        }
        return dVar;
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        boolean a2;
        if (dVar == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.d(UMRTLog.RTLOG_TAG, "Imprint is null");
            }
        } else if (!c(dVar)) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "Imprint is not valid");
            }
        } else {
            boolean z = AnalyticsConstants.UM_DEBUG;
            HashMap hashMap = new HashMap();
            synchronized (this) {
                com.umeng.commonsdk.statistics.proto.d dVar2 = this.i;
                com.umeng.commonsdk.statistics.proto.d d2 = d(dVar);
                String i = dVar2 == null ? null : dVar2.i();
                com.umeng.commonsdk.statistics.proto.d e = dVar2 == null ? e(d2) : a(dVar2, d2, hashMap);
                this.i = e;
                a2 = a(i, e == null ? null : e.i());
            }
            if (this.i != null) {
                boolean z2 = AnalyticsConstants.UM_DEBUG;
                if (!a2) {
                    this.h.a(this.i);
                    com.umeng.commonsdk.statistics.internal.d dVar3 = this.e;
                    if (dVar3 != null) {
                        dVar3.onImprintChanged(this.h);
                    }
                }
            }
            if (hashMap.size() > 0) {
                synchronized (g) {
                    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && f.containsKey(key)) {
                            ULog.i("--->>> target imprint key is: " + key + "; value is: " + value);
                            ArrayList<UMImprintChangeCallback> arrayList = f.get(key);
                            if (arrayList != null) {
                                int i2 = 0;
                                while (true) {
                                    int i3 = i2;
                                    if (i3 < arrayList.size()) {
                                        arrayList.get(i3).onImprintValueChanged(key, value);
                                        i2 = i3 + 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public a c() {
        return this.h;
    }

    public void d() {
        if (this.i == null || l == null) {
            return;
        }
        File file = new File(k.getFilesDir(), f40912c);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                try {
                    file.createNewFile();
                } catch (IOException e2) {
                    UMCrashManager.reportCrash(k, e2);
                }
            }
        }
        l.doFileOperateion(file, j, 1);
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i) {
        if (i == 0) {
            j.e();
            return true;
        } else if (i == 1) {
            j.a(file);
            return true;
        } else {
            return true;
        }
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        a(str, uMImprintChangeCallback);
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (TextUtils.isEmpty(str) || uMImprintPreProcessCallback == null) {
            return;
        }
        synchronized (p) {
            try {
                if (o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> key : " + str + " PreProcesser has registed!");
                } else {
                    o.put(str, uMImprintPreProcessCallback);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> registPreProcessCallback: key : " + str + " regist success.");
                }
            }
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        b(str, uMImprintChangeCallback);
    }
}
