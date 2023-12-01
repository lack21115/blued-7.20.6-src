package com.igexin.push.f;

import java.util.Random;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/p.class */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f10057a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz`~!@#$%^&*()-_=+[{}];:'/?.>,<".toCharArray();

    public static String a() {
        StringBuilder sb = new StringBuilder(16);
        Random random = new Random();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 16) {
                return sb.toString();
            }
            char[] cArr = f10057a;
            sb.append(cArr[random.nextInt(cArr.length)]);
            i = i2 + 1;
        }
    }

    public static String b() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 16) {
                return sb.toString();
            }
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(62)));
            i = i2 + 1;
        }
    }

    private static long c() {
        return (new Random().nextInt(6) + 2) * 60000;
    }
}
