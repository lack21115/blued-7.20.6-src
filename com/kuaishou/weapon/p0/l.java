package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/l.class */
public class l {

    /* renamed from: a  reason: collision with root package name */
    static TrustManager[] f10233a = {new X509TrustManager() { // from class: com.kuaishou.weapon.p0.l.1
        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                l.b(x509CertificateArr);
            } catch (Throwable th) {
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }};
    static SSLSocketFactory b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f10234c = "gzip";
    private static final int d = 1024;
    private static volatile l f;
    private static Context g;
    private boolean e = false;

    private l(Context context) {
        g = context;
    }

    public static l a(Context context) {
        if (f == null) {
            synchronized (l.class) {
                try {
                    if (f == null) {
                        f = new l(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null || httpURLConnection == null) {
            return null;
        }
        try {
            if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                this.e = true;
            } else {
                this.e = false;
            }
            return httpURLConnection.getInputStream();
        } catch (IOException e) {
            return null;
        }
    }

    private static void a(String str) {
        try {
            new h(g).c(de.k, str, true);
        } catch (Exception e) {
        }
    }

    private void a(HttpsURLConnection httpsURLConnection) {
        synchronized (this) {
            if (httpsURLConnection != null) {
                try {
                    if (b == null) {
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, f10233a, new SecureRandom());
                        b = sSLContext.getSocketFactory();
                    }
                    if (b != null) {
                        httpsURLConnection.setSSLSocketFactory(b);
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    private boolean a(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        GZIPInputStream gZIPInputStream = inputStream;
        if (this.e) {
            try {
                gZIPInputStream = new GZIPInputStream(inputStream);
            } catch (IOException e) {
                gZIPInputStream = inputStream;
            }
        }
        if (gZIPInputStream == null) {
            return false;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read == -1) {
                        try {
                            bufferedOutputStream.close();
                            return true;
                        } catch (IOException e2) {
                            return true;
                        }
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                    bufferedOutputStream.flush();
                }
            } catch (Throwable th) {
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                        return false;
                    } catch (IOException e3) {
                        return false;
                    }
                }
                return false;
            }
        } catch (Throwable th2) {
            bufferedOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(X509Certificate[] x509CertificateArr) {
        if (x509CertificateArr != null) {
            try {
                if (x509CertificateArr.length == 0) {
                    return;
                }
                String name = x509CertificateArr[0].getIssuerX500Principal().getName();
                if (Pattern.compile(".*(GeoTrust|VeriSign|Symantec|GlobalSign|Entrust|Thawte|DigiCert).*", 2).matcher(name).matches()) {
                    return;
                }
                a(name);
            } catch (Throwable th) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0188 A[Catch: Exception -> 0x01c9, TRY_ENTER, TryCatch #4 {Exception -> 0x01c9, blocks: (B:57:0x017e, B:60:0x0188), top: B:98:0x017e }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x017e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(com.kuaishou.weapon.p0.m r8) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.l.a(com.kuaishou.weapon.p0.m):java.lang.String");
    }

    public String a(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        String str = "";
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2.substring(1);
            }
            Map.Entry<String, String> next = it.next();
            str = str2 + ContainerUtils.FIELD_DELIMITER + next.getKey() + "=" + next.getValue();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.net.HttpURLConnection] */
    public HttpURLConnection a(String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2;
        try {
            URL url = new URL(str);
            if ("https".equals(url.getProtocol())) {
                httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                a(httpsURLConnection2);
            } else {
                httpsURLConnection2 = (HttpURLConnection) url.openConnection();
            }
        } catch (Exception e) {
            httpsURLConnection = null;
        }
        try {
            httpsURLConnection2.setRequestMethod(str2);
            httpsURLConnection2.setAllowUserInteraction(true);
            httpsURLConnection2.setInstanceFollowRedirects(true);
            httpsURLConnection2.setChunkedStreamingMode(0);
            httpsURLConnection2.setConnectTimeout(10000);
            httpsURLConnection2.setReadTimeout(5000);
            httpsURLConnection2.setRequestProperty("Charset", "UTF-8");
            httpsURLConnection2.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpsURLConnection = httpsURLConnection2;
            if (str2.equalsIgnoreCase("post")) {
                httpsURLConnection2.setDoInput(true);
                httpsURLConnection2.setDoOutput(true);
                httpsURLConnection2.setUseCaches(false);
                return httpsURLConnection2;
            }
            return httpsURLConnection;
        } catch (Exception e2) {
            return httpsURLConnection2;
        }
    }

    public void a(m mVar, j jVar) {
        a(mVar, jVar, "GET");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0182 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018b A[Catch: Exception -> 0x01d0, TRY_ENTER, TryCatch #0 {Exception -> 0x01d0, blocks: (B:68:0x0182, B:71:0x018b, B:74:0x0194), top: B:103:0x0182 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0194 A[Catch: Exception -> 0x01d0, TRY_ENTER, TryCatch #0 {Exception -> 0x01d0, blocks: (B:68:0x0182, B:71:0x018b, B:74:0x0194), top: B:103:0x0182 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.kuaishou.weapon.p0.m r8, com.kuaishou.weapon.p0.j r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.l.a(com.kuaishou.weapon.p0.m, com.kuaishou.weapon.p0.j, java.lang.String):void");
    }

    public boolean a(String str, File file) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        HttpURLConnection a2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            a2 = a(str, "GET");
            inputStream = null;
        } catch (Throwable th) {
            httpURLConnection = null;
            inputStream = null;
        }
        try {
            InputStream a3 = a(a2);
            inputStream = a3;
            boolean a4 = a(a3, file);
            if (a3 != null) {
                try {
                    a3.close();
                } catch (Throwable th2) {
                    return false;
                }
            }
            if (a2 != null) {
                a2.disconnect();
                return a4;
            }
            return a4;
        } catch (Throwable th3) {
            httpURLConnection = a2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th4) {
                    return false;
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                return false;
            }
            return false;
        }
    }

    public void b(m mVar, j jVar) {
        a(mVar, jVar, "POST");
    }
}
