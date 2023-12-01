package com.huawei.hms.ads;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.iab.omid.library.huawei.adsession.media.Position;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ja.class */
public enum ja implements it {
    PREROLL(IAdInterListener.AdProdType.PRODUCT_PREROLL),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");
    
    private static boolean B;
    private final String C;

    /* renamed from: com.huawei.hms.ads.ja$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ja$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[ja.values().length];
            Code = iArr;
            try {
                iArr[ja.PREROLL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[ja.MIDROLL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Code[ja.POSTROLL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                Code[ja.STANDALONE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static {
        B = false;
        B = ii.Code("com.iab.omid.library.huawei.adsession.media.Position");
    }

    ja(String str) {
        this.C = str;
    }

    public static Position Code(ja jaVar) {
        if (B) {
            int i = AnonymousClass1.Code[jaVar.ordinal()];
            if (i == 1 || i == 2) {
                return Position.PREROLL;
            }
            if (i != 3) {
                if (i != 4) {
                    return null;
                }
                return Position.STANDALONE;
            }
            return Position.POSTROLL;
        }
        return null;
    }

    public static boolean Code() {
        return B;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.C;
    }
}
