package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.download.app.k;
import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/TextState.class */
public class TextState implements Serializable {
    private static final long serialVersionUID = 30420300;
    private int defaultTextFlag;
    private String language;
    private int showPosition;
    private int state;
    private String text;

    /* renamed from: com.huawei.openalliance.ad.beans.metadata.TextState$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/TextState$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[k.values().length];
            Code = iArr;
            try {
                iArr[k.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[k.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Code[k.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                Code[k.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                Code[k.INSTALL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                Code[k.INSTALLING.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static int Code(k kVar) {
        switch (AnonymousClass1.Code[kVar.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 3;
            case 3:
                return 2;
            case 4:
                return 6;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                return -1;
        }
    }

    public int B() {
        return this.defaultTextFlag;
    }

    public int Code() {
        return this.showPosition;
    }

    public String I() {
        return this.language;
    }

    public int V() {
        return this.state;
    }

    public String Z() {
        return this.text;
    }
}
