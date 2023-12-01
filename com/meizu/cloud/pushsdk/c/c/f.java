package com.meizu.cloud.pushsdk.c.c;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f24024a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24025c;
    private final String d;
    private final String e;
    private final int f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.meizu.cloud.pushsdk.c.c.f$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/f$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24026a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[a.EnumC0607a.values().length];
            f24026a = iArr;
            try {
                iArr[a.EnumC0607a.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f24026a[a.EnumC0607a.INVALID_HOST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f24026a[a.EnumC0607a.UNSUPPORTED_SCHEME.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f24026a[a.EnumC0607a.MISSING_SCHEME.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f24026a[a.EnumC0607a.INVALID_PORT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/f$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f24027a;
        String d;
        final List<String> f;
        List<String> g;
        String h;
        String b = "";

        /* renamed from: c  reason: collision with root package name */
        String f24028c = "";
        int e = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.meizu.cloud.pushsdk.c.c.f$a$a  reason: collision with other inner class name */
        /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/f$a$a.class */
        public enum EnumC0607a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        private static String a(byte[] bArr) {
            int i;
            int i2;
            int i3 = -1;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i = i5;
                if (i4 >= bArr.length) {
                    break;
                }
                int i6 = i4;
                while (true) {
                    i2 = i6;
                    if (i2 >= 16 || bArr[i2] != 0 || bArr[i2 + 1] != 0) {
                        break;
                    }
                    i6 = i2 + 2;
                }
                int i7 = i2 - i4;
                int i8 = i;
                if (i7 > i) {
                    i8 = i7;
                    i3 = i4;
                }
                i4 = i2 + 2;
                i5 = i8;
            }
            com.meizu.cloud.pushsdk.c.g.b bVar = new com.meizu.cloud.pushsdk.c.g.b();
            int i9 = 0;
            while (i9 < bArr.length) {
                if (i9 == i3) {
                    bVar.b(58);
                    int i10 = i9 + i;
                    i9 = i10;
                    if (i10 == 16) {
                        bVar.b(58);
                        i9 = i10;
                    }
                } else {
                    if (i9 > 0) {
                        bVar.b(58);
                    }
                    bVar.d(((bArr[i9] & 255) << 8) | (bArr[i9 + 1] & 255));
                    i9 += 2;
                }
            }
            return bVar.h();
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
                int r0 = com.meizu.cloud.pushsdk.c.c.m.a(r0, r1, r2, r3)
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
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.c.c.f.a.a(java.lang.String, int, int):void");
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String b = f.b(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true);
            if (b(b)) {
                return;
            }
            if (c(b)) {
                c();
                return;
            }
            List<String> list = this.f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f;
                list2.set(list2.size() - 1, b);
            } else {
                this.f.add(b);
            }
            if (z) {
                this.f.add("");
            }
        }

        private static boolean a(String str, int i, int i2, byte[] bArr, int i3) {
            char charAt;
            int i4 = i3;
            int i5 = i;
            while (true) {
                boolean z = false;
                if (i5 >= i2) {
                    if (i4 == i3 + 4) {
                        z = true;
                    }
                    return z;
                } else if (i4 == bArr.length) {
                    return false;
                } else {
                    int i6 = i5;
                    if (i4 != i3) {
                        if (str.charAt(i5) != '.') {
                            return false;
                        }
                        i6 = i5 + 1;
                    }
                    i5 = i6;
                    int i7 = 0;
                    while (i5 < i2 && (charAt = str.charAt(i5)) >= '0' && charAt <= '9') {
                        if (i7 == 0 && i6 != i5) {
                            return false;
                        }
                        i7 = ((i7 * 10) + charAt) - 48;
                        if (i7 > 255) {
                            return false;
                        }
                        i5++;
                    }
                    if (i5 - i6 == 0) {
                        return false;
                    }
                    bArr[i4] = (byte) i7;
                    i4++;
                }
            }
        }

        private static int b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            boolean z = false;
            boolean z2 = charAt < 'a' || charAt > 'z';
            if (charAt < 'A' || charAt > 'Z') {
                z = true;
            }
            if (z2 && z) {
                return -1;
            }
            while (true) {
                i++;
                if (i >= i2) {
                    return -1;
                }
                char charAt2 = str.charAt(i);
                if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && ((charAt2 < '0' || charAt2 > '9') && charAt2 != '+' && charAt2 != '-' && charAt2 != '.'))) {
                    if (charAt2 == ':') {
                        return i;
                    }
                    return -1;
                }
            }
        }

        private boolean b(String str) {
            return ".".equals(str) || "%2e".equalsIgnoreCase(str);
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
            return "..".equals(str) || "%2e.".equalsIgnoreCase(str) || ".%2e".equalsIgnoreCase(str) || "%2e%2e".equalsIgnoreCase(str);
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
            String b = f.b(str, i, i2, false);
            if (b.contains(":")) {
                InetAddress f = (b.startsWith("[") && b.endsWith("]")) ? f(b, 1, b.length() - 1) : f(b, 0, b.length());
                if (f == null) {
                    return null;
                }
                byte[] address = f.getAddress();
                if (address.length == 16) {
                    return a(address);
                }
                throw new AssertionError();
            }
            return m.a(b);
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x0126, code lost:
            if (r12 == 16) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x012c, code lost:
            if (r14 != (-1)) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x012f, code lost:
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0131, code lost:
            r0 = r12 - r14;
            java.lang.System.arraycopy((java.lang.Object) r0, r14, (java.lang.Object) r0, 16 - r0, r0);
            java.util.Arrays.fill(r0, r14, (16 - r12) + r14, (byte) 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x015c, code lost:
            return java.net.InetAddress.getByAddress(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0164, code lost:
            throw new java.lang.AssertionError();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static java.net.InetAddress f(java.lang.String r7, int r8, int r9) {
            /*
                Method dump skipped, instructions count: 361
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.c.c.f.a.f(java.lang.String, int, int):java.net.InetAddress");
        }

        private static int g(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(f.b(str, i, i2, "", false, false, false, true));
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
            return i != -1 ? i : f.a(this.f24027a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x00d1, code lost:
            if (r12.charAt(r13) == '#') goto L29;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        com.meizu.cloud.pushsdk.c.c.f.a.EnumC0607a a(com.meizu.cloud.pushsdk.c.c.f r11, java.lang.String r12) {
            /*
                Method dump skipped, instructions count: 712
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.c.c.f.a.a(com.meizu.cloud.pushsdk.c.c.f, java.lang.String):com.meizu.cloud.pushsdk.c.c.f$a$a");
        }

        public a a(String str) {
            this.g = str != null ? f.b(f.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a a(String str, String str2) {
            if (str != null) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                this.g.add(f.a(str, " \"'<>#&=", false, false, true, true));
                this.g.add(str2 != null ? f.a(str2, " \"'<>#&=", false, false, true, true) : null);
                return this;
            }
            throw new IllegalArgumentException("name == null");
        }

        public f b() {
            if (this.f24027a != null) {
                if (this.d != null) {
                    return new f(this, null);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f24027a);
            sb.append("://");
            if (!this.b.isEmpty() || !this.f24028c.isEmpty()) {
                sb.append(this.b);
                if (!this.f24028c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f24028c);
                }
                sb.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.d);
                sb.append(']');
            } else {
                sb.append(this.d);
            }
            int a2 = a();
            if (a2 != f.a(this.f24027a)) {
                sb.append(':');
                sb.append(a2);
            }
            f.a(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                f.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }
    }

    private f(a aVar) {
        this.b = aVar.f24027a;
        this.f24025c = a(aVar.b, false);
        this.d = a(aVar.f24028c, false);
        this.e = aVar.d;
        this.f = aVar.a();
        this.g = a(aVar.f, false);
        this.h = aVar.g != null ? a(aVar.g, true) : null;
        this.i = aVar.h != null ? a(aVar.h, false) : null;
        this.j = aVar.toString();
    }

    /* synthetic */ f(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public static int a(String str) {
        if ("http".equals(str)) {
            return 80;
        }
        return "https".equals(str) ? 443 : -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return b(str, 0, str.length(), str2, z, z2, z3, z4);
    }

    static String a(String str, boolean z) {
        return b(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(next != null ? a(next, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void a(com.meizu.cloud.pushsdk.c.g.b bVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        com.meizu.cloud.pushsdk.c.g.b bVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 43 && z3) {
                bVar.b(z ? "+" : "%2B");
            } else if (a(codePointAt, i, str, i2, str2, z, z2, z3, z4)) {
                com.meizu.cloud.pushsdk.c.g.b bVar3 = bVar2;
                if (bVar2 == null) {
                    bVar3 = new com.meizu.cloud.pushsdk.c.g.b();
                }
                bVar3.a(codePointAt);
                while (true) {
                    bVar2 = bVar3;
                    if (!bVar3.c()) {
                        int f = bVar3.f() & 255;
                        bVar.b(37);
                        bVar.b((int) f24024a[(f >> 4) & 15]);
                        bVar.b((int) f24024a[f & 15]);
                    }
                }
            } else {
                bVar.a(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    private static void a(com.meizu.cloud.pushsdk.c.g.b bVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt != 37 || (i3 = i + 2) >= i2) {
                if (codePointAt == 43 && z) {
                    bVar.b(32);
                }
                bVar.a(codePointAt);
            } else {
                int b = b(str.charAt(i + 1));
                int b2 = b(str.charAt(i3));
                if (b != -1 && b2 != -1) {
                    bVar.b((b << 4) + b2);
                    i = i3;
                }
                bVar.a(codePointAt);
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

    private static boolean a(int i, int i2, String str, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = true;
        if (i >= 32) {
            if (i == 127) {
                return true;
            }
            if ((i >= 128 && z4) || str2.indexOf(i) != -1) {
                return true;
            }
            boolean z6 = !z || (z2 && !a(str, i2, i3));
            if (i == 37 && z6) {
                return true;
            }
            if (i == 43 && z3) {
                return true;
            }
            z5 = false;
        }
        return z5;
    }

    private static boolean a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && b(str.charAt(i + 1)) != -1 && b(str.charAt(i3)) != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(char c2) {
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    return -1;
                }
            }
            return (c2 - c3) + 10;
        }
        return c2 - '0';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return str.substring(i, i2);
            }
            int codePointAt = str.codePointAt(i4);
            if (a(codePointAt, i4, str, i2, str2, z, z2, z3, z4)) {
                com.meizu.cloud.pushsdk.c.g.b bVar = new com.meizu.cloud.pushsdk.c.g.b();
                bVar.a(str, i, i4);
                a(bVar, str, i4, i2, str2, z, z2, z3, z4);
                return bVar.h();
            }
            i3 = i4 + Character.charCount(codePointAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, int i, int i2, boolean z) {
        int i3;
        int i4 = i;
        while (true) {
            i3 = i4;
            if (i3 >= i2) {
                return str.substring(i, i2);
            }
            char charAt = str.charAt(i3);
            boolean z2 = charAt == '%';
            boolean z3 = false;
            if (charAt == '+') {
                z3 = false;
                if (z) {
                    z3 = true;
                }
            }
            if (z2 || z3) {
                break;
            }
            i4 = i3 + 1;
        }
        com.meizu.cloud.pushsdk.c.g.b bVar = new com.meizu.cloud.pushsdk.c.g.b();
        bVar.a(str, i, i3);
        a(bVar, str, i3, i2, z);
        return bVar.h();
    }

    static List<String> b(String str) {
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

    public static f c(String str) {
        a aVar = new a();
        f fVar = null;
        if (aVar.a((f) null, str) == a.EnumC0607a.SUCCESS) {
            fVar = aVar.b();
        }
        return fVar;
    }

    public String a() {
        if (this.f24025c.isEmpty()) {
            return "";
        }
        int length = this.b.length() + 3;
        String str = this.j;
        return this.j.substring(length, m.a(str, length, str.length(), ":@"));
    }

    public String b() {
        if (this.d.isEmpty()) {
            return "";
        }
        int indexOf = this.j.indexOf(58, this.b.length() + 3);
        return this.j.substring(indexOf + 1, this.j.indexOf(64));
    }

    public List<String> c() {
        int indexOf = this.j.indexOf(47, this.b.length() + 3);
        String str = this.j;
        int a2 = m.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i = indexOf + 1;
            indexOf = m.a(this.j, i, a2, '/');
            arrayList.add(this.j.substring(i, indexOf));
        }
        return arrayList;
    }

    public String d() {
        if (this.h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        String str = this.j;
        return this.j.substring(indexOf, m.a(str, indexOf + 1, str.length(), '#'));
    }

    public String e() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((f) obj).j.equals(this.j);
    }

    public a f() {
        a aVar = new a();
        aVar.f24027a = this.b;
        aVar.b = a();
        aVar.f24028c = b();
        aVar.d = this.e;
        aVar.e = this.f != a(this.b) ? this.f : -1;
        aVar.f.clear();
        aVar.f.addAll(c());
        aVar.a(d());
        aVar.h = e();
        return aVar;
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return this.j;
    }
}
