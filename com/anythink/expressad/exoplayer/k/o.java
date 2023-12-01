package com.anythink.expressad.exoplayer.k;

import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/o.class */
public final class o {
    public static final String A = "audio/eac3";
    public static final String B = "audio/eac3-joc";
    public static final String C = "audio/true-hd";
    public static final String D = "audio/vnd.dts";
    public static final String E = "audio/vnd.dts.hd";
    public static final String F = "audio/vnd.dts.hd;profile=lbr";
    public static final String G = "audio/vorbis";
    public static final String H = "audio/opus";
    public static final String I = "audio/3gpp";
    public static final String J = "audio/amr-wb";
    public static final String K = "audio/flac";
    public static final String L = "audio/alac";
    public static final String M = "audio/gsm";
    public static final String N = "audio/x-unknown";
    public static final String O = "text/vtt";
    public static final String P = "text/x-ssa";
    public static final String Q = "application/mp4";
    public static final String R = "application/webm";
    public static final String S = "application/dash+xml";
    public static final String T = "application/x-mpegURL";
    public static final String U = "application/vnd.ms-sstr+xml";
    public static final String V = "application/id3";
    public static final String W = "application/cea-608";
    public static final String X = "application/cea-708";
    public static final String Y = "application/x-subrip";
    public static final String Z = "application/ttml+xml";

    /* renamed from: a  reason: collision with root package name */
    public static final String f4821a = "video";
    public static final String aa = "application/x-quicktime-tx3g";
    public static final String ab = "application/x-mp4-vtt";
    public static final String ac = "application/x-mp4-cea-608";
    public static final String ad = "application/x-rawcc";
    public static final String ae = "application/vobsub";
    public static final String af = "application/pgs";
    public static final String ag = "application/x-scte35";
    public static final String ah = "application/x-camera-motion";
    public static final String ai = "application/x-emsg";
    public static final String aj = "application/dvbsubs";
    public static final String ak = "application/x-exif";
    private static final ArrayList<a> al = new ArrayList<>();
    public static final String b = "audio";

    /* renamed from: c  reason: collision with root package name */
    public static final String f4822c = "text";
    public static final String d = "application";
    public static final String e = "video/mp4";
    public static final String f = "video/webm";
    public static final String g = "video/3gpp";
    public static final String h = "video/avc";
    public static final String i = "video/hevc";
    public static final String j = "video/x-vnd.on2.vp8";
    public static final String k = "video/x-vnd.on2.vp9";
    public static final String l = "video/mp4v-es";
    public static final String m = "video/mpeg";
    public static final String n = "video/mpeg2";
    public static final String o = "video/wvc1";
    public static final String p = "video/x-unknown";
    public static final String q = "audio/mp4";
    public static final String r = "audio/mp4a-latm";
    public static final String s = "audio/webm";
    public static final String t = "audio/mpeg";
    public static final String u = "audio/mpeg-L1";
    public static final String v = "audio/mpeg-L2";
    public static final String w = "audio/raw";
    public static final String x = "audio/g711-alaw";
    public static final String y = "audio/g711-mlaw";
    public static final String z = "audio/ac3";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/o$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f4823a;
        public final String b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4824c;

        public a(String str, String str2, int i) {
            this.f4823a = str;
            this.b = str2;
            this.f4824c = i;
        }
    }

    private o() {
    }

    public static String a(int i2) {
        if (i2 != 32) {
            if (i2 != 33) {
                if (i2 != 35) {
                    if (i2 != 64) {
                        if (i2 != 163) {
                            if (i2 != 177) {
                                if (i2 != 165) {
                                    if (i2 != 166) {
                                        switch (i2) {
                                            case 96:
                                            case 97:
                                            case 98:
                                            case 99:
                                            case 100:
                                            case 101:
                                                return "video/mpeg2";
                                            case 102:
                                            case 103:
                                            case 104:
                                                return "audio/mp4a-latm";
                                            case 105:
                                            case 107:
                                                return "audio/mpeg";
                                            case 106:
                                                return m;
                                            default:
                                                switch (i2) {
                                                    case 169:
                                                    case 172:
                                                        return D;
                                                    case 170:
                                                    case 171:
                                                        return E;
                                                    case 173:
                                                        return "audio/opus";
                                                    default:
                                                        return null;
                                                }
                                        }
                                    }
                                    return "audio/eac3";
                                }
                                return "audio/ac3";
                            }
                            return "video/x-vnd.on2.vp9";
                        }
                        return o;
                    }
                    return "audio/mp4a-latm";
                }
                return "video/hevc";
            }
            return "video/avc";
        }
        return "video/mp4v-es";
    }

    private static void a(String str, String str2, int i2) {
        a aVar = new a(str, str2, i2);
        int size = al.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                break;
            } else if (str.equals(al.get(i4).f4823a)) {
                al.remove(i4);
                break;
            } else {
                i3 = i4 + 1;
            }
        }
        al.add(aVar);
    }

    public static boolean a(String str) {
        return "audio".equals(k(str));
    }

    public static boolean b(String str) {
        return "video".equals(k(str));
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("avc1") || trim.startsWith("avc3")) {
            return "video/avc";
        }
        if (trim.startsWith("hev1") || trim.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (trim.startsWith("vp9") || trim.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (trim.startsWith("vp8") || trim.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (trim.startsWith("mp4a")) {
            String str2 = null;
            if (trim.startsWith("mp4a.")) {
                String substring = trim.substring(5);
                str2 = null;
                if (substring.length() >= 2) {
                    try {
                        str2 = a(Integer.parseInt(af.e(substring.substring(0, 2)), 16));
                    } catch (NumberFormatException e2) {
                        str2 = null;
                    }
                }
            }
            return str2 == null ? "audio/mp4a-latm" : str2;
        } else if (trim.startsWith("ac-3") || trim.startsWith("dac3")) {
            return "audio/ac3";
        } else {
            if (trim.startsWith("ec-3") || trim.startsWith("dec3")) {
                return "audio/eac3";
            }
            if (trim.startsWith("ec+3")) {
                return B;
            }
            if (trim.startsWith("dtsc") || trim.startsWith("dtse")) {
                return D;
            }
            if (trim.startsWith("dtsh") || trim.startsWith("dtsl")) {
                return E;
            }
            if (trim.startsWith("opus")) {
                return "audio/opus";
            }
            if (trim.startsWith("vorbis")) {
                return "audio/vorbis";
            }
            int size = al.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = al.get(i2);
                if (trim.startsWith(aVar.b)) {
                    return aVar.f4823a;
                }
            }
            return null;
        }
    }

    public static int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (a(str)) {
            return 1;
        }
        if (b(str)) {
            return 2;
        }
        if ("text".equals(k(str)) || W.equals(str) || X.equals(str) || ac.equals(str) || "application/x-subrip".equals(str) || Z.equals(str) || aa.equals(str) || ab.equals(str) || ad.equals(str) || ae.equals(str) || af.equals(str) || aj.equals(str)) {
            return 3;
        }
        if (V.equals(str) || ai.equals(str) || ag.equals(str) || ah.equals(str)) {
            return 4;
        }
        int size = al.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return -1;
            }
            a aVar = al.get(i3);
            if (str.equals(aVar.f4823a)) {
                return aVar.f4824c;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int e(String str) {
        boolean z2;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(B)) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case -1095064472:
                if (str.equals(D)) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    z2 = false;
                    break;
                }
                z2 = true;
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case 1505942594:
                if (str.equals(E)) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case 1556697186:
                if (str.equals(C)) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            default:
                z2 = true;
                break;
        }
        if (z2) {
            if (z2 || z2) {
                return 6;
            }
            if (!z2) {
                if (!z2) {
                    return !z2 ? 0 : 14;
                }
                return 8;
            }
            return 7;
        }
        return 5;
    }

    public static int f(String str) {
        return d(c(str));
    }

    private static boolean g(String str) {
        return "text".equals(k(str));
    }

    private static boolean h(String str) {
        return "application".equals(k(str));
    }

    private static String i(String str) {
        if (str == null) {
            return null;
        }
        String[] a2 = af.a(str, ",");
        int length = a2.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return null;
            }
            String c2 = c(a2[i3]);
            if (c2 != null && b(c2)) {
                return c2;
            }
            i2 = i3 + 1;
        }
    }

    private static String j(String str) {
        if (str == null) {
            return null;
        }
        String[] a2 = af.a(str, ",");
        int length = a2.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return null;
            }
            String c2 = c(a2[i3]);
            if (c2 != null && a(c2)) {
                return c2;
            }
            i2 = i3 + 1;
        }
    }

    private static String k(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        throw new IllegalArgumentException("Invalid mime type: ".concat(String.valueOf(str)));
    }

    private static String l(String str) {
        int size = al.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return null;
            }
            a aVar = al.get(i3);
            if (str.startsWith(aVar.b)) {
                return aVar.f4823a;
            }
            i2 = i3 + 1;
        }
    }

    private static int m(String str) {
        int size = al.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return -1;
            }
            a aVar = al.get(i3);
            if (str.equals(aVar.f4823a)) {
                return aVar.f4824c;
            }
            i2 = i3 + 1;
        }
    }
}
