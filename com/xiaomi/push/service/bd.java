package com.xiaomi.push.service;

import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bd.class */
public class bd {

    /* renamed from: a  reason: collision with root package name */
    private static long f27936a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static String f952a = "";

    public static String a() {
        if (TextUtils.isEmpty(f952a)) {
            f952a = com.xiaomi.push.bn.a(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f952a);
        long j = f27936a;
        f27936a = 1 + j;
        sb.append(j);
        return sb.toString();
    }

    public static String a(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() < 32) {
                return str;
            }
            try {
                return "BlockId_" + str.substring(8);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("Exception occurred when filtering registration packet id for log. ".concat(String.valueOf(e)));
                str2 = "UnexpectedId";
            }
        }
        return str2;
    }

    public static String b() {
        return com.xiaomi.push.bn.a(32);
    }
}
