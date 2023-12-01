package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.qiniu.pili.droid.shortvideo.PLAuthenticationResultCallback;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.core.b;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/u.class */
public class u {
    private static boolean d = true;

    /* renamed from: a  reason: collision with root package name */
    private Context f27627a;
    private b b = b.UnCheck;

    /* renamed from: c  reason: collision with root package name */
    private long f27628c = 0;
    private ArrayList<Integer> e = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/u$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final u f27631a = new u();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/u$b.class */
    public enum b {
        UnCheck,
        Authorized,
        UnAuthorized
    }

    public static u a() {
        return a.f27631a;
    }

    private String a(InputStream inputStream) {
        BufferedReader bufferedReader;
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        } catch (Exception e) {
                            e = e;
                            bufferedReader2 = bufferedReader;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return stringBuffer.toString();
                        } catch (Throwable th) {
                            bufferedReader2 = bufferedReader;
                            th = th;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    b(stringBuffer.toString());
                    a(stringBuffer.toString());
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return stringBuffer.toString();
    }

    private void a(String str) {
        SharedPreferences.Editor edit = this.f27627a.getSharedPreferences("ShortVideo", 0).edit();
        edit.putString("feature", Base64.encodeToString(str.getBytes(), 0));
        edit.apply();
    }

    private void a(boolean z) {
        d = z;
    }

    private String b(Context context) {
        return context != null ? com.qiniu.pili.droid.shortvideo.f.j.g(context) : "";
    }

    private void b(final PLAuthenticationResultCallback pLAuthenticationResultCallback) {
        if (this.f27627a == null) {
            return;
        }
        this.f27628c = System.currentTimeMillis();
        Context context = this.f27627a;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ShortVideo", 0).edit();
            edit.putString("ts", Base64.encodeToString(String.valueOf(this.f27628c).getBytes(), 0));
            edit.apply();
        }
        new Thread(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.core.u.1
            @Override // java.lang.Runnable
            public void run() {
                u.this.d(pLAuthenticationResultCallback);
            }
        }).start();
    }

    private void b(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            this.e.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return;
                }
                this.e.add(Integer.valueOf(jSONArray.getJSONObject(i2).getInt("id")));
                i = i2 + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis() - this.f27628c;
        if (currentTimeMillis < 0 || currentTimeMillis >= 3600000) {
            b((PLAuthenticationResultCallback) null);
        }
    }

    private void c(final PLAuthenticationResultCallback pLAuthenticationResultCallback) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.core.u.2
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.b == b.Authorized) {
                    pLAuthenticationResultCallback.onAuthorizationResult(1);
                } else if (u.this.b == b.UnAuthorized) {
                    pLAuthenticationResultCallback.onAuthorizationResult(0);
                } else {
                    pLAuthenticationResultCallback.onAuthorizationResult(-1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PLAuthenticationResultCallback pLAuthenticationResultCallback) {
        String b2 = b(this.f27627a);
        if ("".equals(b2)) {
            return;
        }
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://shortvideo.qiniuapi.com/v1/zeus?appid=" + b2).openConnection();
            httpsURLConnection.setRequestMethod("GET");
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode == 200) {
                this.b = b.Authorized;
                a(httpsURLConnection.getInputStream());
            } else if (responseCode == 401) {
                this.b = b.UnAuthorized;
            } else {
                this.b = b.UnCheck;
            }
            if (pLAuthenticationResultCallback != null) {
                c(pLAuthenticationResultCallback);
            }
        } catch (IOException e) {
            if (pLAuthenticationResultCallback != null) {
                c(pLAuthenticationResultCallback);
            }
            e.printStackTrace();
        }
    }

    public void a(Context context) {
        if (this.f27627a != null || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.f27627a = applicationContext;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("ShortVideo", 0);
        String string = sharedPreferences.getString("ts", "");
        String string2 = sharedPreferences.getString("feature", "");
        if (!"".equals(string)) {
            this.f27628c = Long.valueOf(new String(Base64.decode(string, 0))).longValue();
        }
        if (!"".equals(string2)) {
            b(new String(Base64.decode(string2, 0)));
        }
        String[] strArr = c.f27539a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            if (a().b(context).contains(strArr[i2])) {
                a().a(false);
                return;
            }
            i = i2 + 1;
        }
    }

    public void a(PLAuthenticationResultCallback pLAuthenticationResultCallback) {
        b(pLAuthenticationResultCallback);
    }

    public boolean a(b.a aVar) {
        boolean z = true;
        if (!d) {
            this.b = b.Authorized;
            return true;
        }
        c();
        if (this.b == b.UnAuthorized) {
            z = false;
        } else if (!this.e.isEmpty()) {
            z = this.e.contains(Integer.valueOf(aVar.a()));
        }
        if (!z) {
            com.qiniu.pili.droid.shortvideo.f.e.b.e("ZeusManager", "no authorized feature : " + aVar + " status : " + this.b);
        }
        return z;
    }

    public boolean a(b.a aVar, PLVideoSaveListener pLVideoSaveListener) {
        boolean a2 = a(aVar);
        if (!a2 && pLVideoSaveListener != null) {
            pLVideoSaveListener.onSaveVideoFailed(8);
        }
        return a2;
    }

    public boolean b() {
        if (d) {
            c();
            return this.b != b.UnAuthorized;
        }
        this.b = b.Authorized;
        return true;
    }
}
