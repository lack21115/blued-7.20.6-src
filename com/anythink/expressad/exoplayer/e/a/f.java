package com.anythink.expressad.exoplayer.e.a;

import android.util.Log;
import com.anythink.expressad.exoplayer.g.a;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.s;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.common.net.HttpHeaders;
import com.huawei.openalliance.ad.constant.ax;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/f.class */
final class f {
    private static final String F = "und";

    /* renamed from: a  reason: collision with root package name */
    private static final String f7296a = "MetadataUtil";
    private static final int b = af.f("nam");

    /* renamed from: c  reason: collision with root package name */
    private static final int f7297c = af.f("trk");
    private static final int d = af.f("cmt");
    private static final int e = af.f("day");
    private static final int f = af.f("ART");
    private static final int g = af.f("too");
    private static final int h = af.f("alb");
    private static final int i = af.f("com");
    private static final int j = af.f("wrt");
    private static final int k = af.f("lyr");
    private static final int l = af.f("gen");
    private static final int m = af.f("covr");
    private static final int n = af.f("gnre");
    private static final int o = af.f("grp");
    private static final int p = af.f("disk");
    private static final int q = af.f("trkn");
    private static final int r = af.f("tmpo");
    private static final int s = af.f("cpil");
    private static final int t = af.f("aART");
    private static final int u = af.f("sonm");
    private static final int v = af.f("soal");
    private static final int w = af.f("soar");
    private static final int x = af.f("soaa");
    private static final int y = af.f("soco");
    private static final int z = af.f("rtng");
    private static final int A = af.f("pgap");
    private static final int B = af.f("sosn");
    private static final int C = af.f("tvsh");
    private static final int D = af.f(com.anythink.expressad.exoplayer.g.b.i.f7358a);
    private static final String[] E = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    private f() {
    }

    public static a.InterfaceC0129a a(s sVar) {
        com.anythink.expressad.exoplayer.g.b.a aVar;
        com.anythink.expressad.exoplayer.g.b.k kVar;
        int c2 = sVar.c() + sVar.i();
        int i2 = sVar.i();
        int i3 = (i2 >> 24) & 255;
        com.anythink.expressad.exoplayer.g.b.e eVar = null;
        try {
            if (i3 == 169 || i3 == 65533) {
                int i4 = 16777215 & i2;
                if (i4 == d) {
                    int i5 = sVar.i();
                    if (sVar.i() == a.aK) {
                        sVar.d(8);
                        String e2 = sVar.e(i5 - 16);
                        eVar = new com.anythink.expressad.exoplayer.g.b.e("und", e2, e2);
                    } else {
                        Log.w(f7296a, "Failed to parse comment attribute: " + a.c(i2));
                    }
                    sVar.c(c2);
                    return eVar;
                }
                if (i4 != b && i4 != f7297c) {
                    if (i4 != i && i4 != j) {
                        if (i4 == e) {
                            return a(i2, "TDRC", sVar);
                        }
                        if (i4 == f) {
                            return a(i2, "TPE1", sVar);
                        }
                        if (i4 == g) {
                            return a(i2, "TSSE", sVar);
                        }
                        if (i4 == h) {
                            return a(i2, "TALB", sVar);
                        }
                        if (i4 == k) {
                            return a(i2, "USLT", sVar);
                        }
                        if (i4 == l) {
                            return a(i2, "TCON", sVar);
                        }
                        if (i4 == o) {
                            return a(i2, "TIT1", sVar);
                        }
                    }
                    return a(i2, "TCOM", sVar);
                }
                return a(i2, "TIT2", sVar);
            } else if (i2 == n) {
                int d2 = d(sVar);
                String str = (d2 <= 0 || d2 > E.length) ? null : E[d2 - 1];
                if (str != null) {
                    kVar = new com.anythink.expressad.exoplayer.g.b.k("TCON", null, str);
                } else {
                    Log.w(f7296a, "Failed to parse standard genre code");
                    kVar = null;
                }
                sVar.c(c2);
                return kVar;
            } else if (i2 == p) {
                return b(i2, "TPOS", sVar);
            } else {
                if (i2 == q) {
                    return b(i2, "TRCK", sVar);
                }
                if (i2 == r) {
                    return a(i2, "TBPM", sVar, true, false);
                }
                if (i2 == s) {
                    return a(i2, "TCMP", sVar, true, true);
                }
                if (i2 == m) {
                    int i6 = sVar.i();
                    if (sVar.i() == a.aK) {
                        int b2 = a.b(sVar.i());
                        String str2 = b2 == 13 ? ax.V : b2 == 14 ? ax.Z : null;
                        if (str2 == null) {
                            Log.w(f7296a, "Unrecognized cover art flags: ".concat(String.valueOf(b2)));
                            aVar = null;
                        } else {
                            sVar.d(4);
                            int i7 = i6 - 16;
                            byte[] bArr = new byte[i7];
                            sVar.a(bArr, 0, i7);
                            aVar = new com.anythink.expressad.exoplayer.g.b.a(str2, null, 3, bArr);
                        }
                    } else {
                        Log.w(f7296a, "Failed to parse cover art attribute");
                        aVar = null;
                    }
                    sVar.c(c2);
                    return aVar;
                } else if (i2 == t) {
                    return a(i2, "TPE2", sVar);
                } else {
                    if (i2 == u) {
                        return a(i2, "TSOT", sVar);
                    }
                    if (i2 == v) {
                        return a(i2, "TSO2", sVar);
                    }
                    if (i2 == w) {
                        return a(i2, "TSOA", sVar);
                    }
                    if (i2 == x) {
                        return a(i2, "TSOP", sVar);
                    }
                    if (i2 == y) {
                        return a(i2, "TSOC", sVar);
                    }
                    if (i2 == z) {
                        return a(i2, "ITUNESADVISORY", sVar, false, false);
                    }
                    if (i2 == A) {
                        return a(i2, "ITUNESGAPLESS", sVar, false, true);
                    }
                    if (i2 == B) {
                        return a(i2, "TVSHOWSORT", sVar);
                    }
                    if (i2 == C) {
                        return a(i2, "TVSHOW", sVar);
                    }
                    if (i2 == D) {
                        return a(sVar, c2);
                    }
                }
            }
            Log.d(f7296a, "Skipped unknown metadata entry: " + a.c(i2));
            sVar.c(c2);
            return null;
        } finally {
            sVar.c(c2);
        }
    }

    private static com.anythink.expressad.exoplayer.g.b.e a(int i2, s sVar) {
        int i3 = sVar.i();
        if (sVar.i() == a.aK) {
            sVar.d(8);
            String e2 = sVar.e(i3 - 16);
            return new com.anythink.expressad.exoplayer.g.b.e("und", e2, e2);
        }
        Log.w(f7296a, "Failed to parse comment attribute: " + a.c(i2));
        return null;
    }

    private static com.anythink.expressad.exoplayer.g.b.h a(int i2, String str, s sVar, boolean z2, boolean z3) {
        int d2 = d(sVar);
        int i3 = d2;
        if (z3) {
            i3 = Math.min(1, d2);
        }
        if (i3 >= 0) {
            return z2 ? new com.anythink.expressad.exoplayer.g.b.k(str, null, Integer.toString(i3)) : new com.anythink.expressad.exoplayer.g.b.e("und", str, Integer.toString(i3));
        }
        Log.w(f7296a, "Failed to parse uint8 attribute: " + a.c(i2));
        return null;
    }

    private static com.anythink.expressad.exoplayer.g.b.h a(s sVar, int i2) {
        String str = null;
        String str2 = null;
        int i3 = -1;
        int i4 = -1;
        while (sVar.c() < i2) {
            int c2 = sVar.c();
            int i5 = sVar.i();
            int i6 = sVar.i();
            sVar.d(4);
            if (i6 == a.aI) {
                str = sVar.e(i5 - 12);
            } else if (i6 == a.aJ) {
                str2 = sVar.e(i5 - 12);
            } else {
                if (i6 == a.aK) {
                    i3 = c2;
                    i4 = i5;
                }
                sVar.d(i5 - 12);
            }
        }
        if (str == null || str2 == null || i3 == -1) {
            return null;
        }
        sVar.c(i3);
        sVar.d(16);
        return new com.anythink.expressad.exoplayer.g.b.i(str, str2, sVar.e(i4 - 16));
    }

    private static com.anythink.expressad.exoplayer.g.b.k a(int i2, String str, s sVar) {
        int i3 = sVar.i();
        if (sVar.i() == a.aK) {
            sVar.d(8);
            return new com.anythink.expressad.exoplayer.g.b.k(str, null, sVar.e(i3 - 16));
        }
        Log.w(f7296a, "Failed to parse text attribute: " + a.c(i2));
        return null;
    }

    private static com.anythink.expressad.exoplayer.g.b.k b(int i2, String str, s sVar) {
        int i3 = sVar.i();
        if (sVar.i() == a.aK && i3 >= 22) {
            sVar.d(10);
            int e2 = sVar.e();
            if (e2 > 0) {
                String valueOf = String.valueOf(e2);
                int e3 = sVar.e();
                String str2 = valueOf;
                if (e3 > 0) {
                    str2 = valueOf + BridgeUtil.SPLIT_MARK + e3;
                }
                return new com.anythink.expressad.exoplayer.g.b.k(str, null, str2);
            }
        }
        Log.w(f7296a, "Failed to parse index/count attribute: " + a.c(i2));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.anythink.expressad.exoplayer.g.b.k b(com.anythink.expressad.exoplayer.k.s r6) {
        /*
            r0 = r6
            int r0 = d(r0)
            r7 = r0
            r0 = r7
            if (r0 <= 0) goto L1c
            java.lang.String[] r0 = com.anythink.expressad.exoplayer.e.a.f.E
            r6 = r0
            r0 = r7
            r1 = r6
            int r1 = r1.length
            if (r0 > r1) goto L1c
            r0 = r6
            r1 = r7
            r2 = 1
            int r1 = r1 - r2
            r0 = r0[r1]
            r6 = r0
            goto L1e
        L1c:
            r0 = 0
            r6 = r0
        L1e:
            r0 = r6
            if (r0 == 0) goto L2f
            com.anythink.expressad.exoplayer.g.b.k r0 = new com.anythink.expressad.exoplayer.g.b.k
            r1 = r0
            java.lang.String r2 = "TCON"
            r3 = 0
            r4 = r6
            r1.<init>(r2, r3, r4)
            return r0
        L2f:
            java.lang.String r0 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            int r0 = android.util.Log.w(r0, r1)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.e.a.f.b(com.anythink.expressad.exoplayer.k.s):com.anythink.expressad.exoplayer.g.b.k");
    }

    private static com.anythink.expressad.exoplayer.g.b.a c(s sVar) {
        int i2 = sVar.i();
        if (sVar.i() != a.aK) {
            Log.w(f7296a, "Failed to parse cover art attribute");
            return null;
        }
        int b2 = a.b(sVar.i());
        String str = b2 == 13 ? ax.V : b2 == 14 ? ax.Z : null;
        if (str == null) {
            Log.w(f7296a, "Unrecognized cover art flags: ".concat(String.valueOf(b2)));
            return null;
        }
        sVar.d(4);
        int i3 = i2 - 16;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        return new com.anythink.expressad.exoplayer.g.b.a(str, null, 3, bArr);
    }

    private static int d(s sVar) {
        sVar.d(4);
        if (sVar.i() == a.aK) {
            sVar.d(8);
            return sVar.d();
        }
        Log.w(f7296a, "Failed to parse uint8 attribute value");
        return -1;
    }
}
