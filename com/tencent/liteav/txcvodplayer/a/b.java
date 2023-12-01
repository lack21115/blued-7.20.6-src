package com.tencent.liteav.txcvodplayer.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiEnterpriseConfig;
import com.heytap.mcssdk.constant.IntentConstant;
import com.huawei.openalliance.ad.constant.ao;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/a/b.class */
public class b {
    private static volatile b d;

    /* renamed from: a  reason: collision with root package name */
    private Context f36509a;
    private Map<String, List<C0930b>> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Long> f36510c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/a/b$a.class */
    public static final class a extends C0930b {

        /* renamed from: a  reason: collision with root package name */
        int f36512a;
        boolean b;

        /* renamed from: c  reason: collision with root package name */
        long f36513c;

        public a(int i, boolean z, long j, String str) {
            super(str, "40305");
            this.f36512a = 60;
            this.b = false;
            this.f36513c = 0L;
            this.f36512a = i;
            this.b = z;
            this.f36513c = j;
        }

        public a(String str) {
            this.f36512a = 60;
            this.b = false;
            this.f36513c = 0L;
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f36512a = jSONObject.optInt("SengmentDuration", 60);
                this.b = jSONObject.optBoolean("ReportSwitch", false);
                this.f36513c = jSONObject.optLong("ExpireTime", (System.currentTimeMillis() / 1000) + com.anythink.expressad.d.a.b.P);
                this.d = jSONObject.optString("appid", "");
                this.e = jSONObject.optString("eventid", "");
            } catch (JSONException e) {
                LiteavLog.i("TXCVodPlayReportControl", "parseFromString: " + e.toString());
                this.f36512a = 60;
                this.b = false;
                this.f36513c = 0L;
                this.d = "";
                this.e = "40305";
            }
        }

        private JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("SengmentDuration", this.f36512a);
                jSONObject.put("ReportSwitch", this.b);
                jSONObject.put("ExpireTime", this.f36513c);
                jSONObject.put("appid", this.d);
                jSONObject.put("eventid", this.e);
                return jSONObject;
            } catch (JSONException e) {
                LiteavLog.e("TXCVodPlayReportControl", "toJsonObject jsonexception: " + e.toString());
                return jSONObject;
            }
        }

        public final String toString() {
            return a().toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.txcvodplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/a/b$b.class */
    public static class C0930b {
        protected String d;
        protected String e;

        public C0930b() {
            this.d = "";
            this.e = "";
        }

        public C0930b(String str, String str2) {
            this.d = "";
            this.e = "";
            this.d = str;
            this.e = str2;
        }
    }

    private b(Context context) {
        this.f36509a = context.getApplicationContext();
        a();
    }

    public static b a(Context context) {
        if (d == null) {
            synchronized (b.class) {
                try {
                    if (d == null) {
                        d = new b(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    private static String a(List<C0930b> list) {
        if (list == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        for (C0930b c0930b : list) {
            JSONObject jSONObject = new JSONObject();
            if ("40305".equals(c0930b.e)) {
                a aVar = (a) c0930b;
                try {
                    jSONObject.put("appid", aVar.d);
                    jSONObject.put("eventid", aVar.e);
                    jSONObject.put("40305", aVar.toString());
                } catch (JSONException e) {
                    LiteavLog.e("TXCVodPlayReportControl", "controlDataListToString jsonObject.put：" + e.toString());
                }
            }
            try {
                jSONArray.put(i, jSONObject);
            } catch (JSONException e2) {
                LiteavLog.e("TXCVodPlayReportControl", "jsonArray.put： " + e2.toString());
            }
            i++;
        }
        return jSONArray.toString();
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f36509a.getSharedPreferences("vod_report_config", 0);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("value", "");
            if (string.isEmpty()) {
                return;
            }
            try {
                synchronized (this) {
                    JSONArray jSONArray = new JSONArray(string);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < jSONArray.length()) {
                            List<C0930b> e = e(jSONArray.optString(i2));
                            if (e.size() > 0) {
                                this.b.put(e.get(0).d, e);
                            }
                            i = i2 + 1;
                        }
                    }
                }
            } catch (JSONException e2) {
                LiteavLog.e("TXCVodPlayReportControl", e2.toString());
            }
        }
    }

    static /* synthetic */ void a(b bVar) {
        SharedPreferences.Editor edit;
        synchronized (bVar) {
            int i = 0;
            SharedPreferences sharedPreferences = bVar.f36509a.getSharedPreferences("vod_report_config", 0);
            if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null && bVar.b.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, List<C0930b>> entry : bVar.b.entrySet()) {
                    try {
                        jSONArray.put(i, a(entry.getValue()));
                    } catch (JSONException e) {
                        LiteavLog.e("TXCVodPlayReportControl", e.toString());
                    }
                    i++;
                }
                edit.putString("value", jSONArray.toString());
                edit.apply();
            }
        }
    }

    static /* synthetic */ void a(b bVar, String str) {
        URL url;
        HttpsURLConnection httpsURLConnection;
        BufferedReader bufferedReader;
        try {
            String str2 = "https://vodreport.qcloud.com/describeControlInfos/v1/" + str + "?sdkVersion=" + CommonUtil.getSDKVersionStr();
            LiteavLog.i("TXCVodPlayReportControl", "makeUrl: ".concat(String.valueOf(str2)));
            url = new URL(str2);
        } catch (MalformedURLException e) {
            LiteavLog.i("TXCVodPlayReportControl", "URL :" + e.toString());
            url = null;
        }
        if (url == null) {
            return;
        }
        try {
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
        } catch (IOException e2) {
            LiteavLog.i("TXCVodPlayReportControl", "openConnection :" + e2.toString());
            httpsURLConnection = null;
        }
        if (httpsURLConnection == null) {
            return;
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                httpsURLConnection.setConnectTimeout(8000);
                httpsURLConnection.setReadTimeout(8000);
                httpsURLConnection.setRequestProperty("Accept-Encoding", WifiEnterpriseConfig.IDENTITY_KEY);
                httpsURLConnection.setInstanceFollowRedirects(true);
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                LiteavLog.i("TXCVodPlayReportControl", "request report control response code : ".concat(String.valueOf(responseCode)));
                BufferedReader bufferedReader3 = null;
                if (200 == responseCode) {
                    bufferedReader3 = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader3.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        }
                        String sb2 = sb.toString();
                        if (sb2 == null || sb2.isEmpty()) {
                            LiteavLog.i("TXCVodPlayReportControl", "response msg is empty");
                        } else {
                            try {
                                JSONObject jSONObject = new JSONObject(sb2);
                                int i = jSONObject.getInt("code");
                                LiteavLog.i("TXCVodPlayReportControl", "code = " + i + " ,message = " + jSONObject.optString("message") + " , requestID= " + jSONObject.optString(ao.S));
                                if (i == 0 && jSONObject.getInt("version") == 1) {
                                    bVar.a(jSONObject);
                                }
                            } catch (JSONException e3) {
                                LiteavLog.e("TXCVodPlayReportControl", "parseJson err: " + e3.toString());
                            }
                        }
                    } catch (IOException e4) {
                        bufferedReader = bufferedReader3;
                        e = e4;
                        StringBuilder sb3 = new StringBuilder("connect or read: ");
                        BufferedReader bufferedReader4 = bufferedReader;
                        sb3.append(e.toString());
                        BufferedReader bufferedReader5 = bufferedReader;
                        LiteavLog.i("TXCVodPlayReportControl", sb3.toString());
                        httpsURLConnection.disconnect();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e5) {
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader3;
                        httpsURLConnection.disconnect();
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e6) {
                            }
                        }
                        throw th;
                    }
                }
                httpsURLConnection.disconnect();
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e7) {
                    }
                }
            } catch (IOException e8) {
                e = e8;
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(String str, long j) {
        synchronized (this) {
            this.f36510c.put(str, Long.valueOf(j));
            LiteavLog.i("TXCVodPlayReportControl", "SetReportExpireTime in mem appid= " + str + " , time=" + j);
        }
    }

    private void a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("controlInfos");
        int optInt = jSONObject.optInt("appId");
        if (optInt == 0) {
            LiteavLog.i("TXCVodPlayReportControl", "response appid is zero!");
        } else if (optJSONArray == null || optJSONArray.length() == 0) {
        } else {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null && "40305".equals(optJSONObject.optString(IntentConstant.EVENT_ID))) {
                    long optLong = optJSONObject.optLong("expireTime", 0L);
                    if (optLong > System.currentTimeMillis() / 1000) {
                        String optString = optJSONObject.optString("switch");
                        int optInt2 = optJSONObject.optInt("frequency", 60);
                        if (optInt2 < 60) {
                            optInt2 = 60;
                        }
                        arrayList.add(new a(optInt2, "on".equalsIgnoreCase(optString), optLong, String.valueOf(optInt)));
                    }
                }
                i = i2 + 1;
            }
            synchronized (this) {
                if (arrayList.size() != 0) {
                    this.b.put(String.valueOf(optInt), arrayList);
                    this.f36510c.remove(Integer.valueOf(optInt));
                }
            }
        }
    }

    private long d(String str) {
        if (str == null || str.isEmpty()) {
            return (System.currentTimeMillis() / 1000) + com.anythink.expressad.d.a.b.P;
        }
        synchronized (this) {
            if (this.f36510c.containsKey(str)) {
                return this.f36510c.get(str).longValue();
            }
            List<C0930b> list = this.b.get(str);
            if (list != null) {
                for (C0930b c0930b : list) {
                    if ("40305".equals(c0930b.e) && str.equalsIgnoreCase(c0930b.d)) {
                        return ((a) c0930b).f36513c;
                    }
                }
            }
            return 0L;
        }
    }

    private static List<C0930b> e(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    optJSONObject.optString("appid", "");
                    if (optJSONObject.optString("eventid", "").equalsIgnoreCase("40305")) {
                        String optString = optJSONObject.optString("40305", "");
                        if (!optString.isEmpty()) {
                            arrayList.add(new a(optString));
                        }
                    }
                }
                i = i2 + 1;
            }
        } catch (JSONException e) {
            LiteavLog.e("TXCVodPlayReportControl", "controlDataListParseFormString :" + e.toString());
        }
        return arrayList;
    }

    public final int a(String str) {
        a aVar;
        if (str == null || str.isEmpty()) {
            return 60;
        }
        synchronized (this) {
            List<C0930b> list = this.b.get(str);
            if (list != null) {
                for (C0930b c0930b : list) {
                    if (c0930b != null && "40305".equals(c0930b.e) && str.equalsIgnoreCase(c0930b.d) && (aVar = (a) c0930b) != null && aVar.f36513c > System.currentTimeMillis() / 1000) {
                        return aVar.f36512a;
                    }
                }
            }
            return 60;
        }
    }

    public final boolean b(String str) {
        a aVar;
        if (str == null || str.isEmpty()) {
            return false;
        }
        synchronized (this) {
            List<C0930b> list = this.b.get(str);
            if (list != null) {
                for (C0930b c0930b : list) {
                    if (c0930b != null && "40305".equals(c0930b.e) && str.equalsIgnoreCase(c0930b.d) && (aVar = (a) c0930b) != null && aVar.f36513c > System.currentTimeMillis() / 1000) {
                        return aVar.b;
                    }
                }
            }
            return false;
        }
    }

    public final void c(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        synchronized (this) {
            if (d(str) < System.currentTimeMillis() / 1000) {
                LiteavLog.i("TXCVodPlayReportControl", "RequestReportControl");
                a(str, (System.currentTimeMillis() / 1000) + com.anythink.expressad.d.a.b.P);
                new Thread(new Runnable() { // from class: com.tencent.liteav.txcvodplayer.a.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.a(b.this, str);
                        b.a(b.this);
                    }
                }, "report_control").start();
            }
        }
    }
}
