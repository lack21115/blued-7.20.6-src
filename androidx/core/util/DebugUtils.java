package androidx.core.util;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/DebugUtils.class */
public class DebugUtils {
    private DebugUtils() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r0.length() <= 0) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void buildShortClassTag(java.lang.Object r4, java.lang.StringBuilder r5) {
        /*
            r0 = r4
            if (r0 != 0) goto Lc
            r0 = r5
            java.lang.String r1 = "null"
            java.lang.StringBuilder r0 = r0.append(r1)
            return
        Lc:
            r0 = r4
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L25
            r0 = r8
            r7 = r0
            r0 = r8
            int r0 = r0.length()
            if (r0 > 0) goto L46
        L25:
            r0 = r4
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            r8 = r0
            r0 = r8
            r1 = 46
            int r0 = r0.lastIndexOf(r1)
            r6 = r0
            r0 = r8
            r7 = r0
            r0 = r6
            if (r0 <= 0) goto L46
            r0 = r8
            r1 = r6
            r2 = 1
            int r1 = r1 + r2
            java.lang.String r0 = r0.substring(r1)
            r7 = r0
        L46:
            r0 = r5
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = 123(0x7b, float:1.72E-43)
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r4
            int r1 = java.lang.System.identityHashCode(r1)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            java.lang.StringBuilder r0 = r0.append(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.util.DebugUtils.buildShortClassTag(java.lang.Object, java.lang.StringBuilder):void");
    }
}
