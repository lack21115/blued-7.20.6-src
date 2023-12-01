package com.android.dex;

import com.android.dex.Dex;
import com.android.dex.util.ByteArrayByteInput;
import com.android.dex.util.ByteInput;

/* loaded from: source-2895416-dex2jar.jar:com/android/dex/EncodedValue.class */
public final class EncodedValue implements Comparable<EncodedValue> {
    private final byte[] data;

    public EncodedValue(byte[] bArr) {
        this.data = bArr;
    }

    public ByteInput asByteInput() {
        return new ByteArrayByteInput(this.data);
    }

    @Override // java.lang.Comparable
    public int compareTo(EncodedValue encodedValue) {
        int min = Math.min(this.data.length, encodedValue.data.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= min) {
                return this.data.length - encodedValue.data.length;
            }
            if (this.data[i2] != encodedValue.data[i2]) {
                return (this.data[i2] & 255) - (encodedValue.data[i2] & 255);
            }
            i = i2 + 1;
        }
    }

    public byte[] getBytes() {
        return this.data;
    }

    public String toString() {
        return Integer.toHexString(this.data[0] & 255) + "...(" + this.data.length + ")";
    }

    public void writeTo(Dex.Section section) {
        section.write(this.data);
    }
}
