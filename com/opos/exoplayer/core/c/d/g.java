package com.opos.exoplayer.core.c.d;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.opos.exoplayer.core.i.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/g.class */
abstract class g {
    public final int aP;

    /* renamed from: a  reason: collision with root package name */
    public static final int f11440a = u.f("ftyp");
    public static final int b = u.f("avc1");

    /* renamed from: c  reason: collision with root package name */
    public static final int f11442c = u.f("avc3");
    public static final int d = u.f("hvc1");
    public static final int e = u.f("hev1");
    public static final int f = u.f("s263");
    public static final int g = u.f("d263");
    public static final int h = u.f("mdat");
    public static final int i = u.f("mp4a");
    public static final int j = u.f(".mp3");
    public static final int k = u.f("wave");
    public static final int l = u.f("lpcm");
    public static final int m = u.f("sowt");
    public static final int n = u.f("ac-3");
    public static final int o = u.f("dac3");
    public static final int p = u.f("ec-3");
    public static final int q = u.f("dec3");
    public static final int r = u.f("dtsc");
    public static final int s = u.f("dtsh");
    public static final int t = u.f("dtsl");
    public static final int u = u.f("dtse");
    public static final int v = u.f("ddts");
    public static final int w = u.f("tfdt");
    public static final int x = u.f("tfhd");
    public static final int y = u.f("trex");
    public static final int z = u.f("trun");
    public static final int A = u.f("sidx");
    public static final int B = u.f("moov");
    public static final int C = u.f("mvhd");
    public static final int D = u.f("trak");
    public static final int E = u.f("mdia");
    public static final int F = u.f("minf");
    public static final int G = u.f("stbl");
    public static final int H = u.f("avcC");
    public static final int I = u.f("hvcC");
    public static final int J = u.f("esds");
    public static final int K = u.f("moof");
    public static final int L = u.f("traf");
    public static final int M = u.f("mvex");
    public static final int N = u.f("mehd");
    public static final int O = u.f("tkhd");
    public static final int P = u.f("edts");
    public static final int Q = u.f("elst");
    public static final int R = u.f("mdhd");
    public static final int S = u.f("hdlr");
    public static final int T = u.f("stsd");
    public static final int U = u.f("pssh");
    public static final int V = u.f("sinf");
    public static final int W = u.f("schm");
    public static final int X = u.f("schi");
    public static final int Y = u.f("tenc");
    public static final int Z = u.f("encv");
    public static final int aa = u.f("enca");
    public static final int ab = u.f("frma");
    public static final int ac = u.f("saiz");
    public static final int ad = u.f("saio");
    public static final int ae = u.f("sbgp");
    public static final int af = u.f("sgpd");
    public static final int ag = u.f("uuid");
    public static final int ah = u.f("senc");
    public static final int ai = u.f("pasp");
    public static final int aj = u.f("TTML");
    public static final int ak = u.f("vmhd");
    public static final int al = u.f("mp4v");
    public static final int am = u.f("stts");
    public static final int an = u.f("stss");
    public static final int ao = u.f("ctts");
    public static final int ap = u.f("stsc");
    public static final int aq = u.f("stsz");

    /* renamed from: ar  reason: collision with root package name */
    public static final int f11441ar = u.f("stz2");
    public static final int as = u.f("stco");
    public static final int at = u.f("co64");
    public static final int au = u.f("tx3g");
    public static final int av = u.f("wvtt");
    public static final int aw = u.f("stpp");
    public static final int ax = u.f("c608");
    public static final int ay = u.f("samr");
    public static final int az = u.f("sawb");
    public static final int aA = u.f("udta");
    public static final int aB = u.f(TTDownloadField.TT_META);
    public static final int aC = u.f("ilst");
    public static final int aD = u.f("mean");
    public static final int aE = u.f("name");
    public static final int aF = u.f("data");
    public static final int aG = u.f("emsg");
    public static final int aH = u.f("st3d");
    public static final int aI = u.f("sv3d");
    public static final int aJ = u.f("proj");
    public static final int aK = u.f("vp08");
    public static final int aL = u.f("vp09");
    public static final int aM = u.f("vpcC");
    public static final int aN = u.f("camm");
    public static final int aO = u.f("alac");

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/g$a.class */
    static final class a extends g {
        public final long aQ;
        public final List<b> aR;
        public final List<a> aS;

        public a(int i, long j) {
            super(i);
            this.aQ = j;
            this.aR = new ArrayList();
            this.aS = new ArrayList();
        }

        public void a(a aVar) {
            this.aS.add(aVar);
        }

        public void a(b bVar) {
            this.aR.add(bVar);
        }

        public b d(int i) {
            int size = this.aR.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    return null;
                }
                b bVar = this.aR.get(i3);
                if (bVar.aP == i) {
                    return bVar;
                }
                i2 = i3 + 1;
            }
        }

        public a e(int i) {
            int size = this.aS.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    return null;
                }
                a aVar = this.aS.get(i3);
                if (aVar.aP == i) {
                    return aVar;
                }
                i2 = i3 + 1;
            }
        }

        @Override // com.opos.exoplayer.core.c.d.g
        public String toString() {
            return c(this.aP) + " leaves: " + Arrays.toString(this.aR.toArray()) + " containers: " + Arrays.toString(this.aS.toArray());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/g$b.class */
    static final class b extends g {
        public final com.opos.exoplayer.core.i.m aQ;

        public b(int i, com.opos.exoplayer.core.i.m mVar) {
            super(i);
            this.aQ = mVar;
        }
    }

    public g(int i2) {
        this.aP = i2;
    }

    public static int a(int i2) {
        return (i2 >> 24) & 255;
    }

    public static int b(int i2) {
        return i2 & 16777215;
    }

    public static String c(int i2) {
        return "" + ((char) ((i2 >> 24) & 255)) + ((char) ((i2 >> 16) & 255)) + ((char) ((i2 >> 8) & 255)) + ((char) (i2 & 255));
    }

    public String toString() {
        return c(this.aP);
    }
}
