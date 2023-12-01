package com.opos.exoplayer.core.f.h;

import android.text.TextUtils;
import com.opos.exoplayer.core.i.m;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/h/g.class */
final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f25406a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final m b = new m();

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f25407c = new StringBuilder();

    private static char a(m mVar, int i) {
        return (char) mVar.f25496a[i];
    }

    static String a(m mVar, StringBuilder sb) {
        b(mVar);
        if (mVar.b() == 0) {
            return null;
        }
        String d = d(mVar, sb);
        if ("".equals(d)) {
            return "" + ((char) mVar.g());
        }
        return d;
    }

    private void a(b bVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int indexOf = str.indexOf(91);
        String str2 = str;
        if (indexOf != -1) {
            Matcher matcher = f25406a.matcher(str.substring(indexOf));
            if (matcher.matches()) {
                bVar.c(matcher.group(1));
            }
            str2 = str.substring(0, indexOf);
        }
        String[] split = str2.split("\\.");
        String str3 = split[0];
        int indexOf2 = str3.indexOf(35);
        if (indexOf2 != -1) {
            bVar.b(str3.substring(0, indexOf2));
            bVar.a(str3.substring(indexOf2 + 1));
        } else {
            bVar.b(str3);
        }
        if (split.length > 1) {
            bVar.a((String[]) Arrays.copyOfRange(split, 1, split.length));
        }
    }

    private static void a(m mVar, b bVar, StringBuilder sb) {
        b(mVar);
        String d = d(mVar, sb);
        if (!"".equals(d) && ":".equals(a(mVar, sb))) {
            b(mVar);
            String c2 = c(mVar, sb);
            if (c2 == null || "".equals(c2)) {
                return;
            }
            int d2 = mVar.d();
            String a2 = a(mVar, sb);
            if (!";".equals(a2)) {
                if (!com.alipay.sdk.util.i.d.equals(a2)) {
                    return;
                }
                mVar.c(d2);
            }
            if ("color".equals(d)) {
                bVar.a(com.opos.exoplayer.core.i.d.b(c2));
            } else if ("background-color".equals(d)) {
                bVar.b(com.opos.exoplayer.core.i.d.b(c2));
            } else if ("text-decoration".equals(d)) {
                if ("underline".equals(c2)) {
                    bVar.a(true);
                }
            } else if ("font-family".equals(d)) {
                bVar.d(c2);
            } else if ("font-weight".equals(d)) {
                if ("bold".equals(c2)) {
                    bVar.b(true);
                }
            } else if ("font-style".equals(d) && "italic".equals(c2)) {
                bVar.c(true);
            }
        }
    }

    private static String b(m mVar, StringBuilder sb) {
        b(mVar);
        if (mVar.b() < 5) {
            return null;
        }
        String str = null;
        if ("::cue".equals(mVar.e(5))) {
            int d = mVar.d();
            String a2 = a(mVar, sb);
            str = null;
            if (a2 != null) {
                if ("{".equals(a2)) {
                    mVar.c(d);
                    return "";
                }
                String d2 = "(".equals(a2) ? d(mVar) : null;
                String a3 = a(mVar, sb);
                str = null;
                if (")".equals(a3)) {
                    str = null;
                    if (a3 != null) {
                        str = d2;
                    }
                }
            }
        }
        return str;
    }

    static void b(m mVar) {
        while (true) {
            boolean z = true;
            while (true) {
                boolean z2 = z;
                if (mVar.b() <= 0 || !z2) {
                    return;
                }
                if (!e(mVar) && !f(mVar)) {
                    z = false;
                }
            }
        }
    }

    private static String c(m mVar, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int d = mVar.d();
            String a2 = a(mVar, sb);
            if (a2 == null) {
                return null;
            }
            if (com.alipay.sdk.util.i.d.equals(a2) || ";".equals(a2)) {
                mVar.c(d);
                z = true;
            } else {
                sb2.append(a2);
            }
        }
        return sb2.toString();
    }

    static void c(m mVar) {
        do {
        } while (!TextUtils.isEmpty(mVar.z()));
    }

    private static String d(m mVar) {
        int d = mVar.d();
        int c2 = mVar.c();
        boolean z = false;
        while (d < c2 && !z) {
            z = ((char) mVar.f25496a[d]) == ')';
            d++;
        }
        return mVar.e((d - 1) - mVar.d()).trim();
    }

    private static String d(m mVar, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int d = mVar.d();
        int c2 = mVar.c();
        while (d < c2 && !z) {
            char c3 = (char) mVar.f25496a[d];
            if ((c3 < 'A' || c3 > 'Z') && ((c3 < 'a' || c3 > 'z') && !((c3 >= '0' && c3 <= '9') || c3 == '#' || c3 == '-' || c3 == '.' || c3 == '_'))) {
                z = true;
            } else {
                d++;
                sb.append(c3);
            }
        }
        mVar.d(d - mVar.d());
        return sb.toString();
    }

    private static boolean e(m mVar) {
        char a2 = a(mVar, mVar.d());
        if (a2 == '\t' || a2 == '\n' || a2 == '\f' || a2 == '\r' || a2 == ' ') {
            mVar.d(1);
            return true;
        }
        return false;
    }

    private static boolean f(m mVar) {
        int d = mVar.d();
        int c2 = mVar.c();
        byte[] bArr = mVar.f25496a;
        if (d + 2 > c2) {
            return false;
        }
        int i = d + 1;
        if (bArr[d] != 47) {
            return false;
        }
        int i2 = i + 1;
        if (bArr[i] != 42) {
            return false;
        }
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= c2) {
                mVar.d(c2 - mVar.d());
                return true;
            } else if (((char) bArr[i2]) == '*' && ((char) bArr[i3]) == '/') {
                c2 = i3 + 1;
                i2 = c2;
            } else {
                i2 = i3;
            }
        }
    }

    public b a(m mVar) {
        this.f25407c.setLength(0);
        int d = mVar.d();
        c(mVar);
        this.b.a(mVar.f25496a, mVar.d());
        this.b.c(d);
        String b = b(this.b, this.f25407c);
        b bVar = null;
        if (b != null) {
            if (!"{".equals(a(this.b, this.f25407c))) {
                return null;
            }
            b bVar2 = new b();
            a(bVar2, b);
            String str = null;
            boolean z = false;
            while (!z) {
                int d2 = this.b.d();
                str = a(this.b, this.f25407c);
                z = str == null || com.alipay.sdk.util.i.d.equals(str);
                if (!z) {
                    this.b.c(d2);
                    a(this.b, bVar2, this.f25407c);
                }
            }
            if (!com.alipay.sdk.util.i.d.equals(str)) {
                return null;
            }
            bVar = bVar2;
        }
        return bVar;
    }
}
