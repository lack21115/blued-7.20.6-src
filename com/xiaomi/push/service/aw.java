package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/aw.class */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    private static long f27925a;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/aw$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f27926a;

        /* renamed from: a  reason: collision with other field name */
        byte[] f940a;

        public a(byte[] bArr, int i) {
            this.f940a = bArr;
            this.f27926a = i;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/aw$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f27927a;

        /* renamed from: a  reason: collision with other field name */
        public Bitmap f941a;

        public b(Bitmap bitmap, long j) {
            this.f941a = bitmap;
            this.f27927a = j;
        }
    }

    private static int a(Context context, InputStream inputStream) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
        if (options.outWidth <= round || options.outHeight <= round) {
            return 1;
        }
        return Math.min(options.outWidth / round, options.outHeight / round);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.Closeable] */
    public static Bitmap a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        int a2;
        Uri parse = Uri.parse(str);
        Uri uri = null;
        try {
            try {
                inputStream = context.getContentResolver().openInputStream(parse);
                try {
                    a2 = a(context, inputStream);
                    inputStream2 = context.getContentResolver().openInputStream(parse);
                } catch (IOException e) {
                    e = e;
                    inputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    com.xiaomi.push.x.a((Closeable) uri);
                    com.xiaomi.push.x.a((Closeable) inputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                inputStream2 = null;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = a2;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream2, null, options);
                com.xiaomi.push.x.a((Closeable) inputStream2);
                com.xiaomi.push.x.a((Closeable) inputStream);
                return decodeStream;
            } catch (IOException e3) {
                e = e3;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.x.a((Closeable) inputStream2);
                com.xiaomi.push.x.a((Closeable) inputStream);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            uri = parse;
        }
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0204: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:85:0x0200 */
    private static a a(String str, boolean z) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        InputStream inputStream2;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (SocketTimeoutException e) {
                httpURLConnection = null;
                inputStream2 = null;
            } catch (IOException e2) {
                e = e2;
                httpURLConnection = null;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
            }
            try {
                httpURLConnection.setConnectTimeout(8000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setRequestProperty("User-agent", "Mozilla/5.0 (Linux; U;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.141 Mobile Safari/537.36 XiaoMi/MiuiBrowser");
                httpURLConnection.connect();
                int contentLength = httpURLConnection.getContentLength();
                if (z && contentLength > 102400) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + str);
                    com.xiaomi.push.x.a((Closeable) null);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return null;
                    }
                    return null;
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("Invalid Http Response Code " + responseCode + " received");
                    com.xiaomi.push.x.a((Closeable) null);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return null;
                    }
                    return null;
                }
                inputStream2 = httpURLConnection.getInputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int i = z ? 102400 : 2048000;
                    byte[] bArr = new byte[1024];
                    while (i > 0) {
                        int read = inputStream2.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        i -= read;
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (i <= 0) {
                        com.xiaomi.channel.commonutils.logger.b.m8344a("length 102400 exhausted.");
                        a aVar = new a(null, 102400);
                        com.xiaomi.push.x.a((Closeable) inputStream2);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return aVar;
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a aVar2 = new a(byteArray, byteArray.length);
                    com.xiaomi.push.x.a((Closeable) inputStream2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return aVar2;
                } catch (SocketTimeoutException e3) {
                    com.xiaomi.channel.commonutils.logger.b.d("Connect timeout to ".concat(String.valueOf(str)));
                    com.xiaomi.push.x.a((Closeable) inputStream2);
                    if (httpURLConnection == null) {
                        return null;
                    }
                    httpURLConnection.disconnect();
                    return null;
                } catch (IOException e4) {
                    inputStream = inputStream2;
                    e = e4;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.push.x.a((Closeable) inputStream);
                    if (httpURLConnection == null) {
                        return null;
                    }
                    httpURLConnection.disconnect();
                    return null;
                }
            } catch (SocketTimeoutException e5) {
                inputStream2 = null;
            } catch (IOException e6) {
                e = e6;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                com.xiaomi.push.x.a(closeable2);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            closeable2 = closeable;
        }
    }

    public static b a(Context context, String str, boolean z) {
        ByteArrayInputStream byteArrayInputStream;
        a a2;
        b bVar = new b(null, 0L);
        Bitmap b2 = b(context, str);
        if (b2 != null) {
            bVar.f941a = b2;
            return bVar;
        }
        ByteArrayInputStream byteArrayInputStream2 = null;
        ByteArrayInputStream byteArrayInputStream3 = null;
        try {
            try {
                a2 = a(str, z);
            } catch (Exception e) {
                e = e;
                byteArrayInputStream = byteArrayInputStream3;
            }
            if (a2 == null) {
                com.xiaomi.push.x.a((Closeable) null);
                return bVar;
            }
            bVar.f27927a = a2.f27926a;
            byte[] bArr = a2.f940a;
            ByteArrayInputStream byteArrayInputStream4 = null;
            if (bArr != null) {
                if (z) {
                    byteArrayInputStream4 = new ByteArrayInputStream(bArr);
                    try {
                        int a3 = a(context, byteArrayInputStream4);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = a3;
                        bVar.f941a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayInputStream = byteArrayInputStream4;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        com.xiaomi.push.x.a((Closeable) byteArrayInputStream);
                        return bVar;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayInputStream2 = byteArrayInputStream4;
                        com.xiaomi.push.x.a((Closeable) byteArrayInputStream2);
                        throw th;
                    }
                } else {
                    bVar.f941a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    byteArrayInputStream4 = null;
                }
            }
            byteArrayInputStream3 = byteArrayInputStream4;
            a(context, a2.f940a, str);
            byteArrayInputStream = byteArrayInputStream4;
            com.xiaomi.push.x.a((Closeable) byteArrayInputStream);
            return bVar;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void a(Context context) {
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (file.exists()) {
            if (f27925a == 0) {
                f27925a = com.xiaomi.push.w.a(file);
            }
            if (f27925a > 15728640) {
                try {
                    File[] listFiles = file.listFiles();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= listFiles.length) {
                            break;
                        }
                        if (!listFiles[i2].isDirectory() && Math.abs(System.currentTimeMillis() - listFiles[i2].lastModified()) > 1209600) {
                            listFiles[i2].delete();
                        }
                        i = i2 + 1;
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
                f27925a = 0L;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r5, byte[] r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.aw.a(android.content.Context, byte[], java.lang.String):void");
    }

    private static Bitmap b(Context context, String str) {
        Bitmap bitmap;
        FileInputStream fileInputStream;
        Exception e;
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon", com.xiaomi.push.bn.a(str));
        FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
                Bitmap bitmap2 = null;
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                    bitmap2 = decodeStream;
                    file.setLastModified(System.currentTimeMillis());
                    com.xiaomi.push.x.a((Closeable) fileInputStream);
                    return decodeStream;
                } catch (Exception e2) {
                    e = e2;
                    bitmap = bitmap2;
                    fileInputStream2 = fileInputStream;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.push.x.a((Closeable) fileInputStream);
                    return bitmap;
                } catch (Throwable th) {
                    fileInputStream2 = fileInputStream;
                    th = th;
                    com.xiaomi.push.x.a((Closeable) fileInputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            bitmap = null;
            fileInputStream = null;
            e = e3;
        }
    }
}
