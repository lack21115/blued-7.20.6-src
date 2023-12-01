package com.huawei.hms.ads;

import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.iab.omid.library.huawei.adsession.media.PlayerState;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/je.class */
public enum je implements it {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL("normal"),
    EXPANDED(CallMraidJS.g),
    FULLSCREEN("fullscreen");
    
    private static boolean C;
    private final String S;

    /* renamed from: com.huawei.hms.ads.je$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/je$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[je.values().length];
            Code = iArr;
            try {
                iArr[je.MINIMIZED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[je.COLLAPSED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Code[je.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                Code[je.EXPANDED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                Code[je.FULLSCREEN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    static {
        C = false;
        C = ii.Code("com.iab.omid.library.huawei.adsession.media.PlayerState");
    }

    je(String str) {
        this.S = str;
    }

    public static PlayerState Code(je jeVar) {
        if (C) {
            int i = AnonymousClass1.Code[jeVar.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            return PlayerState.FULLSCREEN;
                        }
                        return PlayerState.EXPANDED;
                    }
                    return PlayerState.NORMAL;
                }
                return PlayerState.COLLAPSED;
            }
            return PlayerState.MINIMIZED;
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
