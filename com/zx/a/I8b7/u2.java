package com.zx.a.I8b7;

import android.media.TtmlUtils;
import android.net.ConnectivityManager;
import android.net.Network;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.bw;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.xiaomi.mipush.sdk.Constants;
import com.zx.module.annotation.Java2C;
import com.zx.module.base.Callback;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/u2.class */
public class u2 {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f28518a = h();
    public final String[] b = f();

    /* renamed from: c  reason: collision with root package name */
    public final String[] f28519c = d();

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/u2$a.class */
    public class a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        public ConnectivityManager f28520a;
        public Callback b;
        public TimerTask d;
        public JSONObject e;
        public int f;
        public final AtomicBoolean g = new AtomicBoolean(false);

        /* renamed from: c  reason: collision with root package name */
        public Timer f28521c = new Timer();

        /* renamed from: com.zx.a.I8b7.u2$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/u2$a$a.class */
        public class C0950a extends TimerTask {
            public C0950a(u2 u2Var) {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    a aVar = a.this;
                    Callback callback = aVar.b;
                    if (callback != null) {
                        callback.callback(u2.this.a("wifi 情况下切换数据网络超时, 检查是否打开数据网络!", 1));
                    }
                } catch (JSONException e) {
                    z1.a(e);
                }
            }
        }

        public a(JSONObject jSONObject, ConnectivityManager connectivityManager, Callback callback, int i) {
            this.e = jSONObject;
            this.f = i;
            this.f28520a = connectivityManager;
            this.b = callback;
            C0950a c0950a = new C0950a(u2.this);
            this.d = c0950a;
            this.f28521c.schedule(c0950a, 7000L);
        }

        @Java2C.Method2C
        private native void a(Network network, String str);

        public final void a(Network network) throws Exception {
            HttpURLConnection httpURLConnection = (HttpURLConnection) network.openConnection(new URL(u2.this.b[0]));
            httpURLConnection.setConnectTimeout(7000);
            httpURLConnection.setReadTimeout(7000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();
            JSONObject a2 = u2.this.a();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(a2.toString());
            bufferedWriter.close();
            JSONObject jSONObject = new JSONObject(f1.a(n0.b("text/json; charset=utf-8"), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()).b()).getJSONObject(TtmlUtils.TAG_BODY);
            String string = jSONObject.getString(ProcessBridgeProvider.KEY_RESULT_CODE);
            String string2 = jSONObject.getString("resultDesc");
            httpURLConnection.disconnect();
            if ("103000".equals(string) && "成功".equals(string2)) {
                u2.this.a(this.e, this.b, this.f, "cmcc", jSONObject.getString("token"));
            } else {
                this.b.callback(u2.this.a(jSONObject.toString(), 1));
            }
        }

        public final void b(Network network) throws Exception {
            HttpURLConnection httpURLConnection = (HttpURLConnection) network.openConnection(new URL(u2.this.f28519c[0]));
            httpURLConnection.setConnectTimeout(7000);
            httpURLConnection.setReadTimeout(7000);
            httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();
            String substring = UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").substring(0, 16);
            String a2 = u2.this.a(substring);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(a2);
            bufferedWriter.close();
            JSONObject jSONObject = new JSONObject(f1.a(n0.b(""), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()).b());
            httpURLConnection.disconnect();
            String string = jSONObject.getString("msg");
            int i = jSONObject.getInt("result");
            String optString = jSONObject.optString("data");
            if (i == 0 && bw.o.equals(string) && !TextUtils.isEmpty(optString)) {
                u2.this.a(this.e, this.b, this.f, com.anythink.expressad.d.a.b.dx, u2.this.a(substring, optString));
            } else {
                this.b.callback(u2.this.a(jSONObject.toString(), 1));
            }
        }

        public final void c(Network network) throws Exception {
            u2 u2Var = u2.this;
            String b = u2Var.b(u2Var.f28518a[0]);
            z1.a("unicomUAIDNisportalUrl: " + b);
            HttpURLConnection httpURLConnection = (HttpURLConnection) network.openConnection(new URL(b));
            httpURLConnection.setConnectTimeout(7000);
            httpURLConnection.setReadTimeout(7000);
            httpURLConnection.connect();
            JSONObject jSONObject = new JSONObject(f1.a(n0.b("text/json; charset=utf-8"), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()).b());
            String optString = jSONObject.optString("authurl");
            if (TextUtils.isEmpty(optString)) {
                throw new RuntimeException(jSONObject.toString());
            }
            String b2 = u2.this.b(optString);
            z1.a("unicomUAIDAuthUrl: " + b2);
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) network.openConnection(new URL(b2));
            httpURLConnection2.setConnectTimeout(7000);
            httpURLConnection2.setReadTimeout(7000);
            httpURLConnection2.connect();
            String string = new JSONObject(f1.a(n0.b("text/json; charset=utf-8"), httpURLConnection2.getContentLength(), httpURLConnection2.getResponseCode() == 200 ? httpURLConnection2.getInputStream() : httpURLConnection2.getErrorStream()).b()).getString("code");
            z1.a("unicomUAID code: " + string);
            a(network, string);
            httpURLConnection.disconnect();
            httpURLConnection2.disconnect();
            u2.this.a(this.e, this.b, this.f, "unicom", string);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            try {
                if (this.g.getAndSet(true)) {
                    return;
                }
                z1.a("zx 网络切换: 使用移动网络访问");
                this.d.cancel();
                this.f28521c.cancel();
                String b = d3.b(t2.f28510a);
                if ("中国联通".equals(b)) {
                    c(network);
                } else if ("中国移动".equals(b)) {
                    a(network);
                } else if ("中国电信".equals(b)) {
                    b(network);
                } else {
                    this.b.callback(u2.this.a("暂不支持该运营商", 1));
                }
                this.f28520a.unregisterNetworkCallback(this);
            } catch (Throwable th) {
                z1.a(th);
                Callback callback = this.b;
                if (callback != null) {
                    try {
                        callback.callback(u2.this.a(th.getMessage(), 1));
                        this.f28520a.unregisterNetworkCallback(this);
                    } catch (JSONException e) {
                        z1.a(e);
                    }
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/u2$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final u2 f28523a = new u2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Java2C.Method2C
    public native String a(String str) throws Exception;

    /* JADX INFO: Access modifiers changed from: private */
    @Java2C.Method2C
    public native String a(String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, JSONException;

    /* JADX INFO: Access modifiers changed from: private */
    @Java2C.Method2C
    public native JSONObject a() throws JSONException;

    @Java2C.Method2C
    private native void a(JSONObject jSONObject, Callback callback, int i) throws Exception;

    /* JADX INFO: Access modifiers changed from: private */
    @Java2C.Method2C
    public native String b(String str);

    @Java2C.Method2C
    private final native String[] b();

    @Java2C.Method2C
    private native String c() throws Exception;

    @Java2C.Method2C
    private final native String[] d();

    @Java2C.Method2C
    private native String e() throws Exception;

    @Java2C.Method2C
    private final native String[] f();

    @Java2C.Method2C
    private native String g();

    @Java2C.Method2C
    private final native String[] h();

    @Java2C.Method2C
    private native String i() throws Exception;

    public final String a(String str, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", str);
        jSONObject.put("code", i);
        return jSONObject.toString();
    }

    public final void a(JSONObject jSONObject, Callback callback, int i, String str, String str2) throws Exception {
        String str3;
        if (i == 0) {
            callback.callback(a(h1.b(jSONObject, str, str2), 0));
        } else if (i != 1) {
            if (i != 2) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", str2);
            jSONObject2.put("type", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("data", jSONObject2);
            jSONObject3.put("code", 0);
            callback.callback(jSONObject3.toString());
        } else {
            String string = jSONObject.getString("callerId");
            JSONObject jSONObject4 = new JSONObject();
            String str4 = string + "|" + t2.g + "|" + t2.a(t2.h) + "|" + str + "|" + str2;
            String str5 = b()[0];
            SecureRandom secureRandom = k.f28450a;
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, k.b("RSA", str5));
                byte[] bytes = str4.getBytes(StandardCharsets.UTF_8);
                int length = bytes.length;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int i4 = length - i2;
                    if (i4 <= 0) {
                        break;
                    }
                    byte[] doFinal = i4 > 117 ? cipher.doFinal(bytes, i2, 117) : cipher.doFinal(bytes, i2, i4);
                    byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                    i3++;
                    i2 = i3 * 117;
                }
                str3 = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 2), StandardCharsets.UTF_8);
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                str3 = "";
            }
            jSONObject4.put("data", str3);
            jSONObject4.put("code", 0);
            callback.callback(jSONObject4.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(org.json.JSONObject r11, com.zx.module.base.Callback r12, int r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.u2.b(org.json.JSONObject, com.zx.module.base.Callback, int):void");
    }
}
