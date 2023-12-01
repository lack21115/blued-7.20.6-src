package com.sobot.chat.core.a.b;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/b/c.class */
public class c {
    public static final String b = "^[\\u4e00-\\u9fa5]*$";

    /* renamed from: c  reason: collision with root package name */
    public static final String f14532c = "^[\\u4e00-\\u9fa5]{2,15}$";
    public static final String d = "^(((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8})|((\\d{3,4}-)?\\d{7,8}(-\\d{1,4})?)$";
    public static final String e = "w+([-+.]w+)*@w+([-.]w+)*.w+([-.]w+)*";
    public static final String f = "^(25[0-5]|2[0-4][0-9]|1{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|1{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|1{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|1{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$";
    public static final String g = "^6553[0-5]|655[0-2][0-9]|65[0-4][0-9]{2}|6[0-4][0-9]{3}|[1-5][0-9]{4}|[1-9][0-9]{0,3}$";

    /* renamed from: a  reason: collision with root package name */
    final c f14533a = this;

    public static boolean a(String str, int i, int i2) {
        return a(str, "^\\w{" + i + "," + i2 + "}$");
    }

    public static boolean a(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.matches(str2);
    }
}
