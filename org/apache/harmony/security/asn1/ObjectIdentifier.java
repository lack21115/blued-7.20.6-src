package org.apache.harmony.security.asn1;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ObjectIdentifier.class */
public final class ObjectIdentifier {
    private final int[] oid;
    private String soid;

    public ObjectIdentifier(String str) {
        this.oid = toIntArray(str);
        this.soid = str;
    }

    public ObjectIdentifier(int[] iArr) {
        validate(iArr);
        this.oid = iArr;
    }

    public static boolean isOID(String str) {
        boolean z = false;
        if (toIntArray(str, false) != null) {
            z = true;
        }
        return z;
    }

    public static int[] toIntArray(String str) {
        return toIntArray(str, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0083, code lost:
        if (r6 != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0086, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0091, code lost:
        throw new java.lang.IllegalArgumentException("Incorrect syntax");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] toIntArray(java.lang.String r5, boolean r6) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.harmony.security.asn1.ObjectIdentifier.toIntArray(java.lang.String, boolean):int[]");
    }

    public static String toString(int[] iArr) {
        StringBuilder sb = new StringBuilder(iArr.length * 3);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length - 1) {
                sb.append(iArr[iArr.length - 1]);
                return sb.toString();
            }
            sb.append(iArr[i2]);
            sb.append('.');
            i = i2 + 1;
        }
    }

    public static void validate(int[] iArr) {
        if (iArr == null) {
            throw new IllegalArgumentException("oid == null");
        }
        if (iArr.length < 2) {
            throw new IllegalArgumentException("OID MUST have at least 2 subidentifiers");
        }
        if (iArr[0] > 2) {
            throw new IllegalArgumentException("Valid values for first subidentifier are 0, 1 and 2");
        }
        if (iArr[0] != 2 && iArr[1] > 39) {
            throw new IllegalArgumentException("If the first subidentifier has 0 or 1 value the second subidentifier value MUST be less than 40");
        }
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            if (iArr[i2] < 0) {
                throw new IllegalArgumentException("Subidentifier MUST have positive value");
            }
            i = i2 + 1;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.oid, ((ObjectIdentifier) obj).oid);
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.oid.length || i3 >= 4) {
                break;
            }
            i += this.oid[i3] << (i3 * 8);
            i2 = i3 + 1;
        }
        return Integer.MAX_VALUE & i;
    }

    public String toString() {
        if (this.soid == null) {
            this.soid = toString(this.oid);
        }
        return this.soid;
    }
}
