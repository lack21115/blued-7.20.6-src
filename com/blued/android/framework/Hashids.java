package com.blued.android.framework;

import java.util.ArrayList;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/Hashids.class */
public class Hashids {
    private String a;
    private String b;
    private String c;
    private int d;
    private String e;

    public Hashids() {
        this("");
    }

    public Hashids(String str) {
        this(str, 0);
    }

    public Hashids(String str, int i) {
        this(str, i, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123567890");
    }

    public Hashids(String str, int i, String str2) {
        int length;
        String b;
        int indexOf;
        this.a = "";
        this.b = "";
        this.c = "cfhistuCFHISTU";
        this.d = 0;
        this.a = str;
        if (i < 0) {
            this.d = 0;
        } else {
            this.d = i;
        }
        this.b = str2;
        String str3 = "";
        int i2 = 0;
        while (i2 < this.b.length()) {
            String str4 = str3;
            if (!str3.contains("" + this.b.charAt(i2))) {
                str4 = str3 + "" + this.b.charAt(i2);
            }
            i2++;
            str3 = str4;
        }
        this.b = str3;
        if (str3.length() < 16) {
            throw new IllegalArgumentException("alphabet must contain at least 16 unique characters");
        } else if (this.b.contains(" ")) {
            throw new IllegalArgumentException("alphabet cannot contains spaces");
        } else {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.c.length()) {
                    break;
                }
                if (this.b.indexOf(this.c.charAt(i4)) == -1) {
                    this.c = this.c.substring(0, i4) + " " + this.c.substring(i4 + 1);
                } else {
                    this.b = this.b.substring(0, indexOf) + " " + this.b.substring(indexOf + 1);
                }
                i3 = i4 + 1;
            }
            this.b = this.b.replaceAll("\\s+", "");
            String replaceAll = this.c.replaceAll("\\s+", "");
            this.c = replaceAll;
            String b2 = b(replaceAll, this.a);
            this.c = b2;
            if (b2.equals("") || this.b.length() / this.c.length() > 3.5d) {
                int ceil = (int) Math.ceil(this.b.length() / 3.5d);
                int i5 = ceil == 1 ? ceil + 1 : ceil;
                if (i5 > this.c.length()) {
                    this.c += this.b.substring(0, length);
                    this.b = this.b.substring(i5 - this.c.length());
                } else {
                    this.c = this.c.substring(0, i5);
                }
            }
            this.b = b(this.b, this.a);
            int ceil2 = (int) Math.ceil(b.length() / 12);
            if (this.b.length() < 3) {
                this.e = this.c.substring(0, ceil2);
                this.c = this.c.substring(ceil2);
                return;
            }
            this.e = this.b.substring(0, ceil2);
            this.b = this.b.substring(ceil2);
        }
    }

    private String a(long j, String str) {
        String sb;
        long j2;
        int length = str.length();
        char[] charArray = str.toCharArray();
        String str2 = "";
        do {
            StringBuilder sb2 = new StringBuilder();
            long j3 = length;
            sb2.append(charArray[(int) (j % j3)]);
            sb2.append(str2);
            sb = sb2.toString();
            j2 = j / j3;
            str2 = sb;
            j = j2;
        } while (j2 > 0);
        return sb;
    }

    private long[] a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.replaceAll("[" + this.e + "]", " ").split(" ");
        String str3 = split[((split.length == 3 || split.length == 2) ? (byte) 1 : (byte) 0) == 1 ? 1 : 0];
        char c = str3.toCharArray()[0];
        String substring = str3.substring(1);
        String[] split2 = substring.replaceAll("[" + this.c + "]", " ").split(" ");
        int length = split2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            String str4 = split2[i2];
            str2 = b(str2, (c + this.a + str2).substring(0, str2.length()));
            arrayList.add(c(str4, str2));
            i = i2 + 1;
        }
        int size = arrayList.size();
        long[] jArr = new long[size];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                break;
            }
            jArr[i4] = ((Long) arrayList.get(i4)).longValue();
            i3 = i4 + 1;
        }
        long[] jArr2 = jArr;
        if (!b(jArr).equals(str)) {
            jArr2 = new long[0];
        }
        return jArr2;
    }

    private String b(String str, String str2) {
        int i;
        if (str2.length() <= 0) {
            return str;
        }
        char[] charArray = str2.toCharArray();
        int length = str.length() - 1;
        int i2 = 0;
        char c = 0;
        while (length > 0) {
            int length2 = i2 % str2.length();
            char c2 = charArray[length2];
            c += c2;
            char charAt = str.charAt(((c2 + length2) + c) % length);
            String str3 = str.substring(0, i) + str.charAt(length) + str.substring(i + 1);
            str = str3.substring(0, length) + charAt + str3.substring(length + 1);
            length--;
            i2 = length2 + 1;
        }
        return str;
    }

    private String b(long... jArr) {
        String a;
        char c = 0;
        for (int i = 0; i < jArr.length; i++) {
            c = (int) (c + (jArr[i] % (i + 100)));
        }
        String str = this.b;
        char c2 = str.toCharArray()[c % str.length()];
        String str2 = c2 + "";
        char c3 = 0;
        while (true) {
            char c4 = c3;
            if (c4 >= jArr.length) {
                break;
            }
            long j = jArr[c4];
            str = b(str, (c2 + this.a + str).substring(0, str.length()));
            String str3 = str2 + a(j, str);
            int i2 = c4 + 1;
            str2 = str3;
            if (i2 < jArr.length) {
                int length = (int) ((j % (a.toCharArray()[0] + c4)) % this.c.length());
                str2 = str3 + this.c.toCharArray()[length];
            }
            c3 = i2;
        }
        String str4 = str2;
        if (str2.length() < this.d) {
            String str5 = this.e.toCharArray()[(str2.toCharArray()[0] + c) % this.e.length()] + str2;
            str4 = str5;
            if (str5.length() < this.d) {
                str4 = str5 + this.e.toCharArray()[(c + str5.toCharArray()[2]) % this.e.length()];
            }
        }
        int length2 = str.length() / 2;
        while (str4.length() < this.d) {
            str = b(str, str);
            String str6 = str.substring(length2) + str4 + str.substring(0, length2);
            int length3 = str6.length();
            int i3 = this.d;
            int i4 = length3 - i3;
            str4 = str6;
            if (i4 > 0) {
                int i5 = i4 / 2;
                str4 = str6.substring(i5, i3 + i5);
            }
        }
        return str4;
    }

    private Long c(String str, String str2) {
        char[] charArray = str.toCharArray();
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return Long.valueOf(j);
            }
            j = (long) (j + (str2.indexOf(charArray[i2]) * Math.pow(str2.length(), (str.length() - i2) - 1)));
            i = i2 + 1;
        }
    }

    public String a(long... jArr) {
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return jArr.length == 0 ? "" : b(jArr);
            } else if (jArr[i2] > 9007199254740992L) {
                throw new IllegalArgumentException("number can not be greater than 9007199254740992L");
            } else {
                i = i2 + 1;
            }
        }
    }

    public long[] a(String str) {
        return str.equals("") ? new long[0] : a(str, this.b);
    }
}
