package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.Owner;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/iv.class */
public enum iv implements it {
    NATIVE(com.anythink.expressad.foundation.g.a.f.f7832a),
    JAVASCRIPT("javascript"),
    NONE("none");
    
    private static boolean Z;
    private final String B;

    /* renamed from: com.huawei.hms.ads.iv$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/iv$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[iv.values().length];
            Code = iArr;
            try {
                iArr[iv.NATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[iv.JAVASCRIPT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Code[iv.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    static {
        Z = false;
        Z = ii.Code(ii.o);
    }

    iv(String str) {
        this.B = str;
    }

    public static Owner Code(iv ivVar) {
        if (Z) {
            int i = AnonymousClass1.Code[ivVar.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return Owner.NONE;
                }
                return Owner.JAVASCRIPT;
            }
            return Owner.NATIVE;
        }
        return null;
    }

    public static boolean Code() {
        return Z;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.B;
    }
}
