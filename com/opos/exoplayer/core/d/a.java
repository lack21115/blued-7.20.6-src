package com.opos.exoplayer.core.d;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.opos.exoplayer.core.i.j;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/d/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f25256a;
    public final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f25257c;
    public final boolean d;
    private final String e;
    private final MediaCodecInfo.CodecCapabilities f;

    private a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        this.f25256a = (String) com.opos.exoplayer.core.i.a.a(str);
        this.e = str2;
        this.f = codecCapabilities;
        this.b = (z || codecCapabilities == null || !a(codecCapabilities)) ? false : true;
        this.f25257c = codecCapabilities != null && c(codecCapabilities);
        this.d = z2 ? true : codecCapabilities != null && e(codecCapabilities);
    }

    private static int a(String str, String str2, int i) {
        int i2 = i;
        if (i <= 1) {
            if (u.f25510a >= 26 && i > 0) {
                return i;
            }
            i2 = i;
            if (!"audio/mpeg".equals(str2)) {
                i2 = i;
                if (!"audio/3gpp".equals(str2)) {
                    i2 = i;
                    if (!"audio/amr-wb".equals(str2)) {
                        i2 = i;
                        if (!"audio/mp4a-latm".equals(str2)) {
                            i2 = i;
                            if (!"audio/vorbis".equals(str2)) {
                                i2 = i;
                                if (!"audio/opus".equals(str2)) {
                                    i2 = i;
                                    if (!"audio/raw".equals(str2)) {
                                        i2 = i;
                                        if (!"audio/flac".equals(str2)) {
                                            i2 = i;
                                            if (!"audio/g711-alaw".equals(str2)) {
                                                i2 = i;
                                                if (!"audio/g711-mlaw".equals(str2)) {
                                                    i2 = i;
                                                    if (!"audio/gsm".equals(str2)) {
                                                        i2 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
                                                        com.opos.cmn.an.f.a.c(com.anythink.expressad.exoplayer.f.a.f7329a, "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + "]");
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
        }
        return i2;
    }

    public static a a(String str) {
        return new a(str, null, null, false, false);
    }

    public static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new a(str, str2, codecCapabilities, z, z2);
    }

    private static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u.f25510a >= 19 && b(codecCapabilities);
    }

    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        return (d == -1.0d || d <= 0.0d) ? videoCapabilities.isSizeSupported(i, i2) : videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }

    private static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_AdaptivePlayback);
    }

    private void c(String str) {
        com.opos.cmn.an.f.a.b(com.anythink.expressad.exoplayer.f.a.f7329a, "NoSupport [" + str + "] [" + this.f25256a + ", " + this.e + "] [" + u.e + "]");
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u.f25510a >= 21 && d(codecCapabilities);
    }

    private void d(String str) {
        com.opos.cmn.an.f.a.b(com.anythink.expressad.exoplayer.f.a.f7329a, "AssumedSupport [" + str + "] [" + this.f25256a + ", " + this.e + "] [" + u.e + "]");
    }

    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_TunneledPlayback);
    }

    private static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u.f25510a >= 21 && f(codecCapabilities);
    }

    private static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_SecurePlayback);
    }

    public Point a(int i, int i2) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f;
        if (codecCapabilities == null) {
            str = "align.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities != null) {
                int widthAlignment = videoCapabilities.getWidthAlignment();
                int heightAlignment = videoCapabilities.getHeightAlignment();
                return new Point(widthAlignment * u.a(i, widthAlignment), heightAlignment * u.a(i2, heightAlignment));
            }
            str = "align.vCaps";
        }
        c(str);
        return null;
    }

    public boolean a(int i) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f;
        if (codecCapabilities == null) {
            str = "sampleRate.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "sampleRate.aCaps";
            } else if (audioCapabilities.isSampleRateSupported(i)) {
                return true;
            } else {
                str = "sampleRate.support, " + i;
            }
        }
        c(str);
        return false;
    }

    public boolean a(int i, int i2, double d) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f;
        if (codecCapabilities == null) {
            str = "sizeAndRate.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                str = "sizeAndRate.vCaps";
            } else if (a(videoCapabilities, i, i2, d)) {
                return true;
            } else {
                if (i < i2 && a(videoCapabilities, i2, i, d)) {
                    d("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d);
                    return true;
                }
                str = "sizeAndRate.support, " + i + "x" + i2 + "x" + d;
            }
        }
        c(str);
        return false;
    }

    public MediaCodecInfo.CodecProfileLevel[] a() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.f.profileLevels;
    }

    public boolean b(int i) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f;
        if (codecCapabilities == null) {
            str = "channelCount.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "channelCount.aCaps";
            } else if (a(this.f25256a, this.e, audioCapabilities.getMaxInputChannelCount()) >= i) {
                return true;
            } else {
                str = "channelCount.support, " + i;
            }
        }
        c(str);
        return false;
    }

    public boolean b(String str) {
        String d;
        StringBuilder sb;
        String str2;
        if (str == null || this.e == null || (d = j.d(str)) == null) {
            return true;
        }
        if (this.e.equals(d)) {
            Pair<Integer, Integer> a2 = d.a(str);
            if (a2 != null) {
                MediaCodecInfo.CodecProfileLevel[] a3 = a();
                int length = a3.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        sb = new StringBuilder();
                        str2 = "codec.profileLevel, ";
                        break;
                    }
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = a3[i2];
                    if (codecProfileLevel.profile == a2.first.intValue() && codecProfileLevel.level >= a2.second.intValue()) {
                        return true;
                    }
                    i = i2 + 1;
                }
            } else {
                return true;
            }
        } else {
            sb = new StringBuilder();
            str2 = "codec.mime ";
        }
        sb.append(str2);
        sb.append(str);
        sb.append(", ");
        sb.append(d);
        c(sb.toString());
        return false;
    }
}
