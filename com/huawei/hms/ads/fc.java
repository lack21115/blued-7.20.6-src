package com.huawei.hms.ads;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fc.class */
public class fc {
    int Code;
    int I;
    Bitmap V;

    fc() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(int i, Bitmap bitmap, int i2) {
        this.Code = i;
        this.V = bitmap;
        this.I = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc Code() {
        fc fcVar = new fc();
        fcVar.Code = this.Code;
        fcVar.I = this.I;
        return fcVar;
    }

    public String toString() {
        return "GifFrame{frameIndex=" + this.Code + ", delay=" + this.I + '}';
    }
}
