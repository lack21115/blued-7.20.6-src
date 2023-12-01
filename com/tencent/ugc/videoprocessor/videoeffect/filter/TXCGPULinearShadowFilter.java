package com.tencent.ugc.videoprocessor.videoeffect.filter;

import android.media.MediaFormat;
import android.opengl.GLES20;
import com.igexin.push.config.c;
import com.tencent.liteav.videobase.a.b;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPULinearShadowFilter.class */
public class TXCGPULinearShadowFilter extends TXCGPUEffectFilterBase {
    private static final int DURATION_WIN_SHADDOW_LV1 = 300;
    private static final int DURATION_WIN_SHADDOW_LV10 = 1000;
    private static final int DURATION_WIN_SHADDOW_LV11 = 1050;
    private static final int DURATION_WIN_SHADDOW_LV12 = 1100;
    private static final int DURATION_WIN_SHADDOW_LV13 = 1200;
    private static final int DURATION_WIN_SHADDOW_LV14 = 1500;
    private static final int DURATION_WIN_SHADDOW_LV15 = 2500;
    private static final int DURATION_WIN_SHADDOW_LV2 = 350;
    private static final int DURATION_WIN_SHADDOW_LV3 = 400;
    private static final int DURATION_WIN_SHADDOW_LV4 = 500;
    private static final int DURATION_WIN_SHADDOW_LV5 = 600;
    private static final int DURATION_WIN_SHADDOW_LV6 = 650;
    private static final int DURATION_WIN_SHADDOW_LV7 = 700;
    private static final int DURATION_WIN_SHADDOW_LV8 = 800;
    private static final int DURATION_WIN_SHADDOW_LV9 = 900;
    private static final String FRAGMENT_SHADER = "precision mediump float; \nvarying highp vec2 textureCoordinate; \nuniform sampler2D inputImageTexture; \n \nuniform float a; \nuniform float b; \nuniform float c; \nuniform float d; \nuniform float mode; \nuniform float width; \nuniform float stride; \nuniform float alpha; \n \nvoid main() \n{ \n\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate); \n   if(b == 0.0){ \n\t\tfloat mx = mod(textureCoordinate.x + c, stride); \n\t\tif((mode < 0.5 && mx <= width) || (mode > 0.5 && (mx > width))){ \n\t\t\tgl_FragColor.rgb = gl_FragColor.rgb*alpha; \n\t\t} \n\t} \n} \n";
    private int mAlphaPos;
    private int mCPos;
    private LinearShadowParam mLinearShadowParm;
    private int mModePos;
    private int mStridePos;
    private int mWithPos;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPULinearShadowFilter$LinearShadowParam.class */
    public static class LinearShadowParam extends TXCGPUEffectFilterBase.VideoEffectParams {
        public float mode = 0.0f;
        public float alpha = 0.0f;
        public float offset = 0.0f;
        public float width = 0.0f;
        public float stride = 0.05f;
    }

    public TXCGPULinearShadowFilter() {
        super(b.NO_FILTER_VERTEX_SHADER, FRAGMENT_SHADER);
        this.mCPos = -1;
        this.mModePos = -1;
        this.mWithPos = -1;
        this.mStridePos = -1;
        this.mAlphaPos = -1;
    }

    private void setParamsInternal(float f, float f2, float f3, float f4, float f5) {
        setFloatOnDraw(this.mModePos, f);
        setFloatOnDraw(this.mAlphaPos, f2);
        setFloatOnDraw(this.mCPos, f3 * (-1.0f));
        setFloatOnDraw(this.mWithPos, f4);
        setFloatOnDraw(this.mStridePos, f5);
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase, com.tencent.liteav.videobase.a.b
    public void onInit(e eVar) {
        super.onInit(eVar);
        this.mCPos = GLES20.glGetUniformLocation(getProgramId(), "c");
        this.mModePos = GLES20.glGetUniformLocation(getProgramId(), "mode");
        this.mWithPos = GLES20.glGetUniformLocation(getProgramId(), "width");
        this.mStridePos = GLES20.glGetUniformLocation(getProgramId(), MediaFormat.KEY_STRIDE);
        this.mAlphaPos = GLES20.glGetUniformLocation(getProgramId(), "alpha");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase
    public void setNextFrameTimestamp(long j) {
        super.setNextFrameTimestamp(j);
        if (this.mLinearShadowParm == null) {
            this.mLinearShadowParm = new LinearShadowParam();
        }
        long abs = Math.abs(j - this.mEffectStartTime);
        if (abs < 300) {
            this.mLinearShadowParm.alpha = 0.0f;
            this.mLinearShadowParm.stride = 0.03f;
            this.mLinearShadowParm.width = 0.003f;
        } else if (abs < 350) {
            this.mLinearShadowParm.alpha = 0.0f;
            this.mLinearShadowParm.stride = 0.03f;
            this.mLinearShadowParm.width = 0.015f;
        } else if (abs < 400) {
            this.mLinearShadowParm.alpha = 0.0f;
            this.mLinearShadowParm.stride = 0.03f;
            this.mLinearShadowParm.width = 0.024f;
        } else if (abs < 500) {
            this.mLinearShadowParm.alpha = 0.0f;
            this.mLinearShadowParm.stride = 0.03f;
            this.mLinearShadowParm.width = 0.015f;
        } else if (abs < 600) {
            this.mLinearShadowParm.alpha = 0.0f;
            this.mLinearShadowParm.stride = 0.03f;
            this.mLinearShadowParm.width = 0.003f;
        } else if (abs < 650) {
            this.mLinearShadowParm.alpha = 0.0f;
            this.mLinearShadowParm.stride = 0.03f;
            this.mLinearShadowParm.width = 0.03f;
        } else if (abs < 700) {
            this.mLinearShadowParm.alpha = 0.0f;
            this.mLinearShadowParm.stride = 0.03f;
            this.mLinearShadowParm.width = 0.015f;
        } else if (abs < 800) {
            this.mLinearShadowParm.alpha = 0.0f;
            this.mLinearShadowParm.stride = 0.03f;
            this.mLinearShadowParm.width = 0.024f;
        } else if (abs < 900) {
            this.mLinearShadowParm.alpha = 1.0f;
        } else if (abs < 1000) {
            this.mLinearShadowParm.alpha = 0.0f;
            this.mLinearShadowParm.stride = 0.03f;
            this.mLinearShadowParm.width = 0.015f;
        } else if (abs < 1050) {
            this.mLinearShadowParm.alpha = 0.0f;
            this.mLinearShadowParm.stride = 0.03f;
            this.mLinearShadowParm.width = 0.024f;
        } else if (abs < 1100) {
            this.mLinearShadowParm.alpha = 0.0f;
            this.mLinearShadowParm.stride = 0.03f;
            this.mLinearShadowParm.width = 0.015f;
        } else if (abs < 1200) {
            this.mLinearShadowParm.alpha = 0.0f;
            this.mLinearShadowParm.stride = 0.03f;
            this.mLinearShadowParm.width = 0.009f;
        } else if (abs < c.j) {
            this.mLinearShadowParm.alpha = 0.0f;
            this.mLinearShadowParm.stride = 0.03f;
            this.mLinearShadowParm.width = 0.003f;
        } else if (abs < 2500) {
            this.mLinearShadowParm.alpha = 1.0f;
        } else {
            this.mEffectStartTime = -1L;
        }
        setParamsInternal(this.mLinearShadowParm.mode, this.mLinearShadowParm.alpha, this.mLinearShadowParm.offset, this.mLinearShadowParm.width, this.mLinearShadowParm.stride);
    }
}
