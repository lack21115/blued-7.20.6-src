package com.tencent.liteav.videoproducer.capture;

import android.graphics.SurfaceTexture;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ad.class */
public interface ad {
    void a();

    void a(float f);

    void a(int i, int i2);

    void a(ServerVideoProducerConfig serverVideoProducerConfig);

    void a(boolean z);

    boolean a(int i, int i2, boolean z);

    boolean a(CameraCaptureParams cameraCaptureParams, SurfaceTexture surfaceTexture, ae aeVar);

    Rotation b();

    void b(float f);

    void b(boolean z);

    int c();

    com.tencent.liteav.base.util.n d();

    boolean e();

    boolean f();

    boolean g();

    boolean h();
}
