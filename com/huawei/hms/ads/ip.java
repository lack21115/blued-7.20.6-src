package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.CreativeType;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ip.class */
public enum ip implements it {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO("video"),
    AUDIO("audio");
    
    private static boolean C;
    private final String S;

    /* renamed from: com.huawei.hms.ads.ip$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ip$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[ip.values().length];
            Code = iArr;
            try {
                iArr[ip.DEFINED_BY_JAVASCRIPT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[ip.HTML_DISPLAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Code[ip.NATIVE_DISPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                Code[ip.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                Code[ip.AUDIO.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    static {
        C = false;
        C = ii.Code(ii.k);
    }

    ip(String str) {
        this.S = str;
    }

    public static CreativeType Code(ip ipVar) {
        if (C) {
            int i = AnonymousClass1.Code[ipVar.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            return CreativeType.AUDIO;
                        }
                        return CreativeType.VIDEO;
                    }
                    return CreativeType.NATIVE_DISPLAY;
                }
                return CreativeType.HTML_DISPLAY;
            }
            return CreativeType.DEFINED_BY_JAVASCRIPT;
        }
        return null;
    }

    public static boolean Code() {
        return C;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.S;
    }
}
