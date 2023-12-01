package com.meizu.cloud.pushsdk.c.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f10410a;

    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/c$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f10411a = new ArrayList(20);

        private void c(String str, String str2) {
            int i;
            int i2;
            char charAt;
            char charAt2;
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            int i3 = 0;
            while (true) {
                i = i3;
                if (i >= length) {
                    if (str2 == null) {
                        throw new IllegalArgumentException("value == null");
                    }
                    int length2 = str2.length();
                    int i4 = 0;
                    while (true) {
                        i2 = i4;
                        if (i2 >= length2) {
                            return;
                        }
                        charAt = str2.charAt(i2);
                        if (charAt <= 31 || charAt >= 127) {
                            break;
                        }
                        i4 = i2 + 1;
                    }
                    throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str, str2));
                }
                charAt2 = str.charAt(i);
                if (charAt2 <= 31 || charAt2 >= 127) {
                    break;
                }
                i3 = i + 1;
            }
            throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt2), Integer.valueOf(i), str));
        }

        public a a(String str, String str2) {
            c(str, str2);
            return b(str, str2);
        }

        public c a() {
            return new c(this);
        }

        a b(String str, String str2) {
            this.f10411a.add(str);
            this.f10411a.add(str2.trim());
            return this;
        }
    }

    private c(a aVar) {
        this.f10410a = (String[]) aVar.f10411a.toArray(new String[aVar.f10411a.size()]);
    }

    private c(String[] strArr) {
        this.f10410a = strArr;
    }

    public static c a(String... strArr) {
        String str;
        String str2;
        if (strArr == null || strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr2.length) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= strArr2.length) {
                        return new c(strArr2);
                    }
                    str = strArr2[i4];
                    str2 = strArr2[i4 + 1];
                    if (str.length() == 0 || str.indexOf(0) != -1 || str2.indexOf(0) != -1) {
                        break;
                    }
                    i3 = i4 + 2;
                }
                throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
            } else if (strArr2[i2] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            } else {
                strArr2[i2] = strArr2[i2].trim();
                i = i2 + 1;
            }
        }
    }

    private static String a(String[] strArr, String str) {
        int length = strArr.length;
        while (true) {
            int i = length - 2;
            if (i < 0) {
                return null;
            }
            if (str.equalsIgnoreCase(strArr[i])) {
                return strArr[i + 1];
            }
            length = i;
        }
    }

    public int a() {
        return this.f10410a.length / 2;
    }

    public String a(int i) {
        return this.f10410a[i * 2];
    }

    public String a(String str) {
        return a(this.f10410a, str);
    }

    public String b(int i) {
        return this.f10410a[(i * 2) + 1];
    }

    public Set<String> b() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int a2 = a();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2) {
                return Collections.unmodifiableSet(treeSet);
            }
            treeSet.add(a(i2));
            i = i2 + 1;
        }
    }

    public a c() {
        a aVar = new a();
        Collections.addAll(aVar.f10411a, this.f10410a);
        return aVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int a2 = a();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2) {
                return sb.toString();
            }
            sb.append(a(i2));
            sb.append(": ");
            sb.append(b(i2));
            sb.append("\n");
            i = i2 + 1;
        }
    }
}
