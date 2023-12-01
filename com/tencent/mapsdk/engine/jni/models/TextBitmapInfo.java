package com.tencent.mapsdk.engine.jni.models;

import com.tencent.mapsdk.internal.gc;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/engine/jni/models/TextBitmapInfo.class */
public class TextBitmapInfo {
    public boolean bold;
    public float density;
    public int height;
    public byte[] mData = new byte[4];
    public int pitch;
    public int width;

    public void fill(byte[] bArr) {
        Arrays.fill(this.mData, (byte) 0);
        System.arraycopy(bArr, 0, this.mData, 0, 4);
        this.density = gc.d(this.mData);
        System.arraycopy(bArr, 4, this.mData, 0, 4);
        this.width = gc.e(this.mData);
        System.arraycopy(bArr, 8, this.mData, 0, 4);
        this.height = gc.e(this.mData);
        System.arraycopy(bArr, 12, this.mData, 0, 4);
        this.pitch = gc.e(this.mData);
        System.arraycopy(bArr, 16, this.mData, 0, 1);
        this.bold = gc.b(this.mData);
    }
}
