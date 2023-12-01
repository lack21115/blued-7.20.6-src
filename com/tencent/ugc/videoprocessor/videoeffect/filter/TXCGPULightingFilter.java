package com.tencent.ugc.videoprocessor.videoeffect.filter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.d;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;
import java.io.IOException;
import java.nio.FloatBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPULightingFilter.class */
public class TXCGPULightingFilter extends TXCGPUEffectFilterBase {
    private static final int DURATION_LIGHTNING_LV1 = 50;
    private static final int DURATION_LIGHTNING_LV2 = 150;
    private static final int DURATION_LIGHTNING_LV3 = 250;
    private static final int DURATION_LIGHTNING_LV4 = 300;
    private static final int DURATION_LIGHTNING_LV5 = 400;
    private static final int DURATION_LIGHTNING_LV6 = 580;
    private static final String TAG = "TXCGPULightingFilter";
    private final Context mContext;
    private e mGLTexturePool;
    private TXCGPULookUpInvertFilter mLookUpInvertFilter = null;
    private TXCGPULookUpFilter mLookUpFilter = null;
    private LightningParam mLightningParam = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPULightingFilter$LightningParam.class */
    public static class LightningParam extends TXCGPUEffectFilterBase.VideoEffectParams {
        public float lightningLevel = 0.0f;
    }

    public TXCGPULightingFilter(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private void updateParams() {
        LightningParam lightningParam = this.mLightningParam;
        if (lightningParam != null) {
            TXCGPULookUpInvertFilter tXCGPULookUpInvertFilter = this.mLookUpInvertFilter;
            if (tXCGPULookUpInvertFilter != null) {
                tXCGPULookUpInvertFilter.setIntensity(lightningParam.lightningLevel / 5.0f);
                this.mLookUpInvertFilter.setInvertLevel(this.mLightningParam.lightningLevel * 1.5f);
            }
            TXCGPULookUpFilter tXCGPULookUpFilter = this.mLookUpFilter;
            if (tXCGPULookUpFilter != null) {
                tXCGPULookUpFilter.setIntensity(this.mLightningParam.lightningLevel / 5.0f);
            }
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onDraw(int i, d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (isInitialized()) {
            runPendingOnDrawTasks();
            LightningParam lightningParam = this.mLightningParam;
            if (lightningParam == null || lightningParam.lightningLevel <= 0.0f) {
                return;
            }
            d dVar2 = null;
            int i2 = i;
            if (this.mLookUpInvertFilter != null) {
                dVar2 = this.mGLTexturePool.a(this.mOutputSize.f22649a, this.mOutputSize.b);
                this.mLookUpInvertFilter.onDraw(i, dVar2, floatBuffer, floatBuffer2);
                i2 = dVar2.a();
            }
            TXCGPULookUpFilter tXCGPULookUpFilter = this.mLookUpFilter;
            if (tXCGPULookUpFilter != null) {
                tXCGPULookUpFilter.onDraw(i2, dVar, floatBuffer, floatBuffer2);
            }
            if (dVar2 != null) {
                dVar2.release();
            }
        }
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase, com.tencent.liteav.videobase.a.b
    public void onInit(e eVar) {
        super.onInit(eVar);
        this.mGLTexturePool = eVar;
        AssetManager assets = this.mContext.getResources().getAssets();
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(assets.open("fennen.png"));
            if (this.mLookUpInvertFilter == null) {
                TXCGPULookUpInvertFilter tXCGPULookUpInvertFilter = new TXCGPULookUpInvertFilter(decodeStream);
                this.mLookUpInvertFilter = tXCGPULookUpInvertFilter;
                tXCGPULookUpInvertFilter.initialize(eVar);
            }
            try {
                decodeStream = BitmapFactory.decodeStream(assets.open("qingliang.png"));
            } catch (IOException e) {
                LiteavLog.e(TAG, "decode stream failed.", e);
            }
            if (this.mLookUpFilter == null) {
                TXCGPULookUpFilter tXCGPULookUpFilter = new TXCGPULookUpFilter(decodeStream);
                this.mLookUpFilter = tXCGPULookUpFilter;
                tXCGPULookUpFilter.initialize(eVar);
            }
        } catch (IOException e2) {
            LiteavLog.e(TAG, "decode stream failed.", e2);
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        TXCGPULookUpInvertFilter tXCGPULookUpInvertFilter = this.mLookUpInvertFilter;
        if (tXCGPULookUpInvertFilter != null) {
            tXCGPULookUpInvertFilter.onOutputSizeChanged(i, i2);
        }
        TXCGPULookUpFilter tXCGPULookUpFilter = this.mLookUpFilter;
        if (tXCGPULookUpFilter != null) {
            tXCGPULookUpFilter.onOutputSizeChanged(i, i2);
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onUninit() {
        super.onUninit();
        TXCGPULookUpInvertFilter tXCGPULookUpInvertFilter = this.mLookUpInvertFilter;
        if (tXCGPULookUpInvertFilter != null) {
            tXCGPULookUpInvertFilter.uninitialize();
            this.mLookUpInvertFilter = null;
        }
        TXCGPULookUpFilter tXCGPULookUpFilter = this.mLookUpFilter;
        if (tXCGPULookUpFilter != null) {
            tXCGPULookUpFilter.uninitialize();
            this.mLookUpFilter = null;
        }
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase
    public void setNextFrameTimestamp(long j) {
        super.setNextFrameTimestamp(j);
        if (this.mLightningParam == null) {
            LightningParam lightningParam = new LightningParam();
            this.mLightningParam = lightningParam;
            lightningParam.lightningLevel = 0.0f;
        }
        long abs = Math.abs(j - this.mEffectStartTime);
        if (abs < 50) {
            this.mLightningParam.lightningLevel = 0.7f;
        } else if (abs < 150) {
            this.mLightningParam.lightningLevel = 0.5f;
        } else if (abs < 250) {
            this.mLightningParam.lightningLevel = 0.4f;
        } else if (abs < 300) {
            this.mLightningParam.lightningLevel = 1.0f;
        } else if (abs < 400) {
            this.mLightningParam.lightningLevel = 0.3f;
        } else if (abs < 580) {
            this.mLightningParam.lightningLevel = 0.0f;
        } else {
            this.mEffectStartTime = -1L;
        }
        updateParams();
    }
}
