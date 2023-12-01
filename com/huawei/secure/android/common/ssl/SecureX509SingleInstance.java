package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.d;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/SecureX509SingleInstance.class */
public class SecureX509SingleInstance {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23108a = "SecureX509SingleInstance";
    private static volatile SecureX509TrustManager b;

    private SecureX509SingleInstance() {
    }

    public static SecureX509TrustManager getInstance(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        long currentTimeMillis = System.currentTimeMillis();
        if (context != null) {
            com.huawei.secure.android.common.ssl.util.c.a(context);
            if (b == null) {
                synchronized (SecureX509SingleInstance.class) {
                    try {
                        if (b == null) {
                            InputStream filesBksIS = BksUtil.getFilesBksIS(context);
                            if (filesBksIS == null) {
                                g.c(f23108a, "get assets bks");
                                filesBksIS = context.getAssets().open("hmsrootcas.bks");
                            } else {
                                g.c(f23108a, "get files bks");
                            }
                            b = new SecureX509TrustManager(filesBksIS, "");
                            new d().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            String str = f23108a;
            g.a(str, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return b;
        }
        throw new NullPointerException(com.anythink.expressad.foundation.g.b.b.f7836a);
    }

    public static void updateBks(InputStream inputStream) {
        g.c(f23108a, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && b != null) {
            b = new SecureX509TrustManager(inputStream, "");
            SecureSSLSocketFactory.a(b);
            SecureApacheSSLSocketFactory.a(b);
        }
        String str = f23108a;
        g.c(str, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
