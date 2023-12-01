package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.BatteryManager;
import android.util.Pair;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/v.class */
final class v {

    /* renamed from: a  reason: collision with root package name */
    boolean f23347a = true;
    boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    boolean f23348c = true;
    private final MediaCodec d;
    private final String e;
    private final VideoEncodeParams f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videoproducer.encoder.v$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/v$1.class */
    public static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23349a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0055 -> B:32:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0059 -> B:28:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005d -> B:8:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0061 -> B:34:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0065 -> B:30:0x0049). Please submit an issue!!! */
        static {
            int[] iArr = new int[VideoEncoderDef.EncoderProfile.values().length];
            b = iArr;
            try {
                iArr[VideoEncoderDef.EncoderProfile.PROFILE_MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[VideoEncoderDef.EncoderProfile.PROFILE_HIGH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[VideoEncoderDef.EncoderProfile.PROFILE_BASELINE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            int[] iArr2 = new int[VideoEncoderDef.BitrateMode.values().length];
            f23349a = iArr2;
            try {
                iArr2[VideoEncoderDef.BitrateMode.CBR.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f23349a[VideoEncoderDef.BitrateMode.VBR.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f23349a[VideoEncoderDef.BitrateMode.CQ.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public v(MediaCodec mediaCodec, String str, VideoEncodeParams videoEncodeParams) {
        this.d = mediaCodec;
        this.e = str;
        this.f = videoEncodeParams;
    }

    private static int a(VideoEncoderDef.BitrateMode bitrateMode) {
        int i = 2;
        if (bitrateMode == null) {
            return 2;
        }
        int i2 = AnonymousClass1.f23349a[bitrateMode.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return i2 != 3 ? 2 : 0;
            }
            i = 1;
        }
        return i;
    }

    private MediaCodecInfo.VideoCapabilities a(int i, int i2) {
        MediaCodecInfo.CodecCapabilities createFromProfileLevel;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21 && (createFromProfileLevel = MediaCodecInfo.CodecCapabilities.createFromProfileLevel(this.e, i, i2)) != null) {
            return createFromProfileLevel.getVideoCapabilities();
        }
        return null;
    }

    private static Pair<Integer, Integer> a(MediaFormat mediaFormat) {
        int i;
        int i2 = 0;
        try {
            i = mediaFormat.getInteger(MediaFormat.KEY_PROFILE);
        } catch (Exception e) {
            LiteavLog.i("MediaFormatBuilder", "get profile fail.", e);
            i = 0;
        }
        try {
            i2 = mediaFormat.getInteger(BatteryManager.EXTRA_LEVEL);
        } catch (Exception e2) {
            LiteavLog.i("MediaFormatBuilder", "get level fail.", e2);
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:148:0x0497, code lost:
        if (r0.intValue() > r0.intValue()) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x00e8, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0241 A[EDGE_INSN: B:245:0x0241->B:82:0x0241 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0252  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.media.MediaFormat a() {
        /*
            Method dump skipped, instructions count: 2096
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.encoder.v.a():android.media.MediaFormat");
    }
}
