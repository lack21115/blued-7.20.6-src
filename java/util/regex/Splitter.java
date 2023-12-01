package java.util.regex;

import java.util.ArrayList;
import java.util.List;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/util/regex/Splitter.class */
public class Splitter {
    private static final String METACHARACTERS = "\\?*+[](){}^$.|";

    private Splitter() {
    }

    public static String[] fastSplit(String str, String str2, int i) {
        int i2;
        int i3;
        int indexOf;
        int length = str.length();
        if (length == 0) {
            return null;
        }
        char charAt = str.charAt(0);
        if (length != 1 || METACHARACTERS.indexOf(charAt) != -1) {
            if (length != 2 || charAt != '\\') {
                return null;
            }
            char charAt2 = str.charAt(1);
            charAt = charAt2;
            if (METACHARACTERS.indexOf(charAt2) == -1) {
                return null;
            }
        }
        if (str2.isEmpty()) {
            return new String[]{""};
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i2 = i5;
            if (i4 + 1 == i || (indexOf = str2.indexOf(charAt, i2)) == -1) {
                break;
            }
            i4++;
            i5 = indexOf + 1;
        }
        int length2 = str2.length();
        int i6 = length2;
        int i7 = i4;
        if (i == 0) {
            i6 = length2;
            i7 = i4;
            if (i2 == length2) {
                if (i4 == length2) {
                    return EmptyArray.STRING;
                }
                do {
                    i3 = i2 - 1;
                    i2 = i3;
                } while (str2.charAt(i3 - 1) == charAt);
                i7 = i4 - (str2.length() - i3);
                i6 = i3;
            }
        }
        String[] strArr = new String[i7 + 1];
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 == i7) {
                strArr[i7] = str2.substring(i8, i6);
                return strArr;
            }
            int indexOf2 = str2.indexOf(charAt, i8);
            strArr[i10] = str2.substring(i8, indexOf2);
            i8 = indexOf2 + 1;
            i9 = i10 + 1;
        }
    }

    private static String[] finishSplit(List<String> list, String str, int i, int i2) {
        if (i >= str.length()) {
            if (i2 == 0) {
                int size = list.size();
                while (true) {
                    int i3 = size - 1;
                    if (i3 < 0 || !list.get(i3).isEmpty()) {
                        break;
                    }
                    list.remove(i3);
                    size = i3;
                }
            } else {
                list.add("");
            }
        } else {
            list.add(str.substring(i));
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static String[] split(Pattern pattern, String str, String str2, int i) {
        int i2;
        String[] fastSplit = fastSplit(str, str2, i);
        if (fastSplit != null) {
            return fastSplit;
        }
        if (str2.isEmpty()) {
            return new String[]{""};
        }
        ArrayList arrayList = new ArrayList();
        Matcher matcher = new Matcher(pattern, str2);
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (arrayList.size() + 1 == i || !matcher.find()) {
                break;
            }
            arrayList.add(str2.substring(i2, matcher.start()));
            i3 = matcher.end();
        }
        return finishSplit(arrayList, str2, i2, i);
    }
}
