package com.opos.exoplayer.core.c.b;

import android.util.SparseArray;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.g;
import com.opos.exoplayer.core.c.h;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.j;
import com.opos.exoplayer.core.i.k;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.o;
import com.opos.exoplayer.core.video.ColorInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/b/a.class */
public final class a implements com.opos.exoplayer.core.c.e {

    /* renamed from: a  reason: collision with root package name */
    public static final h f11400a = new h() { // from class: com.opos.exoplayer.core.c.b.a.1
        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new a()};
        }
    };
    private static final byte[] b = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f11401c = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte[] d = u.c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] e = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] f = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID g = new UUID(72057594037932032L, -9223371306706625679L);
    private b A;
    private boolean B;
    private int C;
    private long D;
    private boolean E;
    private long F;
    private long G;
    private long H;
    private com.opos.exoplayer.core.i.h I;
    private com.opos.exoplayer.core.i.h J;
    private boolean K;
    private int L;
    private long M;
    private long N;
    private int O;
    private int P;
    private int[] Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private byte Z;
    private int aa;
    private int ab;
    private int ac;
    private boolean ad;
    private boolean ae;
    private g af;
    private final com.opos.exoplayer.core.c.b.c h;
    private final f i;
    private final SparseArray<b> j;
    private final boolean k;
    private final m l;
    private final m m;
    private final m n;
    private final m o;
    private final m p;
    private final m q;
    private final m r;
    private final m s;
    private final m t;
    private ByteBuffer u;
    private long v;
    private long w;
    private long x;
    private long y;
    private long z;

    /* renamed from: com.opos.exoplayer.core.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/b/a$a.class */
    final class C0479a implements d {
        private C0479a() {
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public int a(int i) {
            return a.this.a(i);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void a(int i, double d) {
            a.this.a(i, d);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void a(int i, int i2, com.opos.exoplayer.core.c.f fVar) {
            a.this.a(i, i2, fVar);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void a(int i, long j) {
            a.this.a(i, j);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void a(int i, long j, long j2) {
            a.this.a(i, j, j2);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void a(int i, String str) {
            a.this.a(i, str);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public boolean b(int i) {
            return a.this.b(i);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void c(int i) {
            a.this.c(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/b/a$b.class */
    public static final class b {
        public float A;
        public float B;
        public float C;
        public float D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public long J;
        public long K;
        public c L;
        public boolean M;
        public boolean N;
        public n O;
        public int P;
        private String Q;

        /* renamed from: a  reason: collision with root package name */
        public String f11403a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f11404c;
        public int d;
        public boolean e;
        public byte[] f;
        public n.a g;
        public byte[] h;
        public DrmInitData i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public byte[] o;
        public int p;
        public boolean q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public float w;
        public float x;
        public float y;
        public float z;

        private b() {
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = null;
            this.p = -1;
            this.q = false;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = 1000;
            this.v = 200;
            this.w = -1.0f;
            this.x = -1.0f;
            this.y = -1.0f;
            this.z = -1.0f;
            this.A = -1.0f;
            this.B = -1.0f;
            this.C = -1.0f;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 1;
            this.H = -1;
            this.I = 8000;
            this.J = 0L;
            this.K = 0L;
            this.N = true;
            this.Q = "eng";
        }

        private static List<byte[]> a(m mVar) {
            try {
                mVar.d(16);
                if (mVar.n() != 826496599) {
                    return null;
                }
                int d = mVar.d() + 20;
                byte[] bArr = mVar.f11808a;
                while (true) {
                    if (d >= bArr.length - 4) {
                        throw new o("Failed to find FourCC VC1 initialization data");
                    }
                    if (bArr[d] == 0 && bArr[d + 1] == 0 && bArr[d + 2] == 1 && bArr[d + 3] == 15) {
                        return Collections.singletonList(Arrays.copyOfRange(bArr, d, bArr.length));
                    }
                    d++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new o("Error parsing FourCC VC1 codec private");
            }
        }

        private static List<byte[]> a(byte[] bArr) {
            int i;
            int i2;
            try {
                if (bArr[0] == 2) {
                    int i3 = 1;
                    int i4 = 0;
                    while (true) {
                        i = i4;
                        if (bArr[i3] != -1) {
                            break;
                        }
                        i3++;
                        i4 = i + 255;
                    }
                    int i5 = i + bArr[i3];
                    int i6 = 0;
                    int i7 = i3 + 1;
                    while (true) {
                        i2 = i7;
                        if (bArr[i2] != -1) {
                            break;
                        }
                        i6 += 255;
                        i7 = i2 + 1;
                    }
                    int i8 = i2 + 1;
                    byte b = bArr[i2];
                    if (bArr[i8] == 1) {
                        byte[] bArr2 = new byte[i5];
                        System.arraycopy(bArr, i8, bArr2, 0, i5);
                        int i9 = i5 + i8;
                        if (bArr[i9] == 3) {
                            int i10 = i6 + b + i9;
                            if (bArr[i10] == 5) {
                                byte[] bArr3 = new byte[bArr.length - i10];
                                System.arraycopy(bArr, i10, bArr3, 0, bArr.length - i10);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw new o("Error parsing vorbis codec private");
                        }
                        throw new o("Error parsing vorbis codec private");
                    }
                    throw new o("Error parsing vorbis codec private");
                }
                throw new o("Error parsing vorbis codec private");
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new o("Error parsing vorbis codec private");
            }
        }

        private static boolean b(m mVar) {
            boolean z;
            try {
                int i = mVar.i();
                if (i != 1) {
                    z = false;
                    if (i == 65534) {
                        mVar.c(24);
                        z = false;
                        if (mVar.q() == a.g.getMostSignificantBits()) {
                            if (mVar.q() != a.g.getLeastSignificantBits()) {
                                return false;
                            }
                        }
                    }
                    return z;
                }
                z = true;
                return z;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new o("Error parsing MS/ACM codec private");
            }
        }

        private byte[] c() {
            if (this.w == -1.0f || this.x == -1.0f || this.y == -1.0f || this.z == -1.0f || this.A == -1.0f || this.B == -1.0f || this.C == -1.0f || this.D == -1.0f || this.E == -1.0f || this.F == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.put((byte) 0);
            wrap.putShort((short) ((this.w * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.x * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.y * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.z * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.A * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.B * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.C * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.D * 50000.0f) + 0.5f));
            wrap.putShort((short) (this.E + 0.5f));
            wrap.putShort((short) (this.F + 0.5f));
            wrap.putShort((short) this.u);
            wrap.putShort((short) this.v);
            return bArr;
        }

        public void a() {
            c cVar = this.L;
            if (cVar != null) {
                cVar.a(this);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public void a(g gVar, int i) {
            boolean z;
            String str;
            List<byte[]> singletonList;
            String str2;
            ArrayList a2;
            int i2;
            int i3;
            String str3;
            StringBuilder sb;
            int i4;
            Format a3;
            int i5;
            int i6;
            int i7;
            String str4 = this.f11403a;
            switch (str4.hashCode()) {
                case -2095576542:
                    if (str4.equals("V_MPEG4/ISO/AP")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -2095575984:
                    if (str4.equals("V_MPEG4/ISO/SP")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -1985379776:
                    if (str4.equals("A_MS/ACM")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -1784763192:
                    if (str4.equals("A_TRUEHD")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -1730367663:
                    if (str4.equals("A_VORBIS")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -1482641358:
                    if (str4.equals("A_MPEG/L2")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -1482641357:
                    if (str4.equals("A_MPEG/L3")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -1373388978:
                    if (str4.equals("V_MS/VFW/FOURCC")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -933872740:
                    if (str4.equals("S_DVBSUB")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -538363189:
                    if (str4.equals("V_MPEG4/ISO/ASP")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -538363109:
                    if (str4.equals("V_MPEG4/ISO/AVC")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -425012669:
                    if (str4.equals("S_VOBSUB")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -356037306:
                    if (str4.equals("A_DTS/LOSSLESS")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 62923557:
                    if (str4.equals("A_AAC")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 62923603:
                    if (str4.equals("A_AC3")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 62927045:
                    if (str4.equals("A_DTS")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 82338133:
                    if (str4.equals("V_VP8")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 82338134:
                    if (str4.equals("V_VP9")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 99146302:
                    if (str4.equals("S_HDMV/PGS")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 444813526:
                    if (str4.equals("V_THEORA")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 542569478:
                    if (str4.equals("A_DTS/EXPRESS")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 725957860:
                    if (str4.equals("A_PCM/INT/LIT")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 738597099:
                    if (str4.equals("S_TEXT/ASS")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 855502857:
                    if (str4.equals("V_MPEGH/ISO/HEVC")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1422270023:
                    if (str4.equals("S_TEXT/UTF8")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1809237540:
                    if (str4.equals("V_MPEG2")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1950749482:
                    if (str4.equals("A_EAC3")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1950789798:
                    if (str4.equals("A_FLAC")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1951062397:
                    if (str4.equals("A_OPUS")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            String str5 = ". Setting mimeType to ";
            switch (z) {
                case false:
                    str = "video/x-vnd.on2.vp8";
                    str2 = str;
                    singletonList = null;
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    str = "video/x-vnd.on2.vp9";
                    str2 = str;
                    singletonList = null;
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    str = "video/mpeg2";
                    str2 = str;
                    singletonList = null;
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                case true:
                case true:
                    byte[] bArr = this.h;
                    singletonList = bArr == null ? null : Collections.singletonList(bArr);
                    str2 = "video/mp4v-es";
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    com.opos.exoplayer.core.video.a a4 = com.opos.exoplayer.core.video.a.a(new m(this.h));
                    singletonList = a4.f11877a;
                    this.P = a4.b;
                    str2 = "video/avc";
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    com.opos.exoplayer.core.video.b a5 = com.opos.exoplayer.core.video.b.a(new m(this.h));
                    singletonList = a5.f11879a;
                    this.P = a5.b;
                    str2 = "video/hevc";
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    singletonList = a(new m(this.h));
                    if (singletonList != null) {
                        str2 = com.anythink.expressad.exoplayer.k.o.o;
                    } else {
                        com.opos.cmn.an.f.a.c("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
                        str2 = com.anythink.expressad.exoplayer.k.o.p;
                    }
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    str = com.anythink.expressad.exoplayer.k.o.p;
                    str2 = str;
                    singletonList = null;
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    a2 = a(this.h);
                    str2 = "audio/vorbis";
                    i2 = -1;
                    i3 = 8192;
                    break;
                case true:
                    ArrayList arrayList = new ArrayList(3);
                    arrayList.add(this.h);
                    arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.J).array());
                    arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.K).array());
                    str2 = "audio/opus";
                    i2 = -1;
                    i3 = 5760;
                    a2 = arrayList;
                    break;
                case true:
                    singletonList = Collections.singletonList(this.h);
                    str2 = "audio/mp4a-latm";
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    str3 = com.anythink.expressad.exoplayer.k.o.v;
                    str2 = str3;
                    a2 = null;
                    i2 = -1;
                    i3 = 4096;
                    break;
                case true:
                    str3 = "audio/mpeg";
                    str2 = str3;
                    a2 = null;
                    i2 = -1;
                    i3 = 4096;
                    break;
                case true:
                    str = "audio/ac3";
                    str2 = str;
                    singletonList = null;
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    str = "audio/eac3";
                    str2 = str;
                    singletonList = null;
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    this.L = new c();
                    str = com.anythink.expressad.exoplayer.k.o.C;
                    str2 = str;
                    singletonList = null;
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                case true:
                    str = com.anythink.expressad.exoplayer.k.o.D;
                    str2 = str;
                    singletonList = null;
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    str = com.anythink.expressad.exoplayer.k.o.E;
                    str2 = str;
                    singletonList = null;
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    singletonList = Collections.singletonList(this.h);
                    str2 = "audio/flac";
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    if (b(new m(this.h))) {
                        int b = u.b(this.H);
                        i4 = b;
                        if (b == 0) {
                            sb = new StringBuilder();
                            sb.append("Unsupported PCM bit depth: ");
                            sb.append(this.H);
                            sb.append(str5);
                            sb.append(com.anythink.expressad.exoplayer.k.o.N);
                            com.opos.cmn.an.f.a.c("MatroskaExtractor", sb.toString());
                            str = com.anythink.expressad.exoplayer.k.o.N;
                            str2 = str;
                            singletonList = null;
                            i2 = -1;
                            i3 = -1;
                            a2 = singletonList;
                            break;
                        }
                        str2 = "audio/raw";
                        singletonList = null;
                        i2 = i4;
                        i3 = -1;
                        a2 = singletonList;
                    } else {
                        sb = new StringBuilder();
                        str5 = "Non-PCM MS/ACM is unsupported. Setting mimeType to ";
                        sb.append(str5);
                        sb.append(com.anythink.expressad.exoplayer.k.o.N);
                        com.opos.cmn.an.f.a.c("MatroskaExtractor", sb.toString());
                        str = com.anythink.expressad.exoplayer.k.o.N;
                        str2 = str;
                        singletonList = null;
                        i2 = -1;
                        i3 = -1;
                        a2 = singletonList;
                    }
                case true:
                    int b2 = u.b(this.H);
                    i4 = b2;
                    if (b2 == 0) {
                        sb = new StringBuilder();
                        sb.append("Unsupported PCM bit depth: ");
                        sb.append(this.H);
                        sb.append(str5);
                        sb.append(com.anythink.expressad.exoplayer.k.o.N);
                        com.opos.cmn.an.f.a.c("MatroskaExtractor", sb.toString());
                        str = com.anythink.expressad.exoplayer.k.o.N;
                        str2 = str;
                        singletonList = null;
                        i2 = -1;
                        i3 = -1;
                        a2 = singletonList;
                        break;
                    }
                    str2 = "audio/raw";
                    singletonList = null;
                    i2 = i4;
                    i3 = -1;
                    a2 = singletonList;
                case true:
                    str = "application/x-subrip";
                    str2 = str;
                    singletonList = null;
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    str = com.anythink.expressad.exoplayer.k.o.P;
                    str2 = str;
                    singletonList = null;
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    singletonList = Collections.singletonList(this.h);
                    str2 = com.anythink.expressad.exoplayer.k.o.ae;
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    str = com.anythink.expressad.exoplayer.k.o.af;
                    str2 = str;
                    singletonList = null;
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                case true:
                    byte[] bArr2 = this.h;
                    singletonList = Collections.singletonList(new byte[]{bArr2[0], bArr2[1], bArr2[2], bArr2[3]});
                    str2 = com.anythink.expressad.exoplayer.k.o.aj;
                    i2 = -1;
                    i3 = -1;
                    a2 = singletonList;
                    break;
                default:
                    throw new o("Unrecognized codec identifier.");
            }
            int i8 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
            if (j.a(str2)) {
                a3 = Format.a(Integer.toString(i), str2, (String) null, -1, i3, this.G, this.I, i2, a2, this.i, i8, this.Q);
                i5 = 1;
            } else if (j.b(str2)) {
                if (this.n == 0) {
                    int i9 = this.l;
                    int i10 = i9;
                    if (i9 == -1) {
                        i10 = this.j;
                    }
                    this.l = i10;
                    int i11 = this.m;
                    int i12 = i11;
                    if (i11 == -1) {
                        i12 = this.k;
                    }
                    this.m = i12;
                }
                a3 = Format.a(Integer.toString(i), str2, (String) null, -1, i3, this.j, this.k, -1.0f, a2, -1, (this.l == -1 || (i7 = this.m) == -1) ? -1.0f : (this.k * i6) / (this.j * i7), this.o, this.p, this.q ? new ColorInfo(this.r, this.t, this.s, c()) : null, this.i);
                i5 = 2;
            } else {
                if ("application/x-subrip".equals(str2)) {
                    a3 = Format.a(Integer.toString(i), str2, i8, this.Q, this.i);
                } else if (com.anythink.expressad.exoplayer.k.o.P.equals(str2)) {
                    ArrayList arrayList2 = new ArrayList(2);
                    arrayList2.add(a.d);
                    arrayList2.add(this.h);
                    a3 = Format.a(Integer.toString(i), str2, null, -1, i8, this.Q, -1, this.i, Long.MAX_VALUE, arrayList2);
                } else if (!com.anythink.expressad.exoplayer.k.o.ae.equals(str2) && !com.anythink.expressad.exoplayer.k.o.af.equals(str2) && !com.anythink.expressad.exoplayer.k.o.aj.equals(str2)) {
                    throw new o("Unexpected MIME type.");
                } else {
                    a3 = Format.a(Integer.toString(i), str2, (String) null, -1, i8, a2, this.Q, this.i);
                }
                i5 = 3;
            }
            n a6 = gVar.a(this.b, i5);
            this.O = a6;
            a6.a(a3);
        }

        public void b() {
            c cVar = this.L;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/b/a$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f11405a = new byte[12];
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private int f11406c;
        private int d;
        private long e;
        private int f;

        public void a() {
            this.b = false;
        }

        public void a(b bVar) {
            if (!this.b || this.f11406c <= 0) {
                return;
            }
            bVar.O.a(this.e, this.f, this.d, 0, bVar.g);
            this.f11406c = 0;
        }

        public void a(b bVar, long j) {
            if (this.b) {
                int i = this.f11406c;
                this.f11406c = i + 1;
                if (i == 0) {
                    this.e = j;
                }
                if (this.f11406c >= 8) {
                    bVar.O.a(this.e, this.f, this.d, 0, bVar.g);
                    this.f11406c = 0;
                }
            }
        }

        public void a(com.opos.exoplayer.core.c.f fVar, int i, int i2) {
            if (!this.b) {
                fVar.c(this.f11405a, 0, 12);
                fVar.a();
                if (com.opos.exoplayer.core.a.a.b(this.f11405a) == -1) {
                    return;
                }
                this.b = true;
                this.f11406c = 0;
            }
            if (this.f11406c == 0) {
                this.f = i;
                this.d = 0;
            }
            this.d += i2;
        }
    }

    public a() {
        this(0);
    }

    public a(int i) {
        this(new com.opos.exoplayer.core.c.b.b(), i);
    }

    a(com.opos.exoplayer.core.c.b.c cVar, int i) {
        this.w = -1L;
        this.x = com.anythink.expressad.exoplayer.b.b;
        this.y = com.anythink.expressad.exoplayer.b.b;
        this.z = com.anythink.expressad.exoplayer.b.b;
        this.F = -1L;
        this.G = -1L;
        this.H = com.anythink.expressad.exoplayer.b.b;
        this.h = cVar;
        cVar.a(new C0479a());
        this.k = (i & 1) != 0 ? false : true;
        this.i = new f();
        this.j = new SparseArray<>();
        this.n = new m(4);
        this.o = new m(ByteBuffer.allocate(4).putInt(-1).array());
        this.p = new m(4);
        this.l = new m(k.f11800a);
        this.m = new m(4);
        this.q = new m();
        this.r = new m();
        this.s = new m(8);
        this.t = new m();
    }

    private int a(com.opos.exoplayer.core.c.f fVar, n nVar, int i) {
        int a2;
        int b2 = this.q.b();
        if (b2 > 0) {
            a2 = Math.min(i, b2);
            nVar.a(this.q, a2);
        } else {
            a2 = nVar.a(fVar, i, false);
        }
        this.U += a2;
        this.ac += a2;
        return a2;
    }

    private long a(long j) {
        long j2 = this.x;
        if (j2 != com.anythink.expressad.exoplayer.b.b) {
            return u.d(j, j2, 1000L);
        }
        throw new o("Can't scale timecode prior to timecodeScale being set.");
    }

    private void a(b bVar, long j) {
        if (bVar.L != null) {
            bVar.L.a(bVar, j);
        } else {
            if ("S_TEXT/UTF8".equals(bVar.f11403a)) {
                a(bVar, "%02d:%02d:%02d,%03d", 19, 1000L, f11401c);
            } else if ("S_TEXT/ASS".equals(bVar.f11403a)) {
                a(bVar, "%01d:%02d:%02d:%02d", 21, 10000L, f);
            }
            bVar.O.a(j, this.T, this.ac, 0, bVar.g);
        }
        this.ad = true;
        d();
    }

    private void a(b bVar, String str, int i, long j, byte[] bArr) {
        a(this.r.f11808a, this.N, str, i, j, bArr);
        n nVar = bVar.O;
        m mVar = this.r;
        nVar.a(mVar, mVar.c());
        this.ac += this.r.c();
    }

    private void a(com.opos.exoplayer.core.c.f fVar, int i) {
        if (this.n.c() >= i) {
            return;
        }
        if (this.n.e() < i) {
            m mVar = this.n;
            mVar.a(Arrays.copyOf(mVar.f11808a, Math.max(this.n.f11808a.length * 2, i)), this.n.c());
        }
        fVar.b(this.n.f11808a, this.n.c(), i - this.n.c());
        this.n.b(i);
    }

    private void a(com.opos.exoplayer.core.c.f fVar, b bVar, int i) {
        int i2;
        int i3;
        if ("S_TEXT/UTF8".equals(bVar.f11403a)) {
            a(fVar, b, i);
        } else if ("S_TEXT/ASS".equals(bVar.f11403a)) {
            a(fVar, e, i);
        } else {
            n nVar = bVar.O;
            boolean z = true;
            if (!this.V) {
                if (bVar.e) {
                    this.T &= -1073741825;
                    int i4 = 128;
                    if (!this.W) {
                        fVar.b(this.n.f11808a, 0, 1);
                        this.U++;
                        if ((this.n.f11808a[0] & 128) == 128) {
                            throw new o("Extension bit is set in signal byte");
                        }
                        this.Z = this.n.f11808a[0];
                        this.W = true;
                    }
                    if ((this.Z & 1) == 1) {
                        boolean z2 = (this.Z & 2) == 2;
                        this.T |= 1073741824;
                        if (!this.X) {
                            fVar.b(this.s.f11808a, 0, 8);
                            this.U += 8;
                            this.X = true;
                            byte[] bArr = this.n.f11808a;
                            if (!z2) {
                                i4 = 0;
                            }
                            bArr[0] = (byte) (i4 | 8);
                            this.n.c(0);
                            nVar.a(this.n, 1);
                            this.ac++;
                            this.s.c(0);
                            nVar.a(this.s, 8);
                            this.ac += 8;
                        }
                        if (z2) {
                            if (!this.Y) {
                                fVar.b(this.n.f11808a, 0, 1);
                                this.U++;
                                this.n.c(0);
                                this.aa = this.n.g();
                                this.Y = true;
                            }
                            int i5 = this.aa * 4;
                            this.n.a(i5);
                            fVar.b(this.n.f11808a, 0, i5);
                            this.U = i5 + this.U;
                            short s = (short) ((this.aa / 2) + 1);
                            int i6 = (s * 6) + 2;
                            ByteBuffer byteBuffer = this.u;
                            if (byteBuffer == null || byteBuffer.capacity() < i6) {
                                this.u = ByteBuffer.allocate(i6);
                            }
                            this.u.position(0);
                            this.u.putShort(s);
                            int i7 = 0;
                            int i8 = 0;
                            while (true) {
                                i2 = i8;
                                i3 = this.aa;
                                if (i7 >= i3) {
                                    break;
                                }
                                int u = this.n.u();
                                if (i7 % 2 == 0) {
                                    this.u.putShort((short) (u - i2));
                                } else {
                                    this.u.putInt(u - i2);
                                }
                                i7++;
                                i8 = u;
                            }
                            int i9 = (i - this.U) - i2;
                            ByteBuffer byteBuffer2 = this.u;
                            if (i3 % 2 == 1) {
                                byteBuffer2.putInt(i9);
                            } else {
                                byteBuffer2.putShort((short) i9);
                                this.u.putInt(0);
                            }
                            this.t.a(this.u.array(), i6);
                            nVar.a(this.t, i6);
                            this.ac += i6;
                        }
                    }
                } else if (bVar.f != null) {
                    this.q.a(bVar.f, bVar.f.length);
                }
                this.V = true;
            }
            int c2 = this.q.c() + i;
            if (!"V_MPEG4/ISO/AVC".equals(bVar.f11403a) && !"V_MPEGH/ISO/HEVC".equals(bVar.f11403a)) {
                if (bVar.L != null) {
                    if (this.q.c() != 0) {
                        z = false;
                    }
                    com.opos.exoplayer.core.i.a.b(z);
                    bVar.L.a(fVar, this.T, c2);
                }
                while (true) {
                    int i10 = this.U;
                    if (i10 >= c2) {
                        break;
                    }
                    a(fVar, nVar, c2 - i10);
                }
            } else {
                byte[] bArr2 = this.m.f11808a;
                byte b2 = (byte) 0;
                bArr2[0] = b2;
                bArr2[1] = b2;
                bArr2[2] = b2;
                int i11 = bVar.P;
                int i12 = bVar.P;
                while (this.U < c2) {
                    int i13 = this.ab;
                    if (i13 == 0) {
                        a(fVar, bArr2, 4 - i12, i11);
                        this.m.c(0);
                        this.ab = this.m.u();
                        this.l.c(0);
                        nVar.a(this.l, 4);
                        this.ac += 4;
                    } else {
                        this.ab = i13 - a(fVar, nVar, i13);
                    }
                }
            }
            if ("A_VORBIS".equals(bVar.f11403a)) {
                this.o.c(0);
                nVar.a(this.o, 4);
                this.ac += 4;
            }
        }
    }

    private void a(com.opos.exoplayer.core.c.f fVar, byte[] bArr, int i) {
        int length = bArr.length + i;
        if (this.r.e() < length) {
            this.r.f11808a = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.r.f11808a, 0, bArr.length);
        }
        fVar.b(this.r.f11808a, bArr.length, i);
        this.r.a(length);
    }

    private void a(com.opos.exoplayer.core.c.f fVar, byte[] bArr, int i, int i2) {
        int min = Math.min(i2, this.q.b());
        fVar.b(bArr, i + min, i2 - min);
        if (min > 0) {
            this.q.a(bArr, i, min);
        }
        this.U += i2;
    }

    private static void a(byte[] bArr, long j, String str, int i, long j2, byte[] bArr2) {
        byte[] c2;
        if (j == com.anythink.expressad.exoplayer.b.b) {
            c2 = bArr2;
        } else {
            int i2 = (int) (j / 3600000000L);
            long j3 = j - ((i2 * 3600) * 1000000);
            int i3 = (int) (j3 / 60000000);
            long j4 = j3 - ((i3 * 60) * 1000000);
            int i4 = (int) (j4 / 1000000);
            c2 = u.c(String.format(Locale.US, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j4 - (i4 * 1000000)) / j2))));
        }
        System.arraycopy(c2, 0, bArr, i, bArr2.length);
    }

    private boolean a(com.opos.exoplayer.core.c.k kVar, long j) {
        boolean z;
        if (!this.E) {
            z = false;
            if (this.B) {
                long j2 = this.G;
                z = false;
                if (j2 != -1) {
                    kVar.f11561a = j2;
                    this.G = -1L;
                }
            }
            return z;
        }
        this.G = j;
        kVar.f11561a = this.F;
        this.E = false;
        z = true;
        return z;
    }

    private static boolean a(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str);
    }

    private static int[] a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int[] iArr2 = iArr;
        if (iArr.length < i) {
            iArr2 = new int[Math.max(iArr.length * 2, i)];
        }
        return iArr2;
    }

    private void d() {
        this.U = 0;
        this.ac = 0;
        this.ab = 0;
        this.V = false;
        this.W = false;
        this.Y = false;
        this.aa = 0;
        this.Z = (byte) 0;
        this.X = false;
        this.q.a();
    }

    private l e() {
        com.opos.exoplayer.core.i.h hVar;
        com.opos.exoplayer.core.i.h hVar2;
        int i;
        if (this.w == -1 || this.z == com.anythink.expressad.exoplayer.b.b || (hVar = this.I) == null || hVar.a() == 0 || (hVar2 = this.J) == null || hVar2.a() != this.I.a()) {
            this.I = null;
            this.J = null;
            return new l.b(this.z);
        }
        int a2 = this.I.a();
        int[] iArr = new int[a2];
        long[] jArr = new long[a2];
        long[] jArr2 = new long[a2];
        long[] jArr3 = new long[a2];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = 0;
            if (i3 >= a2) {
                break;
            }
            jArr3[i3] = this.I.a(i3);
            jArr[i3] = this.w + this.J.a(i3);
            i2 = i3 + 1;
        }
        while (true) {
            int i4 = a2 - 1;
            if (i >= i4) {
                iArr[i4] = (int) ((this.w + this.v) - jArr[i4]);
                jArr2[i4] = this.z - jArr3[i4];
                this.I = null;
                this.J = null;
                return new com.opos.exoplayer.core.c.a(iArr, jArr, jArr2, jArr3);
            }
            int i5 = i + 1;
            iArr[i] = (int) (jArr[i5] - jArr[i]);
            jArr2[i] = jArr3[i5] - jArr3[i];
            i = i5;
        }
    }

    int a(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        int i = 0;
        this.ad = false;
        boolean z = true;
        while (z && !this.ad) {
            boolean a2 = this.h.a(fVar);
            z = a2;
            if (a2) {
                z = a2;
                if (a(kVar, fVar.c())) {
                    return 1;
                }
            }
        }
        if (!z) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.j.size()) {
                    break;
                }
                this.j.valueAt(i3).a();
                i2 = i3 + 1;
            }
            i = -1;
        }
        return i;
    }

    void a(int i, double d2) {
        if (i == 181) {
            this.A.I = (int) d2;
        } else if (i == 17545) {
            this.y = (long) d2;
        } else {
            switch (i) {
                case 21969:
                    this.A.w = (float) d2;
                    return;
                case 21970:
                    this.A.x = (float) d2;
                    return;
                case 21971:
                    this.A.y = (float) d2;
                    return;
                case 21972:
                    this.A.z = (float) d2;
                    return;
                case 21973:
                    this.A.A = (float) d2;
                    return;
                case 21974:
                    this.A.B = (float) d2;
                    return;
                case 21975:
                    this.A.C = (float) d2;
                    return;
                case 21976:
                    this.A.D = (float) d2;
                    return;
                case 21977:
                    this.A.E = (float) d2;
                    return;
                case 21978:
                    this.A.F = (float) d2;
                    return;
                default:
                    return;
            }
        }
    }

    void a(int i, int i2, com.opos.exoplayer.core.c.f fVar) {
        long j;
        int i3;
        int i4;
        int[] iArr;
        int i5 = 4;
        if (i != 161 && i != 163) {
            if (i == 16981) {
                this.A.f = new byte[i2];
                fVar.b(this.A.f, 0, i2);
                return;
            } else if (i == 18402) {
                byte[] bArr = new byte[i2];
                fVar.b(bArr, 0, i2);
                this.A.g = new n.a(1, bArr, 0, 0);
                return;
            } else if (i == 21419) {
                Arrays.fill(this.p.f11808a, (byte) 0);
                fVar.b(this.p.f11808a, 4 - i2, i2);
                this.p.c(0);
                this.C = (int) this.p.m();
                return;
            } else if (i == 25506) {
                this.A.h = new byte[i2];
                fVar.b(this.A.h, 0, i2);
                return;
            } else if (i == 30322) {
                this.A.o = new byte[i2];
                fVar.b(this.A.o, 0, i2);
                return;
            } else {
                throw new o("Unexpected id: " + i);
            }
        }
        if (this.L == 0) {
            this.R = (int) this.i.a(fVar, false, true, 8);
            this.S = this.i.b();
            this.N = com.anythink.expressad.exoplayer.b.b;
            this.L = 1;
            this.n.a();
        }
        b bVar = this.j.get(this.R);
        if (bVar == null) {
            fVar.b(i2 - this.S);
            this.L = 0;
            return;
        }
        if (this.L == 1) {
            a(fVar, 3);
            int i6 = (this.n.f11808a[2] & 6) >> 1;
            if (i6 == 0) {
                this.P = 1;
                int[] a2 = a(this.Q, 1);
                this.Q = a2;
                a2[0] = (i2 - this.S) - 3;
            } else if (i != 163) {
                throw new o("Lacing only supported in SimpleBlocks.");
            } else {
                a(fVar, 4);
                int i7 = (this.n.f11808a[3] & 255) + 1;
                this.P = i7;
                int[] a3 = a(this.Q, i7);
                this.Q = a3;
                if (i6 == 2) {
                    int i8 = this.S;
                    int i9 = this.P;
                    Arrays.fill(a3, 0, i9, ((i2 - i8) - 4) / i9);
                } else if (i6 != 1) {
                    if (i6 != 3) {
                        throw new o("Unexpected lacing value: " + i6);
                    }
                    int i10 = 0;
                    int i11 = 0;
                    while (true) {
                        int i12 = this.P;
                        if (i10 >= i12 - 1) {
                            this.Q[i12 - 1] = ((i2 - this.S) - i5) - i11;
                            break;
                        }
                        this.Q[i10] = 0;
                        int i13 = i5 + 1;
                        a(fVar, i13);
                        int i14 = i13 - 1;
                        if (this.n.f11808a[i14] == 0) {
                            throw new o("No valid varint length mask found");
                        }
                        int i15 = 0;
                        while (true) {
                            int i16 = i15;
                            i5 = i13;
                            j = 0;
                            if (i16 >= 8) {
                                break;
                            }
                            int i17 = 1 << (7 - i16);
                            if ((this.n.f11808a[i14] & i17) != 0) {
                                int i18 = i13 + i16;
                                a(fVar, i18);
                                long j2 = i17 & this.n.f11808a[i14] & 255;
                                int i19 = i14;
                                while (true) {
                                    int i20 = i19 + 1;
                                    if (i20 >= i18) {
                                        break;
                                    }
                                    j2 = (j2 << 8) | (this.n.f11808a[i20] & 255);
                                    i19 = i20;
                                }
                                i5 = i18;
                                j = j2;
                                if (i10 > 0) {
                                    j = j2 - ((1 << ((i16 * 7) + 6)) - 1);
                                    i5 = i18;
                                }
                            } else {
                                i15 = i16 + 1;
                            }
                        }
                        if (j < -2147483648L || j > 2147483647L) {
                            break;
                        }
                        int i21 = (int) j;
                        int[] iArr2 = this.Q;
                        if (i10 != 0) {
                            i21 += iArr2[i10 - 1];
                        }
                        iArr2[i10] = i21;
                        i11 += this.Q[i10];
                        i10++;
                    }
                    throw new o("EBML lacing sample size out of range.");
                } else {
                    int i22 = 0;
                    int i23 = 0;
                    while (true) {
                        i3 = this.P;
                        if (i22 >= i3 - 1) {
                            break;
                        }
                        this.Q[i22] = 0;
                        int i24 = i5;
                        do {
                            i5 = i24 + 1;
                            a(fVar, i5);
                            i4 = this.n.f11808a[i5 - 1] & 255;
                            iArr = this.Q;
                            iArr[i22] = iArr[i22] + i4;
                            i24 = i5;
                        } while (i4 == 255);
                        i23 += iArr[i22];
                        i22++;
                    }
                    this.Q[i3 - 1] = ((i2 - this.S) - i5) - i23;
                }
            }
            this.M = this.H + a((this.n.f11808a[0] << 8) | (this.n.f11808a[1] & 255));
            this.T = ((this.n.f11808a[2] & 8) == 8 ? Integer.MIN_VALUE : 0) | ((bVar.f11404c == 2 || (i == 163 && (this.n.f11808a[2] & 128) == 128)) ? 1 : 0);
            this.L = 2;
            this.O = 0;
        }
        if (i != 163) {
            a(fVar, bVar, this.Q[0]);
            return;
        }
        while (true) {
            int i25 = this.O;
            if (i25 >= this.P) {
                this.L = 0;
                return;
            }
            a(fVar, bVar, this.Q[i25]);
            a(bVar, this.M + ((this.O * bVar.d) / 1000));
            this.O++;
        }
    }

    void a(int i, long j) {
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw new o("ContentEncodingOrder " + j + " not supported");
        } else if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw new o("ContentEncodingScope " + j + " not supported");
        } else {
            boolean z = false;
            switch (i) {
                case 131:
                    this.A.f11404c = (int) j;
                    return;
                case 136:
                    b bVar = this.A;
                    boolean z2 = false;
                    if (j == 1) {
                        z2 = true;
                    }
                    bVar.M = z2;
                    return;
                case 155:
                    this.N = a(j);
                    return;
                case 159:
                    this.A.G = (int) j;
                    return;
                case 176:
                    this.A.j = (int) j;
                    return;
                case 179:
                    this.I.a(a(j));
                    return;
                case 186:
                    this.A.k = (int) j;
                    return;
                case 215:
                    this.A.b = (int) j;
                    return;
                case 231:
                    this.H = a(j);
                    return;
                case 241:
                    if (this.K) {
                        return;
                    }
                    this.J.a(j);
                    this.K = true;
                    return;
                case 251:
                    this.ae = true;
                    return;
                case 16980:
                    if (j == 3) {
                        return;
                    }
                    throw new o("ContentCompAlgo " + j + " not supported");
                case 17029:
                    if (j < 1 || j > 2) {
                        throw new o("DocTypeReadVersion " + j + " not supported");
                    }
                    return;
                case 17143:
                    if (j == 1) {
                        return;
                    }
                    throw new o("EBMLReadVersion " + j + " not supported");
                case 18401:
                    if (j == 5) {
                        return;
                    }
                    throw new o("ContentEncAlgo " + j + " not supported");
                case 18408:
                    if (j == 1) {
                        return;
                    }
                    throw new o("AESSettingsCipherMode " + j + " not supported");
                case 21420:
                    this.D = this.w + j;
                    return;
                case 21432:
                    int i2 = (int) j;
                    if (i2 == 0) {
                        this.A.p = 0;
                        return;
                    } else if (i2 == 1) {
                        this.A.p = 2;
                        return;
                    } else if (i2 == 3) {
                        this.A.p = 1;
                        return;
                    } else if (i2 != 15) {
                        return;
                    } else {
                        this.A.p = 3;
                        return;
                    }
                case 21680:
                    this.A.l = (int) j;
                    return;
                case 21682:
                    this.A.n = (int) j;
                    return;
                case 21690:
                    this.A.m = (int) j;
                    return;
                case 21930:
                    b bVar2 = this.A;
                    if (j == 1) {
                        z = true;
                    }
                    bVar2.N = z;
                    return;
                case 22186:
                    this.A.J = j;
                    return;
                case 22203:
                    this.A.K = j;
                    return;
                case 25188:
                    this.A.H = (int) j;
                    return;
                case 2352003:
                    this.A.d = (int) j;
                    return;
                case 2807729:
                    this.x = j;
                    return;
                default:
                    switch (i) {
                        case 21945:
                            int i3 = (int) j;
                            if (i3 == 1) {
                                this.A.t = 2;
                                return;
                            } else if (i3 != 2) {
                                return;
                            } else {
                                this.A.t = 1;
                                return;
                            }
                        case 21946:
                            int i4 = (int) j;
                            if (i4 != 1) {
                                if (i4 == 16) {
                                    this.A.s = 6;
                                    return;
                                } else if (i4 == 18) {
                                    this.A.s = 7;
                                    return;
                                } else if (i4 != 6 && i4 != 7) {
                                    return;
                                }
                            }
                            this.A.s = 3;
                            return;
                        case 21947:
                            this.A.q = true;
                            int i5 = (int) j;
                            if (i5 == 1) {
                                this.A.r = 1;
                                return;
                            } else if (i5 == 9) {
                                this.A.r = 6;
                                return;
                            } else if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                this.A.r = 2;
                                return;
                            } else {
                                return;
                            }
                        case 21948:
                            this.A.u = (int) j;
                            return;
                        case 21949:
                            this.A.v = (int) j;
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    void a(int i, long j, long j2) {
        if (i == 160) {
            this.ae = false;
        } else if (i == 174) {
            this.A = new b();
        } else if (i == 187) {
            this.K = false;
        } else if (i == 19899) {
            this.C = -1;
            this.D = -1L;
        } else if (i == 20533) {
            this.A.e = true;
        } else if (i == 21968) {
            this.A.q = true;
        } else if (i == 408125543) {
            long j3 = this.w;
            if (j3 != -1 && j3 != j) {
                throw new o("Multiple Segment elements not supported");
            }
            this.w = j;
            this.v = j2;
        } else if (i == 475249515) {
            this.I = new com.opos.exoplayer.core.i.h();
            this.J = new com.opos.exoplayer.core.i.h();
        } else if (i == 524531317 && !this.B) {
            if (this.k && this.F != -1) {
                this.E = true;
                return;
            }
            this.af.a(new l.b(this.z));
            this.B = true;
        }
    }

    void a(int i, String str) {
        if (i == 134) {
            this.A.f11403a = str;
        } else if (i != 17026) {
            if (i != 2274716) {
                return;
            }
            this.A.Q = str;
        } else if ("webm".equals(str) || "matroska".equals(str)) {
        } else {
            throw new o("DocType " + str + " not supported");
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        this.H = com.anythink.expressad.exoplayer.b.b;
        this.L = 0;
        this.h.a();
        this.i.a();
        d();
        for (int i = 0; i < this.j.size(); i++) {
            this.j.valueAt(i).b();
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(g gVar) {
        this.af = gVar;
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        return new e().a(fVar);
    }

    boolean b(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }

    void c(int i) {
        if (i == 160) {
            if (this.L == 2) {
                if (!this.ae) {
                    this.T |= 1;
                }
                a(this.j.get(this.R), this.M);
                this.L = 0;
            }
        } else if (i == 174) {
            if (a(this.A.f11403a)) {
                b bVar = this.A;
                bVar.a(this.af, bVar.b);
                this.j.put(this.A.b, this.A);
            }
            this.A = null;
        } else if (i == 19899) {
            int i2 = this.C;
            if (i2 != -1) {
                long j = this.D;
                if (j != -1) {
                    if (i2 == 475249515) {
                        this.F = j;
                        return;
                    }
                    return;
                }
            }
            throw new o("Mandatory element SeekID or SeekPosition not found");
        } else if (i == 25152) {
            if (this.A.e) {
                if (this.A.g == null) {
                    throw new o("Encrypted Track found but ContentEncKeyID was not found");
                }
                this.A.i = new DrmInitData(new DrmInitData.SchemeData(com.opos.exoplayer.core.b.b, com.anythink.expressad.exoplayer.k.o.f, this.A.g.b));
            }
        } else if (i == 28032) {
            if (this.A.e && this.A.f != null) {
                throw new o("Combining encryption and compression is not supported");
            }
        } else if (i == 357149030) {
            if (this.x == com.anythink.expressad.exoplayer.b.b) {
                this.x = 1000000L;
            }
            long j2 = this.y;
            if (j2 != com.anythink.expressad.exoplayer.b.b) {
                this.z = a(j2);
            }
        } else if (i == 374648427) {
            if (this.j.size() == 0) {
                throw new o("No valid tracks were found");
            }
            this.af.a();
        } else if (i == 475249515 && !this.B) {
            this.af.a(e());
            this.B = true;
        }
    }
}
