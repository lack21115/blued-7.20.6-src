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
        System.arraycopy((Object) bArr, 0, (Object) this.mData, 0, 4);
        this.density = gc.d(this.mData);
        System.arraycopy((Object) bArr, 4, (Object) this.mData, 0, 4);
        this.width = gc.e(this.mData);
        System.arraycopy((Object) bArr, 8, (Object) this.mData, 0, 4);
        this.height = gc.e(this.mData);
        System.arraycopy((Object) bArr, 12, (Object) this.mData, 0, 4);
        this.pitch = gc.e(this.mData);
        System.arraycopy((Object) bArr, 16, (Object) this.mData, 0, 1);
        this.bold = gc.b(this.mData);
    }
}
