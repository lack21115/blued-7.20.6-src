package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.Position;
import com.iab.omid.library.huawei.adsession.media.VastProperties;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jg.class */
public class jg implements it {
    private static boolean Code = ii.Code("com.iab.omid.library.huawei.adsession.media.VastProperties");
    private final jf B;
    private Float C;
    private final boolean I;
    private final boolean V;
    private final VastProperties Z;

    private jg(float f, boolean z, jf jfVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.C = Float.valueOf(f);
        this.I = z;
        this.B = jfVar;
        this.Z = vastProperties;
    }

    private jg(boolean z, jf jfVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.I = z;
        this.B = jfVar;
        this.Z = vastProperties;
    }

    public static jg Code(float f, boolean z, jf jfVar) {
        Position Code2;
        return new jg(f, z, jfVar, (jfVar == null || !Code() || (Code2 = jf.Code(jfVar)) == null) ? null : VastProperties.createVastPropertiesForSkippableMedia(f, z, Code2));
    }

    public static jg Code(boolean z, jf jfVar) {
        if (Code) {
            VastProperties vastProperties = null;
            if (jfVar != null) {
                vastProperties = null;
                if (jf.Code()) {
                    Position Code2 = jf.Code(jfVar);
                    vastProperties = null;
                    if (Code2 != null) {
                        vastProperties = VastProperties.createVastPropertiesForNonSkippableMedia(z, Code2);
                    }
                }
            }
            return new jg(z, jfVar, vastProperties);
        }
        return null;
    }

    public static boolean Code() {
        return Code;
    }

    public VastProperties V() {
        return this.Z;
    }
}
