package com.tencent.ugc;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.b.n;
import java.nio.Buffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCWatermarkAlphaTextureFilter.class */
public class UGCWatermarkAlphaTextureFilter extends com.tencent.liteav.beauty.b.n {
    private static final String WATERMARK_ALPHA_FRAG = "varying lowp vec2 textureCoordinate;\n   \n  uniform sampler2D inputImageTexture;\n  uniform mediump float alphaBlend;\n  \n  void main()\n  {\n      mediump vec4 color = texture2D(inputImageTexture, textureCoordinate);\n       if (0.0 == color.a){\n            gl_FragColor = color;\n       }else{\n            gl_FragColor = vec4(color.rgb, alphaBlend);\n       } \n  }\n";
    private int mAlphaUniform;
    private boolean mIsShowBackImageMoment;

    public UGCWatermarkAlphaTextureFilter() {
        super(com.tencent.liteav.videobase.a.b.NO_FILTER_VERTEX_SHADER, WATERMARK_ALPHA_FRAG);
        this.mAlphaUniform = -1;
        this.mIsShowBackImageMoment = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setTextureWatermark$1(UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter, int i, int i2, int i3, float f, float f2, float f3) {
        if (uGCWatermarkAlphaTextureFilter.mRenderObjects == null) {
            uGCWatermarkAlphaTextureFilter.mRenderObjects = new n.a[1];
        }
        if (uGCWatermarkAlphaTextureFilter.mRenderObjects[0] == null) {
            uGCWatermarkAlphaTextureFilter.mRenderObjects[0] = new n.a();
        }
        if (i == -1) {
            uGCWatermarkAlphaTextureFilter.mRenderObjects[0].a();
            uGCWatermarkAlphaTextureFilter.mRenderObjects[0] = null;
            return;
        }
        uGCWatermarkAlphaTextureFilter.mRenderObjects[0].f22705c = i;
        uGCWatermarkAlphaTextureFilter.calculateOffsetMatrix(i2, i3, f, f2, f3, 0);
    }

    @Override // com.tencent.liteav.beauty.b.n, com.tencent.liteav.videobase.a.b
    public void afterDrawArrays() {
        if (!this.mDrawWaterMarkEnabled) {
            return;
        }
        GLES20.glEnable(3042);
        if (this.mIsShowBackImageMoment) {
            GLES20.glBlendFunc(773, 772);
        } else {
            GLES20.glBlendFunc(770, 771);
        }
        GLES20.glActiveTexture(33984);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mRenderObjects.length) {
                GLES20.glDisable(3042);
                return;
            }
            if (this.mRenderObjects[i2] != null) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.mRenderObjects[i2].f22705c);
                GLES20.glUniform1i(this.mGLUniformTexture, 0);
                GLES20.glVertexAttribPointer(this.mGLAttribPosition, 2, 5126, false, 8, (Buffer) this.mRenderObjects[i2].f22704a);
                GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
                GLES20.glVertexAttribPointer(this.mGLAttribTextureCoord, 2, 5126, false, 0, (Buffer) TEXTURE_COORDS_BUFFER);
                GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoord);
                GLES20.glDrawElements(4, DRAW_ORDER.length, 5123, DRAW_ORDER_BUFFER);
                GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
                GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoord);
            }
            i = i2 + 1;
        }
    }

    @Override // com.tencent.liteav.beauty.b.n, com.tencent.liteav.videobase.a.b
    public void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        this.mAlphaUniform = GLES20.glGetUniformLocation(getProgramId(), "alphaBlend");
        this.mSrcBlendMode = 770;
        setAlpha(1.0f);
    }

    @Override // com.tencent.liteav.beauty.b.n, com.tencent.liteav.videobase.a.b
    public void onUninit() {
        this.mRenderObjects = null;
    }

    public void setAlpha(float f) {
        setFloatOnDraw(this.mAlphaUniform, f);
    }

    public void setShowBackImageMoment(boolean z) {
        runOnDraw(gj.a(this, z));
    }

    public void setTextureWatermark(int i, int i2, int i3, float f, float f2, float f3) {
        runOnDraw(gk.a(this, i, i2, i3, f, f2, f3));
    }
}
