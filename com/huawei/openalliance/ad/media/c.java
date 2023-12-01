package com.huawei.openalliance.ad.media;

import com.huawei.hms.ads.ge;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/media/c.class */
public class c {
    private static final String Code = "MediaState";
    private e V = e.IDLE;
    private final byte[] I = new byte[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.openalliance.ad.media.c$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/media/c$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[e.values().length];
            Code = iArr;
            try {
                iArr[e.PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[e.PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Code[e.PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                Code[e.PLAYBACK_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public boolean Code() {
        boolean z;
        synchronized (this.I) {
            int i = AnonymousClass1.Code[this.V.ordinal()];
            z = true;
            if (i != 1) {
                z = true;
                if (i != 2) {
                    z = true;
                    if (i != 3) {
                        z = true;
                        if (i != 4) {
                            z = false;
                        }
                    }
                }
            }
        }
        return z;
    }

    public boolean Code(e eVar) {
        boolean z;
        synchronized (this.I) {
            z = this.V == eVar;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(e eVar) {
        if (eVar == null) {
            return;
        }
        synchronized (this.I) {
            if (this.V != e.END) {
                ge.V(Code, "switchToState: %s", eVar);
                this.V = eVar;
            }
        }
    }

    public int V() {
        int Code2;
        synchronized (this.I) {
            Code2 = this.V.Code();
        }
        return Code2;
    }

    public boolean V(e eVar) {
        return !Code(eVar);
    }

    public String toString() {
        String eVar;
        synchronized (this.I) {
            eVar = this.V.toString();
        }
        return eVar;
    }
}
