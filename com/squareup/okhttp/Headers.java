package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HttpDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/Headers.class */
public final class Headers {
    private final String[] namesAndValues;

    /* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/Headers$Builder.class */
    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        private void checkNameAndValue(String str, String str2) {
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
                    throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header value: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str2));
                }
                charAt2 = str.charAt(i);
                if (charAt2 <= 31 || charAt2 >= 127) {
                    break;
                }
                i3 = i + 1;
            }
            throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt2), Integer.valueOf(i), str));
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

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder addLenient(String str) {
            int indexOf = str.indexOf(":", 1);
            return indexOf != -1 ? addLenient(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? addLenient("", str.substring(1)) : addLenient("", str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder addLenient(String str, String str2) {
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

    private Headers(Builder builder) {
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
    public static com.squareup.okhttp.Headers of(java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.Headers.of(java.util.Map):com.squareup.okhttp.Headers");
    }

    public static Headers of(String... strArr) {
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

    public String get(String str) {
        return get(this.namesAndValues, str);
    }

    public Date getDate(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return HttpDate.parse(str2);
        }
        return null;
    }

    public String name(int i) {
        int i2 = i * 2;
        if (i2 >= 0) {
            String[] strArr = this.namesAndValues;
            if (i2 >= strArr.length) {
                return null;
            }
            return strArr[i2];
        }
        return null;
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
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return linkedHashMap;
            }
            String name = name(i2);
            List list = (List) linkedHashMap.get(name);
            ArrayList arrayList = list;
            if (list == null) {
                arrayList = new ArrayList(2);
                linkedHashMap.put(name, arrayList);
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
        int i2 = (i * 2) + 1;
        if (i2 >= 0) {
            String[] strArr = this.namesAndValues;
            if (i2 >= strArr.length) {
                return null;
            }
            return strArr[i2];
        }
        return null;
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
