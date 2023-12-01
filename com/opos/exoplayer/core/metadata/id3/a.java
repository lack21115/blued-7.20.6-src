package com.opos.exoplayer.core.metadata.id3;

import com.huawei.openalliance.ad.constant.ax;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.d;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/id3/a.class */
public final class a implements com.opos.exoplayer.core.metadata.a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f11850a = u.f("ID3");
    private final InterfaceC0497a b;

    /* renamed from: com.opos.exoplayer.core.metadata.id3.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/id3/a$a.class */
    public interface InterfaceC0497a {
        boolean a(int i, int i2, int i3, int i4, int i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/id3/a$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f11851a;
        private final boolean b;

        /* renamed from: c  reason: collision with root package name */
        private final int f11852c;

        public b(int i, boolean z, int i2) {
            this.f11851a = i;
            this.b = z;
            this.f11852c = i2;
        }
    }

    public a() {
        this(null);
    }

    public a(InterfaceC0497a interfaceC0497a) {
        this.b = interfaceC0497a;
    }

    private static int a(byte[] bArr, int i, int i2) {
        int b2 = b(bArr, i);
        int i3 = b2;
        if (i2 != 0) {
            int i4 = b2;
            if (i2 == 3) {
                return b2;
            }
            while (i4 < bArr.length - 1) {
                if (i4 % 2 == 0 && bArr[i4 + 1] == 0) {
                    return i4;
                }
                i4 = b(bArr, i4 + 1);
            }
            i3 = bArr.length;
        }
        return i3;
    }

    private static ApicFrame a(m mVar, int i, int i2) {
        int b2;
        String d;
        int g = mVar.g();
        String a2 = a(g);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        mVar.a(bArr, 0, i3);
        if (i2 == 2) {
            String str = "image/" + u.d(new String(bArr, 0, 3, "ISO-8859-1"));
            d = str;
            if (str.equals(ax.I)) {
                d = ax.V;
            }
            b2 = 2;
        } else {
            b2 = b(bArr, 0);
            d = u.d(new String(bArr, 0, b2, "ISO-8859-1"));
            if (d.indexOf(47) == -1) {
                d = "image/" + d;
            }
        }
        byte b3 = bArr[b2 + 1];
        int i4 = b2 + 2;
        int a3 = a(bArr, i4, g);
        return new ApicFrame(d, new String(bArr, i4, a3 - i4, a2), b3 & 255, b(bArr, b(g) + a3, i3));
    }

    private static ChapterFrame a(m mVar, int i, int i2, boolean z, int i3, InterfaceC0497a interfaceC0497a) {
        int d = mVar.d();
        int b2 = b(mVar.f11808a, d);
        String str = new String(mVar.f11808a, d, b2 - d, "ISO-8859-1");
        mVar.c(b2 + 1);
        int o = mVar.o();
        int o2 = mVar.o();
        long m = mVar.m();
        if (m == 4294967295L) {
            m = -1;
        }
        long m2 = mVar.m();
        if (m2 == 4294967295L) {
            m2 = -1;
        }
        ArrayList arrayList = new ArrayList();
        while (mVar.d() < d + i) {
            Id3Frame a2 = a(i2, mVar, z, i3, interfaceC0497a);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, o, o2, m, m2, id3FrameArr);
    }

    private static Id3Frame a(int i, m mVar, boolean z, int i2, InterfaceC0497a interfaceC0497a) {
        int u;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int g = mVar.g();
        int g2 = mVar.g();
        int g3 = mVar.g();
        int g4 = i >= 3 ? mVar.g() : 0;
        if (i == 4) {
            int u2 = mVar.u();
            u = u2;
            if (!z) {
                u = (((u2 >> 24) & 255) << 21) | (u2 & 255) | (((u2 >> 8) & 255) << 7) | (((u2 >> 16) & 255) << 14);
            }
        } else {
            u = i == 3 ? mVar.u() : mVar.k();
        }
        int i3 = u;
        int h = i >= 3 ? mVar.h() : 0;
        if (g != 0 || g2 != 0 || g3 != 0 || g4 != 0 || i3 != 0 || h != 0) {
            int d = mVar.d() + i3;
            if (d <= mVar.c()) {
                if (interfaceC0497a == null || interfaceC0497a.a(i, g, g2, g3, g4)) {
                    int i4 = h;
                    if (i == 3) {
                        boolean z7 = (i4 & 128) != 0;
                        z4 = (i4 & 64) != 0;
                        z2 = (i4 & 32) != 0;
                        z6 = z7;
                        z3 = z7;
                        z5 = false;
                    } else if (i == 4) {
                        boolean z8 = (i4 & 64) != 0;
                        boolean z9 = (i4 & 8) != 0;
                        z4 = (i4 & 4) != 0;
                        z5 = (i4 & 2) != 0;
                        z6 = z9;
                        z2 = z8;
                        z3 = (i4 & 1) != 0;
                    } else {
                        z2 = false;
                        z3 = false;
                        z4 = false;
                        z5 = false;
                        z6 = false;
                    }
                    if (z6 || z4) {
                        com.opos.cmn.an.f.a.c("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
                    } else {
                        int i5 = i3;
                        if (z2) {
                            i5 = i3 - 1;
                            mVar.d(1);
                        }
                        int i6 = i5;
                        if (z3) {
                            i6 = i5 - 4;
                            mVar.d(4);
                        }
                        int i7 = i6;
                        if (z5) {
                            i7 = f(mVar, i6);
                        }
                        try {
                            try {
                                Id3Frame a2 = (g == 84 && g2 == 88 && g3 == 88 && (i == 2 || g4 == 88)) ? a(mVar, i7) : g == 84 ? a(mVar, i7, a(i, g, g2, g3, g4)) : (g == 87 && g2 == 88 && g3 == 88 && (i == 2 || g4 == 88)) ? b(mVar, i7) : g == 87 ? b(mVar, i7, a(i, g, g2, g3, g4)) : (g == 80 && g2 == 82 && g3 == 73 && g4 == 86) ? c(mVar, i7) : (g == 71 && g2 == 69 && g3 == 79 && (g4 == 66 || i == 2)) ? d(mVar, i7) : (i != 2 ? !(g == 65 && g2 == 80 && g3 == 73 && g4 == 67) : !(g == 80 && g2 == 73 && g3 == 67)) ? (g == 67 && g2 == 79 && g3 == 77 && (g4 == 77 || i == 2)) ? e(mVar, i7) : (g == 67 && g2 == 72 && g3 == 65 && g4 == 80) ? a(mVar, i7, i, z, i2, interfaceC0497a) : (g == 67 && g2 == 84 && g3 == 79 && g4 == 67) ? b(mVar, i7, i, z, i2, interfaceC0497a) : c(mVar, i7, a(i, g, g2, g3, g4)) : a(mVar, i7, i);
                                if (a2 == null) {
                                    com.opos.cmn.an.f.a.c("Id3Decoder", "Failed to decode frame: id=" + a(i, g, g2, g3, g4) + ", frameSize=" + i7);
                                }
                                mVar.c(d);
                                return a2;
                            } catch (UnsupportedEncodingException e) {
                                com.opos.cmn.an.f.a.c("Id3Decoder", "Unsupported character encoding");
                            }
                        } catch (Throwable th) {
                            mVar.c(d);
                            throw th;
                        }
                    }
                }
                mVar.c(d);
                return null;
            }
            com.opos.cmn.an.f.a.c("Id3Decoder", "Frame size exceeds remaining tag data");
        }
        mVar.c(mVar.c());
        return null;
    }

    private static TextInformationFrame a(m mVar, int i) {
        if (i < 1) {
            return null;
        }
        int g = mVar.g();
        String a2 = a(g);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        mVar.a(bArr, 0, i2);
        int a3 = a(bArr, 0, g);
        String str = new String(bArr, 0, a3, a2);
        int b2 = a3 + b(g);
        return new TextInformationFrame("TXXX", str, a(bArr, b2, a(bArr, b2, g), a2));
    }

    private static TextInformationFrame a(m mVar, int i, String str) {
        if (i < 1) {
            return null;
        }
        int g = mVar.g();
        String a2 = a(g);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        mVar.a(bArr, 0, i2);
        return new TextInformationFrame(str, null, new String(bArr, 0, a(bArr, 0, g), a2));
    }

    private static b a(m mVar) {
        StringBuilder sb;
        String str;
        int i;
        String str2;
        if (mVar.b() < 10) {
            str2 = "Data too short to be an ID3 tag";
        } else {
            int k = mVar.k();
            if (k == f11850a) {
                int g = mVar.g();
                boolean z = true;
                mVar.d(1);
                int g2 = mVar.g();
                int t = mVar.t();
                if (g == 2) {
                    i = t;
                    if ((g2 & 64) != 0) {
                        str2 = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme";
                    }
                } else if (g == 3) {
                    i = t;
                    if ((g2 & 64) != 0) {
                        int o = mVar.o();
                        mVar.d(o);
                        i = t - (o + 4);
                    }
                } else if (g == 4) {
                    int i2 = t;
                    if ((g2 & 64) != 0) {
                        int t2 = mVar.t();
                        mVar.d(t2 - 4);
                        i2 = t - t2;
                    }
                    i = i2;
                    if ((g2 & 16) != 0) {
                        i = i2 - 10;
                    }
                } else {
                    sb = new StringBuilder();
                    str = "Skipped ID3 tag with unsupported majorVersion=";
                    k = g;
                }
                if (g >= 4 || (g2 & 128) == 0) {
                    z = false;
                }
                return new b(g, z, i);
            }
            sb = new StringBuilder();
            str = "Unexpected first three bytes of ID3 tag header: ";
            sb.append(str);
            sb.append(k);
            str2 = sb.toString();
        }
        com.opos.cmn.an.f.a.c("Id3Decoder", str2);
        return null;
    }

    private static String a(int i) {
        String str = "ISO-8859-1";
        if (i != 0) {
            if (i != 1) {
                return i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE";
            }
            str = com.anythink.expressad.exoplayer.b.k;
        }
        return str;
    }

    private static String a(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static String a(byte[] bArr, int i, int i2, String str) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012b A[Catch: all -> 0x014b, TRY_ENTER, TryCatch #0 {all -> 0x014b, blocks: (B:3:0x0006, B:8:0x001a, B:53:0x012b, B:56:0x0139, B:9:0x002f), top: B:62:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0073 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.opos.exoplayer.core.i.m r9, int r10, int r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.metadata.id3.a.a(com.opos.exoplayer.core.i.m, int, int, boolean):boolean");
    }

    private static int b(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int b(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static ChapterTocFrame b(m mVar, int i, int i2, boolean z, int i3, InterfaceC0497a interfaceC0497a) {
        int d = mVar.d();
        int b2 = b(mVar.f11808a, d);
        String str = new String(mVar.f11808a, d, b2 - d, "ISO-8859-1");
        mVar.c(b2 + 1);
        int g = mVar.g();
        boolean z2 = (g & 2) != 0;
        boolean z3 = (g & 1) != 0;
        int g2 = mVar.g();
        String[] strArr = new String[g2];
        for (int i4 = 0; i4 < g2; i4++) {
            int d2 = mVar.d();
            int b3 = b(mVar.f11808a, d2);
            strArr[i4] = new String(mVar.f11808a, d2, b3 - d2, "ISO-8859-1");
            mVar.c(b3 + 1);
        }
        ArrayList arrayList = new ArrayList();
        while (mVar.d() < d + i) {
            Id3Frame a2 = a(i2, mVar, z, i3, interfaceC0497a);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    private static UrlLinkFrame b(m mVar, int i) {
        if (i < 1) {
            return null;
        }
        int g = mVar.g();
        String a2 = a(g);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        mVar.a(bArr, 0, i2);
        int a3 = a(bArr, 0, g);
        String str = new String(bArr, 0, a3, a2);
        int b2 = b(g) + a3;
        return new UrlLinkFrame("WXXX", str, a(bArr, b2, b(bArr, b2), "ISO-8859-1"));
    }

    private static UrlLinkFrame b(m mVar, int i, String str) {
        byte[] bArr = new byte[i];
        mVar.a(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    private static byte[] b(byte[] bArr, int i, int i2) {
        return i2 <= i ? new byte[0] : Arrays.copyOfRange(bArr, i, i2);
    }

    private static BinaryFrame c(m mVar, int i, String str) {
        byte[] bArr = new byte[i];
        mVar.a(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    private static PrivFrame c(m mVar, int i) {
        byte[] bArr = new byte[i];
        mVar.a(bArr, 0, i);
        int b2 = b(bArr, 0);
        return new PrivFrame(new String(bArr, 0, b2, "ISO-8859-1"), b(bArr, b2 + 1, i));
    }

    private static GeobFrame d(m mVar, int i) {
        int g = mVar.g();
        String a2 = a(g);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        mVar.a(bArr, 0, i2);
        int b2 = b(bArr, 0);
        String str = new String(bArr, 0, b2, "ISO-8859-1");
        int i3 = b2 + 1;
        int a3 = a(bArr, i3, g);
        String a4 = a(bArr, i3, a3, a2);
        int b3 = a3 + b(g);
        int a5 = a(bArr, b3, g);
        return new GeobFrame(str, a4, a(bArr, b3, a5, a2), b(bArr, b(g) + a5, i2));
    }

    private static CommentFrame e(m mVar, int i) {
        if (i < 4) {
            return null;
        }
        int g = mVar.g();
        String a2 = a(g);
        byte[] bArr = new byte[3];
        mVar.a(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        mVar.a(bArr2, 0, i2);
        int a3 = a(bArr2, 0, g);
        String str2 = new String(bArr2, 0, a3, a2);
        int b2 = a3 + b(g);
        return new CommentFrame(str, str2, a(bArr2, b2, a(bArr2, b2, g), a2));
    }

    private static int f(m mVar, int i) {
        byte[] bArr = mVar.f11808a;
        int d = mVar.d();
        while (true) {
            int i2 = d + 1;
            if (i2 >= i) {
                return i;
            }
            int i3 = i;
            if ((bArr[d] & 255) == 255) {
                i3 = i;
                if (bArr[i2] == 0) {
                    System.arraycopy(bArr, d + 2, bArr, i2, (i - d) - 2);
                    i3 = i - 1;
                }
            }
            d = i2;
            i = i3;
        }
    }

    @Override // com.opos.exoplayer.core.metadata.a
    public Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.b;
        return a(byteBuffer.array(), byteBuffer.limit());
    }

    public Metadata a(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        m mVar = new m(bArr, i);
        b a2 = a(mVar);
        if (a2 == null) {
            return null;
        }
        int d = mVar.d();
        int i2 = a2.f11851a == 2 ? 6 : 10;
        int i3 = a2.f11852c;
        if (a2.b) {
            i3 = f(mVar, a2.f11852c);
        }
        mVar.b(i3 + d);
        boolean z = false;
        if (!a(mVar, a2.f11851a, i2, false)) {
            if (a2.f11851a != 4 || !a(mVar, 4, i2, true)) {
                com.opos.cmn.an.f.a.c("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + a2.f11851a);
                return null;
            }
            z = true;
        }
        while (mVar.b() >= i2) {
            Id3Frame a3 = a(a2.f11851a, mVar, z, i2, this.b);
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return new Metadata(arrayList);
    }
}
