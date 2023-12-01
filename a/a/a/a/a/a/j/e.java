package a.a.a.a.a.a.j;

import a.a.a.a.a.a.j.f;
import a.a.a.a.a.e.h;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.BatteryManager;
import android.view.Surface;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import java.io.IOException;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/e.class */
public class e extends a.a.a.a.a.a.a implements a.a.a.a.a.a.g.a {
    public Surface d;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/e$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1270a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[StreamingProfile.H264Profile.values().length];
            f1270a = iArr;
            try {
                iArr[StreamingProfile.H264Profile.BASELINE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1270a[StreamingProfile.H264Profile.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1270a[StreamingProfile.H264Profile.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public e(a.a.a.a.a.a.i.c cVar) throws IOException {
        super(cVar);
        cVar.a(this);
        a.a.a.a.a.a.b d = cVar.d();
        MediaFormat a2 = a(MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface, d, d.f().getVideoProfile());
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.i;
        eVar.a("VideoEncoderCore", "format: " + a2);
        a.a.a.a.a.a.g.c cVar2 = new a.a.a.a.a.a.g.c(a2, "video/avc", true);
        this.b = cVar2;
        this.d = cVar2.e();
        this.b.d();
        this.f1213c = 1;
    }

    public e(f.a aVar) {
        super(aVar.f1271a);
        aVar.f1271a.a(this);
        MediaCodecInfo a2 = a("video/avc");
        if (a2 == null) {
            a.a.a.a.a.e.e.i.e("VideoEncoderCore", "Unable to find an appropriate codec for video/avc");
            return;
        }
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.i;
        eVar.c("VideoEncoderCore", "found codec: " + a2.getName());
        int[] a3 = a(a2, "video/avc");
        if (a3 == null) {
            a.a.a.a.a.e.e.i.e("VideoEncoderCore", "Unable to find an appropriate colorFormat for video/avc");
            return;
        }
        a.a.a.a.a.e.e eVar2 = a.a.a.a.a.e.e.i;
        eVar2.c("VideoEncoderCore", "found colorFormat:[" + a3[0] + "," + a3[1] + "]");
        aVar.k = a3[1];
        a.a.a.a.a.a.b d = aVar.f1271a.d();
        a.a.a.a.a.e.e eVar3 = a.a.a.a.a.e.e.i;
        eVar3.c("VideoEncoderCore", "encoding rotation:" + aVar.e);
        MediaFormat a4 = a(a3[0], d, d.f().getVideoProfile());
        a.a.a.a.a.e.e eVar4 = a.a.a.a.a.e.e.i;
        eVar4.c("VideoEncoderCore", "format: " + a4);
        a.a.a.a.a.a.g.e eVar5 = new a.a.a.a.a.a.g.e(a4, "video/avc", true, aVar);
        this.b = eVar5;
        eVar5.d();
        this.f1213c = 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.media.MediaCodecInfo a(java.lang.String r3) {
        /*
            int r0 = android.media.MediaCodecList.getCodecCount()
            r6 = r0
            r0 = 0
            r4 = r0
        L6:
            r0 = r4
            r1 = r6
            if (r0 >= r1) goto L4c
            r0 = r4
            android.media.MediaCodecInfo r0 = android.media.MediaCodecList.getCodecInfoAt(r0)
            r8 = r0
            r0 = r8
            boolean r0 = r0.isEncoder()
            if (r0 != 0) goto L1c
            goto L45
        L1c:
            r0 = r8
            java.lang.String[] r0 = r0.getSupportedTypes()
            r9 = r0
            r0 = r9
            int r0 = r0.length
            r7 = r0
            r0 = 0
            r5 = r0
        L2a:
            r0 = r5
            r1 = r7
            if (r0 >= r1) goto L45
            r0 = r9
            r1 = r5
            r0 = r0[r1]
            r1 = r3
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L3e
            r0 = r8
            return r0
        L3e:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L2a
        L45:
            r0 = r4
            r1 = 1
            int r0 = r0 + r1
            r4 = r0
            goto L6
        L4c:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.j.e.a(java.lang.String):android.media.MediaCodecInfo");
    }

    public static int[] a(MediaCodecInfo mediaCodecInfo, String str) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        int i = 0;
        while (true) {
            int i2 = i;
            int[] iArr = capabilitiesForType.colorFormats;
            if (i2 >= iArr.length) {
                a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.i;
                eVar.e("VideoEncoderCore", "couldn't find a good color format for " + mediaCodecInfo.getName() + " / " + str);
                return null;
            }
            int i3 = iArr[i2];
            int c2 = c(i3);
            if (c2 != -1) {
                return new int[]{i3, c2};
            }
            i = i2 + 1;
        }
    }

    public static int c(int i) {
        if (i != 19) {
            if (i != 21) {
                return -1;
            }
            return PLFourCC.FOURCC_NV12;
        }
        return PLFourCC.FOURCC_I420;
    }

    public final MediaFormat a(int i, a.a.a.a.a.a.b bVar, StreamingProfile.VideoProfile videoProfile) {
        int a2 = bVar.a().a();
        int b = bVar.a().b();
        int i2 = a2;
        if (h.e()) {
            i2 = h.a(a2, b);
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, b);
        createVideoFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, i);
        int round = Math.round((bVar.p() * 1.0f) / bVar.r());
        a.a.a.a.a.e.e.i.c("VideoEncoderCore", "w:" + i2 + ", h:" + b + ",iFrameInterval:" + round + ",fps:" + bVar.r() + ",bitrate:" + bVar.d());
        createVideoFormat.setInteger(MediaFormat.KEY_BIT_RATE, bVar.d());
        createVideoFormat.setInteger(MediaFormat.KEY_FRAME_RATE, bVar.r());
        createVideoFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, round);
        createVideoFormat.setInteger(BatteryManager.EXTRA_LEVEL, 128);
        int i3 = a.f1270a[videoProfile.getH264Profile().ordinal()];
        int i4 = 2;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    i4 = 8;
                }
            }
            createVideoFormat.setInteger(MediaFormat.KEY_PROFILE, i4);
            return createVideoFormat;
        }
        i4 = 1;
        createVideoFormat.setInteger(MediaFormat.KEY_PROFILE, i4);
        return createVideoFormat;
    }

    @Override // a.a.a.a.a.a.g.a
    public void a(PLAVFrame pLAVFrame, PLBufferInfo pLBufferInfo) {
        this.b.a(this.f1212a, pLAVFrame, pLBufferInfo, false);
    }

    public Surface e() {
        return this.d;
    }
}
