package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/connect/auth/AuthMap.class */
public class AuthMap {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f22475a = !AuthMap.class.desiredAssertionStatus();
    private static int b = 0;
    public static AuthMap sInstance;
    public HashMap<String, Auth> authMap = new HashMap<>();
    public final String KEY_CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/connect/auth/AuthMap$Auth.class */
    public static class Auth {
        public AuthDialog dialog;
        public String key;
        public IUiListener listener;
    }

    private String a(String str, String str2) {
        if (f22475a || str.length() % 2 == 0) {
            StringBuilder sb = new StringBuilder();
            int length = str2.length();
            int length2 = str.length() / 2;
            int i = 0;
            for (int i2 = 0; i2 < length2; i2++) {
                int i3 = i2 * 2;
                sb.append((char) (Integer.parseInt(str.substring(i3, i3 + 2), 16) ^ str2.charAt(i)));
                i = (i + 1) % length;
            }
            return sb.toString();
        }
        throw new AssertionError();
    }

    public static AuthMap getInstance() {
        if (sInstance == null) {
            sInstance = new AuthMap();
        }
        return sInstance;
    }

    public static int getSerial() {
        int i = b + 1;
        b = i;
        return i;
    }

    public String decode(String str, String str2) {
        return a(str, str2);
    }

    public Auth get(String str) {
        return this.authMap.get(str);
    }

    public String makeKey() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= ceil) {
                return stringBuffer.toString();
            }
            stringBuffer.append(charArray[(int) (Math.random() * length)]);
            i = i2 + 1;
        }
    }

    public void remove(String str) {
        this.authMap.remove(str);
    }

    public String set(Auth auth) {
        int serial = getSerial();
        try {
            HashMap<String, Auth> hashMap = this.authMap;
            hashMap.put("" + serial, auth);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + serial;
    }
}
