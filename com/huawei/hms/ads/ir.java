package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.FriendlyObstructionPurpose;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ir.class */
public enum ir implements it {
    VIDEO_CONTROLS,
    CLOSE_AD,
    NOT_VISIBLE,
    OTHER;
    
    private static boolean B;

    /* renamed from: com.huawei.hms.ads.ir$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ir$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[ir.values().length];
            Code = iArr;
            try {
                iArr[ir.VIDEO_CONTROLS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[ir.CLOSE_AD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Code[ir.NOT_VISIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                Code[ir.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static {
        B = false;
        B = ii.Code(ii.m);
    }

    public static FriendlyObstructionPurpose Code(ir irVar) {
        if (B) {
            int i = AnonymousClass1.Code[irVar.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return FriendlyObstructionPurpose.OTHER;
                    }
                    return FriendlyObstructionPurpose.NOT_VISIBLE;
                }
                return FriendlyObstructionPurpose.CLOSE_AD;
            }
            return FriendlyObstructionPurpose.VIDEO_CONTROLS;
        }
        return null;
    }

    public static boolean Code() {
        return B;
    }
}
