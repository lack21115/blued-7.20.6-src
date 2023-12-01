package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.f;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/SecureX509TrustManager.class */
public class SecureX509TrustManager implements X509TrustManager {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9501c = SecureX509TrustManager.class.getSimpleName();
    public static final String d = "hmsrootcas.bks";
    private static final String e = "";
    private static final String f = "X509";
    private static final String g = "bks";
    private static final String h = "AndroidCAStore";

    /* renamed from: a  reason: collision with root package name */
    protected List<X509TrustManager> f9502a;
    private X509Certificate[] b;

    public SecureX509TrustManager(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this(context, false);
    }

    public SecureX509TrustManager(Context context, boolean z) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.f9502a = new ArrayList();
        if (context == null) {
            throw new IllegalArgumentException(com.anythink.expressad.foundation.g.b.b.f4996a);
        }
        com.huawei.secure.android.common.ssl.util.c.a(context);
        if (z) {
            a();
        }
        a(context);
        if (this.f9502a.isEmpty()) {
            throw new CertificateException("X509TrustManager is empty");
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str) throws IllegalArgumentException {
        this.f9502a = new ArrayList();
        a(inputStream, str);
    }

    public SecureX509TrustManager(InputStream inputStream, String str, boolean z) throws IllegalArgumentException {
        this.f9502a = new ArrayList();
        if (z) {
            a();
        }
        a(inputStream, str);
    }

    public SecureX509TrustManager(String str) throws IllegalArgumentException, FileNotFoundException {
        this(str, false);
    }

    public SecureX509TrustManager(String str, boolean z) throws IllegalArgumentException, FileNotFoundException {
        FileInputStream fileInputStream;
        this.f9502a = new ArrayList();
        try {
            fileInputStream = new FileInputStream(str);
            try {
                a(fileInputStream, "");
                f.a((InputStream) fileInputStream);
                if (z) {
                    a();
                }
            } catch (Throwable th) {
                th = th;
                f.a((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    private void a() {
        g.c(f9501c, "loadSystemCA");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            KeyStore keyStore = KeyStore.getInstance(h);
            keyStore.load(null, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f);
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= trustManagers.length) {
                    break;
                }
                if (trustManagers[i2] instanceof X509TrustManager) {
                    this.f9502a.add((X509TrustManager) trustManagers[i2]);
                }
                i = i2 + 1;
            }
        } catch (IOException | NegativeArraySizeException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            String str = f9501c;
            g.b(str, "loadSystemCA: exception : " + e2.getMessage());
        }
        String str2 = f9501c;
        g.a(str2, "loadSystemCA: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    private void a(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        boolean z;
        g.c(f9501c, "loadBksCA");
        long currentTimeMillis = System.currentTimeMillis();
        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
        if (filesBksIS != null) {
            try {
                g.c(f9501c, "get bks not from assets");
                a(filesBksIS);
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
                g.b(f9501c, "loadBksCA: exception : " + e2.getMessage());
                z = false;
            }
        }
        z = true;
        if (!z || filesBksIS == null) {
            g.c(f9501c, " get bks from assets ");
            a(context.getAssets().open("hmsrootcas.bks"));
        }
        g.a(f9501c, "loadBksCA: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    private void a(InputStream inputStream) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f);
            KeyStore keyStore = KeyStore.getInstance("bks");
            keyStore.load(inputStream, "".toCharArray());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= trustManagers.length) {
                    return;
                }
                if (trustManagers[i2] instanceof X509TrustManager) {
                    this.f9502a.add((X509TrustManager) trustManagers[i2]);
                }
                i = i2 + 1;
            }
        } finally {
            f.a(inputStream);
        }
    }

    private void a(InputStream inputStream, String str) {
        if (inputStream == null || str == null) {
            throw new IllegalArgumentException("inputstream or trustPwd is null");
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f);
                KeyStore keyStore = KeyStore.getInstance("bks");
                keyStore.load(inputStream, str.toCharArray());
                trustManagerFactory.init(keyStore);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= trustManagers.length) {
                        break;
                    }
                    if (trustManagers[i2] instanceof X509TrustManager) {
                        this.f9502a.add((X509TrustManager) trustManagers[i2]);
                    }
                    i = i2 + 1;
                }
                f.a(inputStream);
            } catch (IOException | NegativeArraySizeException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
                String str2 = f9501c;
                g.b(str2, "loadInputStream: exception : " + e2.getMessage());
            }
            String str3 = f9501c;
            g.a(str3, "loadInputStream: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        } finally {
            f.a(inputStream);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.c(f9501c, "checkClientTrusted: ");
        for (X509TrustManager x509TrustManager : this.f9502a) {
            try {
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e2) {
                String str2 = f9501c;
                g.b(str2, "checkServerTrusted CertificateException" + e2.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        setChain(x509CertificateArr);
        String str2 = f9501c;
        g.c(str2, "checkServerTrusted begin ,server ca chain size is : " + x509CertificateArr.length + " ,auth type is : " + str);
        long currentTimeMillis = System.currentTimeMillis();
        int length = x509CertificateArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            X509Certificate x509Certificate = x509CertificateArr[i2];
            String str3 = f9501c;
            g.a(str3, "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN());
            String str4 = f9501c;
            g.a(str4, "IssuerDN :" + x509Certificate.getIssuerDN());
            String str5 = f9501c;
            g.a(str5, "SerialNumber : " + x509Certificate.getSerialNumber());
            i = i2 + 1;
        }
        int size = this.f9502a.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                String str6 = f9501c;
                g.a(str6, "checkServerTrusted: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return;
            }
            try {
                String str7 = f9501c;
                g.c(str7, "check server i : " + i4);
                X509TrustManager x509TrustManager = this.f9502a.get(i4);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    String str8 = f9501c;
                    g.c(str8, "client root ca size is : " + acceptedIssuers.length);
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= acceptedIssuers.length) {
                            break;
                        }
                        String str9 = f9501c;
                        g.a(str9, "client root ca getIssuerDN :" + acceptedIssuers[i6].getIssuerDN());
                        i5 = i6 + 1;
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                String str10 = f9501c;
                g.c(str10, "checkServerTrusted succeed ,root ca issuer is : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (CertificateException e2) {
                String str11 = f9501c;
                g.b(str11, "checkServerTrusted error :" + e2.getMessage() + " , time : " + i4);
                if (i4 == size - 1) {
                    if (x509CertificateArr != null && x509CertificateArr.length > 0) {
                        String str12 = f9501c;
                        g.b(str12, "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e2;
                }
                i3 = i4 + 1;
            }
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            for (X509TrustManager x509TrustManager : this.f9502a) {
                arrayList.addAll(Arrays.asList(x509TrustManager.getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e2) {
            String str = f9501c;
            g.b(str, "getAcceptedIssuers exception : " + e2.getMessage());
            return new X509Certificate[0];
        }
    }

    public X509Certificate[] getChain() {
        return this.b;
    }

    public List<X509TrustManager> getX509TrustManagers() {
        return this.f9502a;
    }

    public void setChain(X509Certificate[] x509CertificateArr) {
        this.b = x509CertificateArr;
    }

    public void setX509TrustManagers(List<X509TrustManager> list) {
        this.f9502a = list;
    }
}
