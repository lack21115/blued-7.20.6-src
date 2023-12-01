package com.ss.android.socialbase.appdownloader.u.mb;

import java.io.PrintStream;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/u/mb/ww.class */
public class ww extends Exception {
    protected int b;
    protected Throwable mb;
    protected int ox;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ww(java.lang.String r4, com.ss.android.socialbase.appdownloader.u.mb.ko r5, java.lang.Throwable r6) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            java.lang.String r0 = ""
            r7 = r0
            r0 = r4
            if (r0 != 0) goto L17
            java.lang.String r0 = ""
            r4 = r0
            goto L35
        L17:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r9
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            java.lang.String r1 = " "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            java.lang.String r0 = r0.toString()
            r4 = r0
        L35:
            r0 = r8
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            if (r0 != 0) goto L46
            java.lang.String r0 = ""
            r4 = r0
            goto L6c
        L46:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            java.lang.String r1 = "(position:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            r1 = r5
            java.lang.String r1 = r1.hj()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r1 = ") "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r0 = r0.toString()
            r4 = r0
        L6c:
            r0 = r8
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            if (r0 != 0) goto L7d
            r0 = r7
            r4 = r0
            goto L97
        L7d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            java.lang.String r1 = "caused by: "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r0 = r0.toString()
            r4 = r0
        L97:
            r0 = r8
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r3
            r1 = r8
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r0 = r3
            r1 = -1
            r0.ox = r1
            r0 = r3
            r1 = -1
            r0.b = r1
            r0 = r5
            if (r0 == 0) goto Lc9
            r0 = r3
            r1 = r5
            int r1 = r1.b()
            r0.ox = r1
            r0 = r3
            r1 = r5
            int r1 = r1.u()
            r0.b = r1
        Lc9:
            r0 = r3
            r1 = r6
            r0.mb = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.u.mb.ww.<init>(java.lang.String, com.ss.android.socialbase.appdownloader.u.mb.ko, java.lang.Throwable):void");
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.mb == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            PrintStream printStream = System.err;
            printStream.println(super.getMessage() + "; nested exception is:");
            this.mb.printStackTrace();
        }
    }
}
