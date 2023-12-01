package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.g;
import com.huawei.secure.android.common.ssl.util.j;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/c.class */
public class c implements X509TrustManager {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9511c = "WebViewX509TrustManger";

    /* renamed from: a  reason: collision with root package name */
    private X509Certificate f9512a;
    private List<X509TrustManager> b = new ArrayList();

    public c(Context context) {
        if (context == null) {
            throw new NullPointerException("WebViewX509TrustManger context is null");
        }
        com.huawei.secure.android.common.ssl.util.c.a(context);
        X509Certificate b = new j(context).b();
        this.f9512a = b;
        if (b == null) {
            throw new NullPointerException("WebViewX509TrustManger cannot get cbg root ca");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.c(f9511c, "checkClientTrusted");
        if (this.b.isEmpty()) {
            throw new CertificateException("checkClientTrusted CertificateException");
        }
        this.b.get(0).checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.c(f9511c, "checkServerTrusted");
        boolean z = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= x509CertificateArr.length) {
                break;
            }
            g.a(f9511c, "checkServerTrusted " + i2 + " : " + x509CertificateArr[i2].getIssuerDN().getName());
            i = i2 + 1;
        }
        X509Certificate[] x509CertificateArr2 = new X509Certificate[x509CertificateArr.length];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= x509CertificateArr.length) {
                break;
            }
            x509CertificateArr2[i4] = x509CertificateArr[(x509CertificateArr.length - 1) - i4];
            i3 = i4 + 1;
        }
        CertificateException e = new CertificateException("CBG root CA CertificateException");
        try {
            z = com.huawei.secure.android.common.ssl.util.b.a(this.f9512a, x509CertificateArr2);
        } catch (InvalidKeyException e2) {
            g.b(f9511c, "checkServerTrusted InvalidKeyException: " + e2.getMessage());
        } catch (NoSuchAlgorithmException e3) {
            g.b(f9511c, "checkServerTrusted NoSuchAlgorithmException: " + e3.getMessage());
        } catch (NoSuchProviderException e4) {
            g.b(f9511c, "checkServerTrusted NoSuchProviderException: " + e4.getMessage());
        } catch (SignatureException e5) {
            g.b(f9511c, "checkServerTrusted SignatureException: " + e5.getMessage());
        } catch (CertificateException e6) {
            e = e6;
            g.b(f9511c, "checkServerTrusted CertificateException: " + e.getMessage());
        }
        if (!z) {
            throw e;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            for (X509TrustManager x509TrustManager : this.b) {
                arrayList.addAll(Arrays.asList(x509TrustManager.getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e) {
            g.b(f9511c, "getAcceptedIssuers exception : " + e.getMessage());
            return new X509Certificate[0];
        }
    }
}
