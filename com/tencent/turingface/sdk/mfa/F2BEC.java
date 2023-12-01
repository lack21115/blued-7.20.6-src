package com.tencent.turingface.sdk.mfa;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/F2BEC.class */
public final class F2BEC {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26179a = kC0XR.a(kC0XR.O0);
    public static final String b = kC0XR.a(kC0XR.P0);

    /* renamed from: c  reason: collision with root package name */
    public static final String f26180c = kC0XR.a(kC0XR.Q0);
    public static final String d = kC0XR.a(kC0XR.R0);
    public static final String e = kC0XR.a(kC0XR.S0);
    public long f;
    public int g;
    public String h;
    public ArrayList<String> i;

    public F2BEC(String str) {
        this.f = -1L;
        this.g = -1;
        this.h = "";
        this.i = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str2 = e;
            if (!jSONObject.has(str2)) {
                this.f = jSONObject.optLong(b);
                this.g = jSONObject.optInt(d);
                this.h = jSONObject.optString(f26180c);
                jSONObject.optString(f26179a);
                return;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(str2);
            optJSONArray.length();
            this.i = new ArrayList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(this.i.get(0).getBytes())));
                    jSONObject.put(f26180c, this.h);
                    jSONObject.put(d, this.g);
                    jSONObject.put(b, this.f);
                    jSONObject.toString();
                    return;
                }
                this.i.add(optJSONArray.getString(i2));
                i = i2 + 1;
            }
        } catch (Exception e2) {
        }
    }

    public F2BEC(Certificate[] certificateArr) {
        this.f = -1L;
        this.g = -1;
        this.h = "";
        this.i = null;
        if (certificateArr == null) {
            return;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= certificateArr.length) {
                    this.i = arrayList;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(e, jSONArray);
                    jSONObject.put(f26180c, this.h);
                    jSONObject.put(d, this.g);
                    jSONObject.put(b, this.f);
                    jSONObject.toString();
                    return;
                }
                Certificate certificate = certificateArr[i2];
                Base64.encodeToString(certificate.getEncoded(), 2);
                String a2 = tfWT8.a(certificate);
                if (i2 == 0) {
                    a((X509Certificate) certificate);
                }
                jSONArray.put(a2);
                arrayList.add(a2);
                i = i2 + 1;
            }
        } catch (Exception e2) {
        }
    }

    public final void a(X509Certificate x509Certificate) {
        try {
            tfWT8.a(x509Certificate, this);
        } catch (Exception e2) {
        }
    }
}
