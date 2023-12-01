package a.a.a.a.a.d;

import com.huawei.openalliance.ad.constant.ao;
import com.qiniu.pili.droid.streaming.AVCodecType;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.WatermarkSetting;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/d/b.class */
public class b {

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/d/b$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1295a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007d -> B:61:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0081 -> B:55:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0085 -> B:51:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0089 -> B:45:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x008d -> B:59:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0091 -> B:53:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0095 -> B:49:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0099 -> B:43:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x009d -> B:57:0x0070). Please submit an issue!!! */
        static {
            int[] iArr = new int[AVCodecType.values().length];
            f1295a = iArr;
            try {
                iArr[AVCodecType.HW_VIDEO_WITH_HW_AUDIO_CODEC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1295a[AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_HW_AUDIO_CODEC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1295a[AVCodecType.SW_VIDEO_WITH_HW_AUDIO_CODEC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1295a[AVCodecType.HW_VIDEO_YUV_AS_INPUT_WITH_HW_AUDIO_CODEC.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1295a[AVCodecType.SW_VIDEO_WITH_SW_AUDIO_CODEC.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f1295a[AVCodecType.SW_AUDIO_CODEC.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f1295a[AVCodecType.HW_AUDIO_CODEC.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f1295a[AVCodecType.SW_VIDEO_CODEC.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f1295a[AVCodecType.HW_VIDEO_CODEC.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f1295a[AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_SW_AUDIO_CODEC.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    public static void a() {
        a("streamInit");
    }

    public static void a(AVCodecType aVCodecType) {
        switch (a.f1295a[aVCodecType.ordinal()]) {
            case 1:
            case 2:
                a("videoHardEncode");
                a("audioHardEncode");
                return;
            case 3:
            case 4:
                a("videoSoftEncode");
                a("audioHardEncode");
                return;
            case 5:
                a("videoSoftEncode");
                a("audioSoftEncode");
                return;
            case 6:
                a("audioSoftEncode");
                return;
            case 7:
                a("audioHardEncode");
                return;
            case 8:
                a("videoSoftEncode");
                return;
            case 9:
                a("videoHardEncode");
                return;
            case 10:
                a("videoHardEncode");
                a("audioSoftEncode");
                return;
            default:
                return;
        }
    }

    public static void a(CameraStreamingSetting.VIDEO_FILTER_TYPE video_filter_type) {
        if (video_filter_type.equals(CameraStreamingSetting.VIDEO_FILTER_TYPE.VIDEO_FILTER_BEAUTY)) {
            a("beautify");
        }
    }

    public static void a(StreamingProfile streamingProfile) {
        if (streamingProfile.f()) {
            a("quic");
        }
        a("encodeConfig");
    }

    public static void a(WatermarkSetting watermarkSetting) {
        if (watermarkSetting != null) {
            a("waterMark");
        } else {
            a("clearWaterMark");
        }
    }

    public static void a(String str) {
        f.a().b(str);
    }

    public static void a(boolean z) {
        if (z) {
            a(ao.au);
        }
    }

    public static void b() {
        a("cameraConfig");
    }

    public static void c() {
        a("microphoneConfig");
    }

    public static void d() {
        a("mediaStreamingStart");
    }

    public static void e() {
        a("mediaStreamingStop");
    }

    public static void f() {
        a("mediaStreamingDestroy");
    }

    public static void g() {
        a("inputStreamingStart");
    }

    public static void h() {
        a("inputStreamingStop");
    }

    public static void i() {
        a("inputStreamingDestroy");
    }

    public static void j() {
        a("toggleCamera");
    }

    public static void k() {
        a("startCapture");
    }

    public static void l() {
        a("stopCapture");
    }

    public static void m() {
        a("captureFrame");
    }

    public static void n() {
        a("pushImage");
    }

    public static void o() {
        a("playback");
    }

    public static void p() {
        a("audioFile");
    }

    public static void q() {
        a("closeAudioFile");
    }
}
