package com.tencent.txcopyrightedmedia.impl.utils;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/w.class */
public final class w {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/w$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public InputStream f40183a;
        public final ByteArrayOutputStream b = new ByteArrayOutputStream();

        public final int a(byte[] bArr, int i, int i2) {
            InputStream inputStream = this.f40183a;
            if (inputStream == null) {
                return -1;
            }
            try {
                return inputStream.read(bArr, i, i2);
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        }

        public final byte[] a() {
            try {
                this.b.flush();
                return this.b.toByteArray();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/w$b.class */
    public interface b {
        void a(HttpURLConnection httpURLConnection);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/w$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public static final w f40184a = new w();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/w$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public int f40185a;
        public byte[] b;
        public int d;

        /* renamed from: c  reason: collision with root package name */
        public String f40186c = "";
        public String e = "";
    }

    public static d a(String str, long j, b bVar, a aVar, int i) {
        d dVar;
        loop0: while (true) {
            dVar = new d();
            dVar.f40185a = -1;
            dVar.d = -1;
            boolean z = true;
            String str2 = str;
            while (z) {
                str = str2;
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                    String str3 = str2;
                    bVar.a(httpURLConnection);
                    String str4 = str2;
                    httpURLConnection.setRequestMethod("GET");
                    if (j > 0) {
                        StringBuilder sb = new StringBuilder("bytes=");
                        String str5 = str2;
                        sb.append(j);
                        String str6 = str2;
                        sb.append("-");
                        String str7 = str2;
                        httpURLConnection.setRequestProperty("range", sb.toString());
                    }
                    String str8 = str2;
                    httpURLConnection.setConnectTimeout(15000);
                    String str9 = str2;
                    httpURLConnection.setReadTimeout(15000);
                    String str10 = str2;
                    httpURLConnection.connect();
                    String str11 = str2;
                    if (httpURLConnection.getInputStream() == null) {
                        str = str2;
                        dVar.e = "getInputStream null";
                        return dVar;
                    }
                    dVar.f40185a = httpURLConnection.getResponseCode();
                    String str12 = str2;
                    int contentLength = httpURLConnection.getContentLength();
                    if (contentLength != -1) {
                        dVar.d = contentLength;
                    }
                    String str13 = str2;
                    if (dVar.f40185a == 302) {
                        String str14 = str2;
                        str13 = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                        str2 = str13;
                        if (TextUtils.isEmpty(str13)) {
                        }
                    }
                    z = false;
                    dVar.f40186c = httpURLConnection.getContentType();
                    String str15 = str13;
                    dVar.b = a(httpURLConnection, aVar);
                    str2 = str13;
                } catch (IOException e) {
                    e.printStackTrace();
                    if (i >= 3) {
                        dVar.e = e.toString();
                        break;
                    }
                    i++;
                }
            }
            break loop0;
        }
        return dVar;
    }

    public static d a(String str, byte[] bArr, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.addRequestProperty("Content-Type", str2);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            outputStream.close();
            if (httpURLConnection.getInputStream() == null) {
                return null;
            }
            d dVar = new d();
            dVar.f40185a = httpURLConnection.getResponseCode();
            dVar.f40186c = httpURLConnection.getContentType();
            dVar.d = httpURLConnection.getContentLength();
            dVar.b = a(httpURLConnection, null);
            return dVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static d a(HttpURLConnection httpURLConnection) {
        d dVar = new d();
        dVar.f40185a = -1;
        try {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.connect();
            if (httpURLConnection.getInputStream() == null) {
                dVar.e = "getInputStream null";
                return dVar;
            }
            dVar.f40185a = httpURLConnection.getResponseCode();
            dVar.f40186c = httpURLConnection.getContentType();
            dVar.d = httpURLConnection.getContentLength();
            dVar.b = a(httpURLConnection, null);
            return dVar;
        } catch (IOException e) {
            e.printStackTrace();
            dVar.e = e.toString();
            return dVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] a(java.net.HttpURLConnection r5, com.tencent.txcopyrightedmedia.impl.utils.w.a r6) {
        /*
            Method dump skipped, instructions count: 523
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.txcopyrightedmedia.impl.utils.w.a(java.net.HttpURLConnection, com.tencent.txcopyrightedmedia.impl.utils.w$a):byte[]");
    }
}
