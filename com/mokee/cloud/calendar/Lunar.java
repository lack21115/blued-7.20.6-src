package com.mokee.cloud.calendar;

import com.amap.api.services.core.AMapException;
import com.android.org.conscrypt.NativeCrypto;
import java.text.SimpleDateFormat;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/cloud/calendar/Lunar.class */
public class Lunar {
    private static String[] c;
    private static String[] h;
    private static int[] i;
    private static final long[] o = null;
    private static final String[] q = null;
    private int a;
    private String[] b;
    private String[] d;
    private String[] e;
    private int f;
    private String[] g;
    private String[] j;
    private String[] k;
    private SimpleDateFormat l;
    private int m;
    private String n;
    private boolean p;

    static {
        String[] strArr = new String[91];
        throw new VerifyError("bad dex opcode");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x05b9, code lost:
        if (r0 != 0) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x068f, code lost:
        if (r11 <= 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x06f5, code lost:
        if (r0 != 0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0762, code lost:
        if (r0 != 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x033b, code lost:
        if (r0 != 0) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x07c9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0687  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x069d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x06bf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x073a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0779  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x07c0 -> B:37:0x06c4). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x068f -> B:26:0x066f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Lunar(java.util.Calendar r8) {
        /*
            Method dump skipped, instructions count: 2008
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.cloud.calendar.Lunar.<init>(java.util.Calendar):void");
    }

    private static int a(int i2) {
        return (int) (o[i2 - AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR] & 15);
    }

    private static int a(int i2, int i3) {
        return (o[i2 - AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR] & ((long) (65536 >> i3))) == 0 ? 29 : 30;
    }

    private static int b(int i2) {
        if (a(i2) != 0) {
            return (o[i2 - AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR] & NativeCrypto.SSL_OP_NO_SESSION_RESUMPTION_ON_RENEGOTIATION) != 0 ? 30 : 29;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0046, code lost:
        return b(r5) + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0015, code lost:
        if (com.mokee.cloud.calendar.SolarFestival.b != 0) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0018, code lost:
        r6 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0029, code lost:
        if ((com.mokee.cloud.calendar.Lunar.o[r5 - com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR] & r9) == 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002c, code lost:
        r6 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
        r7 = r9 >> 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
        r9 = r7;
        r8 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003d, code lost:
        if (r7 > 8) goto L3;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x003d -> B:4:0x0018). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int c(int r5) {
        /*
            int r0 = com.mokee.cloud.calendar.SolarFestival.b
            r10 = r0
            r0 = 348(0x15c, float:4.88E-43)
            r8 = r0
            r0 = 32768(0x8000, float:4.5918E-41)
            r9 = r0
            r0 = r9
            r7 = r0
            r0 = r8
            r6 = r0
            r0 = r10
            if (r0 == 0) goto L35
        L18:
            r0 = r8
            r6 = r0
            long[] r0 = com.mokee.cloud.calendar.Lunar.o
            r1 = r5
            r2 = 1900(0x76c, float:2.662E-42)
            int r1 = r1 - r2
            r0 = r0[r1]
            r1 = r9
            long r1 = (long) r1
            long r0 = r0 & r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L30
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
        L30:
            r0 = r9
            r1 = 1
            int r0 = r0 >> r1
            r7 = r0
        L35:
            r0 = r7
            r9 = r0
            r0 = r6
            r8 = r0
            r0 = r7
            r1 = 8
            if (r0 > r1) goto L18
            r0 = r5
            int r0 = b(r0)
            r1 = r6
            int r0 = r0 + r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.cloud.calendar.Lunar.c(int):int");
    }

    private String d(int i2) {
        return String.valueOf(this.b[i2 % 10]) + this.g[i2 % 12];
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0031  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0053 -> B:5:0x0019). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getLunarFestivalInfo(java.lang.String r4, com.mokee.cloud.calendar.Lunar r5) {
        /*
            int r0 = com.mokee.cloud.calendar.SolarFestival.b
            r6 = r0
            r0 = r4
            r1 = r4
            int r1 = r1.length()
            r2 = 4
            int r1 = r1 - r2
            r2 = r4
            int r2 = r2.length()
            java.lang.String r0 = r0.substring(r1, r2)
            r4 = r0
            r0 = r6
            if (r0 == 0) goto L58
            r0 = 0
            r7 = r0
        L19:
            java.lang.String[] r0 = com.mokee.cloud.calendar.Lunar.c
            r1 = r7
            r0 = r0[r1]
            java.lang.String r1 = " "
            java.lang.String[] r0 = r0.split(r1)
            r8 = r0
            r0 = r8
            r1 = 0
            r0 = r0[r1]
            r1 = r4
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L48
            r0 = r7
            if (r0 != 0) goto L43
            r0 = r5
            boolean r0 = r0.isMajorMonth()
            if (r0 == 0) goto L3e
            r0 = 0
            return r0
        L3e:
            r0 = r8
            r1 = 1
            r0 = r0[r1]
            return r0
        L43:
            r0 = r8
            r1 = 1
            r0 = r0[r1]
            return r0
        L48:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
        L4c:
            r0 = r6
            r7 = r0
            r0 = r6
            java.lang.String[] r1 = com.mokee.cloud.calendar.Lunar.c
            int r1 = r1.length
            if (r0 < r1) goto L19
            r0 = 0
            return r0
        L58:
            r0 = 0
            r6 = r0
            goto L4c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.cloud.calendar.Lunar.getLunarFestivalInfo(java.lang.String, com.mokee.cloud.calendar.Lunar):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x005c, code lost:
        if (r0 != 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0033, code lost:
        if (r0 != 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getSolarTermInfo(int r5, int r6, int r7) {
        /*
            r0 = 0
            r9 = r0
            int r0 = com.mokee.cloud.calendar.SolarFestival.b
            r10 = r0
            int[] r0 = com.mokee.cloud.calendar.Lunar.i
            r1 = r5
            r2 = 1970(0x7b2, float:2.76E-42)
            int r1 = r1 - r2
            r2 = 12
            int r1 = r1 * r2
            r2 = r6
            int r1 = r1 + r2
            r0 = r0[r1]
            java.lang.String r0 = java.lang.Integer.toHexString(r0)
            r11 = r0
            r0 = r7
            r1 = 15
            if (r0 >= r1) goto L36
            r0 = 15
            r1 = r11
            r2 = 0
            r3 = 1
            java.lang.String r1 = r1.substring(r2, r3)
            r2 = 16
            int r1 = java.lang.Integer.parseInt(r1, r2)
            int r0 = r0 - r1
            r8 = r0
            r0 = r10
            if (r0 == 0) goto L46
        L36:
            r0 = r11
            r1 = 1
            r2 = 2
            java.lang.String r0 = r0.substring(r1, r2)
            r1 = 16
            int r0 = java.lang.Integer.parseInt(r0, r1)
            r1 = 15
            int r0 = r0 + r1
            r8 = r0
        L46:
            r0 = r9
            r5 = r0
            r0 = r8
            r1 = r7
            if (r0 != r1) goto L65
            r0 = r7
            r1 = 15
            if (r0 <= r1) goto L5f
            r0 = r6
            r1 = 2
            int r0 = r0 * r1
            r1 = 2
            int r0 = r0 + r1
            r5 = r0
            r0 = r10
            if (r0 == 0) goto L65
        L5f:
            r0 = r6
            r1 = 2
            int r0 = r0 * r1
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
        L65:
            java.lang.String[] r0 = com.mokee.cloud.calendar.Lunar.h
            r1 = r5
            r0 = r0[r1]
            r11 = r0
            boolean r0 = com.mokee.volley.VolleyError.b
            if (r0 == 0) goto L79
            r0 = r10
            r1 = 1
            int r0 = r0 + r1
            com.mokee.cloud.calendar.SolarFestival.b = r0
        L79:
            r0 = r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.cloud.calendar.Lunar.getSolarTermInfo(int, int, int):java.lang.String");
    }

    public String getAnimalString() {
        return this.e[(this.a - 4) % 12];
    }

    public String getLunarDayString(int i2) {
        return i2 > 30 ? "" : i2 == 10 ? q[1] : i2 == 20 ? q[0] : i2 == 30 ? q[2] : String.valueOf(this.j[i2 / 10]) + this.d[i2 % 10 == 0 ? 9 : (i2 % 10) - 1];
    }

    public String getLunarYearString() {
        return d((this.a - AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR) + 36);
    }

    public boolean isMajorMonth() {
        return a(this.a, this.m) == 30;
    }

    public String toString() {
        return String.valueOf(getLunarYearString()) + getAnimalString() + "年" + (this.p ? this.n : "") + this.k[this.m - 1] + "月" + getLunarDayString(this.f);
    }
}
