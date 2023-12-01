package com.youzan.androidsdk.account;

import android.content.Context;
import android.text.TextUtils;
import com.youzan.androidsdk.tool.Preference;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/account/Shop.class */
public class Shop {
    public static void clear(Context context) {
        Preference.renew(context);
        setSid(null);
        setShopName(null);
        setShopLogo(null);
        setShopUrl(null);
        setShopCertType(Integer.MIN_VALUE);
    }

    public static int getShopCertType() {
        return Preference.instance().getInt("shop.cert_type", 0);
    }

    public static String getShopLogo() {
        return Preference.instance().getString("shop.logo", null);
    }

    public static String getShopName() {
        return Preference.instance().getString("shop.name", null);
    }

    public static String getShopUrl() {
        return Preference.instance().getString("shop.url", null);
    }

    public static String getSid() {
        return Preference.instance().getString("shop.sid", null);
    }

    public static boolean isValid(String str) {
        return TextUtils.equals(str, getSid()) && !TextUtils.isEmpty(getShopUrl());
    }

    public static void setShopCertType(int i) {
        Preference.instance().setInt("shop.cert_type", i);
    }

    public static void setShopLogo(String str) {
        Preference.instance().setString("shop.logo", str);
    }

    public static void setShopName(String str) {
        Preference.instance().setString("shop.name", str);
    }

    public static void setShopUrl(String str) {
        Preference.instance().setString("shop.url", str);
    }

    public static void setSid(String str) {
        Preference.instance().setString("shop.sid", str);
    }
}
