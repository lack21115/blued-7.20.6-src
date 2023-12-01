package com.tencent.cloud.huiyansdkface.facelight.common;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.cloud.huiyansdkface.facelight.c.b.d;
import com.tencent.cloud.huiyansdkface.facelight.c.e.a;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/common/WbCloudNetSecurityManger.class */
public class WbCloudNetSecurityManger {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21898a = WbCloudNetSecurityManger.class.getSimpleName();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/common/WbCloudNetSecurityManger$ResultCallback.class */
    public interface ResultCallback<T> {
        void callback(T t);
    }

    public static String base64Encry(boolean z, String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new Exception("base64Encry src or key is null,please check!");
        }
        byte[] a2 = WbSecureProviders.secureType(z).a(str.getBytes(), str2.getBytes(), null);
        return a2 == null ? "" : Base64.encodeToString(a2, 2);
    }

    public static String byteToHexString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() < 2) {
                sb.append("0");
            }
            sb.append(hexString);
            i = i2 + 1;
        }
    }

    public static <T> T decry(boolean z, String str, Class<T> cls, String str2) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new Exception("decry encryString or key is null,please check!");
        }
        WeJson weJson = new WeJson();
        byte[] b = WbSecureProviders.secureType(z).b(hexStringToBytes(str), str2.getBytes(), null);
        if (b != null) {
            T t = (T) weJson.fromJson(new String(b, "utf8"), (Class<Object>) cls);
            if (t != null) {
                return t;
            }
            throw new Exception("decry Result failed!");
        }
        throw new Exception("symmetricDecry failed!");
    }

    public static <T> void decryAsyn(final boolean z, final String str, final Class<T> cls, final String str2, final ResultCallback<T> resultCallback) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new Exception("decry encryString or key is null,please check!");
        }
        hexStringToBytesAsyn(str, new ResultCallback<byte[]>() { // from class: com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger.ResultCallback
            /* renamed from: a */
            public void callback(byte[] bArr) {
                try {
                    byte[] b = WbSecureProviders.secureType(z).b(WbCloudNetSecurityManger.hexStringToBytes(str), str2.getBytes(), null);
                    if (b == null) {
                        throw new Exception("decryAsyn failed!");
                    }
                    resultCallback.callback(new WeJson().fromJson(new String(b, "utf8"), (Class<Object>) cls));
                } catch (Exception e) {
                    e.printStackTrace();
                    resultCallback.callback(null);
                }
            }
        });
    }

    public static String encryptAESKey(boolean z, String str, String str2) {
        String str3;
        try {
            str3 = WbSecureProviders.secureType(z).a(str.getBytes("utf8"));
            try {
                WLogger.d(f21898a, "get enKey:" + str3);
                return str3;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                WLogger.w(f21898a, "enKey failed:" + e.toString());
                KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_encry_enkey_fail", str2 + e.toString(), null);
                return str3;
            }
        } catch (Exception e2) {
            e = e2;
            str3 = null;
        }
    }

    public static String generateAESKey() {
        String a2 = a.a();
        String str = a2;
        if (TextUtils.isEmpty(a2)) {
            str = a.a();
        }
        return str;
    }

    public static String hexEncry(boolean z, byte[] bArr, String str) throws Exception {
        if (bArr == null || TextUtils.isEmpty(str)) {
            throw new Exception("hexEncry src or key is null,please check!");
        }
        return byteToHexString(WbSecureProviders.secureType(z).a(bArr, str.getBytes(), null));
    }

    public static byte[] hexStringToBytes(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
            i = i2 + 1;
        }
    }

    public static void hexStringToBytesAsyn(final String str, final ResultCallback<byte[]> resultCallback) {
        new d().a(new Callable<byte[]>() { // from class: com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public byte[] call() throws Exception {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return bArr;
                    }
                    int i3 = i2 * 2;
                    bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
                    i = i2 + 1;
                }
            }
        }, new d.a<byte[]>() { // from class: com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger.3
            @Override // com.tencent.cloud.huiyansdkface.facelight.c.b.d.a
            public void a(byte[] bArr) {
                ResultCallback.this.callback(bArr);
            }
        });
    }
}
