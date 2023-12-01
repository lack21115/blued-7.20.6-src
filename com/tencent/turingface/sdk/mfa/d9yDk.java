package com.tencent.turingface.sdk.mfa;

import android.app.backup.FullBackup;
import android.text.Spanned;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/d9yDk.class */
public final class d9yDk {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f26252a = {"px", t.q, FullBackup.SHAREDPREFS_TREE_TOKEN, "pt", "in", "mm"};
    public e7l68 b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f26253c = new HashMap();
    public byte[] d;
    public String[] e;
    public int[] f;
    public int g;
    public int h;
    public int i;
    public int j;

    public final int a(int i) {
        byte[] bArr = this.d;
        return ((bArr[i + 0] << 0) & 255) | ((bArr[i + 3] << 24) & (-16777216)) | ((bArr[i + 2] << 16) & Spanned.SPAN_PRIORITY) | ((bArr[i + 1] << 8) & 65280);
    }

    /* JADX WARN: Type inference failed for: r0v129, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v45, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r1v37, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r1v86, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.HashMap] */
    public final Document a(InputStream inputStream) throws IOException, ParserConfigurationException {
        String b;
        String str;
        String format;
        byte[] bArr;
        e7l68 e7l68Var = new e7l68();
        this.b = e7l68Var;
        byte[] bArr2 = new byte[inputStream.available()];
        this.d = bArr2;
        inputStream.read(bArr2);
        inputStream.close();
        while (true) {
            int i = this.j;
            if (i >= this.d.length) {
                this.b.getClass();
                return e7l68Var.b;
            }
            int a2 = a(i);
            if (a2 == -1) {
                this.b.getClass();
            } else if (a2 == 524291) {
                e7l68 e7l68Var2 = this.b;
                Document newDocument = e7l68Var2.f26255c.newDocument();
                e7l68Var2.b = newDocument;
                e7l68Var2.f26254a.push(newDocument);
                this.j += 8;
            } else if (a2 == 524672) {
                int a3 = a(this.j + 4);
                int i2 = (a3 / 4) - 2;
                this.i = i2;
                this.f = new int[i2];
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < this.i) {
                        this.f[i4] = a(((i4 + 2) * 4) + this.j);
                        i3 = i4 + 1;
                    } else {
                        this.j += a3;
                    }
                }
            } else if (a2 != 1835009) {
                switch (a2) {
                    case 1048832:
                        a(true);
                        continue;
                    case 1048833:
                        a(false);
                        continue;
                    case 1048834:
                        int a4 = a(this.j + 16);
                        int a5 = a(this.j + 20);
                        int i5 = this.j + 28;
                        byte[] bArr3 = this.d;
                        int i6 = (65280 & (bArr3[i5 + 1] << 8)) | ((bArr3[i5 + 0] << 0) & 255);
                        String b2 = b(a5);
                        if (a4 == -1) {
                            str = b2;
                            b = "";
                        } else {
                            b = b(a4);
                            if (this.f26253c.containsKey(b)) {
                                str = ((String) this.f26253c.get(b)) + ':' + b2;
                            } else {
                                str = b2;
                            }
                        }
                        this.j += 36;
                        tLlmS[] tllmsArr = new tLlmS[i6];
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 < i6) {
                                int a6 = a(this.j);
                                int a7 = a(this.j + 4);
                                int a8 = a(this.j + 8);
                                int a9 = a(this.j + 12);
                                int a10 = a(this.j + 16);
                                tLlmS tllms = new tLlmS();
                                tllms.f26301a = b(a7);
                                if (a6 == -1) {
                                    tllms.f26302c = null;
                                    tllms.b = null;
                                } else {
                                    String b3 = b(a6);
                                    if (this.f26253c.containsKey(b3)) {
                                        tllms.f26302c = b3;
                                        tllms.b = (String) this.f26253c.get(b3);
                                    }
                                }
                                if (a8 == -1) {
                                    switch (a9) {
                                        case 16777224:
                                            format = String.format("@id/0x%08X", Integer.valueOf(a10));
                                            break;
                                        case 33554440:
                                            format = String.format("?id/0x%08X", Integer.valueOf(a10));
                                            break;
                                        case 50331656:
                                            format = b(a10);
                                            break;
                                        case 67108872:
                                            format = Float.toString(Float.intBitsToFloat(a10));
                                            break;
                                        case 83886088:
                                            format = Integer.toString(a10 >> 8) + f26252a[a10 & 255];
                                            break;
                                        case 100663304:
                                            format = new DecimalFormat("#.##%").format(a10 / 2.147483647E9d);
                                            break;
                                        case 268435464:
                                        case 285212680:
                                            format = Integer.toString(a10);
                                            break;
                                        case 301989896:
                                            format = Boolean.toString(a10 != 0);
                                            break;
                                        case 469762056:
                                        case 486539272:
                                            format = String.format("#%08X", Integer.valueOf(a10));
                                            break;
                                        default:
                                            format = String.format("%08X/0x%08X", Integer.valueOf(a9), Integer.valueOf(a10));
                                            break;
                                    }
                                    tllms.d = format;
                                } else {
                                    tllms.d = b(a8);
                                }
                                tllmsArr[i8] = tllms;
                                this.j += 20;
                                i7 = i8 + 1;
                            } else {
                                e7l68 e7l68Var3 = this.b;
                                e7l68Var3.getClass();
                                Element createElement = b == null || "".equals(b) ? e7l68Var3.b.createElement(b2) : e7l68Var3.b.createElementNS(b, str);
                                int i9 = 0;
                                while (true) {
                                    int i10 = i9;
                                    if (i10 < i6) {
                                        tLlmS tllms2 = tllmsArr[i10];
                                        String str2 = tllms2.f26302c;
                                        if (str2 == null || "".equals(str2)) {
                                            createElement.setAttribute(tllms2.f26301a, tllms2.d);
                                        } else {
                                            createElement.setAttributeNS(tllms2.f26302c, tllms2.b + ':' + tllms2.f26301a, tllms2.d);
                                        }
                                        i9 = i10 + 1;
                                    } else {
                                        e7l68Var3.f26254a.peek().appendChild(createElement);
                                        e7l68Var3.f26254a.push(createElement);
                                        continue;
                                    }
                                }
                            }
                        }
                        break;
                    case 1048835:
                        int a11 = a(this.j + 16);
                        b(a(this.j + 20));
                        if (a11 != -1) {
                            b(a11);
                        }
                        this.b.f26254a.pop();
                        this.j += 24;
                        continue;
                    case 1048836:
                        String b4 = b(a(this.j + 16));
                        e7l68 e7l68Var4 = this.b;
                        e7l68Var4.f26254a.peek().appendChild(e7l68Var4.b.createCDATASection(b4));
                        this.j += 28;
                        continue;
                    default:
                        this.j += 4;
                        continue;
                }
            } else {
                int a12 = a(this.j + 4);
                this.g = a(this.j + 8);
                this.h = a(this.j + 12);
                int i11 = this.j;
                int a13 = a(i11 + 20);
                int a14 = a(this.j + 24);
                this.e = new String[this.g];
                int i12 = 0;
                while (true) {
                    int i13 = i12;
                    if (i13 < this.g) {
                        int a15 = a(((i13 + 7) * 4) + this.j) + a13 + i11;
                        String[] strArr = this.e;
                        byte[] bArr4 = this.d;
                        int i14 = a15 + 1;
                        if (bArr4[i14] == bArr4[a15]) {
                            int i15 = bArr4[a15];
                            byte[] bArr5 = new byte[i15];
                            int i16 = 0;
                            while (true) {
                                int i17 = i16;
                                bArr = bArr5;
                                if (i17 < i15) {
                                    bArr5[i17] = this.d[a15 + 2 + i17];
                                    i16 = i17 + 1;
                                }
                            }
                        } else {
                            int i18 = (bArr4[a15] & 255) | ((bArr4[i14] << 8) & 65280);
                            byte[] bArr6 = new byte[i18];
                            int i19 = 0;
                            while (true) {
                                int i20 = i19;
                                bArr = bArr6;
                                if (i20 < i18) {
                                    bArr6[i20] = this.d[(i20 * 2) + a15 + 2];
                                    i19 = i20 + 1;
                                }
                            }
                        }
                        strArr[i13] = new String(bArr);
                        i12 = i13 + 1;
                    } else {
                        if (a14 > 0) {
                            int i21 = 0;
                            while (true) {
                                int i22 = i21;
                                if (i22 < this.h) {
                                    i21 = i22 + 1;
                                }
                            }
                        }
                        this.j += a12;
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.HashMap] */
    public final void a(boolean z) {
        int a2 = a(this.j + 16);
        String b = b(a(this.j + 20));
        String b2 = b(a2);
        if (z) {
            this.b.getClass();
            this.f26253c.put(b, b2);
        } else {
            this.b.getClass();
            this.f26253c.remove(b);
        }
        this.j += 24;
    }

    public final String b(int i) {
        if (i < 0 || i >= this.g) {
            return null;
        }
        return this.e[i];
    }
}
