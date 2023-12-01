package com.tencent.thumbplayer.g.h;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import com.igexin.push.core.g;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.g.b.e;
import com.tencent.thumbplayer.g.b.f;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/h/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f39360a = {"csd-0", "csd-1", "csd-2"};
    private static boolean b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f39361c;
    private static final Set<String> d;

    static {
        HashSet hashSet = new HashSet();
        d = hashSet;
        hashSet.add("1601");
        d.add("1713");
        d.add("1714");
        d.add("A10-70F");
        d.add("A10-70L");
        d.add("A1601");
        d.add("A2016a40");
        d.add("A7000-a");
        d.add("A7000plus");
        d.add("A7010a48");
        d.add("A7020a48");
        d.add("AquaPowerM");
        d.add("ASUS_X00AD_2");
        d.add("Aura_Note_2");
        d.add("BLACK-1X");
        d.add("BRAVIA_ATV2");
        d.add("BRAVIA_ATV3_4K");
        d.add("C1");
        d.add("ComioS1");
        d.add("CP8676_I02");
        d.add("CPH1609");
        d.add("CPY83_I00");
        d.add("cv1");
        d.add("cv3");
        d.add("deb");
        d.add("E5643");
        d.add("ELUGA_A3_Pro");
        d.add("ELUGA_Note");
        d.add("ELUGA_Prim");
        d.add("ELUGA_Ray_X");
        d.add("EverStar_S");
        d.add("F3111");
        d.add("F3113");
        d.add("F3116");
        d.add("F3211");
        d.add("F3213");
        d.add("F3215");
        d.add("F3311");
        d.add("flo");
        d.add("fugu");
        d.add("GiONEE_CBL7513");
        d.add("GiONEE_GBL7319");
        d.add("GIONEE_GBL7360");
        d.add("GIONEE_SWW1609");
        d.add("GIONEE_SWW1627");
        d.add("GIONEE_SWW1631");
        d.add("GIONEE_WBL5708");
        d.add("GIONEE_WBL7365");
        d.add("GIONEE_WBL7519");
        d.add("griffin");
        d.add("htc_e56ml_dtul");
        d.add("hwALE-H");
        d.add("HWBLN-H");
        d.add("HWCAM-H");
        d.add("HWVNS-H");
        d.add("HWWAS-H");
        d.add("i9031");
        d.add("iball8735_9806");
        d.add("Infinix-X572");
        d.add("iris60");
        d.add("itel_S41");
        d.add("j2xlteins");
        d.add("JGZ");
        d.add("K50a40");
        d.add("kate");
        d.add("l5460");
        d.add("le_x6");
        d.add("LS-5017");
        d.add("M5c");
        d.add("manning");
        d.add("marino_f");
        d.add("MEIZU_M5");
        d.add("mh");
        d.add("mido");
        d.add("c");
        d.add("namath");
        d.add("nicklaus_f");
        d.add("NX541J");
        d.add("NX573J");
        d.add("OnePlus5T");
        d.add("p212");
        d.add("P681");
        d.add("P85");
        d.add("panell_d");
        d.add("panell_dl");
        d.add("panell_ds");
        d.add("panell_dt");
        d.add("PB2-670M");
        d.add("PGN528");
        d.add("PGN610");
        d.add("PGN611");
        d.add("Phantom6");
        d.add("Pixi4-7_3G");
        d.add("Pixi5-10_4G");
        d.add("PLE");
        d.add("PRO7S");
        d.add("Q350");
        d.add("Q4260");
        d.add("Q427");
        d.add("Q4310");
        d.add("Q5");
        d.add("QM16XE_U");
        d.add("QX1");
        d.add("santoni");
        d.add("Slate_Pro");
        d.add("SVP-DTV15");
        d.add("s905x018");
        d.add("taido_row");
        d.add("TB3-730F");
        d.add("TB3-730X");
        d.add("TB3-850F");
        d.add("TB3-850M");
        d.add("tcl_eu");
        d.add(g.e);
        d.add("V23GB");
        d.add("V5");
        d.add("vernee_M5");
        d.add("watson");
        d.add("whyred");
        d.add("woods_f");
        d.add("woods_fn");
        d.add("X3_HK");
        d.add("XE2X");
        d.add("XT1663");
        d.add("Z12_PRO");
        d.add("Z80");
    }

    public static int a(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static int a(f fVar, e eVar) {
        if (eVar.i != -1) {
            int i = 0;
            for (int i2 = 0; i2 < eVar.f39326a.size(); i2++) {
                i += eVar.f39326a.get(i2).length;
            }
            return eVar.i + i;
        }
        return a(eVar.j, eVar.b, eVar.f39327c, fVar.d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str, int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    z2 = false;
                    break;
                }
                z2 = true;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            default:
                z2 = true;
                break;
        }
        if (z2 && !z2) {
            if (z2) {
                if ("BRAVIA 4K 2015".equals(TPSystemInfo.getDeviceName())) {
                    return -1;
                }
                if ("Amazon".equals(TPSystemInfo.getDeviceManufacturer())) {
                    if ("KFSOWI".equals(TPSystemInfo.getDeviceName())) {
                        return -1;
                    }
                    if ("AFTS".equals(TPSystemInfo.getDeviceName()) && z) {
                        return -1;
                    }
                }
                i3 = a(i, 16) * a(i2, 16) * 16 * 16;
                i4 = i3;
                i5 = 2;
                return (i4 * 3) / (i5 * 2);
            } else if (!z2) {
                if (z2 || z2) {
                    i4 = i * i2;
                    i5 = 4;
                    return (i4 * 3) / (i5 * 2);
                }
                return -1;
            }
        }
        i3 = i * i2;
        i4 = i3;
        i5 = 2;
        return (i4 * 3) / (i5 * 2);
    }

    public static String a(MediaCodec mediaCodec) {
        return Build.VERSION.SDK_INT >= 18 ? mediaCodec.getName() : "unknow-low-api-18";
    }

    public static ArrayList<byte[]> a(MediaFormat mediaFormat) {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr = f39360a;
            if (i2 >= strArr.length) {
                return arrayList;
            }
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(strArr[i2]);
            if (byteBuffer != null) {
                arrayList.add(byteBuffer.array());
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d6, code lost:
        if (r4 != true) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009d A[Catch: all -> 0x00c5, TryCatch #0 {all -> 0x00c5, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0015, B:10:0x001d, B:12:0x0029, B:12:0x0029, B:15:0x0031, B:17:0x003f, B:18:0x0043, B:18:0x0043, B:21:0x0049, B:29:0x0066, B:33:0x0075, B:37:0x0084, B:42:0x0097, B:42:0x0097, B:44:0x009d, B:46:0x00bb, B:41:0x0093, B:48:0x00c0, B:49:0x00c1), top: B:63:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a() {
        /*
            java.lang.Class<com.tencent.thumbplayer.g.h.c> r0 = com.tencent.thumbplayer.g.h.c.class
            monitor-enter(r0)
            boolean r0 = com.tencent.thumbplayer.g.h.c.b     // Catch: java.lang.Throwable -> Lc5
            if (r0 != 0) goto Lbe
            java.lang.String r0 = "dangal"
            java.lang.String r1 = android.os.Build.DEVICE     // Catch: java.lang.Throwable -> Lc5
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> Lc5
            if (r0 != 0) goto L93
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lc5
            r1 = 27
            if (r0 > r1) goto L29
            java.lang.String r0 = "HWEML"
            java.lang.String r1 = android.os.Build.DEVICE     // Catch: java.lang.Throwable -> Lc5
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> Lc5
            if (r0 != 0) goto L93
        L29:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lc5 java.lang.Throwable -> Lc5
            r1 = 27
            if (r0 >= r1) goto L97
            java.util.Set<java.lang.String> r0 = com.tencent.thumbplayer.g.h.c.d     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r1 = android.os.Build.DEVICE     // Catch: java.lang.Throwable -> Lc5
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> Lc5
            if (r0 == 0) goto L43
            r0 = 1
            com.tencent.thumbplayer.g.h.c.f39361c = r0     // Catch: java.lang.Throwable -> Lc5
        L43:
            java.lang.String r0 = com.tencent.thumbplayer.core.common.TPSystemInfo.getDeviceName()     // Catch: java.lang.Throwable -> Lc5 java.lang.Throwable -> Lc5
            r6 = r0
            r0 = -1
            r4 = r0
            r0 = r6
            int r0 = r0.hashCode()     // Catch: java.lang.Throwable -> Lc5
            r5 = r0
            r0 = r5
            r1 = -594534941(0xffffffffdc901de3, float:-3.2452206E17)
            if (r0 == r1) goto L84
            r0 = r5
            r1 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r0 == r1) goto L75
            r0 = r5
            r1 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r0 == r1) goto L66
            goto Lcb
        L66:
            r0 = r6
            java.lang.String r1 = "AFTN"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> Lc5
            if (r0 == 0) goto Lcb
            r0 = 1
            r4 = r0
            goto Lcb
        L75:
            r0 = r6
            java.lang.String r1 = "AFTA"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> Lc5
            if (r0 == 0) goto Lcb
            r0 = 0
            r4 = r0
            goto Lcb
        L84:
            r0 = r6
            java.lang.String r1 = "JSN-L21"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> Lc5
            if (r0 == 0) goto Lcb
            r0 = 2
            r4 = r0
            goto Lcb
        L93:
            r0 = 1
            com.tencent.thumbplayer.g.h.c.f39361c = r0     // Catch: java.lang.Throwable -> Lc5
        L97:
            boolean r0 = com.tencent.thumbplayer.g.h.b.a()     // Catch: java.lang.Throwable -> Lc5 java.lang.Throwable -> Lc5
            if (r0 == 0) goto Lba
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc5
            r1 = r0
            java.lang.String r2 = "deviceNeedsSetOutputSurfaceWorkaround:"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lc5
            r6 = r0
            r0 = r6
            boolean r1 = com.tencent.thumbplayer.g.h.c.f39361c     // Catch: java.lang.Throwable -> Lc5
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r0 = "TUtils"
            r1 = r6
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc5
            com.tencent.thumbplayer.g.h.b.b(r0, r1)     // Catch: java.lang.Throwable -> Lc5
        Lba:
            r0 = 1
            com.tencent.thumbplayer.g.h.c.b = r0     // Catch: java.lang.Throwable -> Lc5
        Lbe:
            java.lang.Class<com.tencent.thumbplayer.g.h.c> r0 = com.tencent.thumbplayer.g.h.c.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc5
            boolean r0 = com.tencent.thumbplayer.g.h.c.f39361c     // Catch: java.lang.Throwable -> Lc5
            return r0
        Lc5:
            r6 = move-exception
            java.lang.Class<com.tencent.thumbplayer.g.h.c> r0 = com.tencent.thumbplayer.g.h.c.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc5
            r0 = r6
            throw r0
        Lcb:
            r0 = r4
            if (r0 == 0) goto L93
            r0 = r4
            r1 = 1
            if (r0 == r1) goto L93
            r0 = r4
            r1 = 2
            if (r0 == r1) goto L93
            goto L97
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.g.h.c.a():boolean");
    }

    public static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Build.VERSION.SDK_INT >= 19 && c(codecCapabilities);
    }

    public static boolean a(String str) {
        return str.contains("video");
    }

    public static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Build.VERSION.SDK_INT >= 21 && d(codecCapabilities);
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_AdaptivePlayback);
    }

    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_SecurePlayback);
    }
}
