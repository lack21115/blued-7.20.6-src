package android.media;

/* loaded from: source-9557208-dex2jar.jar:android/media/AudioFormat.class */
public class AudioFormat {
    public static final int AUDIO_FORMAT_HAS_PROPERTY_CHANNEL_MASK = 4;
    public static final int AUDIO_FORMAT_HAS_PROPERTY_ENCODING = 1;
    public static final int AUDIO_FORMAT_HAS_PROPERTY_NONE = 0;
    public static final int AUDIO_FORMAT_HAS_PROPERTY_SAMPLE_RATE = 2;
    @Deprecated
    public static final int CHANNEL_CONFIGURATION_DEFAULT = 1;
    @Deprecated
    public static final int CHANNEL_CONFIGURATION_INVALID = 0;
    @Deprecated
    public static final int CHANNEL_CONFIGURATION_MONO = 2;
    @Deprecated
    public static final int CHANNEL_CONFIGURATION_STEREO = 3;
    public static final int CHANNEL_INVALID = 0;
    public static final int CHANNEL_IN_5POINT1 = 252;
    public static final int CHANNEL_IN_BACK = 32;
    public static final int CHANNEL_IN_BACK_PROCESSED = 512;
    public static final int CHANNEL_IN_DEFAULT = 1;
    public static final int CHANNEL_IN_FRONT = 16;
    public static final int CHANNEL_IN_FRONT_BACK = 48;
    public static final int CHANNEL_IN_FRONT_PROCESSED = 256;
    public static final int CHANNEL_IN_LEFT = 4;
    public static final int CHANNEL_IN_LEFT_PROCESSED = 64;
    public static final int CHANNEL_IN_MONO = 16;
    public static final int CHANNEL_IN_PRESSURE = 1024;
    public static final int CHANNEL_IN_RIGHT = 8;
    public static final int CHANNEL_IN_RIGHT_PROCESSED = 128;
    public static final int CHANNEL_IN_STEREO = 12;
    public static final int CHANNEL_IN_VOICE_DNLINK = 32768;
    public static final int CHANNEL_IN_VOICE_UPLINK = 16384;
    public static final int CHANNEL_IN_X_AXIS = 2048;
    public static final int CHANNEL_IN_Y_AXIS = 4096;
    public static final int CHANNEL_IN_Z_AXIS = 8192;
    public static final int CHANNEL_OUT_5POINT1 = 252;
    public static final int CHANNEL_OUT_5POINT1_SIDE = 6204;
    public static final int CHANNEL_OUT_7POINT1 = 1020;
    public static final int CHANNEL_OUT_7POINT1_SURROUND = 6396;
    public static final int CHANNEL_OUT_BACK_CENTER = 1024;
    public static final int CHANNEL_OUT_BACK_LEFT = 64;
    public static final int CHANNEL_OUT_BACK_RIGHT = 128;
    public static final int CHANNEL_OUT_DEFAULT = 1;
    public static final int CHANNEL_OUT_FRONT_CENTER = 16;
    public static final int CHANNEL_OUT_FRONT_LEFT = 4;
    public static final int CHANNEL_OUT_FRONT_LEFT_OF_CENTER = 256;
    public static final int CHANNEL_OUT_FRONT_RIGHT = 8;
    public static final int CHANNEL_OUT_FRONT_RIGHT_OF_CENTER = 512;
    public static final int CHANNEL_OUT_LOW_FREQUENCY = 32;
    public static final int CHANNEL_OUT_MONO = 4;
    public static final int CHANNEL_OUT_QUAD = 204;
    public static final int CHANNEL_OUT_QUAD_SIDE = 6156;
    public static final int CHANNEL_OUT_SIDE_LEFT = 2048;
    public static final int CHANNEL_OUT_SIDE_RIGHT = 4096;
    public static final int CHANNEL_OUT_STEREO = 12;
    public static final int CHANNEL_OUT_SURROUND = 1052;
    public static final int CHANNEL_OUT_TOP_BACK_CENTER = 262144;
    public static final int CHANNEL_OUT_TOP_BACK_LEFT = 131072;
    public static final int CHANNEL_OUT_TOP_BACK_RIGHT = 524288;
    public static final int CHANNEL_OUT_TOP_CENTER = 8192;
    public static final int CHANNEL_OUT_TOP_FRONT_CENTER = 32768;
    public static final int CHANNEL_OUT_TOP_FRONT_LEFT = 16384;
    public static final int CHANNEL_OUT_TOP_FRONT_RIGHT = 65536;
    public static final int ENCODING_AC3 = 5;
    public static final int ENCODING_AMRNB = 100;
    public static final int ENCODING_AMRWB = 101;
    public static final int ENCODING_DEFAULT = 1;
    public static final int ENCODING_EVRC = 102;
    public static final int ENCODING_EVRCB = 103;
    public static final int ENCODING_EVRCNW = 105;
    public static final int ENCODING_EVRCWB = 104;
    public static final int ENCODING_E_AC3 = 6;
    public static final int ENCODING_INVALID = 0;
    public static final int ENCODING_PCM_16BIT = 2;
    public static final int ENCODING_PCM_8BIT = 3;
    public static final int ENCODING_PCM_FLOAT = 4;
    private int mChannelMask;
    private int mEncoding;
    private int mPropertySetMask;
    private int mSampleRate;

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioFormat$Builder.class */
    public static class Builder {
        private int mChannelMask;
        private int mEncoding;
        private int mPropertySetMask;
        private int mSampleRate;

        public Builder() {
            this.mEncoding = 0;
            this.mSampleRate = 0;
            this.mChannelMask = 0;
            this.mPropertySetMask = 0;
        }

        public Builder(AudioFormat audioFormat) {
            this.mEncoding = 0;
            this.mSampleRate = 0;
            this.mChannelMask = 0;
            this.mPropertySetMask = 0;
            this.mEncoding = audioFormat.mEncoding;
            this.mSampleRate = audioFormat.mSampleRate;
            this.mChannelMask = audioFormat.mChannelMask;
            this.mPropertySetMask = audioFormat.mPropertySetMask;
        }

        public AudioFormat build() {
            AudioFormat audioFormat = new AudioFormat(1980);
            audioFormat.mEncoding = this.mEncoding;
            audioFormat.mSampleRate = this.mSampleRate;
            audioFormat.mChannelMask = this.mChannelMask;
            audioFormat.mPropertySetMask = this.mPropertySetMask;
            return audioFormat;
        }

        public Builder setChannelMask(int i) {
            this.mChannelMask = i;
            this.mPropertySetMask |= 4;
            return this;
        }

        public Builder setEncoding(int i) throws IllegalArgumentException {
            switch (i) {
                case 1:
                    this.mEncoding = 2;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                    this.mEncoding = i;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid encoding " + i);
            }
            this.mPropertySetMask |= 1;
            return this;
        }

        public Builder setSampleRate(int i) throws IllegalArgumentException {
            if (i <= 0 || i > 192000) {
                throw new IllegalArgumentException("Invalid sample rate " + i);
            }
            this.mSampleRate = i;
            this.mPropertySetMask |= 2;
            return this;
        }
    }

    public AudioFormat() {
        throw new UnsupportedOperationException("There is no valid usage of this constructor");
    }

    private AudioFormat(int i) {
    }

    private AudioFormat(int i, int i2, int i3) {
        this.mEncoding = i;
        this.mSampleRate = i2;
        this.mChannelMask = i3;
        this.mPropertySetMask = 7;
    }

    public static int channelCountFromInChannelMask(int i) {
        return Integer.bitCount(i);
    }

    public static int channelCountFromOutChannelMask(int i) {
        return Integer.bitCount(i);
    }

    public static int convertChannelOutMaskToNativeMask(int i) {
        return i >> 2;
    }

    public static int convertNativeChannelMaskToOutMask(int i) {
        return i << 2;
    }

    public static int getBytesPerSample(int i) {
        switch (i) {
            case 1:
            case 2:
                return 2;
            case 3:
                return 1;
            case 4:
                return 4;
            case 100:
                return 32;
            case 101:
                return 61;
            case 102:
            case 103:
            case 104:
            case 105:
                return 23;
            default:
                throw new IllegalArgumentException("Bad audio format " + i);
        }
    }

    public static int inChannelMaskFromOutChannelMask(int i) throws IllegalArgumentException {
        if (i == 1) {
            throw new IllegalArgumentException("Illegal CHANNEL_OUT_DEFAULT channel mask for input.");
        }
        switch (channelCountFromOutChannelMask(i)) {
            case 1:
                return 16;
            case 2:
                return 12;
            default:
                throw new IllegalArgumentException("Unsupported channel configuration for input.");
        }
    }

    public static boolean isEncodingLinearPcm(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            case 5:
            case 6:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
                return false;
            default:
                throw new IllegalArgumentException("Bad audio format " + i);
        }
    }

    public static boolean isValidEncoding(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
                return true;
            default:
                return false;
        }
    }

    public int getChannelMask() {
        if ((this.mPropertySetMask & 4) == 0) {
            return 0;
        }
        return this.mChannelMask;
    }

    public int getEncoding() {
        if ((this.mPropertySetMask & 1) == 0) {
            return 0;
        }
        return this.mEncoding;
    }

    public int getPropertySetMask() {
        return this.mPropertySetMask;
    }

    public int getSampleRate() {
        if ((this.mPropertySetMask & 2) == 0) {
            return 0;
        }
        return this.mSampleRate;
    }

    public String toString() {
        return new String("AudioFormat: props=" + this.mPropertySetMask + " enc=" + this.mEncoding + " chan=0x" + Integer.toHexString(this.mChannelMask) + " rate=" + this.mSampleRate);
    }
}
