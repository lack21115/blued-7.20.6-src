package com.huawei.secure.android.common.anonymization;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/anonymization/a.class */
public class a {
    public static int a(String str, char c2, int i) {
        int length = str.length();
        while (true) {
            int i2 = length - 1;
            int i3 = i;
            if (i2 < 0) {
                return i2;
            }
            i = i3;
            if (str.charAt(i2) == c2) {
                int i4 = i3 - 1;
                i = i4;
                if (i4 <= 0) {
                    return i2;
                }
            }
            length = i2;
        }
    }

    public static String a(String str, char c2) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new String(cArr);
            }
            cArr[i2] = c2;
            i = i2 + 1;
        }
    }

    public static String a(String str, String str2, String str3) {
        if (str == null || str.length() <= 0 || str2.length() <= 0) {
            return str;
        }
        if (str3.length() <= 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] cArr = new char[str.length()];
        char charAt = str3.charAt(str3.length() - 1);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= charArray.length) {
                return new String(cArr);
            }
            char c2 = charArray[i2];
            int lastIndexOf = str2.lastIndexOf(c2);
            if (lastIndexOf < 0) {
                cArr[i2] = c2;
            } else {
                cArr[i2] = lastIndexOf >= str3.length() ? charAt : str3.charAt(lastIndexOf);
            }
            i = i2 + 1;
        }
    }

    public static String a(String str, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return sb.toString();
            }
            if (strArr[i2] != null) {
                sb.append(str);
                sb.append(strArr[i2]);
            }
            i = i2 + 1;
        }
    }

    public static String a(String[] strArr, int i) {
        return (strArr == null || strArr.length <= 0 || i < 0 || i >= strArr.length) ? "" : strArr[i];
    }

    public static String[] a(String str, int i) {
        return str == null ? new String[]{"", ""} : (i < 0 || i > str.length()) ? new String[]{str, ""} : new String[]{str.substring(0, i), str.substring(i)};
    }

    public static String[] a(String str, int i, int i2) {
        String[] a2 = a(str, i);
        return b(a(a2, 0), a(a(a2, 1), i2 - i));
    }

    public static String[] a(String str, int i, int i2, int i3) {
        String[] a2 = a(str, i);
        return b(a(a2, 0), a(a(a2, 1), i2 - i, i3 - i));
    }

    public static String[] a(String str, int... iArr) {
        if (str == null) {
            return new String[]{""};
        }
        if (str.length() <= 1 || iArr.length <= 0) {
            return new String[]{str};
        }
        if (iArr.length <= 1) {
            return a(str, iArr[0]);
        }
        int i = iArr[0];
        int length = iArr.length - 1;
        int[] iArr2 = new int[length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                String[] a2 = a(str, i);
                return b(a(a2, 0), a(a(a2, 1), iArr2));
            }
            int i4 = i3 + 1;
            iArr2[i3] = iArr[i4] - i;
            i2 = i4;
        }
    }

    public static String[] a(String[] strArr, String str) {
        return a(strArr, new String[]{str});
    }

    public static String[] a(String[] strArr, String[] strArr2) {
        if (strArr.length <= 0) {
            return strArr2.length <= 0 ? new String[0] : strArr2;
        } else if (strArr2.length <= 0) {
            return strArr;
        } else {
            String[] strArr3 = new String[strArr.length + strArr2.length];
            System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
            System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
            return strArr3;
        }
    }

    public static String[] b(String str, char c2) {
        int i;
        if (str == null) {
            return new String[0];
        }
        if (str.length() <= 0) {
            return new String[]{str};
        }
        int i2 = 0;
        int i3 = 1;
        while (true) {
            i = i3;
            if (i2 >= str.length()) {
                break;
            }
            int i4 = i;
            if (str.charAt(i2) == c2) {
                i4 = i + 1;
            }
            i2++;
            i3 = i4;
        }
        if (i <= 1) {
            return new String[]{str};
        }
        String[] strArr = new String[i];
        StringBuilder sb = new StringBuilder(str.length());
        int i5 = 0;
        for (int i6 = 0; i6 < str.length() && i5 < i; i6++) {
            char charAt = str.charAt(i6);
            if (charAt == c2) {
                strArr[i5] = sb.toString();
                sb.setLength(0);
                i5++;
            } else {
                sb.append(charAt);
            }
        }
        strArr[i5] = sb.toString();
        return strArr;
    }

    public static String[] b(String str, String[] strArr) {
        return a(new String[]{str}, strArr);
    }
}
