package com.blued.android.module.shortvideo.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.shortvideo.contract.IGetFrameCallback;
import com.blued.android.module.shortvideo.contract.IStvVideoFrameForTimeCallback;
import com.blued.android.module.shortvideo.model.VideoFrameInfo;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/VideoExtractFrameAsyncUtils.class */
public class VideoExtractFrameAsyncUtils {
    private int a;
    private int b;
    private volatile boolean c;

    public VideoExtractFrameAsyncUtils() {
        this.a = 0;
        this.b = 0;
    }

    public VideoExtractFrameAsyncUtils(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    private Bitmap a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        if (this.a == 0 || this.b == 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = (this.a * 2.0f) / width;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    private String a(MediaMetadataRetriever mediaMetadataRetriever, long j, String str) {
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(1000 * j, 2);
        if (frameAtTime != null) {
            Bitmap a = a(frameAtTime);
            String a2 = com.blued.android.module.shortvideo.view.StvFileUtils.a(a, str, System.currentTimeMillis() + BridgeUtil.UNDERLINE_STR + j + ".jpeg");
            if (a != null && !a.isRecycled()) {
                a.recycle();
            }
            return a2;
        }
        return null;
    }

    private void a(int i, String str, long j, IGetFrameCallback iGetFrameCallback) {
        VideoFrameInfo videoFrameInfo = new VideoFrameInfo();
        videoFrameInfo.index = i;
        videoFrameInfo.path = str;
        videoFrameInfo.time = j;
        if (iGetFrameCallback != null) {
            iGetFrameCallback.a(videoFrameInfo);
        }
    }

    public void a(String str, String str2, long j, long j2, int i, IGetFrameCallback iGetFrameCallback) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
        } catch (Exception e) {
        }
        int i2 = i - 1;
        long j3 = (j2 - j) / i2;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                break;
            } else if (this.c) {
                Log.d("ExtractFrame", "-------ok-stop-stop--");
                mediaMetadataRetriever.release();
                break;
            } else {
                long j4 = j + (i4 * j3);
                if (i4 != i2) {
                    a(i4, a(mediaMetadataRetriever, j4, str2), j4, iGetFrameCallback);
                } else if (j3 > 1000) {
                    long j5 = j2 - 800;
                    a(i4, a(mediaMetadataRetriever, j5, str2), j5, iGetFrameCallback);
                } else {
                    a(i4, a(mediaMetadataRetriever, j2, str2), j2, iGetFrameCallback);
                }
                i3 = i4 + 1;
            }
        }
        mediaMetadataRetriever.release();
    }

    public void a(String str, String str2, long j, IStvVideoFrameForTimeCallback iStvVideoFrameForTimeCallback) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
        } catch (Exception e) {
        }
        String a = a(mediaMetadataRetriever, j, str2);
        VideoFrameInfo videoFrameInfo = new VideoFrameInfo();
        videoFrameInfo.index = 0;
        videoFrameInfo.path = a;
        videoFrameInfo.time = j;
        mediaMetadataRetriever.release();
        if (iStvVideoFrameForTimeCallback != null) {
            iStvVideoFrameForTimeCallback.a(a);
        }
    }
}
