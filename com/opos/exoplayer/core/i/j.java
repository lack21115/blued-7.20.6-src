package com.opos.exoplayer.core.i;

import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/j.class */
public final class j {
    public static String a(int i) {
        if (i != 32) {
            if (i != 33) {
                if (i != 35) {
                    if (i != 64) {
                        if (i != 107) {
                            if (i == 96 || i == 97) {
                                return "video/mpeg2";
                            }
                            if (i != 165) {
                                if (i != 166) {
                                    switch (i) {
                                        case 102:
                                        case 103:
                                        case 104:
                                            return "audio/mp4a-latm";
                                        case 105:
                                            return "audio/mpeg";
                                        default:
                                            switch (i) {
                                                case 169:
                                                case 172:
                                                    return com.anythink.expressad.exoplayer.k.o.D;
                                                case 170:
                                                case 171:
                                                    return com.anythink.expressad.exoplayer.k.o.E;
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
                        return "audio/mpeg";
                    }
                    return "audio/mp4a-latm";
                }
                return "video/hevc";
            }
            return "video/avc";
        }
        return "video/mp4v-es";
    }

    public static boolean a(String str) {
        return "audio".equals(g(str));
    }

    public static boolean b(String str) {
        return "video".equals(g(str));
    }

    public static boolean c(String str) {
        return "text".equals(g(str));
    }

    public static String d(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("avc1") || trim.startsWith("avc3")) {
            str2 = "video/avc";
        } else if (trim.startsWith("hev1") || trim.startsWith("hvc1")) {
            return "video/hevc";
        } else {
            if (trim.startsWith("vp9") || trim.startsWith("vp09")) {
                return "video/x-vnd.on2.vp9";
            }
            if (trim.startsWith("vp8") || trim.startsWith("vp08")) {
                return "video/x-vnd.on2.vp8";
            }
            if (trim.startsWith("mp4a")) {
                String str3 = null;
                if (trim.startsWith("mp4a.")) {
                    String substring = trim.substring(5);
                    str3 = null;
                    if (substring.length() >= 2) {
                        try {
                            str3 = a(Integer.parseInt(u.e(substring.substring(0, 2)), 16));
                        } catch (NumberFormatException e) {
                            str3 = null;
                        }
                    }
                }
                str2 = str3;
                if (str3 == null) {
                    return "audio/mp4a-latm";
                }
            } else if (trim.startsWith("ac-3") || trim.startsWith("dac3")) {
                return "audio/ac3";
            } else {
                if (trim.startsWith("ec-3") || trim.startsWith("dec3")) {
                    return "audio/eac3";
                }
                if (trim.startsWith("ec+3")) {
                    return com.anythink.expressad.exoplayer.k.o.B;
                }
                if (trim.startsWith("dtsc") || trim.startsWith("dtse")) {
                    return com.anythink.expressad.exoplayer.k.o.D;
                }
                if (trim.startsWith("dtsh") || trim.startsWith("dtsl")) {
                    return com.anythink.expressad.exoplayer.k.o.E;
                }
                if (trim.startsWith("opus")) {
                    return "audio/opus";
                }
                str2 = null;
                if (trim.startsWith("vorbis")) {
                    return "audio/vorbis";
                }
            }
        }
        return str2;
    }

    public static int e(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (a(str)) {
            return 1;
        }
        if (b(str)) {
            return 2;
        }
        if (c(str) || com.anythink.expressad.exoplayer.k.o.W.equals(str) || com.anythink.expressad.exoplayer.k.o.X.equals(str) || com.anythink.expressad.exoplayer.k.o.ac.equals(str) || "application/x-subrip".equals(str) || com.anythink.expressad.exoplayer.k.o.Z.equals(str) || com.anythink.expressad.exoplayer.k.o.aa.equals(str) || com.anythink.expressad.exoplayer.k.o.ab.equals(str) || com.anythink.expressad.exoplayer.k.o.ad.equals(str) || com.anythink.expressad.exoplayer.k.o.ae.equals(str) || com.anythink.expressad.exoplayer.k.o.af.equals(str) || com.anythink.expressad.exoplayer.k.o.aj.equals(str)) {
            return 3;
        }
        return (com.anythink.expressad.exoplayer.k.o.V.equals(str) || com.anythink.expressad.exoplayer.k.o.ai.equals(str) || com.anythink.expressad.exoplayer.k.o.ag.equals(str) || com.anythink.expressad.exoplayer.k.o.ah.equals(str)) ? 4 : -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int f(String str) {
        boolean z;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(com.anythink.expressad.exoplayer.k.o.B)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1095064472:
                if (str.equals(com.anythink.expressad.exoplayer.k.o.D)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1505942594:
                if (str.equals(com.anythink.expressad.exoplayer.k.o.E)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1556697186:
                if (str.equals(com.anythink.expressad.exoplayer.k.o.C)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (z) {
            if (z || z) {
                return 6;
            }
            if (!z) {
                if (!z) {
                    return !z ? 0 : 14;
                }
                return 8;
            }
            return 7;
        }
        return 5;
    }

    private static String g(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        throw new IllegalArgumentException("Invalid mime type: " + str);
    }
}
