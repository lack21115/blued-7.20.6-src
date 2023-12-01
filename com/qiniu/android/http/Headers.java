package com.qiniu.android.http;

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
import okhttp3.internal.Util;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/Headers.class */
public final class Headers {
    private final String[] namesAndValues;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/Headers$Builder.class */
    public static final class Builder {
        final List<String> namesAndValues = new ArrayList(20);

        private void checkNameAndValue(String str, String str2) {
            int i;
            int i2;
            int i3;
            char charAt;
            char charAt2;
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            int i4 = 0;
            while (true) {
                i = i4;
                if (i >= length) {
                    if (str2 == null) {
                        throw new NullPointerException("value for name " + str + " == null");
                    }
                    int length2 = str2.length();
                    while (true) {
                        i3 = i2;
                        if (i3 >= length2) {
                            return;
                        }
                        charAt = str2.charAt(i3);
                        i2 = ((charAt > 31 || charAt == '\t') && charAt < 127) ? i3 + 1 : 0;
                    }
                    throw new IllegalArgumentException(Util.a("Unexpected char %#04x at %d in %s value: %s", new Object[]{Integer.valueOf(charAt), Integer.valueOf(i3), str, str2}));
                }
                charAt2 = str.charAt(i);
                if (charAt2 <= ' ' || charAt2 >= 127) {
                    break;
                }
                i4 = i + 1;
            }
            throw new IllegalArgumentException(Util.a("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(charAt2), Integer.valueOf(i), str}));
        }

        public Builder add(String str) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                return add(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            throw new IllegalArgumentException("Unexpected header: " + str);
        }

        public Builder add(String str, String str2) {
            checkNameAndValue(str, str2);
            return addLenient(str, str2);
        }

        public Builder addAll(Headers headers) {
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

        Builder addLenient(String str) {
            int indexOf = str.indexOf(":", 1);
            return indexOf != -1 ? addLenient(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? addLenient("", str.substring(1)) : addLenient("", str);
        }

        Builder addLenient(String str, String str2) {
            this.namesAndValues.add(str);
            this.namesAndValues.add(str2.trim());
            return this;
        }

        public Headers build() {
            return new Headers(this);
        }

        public String get(String str) {
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

        public Builder removeAll(String str) {
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

        public Builder set(String str, String str2) {
            checkNameAndValue(str, str2);
            removeAll(str);
            addLenient(str, str2);
            return this;
        }
    }

    Headers(Builder builder) {
        this.namesAndValues = (String[]) builder.namesAndValues.toArray(new String[builder.namesAndValues.size()]);
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
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

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c7, code lost:
        throw new java.lang.IllegalArgumentException("Headers cannot be null");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.qiniu.android.http.Headers of(java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.http.Headers.of(java.util.Map):com.qiniu.android.http.Headers");
    }

    public static Headers of(String... strArr) {
        String str;
        String str2;
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
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= strArr2.length) {
                        return new Headers(strArr2);
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

    public long byteCount() {
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

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).namesAndValues, this.namesAndValues);
    }

    public String get(String str) {
        return get(this.namesAndValues, str);
    }

    public Date getDate(String str) {
        return HttpDate.parse(get(str));
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public String name(int i) {
        return this.namesAndValues[i * 2];
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
        Collections.addAll(builder.namesAndValues, this.namesAndValues);
        return builder;
    }

    public int size() {
        return this.namesAndValues.length / 2;
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
        return this.namesAndValues[(i * 2) + 1];
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
