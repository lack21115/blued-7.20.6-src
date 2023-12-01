package com.anythink.expressad.exoplayer.f;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.o;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/f/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7329a = "MediaCodecInfo";
    public static final int b = -1;

    /* renamed from: c  reason: collision with root package name */
    public final String f7330c;
    public final String d;
    public final MediaCodecInfo.CodecCapabilities e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private a(java.lang.String r4, java.lang.String r5, android.media.MediaCodecInfo.CodecCapabilities r6, boolean r7, boolean r8, boolean r9) {
        /*
            r3 = this;
            r0 = r3
            r0.<init>()
            r0 = r3
            r1 = r4
            java.lang.Object r1 = com.anythink.expressad.exoplayer.k.a.a(r1)
            java.lang.String r1 = (java.lang.String) r1
            r0.f7330c = r1
            r0 = r3
            r1 = r5
            r0.d = r1
            r0 = r3
            r1 = r6
            r0.e = r1
            r0 = r3
            r1 = r7
            r0.i = r1
            r0 = 1
            r11 = r0
            r0 = r8
            if (r0 != 0) goto L50
            r0 = r6
            if (r0 == 0) goto L50
            int r0 = com.anythink.expressad.exoplayer.k.af.f7632a
            r1 = 19
            if (r0 < r1) goto L42
            r0 = r6
            java.lang.String r1 = "adaptive-playback"
            boolean r0 = r0.isFeatureSupported(r1)
            if (r0 == 0) goto L42
            r0 = 1
            r10 = r0
            goto L45
        L42:
            r0 = 0
            r10 = r0
        L45:
            r0 = r10
            if (r0 == 0) goto L50
            r0 = 1
            r7 = r0
            goto L53
        L50:
            r0 = 0
            r7 = r0
        L53:
            r0 = r3
            r1 = r7
            r0.f = r1
            r0 = r6
            if (r0 == 0) goto L82
            int r0 = com.anythink.expressad.exoplayer.k.af.f7632a
            r1 = 21
            if (r0 < r1) goto L74
            r0 = r6
            java.lang.String r1 = "tunneled-playback"
            boolean r0 = r0.isFeatureSupported(r1)
            if (r0 == 0) goto L74
            r0 = 1
            r10 = r0
            goto L77
        L74:
            r0 = 0
            r10 = r0
        L77:
            r0 = r10
            if (r0 == 0) goto L82
            r0 = 1
            r7 = r0
            goto L85
        L82:
            r0 = 0
            r7 = r0
        L85:
            r0 = r3
            r1 = r7
            r0.g = r1
            r0 = r11
            r7 = r0
            r0 = r9
            if (r0 != 0) goto Lc1
            r0 = r6
            if (r0 == 0) goto Lbe
            int r0 = com.anythink.expressad.exoplayer.k.af.f7632a
            r1 = 21
            if (r0 < r1) goto Laf
            r0 = r6
            java.lang.String r1 = "secure-playback"
            boolean r0 = r0.isFeatureSupported(r1)
            if (r0 == 0) goto Laf
            r0 = 1
            r10 = r0
            goto Lb2
        Laf:
            r0 = 0
            r10 = r0
        Lb2:
            r0 = r10
            if (r0 == 0) goto Lbe
            r0 = r11
            r7 = r0
            goto Lc1
        Lbe:
            r0 = 0
            r7 = r0
        Lc1:
            r0 = r3
            r1 = r7
            r0.h = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.f.a.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean):void");
    }

    private static int a(String str, String str2, int i) {
        if (i <= 1) {
            if (af.f7632a >= 26 && i > 0) {
                return i;
            }
            if (!"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2)) {
                if ("audio/gsm".equals(str2)) {
                    return i;
                }
                int i2 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
                Log.w(f7329a, "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + "]");
                return i2;
            }
        }
        return i;
    }

    public static a a(String str) {
        return new a(str, null, null, true, false, false);
    }

    private static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return new a(str, str2, codecCapabilities, false, false, false);
    }

    public static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new a(str, str2, codecCapabilities, false, z, z2);
    }

    private static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return af.f7632a >= 19 && codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_AdaptivePlayback);
    }

    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        return (d == -1.0d || d <= 0.0d) ? videoCapabilities.isSizeSupported(i, i2) : videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }

    private int b() {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        if (af.f7632a < 23 || (codecCapabilities = this.e) == null) {
            return -1;
        }
        return codecCapabilities.getMaxSupportedInstances();
    }

    private static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_AdaptivePlayback);
    }

    private void c(String str) {
        Log.d(f7329a, "NoSupport [" + str + "] [" + this.f7330c + ", " + this.d + "] [" + af.e + "]");
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return af.f7632a >= 21 && codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_TunneledPlayback);
    }

    private void d(String str) {
        Log.d(f7329a, "AssumedSupport [" + str + "] [" + this.f7330c + ", " + this.d + "] [" + af.e + "]");
    }

    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_TunneledPlayback);
    }

    private static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return af.f7632a >= 21 && codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_SecurePlayback);
    }

    private static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_SecurePlayback);
    }

    private static int g(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.getMaxSupportedInstances();
    }

    public final Point a(int i, int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        if (codecCapabilities == null) {
            c("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            c("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(af.a(i, widthAlignment) * widthAlignment, af.a(i2, heightAlignment) * heightAlignment);
    }

    public final boolean a(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        if (codecCapabilities == null) {
            c("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        } else {
            c("sampleRate.support, ".concat(String.valueOf(i)));
            return false;
        }
    }

    public final boolean a(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        if (codecCapabilities == null) {
            c("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            c("sizeAndRate.vCaps");
            return false;
        } else if (a(videoCapabilities, i, i2, d)) {
            return true;
        } else {
            if (i >= i2 || !a(videoCapabilities, i2, i, d)) {
                c("sizeAndRate.support, " + i + "x" + i2 + "x" + d);
                return false;
            }
            Log.d(f7329a, "AssumedSupport [" + ("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d) + "] [" + this.f7330c + ", " + this.d + "] [" + af.e + "]");
            return true;
        }
    }

    public final MediaCodecInfo.CodecProfileLevel[] a() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.e.profileLevels;
    }

    public final boolean b(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        if (codecCapabilities == null) {
            c("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("channelCount.aCaps");
            return false;
        }
        String str = this.f7330c;
        String str2 = this.d;
        int maxInputChannelCount = audioCapabilities.getMaxInputChannelCount();
        int i2 = maxInputChannelCount;
        if (maxInputChannelCount <= 1) {
            if (af.f7632a < 26 || maxInputChannelCount <= 0) {
                i2 = maxInputChannelCount;
                if (!"audio/mpeg".equals(str2)) {
                    i2 = maxInputChannelCount;
                    if (!"audio/3gpp".equals(str2)) {
                        i2 = maxInputChannelCount;
                        if (!"audio/amr-wb".equals(str2)) {
                            i2 = maxInputChannelCount;
                            if (!"audio/mp4a-latm".equals(str2)) {
                                i2 = maxInputChannelCount;
                                if (!"audio/vorbis".equals(str2)) {
                                    i2 = maxInputChannelCount;
                                    if (!"audio/opus".equals(str2)) {
                                        i2 = maxInputChannelCount;
                                        if (!"audio/raw".equals(str2)) {
                                            i2 = maxInputChannelCount;
                                            if (!"audio/flac".equals(str2)) {
                                                i2 = maxInputChannelCount;
                                                if (!"audio/g711-alaw".equals(str2)) {
                                                    i2 = maxInputChannelCount;
                                                    if (!"audio/g711-mlaw".equals(str2)) {
                                                        if ("audio/gsm".equals(str2)) {
                                                            i2 = maxInputChannelCount;
                                                        } else {
                                                            i2 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
                                                            Log.w(f7329a, "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i2 + "]");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                i2 = maxInputChannelCount;
            }
        }
        if (i2 < i) {
            c("channelCount.support, ".concat(String.valueOf(i)));
            return false;
        }
        return true;
    }

    public final boolean b(String str) {
        String c2;
        if (str == null || this.d == null || (c2 = o.c(str)) == null) {
            return true;
        }
        if (!this.d.equals(c2)) {
            c("codec.mime " + str + ", " + c2);
            return false;
        }
        Pair<Integer, Integer> a2 = d.a(str);
        if (a2 == null) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] a3 = a();
        int length = a3.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                c("codec.profileLevel, " + str + ", " + c2);
                return false;
            }
            MediaCodecInfo.CodecProfileLevel codecProfileLevel = a3[i2];
            if (codecProfileLevel.profile == a2.first.intValue() && codecProfileLevel.level >= a2.second.intValue()) {
                return true;
            }
            i = i2 + 1;
        }
    }
}
