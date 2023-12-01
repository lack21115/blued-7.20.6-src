package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videoconsumer.decoder.ay;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/VideoDecoderDef.class */
public interface VideoDecoderDef {

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/VideoDecoderDef$ConsumerScene.class */
    public enum ConsumerScene {
        UNKNOWN(-1),
        LIVE(0),
        RTC(1);
        
        private static final ConsumerScene[] d = values();
        private int mValue;

        ConsumerScene(int i) {
            this.mValue = i;
        }

        public static ConsumerScene a(int i) {
            ConsumerScene[] consumerSceneArr = d;
            int length = consumerSceneArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return UNKNOWN;
                }
                ConsumerScene consumerScene = consumerSceneArr[i3];
                if (consumerScene.mValue == i) {
                    return consumerScene;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/VideoDecoderDef$DecodeAbility.class */
    public static class DecodeAbility {

        /* renamed from: a  reason: collision with root package name */
        public boolean f23050a = true;
        public boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f23051c = false;

        public boolean isSupportHEVC() {
            return this.f23051c;
        }

        public boolean isSupportRPS() {
            return this.f23050a;
        }

        public boolean isSupportSVC() {
            return this.b;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/VideoDecoderDef$DecoderProperty.class */
    public static class DecoderProperty {

        /* renamed from: a  reason: collision with root package name */
        public ay.a f23052a;
        public CodecType b;

        public DecoderProperty(ay.a aVar, CodecType codecType) {
            this.f23052a = aVar;
            this.b = codecType;
        }

        public int getCodecType() {
            return this.b.mValue;
        }

        public int getDecoderType() {
            return this.f23052a.mValue;
        }
    }
}
