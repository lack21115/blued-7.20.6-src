package com.alipay.sdk.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/net/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4632a = "msp";
    private static final String b = "application/octet-stream;binary/octet-stream";

    /* renamed from: c  reason: collision with root package name */
    private static final CookieManager f4633c = new CookieManager();

    /* renamed from: com.alipay.sdk.net.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/net/a$a.class */
    public static final class C0049a {

        /* renamed from: a  reason: collision with root package name */
        public final String f4634a;
        public final byte[] b;

        /* renamed from: c  reason: collision with root package name */
        public final Map<String, String> f4635c;

        public C0049a(String str, Map<String, String> map, byte[] bArr) {
            this.f4634a = str;
            this.b = bArr;
            this.f4635c = map;
        }

        public String toString() {
            return String.format("<UrlConnectionConfigure url=%s headers=%s>", this.f4634a, this.f4635c);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/net/a$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<String>> f4636a;
        public final String b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f4637c;

        public b(Map<String, List<String>> map, String str, byte[] bArr) {
            this.f4636a = map;
            this.b = str;
            this.f4637c = bArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x02a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0295 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alipay.sdk.net.a.b a(android.content.Context r6, com.alipay.sdk.net.a.C0049a r7) {
        /*
            Method dump skipped, instructions count: 766
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.net.a.a(android.content.Context, com.alipay.sdk.net.a$a):com.alipay.sdk.net.a$b");
    }

    private static Proxy a(Context context) {
        String c2 = c(context);
        Proxy proxy = null;
        if (c2 == null || c2.contains("wap")) {
            try {
                String property = System.getProperty("https.proxyHost");
                String property2 = System.getProperty("https.proxyPort");
                if (!TextUtils.isEmpty(property)) {
                    proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, Integer.parseInt(property2)));
                }
                return proxy;
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static NetworkInfo b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        } catch (Exception e) {
            return null;
        }
    }

    private static String c(Context context) {
        try {
            NetworkInfo b2 = b(context);
            return (b2 == null || !b2.isAvailable()) ? "none" : b2.getType() == 1 ? "wifi" : b2.getExtraInfo().toLowerCase();
        } catch (Exception e) {
            return "none";
        }
    }
}
