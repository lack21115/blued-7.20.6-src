package com.tencent.thumbplayer.a;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.imagegenerator.ITPImageGeneratorCallback;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/a/d.class */
public class d implements com.tencent.thumbplayer.adapter.a.a, ITPImageGeneratorCallback {

    /* renamed from: a  reason: collision with root package name */
    private long f39134a;
    private TPImageGenerator b;

    /* renamed from: c  reason: collision with root package name */
    private Map<Long, TPCaptureCallBack> f39135c;

    public d(int i) {
        this(i, 0L, 0L);
    }

    public d(int i, long j, long j2) {
        this.f39134a = 0L;
        this.b = new TPImageGenerator(i, j, j2, this);
        this.f39135c = new HashMap();
        try {
            this.b.init();
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", "init: " + Log.getStackTraceString(e));
        }
    }

    public d(String str) {
        this.f39134a = 0L;
        this.b = new TPImageGenerator(str, this);
        this.f39135c = new HashMap();
        try {
            this.b.init();
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", "init: " + Log.getStackTraceString(e));
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.a
    public void a() {
        try {
            this.b.cancelAllImageGenerations();
            this.b.unInit();
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", "release: " + Log.getStackTraceString(e));
        }
        this.f39135c.clear();
        this.b = null;
    }

    @Override // com.tencent.thumbplayer.adapter.a.a
    public void a(long j, TPImageGeneratorParams tPImageGeneratorParams, TPCaptureCallBack tPCaptureCallBack) {
        TPImageGeneratorParams tPImageGeneratorParams2 = tPImageGeneratorParams;
        if (tPImageGeneratorParams == null) {
            tPImageGeneratorParams2 = new TPImageGeneratorParams();
            tPImageGeneratorParams2.format = 37;
        }
        long j2 = this.f39134a + 1;
        this.f39134a = j2;
        this.f39135c.put(Long.valueOf(j2), tPCaptureCallBack);
        try {
            this.b.generateImageAsyncAtTime(j, this.f39134a, tPImageGeneratorParams2);
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", "generateImageAsyncAtTime: " + Log.getStackTraceString(e));
        }
    }

    @Override // com.tencent.thumbplayer.core.imagegenerator.ITPImageGeneratorCallback
    public void onImageGenerationCompleted(int i, long j, long j2, long j3, TPVideoFrame tPVideoFrame) {
        TPCaptureCallBack tPCaptureCallBack = this.f39135c.get(Long.valueOf(j3));
        if (tPCaptureCallBack != null) {
            int i2 = i;
            if (i == 0) {
                i2 = i;
                if (tPVideoFrame != null) {
                    Bitmap a2 = a.a(tPVideoFrame);
                    if (a2 != null) {
                        tPCaptureCallBack.onCaptureVideoSuccess(a2);
                    } else {
                        i2 = 1000001;
                    }
                }
            }
            tPCaptureCallBack.onCaptureVideoFailed(i2);
        }
        this.f39135c.remove(Long.valueOf(j3));
    }
}
