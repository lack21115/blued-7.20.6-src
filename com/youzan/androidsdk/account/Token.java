package com.youzan.androidsdk.account;

import android.content.Context;
import com.youzan.androidsdk.YouzanToken;
import com.youzan.androidsdk.tool.Preference;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/account/Token.class */
public class Token {
    public static void clear(Context context) {
        Preference.renew(context);
        m9182(null);
        m9184(null);
        m9185(null);
        m9183(null);
    }

    public static String getAccessToken() {
        try {
            return Preference.instance().getString("token.access_token", null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getCookieKey() {
        return Preference.instance().getString("token.cookie_key", null);
    }

    public static String getCookieValue() {
        return Preference.instance().getString("token.cookie_value", null);
    }

    public static String getYzOpenId() {
        return Preference.instance().getString("token.yz_open_id", null);
    }

    public static void save(YouzanToken youzanToken) {
        m9182(youzanToken.getAccessToken());
        m9184(youzanToken.getCookieKey());
        m9185(youzanToken.getCookieValue());
        m9183(youzanToken.getYzOpenId());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m9182(String str) {
        Preference.instance().setString("token.access_token", str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m9183(String str) {
        Preference.instance().setString("token.yz_open_id", str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m9184(String str) {
        Preference.instance().setString("token.cookie_key", str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m9185(String str) {
        Preference.instance().setString("token.cookie_value", str);
    }
}
