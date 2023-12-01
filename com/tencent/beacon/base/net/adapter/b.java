package com.tencent.beacon.base.net.adapter;

import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/adapter/b.class */
public class b extends AbstractNetAdapter {
    private BResponse a(String str, String str2, Map<String, String> map, byte[] bArr) throws IOException {
        HttpURLConnection a2 = a(str, str2, map);
        a2.connect();
        OutputStream outputStream = a2.getOutputStream();
        if (outputStream != null && bArr != null) {
            outputStream.write(bArr);
            outputStream.close();
        }
        return new BResponse(a2.getHeaderFields(), a2.getResponseCode(), a2.getResponseMessage(), a(a2.getInputStream()));
    }

    private HttpURLConnection a(String str, String str2, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        return httpURLConnection;
    }

    private byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException e) {
                e = e;
                byteArrayOutputStream = null;
            } catch (Throwable th) {
                th = th;
                com.tencent.beacon.base.util.b.a(inputStream, null);
                throw th;
            }
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        inputStream.close();
                        com.tencent.beacon.base.util.b.a(inputStream, byteArrayOutputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (IOException e2) {
                e = e2;
                com.tencent.beacon.base.util.c.a(e);
                com.tencent.beacon.base.util.b.a(inputStream, byteArrayOutputStream);
                throw e;
            }
        } catch (Throwable th2) {
            th = th2;
            com.tencent.beacon.base.util.b.a(inputStream, null);
            throw th;
        }
    }

    private byte[] buildBody(com.tencent.beacon.base.net.call.e eVar) throws UnsupportedEncodingException {
        int i = a.f34963a[eVar.a().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return eVar.f().getBytes("UTF-8");
            }
            return com.tencent.beacon.base.net.b.d.b(eVar.d()).getBytes("UTF-8");
        }
        return eVar.c();
    }

    @Override // com.tencent.beacon.base.net.adapter.AbstractNetAdapter
    public void request(JceRequestEntity jceRequestEntity, Callback<byte[]> callback) {
        String name = jceRequestEntity.getType().name();
        try {
            BResponse a2 = a(jceRequestEntity.getUrl(), "POST", jceRequestEntity.getHeader(), jceRequestEntity.getContent());
            if (a2.code == 200) {
                if (com.tencent.beacon.base.net.b.d.a(a2.headers)) {
                    callback.onResponse(a2.body);
                    return;
                } else {
                    callback.onFailure(new com.tencent.beacon.base.net.d(name, "454", a2.code, "server encrypt-status error!"));
                    return;
                }
            }
            int i = a2.code;
            StringBuilder sb = new StringBuilder();
            sb.append("response status code != 2XX. msg: ");
            sb.append(a2.msg);
            callback.onFailure(new com.tencent.beacon.base.net.d(name, "452", i, sb.toString()));
        } catch (ConnectException e) {
            com.tencent.beacon.base.util.c.a(e);
            callback.onFailure(new com.tencent.beacon.base.net.d(name, "451", -1, "https connect timeout: " + e.getMessage(), e));
        } catch (Throwable th) {
            com.tencent.beacon.base.util.c.a(th);
            callback.onFailure(new com.tencent.beacon.base.net.d(name, "499", -1, "https connect error: " + th.getMessage(), th));
        }
    }

    @Override // com.tencent.beacon.base.net.adapter.AbstractNetAdapter
    public void request(com.tencent.beacon.base.net.call.e eVar, Callback<BResponse> callback) {
        String h = eVar.h();
        try {
            BResponse a2 = a(eVar.i(), eVar.g().name(), eVar.e(), buildBody(eVar));
            if (a2.code == 200) {
                callback.onResponse(a2);
                return;
            }
            int i = a2.code;
            StringBuilder sb = new StringBuilder();
            sb.append("response status code != 2XX. msg: ");
            sb.append(a2.msg);
            callback.onFailure(new com.tencent.beacon.base.net.d(h, "452", i, sb.toString()));
        } catch (ConnectException e) {
            com.tencent.beacon.base.util.c.a(e);
            callback.onFailure(new com.tencent.beacon.base.net.d(h, "451", -1, "https connect timeout: " + e.getMessage(), e));
        } catch (Throwable th) {
            com.tencent.beacon.base.util.c.a(th);
            callback.onFailure(new com.tencent.beacon.base.net.d(h, "499", -1, "https connect error: " + th.getMessage(), th));
        }
    }
}
