package com.android.dex.util;

/* loaded from: source-2895416-dex2jar.jar:com/android/dex/util/ByteArrayByteInput.class */
public final class ByteArrayByteInput implements ByteInput {
    private final byte[] bytes;
    private int position;

    public ByteArrayByteInput(byte... bArr) {
        this.bytes = bArr;
    }

    @Override // com.android.dex.util.ByteInput
    public byte readByte() {
        byte[] bArr = this.bytes;
        int i = this.position;
        this.position = i + 1;
        return bArr[i];
    }
}
