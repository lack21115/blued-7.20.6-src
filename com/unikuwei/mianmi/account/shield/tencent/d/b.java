package com.unikuwei.mianmi.account.shield.tencent.d;

import android.net.Network;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.unikuwei.mianmi.account.shield.tencent.UniAccountHelper;
import com.unikuwei.mianmi.account.shield.tencent.e.d;
import com.unikuwei.mianmi.account.shield.tencent.e.g;
import com.unikuwei.mianmi.account.shield.tencent.e.h;
import com.unikuwei.mianmi.account.shield.tencent.e.j;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/d/b.class */
public class b {
    private String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Exception e) {
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String str = new String(byteArrayOutputStream.toByteArray());
            try {
                byteArrayOutputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                return str;
            } catch (Exception e2) {
                return str;
            }
        } catch (Exception e3) {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e4) {
                    return null;
                }
            }
            if (inputStream != null) {
                inputStream.close();
                return null;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e5) {
                    throw th;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public String a(String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        if (Build.VERSION.SDK_INT < 21) {
            return "";
        }
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            try {
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setUseCaches(false);
                    httpsURLConnection.setInstanceFollowRedirects(true);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setConnectTimeout(30000);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.unikuwei.mianmi.account.shield.tencent.d.b.3
                        @Override // javax.net.ssl.HostnameVerifier
                        public boolean verify(String str3, SSLSession sSLSession) {
                            if (TextUtils.isEmpty(str3)) {
                                return false;
                            }
                            return str3.endsWith(".wostore.cn") || str3.endsWith(".10010.com");
                        }
                    });
                    httpsURLConnection.addRequestProperty("Connection", "close");
                    httpsURLConnection.addRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    httpsURLConnection.connect();
                    DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
                    if (str2 != null) {
                        dataOutputStream.write(str2.getBytes("UTF-8"));
                    }
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    String a2 = httpsURLConnection.getResponseCode() == 200 ? a(httpsURLConnection.getInputStream()) : "";
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    return a2;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                        return "";
                    }
                    return "";
                } catch (Throwable th) {
                    httpsURLConnection2 = httpsURLConnection;
                    th = th;
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                httpsURLConnection = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String a(String str, HashMap<String, String> hashMap, Network network) {
        String str2;
        g.a("url:" + str);
        if (Build.VERSION.SDK_INT < 21) {
            return c(str, hashMap, network);
        }
        try {
            URL url = new URL(str);
            str2 = "https://" + url.getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            str2 = "";
        }
        h.c(str);
        try {
            URL url2 = new URL(str);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((network == null || Build.VERSION.SDK_INT < 21) ? url2.openConnection() : network.openConnection(url2));
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(false);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setInstanceFollowRedirects(false);
            httpsURLConnection.setReadTimeout(30000);
            httpsURLConnection.setConnectTimeout(30000);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.unikuwei.mianmi.account.shield.tencent.d.b.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str3, SSLSession sSLSession) {
                    if (TextUtils.isEmpty(str3)) {
                        return false;
                    }
                    return str3.endsWith(".wostore.cn") || str3.endsWith(".10010.com");
                }
            });
            if (hashMap != null) {
                for (String str3 : hashMap.keySet()) {
                    httpsURLConnection.setRequestProperty(str3, hashMap.get(str3));
                }
            }
            httpsURLConnection.addRequestProperty("Connection", str.startsWith("https://opencloud.wostore.cn/openapi/netauth/precheck/wp?") ? com.anythink.expressad.foundation.g.f.g.c.f7906c : "close");
            httpsURLConnection.connect();
            if (httpsURLConnection.getResponseCode() == 200) {
                String a2 = a(httpsURLConnection.getInputStream());
                if (TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 10012);
                    jSONObject.put("msg", "10012");
                    jSONObject.put("data", str2);
                    return jSONObject.toString();
                }
                return a2;
            } else if (httpsURLConnection.getResponseCode() != 302) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 10010);
                jSONObject2.put("msg", "https状态码" + httpsURLConnection.getResponseCode());
                jSONObject2.put("data", str2);
                return jSONObject2.toString();
            } else {
                String headerField = httpsURLConnection.getHeaderField(HttpHeaders.LOCATION);
                if (!TextUtils.isEmpty(headerField)) {
                    return headerField.startsWith("https") ? a(headerField, null, network) : b(headerField, null, network);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 10013);
                jSONObject3.put("msg", "无跳转地址");
                jSONObject3.put("data", str2);
                return jSONObject3.toString();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("code", 10011);
                jSONObject4.put("msg", "https异常" + e2.getMessage());
                jSONObject4.put("data", str2);
                return jSONObject4.toString();
            } catch (Exception e3) {
                return null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x02a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(java.lang.String r6, java.util.HashMap<java.lang.String, java.lang.String> r7, android.net.Network r8) {
        /*
            Method dump skipped, instructions count: 685
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unikuwei.mianmi.account.shield.tencent.d.b.b(java.lang.String, java.util.HashMap, android.net.Network):java.lang.String");
    }

    public String c(String str, HashMap<String, String> hashMap, Network network) {
        String str2;
        g.a("url:" + str);
        if (Build.VERSION.SDK_INT < 21) {
            try {
                if (j.a(UniAccountHelper.getInstance().getApplicationContext()) == 1) {
                    new d().a(UniAccountHelper.getInstance().getApplicationContext(), str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            URL url = new URL(str);
            str2 = "https://" + url.getHost();
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            str2 = "";
        }
        h.c(str);
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, new SecureRandom());
            c cVar = new c(sSLContext.getSocketFactory());
            URL url2 = new URL(str);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((network == null || Build.VERSION.SDK_INT < 21) ? url2.openConnection() : network.openConnection(url2));
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(false);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setInstanceFollowRedirects(false);
            httpsURLConnection.setReadTimeout(30000);
            httpsURLConnection.setConnectTimeout(30000);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setSSLSocketFactory(cVar);
            httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.unikuwei.mianmi.account.shield.tencent.d.b.2
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str3, SSLSession sSLSession) {
                    if (TextUtils.isEmpty(str3)) {
                        return false;
                    }
                    return str3.endsWith(".wostore.cn") || str3.endsWith(".10010.com");
                }
            });
            if (hashMap != null) {
                for (String str3 : hashMap.keySet()) {
                    httpsURLConnection.setRequestProperty(str3, hashMap.get(str3));
                }
            }
            httpsURLConnection.addRequestProperty("Connection", str.startsWith("https://opencloud.wostore.cn/openapi/netauth/precheck/wp?") ? com.anythink.expressad.foundation.g.f.g.c.f7906c : "close");
            httpsURLConnection.connect();
            if (httpsURLConnection.getResponseCode() == 200) {
                String a2 = a(httpsURLConnection.getInputStream());
                if (TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 10012);
                    jSONObject.put("msg", "10012");
                    jSONObject.put("data", str2);
                    return jSONObject.toString();
                }
                return a2;
            } else if (httpsURLConnection.getResponseCode() != 302) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 10010);
                jSONObject2.put("msg", "https状态码" + httpsURLConnection.getResponseCode());
                jSONObject2.put("data", str2);
                return jSONObject2.toString();
            } else {
                String headerField = httpsURLConnection.getHeaderField(HttpHeaders.LOCATION);
                if (!TextUtils.isEmpty(headerField)) {
                    return headerField.startsWith("https") ? a(headerField, null, network) : b(headerField, null, network);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 10013);
                jSONObject3.put("msg", "无跳转地址");
                jSONObject3.put("data", str2);
                return jSONObject3.toString();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("code", 10011);
                jSONObject4.put("msg", "https异常" + e3.getMessage());
                jSONObject4.put("data", str2);
                return jSONObject4.toString();
            } catch (Exception e4) {
                return null;
            }
        }
    }
}
