package com.zx.a.I8b7;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.bh;
import com.zx.a.I8b7.g0;
import com.zx.a.I8b7.w1;
import com.zx.a.I8b7.z1;
import com.zx.module.annotation.Java2C;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Locale;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/a0.class */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static w1 f42098a;
    public static final String[] b;

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/a0$a.class */
    public class a implements g0 {
        @Override // com.zx.a.I8b7.g0
        public e1 a(g0.a aVar) throws IOException {
            if (d3.a(t2.f42201a, true)) {
                v0 v0Var = (v0) aVar;
                return v0Var.a(v0Var.f42217c, v0Var.d);
            }
            throw new IllegalStateException("network is not available");
        }
    }

    static {
        g();
        b = h();
    }

    public static String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        a(stringBuffer);
        stringBuffer.append("BE");
        stringBuffer.append("GIN ");
        stringBuffer.append("CE");
        stringBuffer.append("RT");
        stringBuffer.append("IFIC");
        stringBuffer.append("ATE");
        a(stringBuffer);
        stringBuffer.append("\n");
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (!readLine.trim().equals("")) {
                    sb.append(readLine.substring(0, readLine.length() - 5));
                }
            }
        } catch (Exception e) {
            z1.a(e);
        }
        stringBuffer.append(sb.toString());
        stringBuffer.append("\n");
        a(stringBuffer);
        stringBuffer.append("EN");
        stringBuffer.append("D ");
        stringBuffer.append("CE");
        stringBuffer.append("RTI");
        stringBuffer.append("FIC");
        stringBuffer.append("ATE");
        a(stringBuffer);
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    public static JSONObject a() throws JSONException {
        String str;
        String str2;
        MessageDigest messageDigest;
        String str3 = "error!";
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appPkg", t2.g);
        try {
            Signature[] a2 = d.a(t2.g);
            if (a2 != null) {
                int length = a2.length;
                str = "error!";
                int i = 0;
                while (true) {
                    int i2 = i;
                    str3 = str;
                    if (i2 >= length) {
                        break;
                    }
                    try {
                        byte[] byteArray = a2[i2].toByteArray();
                        try {
                            messageDigest = MessageDigest.getInstance("MD5");
                        } catch (NoSuchAlgorithmException e) {
                            z1.a(e);
                        }
                        if (messageDigest != null) {
                            byte[] digest = messageDigest.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            int length2 = digest.length;
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= length2) {
                                    break;
                                }
                                sb.append(Integer.toHexString((digest[i4] & 255) | 256).substring(1, 3));
                                i3 = i4 + 1;
                            }
                            str2 = sb.toString();
                            str = str2;
                            i = i2 + 1;
                        }
                        str2 = "error!";
                        str = str2;
                        i = i2 + 1;
                    } catch (Exception e2) {
                        e = e2;
                        z1.a(e);
                        str3 = str;
                        jSONObject.put("appSign", str3);
                        jSONObject.put("appId", t2.f);
                        return jSONObject;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            str = "error!";
        }
        jSONObject.put("appSign", str3);
        jSONObject.put("appId", t2.f);
        return jSONObject;
    }

    public static void a(StringBuffer stringBuffer) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                return;
            }
            stringBuffer.append("-");
            i = i2 + 1;
        }
    }

    @Java2C.Method2C
    public static native void a(HttpURLConnection httpURLConnection) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException;

    public static HashMap<String, String> b(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("UDID-LID", t2.a(t2.h));
        String str2 = t2.i;
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("UDID-ZID", str2);
        try {
            String str3 = new String(Base64.encode(a().toString().getBytes(StandardCharsets.UTF_8), 2), StandardCharsets.UTF_8);
            z1.a("ZXID 请求 header 中的 appInfo: " + str3);
            hashMap.put("UDID-APP-INFO", str3);
            String str4 = new String(Base64.encode(e().toString().getBytes(StandardCharsets.UTF_8), 2), StandardCharsets.UTF_8);
            z1.a("ZXID 请求 header 中的 sdkInfoBase: " + str4);
            hashMap.put("UDID-SDK-INFO-BASE", str4);
        } catch (Exception e) {
            StringBuilder a2 = m2.a("ZXID 请求 header 创建异常: ");
            a2.append(e.getMessage());
            z1.b(a2.toString());
        }
        hashMap.put("UDID-PROTOCOL", "v3.0.0");
        hashMap.put("UDID-KEY", str);
        return hashMap;
    }

    public static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(bh.x, "Android");
            jSONObject.put("applicationId", t2.g);
            PackageManager packageManager = d3.f42116a;
            jSONObject.put("country", Locale.getDefault().getCountry());
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("arch", d3.c());
            jSONObject.put("androidVersion", d3.a("59"));
            return jSONObject;
        } catch (JSONException e) {
            StringBuilder a2 = m2.a("ZXID 构建deviceInfo异常:");
            a2.append(e.getMessage());
            z1.b(a2.toString());
            return jSONObject;
        }
    }

    @Java2C.Method2C
    private static native SSLSocketFactory c() throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static JSONObject d() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", t2.b);
            jSONObject.put("configVersion", t2.l);
            if (TextUtils.equals("core-d", t2.f42202c)) {
                jSONObject.put("versiond", t2.d);
            }
            jSONObject.put("channelId", t2.e);
            jSONObject.put("arch", Build.CPU_ABI);
            return jSONObject;
        } catch (JSONException e) {
            StringBuilder a2 = m2.a("ZXID 构建SDKInfoBase异常:");
            a2.append(e.getMessage());
            z1.b(a2.toString());
            return jSONObject;
        }
    }

    public static X509Certificate f() throws CertificateException {
        return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(a(b[0]).getBytes()));
    }

    @Java2C.Method2C
    private static native String[] g();

    @Java2C.Method2C
    private static native String[] h();

    public static void i() {
        try {
            w1.a aVar = new w1.a();
            aVar.b.add(new l0(z1.a.f42234a.f42233a, 5));
            aVar.b.add(new a());
            SSLSocketFactory c2 = c();
            if (c2 == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            aVar.f42223c = c2;
            f42098a = new w1(aVar);
        } catch (Throwable th) {
            z1.a(th);
            th.printStackTrace();
        }
    }
}
