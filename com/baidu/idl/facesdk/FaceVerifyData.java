package com.baidu.idl.facesdk;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/idl/facesdk/FaceVerifyData.class */
public class FaceVerifyData {
    public int cols;
    public byte[] mRegDigest;
    public int[] mRegImg;
    public int[] mRegLdmk;
    public int nPoints;
    public int rows;

    FaceVerifyData() {
    }

    FaceVerifyData(int[] iArr, int[] iArr2, byte[] bArr, int i, int i2, int i3) {
        this.mRegImg = iArr;
        this.mRegLdmk = iArr2;
        this.mRegDigest = bArr;
        this.rows = i;
        this.cols = i2;
        this.nPoints = i3;
    }
}
