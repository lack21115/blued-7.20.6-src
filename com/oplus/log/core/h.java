package com.oplus.log.core;

import android.os.StatFs;
import android.util.Log;
import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/core/h.class */
public final class h extends Thread {

    /* renamed from: a  reason: collision with root package name */
    i f10655a;
    private boolean f;
    private File g;
    private boolean h;
    private long i;
    private f j;
    private ConcurrentLinkedQueue<e> k;
    private String l;
    private String m;
    private String n;
    private long o;
    private long p;
    private long q;
    private String r;
    private String s;
    private int t;
    private ExecutorService v;
    private final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Object f10656c = new Object();
    private volatile boolean e = true;
    private ConcurrentLinkedQueue<e> u = new ConcurrentLinkedQueue<>();
    private final a d = new a();
    private final com.oplus.log.c.a w = new com.oplus.log.c.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ConcurrentLinkedQueue<e> concurrentLinkedQueue, String str, String str2, long j, long j2, long j3, String str3, String str4, String str5) {
        this.k = concurrentLinkedQueue;
        this.l = str;
        this.m = str2;
        this.n = str5;
        this.o = j;
        this.p = j2;
        this.q = j3;
        this.r = str3;
        this.s = str4;
    }

    private void a(long j) {
        File[] listFiles;
        File file = new File(this.m);
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            File file2 = listFiles[i2];
            if (file2 != null) {
                try {
                    if (file2.lastModified() <= j) {
                        file2.delete();
                    }
                } catch (Exception e) {
                    if (com.oplus.log.b.a()) {
                        e.printStackTrace();
                    }
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.log.core.h.a(java.lang.String, java.lang.String):boolean");
    }

    private boolean c() {
        try {
            StatFs statFs = new StatFs(this.m);
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > this.q;
        } catch (IllegalArgumentException e) {
            if (com.oplus.log.b.a()) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public final void a() {
        if (this.f) {
            return;
        }
        synchronized (this.b) {
            this.b.notify();
        }
    }

    public final void b() {
        if (b.f10642a) {
            Log.d("LoganThread", "Logan flush start");
        }
        f fVar = this.j;
        if (fVar != null) {
            fVar.logan_flush();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0373 A[Catch: all -> 0x047b, TRY_ENTER, TryCatch #0 {, blocks: (B:94:0x02c5, B:96:0x02ce, B:142:0x0477, B:97:0x02db, B:99:0x02e8, B:101:0x02f2, B:105:0x0300, B:107:0x0308, B:109:0x030e, B:111:0x0319, B:122:0x0373, B:124:0x03b2, B:126:0x03f7, B:133:0x041e, B:135:0x0424, B:136:0x0430, B:138:0x0458, B:140:0x0468, B:128:0x0403, B:130:0x040f, B:114:0x032b, B:116:0x0365), top: B:178:0x02c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x040f A[Catch: all -> 0x047b, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:94:0x02c5, B:96:0x02ce, B:142:0x0477, B:97:0x02db, B:99:0x02e8, B:101:0x02f2, B:105:0x0300, B:107:0x0308, B:109:0x030e, B:111:0x0319, B:122:0x0373, B:124:0x03b2, B:126:0x03f7, B:133:0x041e, B:135:0x0424, B:136:0x0430, B:138:0x0458, B:140:0x0468, B:128:0x0403, B:130:0x040f, B:114:0x032b, B:116:0x0365), top: B:178:0x02c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x041e A[Catch: all -> 0x047b, TRY_ENTER, TryCatch #0 {, blocks: (B:94:0x02c5, B:96:0x02ce, B:142:0x0477, B:97:0x02db, B:99:0x02e8, B:101:0x02f2, B:105:0x0300, B:107:0x0308, B:109:0x030e, B:111:0x0319, B:122:0x0373, B:124:0x03b2, B:126:0x03f7, B:133:0x041e, B:135:0x0424, B:136:0x0430, B:138:0x0458, B:140:0x0468, B:128:0x0403, B:130:0x040f, B:114:0x032b, B:116:0x0365), top: B:178:0x02c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0430 A[Catch: all -> 0x047b, TRY_ENTER, TryCatch #0 {, blocks: (B:94:0x02c5, B:96:0x02ce, B:142:0x0477, B:97:0x02db, B:99:0x02e8, B:101:0x02f2, B:105:0x0300, B:107:0x0308, B:109:0x030e, B:111:0x0319, B:122:0x0373, B:124:0x03b2, B:126:0x03f7, B:133:0x041e, B:135:0x0424, B:136:0x0430, B:138:0x0458, B:140:0x0468, B:128:0x0403, B:130:0x040f, B:114:0x032b, B:116:0x0365), top: B:178:0x02c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8 A[Catch: InterruptedException -> 0x04a7, all -> 0x04bf, TRY_ENTER, TryCatch #1 {InterruptedException -> 0x04a7, blocks: (B:10:0x001e, B:12:0x002e, B:15:0x0047, B:17:0x004f, B:19:0x005a, B:21:0x0062, B:36:0x00a8, B:38:0x00af, B:40:0x00f3, B:42:0x00fc, B:44:0x0109, B:46:0x0113, B:48:0x0119, B:50:0x0129, B:52:0x0143, B:54:0x0155, B:56:0x0169, B:64:0x018f, B:66:0x01c2, B:68:0x01d5, B:69:0x01de, B:69:0x01de, B:70:0x01e1, B:72:0x01ee, B:74:0x0213, B:75:0x023b, B:75:0x023b, B:76:0x023e, B:78:0x024a, B:80:0x025a, B:82:0x0260, B:84:0x0267, B:86:0x0283, B:60:0x0182, B:87:0x02a5, B:89:0x02b0, B:91:0x02bb, B:92:0x02c3, B:148:0x0482, B:150:0x0485, B:152:0x048e, B:154:0x049a, B:24:0x0070, B:26:0x007b, B:28:0x0083, B:31:0x0096), top: B:180:0x001e, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018f A[Catch: InterruptedException -> 0x04a7, all -> 0x04bf, TRY_ENTER, TryCatch #1 {InterruptedException -> 0x04a7, blocks: (B:10:0x001e, B:12:0x002e, B:15:0x0047, B:17:0x004f, B:19:0x005a, B:21:0x0062, B:36:0x00a8, B:38:0x00af, B:40:0x00f3, B:42:0x00fc, B:44:0x0109, B:46:0x0113, B:48:0x0119, B:50:0x0129, B:52:0x0143, B:54:0x0155, B:56:0x0169, B:64:0x018f, B:66:0x01c2, B:68:0x01d5, B:69:0x01de, B:69:0x01de, B:70:0x01e1, B:72:0x01ee, B:74:0x0213, B:75:0x023b, B:75:0x023b, B:76:0x023e, B:78:0x024a, B:80:0x025a, B:82:0x0260, B:84:0x0267, B:86:0x0283, B:60:0x0182, B:87:0x02a5, B:89:0x02b0, B:91:0x02bb, B:92:0x02c3, B:148:0x0482, B:150:0x0485, B:152:0x048e, B:154:0x049a, B:24:0x0070, B:26:0x007b, B:28:0x0083, B:31:0x0096), top: B:180:0x001e, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x024a A[Catch: InterruptedException -> 0x04a7, all -> 0x04bf, TryCatch #1 {InterruptedException -> 0x04a7, blocks: (B:10:0x001e, B:12:0x002e, B:15:0x0047, B:17:0x004f, B:19:0x005a, B:21:0x0062, B:36:0x00a8, B:38:0x00af, B:40:0x00f3, B:42:0x00fc, B:44:0x0109, B:46:0x0113, B:48:0x0119, B:50:0x0129, B:52:0x0143, B:54:0x0155, B:56:0x0169, B:64:0x018f, B:66:0x01c2, B:68:0x01d5, B:69:0x01de, B:69:0x01de, B:70:0x01e1, B:72:0x01ee, B:74:0x0213, B:75:0x023b, B:75:0x023b, B:76:0x023e, B:78:0x024a, B:80:0x025a, B:82:0x0260, B:84:0x0267, B:86:0x0283, B:60:0x0182, B:87:0x02a5, B:89:0x02b0, B:91:0x02bb, B:92:0x02c3, B:148:0x0482, B:150:0x0485, B:152:0x048e, B:154:0x049a, B:24:0x0070, B:26:0x007b, B:28:0x0083, B:31:0x0096), top: B:180:0x001e, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0260 A[Catch: InterruptedException -> 0x04a7, all -> 0x04bf, TryCatch #1 {InterruptedException -> 0x04a7, blocks: (B:10:0x001e, B:12:0x002e, B:15:0x0047, B:17:0x004f, B:19:0x005a, B:21:0x0062, B:36:0x00a8, B:38:0x00af, B:40:0x00f3, B:42:0x00fc, B:44:0x0109, B:46:0x0113, B:48:0x0119, B:50:0x0129, B:52:0x0143, B:54:0x0155, B:56:0x0169, B:64:0x018f, B:66:0x01c2, B:68:0x01d5, B:69:0x01de, B:69:0x01de, B:70:0x01e1, B:72:0x01ee, B:74:0x0213, B:75:0x023b, B:75:0x023b, B:76:0x023e, B:78:0x024a, B:80:0x025a, B:82:0x0260, B:84:0x0267, B:86:0x0283, B:60:0x0182, B:87:0x02a5, B:89:0x02b0, B:91:0x02bb, B:92:0x02c3, B:148:0x0482, B:150:0x0485, B:152:0x048e, B:154:0x049a, B:24:0x0070, B:26:0x007b, B:28:0x0083, B:31:0x0096), top: B:180:0x001e, outer: #2 }] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.log.core.h.run():void");
    }
}
