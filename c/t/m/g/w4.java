package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/w4.class */
public class w4 {
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bb, code lost:
        if (r9 < 13) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.util.List<android.net.wifi.ScanResult> r7, java.util.List<android.net.wifi.ScanResult> r8) {
        /*
            r0 = 0
            r13 = r0
            r0 = r13
            r12 = r0
            r0 = r7
            if (r0 == 0) goto Lc1
            r0 = r8
            if (r0 != 0) goto L11
            r0 = 0
            return r0
        L11:
            r0 = r7
            int r0 = r0.size()
            r10 = r0
            r0 = r8
            int r0 = r0.size()
            r11 = r0
            r0 = r10
            if (r0 != 0) goto L2b
            r0 = r11
            if (r0 != 0) goto L2b
            r0 = 1
            return r0
        L2b:
            r0 = r13
            r12 = r0
            r0 = r10
            if (r0 == 0) goto Lc1
            r0 = r11
            if (r0 != 0) goto L3a
            r0 = 0
            return r0
        L3a:
            r0 = r7
            r15 = r0
            r0 = r8
            r14 = r0
            r0 = r7
            int r0 = r0.size()
            r1 = r8
            int r1 = r1.size()
            if (r0 <= r1) goto L55
            r0 = r7
            r14 = r0
            r0 = r8
            r15 = r0
        L55:
            r0 = r15
            java.util.Iterator r0 = r0.iterator()
            r7 = r0
            r0 = 0
            r9 = r0
        L5f:
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto La3
            r0 = r7
            java.lang.Object r0 = r0.next()
            android.net.wifi.ScanResult r0 = (android.net.wifi.ScanResult) r0
            r8 = r0
            r0 = r14
            java.util.Iterator r0 = r0.iterator()
            r15 = r0
        L7b:
            r0 = r15
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L5f
            r0 = r15
            java.lang.Object r0 = r0.next()
            android.net.wifi.ScanResult r0 = (android.net.wifi.ScanResult) r0
            java.lang.String r0 = r0.BSSID
            r1 = r8
            java.lang.String r1 = r1.BSSID
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7b
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            goto L5f
        La3:
            r0 = r9
            r1 = 2
            int r0 = r0 * r1
            double r0 = (double) r0
            r1 = r10
            r2 = r11
            int r1 = r1 + r2
            double r1 = (double) r1
            r2 = 4605831338911806259(0x3feb333333333333, double:0.85)
            double r1 = r1 * r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto Lbe
            r0 = r13
            r12 = r0
            r0 = r9
            r1 = 13
            if (r0 >= r1) goto Lc1
        Lbe:
            r0 = 1
            r12 = r0
        Lc1:
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.w4.a(java.util.List, java.util.List):boolean");
    }
}
