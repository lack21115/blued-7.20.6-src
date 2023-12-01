package com.alibaba.mtl.log.e;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.SdkMeta;
import com.alibaba.mtl.log.model.LogField;
import com.alibaba.mtl.log.sign.IRequestAuth;
import com.alibaba.mtl.log.sign.SecurityRequestAuth;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/t.class */
public class t {
    private static final String TAG = t.class.getSimpleName();

    private static String a(String str, String str2, String str3, String str4) throws Exception {
        String str5;
        Context context = com.alibaba.mtl.log.a.getContext();
        String appkey = b.getAppkey();
        String l = b.l();
        String str6 = l;
        if (l == null) {
            str6 = "";
        }
        String str7 = d.a(context).get(LogField.APPVERSION.toString());
        String str8 = d.a(context).get(LogField.OS.toString());
        String str9 = d.a(context).get(LogField.UTDID.toString());
        String valueOf = String.valueOf(System.currentTimeMillis());
        IRequestAuth a2 = com.alibaba.mtl.log.a.a();
        String str10 = "0";
        Object obj = "1";
        if (a2 instanceof SecurityRequestAuth) {
            obj = "0";
            str10 = "1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(appkey);
        sb.append(str6);
        sb.append(str7);
        sb.append(str8);
        sb.append(SdkMeta.SDK_VERSION);
        sb.append(str9);
        sb.append(valueOf);
        sb.append("3.0");
        sb.append(str10);
        if (str3 == null) {
            str3 = "";
        }
        sb.append(str3);
        if (str4 == null) {
            str4 = "";
        }
        sb.append(str4);
        String sign = a2.getSign(j.b(sb.toString().getBytes()));
        if (TextUtils.isEmpty(str2)) {
            str5 = "";
        } else {
            str5 = str2 + "&";
        }
        return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s&k=%s", str, str5, e(appkey), e(str7), e(str6), e("3.0"), e(sign), e(str9), SdkMeta.SDK_VERSION, str8, valueOf, "", str10, obj);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(7:5|(2:6|(1:8)(0))|10|11|(1:13)|14|15)(0))(0)|9|10|11|(0)|14|15) */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x00a1, code lost:
        r5 = a(com.alibaba.mtl.log.a.a.M, null, null, r10);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r5, java.util.Map<java.lang.String, java.lang.Object> r6, java.util.Map<java.lang.String, java.lang.Object> r7) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.t.a(java.lang.String, java.util.Map, java.util.Map):java.lang.String");
    }

    public static String b(String str, Map<String, Object> map, Map<String, Object> map2) throws Exception {
        if (map == null) {
            new HashMap();
        }
        Context context = com.alibaba.mtl.log.a.getContext();
        String appkey = b.getAppkey();
        String l = b.l();
        String str2 = l;
        if (l == null) {
            str2 = "";
        }
        String str3 = d.a(context).get(LogField.APPVERSION.toString());
        String str4 = d.a(context).get(LogField.OS.toString());
        String str5 = d.a(context).get(LogField.UTDID.toString());
        String valueOf = String.valueOf(System.currentTimeMillis());
        IRequestAuth a2 = com.alibaba.mtl.log.a.a();
        String str6 = a2 instanceof SecurityRequestAuth ? "1" : "0";
        String sign = a2.getSign(j.b((appkey + str3 + str2 + str4 + str5 + SdkMeta.SDK_VERSION + valueOf + str6 + map.get("_b01n15") + map.get("_b01na")).getBytes()));
        return str + "?ak=" + appkey + "&" + com.alipay.sdk.sys.a.k + "=" + str3 + "&c=" + URLEncoder.encode(str2) + "&d=" + str5 + "&sv=" + SdkMeta.SDK_VERSION + "&t=" + valueOf + "&is=" + str6 + "&_b01n15=" + map.get("_b01n15") + "&_b01na=" + map.get("_b01na") + "&s=" + sign;
    }

    private static String e(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
