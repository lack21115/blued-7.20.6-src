package com.tencent.turingface.sdk.mfa;

import android.util.Base64;
import com.alipay.sdk.util.i;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/tfWT8.class */
public final class tfWT8 {
    public static final /* synthetic */ boolean e = !tfWT8.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public static final String f39996a = kC0XR.a(kC0XR.T0);
    public static final String b = kC0XR.a(kC0XR.P0);

    /* renamed from: c  reason: collision with root package name */
    public static final String f39997c = kC0XR.a(kC0XR.Q0);
    public static final String d = kC0XR.a(kC0XR.R0);

    public static String a(Certificate certificate) throws Exception {
        int i;
        int i2;
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        bufferedWriter.write("-----BEGIN CERTIFICATE-----");
        bufferedWriter.write("\n");
        byte[] encode = Base64.encode(certificate.getEncoded(), 2);
        char[] cArr = new char[64];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= encode.length) {
                bufferedWriter.write("-----END CERTIFICATE-----");
                bufferedWriter.write("\n");
                bufferedWriter.close();
                return stringWriter.toString();
            }
            int i5 = 0;
            while (true) {
                i = i5;
                if (i != 64 && (i2 = i4 + i) < encode.length) {
                    cArr[i] = (char) encode[i2];
                    i5 = i + 1;
                }
            }
            bufferedWriter.write(cArr, 0, i);
            bufferedWriter.write("\n");
            i3 = i4 + 64;
        }
    }

    public static void a(X509Certificate x509Certificate, F2BEC f2bec) throws Exception, IOException {
        int i;
        byte[] extensionValue = x509Certificate.getExtensionValue(f39996a);
        if (extensionValue == null || extensionValue.length == 0) {
            throw new Exception("Couldn't find the keystore attestation extension data.");
        }
        try {
            byte b2 = "{".getBytes()[0];
            byte b3 = i.d.getBytes()[0];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < extensionValue.length) {
                byte b4 = extensionValue[i2];
                if (b4 == b2) {
                    i = i2;
                } else {
                    i = i3;
                    if (b4 == b3) {
                        i4 = i2;
                        i = i3;
                    }
                }
                i2++;
                i3 = i;
            }
            if (i3 <= 0 || i3 >= i4) {
                return;
            }
            if (!e && extensionValue[i3 - 1] != (i4 - i3) + 1) {
                throw new AssertionError();
            }
            int i5 = (i4 - i3) + 1;
            byte[] bArr = new byte[i5];
            System.arraycopy((Object) extensionValue, i3, (Object) bArr, 0, i5);
            JSONObject jSONObject = new JSONObject(new String(bArr));
            f2bec.h = jSONObject.getString(f39997c);
            f2bec.g = jSONObject.getInt(d);
            f2bec.f = jSONObject.getLong(b);
        } catch (Exception e2) {
            StringBuilder b5 = com.tencent.turingcam.oqKCa.b("C");
            b5.append(e2.getStackTrace());
            throw new Exception(b5.toString());
        }
    }
}
