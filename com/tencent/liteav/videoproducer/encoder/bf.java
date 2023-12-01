package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/bf.class */
public interface bf {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/bf$a.class */
    public interface a extends VideoEncoderDef.VideoEncoderDataListener {
        void a();

        void a(String str);

        void a(boolean z, int i);
    }

    void ackRPSRecvFrameIndex(int i, int i2);

    void encodeFrame(PixelFrame pixelFrame);

    VideoEncodeParams getEncodeParams();

    VideoEncoderDef.a getEncoderType();

    void initialize();

    void restartIDRFrame();

    void setBitrate(int i);

    void setFps(int i);

    void setRPSIFrameFPS(int i);

    void setRPSNearestREFSize(int i);

    void setServerConfig(ServerVideoProducerConfig serverVideoProducerConfig);

    void signalEndOfStream();

    boolean start(VideoEncodeParams videoEncodeParams, a aVar);

    void stop();

    void takeSnapshot(TakeSnapshotListener takeSnapshotListener);

    void uninitialize();
}
