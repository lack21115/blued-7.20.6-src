package com.tencent.ugc.videoprocessor.videoeffect.filter;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.a.b;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPURockFilter.class */
public class TXCGPURockFilter extends TXCGPUEffectFilterBase {
    private static final int DURATION_LIVEWAVE = 70;
    private static final int DURATION_LIVEWAVE_LVMIN = 120;
    private static final String FRAGMENT_SHADER = "precision highp float; \nvarying vec2 textureCoordinate; \nuniform sampler2D inputImageTexture; \nuniform float t; \nuniform float st; \nconst float stride = 7.0; \nconst float interval = 1.0; \nuniform float zMin; \nuniform float zMax; \nuniform vec2 center; \nuniform vec2 offsetR; \nuniform vec2 offsetG; \nuniform vec2 offsetB;\n\nfloat GetFactor(float elapse, float astride, float ainterval, float amp) \n{ \n   float ff = mod(elapse, astride + ainterval) / astride; \n   if (ff > 1.0) \n   { \n       ff = 0.0; \n   } \n   return pow(ff, 3.0) * 1.125 * amp; \n} \nvec2 _uv(vec2 uv, vec2 center, float zz, float min) \n{ \n   return uv + (zz + min) * (center - uv); \n} \nvoid main() \n{ \n   vec4 fout; \n   float zz = GetFactor(t - st, stride, interval, zMax - zMin); \n   float coeff = pow(zz, 0.75); \n   fout.r = texture2D(inputImageTexture, _uv(textureCoordinate, center, zz, zMin) + offsetR * coeff).r;\n   fout.g = texture2D(inputImageTexture, _uv(textureCoordinate, center, zz, zMin) + offsetG * coeff).g;\n   fout.b = texture2D(inputImageTexture, _uv(textureCoordinate, center, zz, zMin) + offsetB * coeff).b;\n   gl_FragColor = vec4(fout.rgb, 1.0); \n}\n";
    private int mCenterLocation;
    private int mCurrentLocation;
    private DongGanLightParam mDongGanParam;
    private int mDurationLocation;
    private int mOffsetBLocation;
    private int mOffsetGLocation;
    private int mOffsetRLocation;
    private int mZMaxLocation;
    private int mZMinLocation;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPURockFilter$DongGanLightParam.class */
    public static class DongGanLightParam extends TXCGPUEffectFilterBase.VideoEffectParams {
        public float zoomMin = 0.0f;
        public float zoomMax = 0.4f;
        public float[] center = {0.5f, 0.5f};
        public float current = 0.0f;
        public float duration = 10.0f;
        public float[] offetRed = {0.0f, 0.0f};
        public float[] offsetGreen = {0.0f, 0.0f};
        public float[] offsetBlue = {0.0f, 0.0f};
    }

    public TXCGPURockFilter() {
        super(b.NO_FILTER_VERTEX_SHADER, FRAGMENT_SHADER);
        this.mZMinLocation = -1;
        this.mZMaxLocation = -1;
        this.mDurationLocation = -1;
        this.mCurrentLocation = -1;
        this.mCenterLocation = -1;
        this.mOffsetRLocation = -1;
        this.mOffsetGLocation = -1;
        this.mOffsetBLocation = -1;
        this.mDongGanParam = null;
    }

    private void setCurrent(float f) {
        setFloatOnDraw(this.mCurrentLocation, f);
    }

    private void setDuration(float f) {
        setFloatOnDraw(this.mDurationLocation, f);
    }

    private void setOffset(float[] fArr, float[] fArr2, float[] fArr3) {
        setFloatVec2OnDraw(this.mOffsetRLocation, fArr);
        setFloatVec2OnDraw(this.mOffsetGLocation, fArr2);
        setFloatVec2OnDraw(this.mOffsetBLocation, fArr3);
    }

    private void setZoom(float f, float f2) {
        setFloatOnDraw(this.mZMinLocation, f);
        setFloatOnDraw(this.mZMaxLocation, f2);
    }

    private void updateParamsToOpenGL() {
        setOffset(this.mDongGanParam.offetRed, this.mDongGanParam.offsetGreen, this.mDongGanParam.offsetBlue);
        setFloatVec2OnDraw(this.mCenterLocation, this.mDongGanParam.center);
        setZoom(this.mDongGanParam.zoomMin, this.mDongGanParam.zoomMax);
        setDuration(this.mDongGanParam.duration);
        setCurrent(this.mDongGanParam.current);
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase, com.tencent.liteav.videobase.a.b
    public void onInit(e eVar) {
        super.onInit(eVar);
        this.mZMinLocation = GLES20.glGetUniformLocation(getProgramId(), "zMin");
        this.mZMaxLocation = GLES20.glGetUniformLocation(getProgramId(), "zMax");
        this.mDurationLocation = GLES20.glGetUniformLocation(getProgramId(), "t");
        this.mCurrentLocation = GLES20.glGetUniformLocation(getProgramId(), "st");
        this.mCenterLocation = GLES20.glGetUniformLocation(getProgramId(), "center");
        this.mOffsetRLocation = GLES20.glGetUniformLocation(getProgramId(), "offsetR");
        this.mOffsetGLocation = GLES20.glGetUniformLocation(getProgramId(), "offsetG");
        this.mOffsetBLocation = GLES20.glGetUniformLocation(getProgramId(), "offsetB");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase
    public void setNextFrameTimestamp(long j) {
        super.setNextFrameTimestamp(j);
        if (this.mDongGanParam == null) {
            DongGanLightParam dongGanLightParam = new DongGanLightParam();
            this.mDongGanParam = dongGanLightParam;
            dongGanLightParam.duration = 8.0f;
            this.mDongGanParam.center = new float[]{0.5f, 0.5f};
            this.mDongGanParam.zoomMin = 0.0f;
            this.mDongGanParam.zoomMax = 0.2f;
        }
        long abs = Math.abs(j - this.mEffectStartTime);
        if (abs < 120) {
            this.mDongGanParam.current = 0.0f;
            this.mDongGanParam.duration = 8.0f;
            this.mDongGanParam.center = new float[]{0.0f, 0.0f};
            this.mDongGanParam.zoomMin = 0.0f;
            this.mDongGanParam.zoomMax = 0.0f;
            this.mDongGanParam.offetRed = new float[]{0.0f, 0.0f};
            this.mDongGanParam.offsetGreen = new float[]{0.0f, 0.0f};
        } else {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 8) {
                    break;
                } else if (abs < (i2 * 70) + 120) {
                    this.mDongGanParam.current = i2;
                    this.mDongGanParam.duration = 8.0f;
                    this.mDongGanParam.center = new float[]{0.5f, 0.5f};
                    this.mDongGanParam.zoomMin = 0.0f;
                    this.mDongGanParam.zoomMax = 0.3f;
                    if (i2 >= 3) {
                        this.mDongGanParam.offetRed = new float[]{-0.1f, 0.0f};
                        this.mDongGanParam.offsetGreen = new float[]{0.0f, 0.1f};
                    } else {
                        this.mDongGanParam.offetRed = new float[]{0.0f, 0.0f};
                        this.mDongGanParam.offsetGreen = new float[]{0.0f, 0.0f};
                    }
                } else {
                    i = i2 + 1;
                }
            }
            if (abs > 680) {
                if (abs <= 400680) {
                    this.mDongGanParam.current = 0.0f;
                    this.mDongGanParam.duration = 8.0f;
                    this.mDongGanParam.center = new float[]{0.0f, 0.0f};
                    this.mDongGanParam.zoomMin = 0.0f;
                    this.mDongGanParam.zoomMax = 0.0f;
                    this.mDongGanParam.offetRed = new float[]{0.0f, 0.0f};
                    this.mDongGanParam.offsetGreen = new float[]{0.0f, 0.0f};
                } else {
                    this.mEffectStartTime = -1L;
                }
            }
        }
        updateParamsToOpenGL();
    }
}
