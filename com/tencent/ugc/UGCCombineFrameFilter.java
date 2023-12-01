package com.tencent.ugc;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.UGCTransitionProcessor;
import com.uc.crashsdk.export.LogType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCCombineFrameFilter.class */
public class UGCCombineFrameFilter {
    private static final String TAG = "UGCCombineFrameFilter";
    private UGCWatermarkAlphaTextureFilter mAlphaBlendFilter;
    private com.tencent.liteav.base.util.n mCanvasSize;
    private FloatBuffer mCropRectTextureCoordsBuffer;
    private com.tencent.liteav.videobase.frame.c mFrameBufferForClear;
    private final com.tencent.liteav.videobase.frame.e mTexturePool;
    private UGCRotateScaleFilter mRotateScaleFilter = null;
    private com.tencent.liteav.videobase.a.b mCropFilter = null;
    private TXVideoEditConstants.TXAbsoluteRect mCropRect = null;
    private com.tencent.liteav.videobase.frame.d mBackgroundTexture = null;
    private final FloatBuffer mNormalCubeVerticesBuffer = OpenGlUtils.createNormalCubeVerticesBuffer();
    private final FloatBuffer mNormalTextureCoordsBuffer = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);

    public UGCCombineFrameFilter(com.tencent.liteav.videobase.frame.e eVar) {
        this.mTexturePool = eVar;
    }

    private void clearTexture(com.tencent.liteav.videobase.frame.d dVar) {
        if (this.mFrameBufferForClear == null) {
            com.tencent.liteav.videobase.frame.c cVar = new com.tencent.liteav.videobase.frame.c();
            this.mFrameBufferForClear = cVar;
            cVar.a();
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        if (dVar == null) {
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glClear(LogType.UNEXP_RESTART);
            return;
        }
        this.mFrameBufferForClear.a(dVar.a());
        this.mFrameBufferForClear.b();
        GLES20.glClear(LogType.UNEXP_RESTART);
        OpenGlUtils.bindFramebuffer(36160, 0);
        this.mFrameBufferForClear.c();
    }

    private com.tencent.liteav.videobase.frame.d combineFrameWithAlphaBlendFilter(List<UGCTransitionProcessor.TXCCombineFrame> list) {
        int backgroundTextureId = getBackgroundTextureId();
        com.tencent.liteav.videobase.frame.d dVar = null;
        int i = 0;
        while (i < list.size()) {
            setAlphaBlendFilterParameter(list.get(i));
            GLES20.glViewport(0, 0, this.mCanvasSize.f36340a, this.mCanvasSize.b);
            com.tencent.liteav.base.util.n outputSize = this.mAlphaBlendFilter.getOutputSize();
            com.tencent.liteav.videobase.frame.d a2 = this.mTexturePool.a(outputSize.f36340a, outputSize.b);
            this.mAlphaBlendFilter.onDraw(backgroundTextureId, a2, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
            if (dVar != null) {
                dVar.release();
            }
            backgroundTextureId = a2.a();
            i++;
            dVar = a2;
        }
        return dVar;
    }

    private com.tencent.liteav.videobase.frame.d cropTexture(com.tencent.liteav.videobase.frame.d dVar) {
        com.tencent.liteav.videobase.a.b bVar;
        if (dVar != null && (bVar = this.mCropFilter) != null) {
            com.tencent.liteav.base.util.n outputSize = bVar.getOutputSize();
            com.tencent.liteav.videobase.frame.d a2 = this.mTexturePool.a(outputSize.f36340a, outputSize.b);
            GLES20.glViewport(0, 0, outputSize.f36340a, outputSize.b);
            this.mCropFilter.onDraw(dVar.a(), a2, this.mNormalCubeVerticesBuffer, this.mCropRectTextureCoordsBuffer);
            dVar.release();
            return a2;
        }
        return dVar;
    }

    private int getBackgroundTextureId() {
        if (this.mBackgroundTexture == null) {
            com.tencent.liteav.videobase.frame.d a2 = this.mTexturePool.a(this.mCanvasSize.f36340a, this.mCanvasSize.b);
            this.mBackgroundTexture = a2;
            clearTexture(a2);
        }
        return this.mBackgroundTexture.a();
    }

    private static FloatBuffer getCropRectTextureCoords(int i, int i2, TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect) {
        int length = GLConstants.d.length;
        float[] fArr = new float[length];
        OpenGlUtils.initTextureCoordsBuffer(fArr, Rotation.NORMAL, false, false);
        if (tXAbsoluteRect != null) {
            float f = i * 1.0f;
            float f2 = tXAbsoluteRect.x / f;
            float f3 = ((i - tXAbsoluteRect.x) - tXAbsoluteRect.width) / f;
            float f4 = i2 * 1.0f;
            float f5 = tXAbsoluteRect.y / f4;
            float f6 = ((i2 - tXAbsoluteRect.y) - tXAbsoluteRect.height) / f4;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length / 2) {
                    break;
                }
                int i5 = i4 * 2;
                if (fArr[i5] < 0.5f) {
                    fArr[i5] = fArr[i5] + f2;
                } else {
                    fArr[i5] = fArr[i5] - f3;
                }
                int i6 = i5 + 1;
                if (fArr[i6] < 0.5f) {
                    fArr[i6] = fArr[i6] + f5;
                } else {
                    fArr[i6] = fArr[i6] - f6;
                }
                i3 = i4 + 1;
            }
        }
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(GLConstants.d.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr).position(0);
        return asFloatBuffer;
    }

    private void initFilter() {
        if (this.mRotateScaleFilter == null) {
            UGCRotateScaleFilter uGCRotateScaleFilter = new UGCRotateScaleFilter();
            this.mRotateScaleFilter = uGCRotateScaleFilter;
            uGCRotateScaleFilter.initialize(this.mTexturePool);
        }
        if (this.mAlphaBlendFilter == null) {
            UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter = new UGCWatermarkAlphaTextureFilter();
            this.mAlphaBlendFilter = uGCWatermarkAlphaTextureFilter;
            uGCWatermarkAlphaTextureFilter.initialize(this.mTexturePool);
        }
        this.mAlphaBlendFilter.enableWatermark(true);
        this.mAlphaBlendFilter.onOutputSizeChanged(this.mCanvasSize.f36340a, this.mCanvasSize.b);
        if (this.mCropRect != null) {
            if (this.mCropFilter == null) {
                com.tencent.liteav.videobase.a.b bVar = new com.tencent.liteav.videobase.a.b();
                this.mCropFilter = bVar;
                bVar.initialize(this.mTexturePool);
            }
            this.mCropFilter.onOutputSizeChanged(this.mCropRect.width, this.mCropRect.height);
            return;
        }
        com.tencent.liteav.videobase.a.b bVar2 = this.mCropFilter;
        if (bVar2 != null) {
            bVar2.uninitialize();
            this.mCropFilter = null;
        }
    }

    private void processRotateScale(List<UGCTransitionProcessor.TXCCombineFrame> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            UGCTransitionProcessor.TXCCombineFrame tXCCombineFrame = list.get(i2);
            if (this.mRotateScaleFilter == null || tXCCombineFrame.transformParams == null) {
                return;
            }
            this.mRotateScaleFilter.setRotateAndScale(tXCCombineFrame.transformParams.rotate, tXCCombineFrame.transformParams.scale);
            this.mRotateScaleFilter.setAlpha(tXCCombineFrame.transformParams.alpha);
            GLES20.glViewport(0, 0, tXCCombineFrame.drawRect.width, tXCCombineFrame.drawRect.height);
            com.tencent.liteav.videobase.frame.d a2 = this.mTexturePool.a(tXCCombineFrame.drawRect.width, tXCCombineFrame.drawRect.height);
            clearTexture(a2);
            this.mRotateScaleFilter.onDraw(tXCCombineFrame.drawInputFrame.getTextureId(), a2, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
            PixelFrame pixelFrame = tXCCombineFrame.drawInputFrame;
            tXCCombineFrame.drawInputFrame = a2.a(pixelFrame.getGLContext());
            pixelFrame.release();
            a2.release();
            i = i2 + 1;
        }
    }

    private void setAlphaBlendFilterParameter(UGCTransitionProcessor.TXCCombineFrame tXCCombineFrame) {
        if (tXCCombineFrame.transformParams != null) {
            this.mAlphaBlendFilter.setAlpha(tXCCombineFrame.transformParams.alpha);
            this.mAlphaBlendFilter.setShowBackImageMoment(tXCCombineFrame.transformParams.isBackgroundTransparent);
        } else {
            this.mAlphaBlendFilter.setAlpha(1.0f);
            this.mAlphaBlendFilter.setShowBackImageMoment(false);
        }
        this.mAlphaBlendFilter.setTextureWatermark(tXCCombineFrame.drawInputFrame.getTextureId(), tXCCombineFrame.drawRect.width, tXCCombineFrame.drawRect.height, (tXCCombineFrame.drawRect.x * 1.0f) / this.mCanvasSize.f36340a, (tXCCombineFrame.drawRect.y * 1.0f) / this.mCanvasSize.b, (tXCCombineFrame.drawRect.width * 1.0f) / this.mCanvasSize.f36340a);
    }

    private void unInitFilter() {
        UGCRotateScaleFilter uGCRotateScaleFilter = this.mRotateScaleFilter;
        if (uGCRotateScaleFilter != null) {
            uGCRotateScaleFilter.uninitialize();
            this.mRotateScaleFilter = null;
        }
        UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter = this.mAlphaBlendFilter;
        if (uGCWatermarkAlphaTextureFilter != null) {
            uGCWatermarkAlphaTextureFilter.uninitialize();
            this.mAlphaBlendFilter = null;
        }
        com.tencent.liteav.videobase.a.b bVar = this.mCropFilter;
        if (bVar != null) {
            bVar.uninitialize();
            this.mCropFilter = null;
        }
        com.tencent.liteav.videobase.frame.d dVar = this.mBackgroundTexture;
        if (dVar != null) {
            dVar.release();
            this.mBackgroundTexture = null;
        }
        com.tencent.liteav.videobase.frame.c cVar = this.mFrameBufferForClear;
        if (cVar != null) {
            cVar.d();
            this.mFrameBufferForClear = null;
        }
    }

    public com.tencent.liteav.videobase.frame.d combineFrame(List<UGCTransitionProcessor.TXCCombineFrame> list) {
        if (list == null || list.size() <= 0) {
            Log.e(TAG, "frames is null or no frames!");
            return null;
        }
        initFilter();
        processRotateScale(list);
        return cropTexture(combineFrameWithAlphaBlendFilter(list));
    }

    public void release() {
        unInitFilter();
    }

    public void setCanvasSize(int i, int i2) {
        com.tencent.liteav.base.util.n nVar = this.mCanvasSize;
        if (nVar != null && i == nVar.f36340a && i2 == this.mCanvasSize.b) {
            return;
        }
        com.tencent.liteav.base.util.n nVar2 = new com.tencent.liteav.base.util.n(i, i2);
        this.mCanvasSize = nVar2;
        this.mCropRectTextureCoordsBuffer = getCropRectTextureCoords(nVar2.f36340a, this.mCanvasSize.b, this.mCropRect);
    }

    public void setCropRect(TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect) {
        TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect2 = this.mCropRect;
        if (tXAbsoluteRect2 != null && tXAbsoluteRect != null && tXAbsoluteRect2.width == tXAbsoluteRect.width && this.mCropRect.height == tXAbsoluteRect.height && this.mCropRect.x == tXAbsoluteRect.x && this.mCropRect.y == tXAbsoluteRect.y) {
            return;
        }
        this.mCropRect = tXAbsoluteRect;
        this.mCropRectTextureCoordsBuffer = getCropRectTextureCoords(this.mCanvasSize.f36340a, this.mCanvasSize.b, this.mCropRect);
    }
}
