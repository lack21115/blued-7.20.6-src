package com.oplus.quickgame.sdk.engine.b;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/b/a.class */
public class a {
    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    private void a(URLConnection uRLConnection, b bVar) {
        Map<String, String> a2 = bVar.a();
        if (a2 != null) {
            for (Map.Entry<String, String> entry : a2.entrySet()) {
                uRLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public c a(b bVar) {
        System.currentTimeMillis();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(bVar.c()).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod(bVar.b());
            httpURLConnection.setConnectTimeout(30000);
            a(httpURLConnection, bVar);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            Log.e("test", "responseCode: " + responseCode);
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream == null) {
                    return null;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        a(inputStream);
                        byteArrayOutputStream.close();
                        return c.b().a(200).a(byteArray).a();
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.currentTimeMillis();
        return null;
    }
}
