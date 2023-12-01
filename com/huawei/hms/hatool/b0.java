package com.huawei.hms.hatool;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Map;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/b0.class */
public abstract class b0 {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/b0$a.class */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static c0 a(String str, byte[] bArr, Map<String, String> map) {
        return a(str, bArr, map, "POST");
    }

    public static c0 a(String str, byte[] bArr, Map<String, String> map, String str2) {
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream2;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        BufferedOutputStream bufferedOutputStream3;
        BufferedOutputStream bufferedOutputStream4;
        BufferedOutputStream bufferedOutputStream5;
        BufferedOutputStream bufferedOutputStream6;
        BufferedOutputStream bufferedOutputStream7;
        BufferedOutputStream bufferedOutputStream8;
        int responseCode;
        if (TextUtils.isEmpty(str)) {
            return new c0(-100, "");
        }
        int i = -102;
        BufferedOutputStream bufferedOutputStream9 = null;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = a(str, bArr.length, map, str2);
                try {
                    if (httpURLConnection == null) {
                        c0 c0Var = new c0(PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST, "");
                        u0.a((Closeable) null);
                        u0.a((Closeable) null);
                        if (httpURLConnection != null) {
                            u0.a(httpURLConnection);
                        }
                        return c0Var;
                    }
                    outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        bufferedOutputStream8 = new BufferedOutputStream(outputStream2);
                    } catch (a e) {
                        bufferedOutputStream7 = null;
                    } catch (SecurityException e2) {
                        bufferedOutputStream2 = null;
                    } catch (ConnectException e3) {
                        bufferedOutputStream = null;
                    } catch (UnknownHostException e4) {
                        bufferedOutputStream6 = null;
                    } catch (SSLHandshakeException e5) {
                        bufferedOutputStream5 = null;
                    } catch (SSLPeerUnverifiedException e6) {
                        bufferedOutputStream4 = null;
                    } catch (IOException e7) {
                        bufferedOutputStream3 = null;
                    }
                    try {
                        try {
                            bufferedOutputStream8.write(bArr);
                            bufferedOutputStream8.flush();
                            responseCode = httpURLConnection.getResponseCode();
                        } catch (IOException e8) {
                        } catch (SecurityException e9) {
                        } catch (ConnectException e10) {
                        } catch (UnknownHostException e11) {
                        } catch (SSLHandshakeException e12) {
                        } catch (SSLPeerUnverifiedException e13) {
                        }
                        try {
                            c0 c0Var2 = new c0(responseCode, b(httpURLConnection));
                            u0.a((Closeable) bufferedOutputStream8);
                            u0.a((Closeable) outputStream2);
                            if (httpURLConnection != null) {
                                u0.a(httpURLConnection);
                            }
                            return c0Var2;
                        } catch (UnknownHostException e14) {
                            i = responseCode;
                            bufferedOutputStream6 = bufferedOutputStream8;
                            z.f("hmsSdk", "No address associated with hostname or No network");
                            BufferedOutputStream bufferedOutputStream10 = bufferedOutputStream6;
                            c0 c0Var3 = new c0(i, "");
                            u0.a((Closeable) bufferedOutputStream6);
                            u0.a((Closeable) outputStream2);
                            if (httpURLConnection != null) {
                                u0.a(httpURLConnection);
                            }
                            return c0Var3;
                        } catch (IOException e15) {
                            i = responseCode;
                            bufferedOutputStream3 = bufferedOutputStream8;
                            z.f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");
                            BufferedOutputStream bufferedOutputStream11 = bufferedOutputStream3;
                            c0 c0Var4 = new c0(i, "");
                            u0.a((Closeable) bufferedOutputStream3);
                            u0.a((Closeable) outputStream2);
                            if (httpURLConnection != null) {
                                u0.a(httpURLConnection);
                            }
                            return c0Var4;
                        } catch (SecurityException e16) {
                            i = responseCode;
                            bufferedOutputStream2 = bufferedOutputStream8;
                            z.f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");
                            BufferedOutputStream bufferedOutputStream12 = bufferedOutputStream2;
                            c0 c0Var5 = new c0(i, "");
                            u0.a((Closeable) bufferedOutputStream2);
                            u0.a((Closeable) outputStream2);
                            if (httpURLConnection != null) {
                                u0.a(httpURLConnection);
                            }
                            return c0Var5;
                        } catch (ConnectException e17) {
                            i = responseCode;
                            bufferedOutputStream = bufferedOutputStream8;
                            z.f("hmsSdk", "Network is unreachable or Connection refused");
                            BufferedOutputStream bufferedOutputStream13 = bufferedOutputStream;
                            c0 c0Var6 = new c0(i, "");
                            u0.a((Closeable) bufferedOutputStream);
                            u0.a((Closeable) outputStream2);
                            if (httpURLConnection != null) {
                                u0.a(httpURLConnection);
                            }
                            return c0Var6;
                        } catch (SSLHandshakeException e18) {
                            i = responseCode;
                            bufferedOutputStream5 = bufferedOutputStream8;
                            z.f("hmsSdk", "Chain validation failed,Certificate expired");
                            BufferedOutputStream bufferedOutputStream14 = bufferedOutputStream5;
                            c0 c0Var7 = new c0(i, "");
                            u0.a((Closeable) bufferedOutputStream5);
                            u0.a((Closeable) outputStream2);
                            if (httpURLConnection != null) {
                                u0.a(httpURLConnection);
                            }
                            return c0Var7;
                        } catch (SSLPeerUnverifiedException e19) {
                            i = responseCode;
                            bufferedOutputStream4 = bufferedOutputStream8;
                            z.f("hmsSdk", "Certificate has not been verified,Request is restricted!");
                            BufferedOutputStream bufferedOutputStream15 = bufferedOutputStream4;
                            c0 c0Var8 = new c0(i, "");
                            u0.a((Closeable) bufferedOutputStream4);
                            u0.a((Closeable) outputStream2);
                            if (httpURLConnection != null) {
                                u0.a(httpURLConnection);
                            }
                            return c0Var8;
                        }
                    } catch (a e20) {
                        bufferedOutputStream7 = bufferedOutputStream8;
                        z.f("hmsSdk", "PostRequest(byte[]): No ssl socket factory set!");
                        BufferedOutputStream bufferedOutputStream16 = bufferedOutputStream7;
                        c0 c0Var9 = new c0(PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST, "");
                        u0.a((Closeable) bufferedOutputStream7);
                        u0.a((Closeable) outputStream2);
                        if (httpURLConnection != null) {
                            u0.a(httpURLConnection);
                        }
                        return c0Var9;
                    } catch (Throwable th) {
                        bufferedOutputStream9 = bufferedOutputStream8;
                        httpURLConnection2 = httpURLConnection;
                        th = th;
                        outputStream = outputStream2;
                        u0.a((Closeable) bufferedOutputStream9);
                        u0.a((Closeable) outputStream);
                        if (httpURLConnection2 != null) {
                            u0.a(httpURLConnection2);
                        }
                        throw th;
                    }
                } catch (a e21) {
                    outputStream2 = null;
                    bufferedOutputStream7 = null;
                } catch (SecurityException e22) {
                    outputStream2 = null;
                    bufferedOutputStream2 = null;
                } catch (ConnectException e23) {
                    outputStream2 = null;
                    bufferedOutputStream = null;
                } catch (UnknownHostException e24) {
                    outputStream2 = null;
                    bufferedOutputStream6 = null;
                } catch (SSLHandshakeException e25) {
                    outputStream2 = null;
                    bufferedOutputStream5 = null;
                } catch (SSLPeerUnverifiedException e26) {
                    outputStream2 = null;
                    bufferedOutputStream4 = null;
                } catch (IOException e27) {
                    outputStream2 = null;
                    bufferedOutputStream3 = null;
                } catch (Throwable th2) {
                    outputStream = null;
                    httpURLConnection2 = httpURLConnection;
                    th = th2;
                }
            } catch (a e28) {
                httpURLConnection = null;
                outputStream2 = null;
                bufferedOutputStream7 = null;
            } catch (UnknownHostException e29) {
                httpURLConnection = null;
                outputStream2 = null;
                bufferedOutputStream6 = null;
            } catch (SSLHandshakeException e30) {
                httpURLConnection = null;
                outputStream2 = null;
                bufferedOutputStream5 = null;
            } catch (SSLPeerUnverifiedException e31) {
                httpURLConnection = null;
                outputStream2 = null;
                bufferedOutputStream4 = null;
            } catch (IOException e32) {
                httpURLConnection = null;
                outputStream2 = null;
                bufferedOutputStream3 = null;
            } catch (SecurityException e33) {
                httpURLConnection = null;
                outputStream2 = null;
                bufferedOutputStream2 = null;
            } catch (ConnectException e34) {
                httpURLConnection = null;
                outputStream2 = null;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection2 = null;
                outputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            outputStream = str2;
        }
    }

    public static HttpURLConnection a(String str, int i, Map<String, String> map, String str2) {
        if (TextUtils.isEmpty(str)) {
            z.b("hmsSdk", "CreateConnection: invalid urlPath.");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        a(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(i));
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null) {
            if (map.size() < 1) {
                return httpURLConnection;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.net.HttpURLConnection r4) {
        /*
            r0 = r4
            boolean r0 = r0 instanceof javax.net.ssl.HttpsURLConnection
            if (r0 == 0) goto L5a
            r0 = r4
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0
            r6 = r0
            r0 = 0
            r5 = r0
            android.content.Context r0 = com.huawei.hms.hatool.b.i()     // Catch: java.security.NoSuchAlgorithmException -> L5b java.security.KeyStoreException -> L5f java.security.GeneralSecurityException -> L63 java.io.IOException -> L67 java.lang.IllegalAccessException -> L6b
            com.huawei.secure.android.common.ssl.SecureSSLSocketFactory r0 = com.huawei.secure.android.common.ssl.SecureSSLSocketFactory.getInstance(r0)     // Catch: java.security.NoSuchAlgorithmException -> L5b java.security.KeyStoreException -> L5f java.security.GeneralSecurityException -> L63 java.io.IOException -> L67 java.lang.IllegalAccessException -> L6b
            r4 = r0
            goto L3b
        L18:
            java.lang.String r0 = "getSocketFactory(): Illegal Access Exception "
            r4 = r0
            goto L33
        L1e:
            java.lang.String r0 = "getSocketFactory(): IO Exception!"
            r4 = r0
            goto L33
        L24:
            java.lang.String r0 = "getSocketFactory(): General Security Exception"
            r4 = r0
            goto L33
        L2a:
            java.lang.String r0 = "getSocketFactory(): Key Store exception"
            r4 = r0
            goto L33
        L30:
            java.lang.String r0 = "getSocketFactory(): Algorithm Exception!"
            r4 = r0
        L33:
            java.lang.String r0 = "hmsSdk"
            r1 = r4
            com.huawei.hms.hatool.z.f(r0, r1)
            r0 = r5
            r4 = r0
        L3b:
            r0 = r4
            if (r0 == 0) goto L50
            r0 = r6
            r1 = r4
            r0.setSSLSocketFactory(r1)
            r0 = r6
            com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier r1 = new com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier
            r2 = r1
            r2.<init>()
            r0.setHostnameVerifier(r1)
            return
        L50:
            com.huawei.hms.hatool.b0$a r0 = new com.huawei.hms.hatool.b0$a
            r1 = r0
            java.lang.String r2 = "No ssl socket factory set"
            r1.<init>(r2)
            throw r0
        L5a:
            return
        L5b:
            r4 = move-exception
            goto L30
        L5f:
            r4 = move-exception
            goto L2a
        L63:
            r4 = move-exception
            goto L24
        L67:
            r4 = move-exception
            goto L1e
        L6b:
            r4 = move-exception
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.b0.a(java.net.HttpURLConnection):void");
    }

    public static String b(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
            try {
                InputStream inputStream3 = httpURLConnection.getInputStream();
                inputStream2 = inputStream3;
                inputStream = inputStream3;
                String a2 = u0.a(inputStream3);
                u0.a((Closeable) inputStream3);
                return a2;
            } catch (IOException e) {
                int responseCode = httpURLConnection.getResponseCode();
                InputStream inputStream4 = inputStream;
                StringBuilder sb = new StringBuilder();
                InputStream inputStream5 = inputStream;
                sb.append("When Response Content From Connection inputStream operation exception! ");
                InputStream inputStream6 = inputStream;
                sb.append(responseCode);
                inputStream2 = inputStream;
                z.f("hmsSdk", sb.toString());
                u0.a((Closeable) inputStream);
                return "";
            }
        } catch (Throwable th) {
            u0.a((Closeable) inputStream2);
            throw th;
        }
    }
}
