package com.tencent.thumbplayer.api;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.thumbplayer.a.a;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.imagegenerator.ITPImageGeneratorCallback;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPVideoCapture.class */
public class TPVideoCapture implements ITPImageGeneratorCallback {
    private static final String TAG = "TPThumbPlayer[TPVideoCapture.java]";
    private TPImageGenerator mTpImageGenerator;
    private int mWidth = 0;
    private int mHeight = 0;
    private long mRequestedTimeMsToleranceBefore = 0;
    private long mRequestedTimeMsToleranceAfter = 0;
    private long mOpaque = 0;
    private Map<String, TPVideoCaptureCallBack> mCallBackMap = new HashMap();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPVideoCapture$TPVideoCaptureCallBack.class */
    public interface TPVideoCaptureCallBack {
        void onCaptureError(int i);

        void onCaptureSuccess(Bitmap[] bitmapArr);
    }

    public TPVideoCapture(String str) {
        this.mTpImageGenerator = new TPImageGenerator(str, this);
        try {
            this.mTpImageGenerator.init();
        } catch (Exception e) {
            TPLogUtil.e(TAG, "init: " + Log.getStackTraceString(e));
        }
    }

    private String generateOpaqueKey(long j, long j2) {
        return "opaque_" + j + "time_" + j2;
    }

    private TPImageGeneratorParams getParameters() {
        TPImageGeneratorParams tPImageGeneratorParams = new TPImageGeneratorParams();
        tPImageGeneratorParams.format = 37;
        tPImageGeneratorParams.width = this.mWidth;
        tPImageGeneratorParams.height = this.mHeight;
        tPImageGeneratorParams.requestedTimeMsToleranceAfter = this.mRequestedTimeMsToleranceAfter;
        tPImageGeneratorParams.requestedTimeMsToleranceBefore = this.mRequestedTimeMsToleranceBefore;
        return tPImageGeneratorParams;
    }

    public void generateImageAsyncAtTime(long j, TPVideoCaptureCallBack tPVideoCaptureCallBack) {
        long j2 = this.mOpaque + 1;
        this.mOpaque = j2;
        this.mCallBackMap.put(generateOpaqueKey(j2, j), tPVideoCaptureCallBack);
        try {
            this.mTpImageGenerator.generateImageAsyncAtTime(j, this.mOpaque, getParameters());
        } catch (Exception e) {
            TPLogUtil.e(TAG, "generateImageAsyncAtTime: " + Log.getStackTraceString(e));
        }
    }

    public void generateImagesAsyncForTimes(long[] jArr, TPVideoCaptureCallBack tPVideoCaptureCallBack) {
        this.mOpaque++;
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                try {
                    this.mTpImageGenerator.generateImagesAsyncForTimes(jArr, this.mOpaque, getParameters());
                    return;
                } catch (Exception e) {
                    TPLogUtil.e(TAG, "generateImagesAsyncForTimes: " + Log.getStackTraceString(e));
                    return;
                }
            }
            this.mCallBackMap.put(generateOpaqueKey(this.mOpaque, jArr[i2]), tPVideoCaptureCallBack);
            i = i2 + 1;
        }
    }

    @Override // com.tencent.thumbplayer.core.imagegenerator.ITPImageGeneratorCallback
    public void onImageGenerationCompleted(int i, long j, long j2, long j3, TPVideoFrame tPVideoFrame) {
        TPVideoCaptureCallBack tPVideoCaptureCallBack = this.mCallBackMap.get(generateOpaqueKey(j3, j));
        if (tPVideoCaptureCallBack != null) {
            if (i != 0 || tPVideoFrame == null) {
                tPVideoCaptureCallBack.onCaptureError(i);
            } else {
                tPVideoCaptureCallBack.onCaptureSuccess(a.b(tPVideoFrame));
            }
        }
        this.mCallBackMap.remove(generateOpaqueKey(j3, j));
    }

    public void release() {
        try {
            this.mTpImageGenerator.cancelAllImageGenerations();
            this.mTpImageGenerator.unInit();
        } catch (Exception e) {
            TPLogUtil.e(TAG, "release: " + Log.getStackTraceString(e));
        }
        this.mCallBackMap.clear();
        this.mTpImageGenerator = null;
    }

    public void setSize(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Size is illegal");
        }
        this.mWidth = i;
        this.mHeight = i2;
    }

    public void setTimeMsTolerance(long j, long j2) {
        if (j > j2) {
            throw new IllegalArgumentException("Tolerance is illegal");
        }
        this.mRequestedTimeMsToleranceBefore = j;
        this.mRequestedTimeMsToleranceAfter = j2;
    }
}
