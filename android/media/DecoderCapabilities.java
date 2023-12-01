package android.media;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/media/DecoderCapabilities.class */
public class DecoderCapabilities {

    /* loaded from: source-9557208-dex2jar.jar:android/media/DecoderCapabilities$AudioDecoder.class */
    public enum AudioDecoder {
        AUDIO_DECODER_WMA
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/DecoderCapabilities$VideoDecoder.class */
    public enum VideoDecoder {
        VIDEO_DECODER_WMV
    }

    static {
        System.loadLibrary("media_jni");
        native_init();
    }

    private DecoderCapabilities() {
    }

    public static List<AudioDecoder> getAudioDecoders() {
        ArrayList arrayList = new ArrayList();
        int native_get_num_audio_decoders = native_get_num_audio_decoders();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= native_get_num_audio_decoders) {
                return arrayList;
            }
            arrayList.add(AudioDecoder.values()[native_get_audio_decoder_type(i2)]);
            i = i2 + 1;
        }
    }

    public static List<VideoDecoder> getVideoDecoders() {
        ArrayList arrayList = new ArrayList();
        int native_get_num_video_decoders = native_get_num_video_decoders();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= native_get_num_video_decoders) {
                return arrayList;
            }
            arrayList.add(VideoDecoder.values()[native_get_video_decoder_type(i2)]);
            i = i2 + 1;
        }
    }

    private static final native int native_get_audio_decoder_type(int i);

    private static final native int native_get_num_audio_decoders();

    private static final native int native_get_num_video_decoders();

    private static final native int native_get_video_decoder_type(int i);

    private static final native void native_init();
}
