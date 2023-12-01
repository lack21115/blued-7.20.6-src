package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/util/j.class */
public class j {
    private static final String b = "X509CertificateUtil";

    /* renamed from: c  reason: collision with root package name */
    public static final String f23135c = "hmsrootcas.bks";
    public static final String d = "";
    public static final String e = "bks";
    public static final String f = "052root";
    private static final String g = "hmsincas.bks";
    private static final String h = "huawei cbg application integration ca";

    /* renamed from: a  reason: collision with root package name */
    private Context f23136a;

    public j(Context context) {
        this.f23136a = context;
    }

    public X509Certificate a() {
        return a(g, h);
    }

    public X509Certificate a(String str, String str2) {
        InputStream inputStream;
        InputStream inputStream2;
        X509Certificate x509Certificate;
        KeyStore keyStore;
        InputStream inputStream3 = null;
        try {
            try {
                keyStore = KeyStore.getInstance(e);
                inputStream2 = this.f23136a.getAssets().open(str);
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
                StringBuilder sb = new StringBuilder();
                InputStream inputStream4 = inputStream;
                sb.append("loadBksCA: exception : ");
                InputStream inputStream5 = inputStream;
                sb.append(e.getMessage());
                inputStream3 = inputStream;
                g.b(b, sb.toString());
                inputStream2 = inputStream;
                x509Certificate = null;
                f.a(inputStream2);
                return x509Certificate;
            } catch (KeyStoreException e3) {
                e = e3;
                inputStream = null;
                StringBuilder sb2 = new StringBuilder();
                InputStream inputStream42 = inputStream;
                sb2.append("loadBksCA: exception : ");
                InputStream inputStream52 = inputStream;
                sb2.append(e.getMessage());
                inputStream3 = inputStream;
                g.b(b, sb2.toString());
                inputStream2 = inputStream;
                x509Certificate = null;
                f.a(inputStream2);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                inputStream = null;
                StringBuilder sb22 = new StringBuilder();
                InputStream inputStream422 = inputStream;
                sb22.append("loadBksCA: exception : ");
                InputStream inputStream522 = inputStream;
                sb22.append(e.getMessage());
                inputStream3 = inputStream;
                g.b(b, sb22.toString());
                inputStream2 = inputStream;
                x509Certificate = null;
                f.a(inputStream2);
                return x509Certificate;
            } catch (CertificateException e5) {
                e = e5;
                inputStream = null;
                StringBuilder sb222 = new StringBuilder();
                InputStream inputStream4222 = inputStream;
                sb222.append("loadBksCA: exception : ");
                InputStream inputStream5222 = inputStream;
                sb222.append(e.getMessage());
                inputStream3 = inputStream;
                g.b(b, sb222.toString());
                inputStream2 = inputStream;
                x509Certificate = null;
                f.a(inputStream2);
                return x509Certificate;
            } catch (Throwable th) {
                th = th;
                f.a(inputStream3);
                throw th;
            }
            try {
                inputStream2.reset();
                keyStore.load(inputStream2, "".toCharArray());
                inputStream3 = inputStream2;
                x509Certificate = (X509Certificate) keyStore.getCertificate(str2);
            } catch (IOException e6) {
                inputStream = inputStream2;
                e = e6;
                StringBuilder sb2222 = new StringBuilder();
                InputStream inputStream42222 = inputStream;
                sb2222.append("loadBksCA: exception : ");
                InputStream inputStream52222 = inputStream;
                sb2222.append(e.getMessage());
                inputStream3 = inputStream;
                g.b(b, sb2222.toString());
                inputStream2 = inputStream;
                x509Certificate = null;
                f.a(inputStream2);
                return x509Certificate;
            } catch (KeyStoreException e7) {
                inputStream = inputStream2;
                e = e7;
                StringBuilder sb22222 = new StringBuilder();
                InputStream inputStream422222 = inputStream;
                sb22222.append("loadBksCA: exception : ");
                InputStream inputStream522222 = inputStream;
                sb22222.append(e.getMessage());
                inputStream3 = inputStream;
                g.b(b, sb22222.toString());
                inputStream2 = inputStream;
                x509Certificate = null;
                f.a(inputStream2);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e8) {
                inputStream = inputStream2;
                e = e8;
                StringBuilder sb222222 = new StringBuilder();
                InputStream inputStream4222222 = inputStream;
                sb222222.append("loadBksCA: exception : ");
                InputStream inputStream5222222 = inputStream;
                sb222222.append(e.getMessage());
                inputStream3 = inputStream;
                g.b(b, sb222222.toString());
                inputStream2 = inputStream;
                x509Certificate = null;
                f.a(inputStream2);
                return x509Certificate;
            } catch (CertificateException e9) {
                inputStream = inputStream2;
                e = e9;
                StringBuilder sb2222222 = new StringBuilder();
                InputStream inputStream42222222 = inputStream;
                sb2222222.append("loadBksCA: exception : ");
                InputStream inputStream52222222 = inputStream;
                sb2222222.append(e.getMessage());
                inputStream3 = inputStream;
                g.b(b, sb2222222.toString());
                inputStream2 = inputStream;
                x509Certificate = null;
                f.a(inputStream2);
                return x509Certificate;
            }
            f.a(inputStream2);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            f.a(inputStream3);
            throw th;
        }
    }

    public X509Certificate b() {
        return a("hmsrootcas.bks", f);
    }
}
