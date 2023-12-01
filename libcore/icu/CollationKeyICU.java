package libcore.icu;

import java.text.CollationKey;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/CollationKeyICU.class */
public final class CollationKeyICU extends CollationKey {
    private final byte[] bytes;
    private int hashCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CollationKeyICU(String str, byte[] bArr) {
        super(str);
        this.bytes = bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r4.length == 0) goto L39;
     */
    @Override // java.text.CollationKey, java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(java.text.CollationKey r4) {
        /*
            r3 = this;
            r0 = -1
            r7 = r0
            r0 = r4
            boolean r0 = r0 instanceof libcore.icu.CollationKeyICU
            if (r0 == 0) goto L31
            r0 = r4
            libcore.icu.CollationKeyICU r0 = (libcore.icu.CollationKeyICU) r0
            byte[] r0 = r0.bytes
            r4 = r0
        L12:
            r0 = r3
            byte[] r0 = r0.bytes
            if (r0 == 0) goto L21
            r0 = r3
            byte[] r0 = r0.bytes
            int r0 = r0.length
            if (r0 != 0) goto L39
        L21:
            r0 = r4
            if (r0 == 0) goto L2d
            r0 = r7
            r5 = r0
            r0 = r4
            int r0 = r0.length
            if (r0 != 0) goto L2f
        L2d:
            r0 = 0
            r5 = r0
        L2f:
            r0 = r5
            return r0
        L31:
            r0 = r4
            byte[] r0 = r0.toByteArray()
            r4 = r0
            goto L12
        L39:
            r0 = r4
            if (r0 == 0) goto L42
            r0 = r4
            int r0 = r0.length
            if (r0 != 0) goto L44
        L42:
            r0 = 1
            return r0
        L44:
            r0 = r3
            byte[] r0 = r0.bytes
            int r0 = r0.length
            r1 = r4
            int r1 = r1.length
            int r0 = java.lang.Math.min(r0, r1)
            r8 = r0
            r0 = 0
            r6 = r0
        L52:
            r0 = r6
            r1 = r8
            if (r0 >= r1) goto L87
            r0 = r3
            byte[] r0 = r0.bytes
            r1 = r6
            r0 = r0[r1]
            r1 = 255(0xff, float:3.57E-43)
            r0 = r0 & r1
            r9 = r0
            r0 = r4
            r1 = r6
            r0 = r0[r1]
            r1 = 255(0xff, float:3.57E-43)
            r0 = r0 & r1
            r10 = r0
            r0 = r7
            r5 = r0
            r0 = r9
            r1 = r10
            if (r0 < r1) goto L2f
            r0 = r9
            r1 = r10
            if (r0 <= r1) goto L80
            r0 = 1
            return r0
        L80:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L52
        L87:
            r0 = r7
            r5 = r0
            r0 = r3
            byte[] r0 = r0.bytes
            int r0 = r0.length
            r1 = r4
            int r1 = r1.length
            if (r0 < r1) goto L2f
            r0 = r3
            byte[] r0 = r0.bytes
            int r0 = r0.length
            r1 = r4
            int r1 = r1.length
            if (r0 <= r1) goto La0
            r0 = 1
            return r0
        La0:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: libcore.icu.CollationKeyICU.compareTo(java.text.CollationKey):int");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof CollationKey) && compareTo((CollationKey) obj) == 0;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            if (this.bytes != null && this.bytes.length != 0) {
                int length = this.bytes.length;
                int i = (length - 32) / 32;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    this.hashCode = (this.hashCode * 37) + this.bytes[i3];
                    i2 = i3 + i + 1;
                }
            }
            if (this.hashCode == 0) {
                this.hashCode = 1;
            }
        }
        return this.hashCode;
    }

    @Override // java.text.CollationKey
    public byte[] toByteArray() {
        if (this.bytes == null || this.bytes.length == 0) {
            return null;
        }
        return (byte[]) this.bytes.clone();
    }
}
