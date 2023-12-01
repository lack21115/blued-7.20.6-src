package com.tencent.ugc.videoprocessor;

import android.content.Context;
import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;
import com.tencent.ugc.videoprocessor.videoeffect.data.Motion;
import com.tencent.ugc.videoprocessor.videoeffect.data.MotionFilterConfig;
import com.tencent.ugc.videoprocessor.videoeffect.filter.TXCGPUDarkFilter;
import com.tencent.ugc.videoprocessor.videoeffect.filter.TXCGPUGhostFilter;
import com.tencent.ugc.videoprocessor.videoeffect.filter.TXCGPUGhostShadowFilter;
import com.tencent.ugc.videoprocessor.videoeffect.filter.TXCGPUIllusionFilter;
import com.tencent.ugc.videoprocessor.videoeffect.filter.TXCGPULightingFilter;
import com.tencent.ugc.videoprocessor.videoeffect.filter.TXCGPULinearShadowFilter;
import com.tencent.ugc.videoprocessor.videoeffect.filter.TXCGPUMirrorFilter;
import com.tencent.ugc.videoprocessor.videoeffect.filter.TXCGPUPhontomFilter;
import com.tencent.ugc.videoprocessor.videoeffect.filter.TXCGPURockFilter;
import com.tencent.ugc.videoprocessor.videoeffect.filter.TXCGPUSpiritOutFilter;
import com.tencent.ugc.videoprocessor.videoeffect.filter.TXCGPUSplitScreenFilter;
import java.nio.FloatBuffer;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/VideoEffectProcessor.class */
public class VideoEffectProcessor {
    private static final String TAG = "VideoEffectProcessor";
    private final Context mContext;
    private com.tencent.liteav.videobase.a.b mCurrentEffect;
    private boolean mReverse = false;
    private int mCurrentEffectType = -1;
    private final MotionFilterConfig mMotionFilterConfig = new MotionFilterConfig();

    public VideoEffectProcessor(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private com.tencent.liteav.videobase.a.b createEffect(int i) {
        switch (i) {
            case 0:
                return new TXCGPUSpiritOutFilter();
            case 1:
                return new TXCGPUSplitScreenFilter();
            case 2:
                return new TXCGPUDarkFilter();
            case 3:
                return new TXCGPURockFilter();
            case 4:
                return new TXCGPULinearShadowFilter();
            case 5:
                return new TXCGPUGhostShadowFilter();
            case 6:
                return new TXCGPUPhontomFilter();
            case 7:
                return new TXCGPUGhostFilter();
            case 8:
                return new TXCGPULightingFilter(this.mContext);
            case 9:
                return new TXCGPUMirrorFilter();
            case 10:
                return new TXCGPUIllusionFilter();
            default:
                return new com.tencent.liteav.videobase.a.b();
        }
    }

    private void destroyCurrentEffect() {
        com.tencent.liteav.videobase.a.b bVar = this.mCurrentEffect;
        if (bVar != null) {
            bVar.uninitialize();
            this.mCurrentEffect = null;
        }
    }

    private Motion getCurrentMotion(long j) {
        Motion motion;
        List<Motion> motionList = this.mMotionFilterConfig.getMotionList();
        if (com.tencent.liteav.videobase.utils.c.a(motionList)) {
            return null;
        }
        int size = motionList.size();
        while (true) {
            int i = size - 1;
            motion = null;
            if (i < 0) {
                break;
            }
            motion = motionList.get(i);
            if (j >= motion.startTime && j <= motion.endTime) {
                break;
            }
            size = i;
        }
        Motion currentMotion = this.mMotionFilterConfig.getCurrentMotion();
        if (currentMotion.endTime == -1 || currentMotion.endTime == currentMotion.startTime) {
            motion = currentMotion;
        }
        return motion;
    }

    private boolean isInMotionTime(Motion motion, long j) {
        long j2 = motion.startTime;
        long j3 = motion.endTime;
        int i = (j2 > (-1L) ? 1 : (j2 == (-1L) ? 0 : -1));
        boolean z = i != 0 && j3 != -1 && j > j2 && j < j3;
        boolean z2 = z;
        if (i != 0) {
            z2 = z;
            if (j > j2) {
                z2 = true;
            }
        }
        if (j3 == -1 || j >= j3) {
            return z2;
        }
        return true;
    }

    public void deleteAllEffect() {
        LiteavLog.i(TAG, "==== deleteAllEffect ====");
        this.mMotionFilterConfig.clear();
    }

    public void deleteLastEffect() {
        LiteavLog.i(TAG, "==== deleteLastEffect ====");
        this.mMotionFilterConfig.deleteLastMotionEffect();
    }

    public void destroy() {
        destroyCurrentEffect();
    }

    public int getCurrentMotionType(long j) {
        Motion currentMotion = getCurrentMotion(j);
        if (currentMotion == null) {
            return -1;
        }
        return currentMotion.type;
    }

    public PixelFrame processFrame(PixelFrame pixelFrame, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, com.tencent.liteav.videobase.frame.e eVar) {
        Motion currentMotion = getCurrentMotion(pixelFrame.getTimestamp());
        if (currentMotion == null || !isInMotionTime(currentMotion, pixelFrame.getTimestamp())) {
            return null;
        }
        if (this.mCurrentEffectType != currentMotion.type) {
            destroyCurrentEffect();
        }
        if (this.mCurrentEffect == null) {
            int i = currentMotion.type;
            this.mCurrentEffectType = i;
            com.tencent.liteav.videobase.a.b createEffect = createEffect(i);
            this.mCurrentEffect = createEffect;
            createEffect.initialize(eVar);
        }
        this.mCurrentEffect.onOutputSizeChanged(pixelFrame.getWidth(), pixelFrame.getHeight());
        com.tencent.liteav.videobase.a.b bVar = this.mCurrentEffect;
        if (bVar instanceof TXCGPUEffectFilterBase) {
            ((TXCGPUEffectFilterBase) bVar).setNextFrameTimestamp(pixelFrame.getTimestamp());
        }
        com.tencent.liteav.videobase.frame.d a2 = eVar.a(pixelFrame.getWidth(), pixelFrame.getHeight());
        GLES20.glViewport(0, 0, pixelFrame.getWidth(), pixelFrame.getHeight());
        this.mCurrentEffect.onDraw(pixelFrame.getTextureId(), a2, floatBuffer, floatBuffer2);
        PixelFrame a3 = a2.a(OpenGlUtils.getCurrentContext());
        a3.setTimestamp(pixelFrame.getTimestamp());
        a2.release();
        return a3;
    }

    public void startEffect(int i, long j) {
        LiteavLog.i(TAG, "startEffect: type" + i + "  startTime:" + j);
        Motion motion = new Motion(i);
        if (this.mReverse) {
            motion.endTime = j;
        } else {
            motion.startTime = j;
        }
        this.mMotionFilterConfig.addMotion(motion);
    }

    public void stopEffect(int i, long j) {
        LiteavLog.i(TAG, "stopEffect type: " + i + ", endTime: " + j);
        Motion currentMotion = this.mMotionFilterConfig.getCurrentMotion();
        if (currentMotion != null) {
            if (this.mReverse) {
                currentMotion.startTime = j;
            } else {
                currentMotion.endTime = j;
            }
        }
    }
}
