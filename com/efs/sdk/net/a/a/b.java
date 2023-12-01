package com.efs.sdk.net.a.a;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.net.a.a.f;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/a/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    Map<String, Long> f21833a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(f.a aVar) {
        try {
            byte[] d = aVar.d();
            if (d != null) {
                return d.length;
            }
            return 0L;
        } catch (IOException | OutOfMemoryError e) {
            e.printStackTrace();
            return 0L;
        }
    }

    private static ByteArrayOutputStream a(InputStream inputStream, com.efs.sdk.net.a.b bVar, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                Log.e("NetTrace-Interceptor", "parse and save body, e is ".concat(String.valueOf(e)));
                return byteArrayOutputStream;
            }
        }
        byteArrayOutputStream.flush();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        BufferedReader bufferedReader = "gzip".equals(str) ? new BufferedReader(new InputStreamReader(new GZIPInputStream(byteArrayInputStream))) : new BufferedReader(new InputStreamReader(byteArrayInputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bVar.i = sb.toString().getBytes().length;
                return byteArrayOutputStream;
            }
            sb.append(readLine + '\n');
        }
    }

    public static InputStream a(String str, String str2, String str3, InputStream inputStream) {
        Log.i("NetTrace-Interceptor", "save interpret response stream");
        com.efs.sdk.net.a.b a2 = com.efs.sdk.net.a.a.a().a(str);
        a2.h = str2;
        if (str2 != null) {
            if (str2.contains("text") || str2.contains("json")) {
                ByteArrayOutputStream a3 = a(inputStream, a2, str3);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a3.toByteArray());
                try {
                    a3.close();
                    return byteArrayInputStream;
                } catch (IOException e) {
                    Log.e("NetTrace-Interceptor", "save interpret response stream, e is ".concat(String.valueOf(e)));
                    return byteArrayInputStream;
                }
            }
        }
        a2.i = 0L;
        return inputStream;
    }
}
