package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.youzan.androidsdk.tool.AppSigning;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/HttpsCertificateUtils.class */
public class HttpsCertificateUtils {
    public static String getCertificate(String str) {
        String trim = str.trim();
        StringBuilder sb = new StringBuilder();
        sb.append("-----BEGIN CERTIFICATE-----\n");
        int length = trim.length();
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = i2 + 64;
            if (i3 >= length) {
                break;
            }
            String substring = trim.substring(i2, i3);
            sb.append(substring + "\n");
            i = i3;
        }
        int i4 = length % 64;
        if (i4 > 0) {
            sb.append(trim.substring(length - i4, length) + "\n");
        }
        sb.append("-----END CERTIFICATE-----");
        return sb.toString();
    }

    public static String getFingerPrint(String str) {
        try {
            return ByteString.of(MessageDigest.getInstance(AppSigning.SHA256).digest(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(str.getBytes()))).getPublicKey().getEncoded())).hex();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
