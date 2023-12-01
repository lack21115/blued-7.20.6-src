package c.t.m.g;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/d3.class */
public class d3 {

    /* renamed from: a  reason: collision with root package name */
    public static b2 f3739a;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/d3$a.class */
    public interface a {
        void a(String str);

        void a(byte[] bArr);
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/d3$b.class */
    public interface b {
        void a(int i, Map<String, Object> map);
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/d3$c.class */
    public interface c {
        void a(String str);

        void b(String str);
    }

    public static String a(String str) {
        if (str == null) {
            return "GBK";
        }
        String[] split = str.split(com.huawei.openalliance.ad.constant.t.aE);
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

    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r13, byte[] r14, int r15, java.lang.Object r16) {
        /*
            Method dump skipped, instructions count: 751
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.d3.a(java.lang.String, byte[], int, java.lang.Object):void");
    }

    public static void a(String str, byte[] bArr, Object obj) {
        if (bArr == null) {
            bArr = k2.f3812a;
        }
        a(str, bArr, 0, obj);
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
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                inputStream.close();
                g2.a().a(a2);
                return byteArray;
            }
            byteArrayOutputStream.write(a2, 0, read);
        }
    }

    public static byte[] a(String str, Object obj) {
        c cVar = (obj == null || !(obj instanceof c)) ? null : (c) obj;
        a aVar = (obj == null || !(obj instanceof a)) ? null : (a) obj;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.connect();
            byte[] a2 = a(httpURLConnection.getInputStream());
            if (a2 != null) {
                int length = str.getBytes().length;
                int length2 = a2.length;
            }
            if (aVar != null) {
                aVar.a(a2);
            }
            if (cVar != null) {
                cVar.b(new String(a2, "UTF-8"));
            }
            httpURLConnection.disconnect();
            return a2;
        } catch (Throwable th) {
            long length3 = str.getBytes().length;
            if (aVar != null) {
                aVar.a(th.toString());
            }
            if (cVar != null) {
                cVar.a(th.toString());
            }
            b2 b2Var = f3739a;
            if (b2Var != null) {
                b2Var.a(str, currentTimeMillis, length3, 0L, System.currentTimeMillis() - currentTimeMillis, false);
                return null;
            }
            return null;
        }
    }
}
