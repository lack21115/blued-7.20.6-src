package android.media;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/media/EncoderCapabilities.class */
public class EncoderCapabilities {
    private static final String TAG = "EncoderCapabilities";

    /* loaded from: source-9557208-dex2jar.jar:android/media/EncoderCapabilities$AudioEncoderCap.class */
    public static class AudioEncoderCap {
        public final int mCodec;
        public final int mMaxBitRate;
        public final int mMaxChannels;
        public final int mMaxSampleRate;
        public final int mMinBitRate;
        public final int mMinChannels;
        public final int mMinSampleRate;

        private AudioEncoderCap(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.mCodec = i;
            this.mMinBitRate = i2;
            this.mMaxBitRate = i3;
            this.mMinSampleRate = i4;
            this.mMaxSampleRate = i5;
            this.mMinChannels = i6;
            this.mMaxChannels = i7;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/EncoderCapabilities$VideoEncoderCap.class */
    public static class VideoEncoderCap {
        public final int mCodec;
        public final int mMaxBitRate;
        public final int mMaxFrameHeight;
        public final int mMaxFrameRate;
        public final int mMaxFrameWidth;
        public final int mMaxHFRFrameHeight;
        public final int mMaxHFRFrameWidth;
        public final int mMaxHFRMode;
        public final int mMinBitRate;
        public final int mMinFrameHeight;
        public final int mMinFrameRate;
        public final int mMinFrameWidth;

        private VideoEncoderCap(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            this.mCodec = i;
            this.mMinBitRate = i2;
            this.mMaxBitRate = i3;
            this.mMinFrameRate = i4;
            this.mMaxFrameRate = i5;
            this.mMinFrameWidth = i6;
            this.mMaxFrameWidth = i7;
            this.mMinFrameHeight = i8;
            this.mMaxFrameHeight = i9;
            this.mMaxHFRFrameWidth = i10;
            this.mMaxHFRFrameHeight = i11;
            this.mMaxHFRMode = i12;
        }
    }

    static {
        System.loadLibrary("media_jni");
        native_init();
    }

    private EncoderCapabilities() {
    }

    public static List<AudioEncoderCap> getAudioEncoders() {
        ArrayList arrayList;
        int native_get_num_audio_encoders = native_get_num_audio_encoders();
        if (native_get_num_audio_encoders != 0) {
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                arrayList = arrayList2;
                if (i2 >= native_get_num_audio_encoders) {
                    break;
                }
                arrayList2.add(native_get_audio_encoder_cap(i2));
                i = i2 + 1;
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    public static int[] getOutputFileFormats() {
        int[] iArr;
        int native_get_num_file_formats = native_get_num_file_formats();
        if (native_get_num_file_formats != 0) {
            int[] iArr2 = new int[native_get_num_file_formats];
            int i = 0;
            while (true) {
                int i2 = i;
                iArr = iArr2;
                if (i2 >= native_get_num_file_formats) {
                    break;
                }
                iArr2[i2] = native_get_file_format(i2);
                i = i2 + 1;
            }
        } else {
            iArr = null;
        }
        return iArr;
    }

    public static List<VideoEncoderCap> getVideoEncoders() {
        ArrayList arrayList;
        int native_get_num_video_encoders = native_get_num_video_encoders();
        if (native_get_num_video_encoders != 0) {
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                arrayList = arrayList2;
                if (i2 >= native_get_num_video_encoders) {
                    break;
                }
                arrayList2.add(native_get_video_encoder_cap(i2));
                i = i2 + 1;
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    private static final native AudioEncoderCap native_get_audio_encoder_cap(int i);

    private static final native int native_get_file_format(int i);

    private static final native int native_get_num_audio_encoders();

    private static final native int native_get_num_file_formats();

    private static final native int native_get_num_video_encoders();

    private static final native VideoEncoderCap native_get_video_encoder_cap(int i);

    private static final native void native_init();
}
