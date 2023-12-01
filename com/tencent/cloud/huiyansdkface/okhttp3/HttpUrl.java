package com.tencent.cloud.huiyansdkface.okhttp3;

import com.blued.das.live.LiveProtos;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/HttpUrl.class */
public final class HttpUrl {
    private static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    final String f22168a;
    final String b;

    /* renamed from: c  reason: collision with root package name */
    final int f22169c;
    private final String e;
    private final String f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/HttpUrl$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        String f22170a;
        String d;
        final List<String> f;
        List<String> g;
        String h;
        String b = "";

        /* renamed from: c  reason: collision with root package name */
        String f22171c = "";
        int e = -1;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        private Builder a(String str, boolean z) {
            int i;
            int i2 = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(str, i2, str.length(), "/\\");
                a(str, i2, delimiterOffset, delimiterOffset < str.length(), z);
                i = delimiterOffset + 1;
                i2 = i;
            } while (i <= str.length());
            return this;
        }

        private void a(String str) {
            int size = this.g.size();
            while (true) {
                int i = size - 2;
                if (i < 0) {
                    return;
                }
                if (str.equals(this.g.get(i))) {
                    this.g.remove(i + 1);
                    this.g.remove(i);
                    if (this.g.isEmpty()) {
                        this.g = null;
                        return;
                    }
                }
                size = i;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0086 -> B:12:0x0052). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void a(java.lang.String r8, int r9, int r10) {
            /*
                r7 = this;
                r0 = r9
                r1 = r10
                if (r0 != r1) goto L6
                return
            L6:
                r0 = r8
                r1 = r9
                char r0 = r0.charAt(r1)
                r11 = r0
                r0 = r11
                r1 = 47
                if (r0 == r1) goto L3a
                r0 = r11
                r1 = 92
                if (r0 != r1) goto L1e
                goto L3a
            L1e:
                r0 = r7
                java.util.List<java.lang.String> r0 = r0.f
                r13 = r0
                r0 = r13
                r1 = r13
                int r1 = r1.size()
                r2 = 1
                int r1 = r1 - r2
                java.lang.String r2 = ""
                java.lang.Object r0 = r0.set(r1, r2)
                goto L52
            L3a:
                r0 = r7
                java.util.List<java.lang.String> r0 = r0.f
                r0.clear()
                r0 = r7
                java.util.List<java.lang.String> r0 = r0.f
                java.lang.String r1 = ""
                boolean r0 = r0.add(r1)
                goto L86
            L52:
                r0 = r9
                r1 = r10
                if (r0 >= r1) goto L8d
                r0 = r8
                r1 = r9
                r2 = r10
                java.lang.String r3 = "/\\"
                int r0 = com.tencent.cloud.huiyansdkface.okhttp3.internal.Util.delimiterOffset(r0, r1, r2, r3)
                r11 = r0
                r0 = r11
                r1 = r10
                if (r0 >= r1) goto L6d
                r0 = 1
                r12 = r0
                goto L70
            L6d:
                r0 = 0
                r12 = r0
            L70:
                r0 = r7
                r1 = r8
                r2 = r9
                r3 = r11
                r4 = r12
                r5 = 1
                r0.a(r1, r2, r3, r4, r5)
                r0 = r11
                r9 = r0
                r0 = r12
                if (r0 == 0) goto L52
                r0 = r11
                r9 = r0
            L86:
                r0 = r9
                r1 = 1
                int r0 = r0 + r1
                r9 = r0
                goto L52
            L8d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl.Builder.a(java.lang.String, int, int):void");
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String a2 = HttpUrl.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (b(a2)) {
                return;
            }
            if (c(a2)) {
                c();
                return;
            }
            List<String> list = this.f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f;
                list2.set(list2.size() - 1, a2);
            } else {
                this.f.add(a2);
            }
            if (z) {
                this.f.add("");
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
            if (r0 > 'z') goto L54;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int b(java.lang.String r3, int r4, int r5) {
            /*
                r0 = r5
                r1 = r4
                int r0 = r0 - r1
                r1 = 2
                if (r0 >= r1) goto L9
                r0 = -1
                return r0
            L9:
                r0 = r3
                r1 = r4
                char r0 = r0.charAt(r1)
                r7 = r0
                r0 = r7
                r1 = 97
                if (r0 < r1) goto L20
                r0 = r4
                r6 = r0
                r0 = r7
                r1 = 122(0x7a, float:1.71E-43)
                if (r0 <= r1) goto L32
            L20:
                r0 = r7
                r1 = 65
                if (r0 < r1) goto L99
                r0 = r4
                r6 = r0
                r0 = r7
                r1 = 90
                if (r0 <= r1) goto L32
                r0 = -1
                return r0
            L32:
                r0 = r6
                r1 = 1
                int r0 = r0 + r1
                r4 = r0
                r0 = r4
                r1 = r5
                if (r0 >= r1) goto L99
                r0 = r3
                r1 = r4
                char r0 = r0.charAt(r1)
                r7 = r0
                r0 = r7
                r1 = 97
                if (r0 < r1) goto L52
                r0 = r4
                r6 = r0
                r0 = r7
                r1 = 122(0x7a, float:1.71E-43)
                if (r0 <= r1) goto L32
            L52:
                r0 = r7
                r1 = 65
                if (r0 < r1) goto L62
                r0 = r4
                r6 = r0
                r0 = r7
                r1 = 90
                if (r0 <= r1) goto L32
            L62:
                r0 = r7
                r1 = 48
                if (r0 < r1) goto L72
                r0 = r4
                r6 = r0
                r0 = r7
                r1 = 57
                if (r0 <= r1) goto L32
            L72:
                r0 = r4
                r6 = r0
                r0 = r7
                r1 = 43
                if (r0 == r1) goto L32
                r0 = r4
                r6 = r0
                r0 = r7
                r1 = 45
                if (r0 == r1) goto L32
                r0 = r7
                r1 = 46
                if (r0 != r1) goto L90
                r0 = r4
                r6 = r0
                goto L32
            L90:
                r0 = r7
                r1 = 58
                if (r0 != r1) goto L99
                r0 = r4
                return r0
            L99:
                r0 = -1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl.Builder.b(java.lang.String, int, int):int");
        }

        private boolean b(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private static int c(String str, int i, int i2) {
            char charAt;
            int i3 = 0;
            while (i < i2 && ((charAt = str.charAt(i)) == '\\' || charAt == '/')) {
                i3++;
                i++;
            }
            return i3;
        }

        private void c() {
            List<String> list = this.f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f.isEmpty()) {
                this.f.add("");
                return;
            }
            List<String> list2 = this.f;
            list2.set(list2.size() - 1, "");
        }

        private boolean c(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int d(String str, int i, int i2) {
            int i3;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                int i4 = i;
                if (charAt != '[') {
                    i3 = i;
                } else {
                    while (true) {
                        int i5 = i4 + 1;
                        i3 = i5;
                        if (i5 < i2) {
                            i4 = i5;
                            if (str.charAt(i5) == ']') {
                                i3 = i5;
                                break;
                            }
                        }
                    }
                }
                i = i3 + 1;
            }
            return i2;
        }

        private static String e(String str, int i, int i2) {
            return Util.canonicalizeHost(HttpUrl.a(str, i, i2, false));
        }

        private static int f(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(HttpUrl.a(str, i, i2, "", false, false, false, true, null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException e) {
                return -1;
            }
        }

        int a() {
            int i = this.e;
            return i != -1 ? i : HttpUrl.defaultPort(this.f22170a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x00ff, code lost:
            if (r13.charAt(r14) == '#') goto L29;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl.Builder a(com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl r12, java.lang.String r13) {
            /*
                Method dump skipped, instructions count: 854
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl.Builder.a(com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl, java.lang.String):com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl$Builder");
        }

        public Builder addEncodedPathSegment(String str) {
            if (str != null) {
                a(str, 0, str.length(), false, true);
                return this;
            }
            throw new NullPointerException("encodedPathSegment == null");
        }

        public Builder addEncodedPathSegments(String str) {
            if (str != null) {
                return a(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        public Builder addEncodedQueryParameter(String str, String str2) {
            if (str != null) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                this.g.add(HttpUrl.a(str, " \"'<>#&=", true, false, true, true));
                this.g.add(str2 != null ? HttpUrl.a(str2, " \"'<>#&=", true, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        public Builder addPathSegment(String str) {
            if (str != null) {
                a(str, 0, str.length(), false, false);
                return this;
            }
            throw new NullPointerException("pathSegment == null");
        }

        public Builder addPathSegments(String str) {
            if (str != null) {
                return a(str, false);
            }
            throw new NullPointerException("pathSegments == null");
        }

        public Builder addQueryParameter(String str, String str2) {
            if (str != null) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                this.g.add(HttpUrl.a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                this.g.add(str2 != null ? HttpUrl.a(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        Builder b() {
            int size = this.f.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                this.f.set(i2, HttpUrl.a(this.f.get(i2), "[]", true, true, false, true));
                i = i2 + 1;
            }
            List<String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size2) {
                        break;
                    }
                    String str = this.g.get(i4);
                    if (str != null) {
                        this.g.set(i4, HttpUrl.a(str, "\\^`{|}", true, true, true, true));
                    }
                    i3 = i4 + 1;
                }
            }
            String str2 = this.h;
            if (str2 != null) {
                this.h = HttpUrl.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public HttpUrl build() {
            if (this.f22170a != null) {
                if (this.d != null) {
                    return new HttpUrl(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public Builder encodedFragment(String str) {
            this.h = str != null ? HttpUrl.a(str, "", true, false, false, false) : null;
            return this;
        }

        public Builder encodedPassword(String str) {
            if (str != null) {
                this.f22171c = HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                return this;
            }
            throw new NullPointerException("encodedPassword == null");
        }

        public Builder encodedPath(String str) {
            if (str != null) {
                if (str.startsWith("/")) {
                    a(str, 0, str.length());
                    return this;
                }
                throw new IllegalArgumentException("unexpected encodedPath: " + str);
            }
            throw new NullPointerException("encodedPath == null");
        }

        public Builder encodedQuery(String str) {
            this.g = str != null ? HttpUrl.a(HttpUrl.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public Builder encodedUsername(String str) {
            if (str != null) {
                this.b = HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                return this;
            }
            throw new NullPointerException("encodedUsername == null");
        }

        public Builder fragment(String str) {
            this.h = str != null ? HttpUrl.a(str, "", false, false, false, false) : null;
            return this;
        }

        public Builder host(String str) {
            if (str != null) {
                String e = e(str, 0, str.length());
                if (e != null) {
                    this.d = e;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        public Builder password(String str) {
            if (str != null) {
                this.f22171c = HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public Builder port(int i) {
            if (i > 0 && i <= 65535) {
                this.e = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        public Builder query(String str) {
            this.g = str != null ? HttpUrl.a(HttpUrl.a(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public Builder removeAllEncodedQueryParameters(String str) {
            if (str != null) {
                if (this.g == null) {
                    return this;
                }
                a(HttpUrl.a(str, " \"'<>#&=", true, false, true, true));
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        public Builder removeAllQueryParameters(String str) {
            if (str != null) {
                if (this.g == null) {
                    return this;
                }
                a(HttpUrl.a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                return this;
            }
            throw new NullPointerException("name == null");
        }

        public Builder removePathSegment(int i) {
            this.f.remove(i);
            if (this.f.isEmpty()) {
                this.f.add("");
            }
            return this;
        }

        public Builder scheme(String str) {
            String str2;
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    str2 = "http";
                } else if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                } else {
                    str2 = "https";
                }
                this.f22170a = str2;
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public Builder setEncodedPathSegment(int i, String str) {
            if (str != null) {
                String a2 = HttpUrl.a(str, 0, str.length(), " \"<>^`{}|/\\?#", true, false, false, true, null);
                this.f.set(i, a2);
                if (b(a2) || c(a2)) {
                    throw new IllegalArgumentException("unexpected path segment: " + str);
                }
                return this;
            }
            throw new NullPointerException("encodedPathSegment == null");
        }

        public Builder setEncodedQueryParameter(String str, String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public Builder setPathSegment(int i, String str) {
            if (str != null) {
                String a2 = HttpUrl.a(str, 0, str.length(), " \"<>^`{}|/\\?#", false, false, false, true, null);
                if (!b(a2) && !c(a2)) {
                    this.f.set(i, a2);
                    return this;
                }
                throw new IllegalArgumentException("unexpected path segment: " + str);
            }
            throw new NullPointerException("pathSegment == null");
        }

        public Builder setQueryParameter(String str, String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            String str2 = this.f22170a;
            if (str2 != null) {
                sb.append(str2);
                str = "://";
            } else {
                str = "//";
            }
            sb.append(str);
            if (!this.b.isEmpty() || !this.f22171c.isEmpty()) {
                sb.append(this.b);
                if (!this.f22171c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f22171c);
                }
                sb.append('@');
            }
            String str3 = this.d;
            if (str3 != null) {
                if (str3.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.d);
                    sb.append(']');
                } else {
                    sb.append(this.d);
                }
            }
            if (this.e != -1 || this.f22170a != null) {
                int a2 = a();
                String str4 = this.f22170a;
                if (str4 == null || a2 != HttpUrl.defaultPort(str4)) {
                    sb.append(':');
                    sb.append(a2);
                }
            }
            HttpUrl.a(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                HttpUrl.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        public Builder username(String str) {
            if (str != null) {
                this.b = HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }
    }

    HttpUrl(Builder builder) {
        this.f22168a = builder.f22170a;
        this.e = a(builder.b, false);
        this.f = a(builder.f22171c, false);
        this.b = builder.d;
        this.f22169c = builder.a();
        this.g = a(builder.f, false);
        this.h = builder.g != null ? a(builder.g, true) : null;
        this.i = builder.h != null ? a(builder.h, false) : null;
        this.j = builder.toString();
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i3;
        int i4 = i;
        while (true) {
            i3 = i4;
            if (i3 >= i2) {
                return str.substring(i, i2);
            }
            int codePointAt = str.codePointAt(i3);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !a(str, i3, i2)))) || (codePointAt == 43 && z3)))) {
                break;
            }
            i4 = i3 + Character.charCount(codePointAt);
        }
        Buffer buffer = new Buffer();
        buffer.writeUtf8(str, i, i3);
        a(buffer, str, i3, i2, str2, z, z2, z3, z4, charset);
        return buffer.readUtf8();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
        r0 = new com.tencent.cloud.huiyansdkface.okio.Buffer();
        r0.writeUtf8(r6, r7, r10);
        a(r0, r6, r10, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
        return r0.readUtf8();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String a(java.lang.String r6, int r7, int r8, boolean r9) {
        /*
            r0 = r7
            r10 = r0
        L3:
            r0 = r10
            r1 = r8
            if (r0 >= r1) goto L52
            r0 = r6
            r1 = r10
            char r0 = r0.charAt(r1)
            r11 = r0
            r0 = r11
            r1 = 37
            if (r0 == r1) goto L2f
            r0 = r11
            r1 = 43
            if (r0 != r1) goto L26
            r0 = r9
            if (r0 == 0) goto L26
            goto L2f
        L26:
            r0 = r10
            r1 = 1
            int r0 = r0 + r1
            r10 = r0
            goto L3
        L2f:
            com.tencent.cloud.huiyansdkface.okio.Buffer r0 = new com.tencent.cloud.huiyansdkface.okio.Buffer
            r1 = r0
            r1.<init>()
            r12 = r0
            r0 = r12
            r1 = r6
            r2 = r7
            r3 = r10
            com.tencent.cloud.huiyansdkface.okio.Buffer r0 = r0.writeUtf8(r1, r2, r3)
            r0 = r12
            r1 = r6
            r2 = r10
            r3 = r8
            r4 = r9
            a(r0, r1, r2, r3, r4)
            r0 = r12
            java.lang.String r0 = r0.readUtf8()
            return r0
        L52:
            r0 = r6
            r1 = r7
            r2 = r8
            java.lang.String r0 = r0.substring(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl.a(java.lang.String, int, int, boolean):java.lang.String");
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    static List<String> a(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > str.length()) {
                return arrayList;
            }
            int indexOf = str.indexOf(38, i2);
            int i3 = indexOf;
            if (indexOf == -1) {
                i3 = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > i3) {
                arrayList.add(str.substring(i2, i3));
                str2 = null;
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                str2 = str.substring(indexOf2 + 1, i3);
            }
            arrayList.add(str2);
            i = i3 + 1;
        }
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return Collections.unmodifiableList(arrayList);
            }
            String str = list.get(i2);
            arrayList.add(str != null ? a(str, z) : null);
            i = i2 + 1;
        }
    }

    static void a(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        Buffer buffer2;
        Buffer buffer3 = null;
        while (true) {
            Buffer buffer4 = buffer3;
            if (i >= i2) {
                return;
            }
            int codePointAt = str.codePointAt(i);
            if (z) {
                buffer2 = buffer4;
                if (codePointAt != 9) {
                    buffer2 = buffer4;
                    if (codePointAt != 10) {
                        buffer2 = buffer4;
                        if (codePointAt != 12) {
                            if (codePointAt == 13) {
                                buffer2 = buffer4;
                            }
                        }
                    }
                }
                i += Character.charCount(codePointAt);
                buffer3 = buffer2;
            }
            if (codePointAt == 43 && z3) {
                buffer.writeUtf8(z ? "+" : "%2B");
                buffer2 = buffer4;
            } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !a(str, i, i2)))))) {
                Buffer buffer5 = buffer4;
                if (buffer4 == null) {
                    buffer5 = new Buffer();
                }
                if (charset == null || charset.equals(Util.e)) {
                    buffer5.writeUtf8CodePoint(codePointAt);
                } else {
                    buffer5.writeString(str, i, Character.charCount(codePointAt) + i, charset);
                }
                while (true) {
                    buffer2 = buffer5;
                    if (!buffer5.exhausted()) {
                        int readByte = buffer5.readByte() & 255;
                        buffer.writeByte(37);
                        buffer.writeByte((int) d[(readByte >> 4) & 15]);
                        buffer.writeByte((int) d[readByte & 15]);
                    }
                }
            } else {
                buffer.writeUtf8CodePoint(codePointAt);
                buffer2 = buffer4;
            }
            i += Character.charCount(codePointAt);
            buffer3 = buffer2;
        }
    }

    static void a(Buffer buffer, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt != 37 || (i3 = i + 2) >= i2) {
                if (codePointAt == 43 && z) {
                    buffer.writeByte(32);
                }
                buffer.writeUtf8CodePoint(codePointAt);
            } else {
                int decodeHexDigit = Util.decodeHexDigit(str.charAt(i + 1));
                int decodeHexDigit2 = Util.decodeHexDigit(str.charAt(i3));
                if (decodeHexDigit != -1 && decodeHexDigit2 != -1) {
                    buffer.writeByte((decodeHexDigit << 4) + decodeHexDigit2);
                    i = i3;
                }
                buffer.writeUtf8CodePoint(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            sb.append('/');
            sb.append(list.get(i2));
            i = i2 + 1;
        }
    }

    static boolean a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && Util.decodeHexDigit(str.charAt(i + 1)) != -1 && Util.decodeHexDigit(str.charAt(i3)) != -1;
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
            i = i2 + 2;
        }
    }

    public static int defaultPort(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return LiveProtos.Event.LIVE_CHALLENGE_PK_EXPLAIN_CLICK_VALUE;
        }
        return -1;
    }

    public static HttpUrl get(String str) {
        return new Builder().a((HttpUrl) null, str).build();
    }

    public static HttpUrl get(URI uri) {
        return parse(uri.toString());
    }

    public static HttpUrl get(URL url) {
        return parse(url.toString());
    }

    public static HttpUrl parse(String str) {
        try {
            return get(str);
        } catch (IllegalArgumentException e) {
            OkHttpLogger.log("url parse err:" + str, e);
            return null;
        }
    }

    public String encodedFragment() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    public String encodedPassword() {
        if (this.f.isEmpty()) {
            return "";
        }
        int indexOf = this.j.indexOf(58, this.f22168a.length() + 3);
        return this.j.substring(indexOf + 1, this.j.indexOf(64));
    }

    public String encodedPath() {
        int indexOf = this.j.indexOf(47, this.f22168a.length() + 3);
        String str = this.j;
        return this.j.substring(indexOf, Util.delimiterOffset(str, indexOf, str.length(), "?#"));
    }

    public List<String> encodedPathSegments() {
        int indexOf = this.j.indexOf(47, this.f22168a.length() + 3);
        String str = this.j;
        int delimiterOffset = Util.delimiterOffset(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < delimiterOffset) {
            int i = indexOf + 1;
            indexOf = Util.delimiterOffset(this.j, i, delimiterOffset, '/');
            arrayList.add(this.j.substring(i, indexOf));
        }
        return arrayList;
    }

    public String encodedQuery() {
        if (this.h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        String str = this.j;
        return this.j.substring(indexOf, Util.delimiterOffset(str, indexOf, str.length(), '#'));
    }

    public String encodedUsername() {
        if (this.e.isEmpty()) {
            return "";
        }
        int length = this.f22168a.length() + 3;
        String str = this.j;
        return this.j.substring(length, Util.delimiterOffset(str, length, str.length(), ":@"));
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).j.equals(this.j);
    }

    public String fragment() {
        return this.i;
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String host() {
        return this.b;
    }

    public boolean isHttps() {
        return this.f22168a.equals("https");
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f22170a = this.f22168a;
        builder.b = encodedUsername();
        builder.f22171c = encodedPassword();
        builder.d = this.b;
        builder.e = this.f22169c != defaultPort(this.f22168a) ? this.f22169c : -1;
        builder.f.clear();
        builder.f.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.h = encodedFragment();
        return builder;
    }

    public Builder newBuilder(String str) {
        try {
            return new Builder().a(this, str);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public String password() {
        return this.f;
    }

    public List<String> pathSegments() {
        return this.g;
    }

    public int pathSize() {
        return this.g.size();
    }

    public int port() {
        return this.f22169c;
    }

    public String query() {
        if (this.h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, this.h);
        return sb.toString();
    }

    public String queryParameter(String str) {
        List<String> list = this.h;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.h.get(i))) {
                return this.h.get(i + 1);
            }
        }
        return null;
    }

    public String queryParameterName(int i) {
        List<String> list = this.h;
        if (list != null) {
            return list.get(i * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    public Set<String> queryParameterNames() {
        if (this.h == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.h.size();
        for (int i = 0; i < size; i += 2) {
            linkedHashSet.add(this.h.get(i));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public String queryParameterValue(int i) {
        List<String> list = this.h;
        if (list != null) {
            return list.get((i * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public List<String> queryParameterValues(String str) {
        if (this.h == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.h.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.h.get(i))) {
                arrayList.add(this.h.get(i + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int querySize() {
        List<String> list = this.h;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public String redact() {
        return newBuilder("/...").username("").password("").build().toString();
    }

    public HttpUrl resolve(String str) {
        Builder newBuilder = newBuilder(str);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public String scheme() {
        return this.f22168a;
    }

    public String toString() {
        return this.j;
    }

    public URI uri() {
        String builder = newBuilder().b().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e) {
            try {
                return URI.create(builder.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception e2) {
                throw new RuntimeException(e);
            }
        }
    }

    public URL url() {
        try {
            return new URL(this.j);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String username() {
        return this.e;
    }
}
