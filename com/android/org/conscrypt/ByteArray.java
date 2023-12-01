package com.android.org.conscrypt;

import java.util.Arrays;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/ByteArray.class */
final class ByteArray {
    private final byte[] bytes;
    private final int hashCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteArray(byte[] bArr) {
        this.bytes = bArr;
        this.hashCode = Arrays.hashCode(bArr);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ByteArray) {
            return Arrays.equals(this.bytes, ((ByteArray) obj).bytes);
        }
        return false;
    }

    public int hashCode() {
        return this.hashCode;
    }
}
