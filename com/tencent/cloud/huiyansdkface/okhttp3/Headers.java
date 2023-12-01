package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Headers.class */
public final class Headers {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f22166a;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Headers$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        final List<String> f22167a = new ArrayList(20);

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder a(String str) {
            int indexOf = str.indexOf(":", 1);
            return indexOf != -1 ? a(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? a("", str.substring(1)) : a("", str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder a(String str, String str2) {
            this.f22167a.add(str);
            this.f22167a.add(str2.trim());
            return this;
        }

        public Builder add(String str) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                return add(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            throw new IllegalArgumentException("Unexpected header: " + str);
        }

        public Builder add(String str, String str2) {
            Headers.a(str);
            Headers.a(str2, str);
            return a(str, str2);
        }

        public Builder add(String str, Date date) {
            if (date != null) {
                add(str, HttpDate.format(date));
                return this;
            }
            throw new NullPointerException("value for name " + str + " == null");
        }

        public Builder addAll(Headers headers) {
            int size = headers.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return this;
                }
                a(headers.name(i2), headers.value(i2));
                i = i2 + 1;
            }
        }

        public Builder addUnsafeNonAscii(String str, String str2) {
            Headers.a(str);
            return a(str, str2);
        }

        public Headers build() {
            return new Headers(this);
        }

        public String get(String str) {
            int size = this.f22167a.size();
            while (true) {
                int i = size - 2;
                if (i < 0) {
                    return null;
                }
                if (str.equalsIgnoreCase(this.f22167a.get(i))) {
                    return this.f22167a.get(i + 1);
                }
                size = i;
            }
        }

        public Builder removeAll(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f22167a.size()) {
                    return this;
                }
                int i3 = i2;
                if (str.equalsIgnoreCase(this.f22167a.get(i2))) {
                    this.f22167a.remove(i2);
                    this.f22167a.remove(i2);
                    i3 = i2 - 2;
                }
                i = i3 + 2;
            }
        }

        public Builder set(String str, String str2) {
            Headers.a(str);
            Headers.a(str2, str);
            removeAll(str);
            a(str, str2);
            return this;
        }

        public Builder set(String str, Date date) {
            if (date != null) {
                set(str, HttpDate.format(date));
                return this;
            }
            throw new NullPointerException("value for name " + str + " == null");
        }
    }

    Headers(Builder builder) {
        this.f22166a = (String[]) builder.f22167a.toArray(new String[builder.f22167a.size()]);
    }

    private Headers(String[] strArr) {
        this.f22166a = strArr;
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

    static void a(String str) {
        int i;
        char charAt;
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= length) {
                return;
            }
            charAt = str.charAt(i);
            if (charAt <= ' ' || charAt >= 127) {
                break;
            }
            i2 = i + 1;
        }
        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005a, code lost:
        throw new java.lang.IllegalArgumentException(com.tencent.cloud.huiyansdkface.okhttp3.internal.Util.format("Unexpected char %#04x at %d in %s value: %s", java.lang.Integer.valueOf(r0), java.lang.Integer.valueOf(r10), r9, r8));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(java.lang.String r8, java.lang.String r9) {
        /*
            r0 = r8
            if (r0 == 0) goto L5c
            r0 = r8
            int r0 = r0.length()
            r11 = r0
            r0 = 0
            r10 = r0
        Lb:
            r0 = r10
            r1 = r11
            if (r0 >= r1) goto L5b
            r0 = r8
            r1 = r10
            char r0 = r0.charAt(r1)
            r12 = r0
            r0 = r12
            r1 = 31
            if (r0 > r1) goto L25
            r0 = r12
            r1 = 9
            if (r0 != r1) goto L33
        L25:
            r0 = r12
            r1 = 127(0x7f, float:1.78E-43)
            if (r0 >= r1) goto L33
            r0 = r10
            r1 = 1
            int r0 = r0 + r1
            r10 = r0
            goto Lb
        L33:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "Unexpected char %#04x at %d in %s value: %s"
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = r3
            r5 = 0
            r6 = r12
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r4[r5] = r6
            r4 = r3
            r5 = 1
            r6 = r10
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r4[r5] = r6
            r4 = r3
            r5 = 2
            r6 = r9
            r4[r5] = r6
            r4 = r3
            r5 = 3
            r6 = r8
            r4[r5] = r6
            java.lang.String r2 = com.tencent.cloud.huiyansdkface.okhttp3.internal.Util.format(r2, r3)
            r1.<init>(r2)
            throw r0
        L5b:
            return
        L5c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "value for name "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            r1 = r9
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r1 = " == null"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r1 = r0
            r2 = r8
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.Headers.a(java.lang.String, java.lang.String):void");
    }

    public static Headers of(Map<String, String> map) {
        if (map != null) {
            String[] strArr = new String[map.size() * 2];
            int i = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                String trim = entry.getKey().trim();
                String trim2 = entry.getValue().trim();
                a(trim);
                a(trim2, trim);
                strArr[i] = trim;
                strArr[i + 1] = trim2;
                i += 2;
            }
            return new Headers(strArr);
        }
        throw new NullPointerException("headers == null");
    }

    public static Headers of(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        }
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr2.length) {
                for (int i3 = 0; i3 < strArr2.length; i3 += 2) {
                    String str = strArr2[i3];
                    String str2 = strArr2[i3 + 1];
                    a(str);
                    a(str2, str);
                }
                return new Headers(strArr2);
            } else if (strArr2[i2] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            } else {
                strArr2[i2] = strArr2[i2].trim();
                i = i2 + 1;
            }
        }
    }

    public long byteCount() {
        String[] strArr = this.f22166a;
        long length = strArr.length * 2;
        int length2 = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length2) {
                return length;
            }
            length += this.f22166a[i2].length();
            i = i2 + 1;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).f22166a, this.f22166a);
    }

    public String get(String str) {
        return a(this.f22166a, str);
    }

    public Date getDate(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return HttpDate.parse(str2);
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f22166a);
    }

    public String name(int i) {
        return this.f22166a[i * 2];
    }

    public Set<String> names() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return Collections.unmodifiableSet(treeSet);
            }
            treeSet.add(name(i2));
            i = i2 + 1;
        }
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        Collections.addAll(builder.f22167a, this.f22166a);
        return builder;
    }

    public int size() {
        return this.f22166a.length / 2;
    }

    public Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return treeMap;
            }
            String lowerCase = name(i2).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            ArrayList arrayList = list;
            if (list == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(value(i2));
            i = i2 + 1;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return sb.toString();
            }
            sb.append(name(i2));
            sb.append(": ");
            sb.append(value(i2));
            sb.append("\n");
            i = i2 + 1;
        }
    }

    public String value(int i) {
        return this.f22166a[(i * 2) + 1];
    }

    public List<String> values(String str) {
        int size = size();
        ArrayList arrayList = null;
        int i = 0;
        while (i < size) {
            ArrayList arrayList2 = arrayList;
            if (str.equalsIgnoreCase(name(i))) {
                arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList(2);
                }
                arrayList2.add(value(i));
            }
            i++;
            arrayList = arrayList2;
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }
}
