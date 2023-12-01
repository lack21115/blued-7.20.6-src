package c.t.m.g;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import c.t.m.g.d3;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/s4.class */
public class s4 implements i5 {

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/s4$a.class */
    public class a implements d3.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String[] f3981a;

        public a(s4 s4Var, String[] strArr) {
            this.f3981a = strArr;
        }

        @Override // c.t.m.g.d3.c
        public void a(String str) {
        }

        @Override // c.t.m.g.d3.c
        public void b(String str) {
            String[] strArr = this.f3981a;
            strArr[0] = str;
            String str2 = strArr[0];
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/s4$b.class */
    public static class b {
        public byte[] b;

        /* renamed from: a  reason: collision with root package name */
        public String f3982a = "gbk";

        /* renamed from: c  reason: collision with root package name */
        public String f3983c = "";
    }

    public s4(Context context, String str) {
    }

    public static void a(byte[] bArr, OutputStream outputStream) throws IOException {
        outputStream.write(bArr);
        outputStream.flush();
        outputStream.close();
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
        byte[] a2 = g2.a().a(512);
        while (true) {
            int read = inputStream.read(a2);
            if (read == -1) {
                inputStream.close();
                g2.a().a(a2);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(a2, 0, read);
        }
    }

    public static b b(String str, byte[] bArr) {
        try {
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
            httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.setRequestProperty("Connection", "close");
            a(bArr, httpURLConnection.getOutputStream());
            int responseCode = httpURLConnection.getResponseCode();
            String str2 = "urlStr: " + url + ", retCode : " + responseCode;
            if (responseCode != 200) {
                httpURLConnection.disconnect();
                return null;
            }
            b bVar = new b();
            String headerField = httpURLConnection.getHeaderField("content-type");
            String headerField2 = httpURLConnection.getHeaderField("x-android-sent-millis");
            String b2 = b(headerField);
            byte[] a2 = a(httpURLConnection.getInputStream());
            bVar.f3982a = b2;
            bVar.b = a2;
            bVar.f3983c = headerField2;
            return bVar;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String b(String str) {
        if (str == null) {
            return "GBK";
        }
        String[] split = str.split(";");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return "GBK";
            }
            String trim = split[i2].trim();
            int indexOf = trim.indexOf("charset=");
            if (-1 != indexOf) {
                return trim.substring(indexOf + 8, trim.length());
            }
            i = i2 + 1;
        }
    }

    @Override // c.t.m.g.i5
    public Bundle a(String str, byte[] bArr) throws IOException {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            b b2 = b(str, bArr);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (b2 == null) {
                throw new IOException("net sdk error: response is null");
            }
            s3.a("NET", "0,0," + com.igexin.push.core.b.l + "," + (currentTimeMillis2 - currentTimeMillis) + "," + j3.a());
            Bundle bundle = new Bundle();
            bundle.putString("req_key", "");
            String str2 = b2.f3983c;
            if (!TextUtils.isEmpty(str2)) {
                bundle.putLong("data_header_time", Long.parseLong(str2));
            }
            if (b2.b == null) {
                bundle.putByteArray("data_bytes", "{}".getBytes("UTF-8"));
                bundle.putString("data_charset", "utf-8");
                return bundle;
            }
            String str3 = b2.f3982a;
            bundle.putByteArray("data_bytes", b2.b);
            bundle.putString("data_charset", str3);
            return bundle;
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // c.t.m.g.i5
    public String a(String str) {
        try {
            String[] strArr = new String[1];
            strArr[0] = null;
            d3.a(str, new a(this, strArr));
            if (strArr[0] != null) {
                return strArr[0];
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }
}
