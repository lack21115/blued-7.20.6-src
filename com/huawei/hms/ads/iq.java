package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.ErrorType;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/iq.class */
public enum iq implements it {
    GENERIC("generic"),
    VIDEO("video");
    
    private static final boolean I = ii.Code(ii.l);
    private final String Z;

    /* renamed from: com.huawei.hms.ads.iq$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/iq$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[iq.values().length];
            Code = iArr;
            try {
                iArr[iq.GENERIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[iq.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    iq(String str) {
        this.Z = str;
    }

    public static ErrorType Code(iq iqVar) {
        if (I) {
            int i = AnonymousClass1.Code[iqVar.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return ErrorType.VIDEO;
            }
            return ErrorType.GENERIC;
        }
        return null;
    }

    public static boolean Code() {
        return I;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.Z;
    }
}
