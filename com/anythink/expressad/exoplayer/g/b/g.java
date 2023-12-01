package com.anythink.expressad.exoplayer.g.b;

import android.util.Log;
import android.widget.ExpandableListView;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.s;
import com.huawei.openalliance.ad.constant.ax;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.apache.commons.codec.CharEncoding;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/b/g.class */
public final class g implements com.anythink.expressad.exoplayer.g.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7354a = new a() { // from class: com.anythink.expressad.exoplayer.g.b.g.1
        @Override // com.anythink.expressad.exoplayer.g.b.g.a
        public final boolean a(int i2, int i3, int i4, int i5, int i6) {
            return false;
        }
    };
    public static final int b = af.f("ID3");

    /* renamed from: c  reason: collision with root package name */
    public static final int f7355c = 10;
    private static final String d = "Id3Decoder";
    private static final int e = 128;
    private static final int f = 64;
    private static final int g = 32;
    private static final int h = 8;
    private static final int i = 4;
    private static final int j = 64;
    private static final int k = 2;
    private static final int l = 1;
    private static final int m = 0;
    private static final int n = 1;
    private static final int o = 2;
    private static final int p = 3;
    private final a q;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/b/g$a.class */
    public interface a {
        boolean a(int i, int i2, int i3, int i4, int i5);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/b/g$b.class */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f7356a;
        private final boolean b;

        /* renamed from: c  reason: collision with root package name */
        private final int f7357c;

        public b(int i, boolean z, int i2) {
            this.f7356a = i;
            this.b = z;
            this.f7357c = i2;
        }
    }

    public g() {
        this(null);
    }

    private g(a aVar) {
        this.q = aVar;
    }

    private static int a(byte[] bArr, int i2, int i3) {
        int b2 = b(bArr, i2);
        if (i3 != 0) {
            int i4 = b2;
            if (i3 == 3) {
                return b2;
            }
            while (i4 < bArr.length - 1) {
                if (i4 % 2 == 0 && bArr[i4 + 1] == 0) {
                    return i4;
                }
                i4 = b(bArr, i4 + 1);
            }
            return bArr.length;
        }
        return b2;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0152 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.anythink.expressad.exoplayer.g.a a(byte[] r7, int r8) {
        /*
            Method dump skipped, instructions count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.g.b.g.a(byte[], int):com.anythink.expressad.exoplayer.g.a");
    }

    private static com.anythink.expressad.exoplayer.g.b.a a(s sVar, int i2, int i3) {
        int b2;
        String d2;
        int d3 = sVar.d();
        String a2 = a(d3);
        int i4 = i2 - 1;
        byte[] bArr = new byte[i4];
        sVar.a(bArr, 0, i4);
        if (i3 == 2) {
            String str = "image/" + af.d(new String(bArr, 0, 3, "ISO-8859-1"));
            d2 = str;
            if (ax.I.equals(str)) {
                d2 = ax.V;
            }
            b2 = 2;
        } else {
            b2 = b(bArr, 0);
            d2 = af.d(new String(bArr, 0, b2, "ISO-8859-1"));
            if (d2.indexOf(47) == -1) {
                d2 = "image/".concat(String.valueOf(d2));
            }
        }
        byte b3 = bArr[b2 + 1];
        int i5 = b2 + 2;
        int a3 = a(bArr, i5, d3);
        return new com.anythink.expressad.exoplayer.g.b.a(d2, new String(bArr, i5, a3 - i5, a2), b3 & 255, b(bArr, a3 + b(d3), i4));
    }

    private static c a(s sVar, int i2, int i3, boolean z, int i4, a aVar) {
        int c2 = sVar.c();
        int b2 = b(sVar.f7674a, c2);
        String str = new String(sVar.f7674a, c2, b2 - c2, "ISO-8859-1");
        sVar.c(b2 + 1);
        int i5 = sVar.i();
        int i6 = sVar.i();
        long h2 = sVar.h();
        if (h2 == ExpandableListView.PACKED_POSITION_VALUE_NULL) {
            h2 = -1;
        }
        long h3 = sVar.h();
        if (h3 == ExpandableListView.PACKED_POSITION_VALUE_NULL) {
            h3 = -1;
        }
        ArrayList arrayList = new ArrayList();
        while (sVar.c() < c2 + i2) {
            h a2 = a(i3, sVar, z, i4, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        h[] hVarArr = new h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new c(str, i5, i6, h2, h3, hVarArr);
    }

    private static b a(s sVar) {
        int i2;
        if (sVar.a() < 10) {
            Log.w(d, "Data too short to be an ID3 tag");
            return null;
        }
        int g2 = sVar.g();
        if (g2 != b) {
            Log.w(d, "Unexpected first three bytes of ID3 tag header: ".concat(String.valueOf(g2)));
            return null;
        }
        int d2 = sVar.d();
        boolean z = true;
        sVar.d(1);
        int d3 = sVar.d();
        int l2 = sVar.l();
        if (d2 == 2) {
            i2 = l2;
            if ((d3 & 64) != 0) {
                Log.w(d, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (d2 == 3) {
            i2 = l2;
            if ((d3 & 64) != 0) {
                int i3 = sVar.i();
                sVar.d(i3);
                i2 = l2 - (i3 + 4);
            }
        } else if (d2 != 4) {
            Log.w(d, "Skipped ID3 tag with unsupported majorVersion=".concat(String.valueOf(d2)));
            return null;
        } else {
            int i4 = l2;
            if ((d3 & 64) != 0) {
                int l3 = sVar.l();
                sVar.d(l3 - 4);
                i4 = l2 - l3;
            }
            i2 = i4;
            if ((d3 & 16) != 0) {
                i2 = i4 - 10;
            }
        }
        if (d2 >= 4 || (d3 & 128) == 0) {
            z = false;
        }
        return new b(d2, z, i2);
    }

    private static h a(int i2, s sVar, boolean z, int i3, a aVar) {
        int m2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i4;
        h fVar;
        String str;
        int i5;
        int d2 = sVar.d();
        int d3 = sVar.d();
        int d4 = sVar.d();
        int d5 = i2 >= 3 ? sVar.d() : 0;
        if (i2 == 4) {
            int m3 = sVar.m();
            m2 = m3;
            if (!z) {
                m2 = (((m3 >> 24) & 255) << 21) | (m3 & 255) | (((m3 >> 8) & 255) << 7) | (((m3 >> 16) & 255) << 14);
            }
        } else {
            m2 = i2 == 3 ? sVar.m() : sVar.g();
        }
        int i6 = m2;
        int e2 = i2 >= 3 ? sVar.e() : 0;
        if (d2 == 0 && d3 == 0 && d4 == 0 && d5 == 0 && i6 == 0 && e2 == 0) {
            sVar.c(sVar.b());
            return null;
        }
        int c2 = sVar.c() + i6;
        if (c2 > sVar.b()) {
            Log.w(d, "Frame size exceeds remaining tag data");
            sVar.c(sVar.b());
            return null;
        } else if (aVar != null && !aVar.a(i2, d2, d3, d4, d5)) {
            sVar.c(c2);
            return null;
        } else {
            int i7 = e2;
            if (i2 == 3) {
                z3 = (i7 & 128) != 0;
                z5 = (i7 & 64) != 0;
                z4 = z3;
                z2 = (i7 & 32) != 0;
                z6 = false;
            } else if (i2 == 4) {
                z2 = (i7 & 64) != 0;
                boolean z7 = (i7 & 8) != 0;
                z5 = (i7 & 4) != 0;
                boolean z8 = (i7 & 2) != 0;
                if ((i7 & 1) != 0) {
                    z3 = true;
                    z4 = z7;
                    z6 = z8;
                } else {
                    z3 = false;
                    z4 = z7;
                    z6 = z8;
                }
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
                z6 = false;
            }
            if (z4 || z5) {
                Log.w(d, "Skipping unsupported compressed or encrypted frame");
                sVar.c(c2);
                return null;
            }
            int i8 = i6;
            if (z2) {
                i8 = i6 - 1;
                sVar.d(1);
            }
            int i9 = i8;
            if (z3) {
                i9 = i8 - 4;
                sVar.d(4);
            }
            int i10 = i9;
            if (z6) {
                i10 = f(sVar, i9);
            }
            try {
                try {
                    try {
                        if (d2 == 84 && d3 == 88 && d4 == 88 && (i2 == 2 || d5 == 88)) {
                            if (i10 > 0) {
                                int d6 = sVar.d();
                                String a2 = a(d6);
                                int i11 = i10 - 1;
                                byte[] bArr = new byte[i11];
                                sVar.a(bArr, 0, i11);
                                int a3 = a(bArr, 0, d6);
                                String str2 = new String(bArr, 0, a3, a2);
                                int b2 = a3 + b(d6);
                                fVar = new k("TXXX", str2, a(bArr, b2, a(bArr, b2, d6), a2));
                            }
                            fVar = null;
                        } else if (d2 == 84) {
                            String a4 = a(i2, d2, d3, d4, d5);
                            if (i10 > 0) {
                                int d7 = sVar.d();
                                String a5 = a(d7);
                                int i12 = i10 - 1;
                                byte[] bArr2 = new byte[i12];
                                sVar.a(bArr2, 0, i12);
                                fVar = new k(a4, null, new String(bArr2, 0, a(bArr2, 0, d7), a5));
                            }
                            fVar = null;
                        } else if (d2 == 87 && d3 == 88 && d4 == 88 && (i2 == 2 || d5 == 88)) {
                            if (i10 > 0) {
                                int d8 = sVar.d();
                                String a6 = a(d8);
                                int i13 = i10 - 1;
                                byte[] bArr3 = new byte[i13];
                                sVar.a(bArr3, 0, i13);
                                int a7 = a(bArr3, 0, d8);
                                String str3 = new String(bArr3, 0, a7, a6);
                                int b3 = a7 + b(d8);
                                fVar = new l("WXXX", str3, a(bArr3, b3, b(bArr3, b3), "ISO-8859-1"));
                            }
                            fVar = null;
                        } else if (d2 == 87) {
                            String a8 = a(i2, d2, d3, d4, d5);
                            byte[] bArr4 = new byte[i10];
                            sVar.a(bArr4, 0, i10);
                            fVar = new l(a8, null, new String(bArr4, 0, b(bArr4, 0), "ISO-8859-1"));
                        } else if (d2 == 80 && d3 == 82 && d4 == 73 && d5 == 86) {
                            byte[] bArr5 = new byte[i10];
                            sVar.a(bArr5, 0, i10);
                            int b4 = b(bArr5, 0);
                            fVar = new j(new String(bArr5, 0, b4, "ISO-8859-1"), b(bArr5, b4 + 1, i10));
                        } else if (d2 == 71 && d3 == 69 && d4 == 79 && (d5 == 66 || i2 == 2)) {
                            int d9 = sVar.d();
                            String a9 = a(d9);
                            int i14 = i10 - 1;
                            byte[] bArr6 = new byte[i14];
                            sVar.a(bArr6, 0, i14);
                            int b5 = b(bArr6, 0);
                            String str4 = new String(bArr6, 0, b5, "ISO-8859-1");
                            int i15 = b5 + 1;
                            int a10 = a(bArr6, i15, d9);
                            String a11 = a(bArr6, i15, a10, a9);
                            int b6 = a10 + b(d9);
                            int a12 = a(bArr6, b6, d9);
                            fVar = new f(str4, a11, a(bArr6, b6, a12, a9), b(bArr6, a12 + b(d9), i14));
                        } else {
                            try {
                                if (i2 != 2 ? d2 == 65 && d3 == 80 && d4 == 73 && d5 == 67 : d2 == 80 && d3 == 73 && d4 == 67) {
                                    try {
                                        int d10 = sVar.d();
                                        String a13 = a(d10);
                                        int i16 = i10 - 1;
                                        byte[] bArr7 = new byte[i16];
                                        sVar.a(bArr7, 0, i16);
                                        if (i2 == 2) {
                                            StringBuilder sb = new StringBuilder("image/");
                                            sb.append(af.d(new String(bArr7, 0, 3, "ISO-8859-1")));
                                            String sb2 = sb.toString();
                                            str = sb2;
                                            if (ax.I.equals(sb2)) {
                                                str = ax.V;
                                            }
                                            i5 = 2;
                                        } else {
                                            int b7 = b(bArr7, 0);
                                            String d11 = af.d(new String(bArr7, 0, b7, "ISO-8859-1"));
                                            str = d11;
                                            i5 = b7;
                                            if (d11.indexOf(47) == -1) {
                                                str = "image/".concat(String.valueOf(d11));
                                                i5 = b7;
                                            }
                                        }
                                        byte b8 = bArr7[i5 + 1];
                                        int i17 = i5 + 2;
                                        int a14 = a(bArr7, i17, d10);
                                        fVar = new com.anythink.expressad.exoplayer.g.b.a(str, new String(bArr7, i17, a14 - i17, a13), b8 & 255, b(bArr7, a14 + b(d10), i16));
                                    } catch (UnsupportedEncodingException e3) {
                                        i4 = c2;
                                        try {
                                            Log.w(d, "Unsupported character encoding");
                                            sVar.c(i4);
                                            return null;
                                        } catch (Throwable th) {
                                            th = th;
                                            sVar.c(i4);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        i4 = c2;
                                        sVar.c(i4);
                                        throw th;
                                    }
                                } else if (d2 == 67 && d3 == 79 && d4 == 77 && (d5 == 77 || i2 == 2)) {
                                    if (i10 < 4) {
                                        fVar = null;
                                    } else {
                                        int d12 = sVar.d();
                                        String a15 = a(d12);
                                        byte[] bArr8 = new byte[3];
                                        sVar.a(bArr8, 0, 3);
                                        String str5 = new String(bArr8, 0, 3);
                                        int i18 = i10 - 4;
                                        byte[] bArr9 = new byte[i18];
                                        sVar.a(bArr9, 0, i18);
                                        int a16 = a(bArr9, 0, d12);
                                        String str6 = new String(bArr9, 0, a16, a15);
                                        int b9 = a16 + b(d12);
                                        fVar = new e(str5, str6, a(bArr9, b9, a(bArr9, b9, d12), a15));
                                    }
                                } else if (d2 == 67 && d3 == 72 && d4 == 65 && d5 == 80) {
                                    fVar = a(sVar, i10, i2, z, i3, aVar);
                                } else if (d2 == 67 && d3 == 84 && d4 == 79 && d5 == 67) {
                                    fVar = b(sVar, i10, i2, z, i3, aVar);
                                } else {
                                    String a17 = a(i2, d2, d3, d4, d5);
                                    byte[] bArr10 = new byte[i10];
                                    sVar.a(bArr10, 0, i10);
                                    fVar = new com.anythink.expressad.exoplayer.g.b.b(a17, bArr10);
                                }
                            } catch (UnsupportedEncodingException e4) {
                                i4 = c2;
                                Log.w(d, "Unsupported character encoding");
                                sVar.c(i4);
                                return null;
                            } catch (Throwable th3) {
                                th = th3;
                                i4 = c2;
                                sVar.c(i4);
                                throw th;
                            }
                        }
                        if (fVar == null) {
                            try {
                                Log.w(d, "Failed to decode frame: id=" + a(i2, d2, d3, d4, d5) + ", frameSize=" + i10);
                            } catch (UnsupportedEncodingException e5) {
                                i4 = c2;
                                Log.w(d, "Unsupported character encoding");
                                sVar.c(i4);
                                return null;
                            }
                        }
                        sVar.c(c2);
                        return fVar;
                    } catch (UnsupportedEncodingException e6) {
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (UnsupportedEncodingException e7) {
            }
        }
    }

    private static k a(s sVar, int i2) {
        if (i2 <= 0) {
            return null;
        }
        int d2 = sVar.d();
        String a2 = a(d2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        int a3 = a(bArr, 0, d2);
        String str = new String(bArr, 0, a3, a2);
        int b2 = a3 + b(d2);
        return new k("TXXX", str, a(bArr, b2, a(bArr, b2, d2), a2));
    }

    private static k a(s sVar, int i2, String str) {
        if (i2 <= 0) {
            return null;
        }
        int d2 = sVar.d();
        String a2 = a(d2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        return new k(str, null, new String(bArr, 0, a(bArr, 0, d2), a2));
    }

    private static String a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "ISO-8859-1" : "UTF-8" : CharEncoding.UTF_16BE : "UTF-16";
    }

    private static String a(int i2, int i3, int i4, int i5, int i6) {
        return i2 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    private static String a(byte[] bArr, int i2, int i3, String str) {
        return (i3 <= i2 || i3 > bArr.length) ? "" : new String(bArr, i2, i3 - i2, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cd, code lost:
        if ((r15 & 1) != 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d0, code lost:
        r13 = r14;
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fe, code lost:
        if ((r15 & 128) != 0) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.anythink.expressad.exoplayer.k.s r9, int r10, int r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.g.b.g.a(com.anythink.expressad.exoplayer.k.s, int, int, boolean):boolean");
    }

    private static int b(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    private static int b(byte[] bArr, int i2) {
        while (i2 < bArr.length) {
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
        return bArr.length;
    }

    private static d b(s sVar, int i2, int i3, boolean z, int i4, a aVar) {
        int c2 = sVar.c();
        int b2 = b(sVar.f7674a, c2);
        String str = new String(sVar.f7674a, c2, b2 - c2, "ISO-8859-1");
        sVar.c(b2 + 1);
        int d2 = sVar.d();
        boolean z2 = (d2 & 2) != 0;
        boolean z3 = (d2 & 1) != 0;
        int d3 = sVar.d();
        String[] strArr = new String[d3];
        for (int i5 = 0; i5 < d3; i5++) {
            int c3 = sVar.c();
            int b3 = b(sVar.f7674a, c3);
            strArr[i5] = new String(sVar.f7674a, c3, b3 - c3, "ISO-8859-1");
            sVar.c(b3 + 1);
        }
        ArrayList arrayList = new ArrayList();
        while (sVar.c() < c2 + i2) {
            h a2 = a(i3, sVar, z, i4, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        h[] hVarArr = new h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new d(str, z2, z3, strArr, hVarArr);
    }

    private static l b(s sVar, int i2) {
        if (i2 <= 0) {
            return null;
        }
        int d2 = sVar.d();
        String a2 = a(d2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        int a3 = a(bArr, 0, d2);
        String str = new String(bArr, 0, a3, a2);
        int b2 = a3 + b(d2);
        return new l("WXXX", str, a(bArr, b2, b(bArr, b2), "ISO-8859-1"));
    }

    private static l b(s sVar, int i2, String str) {
        byte[] bArr = new byte[i2];
        sVar.a(bArr, 0, i2);
        return new l(str, null, new String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    private static byte[] b(byte[] bArr, int i2, int i3) {
        return i3 <= i2 ? new byte[0] : Arrays.copyOfRange(bArr, i2, i3);
    }

    private static com.anythink.expressad.exoplayer.g.b.b c(s sVar, int i2, String str) {
        byte[] bArr = new byte[i2];
        sVar.a(bArr, 0, i2);
        return new com.anythink.expressad.exoplayer.g.b.b(str, bArr);
    }

    private static j c(s sVar, int i2) {
        byte[] bArr = new byte[i2];
        sVar.a(bArr, 0, i2);
        int b2 = b(bArr, 0);
        return new j(new String(bArr, 0, b2, "ISO-8859-1"), b(bArr, b2 + 1, i2));
    }

    private static f d(s sVar, int i2) {
        int d2 = sVar.d();
        String a2 = a(d2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        int b2 = b(bArr, 0);
        String str = new String(bArr, 0, b2, "ISO-8859-1");
        int i4 = b2 + 1;
        int a3 = a(bArr, i4, d2);
        String a4 = a(bArr, i4, a3, a2);
        int b3 = a3 + b(d2);
        int a5 = a(bArr, b3, d2);
        return new f(str, a4, a(bArr, b3, a5, a2), b(bArr, a5 + b(d2), i3));
    }

    private static e e(s sVar, int i2) {
        if (i2 < 4) {
            return null;
        }
        int d2 = sVar.d();
        String a2 = a(d2);
        byte[] bArr = new byte[3];
        sVar.a(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        sVar.a(bArr2, 0, i3);
        int a3 = a(bArr2, 0, d2);
        String str2 = new String(bArr2, 0, a3, a2);
        int b2 = a3 + b(d2);
        return new e(str, str2, a(bArr2, b2, a(bArr2, b2, d2), a2));
    }

    private static int f(s sVar, int i2) {
        byte[] bArr = sVar.f7674a;
        int c2 = sVar.c();
        while (true) {
            int i3 = c2 + 1;
            if (i3 >= i2) {
                return i2;
            }
            int i4 = i2;
            if ((bArr[c2] & 255) == 255) {
                i4 = i2;
                if (bArr[i3] == 0) {
                    System.arraycopy((Object) bArr, c2 + 2, (Object) bArr, i3, (i2 - c2) - 2);
                    i4 = i2 - 1;
                }
            }
            c2 = i3;
            i2 = i4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0164 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0166  */
    @Override // com.anythink.expressad.exoplayer.g.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.anythink.expressad.exoplayer.g.a a(com.anythink.expressad.exoplayer.g.e r7) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.g.b.g.a(com.anythink.expressad.exoplayer.g.e):com.anythink.expressad.exoplayer.g.a");
    }
}
