package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.decoder.ay;
import java.nio.ByteBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    String f23088a;
    final InterfaceC0768d b;

    /* renamed from: c  reason: collision with root package name */
    final IVideoReporter f23089c;
    boolean e;
    boolean f;
    ay.a h;
    e j;
    long k;
    long l;
    boolean o;
    int p;
    int q;
    boolean r;
    int t;
    boolean u;
    final SpsInfo d = new SpsInfo();
    VideoDecodeController.DecodeStrategy g = VideoDecodeController.DecodeStrategy.f23046a;
    boolean i = false;
    int m = 8;
    int n = 6;
    int s = 0;
    boolean v = false;
    boolean w = true;
    boolean x = false;
    VideoDecoderDef.ConsumerScene y = VideoDecoderDef.ConsumerScene.UNKNOWN;
    long z = 0;
    long A = 0;
    int B = 0;
    boolean C = false;
    int D = 1;

    /* renamed from: com.tencent.liteav.videoconsumer.decoder.d$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/d$1.class */
    static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23090a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[c.values().length];
            f23090a = iArr;
            try {
                iArr[c.SWITCH_TO_SOFTWARE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23090a[c.SWITCH_TO_HARDWARE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23090a[c.RESTART_DECODER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23090a[c.CONTINUE_DECODE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/d$a.class */
    interface a {
        b a(EncodedVideoFrame encodedVideoFrame);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/d$b.class */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final c f23091a;
        public final e b;

        public b(c cVar, e eVar) {
            this.f23091a = cVar;
            this.b = eVar;
            if (cVar != c.SWITCH_TO_HARDWARE && this.f23091a != c.SWITCH_TO_SOFTWARE && this.b != e.NONE) {
                throw new RuntimeException("SwitchReason must be NONE.)");
            }
        }

        public final String toString() {
            return "CheckResult{instruction=" + this.f23091a + ", reason=" + this.b + '}';
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/d$c.class */
    public enum c {
        CONTINUE_DECODE(0),
        DROP_FRAME(1),
        RESTART_DECODER(2),
        SWITCH_TO_HARDWARE(3),
        SWITCH_TO_SOFTWARE(3),
        REQUEST_KEY_FRAME(4),
        REPORT_DECODE_ERROR(5);
        
        private final int mPriority;

        c(int i) {
            this.mPriority = i;
        }
    }

    /* renamed from: com.tencent.liteav.videoconsumer.decoder.d$d  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/d$d.class */
    public interface InterfaceC0768d {
        SpsInfo a(boolean z, ByteBuffer byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/d$e.class */
    public enum e {
        NONE(0),
        RPS_MODE_UPDATED(1),
        SVC_MODE_UPDATED(2),
        HARDWARE_DECODER_ABNORMAL(3),
        LOW_RESOLUTION(4),
        DECODE_ERROR(5),
        OTHERS_DO_NOT_SUPPORT_H265(6);
        
        final int mPriority;

        e(int i) {
            this.mPriority = i;
        }
    }

    public d(InterfaceC0768d interfaceC0768d, IVideoReporter iVideoReporter, boolean z, boolean z2) {
        this.f23088a = "DecoderSupervisor";
        this.b = interfaceC0768d;
        this.f23089c = iVideoReporter;
        this.e = z;
        this.f = z2;
        String str = this.f23088a + "_" + hashCode();
        this.f23088a = str;
        LiteavLog.i(str, "mIsSW265Supported:" + z + ",mIsHW265Supported:" + z2);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f23089c.notifyError(h.a.ERR_VIDEO_NO_AVAILABLE_HEVC_DECODERS, "no available hevc decoders", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(EncodedVideoFrame encodedVideoFrame) {
        if (!encodedVideoFrame.isH265() || this.f) {
            return this.g == VideoDecodeController.DecodeStrategy.f23047c || this.g == VideoDecodeController.DecodeStrategy.f23046a || this.g == VideoDecodeController.DecodeStrategy.b;
        }
        return false;
    }

    public final void b() {
        this.t = 0;
        this.u = false;
        this.o = false;
        this.q = 0;
        this.z = 0L;
        this.r = false;
        this.d.set(new SpsInfo());
        this.l = 0L;
        this.k = 0L;
        this.p = 0;
        this.h = null;
        this.j = e.NONE;
        this.s = 0;
        this.C = false;
        this.D = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b(EncodedVideoFrame encodedVideoFrame) {
        return !encodedVideoFrame.isH265() || this.e;
    }
}
