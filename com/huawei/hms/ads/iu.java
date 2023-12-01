package com.huawei.hms.ads;

import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.iab.omid.library.huawei.adsession.ImpressionType;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/iu.class */
public enum iu implements it {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    UNSPECIFIED("unspecified"),
    LOADED("loaded"),
    BEGIN_TO_RENDER("beginToRender"),
    ONE_PIXEL("onePixel"),
    VIEWABLE(CallMraidJS.f7086c),
    AUDIBLE("audible"),
    OTHER("other");
    
    private static boolean D;
    private final String L;

    /* renamed from: com.huawei.hms.ads.iu$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/iu$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0065 -> B:41:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0069 -> B:37:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0071 -> B:43:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0075 -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0079 -> B:35:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007d -> B:47:0x0058). Please submit an issue!!! */
        static {
            int[] iArr = new int[iu.values().length];
            Code = iArr;
            try {
                iArr[iu.DEFINED_BY_JAVASCRIPT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[iu.UNSPECIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Code[iu.LOADED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                Code[iu.BEGIN_TO_RENDER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                Code[iu.ONE_PIXEL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                Code[iu.VIEWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                Code[iu.AUDIBLE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                Code[iu.OTHER.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    static {
        D = false;
        D = ii.Code(ii.n);
    }

    iu(String str) {
        this.L = str;
    }

    public static ImpressionType Code(iu iuVar) {
        if (D) {
            switch (AnonymousClass1.Code[iuVar.ordinal()]) {
                case 1:
                    return ImpressionType.DEFINED_BY_JAVASCRIPT;
                case 2:
                    return ImpressionType.UNSPECIFIED;
                case 3:
                    return ImpressionType.LOADED;
                case 4:
                    return ImpressionType.BEGIN_TO_RENDER;
                case 5:
                    return ImpressionType.ONE_PIXEL;
                case 6:
                    return ImpressionType.VIEWABLE;
                case 7:
                    return ImpressionType.AUDIBLE;
                case 8:
                    return ImpressionType.OTHER;
                default:
                    return null;
            }
        }
        return null;
    }

    public static boolean Code() {
        return D;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.L;
    }
}
