package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.Position;
import com.iab.omid.library.huawei.adsession.media.VastProperties;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jb.class */
public class jb implements it {
    private static boolean Code = ii.Code("com.iab.omid.library.huawei.adsession.media.VastProperties");
    private final ja B;
    private Float C;
    private final boolean I;
    private final boolean V;
    private final VastProperties Z;

    private jb(float f, boolean z, ja jaVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.C = Float.valueOf(f);
        this.I = z;
        this.B = jaVar;
        this.Z = vastProperties;
    }

    private jb(boolean z, ja jaVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.I = z;
        this.B = jaVar;
        this.Z = vastProperties;
    }

    public static jb Code(float f, boolean z, ja jaVar) {
        Position Code2;
        return new jb(f, z, jaVar, (jaVar == null || !Code() || (Code2 = ja.Code(jaVar)) == null) ? null : VastProperties.createVastPropertiesForSkippableMedia(f, z, Code2));
    }

    public static jb Code(boolean z, ja jaVar) {
        Position Code2;
        return new jb(z, jaVar, (jaVar == null || !Code() || (Code2 = ja.Code(jaVar)) == null) ? null : VastProperties.createVastPropertiesForNonSkippableMedia(z, Code2));
    }

    public static boolean Code() {
        return Code;
    }

    public ja B() {
        return this.B;
    }

    public VastProperties C() {
        return this.Z;
    }

    public Float I() {
        return this.C;
    }

    public boolean V() {
        return false;
    }

    public boolean Z() {
        return this.I;
    }
}
