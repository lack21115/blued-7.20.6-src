package com.tencent.ugc.videoprocessor;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.preprocessor.BeautyProcessor;
import com.tencent.liteav.videoproducer.preprocessor.VideoPreprocessor;
import com.tencent.liteav.videoproducer.preprocessor.ag;
import java.nio.FloatBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/VideoProcessManager.class */
public class VideoProcessManager {
    private static final int IDENTITY = 100;
    private static final String TAG = "VideoProcessManager";
    private BeautyProcessor mBeautyProcessor;
    private Context mContext;
    private com.tencent.liteav.videobase.frame.e mGLTexturePool;
    private IVideoProcessorListener mListener;
    private FloatBuffer mNormalCubeVerticesBuffer;
    private FloatBuffer mNormalTextureCoordsBuffer;
    private IVideoReporter mReporter;
    private final VideoTransitionProcessor mTransitionProcessor;
    private final VideoEffectProcessor mVideoEffectProcessor;
    private VideoPreprocessor mVideoPreprocessor;
    private final WatermarkProcessor mWatermarkProcessor;
    private boolean mNeedProcess = false;
    private boolean mIsPreprocessorRegister = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/VideoProcessManager$IVideoProcessorListener.class */
    public interface IVideoProcessorListener {
        int customProcessFrame(PixelFrame pixelFrame);

        void didProcessFrame(PixelFrame pixelFrame);
    }

    public VideoProcessManager(Context context, boolean z, IVideoReporter iVideoReporter) {
        this.mContext = context;
        this.mReporter = iVideoReporter;
        BeautyProcessor beautyProcessor = new BeautyProcessor(this.mContext, z, this.mReporter);
        this.mBeautyProcessor = beautyProcessor;
        this.mVideoPreprocessor = new VideoPreprocessor(this.mContext, beautyProcessor, iVideoReporter);
        this.mVideoEffectProcessor = new VideoEffectProcessor(this.mContext);
        this.mTransitionProcessor = new VideoTransitionProcessor(this.mContext);
        this.mWatermarkProcessor = new WatermarkProcessor();
        this.mBeautyProcessor.setPerformanceMode(z);
        this.mNormalCubeVerticesBuffer = OpenGlUtils.createNormalCubeVerticesBuffer();
        this.mNormalTextureCoordsBuffer = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);
    }

    private PixelFrame applyMotionFilterChain(PixelFrame pixelFrame) {
        VideoEffectProcessor videoEffectProcessor = this.mVideoEffectProcessor;
        if (videoEffectProcessor != null) {
            return videoEffectProcessor.processFrame(pixelFrame, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer, this.mGLTexturePool);
        }
        return null;
    }

    private PixelFrame applyTransitionFilterChain(PixelFrame pixelFrame) {
        VideoTransitionProcessor videoTransitionProcessor = this.mTransitionProcessor;
        if (videoTransitionProcessor == null) {
            return null;
        }
        return videoTransitionProcessor.applyTransitionFilter(pixelFrame, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
    }

    private PixelFrame processByVideoEffectInner(PixelFrame pixelFrame) {
        PixelFrame pixelFrame2;
        pixelFrame.retain();
        VideoEffectProcessor videoEffectProcessor = this.mVideoEffectProcessor;
        if (videoEffectProcessor == null || videoEffectProcessor.getCurrentMotionType(pixelFrame.getTimestamp()) != 1) {
            PixelFrame applyMotionFilterChain = applyMotionFilterChain(pixelFrame);
            PixelFrame pixelFrame3 = pixelFrame;
            if (applyMotionFilterChain != null) {
                pixelFrame.release();
                pixelFrame3 = applyMotionFilterChain;
            }
            PixelFrame applyTransitionFilterChain = applyTransitionFilterChain(pixelFrame3);
            pixelFrame2 = pixelFrame3;
            if (applyTransitionFilterChain != null) {
                pixelFrame3.release();
                pixelFrame2 = applyTransitionFilterChain;
            }
        } else {
            PixelFrame applyTransitionFilterChain2 = applyTransitionFilterChain(pixelFrame);
            PixelFrame pixelFrame4 = pixelFrame;
            if (applyTransitionFilterChain2 != null) {
                pixelFrame.release();
                pixelFrame4 = applyTransitionFilterChain2;
            }
            PixelFrame applyMotionFilterChain2 = applyMotionFilterChain(pixelFrame4);
            pixelFrame2 = pixelFrame4;
            if (applyMotionFilterChain2 != null) {
                pixelFrame4.release();
                pixelFrame2 = applyMotionFilterChain2;
            }
        }
        PixelFrame process = this.mWatermarkProcessor.process(pixelFrame2, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
        PixelFrame pixelFrame5 = pixelFrame2;
        if (process != null) {
            pixelFrame2.release();
            pixelFrame5 = process;
        }
        return pixelFrame5;
    }

    public void destroyFilter(ag agVar) {
        unInitialize(agVar);
        VideoPreprocessor videoPreprocessor = this.mVideoPreprocessor;
        if (videoPreprocessor != null) {
            videoPreprocessor.uninitialize();
            this.mVideoPreprocessor = null;
        }
    }

    public VideoEffectProcessor getEffectProcessor() {
        this.mNeedProcess = true;
        return this.mVideoEffectProcessor;
    }

    public VideoTransitionProcessor getTransitionProcessor() {
        this.mNeedProcess = true;
        return this.mTransitionProcessor;
    }

    public WatermarkProcessor getWatermarkProcessor() {
        this.mNeedProcess = true;
        return this.mWatermarkProcessor;
    }

    public void initialize(com.tencent.liteav.videobase.frame.e eVar, int i, int i2, ag agVar) {
        this.mGLTexturePool = eVar;
        this.mVideoPreprocessor.initialize();
        this.mVideoPreprocessor.setSourceType(CaptureSourceInterface.SourceType.CUSTOM);
        this.mWatermarkProcessor.initialize(this.mGLTexturePool, i, i2);
        this.mVideoPreprocessor.registerVideoProcessedListener(100, new com.tencent.liteav.videobase.videobase.a(i, i2), GLConstants.PixelBufferType.TEXTURE_2D, GLConstants.PixelFormatType.RGBA, false, agVar);
        this.mIsPreprocessorRegister = true;
        this.mTransitionProcessor.init(this.mGLTexturePool);
    }

    public void processByVideoEffect(PixelFrame pixelFrame) {
        IVideoProcessorListener iVideoProcessorListener;
        PixelFrame processByVideoEffectInner = processByVideoEffectInner(pixelFrame);
        if (processByVideoEffectInner == null || (iVideoProcessorListener = this.mListener) == null) {
            return;
        }
        iVideoProcessorListener.didProcessFrame(processByVideoEffectInner);
        processByVideoEffectInner.release();
    }

    public void processFrame(PixelFrame pixelFrame) {
        GLES20.glFinish();
        if (this.mVideoPreprocessor == null || !this.mNeedProcess) {
            IVideoProcessorListener iVideoProcessorListener = this.mListener;
            if (iVideoProcessorListener != null) {
                iVideoProcessorListener.didProcessFrame(pixelFrame);
            }
        } else if (pixelFrame == null) {
        } else {
            int i = -1;
            IVideoProcessorListener iVideoProcessorListener2 = this.mListener;
            if (iVideoProcessorListener2 != null) {
                i = iVideoProcessorListener2.customProcessFrame(pixelFrame);
            }
            PixelFrame pixelFrame2 = pixelFrame;
            if (i > 0) {
                pixelFrame2 = new PixelFrame(pixelFrame);
                pixelFrame2.setTextureId(i);
            }
            VideoPreprocessor videoPreprocessor = this.mVideoPreprocessor;
            if (videoPreprocessor != null) {
                WatermarkProcessor watermarkProcessor = this.mWatermarkProcessor;
                if (watermarkProcessor != null) {
                    videoPreprocessor.setGaussianBlurLevel(watermarkProcessor.getBlurLevel() * 4.0f);
                } else {
                    videoPreprocessor.setGaussianBlurLevel(0.0f);
                }
                this.mVideoPreprocessor.processFrame(pixelFrame2);
            }
            if (i > 0) {
                pixelFrame2.release();
            }
        }
    }

    public void reInitFilter(com.tencent.liteav.videobase.frame.e eVar, int i, int i2, ag agVar) {
        this.mGLTexturePool = eVar;
        this.mWatermarkProcessor.initialize(eVar, i, i2);
        this.mTransitionProcessor.init(this.mGLTexturePool);
        if (this.mIsPreprocessorRegister) {
            return;
        }
        this.mVideoPreprocessor.registerVideoProcessedListener(100, new com.tencent.liteav.videobase.videobase.a(i, i2), GLConstants.PixelBufferType.TEXTURE_2D, GLConstants.PixelFormatType.RGBA, false, agVar);
        this.mIsPreprocessorRegister = true;
    }

    public void setBeautyFilter(int i, int i2) {
        this.mNeedProcess = true;
        BeautyProcessor beautyProcessor = this.mVideoPreprocessor.getBeautyProcessor();
        if (beautyProcessor != null) {
            beautyProcessor.setBeautyLevel(i);
            beautyProcessor.setWhitenessLevel(i2);
        }
    }

    public void setFilter(Bitmap bitmap, float f, Bitmap bitmap2, float f2, float f3) {
        this.mNeedProcess = true;
        this.mVideoPreprocessor.setFilterGroupImages(f3, bitmap, f, bitmap2, f2);
    }

    public void setListener(IVideoProcessorListener iVideoProcessorListener) {
        this.mListener = iVideoProcessorListener;
    }

    public void setOutputSize(int i, int i2) {
        WatermarkProcessor watermarkProcessor = this.mWatermarkProcessor;
        if (watermarkProcessor != null) {
            watermarkProcessor.setRenderTargetSize(i, i2);
        }
    }

    public void setScaleType(GLConstants.GLScaleType gLScaleType) {
        if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
            this.mWatermarkProcessor.setRenderMode(2);
        }
    }

    public void setSpecialRatio(float f) {
        this.mNeedProcess = true;
        this.mVideoPreprocessor.setFilterMixLevel(f);
    }

    public void unInitialize(ag agVar) {
        VideoEffectProcessor videoEffectProcessor = this.mVideoEffectProcessor;
        if (videoEffectProcessor != null) {
            videoEffectProcessor.destroy();
        }
        VideoTransitionProcessor videoTransitionProcessor = this.mTransitionProcessor;
        if (videoTransitionProcessor != null) {
            videoTransitionProcessor.destroy();
        }
        if (this.mIsPreprocessorRegister) {
            this.mVideoPreprocessor.unregisterVideoProcessedListener(100, agVar);
            this.mIsPreprocessorRegister = false;
        }
    }
}
