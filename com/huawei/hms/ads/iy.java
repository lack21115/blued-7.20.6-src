package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.InteractionType;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/iy.class */
public enum iy implements it {
    CLICK("click"),
    INVITATION_ACCEPTED("invitationAccept");
    
    private static boolean Z;
    String I;

    /* renamed from: com.huawei.hms.ads.iy$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/iy$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[iy.values().length];
            Code = iArr;
            try {
                iArr[iy.CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[iy.INVITATION_ACCEPTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    static {
        Z = false;
        Z = ii.Code("com.iab.omid.library.huawei.adsession.media.InteractionType");
    }

    iy(String str) {
        this.I = str;
    }

    public static InteractionType Code(iy iyVar) {
        if (Z) {
            int i = AnonymousClass1.Code[iyVar.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return InteractionType.INVITATION_ACCEPTED;
            }
            return InteractionType.CLICK;
        }
        return null;
    }

    public static boolean Code() {
        return Z;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.I;
    }
}
