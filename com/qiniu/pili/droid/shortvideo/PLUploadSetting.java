package com.qiniu.pili.droid.shortvideo;

import com.qiniu.android.common.FixedZone;
import com.qiniu.android.common.Zone;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLUploadSetting.class */
public class PLUploadSetting {
    private static final String TAG = "PLUploadSetting";
    private int mChunkSize = 2097152;
    private int mPutThreshhold = 4194304;
    private int mConnectTimeout = 10;
    private int mResponseTimeout = 60;
    private boolean mIsHttpsEnabled = false;
    private Zone mZone = null;
    private Map<String, String> mParams = null;

    /* renamed from: com.qiniu.pili.droid.shortvideo.PLUploadSetting$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLUploadSetting$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13817a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[PLUploadZone.values().length];
            f13817a = iArr;
            try {
                iArr[PLUploadZone.ZONE0.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13817a[PLUploadZone.ZONE1.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13817a[PLUploadZone.ZONE2.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13817a[PLUploadZone.ZONENA0.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f13817a[PLUploadZone.ZONEAS0.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLUploadSetting$PLUploadZone.class */
    public enum PLUploadZone {
        ZONE0,
        ZONE1,
        ZONE2,
        ZONENA0,
        ZONEAS0
    }

    public int getChunkSize() {
        return this.mChunkSize;
    }

    public int getConnectTimeout() {
        return this.mConnectTimeout;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public int getPutThreshhold() {
        return this.mPutThreshhold;
    }

    public int getResponseTimeout() {
        return this.mResponseTimeout;
    }

    public Zone getZone() {
        return this.mZone;
    }

    public boolean isHttpsEnabled() {
        return this.mIsHttpsEnabled;
    }

    public PLUploadSetting setChunkSize(int i) {
        this.mChunkSize = i;
        e eVar = e.o;
        eVar.c(TAG, "setChunkSize: " + i);
        return this;
    }

    public PLUploadSetting setConnectTimeout(int i) {
        this.mConnectTimeout = i;
        e eVar = e.o;
        eVar.c(TAG, "setConnectTimeout: " + i);
        return this;
    }

    public PLUploadSetting setHttpsEnabled(boolean z) {
        this.mIsHttpsEnabled = z;
        e eVar = e.o;
        eVar.c(TAG, "setHttpsEnabled: " + z);
        return this;
    }

    public PLUploadSetting setParams(Map<String, String> map) {
        this.mParams = map;
        e.o.c(TAG, "setParams");
        return this;
    }

    public PLUploadSetting setPutThreshhold(int i) {
        this.mPutThreshhold = i;
        e eVar = e.o;
        eVar.c(TAG, "setPutThreshhold: " + i);
        return this;
    }

    public PLUploadSetting setResponseTimeout(int i) {
        this.mResponseTimeout = i;
        e eVar = e.o;
        eVar.c(TAG, "setResponseTimeout: " + i);
        return this;
    }

    public PLUploadSetting setZone(PLUploadZone pLUploadZone) {
        int i = AnonymousClass1.f13817a[pLUploadZone.ordinal()];
        if (i == 1) {
            this.mZone = FixedZone.zone0;
        } else if (i == 2) {
            this.mZone = FixedZone.zone1;
        } else if (i == 3) {
            this.mZone = FixedZone.zone2;
        } else if (i == 4) {
            this.mZone = FixedZone.zoneNa0;
        } else if (i != 5) {
            this.mZone = null;
        } else {
            this.mZone = FixedZone.zoneAs0;
        }
        e eVar = e.o;
        eVar.c(TAG, "setZone: " + pLUploadZone);
        return this;
    }
}
