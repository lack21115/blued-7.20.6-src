package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.constant.bm;
import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/k.class */
public class k implements Serializable {
    private static final long Code = 30414300;
    private int B;
    private int C;
    private String D;
    private boolean F;
    private String I;
    private String S;
    private String V;
    private int Z;

    public k() {
        this.Z = 0;
        this.B = 0;
    }

    public k(ImageInfo imageInfo) {
        boolean z = false;
        this.Z = 0;
        this.B = 0;
        if (imageInfo != null) {
            this.V = imageInfo.I();
            String I = imageInfo.I();
            this.I = I;
            if (!TextUtils.isEmpty(I) && !this.I.startsWith(bm.HTTP.toString()) && !this.I.startsWith(bm.HTTPS.toString())) {
                this.I = imageInfo.F();
            }
            this.Z = imageInfo.Z();
            this.B = imageInfo.B();
            this.S = imageInfo.Code();
            this.D = imageInfo.V();
            this.C = imageInfo.C();
            this.F = imageInfo.S() == 0 ? true : z;
        }
    }

    public int B() {
        return this.B;
    }

    public int C() {
        return this.Z;
    }

    public void Code(String str) {
        this.I = str;
    }

    public boolean Code() {
        String str = this.V;
        return str != null && str.startsWith(bm.CONTENT.toString());
    }

    public String D() {
        return this.I;
    }

    public int F() {
        return this.C;
    }

    public String I() {
        return this.S;
    }

    public boolean S() {
        return this.F;
    }

    public String V() {
        return this.D;
    }

    public String Z() {
        return this.V;
    }
}
