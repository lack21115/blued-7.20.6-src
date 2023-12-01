package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.ByteInput;
import com.tencent.tinker.android.dex.util.CompareUtils;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/EncodedValue.class */
public final class EncodedValue extends TableOfContents.Section.Item<EncodedValue> {
    public byte[] data;

    public EncodedValue(int i, byte[] bArr) {
        super(i);
        this.data = bArr;
    }

    public ByteInput asByteInput() {
        return new ByteInput() { // from class: com.tencent.tinker.android.dex.EncodedValue.1
            private int position = 0;

            @Override // com.tencent.tinker.android.dex.util.ByteInput
            public byte readByte() {
                byte[] bArr = EncodedValue.this.data;
                int i = this.position;
                this.position = i + 1;
                return bArr[i];
            }
        };
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return this.data.length * 1;
    }

    @Override // java.lang.Comparable
    public int compareTo(EncodedValue encodedValue) {
        return CompareUtils.uArrCompare(this.data, encodedValue.data);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof EncodedValue) {
            if (compareTo((EncodedValue) obj) == 0) {
                z = true;
            }
            return z;
        }
        return false;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return Arrays.hashCode(this.data);
    }
}
