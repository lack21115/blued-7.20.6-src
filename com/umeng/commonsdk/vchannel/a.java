package com.umeng.commonsdk.vchannel;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/vchannel/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f27278a = "https://pslog.umeng.com";
    public static String b = "https://pslog.umeng.com/";

    /* renamed from: c  reason: collision with root package name */
    public static String f27279c = "explog";
    public static final String d = "analytics";
    public static final String e = "ekv";
    public static final String f = "id";
    public static final String g = "ts";
    public static final String h = "ds";
    public static final String i = "pn";
    public static String j = "";

    static {
        String str = "SUB" + System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
        j = sb.toString();
    }
}
