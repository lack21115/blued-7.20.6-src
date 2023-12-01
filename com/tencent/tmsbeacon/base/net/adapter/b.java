package com.tencent.tmsbeacon.base.net.adapter;

import com.tencent.tmsbeacon.base.net.BResponse;
import com.tencent.tmsbeacon.base.net.BodyType;
import com.tencent.tmsbeacon.base.net.b.d;
import com.tencent.tmsbeacon.base.net.call.Callback;
import com.tencent.tmsbeacon.base.net.call.JceRequestEntity;
import com.tencent.tmsbeacon.base.net.call.e;
import com.tencent.tmsbeacon.base.util.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/adapter/b.class */
public class b extends AbstractNetAdapter {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/adapter/b$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39499a;

        static {
            BodyType.values();
            int[] iArr = new int[3];
            f39499a = iArr;
            try {
                BodyType bodyType = BodyType.DATA;
                iArr[2] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f39499a;
                BodyType bodyType2 = BodyType.FORM;
                iArr2[1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f39499a;
                BodyType bodyType3 = BodyType.JSON;
                iArr3[0] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

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
        ByteArrayOutputStream byteArrayOutputStream2;
        try {
            byteArrayOutputStream2 = new ByteArrayOutputStream();
            byteArrayOutputStream = byteArrayOutputStream2;
        } catch (IOException e) {
            e = e;
            byteArrayOutputStream2 = null;
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
            com.tencent.tmsbeacon.base.util.b.a(inputStream, byteArrayOutputStream);
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        byteArrayOutputStream2.flush();
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        byteArrayOutputStream2.close();
                        inputStream.close();
                        com.tencent.tmsbeacon.base.util.b.a(inputStream, byteArrayOutputStream2);
                        return byteArray;
                    }
                    byteArrayOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
                com.tencent.tmsbeacon.base.util.b.a(inputStream, byteArrayOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            byteArrayOutputStream = byteArrayOutputStream2;
            c.a(e);
            com.tencent.tmsbeacon.base.util.b.a(inputStream, byteArrayOutputStream2);
            throw e;
        }
    }

    private byte[] buildBody(e eVar) throws UnsupportedEncodingException {
        int i = a.f39499a[eVar.a().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return eVar.f().getBytes("UTF-8");
            }
            return d.b(eVar.d()).getBytes("UTF-8");
        }
        return eVar.c();
    }

    @Override // com.tencent.tmsbeacon.base.net.adapter.AbstractNetAdapter
    public void request(JceRequestEntity jceRequestEntity, Callback<byte[]> callback) {
        String name = jceRequestEntity.getType().name();
        try {
            BResponse a2 = a(jceRequestEntity.getUrl(), "POST", jceRequestEntity.getHeader(), jceRequestEntity.getContent());
            int i = a2.code;
            if (i != 200) {
                StringBuilder sb = new StringBuilder();
                sb.append("response status code != 2XX. msg: ");
                sb.append(a2.msg);
                callback.onFailure(new com.tencent.tmsbeacon.base.net.d(name, "452", i, sb.toString()));
            } else if (d.a(a2.headers)) {
                callback.onResponse(a2.body);
            } else {
                callback.onFailure(new com.tencent.tmsbeacon.base.net.d(name, "454", a2.code, "server encrypt-status error!"));
            }
        } catch (ConnectException e) {
            c.a(e);
            callback.onFailure(new com.tencent.tmsbeacon.base.net.d(name, "451", -1, "https connect timeout: " + e.getMessage(), e));
        } catch (Throwable th) {
            c.a(th);
            callback.onFailure(new com.tencent.tmsbeacon.base.net.d(name, "499", -1, "https connect error: " + th.getMessage(), th));
        }
    }

    @Override // com.tencent.tmsbeacon.base.net.adapter.AbstractNetAdapter
    public void request(e eVar, Callback<BResponse> callback) {
        String h = eVar.h();
        try {
            BResponse a2 = a(eVar.i(), eVar.g().name(), eVar.e(), buildBody(eVar));
            int i = a2.code;
            if (i == 200) {
                callback.onResponse(a2);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("response status code != 2XX. msg: ");
            sb.append(a2.msg);
            callback.onFailure(new com.tencent.tmsbeacon.base.net.d(h, "452", i, sb.toString()));
        } catch (ConnectException e) {
            c.a(e);
            callback.onFailure(new com.tencent.tmsbeacon.base.net.d(h, "451", -1, "https connect timeout: " + e.getMessage(), e));
        } catch (Throwable th) {
            c.a(th);
            callback.onFailure(new com.tencent.tmsbeacon.base.net.d(h, "499", -1, "https connect error: " + th.getMessage(), th));
        }
    }
}
