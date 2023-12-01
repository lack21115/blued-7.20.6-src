package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/util/CertificateUtil.class */
public final class CertificateUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9518a = "CertificateUtil";

    private CertificateUtil() {
    }

    public static X509Certificate getHwCbgRootCA(Context context) {
        InputStream inputStream;
        X509Certificate x509Certificate;
        InputStream inputStream2 = null;
        try {
            try {
                KeyStore keyStore = KeyStore.getInstance(j.e);
                inputStream = context.getAssets().open("hmsrootcas.bks");
                try {
                    inputStream.reset();
                    keyStore.load(inputStream, "".toCharArray());
                    inputStream2 = inputStream;
                    x509Certificate = (X509Certificate) keyStore.getCertificate(j.f);
                } catch (IOException e) {
                    e = e;
                    StringBuilder sb = new StringBuilder();
                    InputStream inputStream3 = inputStream;
                    sb.append("loadBksCA: exception : ");
                    InputStream inputStream4 = inputStream;
                    sb.append(e.getMessage());
                    inputStream2 = inputStream;
                    g.b(f9518a, sb.toString());
                    x509Certificate = null;
                    f.a(inputStream);
                    return x509Certificate;
                } catch (RuntimeException e2) {
                    e = e2;
                    StringBuilder sb2 = new StringBuilder();
                    InputStream inputStream32 = inputStream;
                    sb2.append("loadBksCA: exception : ");
                    InputStream inputStream42 = inputStream;
                    sb2.append(e.getMessage());
                    inputStream2 = inputStream;
                    g.b(f9518a, sb2.toString());
                    x509Certificate = null;
                    f.a(inputStream);
                    return x509Certificate;
                } catch (KeyStoreException e3) {
                    e = e3;
                    StringBuilder sb22 = new StringBuilder();
                    InputStream inputStream322 = inputStream;
                    sb22.append("loadBksCA: exception : ");
                    InputStream inputStream422 = inputStream;
                    sb22.append(e.getMessage());
                    inputStream2 = inputStream;
                    g.b(f9518a, sb22.toString());
                    x509Certificate = null;
                    f.a(inputStream);
                    return x509Certificate;
                } catch (NoSuchAlgorithmException e4) {
                    e = e4;
                    StringBuilder sb222 = new StringBuilder();
                    InputStream inputStream3222 = inputStream;
                    sb222.append("loadBksCA: exception : ");
                    InputStream inputStream4222 = inputStream;
                    sb222.append(e.getMessage());
                    inputStream2 = inputStream;
                    g.b(f9518a, sb222.toString());
                    x509Certificate = null;
                    f.a(inputStream);
                    return x509Certificate;
                } catch (CertificateException e5) {
                    e = e5;
                    StringBuilder sb2222 = new StringBuilder();
                    InputStream inputStream32222 = inputStream;
                    sb2222.append("loadBksCA: exception : ");
                    InputStream inputStream42222 = inputStream;
                    sb2222.append(e.getMessage());
                    inputStream2 = inputStream;
                    g.b(f9518a, sb2222.toString());
                    x509Certificate = null;
                    f.a(inputStream);
                    return x509Certificate;
                }
            } catch (IOException e6) {
                e = e6;
                inputStream = null;
                StringBuilder sb22222 = new StringBuilder();
                InputStream inputStream322222 = inputStream;
                sb22222.append("loadBksCA: exception : ");
                InputStream inputStream422222 = inputStream;
                sb22222.append(e.getMessage());
                inputStream2 = inputStream;
                g.b(f9518a, sb22222.toString());
                x509Certificate = null;
                f.a(inputStream);
                return x509Certificate;
            } catch (RuntimeException e7) {
                e = e7;
                inputStream = null;
                StringBuilder sb222222 = new StringBuilder();
                InputStream inputStream3222222 = inputStream;
                sb222222.append("loadBksCA: exception : ");
                InputStream inputStream4222222 = inputStream;
                sb222222.append(e.getMessage());
                inputStream2 = inputStream;
                g.b(f9518a, sb222222.toString());
                x509Certificate = null;
                f.a(inputStream);
                return x509Certificate;
            } catch (KeyStoreException e8) {
                e = e8;
                inputStream = null;
                StringBuilder sb2222222 = new StringBuilder();
                InputStream inputStream32222222 = inputStream;
                sb2222222.append("loadBksCA: exception : ");
                InputStream inputStream42222222 = inputStream;
                sb2222222.append(e.getMessage());
                inputStream2 = inputStream;
                g.b(f9518a, sb2222222.toString());
                x509Certificate = null;
                f.a(inputStream);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e9) {
                e = e9;
                inputStream = null;
                StringBuilder sb22222222 = new StringBuilder();
                InputStream inputStream322222222 = inputStream;
                sb22222222.append("loadBksCA: exception : ");
                InputStream inputStream422222222 = inputStream;
                sb22222222.append(e.getMessage());
                inputStream2 = inputStream;
                g.b(f9518a, sb22222222.toString());
                x509Certificate = null;
                f.a(inputStream);
                return x509Certificate;
            } catch (CertificateException e10) {
                e = e10;
                inputStream = null;
                StringBuilder sb222222222 = new StringBuilder();
                InputStream inputStream3222222222 = inputStream;
                sb222222222.append("loadBksCA: exception : ");
                InputStream inputStream4222222222 = inputStream;
                sb222222222.append(e.getMessage());
                inputStream2 = inputStream;
                g.b(f9518a, sb222222222.toString());
                x509Certificate = null;
                f.a(inputStream);
                return x509Certificate;
            } catch (Throwable th) {
                th = th;
                f.a(inputStream2);
                throw th;
            }
            f.a(inputStream);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            f.a(inputStream2);
            throw th;
        }
    }
}
