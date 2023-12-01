package com.tencent.ugc.videoprocessor;

import android.content.Context;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.h;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.ugc.videoprocessor.transitions.BounceFilter;
import com.tencent.ugc.videoprocessor.transitions.BurnFilter;
import com.tencent.ugc.videoprocessor.transitions.CircleCropFilter;
import com.tencent.ugc.videoprocessor.transitions.CircleFilter;
import com.tencent.ugc.videoprocessor.transitions.CrossWarpFilter;
import com.tencent.ugc.videoprocessor.transitions.CrossZoomFilter;
import com.tencent.ugc.videoprocessor.transitions.CubeFilter;
import com.tencent.ugc.videoprocessor.transitions.DirectionalFilter;
import com.tencent.ugc.videoprocessor.transitions.DirectionalWarpFilter;
import com.tencent.ugc.videoprocessor.transitions.DoorWayFilter;
import com.tencent.ugc.videoprocessor.transitions.DreamyZoomFilter;
import com.tencent.ugc.videoprocessor.transitions.FadeColorFilter;
import com.tencent.ugc.videoprocessor.transitions.FadeGrayScaleFilter;
import com.tencent.ugc.videoprocessor.transitions.FlyEyeFilter;
import com.tencent.ugc.videoprocessor.transitions.GlitchDisplaceFilter;
import com.tencent.ugc.videoprocessor.transitions.GlitchMemoriesFilter;
import com.tencent.ugc.videoprocessor.transitions.GridFlipFilter;
import com.tencent.ugc.videoprocessor.transitions.HexagonalizeFilter;
import com.tencent.ugc.videoprocessor.transitions.InvertedPageCurlFilter;
import com.tencent.ugc.videoprocessor.transitions.KaleidoScopeFilter;
import com.tencent.ugc.videoprocessor.transitions.LinearBlurFilter;
import com.tencent.ugc.videoprocessor.transitions.MosaicFilter;
import com.tencent.ugc.videoprocessor.transitions.PixelizeFilter;
import com.tencent.ugc.videoprocessor.transitions.SimpleZoomFilter;
import com.tencent.ugc.videoprocessor.transitions.SqueezeFilter;
import com.tencent.ugc.videoprocessor.transitions.StereoViewerFilter;
import com.tencent.ugc.videoprocessor.transitions.SwapFilter;
import com.tencent.ugc.videoprocessor.transitions.SwirlFilter;
import com.tencent.ugc.videoprocessor.transitions.TXCGPUTransitionFilterBase;
import com.tencent.ugc.videoprocessor.transitions.WaterDropFilter;
import com.tencent.ugc.videoprocessor.transitions.data.TransitionConfig;
import java.nio.FloatBuffer;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/VideoTransitionProcessor.class */
public class VideoTransitionProcessor {
    private static final String TAG = "TransitionProcessor";
    private final Context mContext;
    private com.tencent.liteav.videobase.frame.e mGLTexturePool;
    private TXCGPUTransitionFilterBase mTransitionFilter;
    private long mFirstFrameTime = -1;
    private final TransitionConfig mTransitionConfig = new TransitionConfig();

    public VideoTransitionProcessor(Context context) {
        this.mContext = context;
    }

    private void createTransitionFilter(int i) {
        TXCGPUTransitionFilterBase directionalFilter;
        switch (i) {
            case 1:
                directionalFilter = new DirectionalFilter(i, new float[]{1.0f, 0.0f});
                break;
            case 2:
                directionalFilter = new DirectionalFilter(i, new float[]{-1.0f, 0.0f});
                break;
            case 3:
                directionalFilter = new DirectionalFilter(i, new float[]{0.0f, -1.0f});
                break;
            case 4:
                directionalFilter = new DirectionalFilter(i, new float[]{0.0f, 1.0f});
                break;
            case 5:
                directionalFilter = new FadeColorFilter(i);
                break;
            case 6:
            case 20:
            case 21:
            case 26:
            default:
                directionalFilter = null;
                break;
            case 7:
                directionalFilter = new SimpleZoomFilter(i);
                break;
            case 8:
                directionalFilter = new LinearBlurFilter(i);
                break;
            case 9:
                directionalFilter = new WaterDropFilter(i);
                break;
            case 10:
                directionalFilter = new InvertedPageCurlFilter(i);
                break;
            case 11:
                directionalFilter = new GlitchMemoriesFilter(i);
                break;
            case 12:
                directionalFilter = new StereoViewerFilter(i);
                break;
            case 13:
                directionalFilter = new DirectionalWarpFilter(i);
                break;
            case 14:
                directionalFilter = new BounceFilter(i);
                break;
            case 15:
                directionalFilter = new CircleCropFilter(i);
                break;
            case 16:
                directionalFilter = new SwirlFilter(i);
                break;
            case 17:
                directionalFilter = new CrossZoomFilter(i);
                break;
            case 18:
                directionalFilter = new GridFlipFilter(i);
                break;
            case 19:
                directionalFilter = new MosaicFilter(i);
                break;
            case 22:
                directionalFilter = new KaleidoScopeFilter(i);
                break;
            case 23:
                directionalFilter = new HexagonalizeFilter(i);
                break;
            case 24:
                directionalFilter = new GlitchDisplaceFilter(i);
                break;
            case 25:
                directionalFilter = new DreamyZoomFilter(i);
                break;
            case 27:
                directionalFilter = new BurnFilter(i);
                break;
            case 28:
                directionalFilter = new CircleFilter(i);
                break;
            case 29:
                directionalFilter = new CrossWarpFilter(i);
                break;
            case 30:
                directionalFilter = new CubeFilter(i);
                break;
            case 31:
                directionalFilter = new DoorWayFilter(i);
                break;
            case 32:
                directionalFilter = new FadeGrayScaleFilter(i);
                break;
            case 33:
                directionalFilter = new FlyEyeFilter(i);
                break;
            case 34:
                directionalFilter = new PixelizeFilter(i);
                break;
            case 35:
                directionalFilter = new SqueezeFilter(i);
                break;
            case 36:
                directionalFilter = new SwapFilter(i);
                break;
        }
        if (directionalFilter != null) {
            directionalFilter.initialize(this.mGLTexturePool);
        }
        this.mTransitionFilter = directionalFilter;
    }

    private TransitionConfig.TransitionBean getCurrentTransition(long j) {
        List<TransitionConfig.TransitionBean> transitionList = this.mTransitionConfig.getTransitionList();
        if (com.tencent.liteav.videobase.utils.c.a(transitionList)) {
            return null;
        }
        int size = transitionList.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return null;
            }
            TransitionConfig.TransitionBean transitionBean = transitionList.get(i);
            if (isInTransitionRange(j, transitionBean)) {
                return transitionBean;
            }
            size = i;
        }
    }

    private float getTransitionProgress(TransitionConfig.TransitionBean transitionBean, long j) {
        if (this.mFirstFrameTime == -1) {
            this.mFirstFrameTime = j;
        }
        long abs = Math.abs(j - this.mFirstFrameTime);
        long j2 = transitionBean.endTimeMs - transitionBean.startTimeMs;
        if (j2 <= 0) {
            return -1.0f;
        }
        return h.a((((float) abs) * 1.0f) / ((float) j2), 0.0f, 1.0f);
    }

    private boolean isInTransitionRange(long j, TransitionConfig.TransitionBean transitionBean) {
        return j >= transitionBean.startTimeMs && j <= transitionBean.endTimeMs;
    }

    public PixelFrame applyTransitionFilter(PixelFrame pixelFrame, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        long timestamp = pixelFrame.getTimestamp();
        TransitionConfig.TransitionBean currentTransition = getCurrentTransition(timestamp);
        if (currentTransition == null) {
            this.mFirstFrameTime = -1L;
            return null;
        }
        float transitionProgress = getTransitionProgress(currentTransition, timestamp);
        if (transitionProgress < 0.0f) {
            return null;
        }
        TXCGPUTransitionFilterBase tXCGPUTransitionFilterBase = this.mTransitionFilter;
        if (tXCGPUTransitionFilterBase != null && tXCGPUTransitionFilterBase.mType != currentTransition.type) {
            this.mTransitionFilter.uninitialize();
            this.mTransitionFilter = null;
        }
        if (this.mTransitionFilter == null) {
            createTransitionFilter(currentTransition.type);
        }
        TXCGPUTransitionFilterBase tXCGPUTransitionFilterBase2 = this.mTransitionFilter;
        if (tXCGPUTransitionFilterBase2 == null) {
            return null;
        }
        tXCGPUTransitionFilterBase2.onOutputSizeChanged(pixelFrame.getWidth(), pixelFrame.getHeight());
        this.mTransitionFilter.setProgressForTransition(transitionProgress);
        com.tencent.liteav.videobase.frame.d a2 = this.mGLTexturePool.a(pixelFrame.getWidth(), pixelFrame.getHeight());
        this.mTransitionFilter.onDraw(pixelFrame.getTextureId(), a2, floatBuffer, floatBuffer2);
        PixelFrame a3 = a2.a(OpenGlUtils.getCurrentContext());
        a3.setTimestamp(pixelFrame.getTimestamp());
        a2.release();
        return a3;
    }

    public void deleteLastTransitionEffect() {
        this.mTransitionConfig.deleteLastTransitionEffect();
    }

    public void destroy() {
        TXCGPUTransitionFilterBase tXCGPUTransitionFilterBase = this.mTransitionFilter;
        if (tXCGPUTransitionFilterBase != null) {
            tXCGPUTransitionFilterBase.uninitialize();
            this.mTransitionFilter = null;
        }
    }

    public void init(com.tencent.liteav.videobase.frame.e eVar) {
        this.mGLTexturePool = eVar;
    }

    public boolean setTransitionEffect(int i, long j, long j2, long j3) {
        boolean z;
        if (j2 <= j) {
            long j4 = j3 + j2;
            if (j4 <= j) {
                List<TransitionConfig.TransitionBean> transitionList = this.mTransitionConfig.getTransitionList();
                if (transitionList.size() != 0) {
                    for (TransitionConfig.TransitionBean transitionBean : transitionList) {
                        if (j2 >= transitionBean.startTimeMs && j2 <= transitionBean.endTimeMs) {
                            LiteavLog.w(TAG, "setTransitionEffect,start time invalid");
                        } else if (isInTransitionRange(j4, transitionBean)) {
                            LiteavLog.w(TAG, "setTransitionEffect,end time invalid");
                        }
                        z = false;
                    }
                    z = true;
                    if (!z) {
                        return false;
                    }
                }
                TransitionConfig.TransitionBean transitionBean2 = new TransitionConfig.TransitionBean(i);
                transitionBean2.startTimeMs = j2;
                transitionBean2.endTimeMs = j4;
                this.mTransitionConfig.addTransition(transitionBean2);
                LiteavLog.d(TAG, "setTransitionEffect,success:".concat(String.valueOf(transitionBean2)));
                return true;
            }
        }
        LiteavLog.w(TAG, "setTransitionEffect,not suitable for videoTotalDurationMs");
        return false;
    }
}
