package com.getui.gtc.base.http;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/Headers.class */
public final class Headers {
    private final String[] namesAndValues;

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/Headers$Builder.class */
    public static final class Builder {
        final List<String> namesAndValues = new ArrayList(20);

        public final Builder add(String str) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                return add(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            throw new IllegalArgumentException("Unexpected header: ".concat(String.valueOf(str)));
        }

        public final Builder add(String str, String str2) {
            Headers.checkName(str);
            Headers.checkValue(str2, str);
            return addLenient(str, str2);
        }

        public final Builder addAll(Headers headers) {
            int size = headers.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return this;
                }
                addLenient(headers.name(i2), headers.value(i2));
                i = i2 + 1;
            }
        }

        final Builder addLenient(String str) {
            int indexOf = str.indexOf(":", 1);
            return indexOf != -1 ? addLenient(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? addLenient("", str.substring(1)) : addLenient("", str);
        }

        final Builder addLenient(String str, String str2) {
            this.namesAndValues.add(str);
            this.namesAndValues.add(str2.trim());
            return this;
        }

        public final Builder addUnsafeNonAscii(String str, String str2) {
            Headers.checkName(str);
            return addLenient(str, str2);
        }

        public final Headers build() {
            return new Headers(this);
        }

        public final String get(String str) {
            int size = this.namesAndValues.size();
            while (true) {
                int i = size - 2;
                if (i < 0) {
                    return null;
                }
                if (str.equalsIgnoreCase(this.namesAndValues.get(i))) {
                    return this.namesAndValues.get(i + 1);
                }
                size = i;
            }
        }

        public final Builder removeAll(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.namesAndValues.size()) {
                    return this;
                }
                int i3 = i2;
                if (str.equalsIgnoreCase(this.namesAndValues.get(i2))) {
                    this.namesAndValues.remove(i2);
                    this.namesAndValues.remove(i2);
                    i3 = i2 - 2;
                }
                i = i3 + 2;
            }
        }

        public final Builder set(String str, String str2) {
            Headers.checkName(str);
            Headers.checkValue(str2, str);
            removeAll(str);
            addLenient(str, str2);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/Headers$Util.class */
    public static class Util {
        private Util() {
        }

        public static String format(String str, Object... objArr) {
            return String.format(Locale.US, str, objArr);
        }
    }

    Headers(Builder builder) {
        this.namesAndValues = (String[]) builder.namesAndValues.toArray(new String[builder.namesAndValues.size()]);
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    static void checkName(String str) {
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
        throw new java.lang.IllegalArgumentException(com.getui.gtc.base.http.Headers.Util.format("Unexpected char %#04x at %d in %s value: %s", java.lang.Integer.valueOf(r0), java.lang.Integer.valueOf(r10), r9, r8));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void checkValue(java.lang.String r8, java.lang.String r9) {
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
            java.lang.String r2 = com.getui.gtc.base.http.Headers.Util.format(r2, r3)
            r1.<init>(r2)
            throw r0
        L5b:
            return
        L5c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "value for name "
            r1.<init>(r2)
            r8 = r0
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
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.base.http.Headers.checkValue(java.lang.String, java.lang.String):void");
    }

    private static String get(String[] strArr, String str) {
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
                checkName(trim);
                checkValue(trim2, trim);
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
                    checkName(str);
                    checkValue(str2, str);
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

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        int length2 = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length2) {
                return length;
            }
            length += this.namesAndValues[i2].length();
            i = i2 + 1;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).namesAndValues, this.namesAndValues);
    }

    public final String get(String str) {
        return get(this.namesAndValues, str);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public final String name(int i) {
        return this.namesAndValues[i * 2];
    }

    public final Set<String> names() {
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

    public final Builder newBuilder() {
        Builder builder = new Builder();
        Collections.addAll(builder.namesAndValues, this.namesAndValues);
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
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

    public final String toString() {
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

    public final String value(int i) {
        return this.namesAndValues[(i * 2) + 1];
    }

    public final List<String> values(String str) {
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
