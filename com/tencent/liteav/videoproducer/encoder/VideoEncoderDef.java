package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaFormat;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.videobase.h;

@JNINamespace("liteav::video")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/VideoEncoderDef.class */
public interface VideoEncoderDef {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/VideoEncoderDef$BitrateMode.class */
    public enum BitrateMode {
        CBR(0),
        VBR(1),
        CQ(2);
        
        private static final BitrateMode[] d = values();
        int mValue;

        BitrateMode(int i) {
            this.mValue = i;
        }

        public static BitrateMode a(int i) {
            BitrateMode[] bitrateModeArr = d;
            int length = bitrateModeArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return VBR;
                }
                BitrateMode bitrateMode = bitrateModeArr[i3];
                if (i == bitrateMode.mValue) {
                    return bitrateMode;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/VideoEncoderDef$EncodeAbility.class */
    public static class EncodeAbility {

        /* renamed from: a  reason: collision with root package name */
        public boolean f36955a = true;
        public boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36956c = false;

        public boolean isSupportHEVC() {
            return this.f36956c;
        }

        public boolean isSupportRPS() {
            return this.f36955a;
        }

        public boolean isSupportSVC() {
            return this.b;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/VideoEncoderDef$EncodeStrategy.class */
    public enum EncodeStrategy {
        PREFER_HARDWARE(0),
        PREFER_SOFTWARE(1),
        USE_HARDWARE_ONLY(2),
        USE_SOFTWARE_ONLY(3);
        
        private static final EncodeStrategy[] e = values();
        int mValue;

        EncodeStrategy(int i) {
            this.mValue = i;
        }

        public static EncodeStrategy a(int i) {
            EncodeStrategy[] encodeStrategyArr = e;
            int length = encodeStrategyArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return PREFER_HARDWARE;
                }
                EncodeStrategy encodeStrategy = encodeStrategyArr[i3];
                if (encodeStrategy.mValue == i) {
                    return encodeStrategy;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/VideoEncoderDef$EncoderProfile.class */
    public enum EncoderProfile {
        PROFILE_BASELINE(1),
        PROFILE_MAIN(2),
        PROFILE_HIGH(3),
        PROFILE_BASELINERPS(4),
        PROFILE_MAINRPS(5),
        PROFILE_HIGHRPS(6);
        
        private static final EncoderProfile[] g = values();
        int mValue;

        EncoderProfile(int i) {
            this.mValue = i;
        }

        public static EncoderProfile a(int i) {
            EncoderProfile[] encoderProfileArr = g;
            int length = encoderProfileArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return PROFILE_BASELINE;
                }
                EncoderProfile encoderProfile = encoderProfileArr[i3];
                if (i == encoderProfile.mValue) {
                    return encoderProfile;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/VideoEncoderDef$EncoderProperty.class */
    public static class EncoderProperty {

        /* renamed from: a  reason: collision with root package name */
        public a f36961a;
        public ReferenceStrategy b;

        /* renamed from: c  reason: collision with root package name */
        public CodecType f36962c;

        public EncoderProperty(a aVar, ReferenceStrategy referenceStrategy, CodecType codecType) {
            this.f36961a = aVar;
            this.b = referenceStrategy;
            this.f36962c = codecType;
        }

        public int getCodecType() {
            return this.f36962c.mValue;
        }

        public int getEncoderType() {
            return this.f36961a.value;
        }

        public int getReferenceStrategy() {
            return this.b.mValue;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/VideoEncoderDef$ReferenceStrategy.class */
    public enum ReferenceStrategy {
        FIX_GOP(0),
        RPS(1),
        SVC(2),
        UNLIMITED_GOP(3);
        
        private static final ReferenceStrategy[] e = values();
        int mValue;

        ReferenceStrategy(int i) {
            this.mValue = i;
        }

        public static ReferenceStrategy a(int i) {
            ReferenceStrategy[] referenceStrategyArr = e;
            int length = referenceStrategyArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return FIX_GOP;
                }
                ReferenceStrategy referenceStrategy = referenceStrategyArr[i3];
                if (i == referenceStrategy.mValue) {
                    return referenceStrategy;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/VideoEncoderDef$VideoEncoderDataListener.class */
    public interface VideoEncoderDataListener {
        void onEncodedFail(h.a aVar);

        void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z);

        void onOutputFormatChanged(MediaFormat mediaFormat);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/VideoEncoderDef$a.class */
    public enum a {
        HARDWARE(1),
        SOFTWARE(2);
        
        int value;

        a(int i) {
            this.value = i;
        }
    }
}
