package com.tencent.tendinsv.utils;

import com.tencent.cos.xml.crypto.JceEncryptionConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/a.class */
public class a {
    public static String a(String str) {
        if (d.a(str)) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            String str2 = "";
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                String str3 = hexString;
                if (hexString.length() == 1) {
                    str3 = "0" + hexString;
                }
                str2 = str2 + str3;
            }
            return str2;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String a(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF_8"), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            return f.a(mac.doFinal(str.getBytes("UTF_8")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(Map<String, Object> map) {
        TreeSet<String> treeSet = new TreeSet(map.keySet());
        StringBuilder sb = new StringBuilder();
        for (String str : treeSet) {
            if (!"sign".equals(str)) {
                sb.append(str);
                sb.append(map.get(str));
            }
        }
        return a(sb.toString());
    }

    public static String a(Map<String, Object> map, String str) {
        TreeSet<String> treeSet = new TreeSet(map.keySet());
        StringBuilder sb = new StringBuilder();
        for (String str2 : treeSet) {
            if (!"sign".equals(str2)) {
                sb.append(str2);
                sb.append(map.get(str2));
            }
        }
        return a(sb.toString(), str);
    }

    public static JSONArray a(List<com.tencent.tendinsv.tool.e> list) {
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return jSONArray;
            }
            com.tencent.tendinsv.tool.e eVar = list.get(i2);
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONArray2.put(eVar.f39051a);
                jSONArray2.put(eVar.b);
                jSONArray2.put(eVar.f39052c);
                jSONArray2.put(eVar.d);
                jSONArray2.put(eVar.e);
                jSONArray2.put(eVar.f);
                jSONArray2.put(eVar.g);
                jSONArray2.put(eVar.h);
                jSONArray2.put(eVar.i);
                jSONArray2.put(eVar.j);
                jSONArray2.put(eVar.k);
                jSONArray2.put(eVar.l);
                jSONArray2.put(eVar.m);
                jSONArray2.put(eVar.n);
                jSONArray2.put(String.valueOf(eVar.o));
                jSONArray2.put(String.valueOf(eVar.p));
                jSONArray2.put(eVar.q);
                jSONArray2.put(eVar.r);
                jSONArray2.put(eVar.s);
                jSONArray2.put(eVar.t);
                jSONArray2.put(eVar.u);
                jSONArray2.put(String.valueOf(eVar.v));
                jSONArray2.put(eVar.w);
                jSONArray.put(jSONArray2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i2 + 1;
        }
    }

    public static byte[] a(byte[] bArr, String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            cipher.init(1, new SecretKeySpec(str.getBytes(), "AES"), new IvParameterSpec(str2.getBytes()));
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(Map<String, Object> map, String str) {
        TreeSet<String> treeSet = new TreeSet(map.keySet());
        StringBuilder sb = new StringBuilder();
        for (String str2 : treeSet) {
            if (!"sign".equals(str2)) {
                sb.append(map.get(str2));
            }
        }
        return a(sb.toString(), str);
    }

    public static JSONArray b(List<com.tencent.tendinsv.tool.f> list) {
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return jSONArray;
            }
            com.tencent.tendinsv.tool.f fVar = list.get(i2);
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONArray2.put(fVar.f39053a);
                jSONArray2.put(fVar.b);
                jSONArray2.put(fVar.f39054c);
                jSONArray2.put(fVar.d);
                jSONArray2.put(fVar.e);
                jSONArray2.put(fVar.f);
                jSONArray2.put(fVar.g);
                jSONArray2.put(fVar.h);
                jSONArray2.put(fVar.i);
                jSONArray.put(jSONArray2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tendinsv.utils.a.b(java.lang.String):byte[]");
    }
}
