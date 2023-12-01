package org.apache.harmony.security.utils;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/utils/ObjectIdentifier.class */
public final class ObjectIdentifier {
    private Object group;
    private int hash;
    private String name;
    private final int[] oid;
    private String sOID;
    private String soid;

    public ObjectIdentifier(int[] iArr) {
        this.hash = -1;
        validateOid(iArr);
        this.oid = iArr;
    }

    public ObjectIdentifier(int[] iArr, String str, Object obj) {
        this(iArr);
        if (obj == null) {
            throw new NullPointerException("oidGroup == null");
        }
        this.group = obj;
        this.name = str;
        toOIDString();
    }

    public static int hashIntArray(int[] iArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length || i3 >= 4) {
                break;
            }
            i += iArr[i3] << (i3 * 8);
            i2 = i3 + 1;
        }
        return Integer.MAX_VALUE & i;
    }

    public static void validateOid(int[] iArr) {
        if (iArr == null) {
            throw new NullPointerException("oid == null");
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

    public Object getGroup() {
        return this.group;
    }

    public String getName() {
        return this.name;
    }

    public int[] getOid() {
        return this.oid;
    }

    public int hashCode() {
        if (this.hash == -1) {
            this.hash = hashIntArray(this.oid);
        }
        return this.hash;
    }

    public String toOIDString() {
        if (this.sOID == null) {
            this.sOID = "OID." + toString();
        }
        return this.sOID;
    }

    public String toString() {
        if (this.soid == null) {
            StringBuilder sb = new StringBuilder(this.oid.length * 4);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oid.length - 1) {
                    break;
                }
                sb.append(this.oid[i2]);
                sb.append('.');
                i = i2 + 1;
            }
            sb.append(this.oid[this.oid.length - 1]);
            this.soid = sb.toString();
        }
        return this.soid;
    }
}
