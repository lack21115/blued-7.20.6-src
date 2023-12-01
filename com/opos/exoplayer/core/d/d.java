package com.opos.exoplayer.core.d;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.anythink.expressad.exoplayer.k.o;
import com.opos.exoplayer.core.i.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/d/d.class */
public final class d {
    private static final SparseIntArray d;
    private static final SparseIntArray e;
    private static final Map<String, Integer> f;

    /* renamed from: a  reason: collision with root package name */
    private static final com.opos.exoplayer.core.d.a f25263a = com.opos.exoplayer.core.d.a.a("OMX.google.raw.decoder");
    private static final Pattern b = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<b, List<com.opos.exoplayer.core.d.a>> f25264c = new HashMap<>();
    private static int g = -1;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/d/d$a.class */
    public static class a extends Exception {
        private a(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/d/d$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f25265a;
        public final boolean b;

        public b(String str, boolean z) {
            this.f25265a = str;
            this.b = z;
        }

        public boolean equals(Object obj) {
            boolean z;
            if (this != obj) {
                z = false;
                if (obj != null) {
                    if (obj.getClass() != b.class) {
                        return false;
                    }
                    b bVar = (b) obj;
                    z = false;
                    if (TextUtils.equals(this.f25265a, bVar.f25265a)) {
                        if (this.b != bVar.b) {
                            return false;
                        }
                    }
                }
                return z;
            }
            z = true;
            return z;
        }

        public int hashCode() {
            String str = this.f25265a;
            return (this.b ? 1231 : 1237) + (((str == null ? 0 : str.hashCode()) + 31) * 31);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/d/d$c.class */
    public interface c {
        int a();

        MediaCodecInfo a(int i);

        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.exoplayer.core.d.d$d  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/d/d$d.class */
    public static final class C0655d implements c {
        private C0655d() {
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public int a() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public MediaCodecInfo a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public boolean b() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/d/d$e.class */
    public static final class e implements c {

        /* renamed from: a  reason: collision with root package name */
        private final int f25266a;
        private MediaCodecInfo[] b;

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public e(boolean z) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        private void c() {
            if (this.b == null) {
                this.b = new MediaCodecList(this.f25266a).getCodecInfos();
            }
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public int a() {
            c();
            return this.b.length;
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public MediaCodecInfo a(int i) {
            c();
            return this.b[i];
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_SecurePlayback);
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public boolean b() {
            return true;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d = sparseIntArray;
        sparseIntArray.put(66, 1);
        d.put(77, 2);
        d.put(88, 4);
        d.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        e.put(11, 4);
        e.put(12, 8);
        e.put(13, 16);
        e.put(20, 32);
        e.put(21, 64);
        e.put(22, 128);
        e.put(30, 256);
        e.put(31, 512);
        e.put(32, 1024);
        e.put(40, 2048);
        e.put(41, 4096);
        e.put(42, 8192);
        e.put(50, 16384);
        e.put(51, 32768);
        e.put(52, 65536);
        HashMap hashMap = new HashMap();
        f = hashMap;
        hashMap.put("L30", 1);
        f.put("L60", 4);
        f.put("L63", 16);
        f.put("L90", 64);
        f.put("L93", 256);
        f.put("L120", 1024);
        f.put("L123", 4096);
        f.put("L150", 16384);
        f.put("L153", 65536);
        f.put("L156", 262144);
        f.put("L180", 1048576);
        f.put("L183", 4194304);
        f.put("L186", 16777216);
        f.put("H30", 2);
        f.put("H60", 8);
        f.put("H63", 32);
        f.put("H90", 128);
        f.put("H93", 512);
        f.put("H120", 2048);
        f.put("H123", 8192);
        f.put("H150", 32768);
        f.put("H153", 131072);
        f.put("H156", 524288);
        f.put("H180", 2097152);
        f.put("H183", 8388608);
        f.put("H186", 33554432);
    }

    private static int a(int i) {
        int i2 = 9437184;
        if (i == 1 || i == 2) {
            i2 = 25344;
        } else {
            switch (i) {
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
                    break;
                default:
                    return -1;
            }
        }
        return i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005b, code lost:
        if (r0.equals("hev1") != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> a(java.lang.String r3) {
        /*
            r0 = r3
            if (r0 != 0) goto L7
            goto L92
        L7:
            r0 = r3
            java.lang.String r1 = "\\."
            java.lang.String[] r0 = r0.split(r1)
            r5 = r0
            r0 = 0
            r4 = r0
            r0 = r5
            r1 = 0
            r0 = r0[r1]
            r6 = r0
            r0 = r6
            int r0 = r0.hashCode()
            switch(r0) {
                case 3006243: goto L6f;
                case 3006244: goto L61;
                case 3199032: goto L55;
                case 3214780: goto L47;
                default: goto L44;
            }
        L44:
            goto L7d
        L47:
            r0 = r6
            java.lang.String r1 = "hvc1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7d
            r0 = 1
            r4 = r0
            goto L7f
        L55:
            r0 = r6
            java.lang.String r1 = "hev1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7d
            goto L7f
        L61:
            r0 = r6
            java.lang.String r1 = "avc2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7d
            r0 = 3
            r4 = r0
            goto L7f
        L6f:
            r0 = r6
            java.lang.String r1 = "avc1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7d
            r0 = 2
            r4 = r0
            goto L7f
        L7d:
            r0 = -1
            r4 = r0
        L7f:
            r0 = r4
            if (r0 == 0) goto L9a
            r0 = r4
            r1 = 1
            if (r0 == r1) goto L9a
            r0 = r4
            r1 = 2
            if (r0 == r1) goto L94
            r0 = r4
            r1 = 3
            if (r0 == r1) goto L94
        L92:
            r0 = 0
            return r0
        L94:
            r0 = r3
            r1 = r5
            android.util.Pair r0 = b(r0, r1)
            return r0
        L9a:
            r0 = r3
            r1 = r5
            android.util.Pair r0 = a(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.d.d.a(java.lang.String):android.util.Pair");
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        StringBuilder sb;
        int i;
        String str2;
        if (strArr.length < 4) {
            sb = new StringBuilder();
        } else {
            Matcher matcher = b.matcher(strArr[1]);
            if (matcher.matches()) {
                str = matcher.group(1);
                if ("1".equals(str)) {
                    i = 1;
                } else if (!"2".equals(str)) {
                    sb = new StringBuilder();
                    sb.append("Unknown HEVC profile string: ");
                    sb.append(str);
                    str2 = sb.toString();
                    com.opos.cmn.an.f.a.c("MediaCodecUtil", str2);
                    return null;
                } else {
                    i = 2;
                }
                Integer num = f.get(strArr[3]);
                if (num == null) {
                    str2 = "Unknown HEVC level string: " + matcher.group(1);
                    com.opos.cmn.an.f.a.c("MediaCodecUtil", str2);
                    return null;
                }
                return new Pair<>(Integer.valueOf(i), num);
            }
            sb = new StringBuilder();
        }
        sb.append("Ignoring malformed HEVC codec string: ");
        sb.append(str);
        str2 = sb.toString();
        com.opos.cmn.an.f.a.c("MediaCodecUtil", str2);
        return null;
    }

    public static com.opos.exoplayer.core.d.a a() {
        return f25263a;
    }

    public static com.opos.exoplayer.core.d.a a(String str, boolean z) {
        List<com.opos.exoplayer.core.d.a> b2 = b(str, z);
        if (b2.isEmpty()) {
            return null;
        }
        return b2.get(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x018c, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList<com.opos.exoplayer.core.d.a> a(com.opos.exoplayer.core.d.d.b r7, com.opos.exoplayer.core.d.d.c r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.d.d.a(com.opos.exoplayer.core.d.d$b, com.opos.exoplayer.core.d.d$c, java.lang.String):java.util.ArrayList");
    }

    private static void a(List<com.opos.exoplayer.core.d.a> list) {
        if (u.f25510a < 26) {
            if (list.size() <= 1 || !"OMX.MTK.AUDIO.DECODER.RAW".equals(list.get(0).f25256a)) {
                return;
            }
            for (int i = 1; i < list.size(); i++) {
                com.opos.exoplayer.core.d.a aVar = list.get(i);
                if ("OMX.google.raw.decoder".equals(aVar.f25256a)) {
                    list.remove(i);
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
            if (u.f25510a >= 21 || !("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
                if (u.f25510a >= 18 || !"OMX.SEC.MP3.Decoder".equals(str)) {
                    if (u.f25510a < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
                        if ("a70".equals(u.b)) {
                            return false;
                        }
                        if ("Xiaomi".equals(u.f25511c) && u.b.startsWith("HM")) {
                            return false;
                        }
                    }
                    if (u.f25510a == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(u.b) || "protou".equals(u.b) || "ville".equals(u.b) || "villeplus".equals(u.b) || "villec2".equals(u.b) || u.b.startsWith("gee") || "C6602".equals(u.b) || "C6603".equals(u.b) || "C6606".equals(u.b) || "C6616".equals(u.b) || "L36h".equals(u.b) || "SO-02E".equals(u.b))) {
                        return false;
                    }
                    if (u.f25510a == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(u.b) || "C1505".equals(u.b) || "C1604".equals(u.b) || "C1605".equals(u.b))) {
                        return false;
                    }
                    if (u.f25510a >= 24 || !(("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && u.f25511c.equals("samsung") && (u.b.startsWith("zeroflte") || u.b.startsWith("zerolte") || u.b.startsWith("zenlte") || u.b.equals("SC-05G") || u.b.equals("marinelteatt") || u.b.equals("404SC") || u.b.equals("SC-04G") || u.b.equals("SCV31")))) {
                        if (u.f25510a <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(u.f25511c) && (u.b.startsWith(com.anythink.expressad.foundation.g.a.O) || u.b.startsWith("serrano") || u.b.startsWith("jflte") || u.b.startsWith("santos") || u.b.startsWith("t0"))) {
                            return false;
                        }
                        if (u.f25510a <= 19 && u.b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
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
        if (g == -1) {
            int i = 0;
            com.opos.exoplayer.core.d.a a2 = a("video/avc", false);
            if (a2 != null) {
                int i2 = 0;
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : a2.a()) {
                    i2 = Math.max(a(codecProfileLevel.level), i2);
                }
                i = Math.max(i2, u.f25510a >= 21 ? 345600 : 172800);
            }
            g = i;
        }
        return g;
    }

    private static Pair<Integer, Integer> b(String str, String[] strArr) {
        StringBuilder sb;
        Integer valueOf;
        Integer valueOf2;
        Integer valueOf3;
        String str2;
        if (strArr.length >= 2) {
            try {
                if (strArr[1].length() == 6) {
                    Integer valueOf4 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                    valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
                    valueOf2 = valueOf4;
                } else if (strArr.length < 3) {
                    com.opos.cmn.an.f.a.c("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                    return null;
                } else {
                    int parseInt = Integer.parseInt(strArr[1]);
                    valueOf = Integer.valueOf(Integer.parseInt(strArr[2]));
                    valueOf2 = Integer.valueOf(parseInt);
                }
                valueOf3 = Integer.valueOf(d.get(valueOf2.intValue()));
            } catch (NumberFormatException e2) {
                sb = new StringBuilder();
            }
            if (valueOf3 == null) {
                str2 = "Unknown AVC profile: " + valueOf2;
                com.opos.cmn.an.f.a.c("MediaCodecUtil", str2);
                return null;
            }
            Integer valueOf5 = Integer.valueOf(e.get(valueOf.intValue()));
            if (valueOf5 == null) {
                sb = new StringBuilder();
                sb.append("Unknown AVC level: ");
                sb.append(valueOf);
                str2 = sb.toString();
                com.opos.cmn.an.f.a.c("MediaCodecUtil", str2);
                return null;
            }
            return new Pair<>(valueOf3, valueOf5);
        }
        sb = new StringBuilder();
        sb.append("Ignoring malformed AVC codec string: ");
        sb.append(str);
        str2 = sb.toString();
        com.opos.cmn.an.f.a.c("MediaCodecUtil", str2);
        return null;
    }

    public static List<com.opos.exoplayer.core.d.a> b(String str, boolean z) {
        List<com.opos.exoplayer.core.d.a> unmodifiableList;
        synchronized (d.class) {
            try {
                b bVar = new b(str, z);
                List<com.opos.exoplayer.core.d.a> list = f25264c.get(bVar);
                if (list != null) {
                    unmodifiableList = list;
                } else {
                    c eVar = u.f25510a >= 21 ? new e(z) : new C0655d();
                    ArrayList<com.opos.exoplayer.core.d.a> a2 = a(bVar, eVar, str);
                    c cVar = eVar;
                    ArrayList<com.opos.exoplayer.core.d.a> arrayList = a2;
                    if (z) {
                        cVar = eVar;
                        arrayList = a2;
                        if (a2.isEmpty()) {
                            cVar = eVar;
                            arrayList = a2;
                            if (21 <= u.f25510a) {
                                cVar = eVar;
                                arrayList = a2;
                                if (u.f25510a <= 23) {
                                    c c0655d = new C0655d();
                                    ArrayList<com.opos.exoplayer.core.d.a> a3 = a(bVar, c0655d, str);
                                    cVar = c0655d;
                                    arrayList = a3;
                                    if (!a3.isEmpty()) {
                                        com.opos.cmn.an.f.a.c("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + a3.get(0).f25256a);
                                        arrayList = a3;
                                        cVar = c0655d;
                                    }
                                }
                            }
                        }
                    }
                    if (o.B.equals(str)) {
                        arrayList.addAll(a(new b("audio/eac3", bVar.b), cVar, str));
                    }
                    a(arrayList);
                    unmodifiableList = Collections.unmodifiableList(arrayList);
                    f25264c.put(bVar, unmodifiableList);
                }
            } finally {
            }
        }
        return unmodifiableList;
    }

    private static boolean b(String str) {
        if (u.f25510a <= 22) {
            if (u.d.equals("ODROID-XU3") || u.d.equals("Nexus 10")) {
                return "OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str);
            }
            return false;
        }
        return false;
    }
}
