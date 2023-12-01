package com.opos.cmn.an.f.a.a;

import com.google.common.net.HttpHeaders;
import com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/a/a/c.class */
public class c implements com.oplus.log.g.a {
    private static SSLSocketFactory a() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            return null;
        }
    }

    private void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            try {
                SSLSocketFactory a2 = a();
                if (a2 != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(a2);
                }
            } catch (Exception e) {
            }
        }
    }

    private UserTraceConfigDto c(String str) {
        UserTraceConfigDto userTraceConfigDto;
        if (!com.opos.cmn.an.c.a.a(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                UserTraceConfigDto userTraceConfigDto2 = new UserTraceConfigDto();
                userTraceConfigDto2.setTraceId(jSONObject.optLong("traceId", 0L));
                if (!jSONObject.isNull("imei")) {
                    userTraceConfigDto2.setImei(jSONObject.optString("imei", ""));
                }
                userTraceConfigDto2.setBeginTime(jSONObject.optLong("beginTime", 0L));
                userTraceConfigDto2.setBeginTime(jSONObject.optLong("endTime", 0L));
                userTraceConfigDto2.setForce(jSONObject.optInt("force", 0));
                if (!jSONObject.isNull("tracePkg")) {
                    userTraceConfigDto2.setTracePkg(jSONObject.optString("tracePkg", ""));
                }
                userTraceConfigDto = userTraceConfigDto2;
                if (!jSONObject.isNull("openId")) {
                    userTraceConfigDto2.setOpenId(jSONObject.optString("openId", ""));
                    return userTraceConfigDto2;
                }
            } catch (Exception e) {
            }
            return userTraceConfigDto;
        }
        userTraceConfigDto = null;
        return userTraceConfigDto;
    }

    @Override // com.oplus.log.g.a
    public com.oplus.log.g.b a(String str) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.opos.cmn.an.c.a.a(str)) {
                return null;
            }
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", com.anythink.expressad.foundation.g.f.g.c.f7906c);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
                httpURLConnection.connect();
                com.oplus.log.g.b bVar = new com.oplus.log.g.b(httpURLConnection.getResponseCode());
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e) {
                    }
                }
                return bVar;
            } catch (Exception e2) {
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                        return null;
                    } catch (Exception e3) {
                        return null;
                    }
                }
                return null;
            } catch (Throwable th) {
                httpURLConnection2 = httpURLConnection;
                th = th;
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    @Override // com.oplus.log.g.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.oplus.log.g.b a(java.lang.String r6, java.io.File r7) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.f.a.a.c.a(java.lang.String, java.io.File):com.oplus.log.g.b");
    }

    @Override // com.oplus.log.g.a
    public UserTraceConfigDto b(String str) {
        HttpURLConnection httpURLConnection;
        String str2;
        String sb;
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
        } catch (Exception e) {
            httpURLConnection = null;
        } catch (Throwable th) {
            th = th;
            httpURLConnection = null;
        }
        if (com.opos.cmn.an.c.a.a(str)) {
            com.opos.cmn.an.f.c.b.a((Closeable) null);
            return null;
        }
        httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        inputStream = null;
        inputStream2 = null;
        try {
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
            httpURLConnection.connect();
            InputStream inputStream3 = httpURLConnection.getInputStream();
            StringBuilder sb2 = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream3));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb2.append(readLine);
            }
            inputStream = inputStream3;
            inputStream2 = inputStream3;
            sb = sb2.toString();
            com.opos.cmn.an.f.c.b.a(inputStream3);
            str2 = sb;
        } catch (Exception e2) {
            com.opos.cmn.an.f.c.b.a(inputStream2);
            str2 = "";
            if (httpURLConnection != null) {
                str2 = "";
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e3) {
                }
            }
            return c(str2);
        } catch (Throwable th2) {
            th = th2;
            com.opos.cmn.an.f.c.b.a(inputStream);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
        if (httpURLConnection != null) {
            str2 = sb;
            httpURLConnection.disconnect();
        }
        return c(str2);
    }
}
