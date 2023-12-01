package com.amap.api.col.p0003sl;

import android.opengl.EGL14;
import com.google.android.material.timepicker.TimeModel;
import java.util.Locale;
import java.util.Random;

/* renamed from: com.amap.api.col.3sl.do  reason: invalid class name and invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/do.class */
public final class Cdo {

    /* renamed from: a  reason: collision with root package name */
    private static String f4860a = "0123456789";

    /* renamed from: com.amap.api.col.3sl.do$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/do$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f4861a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f4862c;

        public a() {
            this((byte) 0);
        }

        private a(byte b) {
            this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 11);
        }

        public a(String str, int i) {
            this.b = 1103515245;
            this.f4862c = EGL14.EGL_BIND_TO_TEXTURE_RGB;
            this.f4861a = a(str, i, str.length());
        }

        private char a(int i) {
            this.f4861a.length();
            return this.f4861a.charAt(i);
        }

        private int a(char c2) {
            this.f4861a.length();
            return this.f4861a.indexOf(c2);
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
            return (int) (((i * this.b) + this.f4862c) & 2147483647L);
        }

        private String b(int i, String str) {
            int a2;
            StringBuilder sb = new StringBuilder();
            int length = this.f4861a.length();
            int length2 = str.length();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length2 || (a2 = a(str.charAt(i3))) < 0) {
                    break;
                }
                sb.append(a(((a2 + i) + i3) % length));
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
        String a2 = new a(f4860a, nextInt2).a(nextInt, format);
        return a2 + String.format(Locale.US, "%01d", Integer.valueOf(nextInt)) + String.format(Locale.US, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(nextInt2));
    }
}
