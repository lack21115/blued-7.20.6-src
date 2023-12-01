package com.tencent.cloud.huiyansdkface.okhttp3;

import com.blued.das.live.LiveProtos;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpDate;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Cookie.class */
public final class Cookie {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f22150a = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f22151c = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private final String e;
    private final String f;
    private final long g;
    private final String h;
    private final String i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Cookie$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        String f22152a;
        String b;
        String d;
        boolean f;
        boolean g;
        boolean h;
        boolean i;

        /* renamed from: c  reason: collision with root package name */
        long f22153c = 253402300799999L;
        String e = "/";

        private Builder a(String str, boolean z) {
            if (str != null) {
                String canonicalizeHost = Util.canonicalizeHost(str);
                if (canonicalizeHost != null) {
                    this.d = canonicalizeHost;
                    this.i = z;
                    return this;
                }
                throw new IllegalArgumentException("unexpected domain: " + str);
            }
            throw new NullPointerException("domain == null");
        }

        public Cookie build() {
            return new Cookie(this);
        }

        public Builder domain(String str) {
            return a(str, false);
        }

        public Builder expiresAt(long j) {
            long j2 = j;
            if (j <= 0) {
                j2 = Long.MIN_VALUE;
            }
            long j3 = j2;
            if (j2 > 253402300799999L) {
                j3 = 253402300799999L;
            }
            this.f22153c = j3;
            this.h = true;
            return this;
        }

        public Builder hostOnlyDomain(String str) {
            return a(str, true);
        }

        public Builder httpOnly() {
            this.g = true;
            return this;
        }

        public Builder name(String str) {
            if (str != null) {
                if (str.trim().equals(str)) {
                    this.f22152a = str;
                    return this;
                }
                throw new IllegalArgumentException("name is not trimmed");
            }
            throw new NullPointerException("name == null");
        }

        public Builder path(String str) {
            if (str.startsWith("/")) {
                this.e = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        public Builder secure() {
            this.f = true;
            return this;
        }

        public Builder value(String str) {
            if (str != null) {
                if (str.trim().equals(str)) {
                    this.b = str;
                    return this;
                }
                throw new IllegalArgumentException("value is not trimmed");
            }
            throw new NullPointerException("value == null");
        }
    }

    Cookie(Builder builder) {
        if (builder.f22152a == null) {
            throw new NullPointerException("builder.name == null");
        }
        if (builder.b == null) {
            throw new NullPointerException("builder.value == null");
        }
        if (builder.d == null) {
            throw new NullPointerException("builder.domain == null");
        }
        this.e = builder.f22152a;
        this.f = builder.b;
        this.g = builder.f22153c;
        this.h = builder.d;
        this.i = builder.e;
        this.j = builder.f;
        this.k = builder.g;
        this.l = builder.h;
        this.m = builder.i;
    }

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.e = str;
        this.f = str2;
        this.g = j;
        this.h = str3;
        this.i = str4;
        this.j = z;
        this.k = z2;
        this.m = z3;
        this.l = z4;
    }

    private static int a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER) ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    private static long a(String str, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int a2 = a(str, i, i2, false);
        Matcher matcher = d.matcher(str);
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        while (a2 < i2) {
            int a3 = a(str, a2 + 1, i2, true);
            matcher.region(a2, a3);
            if (i10 == -1 && matcher.usePattern(d).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i7 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
                i3 = i9;
                i5 = i11;
                i6 = i12;
            } else if (i11 == -1 && matcher.usePattern(f22151c).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
                i3 = i9;
                i4 = i10;
                i6 = i12;
                i7 = i13;
                i8 = i14;
            } else if (i12 == -1 && matcher.usePattern(b).matches()) {
                i6 = b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                i3 = i9;
                i4 = i10;
                i5 = i11;
                i7 = i13;
                i8 = i14;
            } else {
                i3 = i9;
                i4 = i10;
                i5 = i11;
                i6 = i12;
                i7 = i13;
                i8 = i14;
                if (i9 == -1) {
                    i3 = i9;
                    i4 = i10;
                    i5 = i11;
                    i6 = i12;
                    i7 = i13;
                    i8 = i14;
                    if (matcher.usePattern(f22150a).matches()) {
                        i3 = Integer.parseInt(matcher.group(1));
                        i8 = i14;
                        i7 = i13;
                        i6 = i12;
                        i5 = i11;
                        i4 = i10;
                    }
                }
            }
            i9 = i3;
            i10 = i4;
            i11 = i5;
            i12 = i6;
            i13 = i7;
            i14 = i8;
            a2 = a(str, a3 + 1, i2, false);
        }
        int i15 = i9;
        if (i9 >= 70) {
            i15 = i9;
            if (i9 <= 99) {
                i15 = i9 + 1900;
            }
        }
        int i16 = i15;
        if (i15 >= 0) {
            i16 = i15;
            if (i15 <= 69) {
                i16 = i15 + 2000;
            }
        }
        if (i16 >= 1601) {
            if (i12 != -1) {
                if (i11 < 1 || i11 > 31) {
                    throw new IllegalArgumentException();
                }
                if (i10 < 0 || i10 > 23) {
                    throw new IllegalArgumentException();
                }
                if (i13 < 0 || i13 > 59) {
                    throw new IllegalArgumentException();
                }
                if (i14 < 0 || i14 > 59) {
                    throw new IllegalArgumentException();
                }
                GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.g);
                gregorianCalendar.setLenient(false);
                gregorianCalendar.set(1, i16);
                gregorianCalendar.set(2, i12 - 1);
                gregorianCalendar.set(5, i11);
                gregorianCalendar.set(11, i10);
                gregorianCalendar.set(12, i13);
                gregorianCalendar.set(13, i14);
                gregorianCalendar.set(14, 0);
                return gregorianCalendar.getTimeInMillis();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x023e, code lost:
        if (r0 > 253402300799999L) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.tencent.cloud.huiyansdkface.okhttp3.Cookie a(long r13, com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl r15, java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 734
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.Cookie.a(long, com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl, java.lang.String):com.tencent.cloud.huiyansdkface.okhttp3.Cookie");
    }

    private static boolean a(HttpUrl httpUrl, String str) {
        String encodedPath = httpUrl.encodedPath();
        if (encodedPath.equals(str)) {
            return true;
        }
        if (encodedPath.startsWith(str)) {
            return str.endsWith("/") || encodedPath.charAt(str.length()) == '/';
        }
        return false;
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.verifyAsIpAddress(str);
    }

    private static String b(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        String str2 = str;
        if (str.startsWith(".")) {
            str2 = str.substring(1);
        }
        String canonicalizeHost = Util.canonicalizeHost(str2);
        if (canonicalizeHost != null) {
            return canonicalizeHost;
        }
        throw new IllegalArgumentException();
    }

    public static Cookie parse(HttpUrl httpUrl, String str) {
        return a(System.currentTimeMillis(), httpUrl, str);
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List<String> values = headers.values("Set-Cookie");
        int size = values.size();
        ArrayList arrayList = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            Cookie parse = parse(httpUrl, values.get(i2));
            if (parse != null) {
                ArrayList arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(parse);
                arrayList = arrayList2;
            }
            i = i2 + 1;
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    String a(boolean z) {
        String format;
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        sb.append('=');
        sb.append(this.f);
        if (this.l) {
            if (this.g == Long.MIN_VALUE) {
                format = "; max-age=0";
            } else {
                sb.append("; expires=");
                format = HttpDate.format(new Date(this.g));
            }
            sb.append(format);
        }
        if (!this.m) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.h);
        }
        sb.append("; path=");
        sb.append(this.i);
        if (this.j) {
            sb.append("; secure");
        }
        if (this.k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public String domain() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            boolean z = false;
            if (cookie.e.equals(this.e)) {
                z = false;
                if (cookie.f.equals(this.f)) {
                    z = false;
                    if (cookie.h.equals(this.h)) {
                        z = false;
                        if (cookie.i.equals(this.i)) {
                            z = false;
                            if (cookie.g == this.g) {
                                z = false;
                                if (cookie.j == this.j) {
                                    z = false;
                                    if (cookie.k == this.k) {
                                        z = false;
                                        if (cookie.l == this.l) {
                                            z = false;
                                            if (cookie.m == this.m) {
                                                z = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    public long expiresAt() {
        return this.g;
    }

    public int hashCode() {
        int hashCode = this.e.hashCode();
        int hashCode2 = this.f.hashCode();
        int hashCode3 = this.h.hashCode();
        int hashCode4 = this.i.hashCode();
        long j = this.g;
        return ((((((((((((((((LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (!this.j ? 1 : 0)) * 31) + (!this.k ? 1 : 0)) * 31) + (!this.l ? 1 : 0)) * 31) + (!this.m ? 1 : 0);
    }

    public boolean hostOnly() {
        return this.m;
    }

    public boolean httpOnly() {
        return this.k;
    }

    public boolean matches(HttpUrl httpUrl) {
        if ((this.m ? httpUrl.host().equals(this.h) : a(httpUrl.host(), this.h)) && a(httpUrl, this.i)) {
            return !this.j || httpUrl.isHttps();
        }
        return false;
    }

    public String name() {
        return this.e;
    }

    public String path() {
        return this.i;
    }

    public boolean persistent() {
        return this.l;
    }

    public boolean secure() {
        return this.j;
    }

    public String toString() {
        return a(false);
    }

    public String value() {
        return this.f;
    }
}
