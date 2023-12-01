package com.youzan.androidsdk.account;

import android.content.Context;
import com.youzan.androidsdk.YouzanToken;
import com.youzan.androidsdk.tool.Preference;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/account/Token.class */
public class Token {
    public static void clear(Context context) {
        Preference.renew(context);
        m12232(null);
        m12234(null);
        m12235(null);
        m12233(null);
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
        m12232(youzanToken.getAccessToken());
        m12234(youzanToken.getCookieKey());
        m12235(youzanToken.getCookieValue());
        m12233(youzanToken.getYzOpenId());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m12232(String str) {
        Preference.instance().setString("token.access_token", str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m12233(String str) {
        Preference.instance().setString("token.yz_open_id", str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m12234(String str) {
        Preference.instance().setString("token.cookie_key", str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m12235(String str) {
        Preference.instance().setString("token.cookie_value", str);
    }
}
