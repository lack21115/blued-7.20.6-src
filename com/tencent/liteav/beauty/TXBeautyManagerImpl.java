package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::manager")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/TXBeautyManagerImpl.class */
public class TXBeautyManagerImpl implements TXBeautyManager {
    private long mNativeBeautyManager;

    public TXBeautyManagerImpl(long j) {
        this.mNativeBeautyManager = 0L;
        this.mNativeBeautyManager = j;
    }

    private static native void nativeDestroy(long j);

    private static native void nativeEnableSharpnessEnhancement(long j, boolean z);

    private static native void nativeSetBeautyLevel(long j, float f);

    private static native void nativeSetBeautyStyle(long j, int i);

    private static native int nativeSetChinLevel(long j, float f);

    private static native int nativeSetEyeAngleLevel(long j, float f);

    private static native int nativeSetEyeDistanceLevel(long j, float f);

    private static native int nativeSetEyeLightenLevel(long j, float f);

    private static native int nativeSetEyeScaleLevel(long j, float f);

    private static native int nativeSetFaceBeautyLevel(long j, float f);

    private static native int nativeSetFaceNarrowLevel(long j, float f);

    private static native int nativeSetFaceShortLevel(long j, float f);

    private static native int nativeSetFaceSlimLevel(long j, float f);

    private static native int nativeSetFaceVLevel(long j, float f);

    private static native void nativeSetFilter(long j, Bitmap bitmap);

    private static native void nativeSetFilterStrength(long j, float f);

    private static native int nativeSetForeheadLevel(long j, float f);

    private static native int nativeSetGreenScreenFile(long j, String str);

    private static native int nativeSetLipsThicknessLevel(long j, float f);

    private static native void nativeSetMotionMute(long j, boolean z);

    private static native void nativeSetMotionTmpl(long j, String str);

    private static native int nativeSetMouthShapeLevel(long j, float f);

    private static native int nativeSetNosePositionLevel(long j, float f);

    private static native int nativeSetNoseSlimLevel(long j, float f);

    private static native int nativeSetNoseWingLevel(long j, float f);

    private static native int nativeSetPounchRemoveLevel(long j, float f);

    private static native void nativeSetRuddyLevel(long j, float f);

    private static native int nativeSetSmileLinesRemoveLevel(long j, float f);

    private static native int nativeSetToothWhitenLevel(long j, float f);

    private static native void nativeSetWhitenessLevel(long j, float f);

    private static native int nativeSetWrinkleRemoveLevel(long j, float f);

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void enableSharpnessEnhancement(boolean z) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeEnableSharpnessEnhancement(j, z);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeDestroy(j);
            this.mNativeBeautyManager = 0L;
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setBeautyLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetBeautyLevel(j, f);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setBeautyStyle(int i) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetBeautyStyle(j, i);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setChinLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetChinLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setEyeAngleLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetEyeAngleLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setEyeDistanceLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetEyeDistanceLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setEyeLightenLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetEyeLightenLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setEyeScaleLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetEyeScaleLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setFaceBeautyLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetFaceBeautyLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setFaceNarrowLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetFaceNarrowLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setFaceShortLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetFaceShortLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setFaceSlimLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetFaceSlimLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setFaceVLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetFaceVLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setFilter(Bitmap bitmap) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetFilter(j, bitmap);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setFilterStrength(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetFilterStrength(j, f);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setForeheadLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetForeheadLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setGreenScreenFile(String str) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetGreenScreenFile(j, str);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setLipsThicknessLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetLipsThicknessLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setMotionMute(boolean z) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetMotionMute(j, z);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setMotionTmpl(String str) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetMotionTmpl(j, str);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setMouthShapeLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetMouthShapeLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setNosePositionLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetNosePositionLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setNoseSlimLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetNoseSlimLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setNoseWingLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetNoseWingLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setPounchRemoveLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetPounchRemoveLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setRuddyLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetRuddyLevel(j, f);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setSmileLinesRemoveLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetSmileLinesRemoveLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setToothWhitenLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetToothWhitenLevel(j, f);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setWhitenessLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetWhitenessLevel(j, f);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setWrinkleRemoveLevel(float f) {
        long j = this.mNativeBeautyManager;
        if (j != 0) {
            nativeSetWrinkleRemoveLevel(j, f);
            return 0;
        }
        return 0;
    }
}
