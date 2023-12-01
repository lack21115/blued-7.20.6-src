package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STYuvImage.class */
public class STYuvImage {
    public int format = 3;
    public int height;
    public byte[] planes0;
    public byte[] planes1;
    public byte[] planes2;
    public int[] strides;
    public int width;

    public STYuvImage(byte[] bArr, int i, int i2) {
        this.strides = r0;
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        this.planes0 = bArr2;
        int i4 = i3 / 2;
        this.planes1 = new byte[i4];
        this.height = i2;
        this.width = i;
        int[] iArr = {i, i, i};
        System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, i3);
        System.arraycopy((Object) bArr, i3, (Object) this.planes1, 0, i4);
    }
}
