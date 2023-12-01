package a.a.a.a.a.n;

import a.a.a.a.a.e.h;
import a.a.a.a.a.k.e.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qiniu.android.dns.DnsManager;
import com.qiniu.pili.droid.streaming.PLAuthenticationResultCallback;
import com.tencent.tendinsv.a.b;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/n/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1416a = true;
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public static b f1417c = new b("https://pili-zeus.qiniuapi.com");
    public String e;
    public CountDownLatch j;
    public a.a.a.a.a.n.c f = new a.a.a.a.a.n.c();
    public Context g = null;
    public e h = e.UnCheck;
    public long i = 0;
    public final ArrayList<g> d = new ArrayList<>();

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/n/b$a.class */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1418a;

        public a(String str) {
            this.f1418a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.g(this.f1418a);
        }
    }

    /* renamed from: a.a.a.a.a.n.b$b  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/n/b$b.class */
    public class RunnableC0021b implements Runnable {
        public RunnableC0021b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.c();
            b.this.g(null);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/n/b$c.class */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PLAuthenticationResultCallback f1420a;

        public c(PLAuthenticationResultCallback pLAuthenticationResultCallback) {
            this.f1420a = pLAuthenticationResultCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b(this.f1420a);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/n/b$d.class */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PLAuthenticationResultCallback f1421a;

        public d(PLAuthenticationResultCallback pLAuthenticationResultCallback) {
            this.f1421a = pLAuthenticationResultCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.h == e.Authorized) {
                this.f1421a.onAuthorizationResult(1);
            } else if (b.this.h == e.UnAuthorized) {
                this.f1421a.onAuthorizationResult(0);
            } else {
                this.f1421a.onAuthorizationResult(-1);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/n/b$e.class */
    public enum e {
        UnCheck,
        Authorized,
        UnAuthorized
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/n/b$f.class */
    public static class f {
        public int d = 3600;

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList<String> f1424a = new ArrayList<>();
        public final HashMap<String, ArrayList<String>> b = new HashMap<>();

        /* renamed from: c  reason: collision with root package name */
        public final HashMap<String, Integer[]> f1425c = new HashMap<>();
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/n/b$g.class */
    public interface g {
        void a();
    }

    public b(String str) {
        this.e = str;
    }

    public static b a() {
        return f1417c;
    }

    public static String a(Context context, String str) throws Exception {
        FileInputStream openFileInput = context.openFileInput(str);
        try {
            try {
                int available = openFileInput.available();
                if (available > 131072) {
                    openFileInput.close();
                    return "";
                }
                byte[] bArr = new byte[available];
                String str2 = new String(bArr, 0, openFileInput.read(bArr));
                openFileInput.close();
                return str2;
            } catch (IOException e2) {
                throw e2;
            }
        } catch (Throwable th) {
            openFileInput.close();
            throw th;
        }
    }

    public static String a(String str) throws URISyntaxException, a.a.a.a.a.f.d {
        Map<String, String> a2;
        URI uri = new URI(str);
        String host = uri.getHost();
        if (DnsManager.validIP(host) && (a2 = h.a(uri)) != null && !a2.isEmpty()) {
            int length = a.a.a.a.a.n.c.f1426a.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str2 = a2.get(a.a.a.a.a.n.c.f1426a[i2]);
                if (h.c(str2)) {
                    return str2;
                }
                i = i2 + 1;
            }
        }
        return host;
    }

    public static String a(String str, a.a.a.a.a.n.a aVar) throws URISyntaxException {
        String str2;
        URI uri = new URI(str);
        String host = uri.getHost();
        a.a.a.a.a.k.e.c.a().a(host, aVar.f1415a);
        c.e a2 = a.a.a.a.a.k.e.c.a().a(host, 0);
        if (a2 == null || (str2 = a2.f1386a) == null || str2.equals("")) {
            a.a.a.a.a.e.e.f1313c.b("SpeedMeasure failed", "" + a2);
            return str;
        }
        a.a.a.a.a.e.e.f1313c.b("SpeedMeasure", "the fasetest server " + host + " " + a2.f1386a + " time " + a2.f1387c);
        String str3 = "";
        if (uri.getPort() > 0) {
            str3 = ":" + Integer.toString(uri.getPort());
        }
        return String.format("rtmp://%s%s%s?%s&domain=%s", a2.f1386a, str3, uri.getPath(), uri.getQuery(), host);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r6, java.lang.String r7, org.json.JSONObject r8) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.n.b.a(java.lang.String, java.lang.String, org.json.JSONObject):java.lang.String");
    }

    public static void a(Context context) {
        if (b) {
            return;
        }
        b = true;
        a().b(context);
        a().e();
        String[] strArr = a.a.a.a.a.e.d.f1310a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            if (h.h(context).contains(strArr[i2])) {
                a().a(false);
                break;
            }
            i = i2 + 1;
        }
        a().f();
    }

    public static void a(Context context, String str, String str2) throws IOException {
        FileOutputStream openFileOutput = context.openFileOutput(str, 0);
        try {
            try {
                openFileOutput.write(str2.getBytes());
                openFileOutput.flush();
                openFileOutput.close();
            } catch (IOException e2) {
                throw e2;
            }
        } catch (Throwable th) {
            openFileOutput.close();
            throw th;
        }
    }

    public void a(g gVar) {
        synchronized (this.d) {
            if (!this.d.contains(gVar)) {
                this.d.add(gVar);
            }
        }
    }

    public void a(PLAuthenticationResultCallback pLAuthenticationResultCallback) {
        new Thread(new c(pLAuthenticationResultCallback)).start();
    }

    public final void a(boolean z) {
        f1416a = z;
    }

    public String b(String str) throws URISyntaxException, a.a.a.a.a.f.d {
        String a2 = a(str);
        a.a.a.a.a.n.a a3 = this.f.a(a2);
        if (a3 == null) {
            new Thread(new a(a2)).start();
            return str;
        } else if (a3.a()) {
            throw new a.a.a.a.a.f.d("Url is invalid => " + str);
        } else if (a3.b()) {
            PrintStream printStream = System.out;
            printStream.println("PublishLines external " + str);
            return str;
        } else {
            return a(str, a3);
        }
    }

    public void b(g gVar) {
        synchronized (this.d) {
            this.d.remove(gVar);
        }
    }

    public final void b(Context context) {
        if (context != null) {
            this.g = context.getApplicationContext();
        }
    }

    public final void b(PLAuthenticationResultCallback pLAuthenticationResultCallback) {
        String c2 = c(this.g);
        if ("".equals(c2)) {
            a.a.a.a.a.e.e.f1313c.e("Zeus", "Invalid package name!");
            CountDownLatch countDownLatch = this.j;
            if (countDownLatch != null) {
                countDownLatch.countDown();
                return;
            }
            return;
        }
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://shortvideo.qiniuapi.com/v1/pstream/license?package=" + c2).openConnection();
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setConnectTimeout(3000);
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode == 200) {
                this.h = e.Authorized;
            } else if (responseCode == 401) {
                this.h = e.UnAuthorized;
                a.a.a.a.a.e.e.f1313c.e("Zeus", "鉴权失败! ! ! 请参阅 https://developer.qiniu.com/pili/sdk/3716/PLDroidMediaStreaming-preparation-before-development#2 前置条件说明并按照流程获取相应鉴权！");
            } else {
                this.h = e.UnCheck;
            }
            if (pLAuthenticationResultCallback != null) {
                c(pLAuthenticationResultCallback);
            }
            g();
        } catch (IOException e2) {
            if (pLAuthenticationResultCallback != null) {
                c(pLAuthenticationResultCallback);
            }
            e2.printStackTrace();
        }
        CountDownLatch countDownLatch2 = this.j;
        if (countDownLatch2 != null) {
            countDownLatch2.countDown();
        }
    }

    public boolean b() {
        boolean z = false;
        if (!h()) {
            if (this.h == e.UnAuthorized) {
                a.a.a.a.a.e.e.f1313c.e("Zeus", "鉴权失败! ! ! 请参阅 https://developer.qiniu.com/pili/sdk/3716/PLDroidMediaStreaming-preparation-before-development#2 前置条件说明并按照流程获取相应鉴权！");
            }
            if (this.h != e.UnAuthorized) {
                z = true;
            }
            return z;
        }
        this.j = new CountDownLatch(1);
        a((PLAuthenticationResultCallback) null);
        try {
            this.j.await();
        } catch (InterruptedException e2) {
            a.a.a.a.a.e.e.f1313c.e("Zeus", "Authorize failed : " + e2.getMessage());
        }
        this.j = null;
        boolean z2 = false;
        if (this.h != e.UnAuthorized) {
            z2 = true;
        }
        return z2;
    }

    public final String c(Context context) {
        return context != null ? h.l(context) : "";
    }

    public final void c() {
        Context context = this.g;
        if (context == null) {
            return;
        }
        try {
            f d2 = d(a(context, "pili_config.json"));
            this.f.a(d2.f1424a, d2.b, d2.f1425c, d2.d);
        } catch (Exception e2) {
        }
        d();
    }

    public final void c(PLAuthenticationResultCallback pLAuthenticationResultCallback) {
        new Handler(Looper.getMainLooper()).post(new d(pLAuthenticationResultCallback));
    }

    public Integer[] c(String str) {
        return this.f.b(str);
    }

    public f d(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        f fVar = new f();
        fVar.d = jSONObject.optInt(RemoteMessageConst.TTL, 3600);
        JSONArray optJSONArray = jSONObject.optJSONArray("forbiddenDomains");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                fVar.f1424a.add(optJSONArray.getString(i2));
                i = i2 + 1;
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("publishLines");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray jSONArray = optJSONObject.getJSONArray(next);
                ArrayList<String> arrayList = new ArrayList<>();
                if (jSONArray != null && jSONArray.length() != 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < jSONArray.length()) {
                            String string = jSONArray.getString(i4);
                            if (string != null && !string.equals("")) {
                                arrayList.add(string);
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                fVar.b.put(next, arrayList);
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(com.igexin.push.core.b.U);
        if (optJSONObject2 != null) {
            Iterator<String> keys2 = optJSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(next2);
                if (optJSONObject3 != null) {
                    int optInt = optJSONObject3.optInt("publishQuic", 2);
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("quicPort");
                    if (optJSONArray2 != null && optJSONArray2.length() == 2) {
                        fVar.f1425c.put(next2, new Integer[]{Integer.valueOf(optInt), Integer.valueOf(h.d(optJSONArray2.optInt(0), optJSONArray2.optInt(1)))});
                    }
                }
            }
        }
        return fVar;
    }

    public final void d() {
        ArrayList arrayList;
        synchronized (this.d) {
            arrayList = new ArrayList(this.d);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a();
        }
    }

    public final void e() {
        new Thread(new RunnableC0021b()).start();
    }

    public final void e(String str) {
        Context context = this.g;
        if (context == null) {
            return;
        }
        try {
            a(context, "pili_config.json", str);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final JSONObject f(String str) {
        ArrayList<String> a2 = this.f.a();
        if (str != null && !a2.contains(str)) {
            a2.add(str);
        }
        if (a2.size() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("publishDomains", new JSONArray((Collection) a2));
            jSONObject.put("deviceID", this.g == null ? h.i() : h.k(this.g));
            jSONObject.put("osPlatform", "Android");
            jSONObject.put(b.a.l, h.j());
            jSONObject.put("sdkName", "pili-android-streaming-kit");
            jSONObject.put("sdkVersion", "3.0.0");
            if (this.g != null) {
                jSONObject.put("appPackageName", h.g(this.g));
                return jSONObject;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final void f() {
        SharedPreferences sharedPreferences = this.g.getSharedPreferences("PLDroidStreaming", 0);
        String string = sharedPreferences.getString("ts", "");
        if (!"".equals(string)) {
            this.i = Long.valueOf(new String(Base64.decode(string, 0))).longValue();
        }
        int i = sharedPreferences.getInt("authStatus", 0);
        if (i == 1) {
            this.h = e.Authorized;
        } else if (i != 2) {
            this.h = e.UnCheck;
        } else {
            this.h = e.UnAuthorized;
        }
        if (h()) {
            a((PLAuthenticationResultCallback) null);
        } else if (this.h == e.UnAuthorized) {
            a.a.a.a.a.e.e.f1313c.e("Zeus", "鉴权失败! ! ! 请参阅 https://developer.qiniu.com/pili/sdk/3716/PLDroidMediaStreaming-preparation-before-development#2 前置条件说明并按照流程获取相应鉴权！");
        }
    }

    public final void g() {
        this.i = System.currentTimeMillis();
        Context context = this.g;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("PLDroidStreaming", 0).edit();
            edit.putString("ts", Base64.encodeToString(String.valueOf(this.i).getBytes(), 0));
            edit.putInt("authStatus", this.h.ordinal());
            edit.apply();
        }
    }

    public final void g(String str) {
        JSONObject f2 = f(str);
        if (f2 == null) {
            return;
        }
        String a2 = a(this.e + "/v2/config", (String) null, f2);
        try {
            f d2 = d(a2);
            e(a2);
            this.f.a(d2.f1424a, d2.b, d2.f1425c, d2.d);
            d();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final boolean h() {
        long currentTimeMillis = System.currentTimeMillis() - this.i;
        e eVar = this.h;
        if (eVar != e.UnCheck) {
            if (eVar != e.Authorized || currentTimeMillis <= 86400000) {
                return this.h == e.UnAuthorized && currentTimeMillis > 300000;
            }
            return true;
        }
        return true;
    }
}
