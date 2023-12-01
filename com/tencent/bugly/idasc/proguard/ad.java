package com.tencent.bugly.idasc.proguard;

import android.util.Pair;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ad.class */
public final class ad {
    private static Pair<Integer, String> a(String str, String str2, Map<String, String> map) {
        InputStream inputStream;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection;
        String str3;
        int i;
        int i2 = -1;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            int i3 = -1;
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                a(httpURLConnection, map);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.connect();
                byte[] bytes = str2.getBytes("UTF-8");
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.write(bytes);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    i2 = httpURLConnection.getResponseCode();
                    if (i2 >= 400) {
                        i3 = i2;
                        inputStream = httpURLConnection.getErrorStream();
                    } else {
                        i3 = i2;
                        inputStream = httpURLConnection.getInputStream();
                    }
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                            sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                        }
                        bufferedReader.close();
                        String sb2 = sb.toString();
                        a((Closeable) null);
                        a(inputStream);
                        i = i2;
                        str3 = sb2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            i = i2;
                            str3 = sb2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        dataOutputStream = null;
                        try {
                            al.b(th);
                            String message = th.getMessage();
                            a(dataOutputStream);
                            a(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            str3 = message;
                            i = i2;
                            return new Pair<>(Integer.valueOf(i), str3);
                        } catch (Throwable th2) {
                            a(dataOutputStream);
                            a(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                dataOutputStream = null;
                inputStream = null;
                i2 = i3;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            dataOutputStream = null;
            httpURLConnection = null;
        }
        return new Pair<>(Integer.valueOf(i), str3);
    }

    public static Pair<Integer, String> a(List<String> list) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Atta-Type", "batch-report");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("attaid", "0d000062340").put("token", "2273782735").put("type", com.umeng.ccg.a.s).put("version", "v1.0.0");
            JSONArray jSONArray = new JSONArray();
            for (String str : list) {
                jSONArray.put(str);
            }
            jSONObject.put("datas", jSONArray);
            return a("https://h.trace.qq.com/kv", jSONObject.toString(), hashMap);
        } catch (Throwable th) {
            al.b(th);
            return new Pair<>(-1, th.getMessage());
        }
    }

    private static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
            al.b(e);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (httpURLConnection == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
