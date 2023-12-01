package com.kwad.sdk.crash.report.upload;

import android.net.ConnectivityManager;
import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Base64;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.crash.utils.h;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/upload/b.class */
public final class b {
    private static Map<String, String> a(f fVar) {
        HashMap hashMap = new HashMap();
        if (fVar == null) {
            return hashMap;
        }
        if (!TextUtils.isEmpty(fVar.ata)) {
            hashMap.put("uploadToken", fVar.ata);
        }
        if (!TextUtils.isEmpty(fVar.asX)) {
            hashMap.put("sys", fVar.asX);
        }
        if (!TextUtils.isEmpty(fVar.asW)) {
            hashMap.put("did", fVar.asW);
        }
        if (!TextUtils.isEmpty(fVar.asU)) {
            hashMap.put("sid", fVar.asU);
        }
        if (!TextUtils.isEmpty(fVar.arz)) {
            hashMap.put("appver", fVar.arz);
        }
        if (!TextUtils.isEmpty(fVar.mTaskId)) {
            hashMap.put(DBDefinition.TASK_ID, fVar.mTaskId);
        }
        if (!TextUtils.isEmpty(fVar.asV)) {
            hashMap.put("token", fVar.asV);
        }
        if (!TextUtils.isEmpty(fVar.asT)) {
            hashMap.put("uid", fVar.asT);
        }
        if (!TextUtils.isEmpty(fVar.asY)) {
            hashMap.put(ConnectivityManager.EXTRA_EXTRA_INFO, fVar.asY);
        }
        return hashMap;
    }

    public static void a(File file, f fVar, a aVar) {
        a(file, fVar.asW, fVar.asV, a(fVar), aVar);
    }

    private static void a(File file, String str, String str2, Map<String, String> map, a aVar) {
        DataInputStream dataInputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        DataInputStream dataInputStream2;
        OutputStream outputStream2;
        HttpURLConnection httpURLConnection2;
        OutputStream outputStream3;
        HttpURLConnection httpURLConnection3;
        OutputStream outputStream4;
        byte[] bytes;
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "uploadLogFile " + Thread.currentThread());
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        String uuid = UUID.randomUUID().toString();
        String name = file.getName();
        String str3 = "https://" + com.kwad.sdk.core.network.idc.a.wm().C("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/upload";
        try {
            httpURLConnection3 = (HttpURLConnection) new URL(str3).openConnection();
            try {
                httpURLConnection3.setDoOutput(true);
                httpURLConnection3.setDoInput(true);
                httpURLConnection3.setUseCaches(false);
                httpURLConnection3.setConnectTimeout(5000);
                httpURLConnection3.setReadTimeout(5000);
                httpURLConnection3.setUseCaches(false);
                httpURLConnection3.setRequestMethod("POST");
                httpURLConnection3.setRequestProperty(Headers.CONN_DIRECTIVE, com.anythink.expressad.foundation.g.f.g.c.f7906c);
                httpURLConnection3.setRequestProperty("User-Agent", q.getUserAgent());
                httpURLConnection3.setRequestProperty("Charset", "UTF-8");
                httpURLConnection3.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + uuid);
                httpURLConnection3.setRequestProperty("Content-MD5", Base64.encodeToString(com.kwad.sdk.utils.a.es(file.getPath()), 2));
                httpURLConnection3.setRequestProperty("file-type", "." + com.kwad.sdk.utils.q.getExtension(file.getName()));
                httpURLConnection3.setRequestProperty("origin-name", name);
                httpURLConnection3.setRequestProperty("Cookie", "did=" + str);
                httpURLConnection3.connect();
                outputStream3 = httpURLConnection3.getOutputStream();
                try {
                    for (String str4 : map.keySet()) {
                        outputStream3.write(d(str4, map.get(str4), uuid));
                    }
                    bytes = ("\r\n--" + uuid + "--\r\n").getBytes();
                    StringBuilder sb = new StringBuilder();
                    sb.append("--");
                    sb.append(uuid);
                    sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                    sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + name + "\"\r\n");
                    sb.append("Content-Type: application/octet-stream\r\n\r\n");
                    outputStream3.write(sb.toString().getBytes());
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                } catch (Exception e) {
                    e = e;
                    dataInputStream = null;
                    outputStream4 = outputStream3;
                } catch (Throwable th) {
                    th = th;
                    dataInputStream = null;
                }
            } catch (Exception e2) {
                e = e2;
                dataInputStream = null;
                outputStream4 = null;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream = null;
                outputStream3 = null;
            }
        } catch (Exception e3) {
            e = e3;
            dataInputStream2 = null;
            outputStream2 = null;
            httpURLConnection2 = null;
        } catch (Throwable th3) {
            th = th3;
            dataInputStream = null;
            outputStream = null;
            httpURLConnection = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = dataInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream3.write(bArr, 0, read);
            }
            outputStream3.write(IOUtils.LINE_SEPARATOR_WINDOWS.getBytes());
            outputStream3.write(bytes);
            outputStream3.flush();
            int responseCode = httpURLConnection3.getResponseCode();
            cVar.code = responseCode;
            cVar.agd = responseCode;
            if (responseCode == 200) {
                cVar.agf = h.a(httpURLConnection3.getInputStream());
                try {
                    int optInt = new JSONObject(cVar.agf).optInt("result", -1);
                    if (optInt == 1) {
                        aVar.Ag();
                    } else {
                        e eVar = e.asP;
                        new StringBuilder("result is ").append(optInt);
                        aVar.Af();
                    }
                } catch (JSONException e4) {
                    e eVar2 = e.asQ;
                    e eVar3 = e.asQ;
                    aVar.Af();
                }
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "response.body= " + cVar.agf);
            } else {
                e eVar4 = e.asO;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(e.asO.Ai());
                sb2.append(responseCode);
                aVar.Af();
                com.kwad.sdk.core.network.idc.a.wm().a(str3, cVar.code == 0 ? -1 : cVar.code, (Throwable) null);
            }
            com.kwad.sdk.crash.utils.b.a(httpURLConnection3);
            dataInputStream2 = dataInputStream;
        } catch (Exception e5) {
            e = e5;
            outputStream4 = outputStream3;
            httpURLConnection2 = httpURLConnection3;
            e = e;
            dataInputStream2 = dataInputStream;
            outputStream2 = outputStream4;
            try {
                e eVar5 = e.asO;
                e.getCause();
                aVar.Af();
                com.kwad.sdk.core.network.idc.a.wm().a(str3, cVar.code == 0 ? -1 : cVar.code, e);
                com.kwad.sdk.core.d.b.printStackTrace(e);
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                outputStream3 = outputStream2;
                com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream3);
            } catch (Throwable th4) {
                outputStream = outputStream2;
                httpURLConnection = httpURLConnection2;
                dataInputStream = dataInputStream2;
                th = th4;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = httpURLConnection3;
            outputStream = outputStream3;
            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream2);
        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream3);
    }

    private static byte[] d(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(str3);
        sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        sb.append("Content-Disposition: form-data; name=\"" + str + "\"");
        sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        sb.append("Content-Length: " + str2.length());
        sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        sb.append(str2);
        sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        return sb.toString().getBytes();
    }
}
