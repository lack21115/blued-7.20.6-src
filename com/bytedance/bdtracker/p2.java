package com.bytedance.bdtracker;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import javax.crypto.KeyGenerator;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/p2.class */
public class p2 {
    public static final String[] b = {"tt_data", "device_platform"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f7681c = {"aid", "version_code", "ab_version", "iid", "device_platform"};
    public static final String[] d = {"aid", "app_version", "tt_data", "device_id"};

    /* renamed from: a  reason: collision with root package name */
    public final c f7682a;

    public p2(c cVar) {
        this.f7682a = cVar;
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (bArr == null || i2 >= bArr.length) {
                break;
            }
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
            i = i2 + 1;
        }
        return sb.toString();
    }

    public static String[] a() {
        String[] strArr = new String[2];
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = new SecureRandom();
            keyGenerator.init(128, secureRandom);
            strArr[0] = a(keyGenerator.generateKey().getEncoded());
            byte[] bArr = new byte[8];
            secureRandom.nextBytes(bArr);
            strArr[1] = a(bArr);
            if (TextUtils.isEmpty(strArr[0]) || strArr[0].length() != 32 || TextUtils.isEmpty(strArr[1])) {
                return null;
            }
            if (strArr[1].length() == 16) {
                return strArr;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream2;
        GZIPInputStream gZIPInputStream3;
        InputStream inputStream = null;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream3 = new GZIPInputStream(byteArrayInputStream);
            } catch (IOException e) {
                gZIPInputStream2 = null;
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = null;
            }
        } catch (IOException e2) {
            gZIPInputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            gZIPInputStream = null;
            byteArrayInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream3.read(bArr2);
                gZIPInputStream2 = gZIPInputStream3;
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e3) {
            gZIPInputStream2 = gZIPInputStream3;
        } catch (Throwable th3) {
            th = th3;
            gZIPInputStream = gZIPInputStream3;
            j1.a((Closeable) gZIPInputStream);
            j1.a((Closeable) byteArrayInputStream);
            throw th;
        }
        inputStream = byteArrayInputStream;
        j1.a((Closeable) gZIPInputStream2);
        j1.a((Closeable) inputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public String a(String str) {
        if (!TextUtils.isEmpty(str) && this.f7682a.A) {
            Uri parse = Uri.parse(str);
            String encodedQuery = parse.getEncodedQuery();
            ArrayList<Pair> arrayList = new ArrayList();
            String[] strArr = d;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str2 = strArr[i2];
                String queryParameter = parse.getQueryParameter(str2);
                if (!TextUtils.isEmpty(queryParameter)) {
                    arrayList.add(new Pair(str2, queryParameter));
                }
                i = i2 + 1;
            }
            Uri.Builder buildUpon = parse.buildUpon();
            buildUpon.clearQuery();
            for (Pair pair : arrayList) {
                buildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
            }
            buildUpon.appendQueryParameter("tt_info", new String(Base64.encode(b(encodedQuery), 8)));
            return buildUpon.build().toString();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] b(java.lang.String r5) {
        /*
            r4 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r1 = r0
            r2 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r2)
            r9 = r0
            r0 = 0
            r8 = r0
            r0 = 0
            r7 = r0
            r0 = r4
            com.bytedance.bdtracker.c r0 = r0.f7682a     // Catch: java.lang.Throwable -> L50
            boolean r0 = r0.A     // Catch: java.lang.Throwable -> L50
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L3e
            java.util.zip.GZIPOutputStream r0 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L50
            r1 = r0
            r2 = r9
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L50
            r7 = r0
            r0 = r7
            r1 = r5
            java.lang.String r2 = "UTF-8"
            byte[] r1 = r1.getBytes(r2)     // Catch: java.lang.Throwable -> L34
            r0.write(r1)     // Catch: java.lang.Throwable -> L34
            goto L49
        L34:
            r8 = move-exception
            r0 = r7
            r5 = r0
            r0 = r8
            r7 = r0
            goto L54
        L3e:
            r0 = r9
            r1 = r5
            java.lang.String r2 = "UTF-8"
            byte[] r1 = r1.getBytes(r2)     // Catch: java.lang.Throwable -> L50
            r0.write(r1)     // Catch: java.lang.Throwable -> L50
        L49:
            r0 = r7
            com.bytedance.bdtracker.j1.a(r0)
            goto L5e
        L50:
            r7 = move-exception
            r0 = r8
            r5 = r0
        L54:
            java.lang.String r0 = "U SHALL NOT PASS!"
            r1 = r7
            com.bytedance.bdtracker.z2.c(r0, r1)     // Catch: java.lang.Throwable -> L9e
            r0 = r5
            com.bytedance.bdtracker.j1.a(r0)
        L5e:
            r0 = r9
            byte[] r0 = r0.toByteArray()
            r7 = r0
            r0 = r7
            r5 = r0
            r0 = r4
            com.bytedance.bdtracker.c r0 = r0.f7682a
            boolean r0 = r0.A
            if (r0 == 0) goto L9c
            r0 = r7
            r5 = r0
            r0 = r4
            com.bytedance.bdtracker.c r0 = r0.f7682a
            com.bytedance.applog.InitConfig r0 = r0.getInitConfig()
            if (r0 == 0) goto L9c
            r0 = r4
            com.bytedance.bdtracker.c r0 = r0.f7682a
            com.bytedance.applog.InitConfig r0 = r0.getInitConfig()
            com.bytedance.mpaas.IEncryptor r0 = r0.getEncryptor()
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L95
            r0 = r5
            r1 = r7
            r2 = r7
            int r2 = r2.length
            byte[] r0 = r0.encrypt(r1, r2)
            return r0
        L95:
            r0 = r7
            r1 = r7
            int r1 = r1.length
            byte[] r0 = com.bytedance.applog.encryptor.EncryptorUtil.encrypt(r0, r1)
            r5 = r0
        L9c:
            r0 = r5
            return r0
        L9e:
            r7 = move-exception
            r0 = r5
            com.bytedance.bdtracker.j1.a(r0)
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.p2.b(java.lang.String):byte[]");
    }
}
