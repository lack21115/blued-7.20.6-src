package com.huawei.openalliance.ad.constant;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.ge;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/constant/cj.class */
public class cj {
    private static final String B = "com.huawei.fastapp.dev";
    private static final String Code = "WhiteListPkgList";
    private static final String D = "com.huawei.browser";
    private static final String S = "com.hihonor.fastapp";
    private static final String V = "com.huawei.appmarket";
    private static final String Z = "com.huawei.fastapp";

    /* renamed from: a  reason: collision with root package name */
    private static final String f22948a = "com.hicloud.browser";

    /* renamed from: c  reason: collision with root package name */
    private static final String f22949c = "com.android.browser";
    private static final String e = "com.hihonor.browser";
    private static final Map<String, List<String>> g;
    private static final String h = "com.petal.litegames";
    private static final String[] i;
    private static final String[] I = {"ffe391e0ea186d0734ed601e4e70e3224b7309d48e2075bac46d8c667eae7212", "3baf59a2e5331c30675fab35ff5fff0d116142d3d4664f1c3cb804068b40614f"};
    private static final String[] C = {"b92825c2bd5d6d6d1e7f39eecd17843b7d9016f611136b75441bc6f4d3f00f05", "59321357AB0A6BACBE3D32665B0084DCBB709B1D234EC684431AAEC5A0F0B8B1"};
    private static final String[] F = {t.aX};
    private static final String[] L = {t.aZ};
    private static final String[] b = {t.bb};
    private static final String[] d = {"bbe2ff269828a0d922498ee87f65afe769c27d62f489d5c19b9cc6c444c80811", "d8a4db56b7ebc39fe5f3004215f0e0decb43b9cfcbe9b2d948383fedd434e7d9", t.aZ};
    private static final String[] f = {"22dcb04cfaa28f382b613794eba4441a8bcb1dbc8576776f1b1e6a457b00d449"};

    static {
        HashMap hashMap = new HashMap();
        g = hashMap;
        i = new String[]{"A9436644E0BD71FF512C63839F8AC27114399F36956958688555DFCC63257EDE"};
        hashMap.put(e, Arrays.asList(f));
        g.put("com.android.browser", Arrays.asList(d));
        g.put("com.huawei.browser", Arrays.asList(L));
        g.put("com.huawei.appmarket", Arrays.asList(I));
        g.put("com.huawei.hwid", Arrays.asList("b92825c2bd5d6d6d1e7f39eecd17843b7d9016f611136b75441bc6f4d3f00f05"));
        g.put("com.huawei.hwid.tv", Arrays.asList("3517262215d8d3008cbf888750b6418edc4d562ac33ed6874e0d73aba667bc3c"));
        g.put("com.huawei.hms", Arrays.asList("e49d5c2c0e11b3b1b96ca56c6de2a14ec7dab5ccc3b5f300d03e5b4dba44f539"));
        g.put("com.huawei.fastapp", Arrays.asList(C));
        g.put("com.huawei.fastapp.dev", Arrays.asList(C));
        g.put("com.hihonor.fastapp", Arrays.asList(F));
        g.put("com.hicloud.browser", Arrays.asList(b));
        g.put(h, Arrays.asList(i));
    }

    public static boolean Code(Context context, String str, String str2) {
        boolean Code2 = Code(str, str2);
        boolean z = Code2;
        if (!Code2) {
            z = V(context, str, str2);
        }
        return z;
    }

    public static boolean Code(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            ge.Z(Code, "inWhiteList invalid input");
            return false;
        }
        return Code(g.get(str), str2);
    }

    private static boolean Code(List<String> list, String str) {
        if (list != null) {
            for (String str2 : list) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean V(Context context, String str, String str2) {
        String str3;
        String Code2 = fk.Code(context).Code();
        if (TextUtils.isEmpty(Code2)) {
            str3 = "inTrustAppList trustAppList is empty";
        } else {
            com.huawei.openalliance.ad.beans.metadata.b bVar = (com.huawei.openalliance.ad.beans.metadata.b) com.huawei.openalliance.ad.utils.z.V(Code2, com.huawei.openalliance.ad.beans.metadata.b.class, new Class[0]);
            if (bVar == null) {
                str3 = "inTrustAppList toObjectNoException is null";
            } else {
                Map<String, List<String>> Code3 = bVar.Code();
                if (Code3 == null) {
                    str3 = "inTrustAppList map is null";
                } else {
                    List<String> list = Code3.get(str);
                    if (list != null) {
                        return Code(list, str2);
                    }
                    str3 = "inTrustAppList signList is null";
                }
            }
        }
        ge.V(Code, str3);
        return false;
    }
}
