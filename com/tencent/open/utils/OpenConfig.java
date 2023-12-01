package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/utils/OpenConfig.class */
public class OpenConfig {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, OpenConfig> f38279a = Collections.synchronizedMap(new HashMap());
    private static String b = null;

    /* renamed from: c  reason: collision with root package name */
    private Context f38280c;
    private String d;
    private JSONObject e = null;
    private long f = 0;
    private int g = 0;
    private boolean h = true;

    private OpenConfig(Context context, String str) {
        this.f38280c = null;
        this.d = null;
        this.f38280c = context.getApplicationContext();
        this.d = str;
        a();
        b();
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.StringBuffer, java.lang.String] */
    private String a(String str) {
        FileInputStream open;
        String str2;
        try {
            try {
                if (this.d != null) {
                    str2 = str + "." + this.d;
                } else {
                    str2 = str;
                }
                open = this.f38280c.openFileInput(str2);
            } catch (FileNotFoundException e) {
                open = this.f38280c.getAssets().open(str);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Charset.forName("UTF-8")));
            ?? stringBuffer = new StringBuffer();
            while (true) {
                try {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                String stringBuffer2 = stringBuffer.toString();
                                open.close();
                                bufferedReader.close();
                                return stringBuffer2;
                            }
                            stringBuffer.append(readLine);
                        } catch (Throwable th) {
                            try {
                                open.close();
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        open.close();
                        bufferedReader.close();
                        return "";
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return stringBuffer;
                }
            }
        } catch (IOException e5) {
            e5.printStackTrace();
            return "";
        }
    }

    private void a() {
        try {
            this.e = new JSONObject(a("com.tencent.open.config.json"));
        } catch (JSONException e) {
            this.e = new JSONObject();
        }
    }

    private void a(String str, String str2) {
        String str3 = str;
        try {
            if (this.d != null) {
                str3 = str + "." + this.d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f38280c.openFileOutput(str3, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        b("cgi back, do update");
        this.e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f = SystemClock.elapsedRealtime();
    }

    private void b() {
        if (this.g != 0) {
            b("update thread is running, return");
            return;
        }
        this.g = 1;
        final Bundle bundle = new Bundle();
        bundle.putString("appid", this.d);
        bundle.putString("appid_for_getting_config", this.d);
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        new Thread() { // from class: com.tencent.open.utils.OpenConfig.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    OpenConfig.this.a(Util.parseJson(HttpUtils.openUrl2(OpenConfig.this.f38280c, "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", bundle).response));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                OpenConfig.this.g = 0;
            }
        }.start();
    }

    private void b(String str) {
        if (this.h) {
            f.a("openSDK_LOG.OpenConfig", str + "; appid: " + this.d);
        }
    }

    private void c() {
        int optInt = this.e.optInt("Common_frequency");
        int i = optInt;
        if (optInt == 0) {
            i = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f >= i * 3600000) {
            b();
        }
    }

    public static OpenConfig getInstance(Context context, String str) {
        OpenConfig openConfig;
        synchronized (f38279a) {
            f.a("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                b = str;
            }
            String str2 = str;
            if (str == null) {
                str2 = b != null ? b : "0";
            }
            OpenConfig openConfig2 = f38279a.get(str2);
            openConfig = openConfig2;
            if (openConfig2 == null) {
                openConfig = new OpenConfig(context, str2);
                f38279a.put(str2, openConfig);
            }
            f.a("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return openConfig;
    }

    public boolean getBoolean(String str) {
        b("get " + str);
        c();
        Object opt = this.e.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        }
        if (opt instanceof Boolean) {
            return ((Boolean) opt).booleanValue();
        }
        return false;
    }

    public int getInt(String str) {
        b("get " + str);
        c();
        return this.e.optInt(str);
    }

    public long getLong(String str) {
        b("get " + str);
        c();
        return this.e.optLong(str);
    }
}
