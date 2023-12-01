package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videoconsumer.consumer.ServerVideoConsumerConfig;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/ay.class */
public interface ay {

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/ay$a.class */
    public enum a {
        SOFTWARE(0),
        HARDWARE(1),
        CUSTOM(2);
        
        int mValue;

        a(int i) {
            this.mValue = i;
        }
    }

    void abandonDecodingFrames();

    boolean decode(EncodedVideoFrame encodedVideoFrame);

    a getDecoderType();

    void initialize();

    void setScene(VideoDecoderDef.ConsumerScene consumerScene);

    void setServerConfig(ServerVideoConsumerConfig serverVideoConsumerConfig);

    void start(Object obj, az azVar);

    void stop();

    void uninitialize();
}
