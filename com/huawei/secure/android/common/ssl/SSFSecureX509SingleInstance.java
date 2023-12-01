package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.e;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/SSFSecureX509SingleInstance.class */
public class SSFSecureX509SingleInstance {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9491a = "SSFSecureX509SingleInstance";
    private static volatile SecureX509TrustManager b;

    private SSFSecureX509SingleInstance() {
    }

    public static SecureX509TrustManager getInstance(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        if (context != null) {
            com.huawei.secure.android.common.ssl.util.c.a(context);
            if (b == null) {
                synchronized (SSFSecureX509SingleInstance.class) {
                    try {
                        if (b == null) {
                            InputStream filesBksIS = BksUtil.getFilesBksIS(context);
                            if (filesBksIS == null) {
                                g.c(f9491a, "get assets bks");
                                filesBksIS = context.getAssets().open("hmsrootcas.bks");
                            } else {
                                g.c(f9491a, "get files bks");
                            }
                            b = new SecureX509TrustManager(filesBksIS, "", true);
                            new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return b;
        }
        throw new NullPointerException(com.anythink.expressad.foundation.g.b.b.f4996a);
    }

    public static void updateBks(InputStream inputStream) {
        g.c(f9491a, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && b != null) {
            b = new SecureX509TrustManager(inputStream, "", true);
            String str = f9491a;
            g.a(str, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            SSFCompatiableSystemCA.a(b);
            SASFCompatiableSystemCA.a(b);
        }
        String str2 = f9491a;
        g.a(str2, "update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
