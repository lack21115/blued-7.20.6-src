package com.anythink.expressad.exoplayer.f;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/f/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4495a = "MediaCodecUtil";

    /* renamed from: c  reason: collision with root package name */
    private static final String f4496c = "OMX.MTK.AUDIO.DECODER.RAW";
    private static final SparseIntArray g;
    private static final SparseIntArray h;
    private static final String i = "avc1";
    private static final String j = "avc2";
    private static final Map<String, Integer> k;
    private static final String l = "hev1";
    private static final String m = "hvc1";
    private static final String b = "OMX.google.raw.decoder";
    private static final com.anythink.expressad.exoplayer.f.a d = com.anythink.expressad.exoplayer.f.a.a(b);
    private static final Pattern e = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<a, List<com.anythink.expressad.exoplayer.f.a>> f = new HashMap<>();
    private static int n = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/f/d$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f4497a;
        public final boolean b;

        public a(String str, boolean z) {
            this.f4497a = str;
            this.b = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.f4497a, aVar.f4497a) && this.b == aVar.b;
        }

        public final int hashCode() {
            String str = this.f4497a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.b ? 1231 : 1237);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/f/d$b.class */
    public static final class b extends Exception {
        private b(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }

        /* synthetic */ b(Throwable th, byte b) {
            this(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/f/d$c.class */
    public interface c {
        int a();

        MediaCodecInfo a(int i);

        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.exoplayer.f.d$d  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/f/d$d.class */
    public static final class C0057d implements c {
        private C0057d() {
        }

        /* synthetic */ C0057d(byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final int a() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final MediaCodecInfo a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final boolean b() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/f/d$e.class */
    public static final class e implements c {

        /* renamed from: a  reason: collision with root package name */
        private final int f4498a;
        private MediaCodecInfo[] b;

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public e(boolean z) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        private void c() {
            if (this.b == null) {
                this.b = new MediaCodecList(this.f4498a).getCodecInfos();
            }
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final int a() {
            c();
            return this.b.length;
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final MediaCodecInfo a(int i) {
            c();
            return this.b[i];
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_SecurePlayback);
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final boolean b() {
            return true;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        g = sparseIntArray;
        sparseIntArray.put(66, 1);
        g.put(77, 2);
        g.put(88, 4);
        g.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        h = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        h.put(11, 4);
        h.put(12, 8);
        h.put(13, 16);
        h.put(20, 32);
        h.put(21, 64);
        h.put(22, 128);
        h.put(30, 256);
        h.put(31, 512);
        h.put(32, 1024);
        h.put(40, 2048);
        h.put(41, 4096);
        h.put(42, 8192);
        h.put(50, 16384);
        h.put(51, 32768);
        h.put(52, 65536);
        HashMap hashMap = new HashMap();
        k = hashMap;
        hashMap.put("L30", 1);
        k.put("L60", 4);
        k.put("L63", 16);
        k.put("L90", 64);
        k.put("L93", 256);
        k.put("L120", 1024);
        k.put("L123", 4096);
        k.put("L150", 16384);
        k.put("L153", 65536);
        k.put("L156", 262144);
        k.put("L180", 1048576);
        k.put("L183", 4194304);
        k.put("L186", 16777216);
        k.put("H30", 2);
        k.put("H60", 8);
        k.put("H63", 32);
        k.put("H90", 128);
        k.put("H93", 512);
        k.put("H120", 2048);
        k.put("H123", 8192);
        k.put("H150", 32768);
        k.put("H153", 131072);
        k.put("H156", 524288);
        k.put("H180", 2097152);
        k.put("H183", 8388608);
        k.put("H186", 33554432);
    }

    private d() {
    }

    private static int a(int i2) {
        if (i2 == 1 || i2 == 2) {
            return 25344;
        }
        switch (i2) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0061, code lost:
        if (r0.equals(com.anythink.expressad.exoplayer.f.d.l) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> a(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.f.d.a(java.lang.String):android.util.Pair");
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        int i2;
        if (strArr.length < 4) {
            Log.w(f4495a, "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        Matcher matcher = e.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w(f4495a, "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        String group = matcher.group(1);
        if ("1".equals(group)) {
            i2 = 1;
        } else if (!"2".equals(group)) {
            Log.w(f4495a, "Unknown HEVC profile string: ".concat(String.valueOf(group)));
            return null;
        } else {
            i2 = 2;
        }
        Integer num = k.get(strArr[3]);
        if (num == null) {
            Log.w(f4495a, "Unknown HEVC level string: " + matcher.group(1));
            return null;
        }
        return new Pair<>(Integer.valueOf(i2), num);
    }

    public static com.anythink.expressad.exoplayer.f.a a() {
        return d;
    }

    public static com.anythink.expressad.exoplayer.f.a a(String str, boolean z) {
        List<com.anythink.expressad.exoplayer.f.a> c2 = c(str, z);
        if (c2.isEmpty()) {
            return null;
        }
        return c2.get(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:160:0x0379, code lost:
        if ("Nexus 10".equals(com.anythink.expressad.exoplayer.k.af.d) == false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0497, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0315 A[Catch: Exception -> 0x04a6, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x04a6, blocks: (B:2:0x0000, B:6:0x0027, B:10:0x0049, B:13:0x0057, B:15:0x005f, B:17:0x006a, B:19:0x0075, B:21:0x0080, B:23:0x008b, B:25:0x0096, B:28:0x00a4, B:30:0x00ac, B:33:0x00ba, B:35:0x00c2, B:37:0x00cd, B:39:0x00d9, B:41:0x00e5, B:44:0x00f4, B:46:0x00fc, B:48:0x0107, B:50:0x0113, B:52:0x011f, B:54:0x012b, B:56:0x0137, B:58:0x0143, B:60:0x014f, B:62:0x015b, B:64:0x0167, B:66:0x0173, B:68:0x017f, B:70:0x018b, B:73:0x019a, B:75:0x01a2, B:77:0x01ad, B:79:0x01b9, B:81:0x01c5, B:83:0x01d1, B:86:0x01e0, B:89:0x01ec, B:91:0x01f7, B:94:0x0205, B:96:0x020e, B:98:0x021a, B:100:0x0226, B:102:0x0232, B:104:0x023e, B:106:0x024a, B:108:0x0256, B:110:0x0262, B:113:0x0271, B:116:0x027d, B:118:0x0288, B:120:0x0294, B:122:0x02a0, B:124:0x02ac, B:126:0x02b8, B:128:0x02c4, B:131:0x02d3, B:133:0x02db, B:135:0x02e7, B:138:0x02f5, B:140:0x02ff, B:145:0x0315, B:150:0x0335, B:192:0x0419, B:195:0x0425, B:197:0x042d, B:198:0x0458, B:199:0x048d), top: B:222:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x039a A[Catch: Exception -> 0x04c6, TRY_ENTER, TryCatch #2 {Exception -> 0x04c6, blocks: (B:157:0x0364, B:159:0x0370, B:162:0x037f, B:164:0x0387, B:169:0x039a, B:177:0x03b5, B:174:0x03ab, B:182:0x03d4), top: B:220:0x0364 }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0497 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList<com.anythink.expressad.exoplayer.f.a> a(com.anythink.expressad.exoplayer.f.d.a r7, com.anythink.expressad.exoplayer.f.d.c r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 1236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.f.d.a(com.anythink.expressad.exoplayer.f.d$a, com.anythink.expressad.exoplayer.f.d$c, java.lang.String):java.util.ArrayList");
    }

    private static void a(List<com.anythink.expressad.exoplayer.f.a> list) {
        if (af.f4793a < 26) {
            if (list.size() <= 1 || !f4496c.equals(list.get(0).f4491c)) {
                return;
            }
            for (int i2 = 1; i2 < list.size(); i2++) {
                com.anythink.expressad.exoplayer.f.a aVar = list.get(i2);
                if (b.equals(aVar.f4491c)) {
                    list.remove(i2);
                    list.add(0, aVar);
                    return;
                }
            }
        }
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder()) {
            return false;
        }
        if (z || !str.endsWith(".secure")) {
            if (af.f4793a >= 21 || !("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
                if (af.f4793a >= 18 || !"OMX.SEC.MP3.Decoder".equals(str)) {
                    if (af.f4793a < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
                        if ("a70".equals(af.b)) {
                            return false;
                        }
                        if ("Xiaomi".equals(af.f4794c) && af.b.startsWith("HM")) {
                            return false;
                        }
                    }
                    if (af.f4793a == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(af.b) || "protou".equals(af.b) || "ville".equals(af.b) || "villeplus".equals(af.b) || "villec2".equals(af.b) || af.b.startsWith("gee") || "C6602".equals(af.b) || "C6603".equals(af.b) || "C6606".equals(af.b) || "C6616".equals(af.b) || "L36h".equals(af.b) || "SO-02E".equals(af.b))) {
                        return false;
                    }
                    if (af.f4793a == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(af.b) || "C1505".equals(af.b) || "C1604".equals(af.b) || "C1605".equals(af.b))) {
                        return false;
                    }
                    if (af.f4793a >= 24 || !(("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(af.f4794c) && (af.b.startsWith("zeroflte") || af.b.startsWith("zerolte") || af.b.startsWith("zenlte") || "SC-05G".equals(af.b) || "marinelteatt".equals(af.b) || "404SC".equals(af.b) || "SC-04G".equals(af.b) || "SCV31".equals(af.b)))) {
                        if (af.f4793a <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(af.f4794c) && (af.b.startsWith(com.anythink.expressad.foundation.g.a.O) || af.b.startsWith("serrano") || af.b.startsWith("jflte") || af.b.startsWith("santos") || af.b.startsWith("t0"))) {
                            return false;
                        }
                        if (af.f4793a <= 19 && af.b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
                            return false;
                        }
                        return (o.B.equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static int b() {
        if (n == -1) {
            int i2 = 0;
            com.anythink.expressad.exoplayer.f.a a2 = a("video/avc", false);
            if (a2 != null) {
                int i3 = 0;
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : a2.a()) {
                    int i4 = codecProfileLevel.level;
                    int i5 = 9437184;
                    if (i4 == 1 || i4 == 2) {
                        i5 = 25344;
                    } else {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i5 = 101376;
                                continue;
                            case 64:
                                i5 = 202752;
                                continue;
                            case 128:
                            case 256:
                                i5 = 414720;
                                continue;
                            case 512:
                                i5 = 921600;
                                continue;
                            case 1024:
                                i5 = 1310720;
                                continue;
                            case 2048:
                            case 4096:
                                i5 = 2097152;
                                continue;
                            case 8192:
                                i5 = 2228224;
                                continue;
                            case 16384:
                                i5 = 5652480;
                                continue;
                            case 32768:
                            case 65536:
                                break;
                            default:
                                i5 = -1;
                                continue;
                        }
                    }
                    i3 = Math.max(i5, i3);
                }
                i2 = Math.max(i3, af.f4793a >= 21 ? 345600 : 172800);
            }
            n = i2;
        }
        return n;
    }

    private static Pair<Integer, Integer> b(String str, String[] strArr) {
        Integer valueOf;
        Integer valueOf2;
        if (strArr.length < 2) {
            Log.w(f4495a, "Ignoring malformed AVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                Integer valueOf3 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
                valueOf2 = valueOf3;
            } else if (strArr.length < 3) {
                Log.w(f4495a, "Ignoring malformed AVC codec string: ".concat(String.valueOf(str)));
                return null;
            } else {
                int parseInt = Integer.parseInt(strArr[1]);
                valueOf = Integer.valueOf(Integer.parseInt(strArr[2]));
                valueOf2 = Integer.valueOf(parseInt);
            }
            int i2 = g.get(valueOf2.intValue(), -1);
            if (i2 == -1) {
                Log.w(f4495a, "Unknown AVC profile: ".concat(String.valueOf(valueOf2)));
                return null;
            }
            int i3 = h.get(valueOf.intValue(), -1);
            if (i3 == -1) {
                Log.w(f4495a, "Unknown AVC level: ".concat(String.valueOf(valueOf)));
                return null;
            }
            return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
        } catch (NumberFormatException e2) {
            Log.w(f4495a, "Ignoring malformed AVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
    }

    private static void b(String str, boolean z) {
        try {
            c(str, z);
        } catch (b e2) {
            Log.e(f4495a, "Codec warming failed", e2);
        }
    }

    private static boolean b(String str) {
        if (af.f4793a <= 22) {
            if ("ODROID-XU3".equals(af.d) || "Nexus 10".equals(af.d)) {
                return "OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str);
            }
            return false;
        }
        return false;
    }

    private static List<com.anythink.expressad.exoplayer.f.a> c(String str, boolean z) {
        synchronized (d.class) {
            try {
                a aVar = new a(str, z);
                List<com.anythink.expressad.exoplayer.f.a> list = f.get(aVar);
                if (list != null) {
                    return list;
                }
                c eVar = af.f4793a >= 21 ? new e(z) : new C0057d((byte) 0);
                ArrayList<com.anythink.expressad.exoplayer.f.a> a2 = a(aVar, eVar, str);
                c cVar = eVar;
                ArrayList<com.anythink.expressad.exoplayer.f.a> arrayList = a2;
                if (z) {
                    cVar = eVar;
                    arrayList = a2;
                    if (a2.isEmpty()) {
                        cVar = eVar;
                        arrayList = a2;
                        if (21 <= af.f4793a) {
                            cVar = eVar;
                            arrayList = a2;
                            if (af.f4793a <= 23) {
                                c c0057d = new C0057d((byte) 0);
                                ArrayList<com.anythink.expressad.exoplayer.f.a> a3 = a(aVar, c0057d, str);
                                cVar = c0057d;
                                arrayList = a3;
                                if (!a3.isEmpty()) {
                                    Log.w(f4495a, "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + a3.get(0).f4491c);
                                    arrayList = a3;
                                    cVar = c0057d;
                                }
                            }
                        }
                    }
                }
                if (o.B.equals(str)) {
                    arrayList.addAll(a(new a("audio/eac3", aVar.b), cVar, str));
                }
                a(arrayList);
                List<com.anythink.expressad.exoplayer.f.a> unmodifiableList = Collections.unmodifiableList(arrayList);
                f.put(aVar, unmodifiableList);
                return unmodifiableList;
            } finally {
            }
        }
    }
}
