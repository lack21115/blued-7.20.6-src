package com.mokee.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/VolleyLog.class */
public class VolleyLog {
    public static boolean DEBUG;
    public static String TAG;

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f24243a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/VolleyLog$a.class */
    public static class a {
        public static final boolean ENABLED = false;

        /* renamed from: c  reason: collision with root package name */
        private static final String[] f24244c = null;

        /* renamed from: a  reason: collision with root package name */
        private final List<b> f24245a = new ArrayList();
        private boolean b = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/VolleyLog$a$b.class */
        public static class b {
            public final String name;
            public final long thread;
            public final long time;

            public b(String str, long j, long j2) {
                this.name = str;
                this.thread = j;
                this.time = j2;
            }
        }

        static {
            String[] strArr = new String[5];
            throw new VerifyError("bad dex opcode");
        }

        private long a() {
            try {
                if (this.f24245a.size() == 0) {
                    return 0L;
                }
                return this.f24245a.get(this.f24245a.size() - 1).time - this.f24245a.get(0).time;
            } catch (IllegalStateException e) {
                throw e;
            }
        }

        public void add(String str, long j) {
            synchronized (this) {
                try {
                    if (this.b) {
                        throw new IllegalStateException(f24244c[2]);
                    }
                    this.f24245a.add(new b(str, j, SystemClock.elapsedRealtime()));
                } catch (IllegalStateException e) {
                    throw e;
                }
            }
        }

        protected void finalize() throws Throwable {
            if (this.b) {
                return;
            }
            finish(f24244c[1]);
            VolleyLog.e(f24244c[0], new Object[0]);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x009c, code lost:
            if (r0.hasNext() == false) goto L7;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x009c -> B:14:0x0056). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void finish(java.lang.String r10) {
            /*
                r9 = this;
                r0 = r9
                monitor-enter(r0)
                boolean r0 = com.mokee.volley.Request.e     // Catch: java.lang.Throwable -> La2
                r11 = r0
                r0 = r9
                r1 = 1
                r0.b = r1     // Catch: java.lang.Throwable -> La2
                r0 = r9
                long r0 = r0.a()     // Catch: java.lang.Throwable -> La2
                r12 = r0
                r0 = r12
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 > 0) goto L19
            L16:
                r0 = r9
                monitor-exit(r0)
                return
            L19:
                r0 = r9
                java.util.List<com.mokee.volley.VolleyLog$a$b> r0 = r0.f24245a     // Catch: java.lang.Throwable -> La2
                r1 = 0
                java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> La2
                com.mokee.volley.VolleyLog$a$b r0 = (com.mokee.volley.VolleyLog.a.b) r0     // Catch: java.lang.Throwable -> La2
                long r0 = r0.time     // Catch: java.lang.Throwable -> La2
                r14 = r0
                java.lang.String[] r0 = com.mokee.volley.VolleyLog.a.f24244c     // Catch: java.lang.Throwable -> La2
                r1 = 3
                r0 = r0[r1]     // Catch: java.lang.Throwable -> La2
                r1 = 2
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> La2
                r2 = r1
                r3 = 0
                r4 = r12
                java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> La2
                r2[r3] = r4     // Catch: java.lang.Throwable -> La2
                r2 = r1
                r3 = 1
                r4 = r10
                r2[r3] = r4     // Catch: java.lang.Throwable -> La2
                com.mokee.volley.VolleyLog.d(r0, r1)     // Catch: java.lang.Throwable -> La2
                r0 = r9
                java.util.List<com.mokee.volley.VolleyLog$a$b> r0 = r0.f24245a     // Catch: java.lang.Throwable -> La2
                java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> La2
                r10 = r0
                r0 = r14
                r12 = r0
                r0 = r11
                if (r0 == 0) goto L94
                r0 = r14
                r12 = r0
            L56:
                r0 = r10
                java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> La2
                com.mokee.volley.VolleyLog$a$b r0 = (com.mokee.volley.VolleyLog.a.b) r0     // Catch: java.lang.Throwable -> La2
                r16 = r0
                r0 = r16
                long r0 = r0.time     // Catch: java.lang.Throwable -> La2
                r14 = r0
                java.lang.String[] r0 = com.mokee.volley.VolleyLog.a.f24244c     // Catch: java.lang.Throwable -> La2
                r1 = 4
                r0 = r0[r1]     // Catch: java.lang.Throwable -> La2
                r1 = 3
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> La2
                r2 = r1
                r3 = 0
                r4 = r14
                r5 = r12
                long r4 = r4 - r5
                java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> La2
                r2[r3] = r4     // Catch: java.lang.Throwable -> La2
                r2 = r1
                r3 = 1
                r4 = r16
                long r4 = r4.thread     // Catch: java.lang.Throwable -> La2
                java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> La2
                r2[r3] = r4     // Catch: java.lang.Throwable -> La2
                r2 = r1
                r3 = 2
                r4 = r16
                java.lang.String r4 = r4.name     // Catch: java.lang.Throwable -> La2
                r2[r3] = r4     // Catch: java.lang.Throwable -> La2
                com.mokee.volley.VolleyLog.d(r0, r1)     // Catch: java.lang.Throwable -> La2
                r0 = r14
                r12 = r0
            L94:
                r0 = r10
                boolean r0 = r0.hasNext()     // Catch: java.lang.Throwable -> La2
                r11 = r0
                r0 = r11
                if (r0 != 0) goto L56
                goto L16
            La2:
                r10 = move-exception
                r0 = r9
                monitor-exit(r0)
                r0 = r10
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.VolleyLog.a.finish(java.lang.String):void");
        }
    }

    static {
        String[] strArr = new String[3];
        throw new VerifyError("bad dex opcode");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0099  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0096 -> B:8:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r8, java.lang.Object... r9) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.VolleyLog.a(java.lang.String, java.lang.Object[]):java.lang.String");
    }

    public static void d(String str, Object... objArr) {
        Log.d(TAG, a(str, objArr));
    }

    public static void e(String str, Object... objArr) {
        Log.e(TAG, a(str, objArr));
    }

    public static void e(Throwable th, String str, Object... objArr) {
        Log.e(TAG, a(str, objArr), th);
    }

    public static void setTag(String str) {
        d(f24243a[0], str);
        TAG = str;
        DEBUG = Log.isLoggable(TAG, 2);
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, a(str, objArr));
        }
    }

    public static void wtf(String str, Object... objArr) {
        Log.wtf(TAG, a(str, objArr));
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        Log.wtf(TAG, a(str, objArr), th);
    }
}
