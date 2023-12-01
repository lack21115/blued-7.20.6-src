package com.oplus.log.d;

import android.os.Build;
import android.provider.Downloads;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.sobot.network.http.model.SobotProgress;
import com.tencent.tendinsv.a.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/d/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24364a = k.class.getName();

    public static String a(String str, String str2, long j, int i, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, com.oplus.log.a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("specificId", str);
        hashMap.put("reportReason", str2);
        hashMap.put("ts", String.valueOf(j));
        hashMap.put("businessVersion", b.c(b.a()));
        hashMap.put("protocolVersion", "3");
        hashMap.put("errorCode", String.valueOf(i));
        hashMap.put("subType", str3);
        hashMap.put("brand", f.b());
        hashMap.put("model", Build.MODEL);
        hashMap.put(b.a.l, f.c());
        hashMap.put(b.a.m, f.a());
        hashMap.put("androidVersion", Build.VERSION.RELEASE);
        hashMap.put("imei", str4.replace("%23", "#"));
        hashMap.put("openId", str5.replace("%23", "#"));
        hashMap.put("tracePkg", str6);
        hashMap.put("program", str7);
        if (!TextUtils.isEmpty(str8)) {
            hashMap.put(SobotProgress.FILE_NAME, str8);
        }
        if (!TextUtils.isEmpty(str9)) {
            hashMap.put(Downloads.Impl.COLUMN_ERROR_MSG, str9);
        }
        String str12 = str10 + File.separator + str8;
        String a2 = a(hashMap);
        aVar.a("NearX-HLog", "签名生成空格替换前参数: " + a2 + "url: " + str12);
        String replaceAll = a2.replaceAll(" ", BridgeUtil.UNDERLINE_STR);
        byte[] bytes = replaceAll.getBytes();
        byte[] a3 = h.a(h.b(str12));
        if (a3 == null) {
            Log.e("SecurityUtils", "log zip file is null");
        } else {
            byte[] bArr = new byte[bytes.length + a3.length];
            System.arraycopy((Object) bytes, 0, (Object) bArr, 0, bytes.length);
            System.arraycopy((Object) a3, 0, (Object) bArr, bytes.length, a3.length);
            bytes = bArr;
        }
        String a4 = a(bytes, str11);
        aVar.a("NearX-HLog", "签名生成空格替换后参数: " + replaceAll + "url: " + str12 + "\n sign: " + a4);
        return a4;
    }

    private static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            sb.append(str);
            sb.append("=");
            sb.append(map.get(str));
            sb.append("&");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            if ((bArr[i2] & 255) < 16) {
                sb.append("0");
            }
            sb.append(Long.toString(bArr[i2] & 255, 16));
            i = i2 + 1;
        }
    }

    private static String a(byte[] bArr, String str) {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(str.getBytes("UTF-8"), mac.getAlgorithm()));
            return a(mac.doFinal(bArr));
        } catch (Exception e) {
            throw new RuntimeException("HMAC-SHA1 encode error", e);
        }
    }
}
