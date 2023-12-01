package com.amap.api.col.p0003sl;

import java.util.Locale;
import java.util.Random;

/* renamed from: com.amap.api.col.3sl.do  reason: invalid class name and invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/do.class */
public final class Cdo {
    private static String a = "0123456789";

    /* renamed from: com.amap.api.col.3sl.do$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/do$a.class */
    static final class a {
        private String a;
        private int b;
        private int c;

        public a() {
            this((byte) 0);
        }

        private a(byte b) {
            this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 11);
        }

        public a(String str, int i) {
            this.b = 1103515245;
            this.c = 12345;
            this.a = a(str, i, str.length());
        }

        private char a(int i) {
            this.a.length();
            return this.a.charAt(i);
        }

        private int a(char c) {
            this.a.length();
            return this.a.indexOf(c);
        }

        private String a(String str, int i, int i2) {
            StringBuffer stringBuffer = new StringBuffer(str);
            int length = str.length();
            int i3 = i;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i2) {
                    return stringBuffer.toString();
                }
                int b = b(i3);
                int i6 = b % length;
                i3 = b(b);
                int i7 = i3 % length;
                char charAt = stringBuffer.charAt(i6);
                stringBuffer.setCharAt(i6, stringBuffer.charAt(i7));
                stringBuffer.setCharAt(i7, charAt);
                i4 = i5 + 1;
            }
        }

        private int b(int i) {
            return (int) (((i * this.b) + this.c) & 2147483647L);
        }

        private String b(int i, String str) {
            int a;
            StringBuilder sb = new StringBuilder();
            int length = this.a.length();
            int length2 = str.length();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length2 || (a = a(str.charAt(i3))) < 0) {
                    break;
                }
                sb.append(a(((a + i) + i3) % length));
                i2 = i3 + 1;
            }
            if (sb.length() == length2) {
                return sb.toString();
            }
            return null;
        }

        public final String a(int i, String str) {
            return b(i, str);
        }
    }

    public static String a() {
        Random random = new Random();
        String format = String.format(Locale.US, "%05d", Integer.valueOf(random.nextInt(10)));
        int nextInt = random.nextInt(10);
        int nextInt2 = random.nextInt(100);
        String a2 = new a(a, nextInt2).a(nextInt, format);
        return a2 + String.format(Locale.US, "%01d", Integer.valueOf(nextInt)) + String.format(Locale.US, "%02d", Integer.valueOf(nextInt2));
    }
}
