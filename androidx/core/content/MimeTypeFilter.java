package androidx.core.content;

import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/MimeTypeFilter.class */
public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    private static boolean a(String[] strArr, String[] strArr2) {
        if (strArr2.length == 2) {
            if (strArr2[0].isEmpty() || strArr2[1].isEmpty()) {
                throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
            }
            if (strArr.length != 2) {
                return false;
            }
            if ("*".equals(strArr2[0]) || strArr2[0].equals(strArr[0])) {
                return "*".equals(strArr2[1]) || strArr2[1].equals(strArr[1]);
            }
            return false;
        }
        throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
    }

    public static String matches(String str, String[] strArr) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("/");
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            String str2 = strArr[i2];
            if (a(split, str2.split("/"))) {
                return str2;
            }
            i = i2 + 1;
        }
    }

    public static String matches(String[] strArr, String str) {
        if (strArr == null) {
            return null;
        }
        String[] split = str.split("/");
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            String str2 = strArr[i2];
            if (a(str2.split("/"), split)) {
                return str2;
            }
            i = i2 + 1;
        }
    }

    public static boolean matches(String str, String str2) {
        if (str == null) {
            return false;
        }
        return a(str.split("/"), str2.split("/"));
    }

    public static String[] matchesMany(String[] strArr, String str) {
        if (strArr == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        String[] split = str.split("/");
        for (String str2 : strArr) {
            if (a(str2.split("/"), split)) {
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
