package com.tencent.ugc.videoprocessor.videoeffect.filter;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.a.b;
import com.tencent.liteav.videobase.frame.d;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;
import java.nio.FloatBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPUGhostFilter.class */
public class TXCGPUGhostFilter extends TXCGPUEffectFilterBase {
    private static final String BLUR_FRAGMENT_SHADER = "precision mediump float;  \nuniform sampler2D inputImageTexture;  \nvarying vec2 textureCoordinate;  \nvarying vec2 oneBackCoord;  \nvarying vec2 twoBackCoord;  \nvarying vec2 threeBackCoord;  \nvarying vec2 fourBackCoord;  \nvarying vec2 oneForwardCoord;  \nvarying vec2 twoForwardCoord;  \nvarying vec2 threeForwardCoord;  \nvarying vec2 fourForwardCoord;  \nvoid main() {   \n\tlowp vec4 fragmentColor = texture2D(inputImageTexture, textureCoordinate) * 0.18;  \n\tfragmentColor += texture2D(inputImageTexture, oneBackCoord) * 0.15;  \n\tfragmentColor += texture2D(inputImageTexture, twoBackCoord) * 0.12;  \n\tfragmentColor += texture2D(inputImageTexture, threeBackCoord) * 0.09;  \n\tfragmentColor += texture2D(inputImageTexture, fourBackCoord) * 0.05;  \n\tfragmentColor += texture2D(inputImageTexture, oneForwardCoord) * 0.15;  \n\tfragmentColor += texture2D(inputImageTexture, twoForwardCoord) * 0.12;  \n\tfragmentColor += texture2D(inputImageTexture, threeForwardCoord) * 0.09;  \n\tfragmentColor += texture2D(inputImageTexture, fourForwardCoord) * 0.05;  \n\tgl_FragColor = fragmentColor;  \n}  \n";
    private static final String BLUR_VERTEX_SHADER = "attribute vec4 position;  \nattribute vec4 inputTextureCoordinate;\nuniform vec2 step;  \nvarying vec2 textureCoordinate;  \nvarying vec2 oneBackCoord;  \nvarying vec2 twoBackCoord;  \nvarying vec2 threeBackCoord;  \nvarying vec2 fourBackCoord;  \nvarying vec2 oneForwardCoord;  \nvarying vec2 twoForwardCoord;  \nvarying vec2 threeForwardCoord;  \nvarying vec2 fourForwardCoord;  \nvoid main() {  \n\tgl_Position = position;  \n\tvec2 coord = inputTextureCoordinate.xy;  \n\ttextureCoordinate = coord;  \n\toneBackCoord = coord.xy - step;  \n\ttwoBackCoord = coord.xy - 2.0 * step;  \n\tthreeBackCoord = coord.xy - 3.0 * step;  \n\tfourBackCoord = coord.xy - 4.0 * step;  \n\toneForwardCoord = coord.xy + step;  \n\ttwoForwardCoord = coord.xy + 2.0 * step;  \n\tthreeForwardCoord = coord.xy + 3.0 * step;  \n\tfourForwardCoord = coord.xy + 4.0 * step;  \n}  \n";
    private static final int DURATION_GHOST_LV1 = 100;
    private static final int DURATION_GHOST_LV2 = 200;
    private static final int DURATION_GHOST_LV3 = 300;
    private static final int DURATION_GHOST_LV4 = 400;
    private static final int DURATION_GHOST_LV5 = 500;
    private static final int DURATION_GHOST_LV6 = 600;
    private static final int DURATION_GHOST_LV7 = 700;
    private static final int DURATION_GHOST_LV8 = 800;
    private static final int DURATION_GHOST_LV9 = 850;
    private static final String SHIFT_FRAGMENT_SHADER = "precision lowp float;  \nvarying vec2 textureCoordinate;  \n\tuniform sampler2D inputImageTexture;  \n\tuniform float shift;  \n\tuniform float alpha;  \n\tvoid main() { vec4 colorShift = texture2D(inputImageTexture, textureCoordinate + vec2(shift, 0.0));\n\tvec4 color = texture2D(inputImageTexture, textureCoordinate + vec2(shift * 0.1, 0.0));  \n\tgl_FragColor = vec4(mix(colorShift.rgb, color.rgb, alpha), color.a);  \n}  \n";
    private int mAlphaPos;
    private float mBlur;
    private int mBlurPos;
    private GhostParam mGhostParam;
    private final b mShiftFilter;
    private int mShiftPos;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPUGhostFilter$GhostParam.class */
    public static class GhostParam extends TXCGPUEffectFilterBase.VideoEffectParams {
        public float shift = 0.0f;
        public float blur = 0.0f;
        public float alpha = 0.0f;
    }

    public TXCGPUGhostFilter() {
        super(BLUR_VERTEX_SHADER, BLUR_FRAGMENT_SHADER);
        this.mShiftPos = -1;
        this.mAlphaPos = -1;
        this.mBlurPos = -1;
        this.mBlur = 0.0f;
        this.mShiftFilter = new b(b.NO_FILTER_VERTEX_SHADER, SHIFT_FRAGMENT_SHADER);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onDraw(int i, d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        d a2 = this.mTexturePool.a(getOutputSize().f36340a, getOutputSize().b);
        super.onDraw(i, a2, floatBuffer, floatBuffer2);
        this.mShiftFilter.onDraw(a2.a(), dVar, floatBuffer, floatBuffer2);
        a2.release();
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase, com.tencent.liteav.videobase.a.b
    public void onInit(e eVar) {
        super.onInit(eVar);
        this.mBlurPos = GLES20.glGetUniformLocation(getProgramId(), "step");
        this.mShiftFilter.initialize(eVar);
        this.mShiftPos = GLES20.glGetUniformLocation(getProgramId(), "shift");
        this.mAlphaPos = GLES20.glGetUniformLocation(getProgramId(), "alpha");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        b bVar = this.mShiftFilter;
        if (bVar != null) {
            bVar.onOutputSizeChanged(i, i2);
        }
        if (Math.abs(i) <= 1.0E-5d || Math.abs(this.mBlur) <= 1.0E-5d) {
            return;
        }
        setFloatVec2OnDraw(this.mBlurPos, new float[]{this.mBlur / getOutputSize().f36340a, 0.0f});
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onUninit() {
        super.onUninit();
        this.mShiftFilter.uninitialize();
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase
    public void setNextFrameTimestamp(long j) {
        super.setNextFrameTimestamp(j);
        if (this.mGhostParam == null) {
            GhostParam ghostParam = new GhostParam();
            this.mGhostParam = ghostParam;
            ghostParam.blur = 0.0f;
            this.mGhostParam.shift = 0.0f;
            this.mGhostParam.alpha = 0.0f;
        }
        long abs = Math.abs(j - this.mEffectStartTime);
        if (abs < 100) {
            this.mGhostParam.blur = 10.0f;
            this.mGhostParam.shift = 0.01f;
            this.mGhostParam.alpha = 0.0f;
        } else if (abs < 200) {
            this.mGhostParam.blur = 20.0f;
            this.mGhostParam.shift = -0.02f;
            this.mGhostParam.alpha = 0.0f;
        } else if (abs < 300) {
            this.mGhostParam.blur = 30.0f;
            this.mGhostParam.shift = 0.02f;
            this.mGhostParam.alpha = 0.0f;
        } else if (abs < 400) {
            this.mGhostParam.blur = 20.0f;
            this.mGhostParam.shift = -0.03f;
            this.mGhostParam.alpha = 0.0f;
        } else if (abs < 500) {
            this.mGhostParam.blur = 10.0f;
            this.mGhostParam.shift = 0.01f;
            this.mGhostParam.alpha = 0.0f;
        } else if (abs < 600) {
            this.mGhostParam.blur = 20.0f;
            this.mGhostParam.shift = -0.02f;
            this.mGhostParam.alpha = 0.0f;
        } else if (abs < 700) {
            this.mGhostParam.blur = 30.0f;
            this.mGhostParam.shift = -0.03f;
            this.mGhostParam.alpha = 0.0f;
        } else if (abs < 800) {
            this.mGhostParam.blur = 20.0f;
            this.mGhostParam.shift = 0.02f;
            this.mGhostParam.alpha = 0.0f;
        } else if (abs < 850) {
            this.mGhostParam.blur = 0.0f;
            this.mGhostParam.shift = 0.0f;
            this.mGhostParam.alpha = 0.0f;
        } else {
            this.mEffectStartTime = -1L;
        }
        updateParams(this.mGhostParam);
    }

    public void updateParams(GhostParam ghostParam) {
        this.mBlur = ghostParam.blur;
        if (getOutputSize().f36340a != 0) {
            setFloatVec2OnDraw(this.mBlurPos, new float[]{ghostParam.blur / getOutputSize().f36340a, 0.0f});
        }
        this.mShiftFilter.setFloatOnDraw(this.mAlphaPos, ghostParam.alpha);
        this.mShiftFilter.setFloatOnDraw(this.mShiftPos, ghostParam.shift);
    }
}
