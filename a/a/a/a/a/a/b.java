package a.a.a.a.a.a;

import a.a.a.a.a.a.i.c;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.f;
import android.content.Context;
import android.graphics.Point;
import com.qiniu.pili.droid.streaming.AVCodecType;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.core.PLDroidStreamingCore;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0000b f1166a;

    /* renamed from: c  reason: collision with root package name */
    public AVCodecType f1167c;
    public c.EnumC0001c d;
    public a.a.a.a.a.a.e.a e;
    public int f;
    public int g;
    public StreamingProfile h;
    public CameraStreamingSetting.PREVIEW_SIZE_RATIO i;
    public f j;
    public d m;
    public c b = c.UNKNOWN;
    public f k = new f(0, 0);
    public Point l = new Point(-1, -1);

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/b$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1168a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[c.EnumC0001c.values().length];
            f1168a = iArr;
            try {
                iArr[c.EnumC0001c.MPEG4.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1168a[c.EnumC0001c.HLS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1168a[c.EnumC0001c.RTMP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: a.a.a.a.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/b$b.class */
    public interface InterfaceC0000b {
        void a(c cVar, Object obj);
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/b$c.class */
    public enum c {
        UNKNOWN,
        PREPARING,
        READY,
        CONNECTING,
        STREAMING,
        SHUTDOWN,
        IOERROR,
        TIMEOUT,
        DISCONNECTED,
        FRAME_QUEUE_EMPTY,
        FRAME_QUEUE_FULL,
        FRAME_QUEUE_HAS_FEW_ELEMENTS,
        FRAME_QUEUE_HAS_MANY_ELEMENTS,
        AUDIO_RECORDING_EXCEPTION,
        INVALID_FORMAT,
        UNAUTHORIZED_URL,
        ADJUST_BITRATE
    }

    public b(Context context, InterfaceC0000b interfaceC0000b) {
        this.f1166a = interfaceC0000b;
    }

    public static c.EnumC0001c a(String str) {
        if (str == null) {
            e.i.e("EncodingConfig", "outputString is null");
            return c.EnumC0001c.INVALID;
        } else if (str.startsWith("rtmp://")) {
            return c.EnumC0001c.RTMP;
        } else {
            if (str.endsWith(".mp4")) {
                return c.EnumC0001c.MPEG4;
            }
            if (str.endsWith(".m3u8")) {
                return c.EnumC0001c.HLS;
            }
            e eVar = e.i;
            eVar.e("EncodingConfig", "INVALID FORMAT:" + str);
            return c.EnumC0001c.INVALID;
        }
    }

    public f a() {
        return this.j;
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(c cVar, Object obj) {
        if (this.b == cVar) {
            return;
        }
        this.b = cVar;
        this.f1166a.a(cVar, obj);
    }

    public void a(a.a.a.a.a.a.e.a aVar) {
        this.e = aVar;
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.k = fVar;
        }
    }

    public void a(Point point) {
        if (point != null) {
            this.l = point;
        }
    }

    public void a(AVCodecType aVCodecType) {
        this.f1167c = aVCodecType;
    }

    public void a(CameraStreamingSetting.PREVIEW_SIZE_RATIO preview_size_ratio) {
        this.i = preview_size_ratio;
    }

    public void a(StreamingProfile.VideoEncodingSize videoEncodingSize) {
        StreamingProfile.VideoEncodingSize videoEncodingSize2 = videoEncodingSize;
        if (videoEncodingSize == null) {
            videoEncodingSize2 = this.h.getVideoEncodingSize(this.i);
        }
        int i = videoEncodingSize2.width;
        int i2 = videoEncodingSize2.height;
        e eVar = e.i;
        eVar.c("EncodingConfig", "isEncodingLandscape:" + this.h.c());
        if (videoEncodingSize2.level < 0) {
            this.j = new f(i, i2);
        } else if (this.h.c()) {
            if (i < i2) {
                this.j = new f(i2, i);
            } else {
                this.j = new f(i, i2);
            }
        } else if (i2 < i) {
            this.j = new f(i2, i);
        } else {
            this.j = new f(i, i2);
        }
        a(this.h.getStartPoint());
        a(this.h.getImageSize());
    }

    public void a(StreamingProfile streamingProfile) {
        e eVar = e.i;
        eVar.c("EncodingConfig", "setStreamingProfile profile:" + streamingProfile + ",stream:" + streamingProfile.getStream() + ",mEncodingSizeRatio:" + this.i);
        this.h = streamingProfile;
        b(streamingProfile.getVideoProfile().reqFps * 1000);
        a(streamingProfile.getVideoProfile().reqFps);
        if (this.h.getStream() == null) {
            this.m = new d(null, this.h.getPublishUrl());
        } else {
            this.m = new d(this.h.getStream(), this.h.getPublishHost());
        }
        CameraStreamingSetting.PREVIEW_SIZE_RATIO preview_size_ratio = this.i;
        if (preview_size_ratio != null) {
            a(this.h.getVideoEncodingSize(preview_size_ratio));
        }
        String a2 = this.m.a();
        this.d = a(a2);
        e eVar2 = e.i;
        eVar2.c("EncodingConfig", "setStreamingProfile mFormat=" + this.d);
        if (this.d == c.EnumC0001c.INVALID) {
            a(c.INVALID_FORMAT, a2);
        }
    }

    public f b() {
        return this.k;
    }

    public void b(int i) {
        this.f = i;
    }

    public Point c() {
        return this.l;
    }

    public int d() {
        StreamingProfile streamingProfile = this.h;
        if (streamingProfile != null) {
            return streamingProfile.getVideoProfile().reqBitrate;
        }
        return 1500000;
    }

    public boolean e() {
        StreamingProfile streamingProfile = this.h;
        if (streamingProfile != null) {
            return streamingProfile.getVideoProfile().avcc;
        }
        return true;
    }

    public StreamingProfile f() {
        return this.h;
    }

    public String g() {
        return this.m.a();
    }

    public c.EnumC0001c h() {
        return this.d;
    }

    public boolean i() {
        return this.d != c.EnumC0001c.INVALID;
    }

    public a.a.a.a.a.a.e.a j() {
        return this.e;
    }

    public boolean k() {
        AVCodecType aVCodecType = this.f1167c;
        return aVCodecType == AVCodecType.SW_VIDEO_WITH_HW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_VIDEO_WITH_SW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_VIDEO_CODEC;
    }

    public boolean l() {
        AVCodecType aVCodecType = this.f1167c;
        return aVCodecType == AVCodecType.SW_VIDEO_WITH_SW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_AUDIO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_SURFACE_AS_INPUT_WITH_SW_AUDIO_CODEC;
    }

    public String m() {
        return k() ? "x264" : "droid264";
    }

    public String n() {
        return l() ? "voaac" : "droidaac";
    }

    public PLDroidStreamingCore.AVOptions o() {
        PLDroidStreamingCore.AVOptions aVOptions = new PLDroidStreamingCore.AVOptions();
        int i = a.f1168a[this.d.ordinal()];
        if (i == 1) {
            aVOptions.outputFormatName = "mp4";
        } else if (i == 2) {
            aVOptions.outputFormatName = "hls";
        } else if (i != 3) {
            throw new IllegalArgumentException("Unrecognized format! " + aVOptions.outputFormatName);
        } else {
            aVOptions.outputFormatName = "flv";
        }
        aVOptions.outputUrl = g();
        aVOptions.videoHeight = a().b();
        aVOptions.videoWidth = a().a();
        aVOptions.videoFps = r();
        aVOptions.videoBitRate = d();
        aVOptions.avcc = e();
        aVOptions.audioSampleRate = this.e.b();
        aVOptions.audioNumChannels = this.e.a();
        aVOptions.audioBitRate = this.e.c();
        aVOptions.videoEncodeType = m();
        aVOptions.audioEncodeType = n();
        return aVOptions;
    }

    public int p() {
        return this.h.getVideoProfile().maxKeyFrameInterval;
    }

    public int q() {
        return this.f;
    }

    public int r() {
        return this.g;
    }

    public c s() {
        return this.b;
    }

    public boolean t() {
        return this.b == c.STREAMING;
    }
}
