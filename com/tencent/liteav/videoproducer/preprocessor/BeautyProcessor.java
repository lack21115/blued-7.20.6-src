package com.tencent.liteav.videoproducer.preprocessor;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.beauty.b.l;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import java.util.HashMap;
import java.util.Map;

@JNINamespace("liteav::video")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/BeautyProcessor.class */
public class BeautyProcessor extends com.tencent.liteav.videobase.a.h {
    private static final String TAG = "TXCBeautyManager";
    private a mBeautyManagerStatusListener;
    private final boolean mIsEnterPriseProEnabled;
    private final IVideoReporter mReporter;
    private int mBeautyStyle = -1;
    private float mBeautyLevel = 0.0f;
    private float mWhitenessLevel = 0.0f;
    private float mRuddyLevel = 0.0f;
    private float mSharpnessLevel = 0.4f;
    private boolean mIsPerformanceMode = true;
    private float mUserSetSharpnessLevel = 0.0f;
    private final Map<String, String> mBeautyStats = new HashMap();
    private final SparseArray<com.tencent.liteav.videobase.a.b> mBeautyFilters = new SparseArray<>();
    private final com.tencent.liteav.beauty.b.l mMotionFilter = new com.tencent.liteav.beauty.b.l() { // from class: com.tencent.liteav.a.a.1
        @Override // com.tencent.liteav.videobase.a.b
        public final boolean canBeSkipped() {
            return true;
        }
    };

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/BeautyProcessor$a.class */
    public interface a {
        void onBeautyStatsChanged(String str);
    }

    public BeautyProcessor(Context context, boolean z, IVideoReporter iVideoReporter) {
        this.mReporter = iVideoReporter;
        this.mIsEnterPriseProEnabled = z;
    }

    private float getSharpnessLevel() {
        float f = this.mUserSetSharpnessLevel;
        return f != 0.0f ? f : (this.mIsPerformanceMode || Math.min(this.mOutputSize.f36340a, this.mOutputSize.b) < 540) ? 0.0f : 0.4f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setBeautyLevel$1(BeautyProcessor beautyProcessor, float f) {
        beautyProcessor.updateBeautyInternal(beautyProcessor.mBeautyStyle, f, beautyProcessor.mWhitenessLevel, beautyProcessor.mRuddyLevel, beautyProcessor.mSharpnessLevel);
        if (f > 0.0f) {
            com.tencent.liteav.beauty.a.b(beautyProcessor.mReporter);
        }
        beautyProcessor.updateStatsInternal("beautyLevel", f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setPerformanceMode$6(BeautyProcessor beautyProcessor, boolean z) {
        beautyProcessor.mIsPerformanceMode = z;
        beautyProcessor.updateSharpenLevelInternal();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setRuddyLevel$4(BeautyProcessor beautyProcessor, float f) {
        beautyProcessor.updateBeautyInternal(beautyProcessor.mBeautyStyle, beautyProcessor.mBeautyLevel, beautyProcessor.mWhitenessLevel, f, beautyProcessor.mSharpnessLevel);
        if (f > 0.0f) {
            com.tencent.liteav.beauty.a.e(beautyProcessor.mReporter);
        }
        beautyProcessor.updateStatsInternal("ruddyLevel", f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setSharpenLevel$3(BeautyProcessor beautyProcessor, float f) {
        beautyProcessor.mUserSetSharpnessLevel = com.tencent.liteav.base.util.h.a(f, 0.0f, 0.9f);
        LiteavLog.d(TAG, "mUserSetSharpnessLevel: " + beautyProcessor.mUserSetSharpnessLevel);
        beautyProcessor.updateSharpenLevelInternal();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setWhitenessLevel$2(BeautyProcessor beautyProcessor, float f) {
        beautyProcessor.updateBeautyInternal(beautyProcessor.mBeautyStyle, beautyProcessor.mBeautyLevel, f, beautyProcessor.mRuddyLevel, beautyProcessor.mSharpnessLevel);
        if (f > 0.0f) {
            com.tencent.liteav.beauty.a.c(beautyProcessor.mReporter);
        }
        beautyProcessor.updateStatsInternal("whiteLevel", f);
    }

    private void setScalableCosmeticTypeLevel(l.a aVar, int i) {
        LiteavLog.d(TAG, "setScalableCosmeticTypeLevel %s %d", aVar, Integer.valueOf(i));
        if (!this.mIsEnterPriseProEnabled) {
            LiteavLog.i(TAG, "need support EnterPrise above!!!");
        } else if (i > 0) {
            com.tencent.liteav.beauty.a.a(this.mReporter, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBeautyInternal(int i, float f, float f2, float f3, float f4) {
        if (this.mOutputSize.f36340a == -1 || this.mOutputSize.b == -1) {
            return;
        }
        if (this.mBeautyStyle != i) {
            updateStatsOnDraw("beautyStyle", i);
        }
        com.tencent.liteav.videobase.a.b bVar = this.mBeautyFilters.get(i);
        com.tencent.liteav.beauty.b.a aVar = bVar;
        if (bVar == null) {
            aVar = i != 0 ? i != 1 ? i != 2 ? new com.tencent.liteav.beauty.b.a() : new com.tencent.liteav.beauty.b.a.a() : new com.tencent.liteav.beauty.b.c.a() : new com.tencent.liteav.beauty.b.b.a();
            aVar.initialize(this.mTexturePool);
            aVar.onOutputSizeChanged(this.mOutputSize.f36340a, this.mOutputSize.b);
            this.mBeautyFilters.put(i, aVar);
        }
        com.tencent.liteav.beauty.b.b bVar2 = (com.tencent.liteav.beauty.b.b) aVar;
        bVar2.a(f);
        bVar2.c(f3);
        bVar2.b(f2);
        bVar2.d(f4);
        boolean z = true;
        if (this.mBeautyStyle == i) {
            z = true;
            if (this.mBeautyLevel == f) {
                z = true;
                if (this.mWhitenessLevel == f2) {
                    z = true;
                    if (this.mRuddyLevel == f3) {
                        z = this.mSharpnessLevel != f4;
                    }
                }
            }
        }
        if (z) {
            this.mBeautyStyle = i;
            this.mBeautyLevel = f;
            this.mWhitenessLevel = f2;
            this.mRuddyLevel = f3;
            this.mSharpnessLevel = f4;
            removeAllFilterAndInterceptor();
            if (this.mBeautyLevel > 0.0f || this.mRuddyLevel > 0.0f || this.mWhitenessLevel > 0.0f || this.mSharpnessLevel > 0.0f) {
                addFilter(aVar);
            }
            addFilter(this.mMotionFilter);
        }
    }

    private void updateSharpenLevelInternal() {
        float sharpnessLevel = getSharpnessLevel();
        LiteavLog.d(TAG, "sharpnessLevel: ".concat(String.valueOf(sharpnessLevel)));
        updateBeautyInternal(this.mBeautyStyle, this.mBeautyLevel, this.mWhitenessLevel, this.mRuddyLevel, sharpnessLevel);
        if (sharpnessLevel > 0.0f) {
            com.tencent.liteav.beauty.a.d(this.mReporter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStatsInternal(String str, float f) {
        this.mBeautyStats.put(str, String.valueOf(f));
        if (this.mBeautyManagerStatusListener == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.mBeautyStats.entrySet()) {
            sb.append(entry.getKey());
            sb.append(":");
            sb.append(entry.getValue());
            sb.append(" ");
        }
        this.mBeautyManagerStatusListener.onBeautyStatsChanged("{" + ((Object) sb) + com.alipay.sdk.util.i.d);
    }

    @Override // com.tencent.liteav.videobase.a.h, com.tencent.liteav.videobase.a.b
    public void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.mMotionFilter.initialize(eVar);
        int i = this.mBeautyStyle;
        if (i == -1) {
            i = 0;
        }
        updateBeautyInternal(i, this.mBeautyLevel, this.mWhitenessLevel, this.mRuddyLevel, this.mSharpnessLevel);
    }

    @Override // com.tencent.liteav.videobase.a.h, com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        this.mMotionFilter.onOutputSizeChanged(i, i2);
        float sharpnessLevel = getSharpnessLevel();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.mBeautyFilters.size()) {
                break;
            }
            com.tencent.liteav.videobase.a.b valueAt = this.mBeautyFilters.valueAt(i4);
            valueAt.onOutputSizeChanged(i, i2);
            if (valueAt instanceof com.tencent.liteav.beauty.b.b) {
                ((com.tencent.liteav.beauty.b.b) valueAt).d(sharpnessLevel);
            }
            i3 = i4 + 1;
        }
        int i5 = this.mBeautyStyle;
        if (i5 == -1) {
            i5 = 0;
        }
        updateBeautyInternal(i5, this.mBeautyLevel, this.mWhitenessLevel, this.mRuddyLevel, sharpnessLevel);
    }

    @Override // com.tencent.liteav.videobase.a.h, com.tencent.liteav.videobase.a.b
    public void onUninit() {
        super.onUninit();
        this.mMotionFilter.uninitialize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mBeautyFilters.size()) {
                return;
            }
            this.mBeautyFilters.valueAt(i2).uninitialize();
            i = i2 + 1;
        }
    }

    public void setAIDetectListener(com.tencent.liteav.videobase.base.a aVar) {
    }

    public void setBeautyLevel(float f) {
        float a2 = com.tencent.liteav.base.util.h.a(f, 0.0f, 0.9f);
        LiteavLog.d(TAG, "setBeautyLevel beautyLevel:".concat(String.valueOf(f)));
        runOnDraw(b.a(this, a2));
    }

    public void setBeautyManagerStatusListener(a aVar) {
        this.mBeautyManagerStatusListener = aVar;
    }

    public void setBeautyStyle(int i) {
        LiteavLog.d(TAG, "setBeautyStyle beautyStyle:".concat(String.valueOf(i)));
        runOnDraw(com.tencent.liteav.videoproducer.preprocessor.a.a(this, i));
    }

    public void setChinLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.CHIN_SCALE, i);
        updateStatsOnDraw("chinLevel", i);
    }

    public void setEyeAngleLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.EYE_ANGLE, i);
        updateStatsOnDraw("eyeAngleLevel", i);
    }

    public void setEyeDistanceLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.EYE_DISTANCE, i);
        updateStatsOnDraw("eyeDistanceLevel", i);
    }

    public void setEyeLightenLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.EYE_LIGHTEN, i);
        updateStatsOnDraw("eyeLightenLevel", i);
    }

    public void setEyeScaleLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.EYE_SCALE, i);
        updateStatsOnDraw("eyeBigScale", i);
    }

    public void setFaceBeautyLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.BASIC3, i);
        updateStatsOnDraw("faceBeautyLevel", i);
    }

    public void setFaceNarrowLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.FACE_NARROW, i);
        updateStatsOnDraw("faceNarrowLevel", i);
    }

    public void setFaceShortLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.FACE_SHORT, i);
        updateStatsOnDraw("faceShortLevel", i);
    }

    public void setFaceSlimLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.FACE_SLIM, i);
        updateStatsOnDraw("faceSlimLevel", i);
    }

    public void setFaceVLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.FACE_V_SHAPE, i);
        updateStatsOnDraw("faceVLevel", i);
    }

    public void setForeheadLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.FOREHEAD, i);
        updateStatsOnDraw("foreheadLevel", i);
    }

    public void setHomeOrientation(int i) {
    }

    public void setLipsThicknessLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.LIPS_THICKNESS, i);
        updateStatsOnDraw("lipsThicknessLevel", i);
    }

    public void setMotionMute(boolean z) {
        LiteavLog.d(TAG, "setMotionMute motionMute:".concat(String.valueOf(z)));
    }

    public void setMotionTmpl(String str) {
        LiteavLog.d(TAG, "setMotionTmpl tmplPath:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.liteav.beauty.a.g(this.mReporter);
    }

    public void setMouthShapeLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.MOUTH_SHAPE, i);
        updateStatsOnDraw("mouthShapeLevel", i);
    }

    public void setNosePositionLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.NOSE_POSITION, i);
        updateStatsOnDraw("nosePositionLevel", i);
    }

    public void setNoseSlimLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.NOSE_SLIM, i);
        updateStatsOnDraw("noseSlimLevel", i);
    }

    public void setNoseWingLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.NOSE_WING, i);
        updateStatsOnDraw("noseWingLevel", i);
    }

    public void setPerformanceMode(boolean z) {
        LiteavLog.d(TAG, "setPerformanceMode: ".concat(String.valueOf(z)));
        runOnDraw(g.a(this, z));
    }

    public void setPounchRemoveLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.REMOVE_POUNCH, i);
        updateStatsOnDraw("pounchRemoveLevel", i);
    }

    public void setRuddyLevel(float f) {
        float a2 = com.tencent.liteav.base.util.h.a(f, 0.0f, 0.9f);
        LiteavLog.d(TAG, "setRuddyLevel ruddyLevel:".concat(String.valueOf(f)));
        runOnDraw(e.a(this, a2));
    }

    public void setSharpenLevel(float f) {
        runOnDraw(d.a(this, f));
    }

    public void setSmileLinesRemoveLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.REMOVE_SMILE_LINES, i);
        updateStatsOnDraw("smileLinesRemoveLevel", i);
    }

    public void setToothWhitenLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.TOOTH_WHITEN, i);
        updateStatsOnDraw("toothWhitenLevel", i);
    }

    public void setWhitenessLevel(float f) {
        float a2 = com.tencent.liteav.base.util.h.a(f, 0.0f, 0.9f);
        LiteavLog.d(TAG, "setWhitenessLevel whitenessLevel:".concat(String.valueOf(f)));
        runOnDraw(c.a(this, a2));
    }

    public void setWrinkleRemoveLevel(int i) {
        setScalableCosmeticTypeLevel(l.a.REMOVE_WRINKLES, i);
        updateStatsOnDraw("wrinkleRemoveLevel", i);
    }

    public void updateStatsOnDraw(String str, int i) {
        runOnDraw(f.a(this, str, i));
    }
}
