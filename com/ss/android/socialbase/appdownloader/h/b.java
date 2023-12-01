package com.ss.android.socialbase.appdownloader.h;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/h/b.class */
public class b {
    private static int mb = 8;
    private static volatile b ox;
    private mb<Integer, Bitmap> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/h/b$mb.class */
    public static class mb<K, T> extends LinkedHashMap<K, T> {
        final int mb;

        public mb(int i, int i2) {
            super(i2, 0.75f, true);
            this.mb = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.mb;
        }
    }

    private b() {
        this.b = null;
        int i = mb;
        this.b = new mb<>(i, i / 2);
    }

    public static int mb(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }

    public static b mb() {
        if (ox == null) {
            synchronized (b.class) {
                try {
                    if (ox == null) {
                        ox = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return ox;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream ox(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public Bitmap mb(int i) {
        return this.b.get(Integer.valueOf(i));
    }

    public void mb(final int i, final String str) {
        if (TextUtils.isEmpty(str) || mb(i) != null) {
            return;
        }
        DownloadComponentManager.getIOThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.b.1
            /* JADX WARN: Not initialized variable reg: 14, insn: 0x0221: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r14 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:58:0x021a */
            /* JADX WARN: Not initialized variable reg: 15, insn: 0x021e: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r15 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:58:0x021a */
            /* JADX WARN: Not initialized variable reg: 16, insn: 0x021a: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r16 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:58:0x021a */
            @Override // java.lang.Runnable
            public void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                ByteArrayInputStream byteArrayInputStream;
                Closeable closeable;
                InputStream inputStream;
                ByteArrayInputStream byteArrayInputStream2;
                ByteArrayInputStream byteArrayInputStream3;
                InputStream inputStream2;
                Closeable closeable2;
                Closeable closeable3;
                ByteArrayOutputStream byteArrayOutputStream2;
                ByteArrayInputStream byteArrayInputStream4;
                try {
                    try {
                        IDownloadHttpConnection downloadWithConnection = DownloadComponentManager.downloadWithConnection(true, 0, str, null);
                        if (downloadWithConnection == null) {
                            DownloadUtils.safeClose(null, null, null, null);
                            return;
                        }
                        InputStream inputStream3 = downloadWithConnection.getInputStream();
                        try {
                            byteArrayOutputStream = b.ox(inputStream3);
                            try {
                                byteArrayInputStream4 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            } catch (Exception e) {
                                e = e;
                                byteArrayInputStream3 = null;
                                inputStream2 = inputStream3;
                                byteArrayInputStream2 = null;
                            } catch (Throwable th) {
                                th = th;
                                byteArrayInputStream = null;
                                inputStream = inputStream3;
                                closeable = null;
                            }
                            try {
                                byteArrayInputStream3 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            } catch (Exception e2) {
                                e = e2;
                                byteArrayInputStream3 = null;
                                inputStream2 = inputStream3;
                                byteArrayInputStream2 = byteArrayInputStream4;
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = inputStream3;
                                byteArrayInputStream = byteArrayInputStream4;
                                closeable = null;
                                DownloadUtils.safeClose(inputStream, byteArrayOutputStream, byteArrayInputStream, closeable);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            byteArrayInputStream3 = null;
                            byteArrayOutputStream = null;
                            inputStream2 = inputStream3;
                            byteArrayInputStream2 = null;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayInputStream = null;
                            byteArrayOutputStream = null;
                            inputStream = inputStream3;
                            closeable = null;
                        }
                        try {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(byteArrayInputStream4, null, options);
                            int i2 = options.outWidth;
                            int i3 = options.outHeight;
                            int mb2 = com.ss.android.socialbase.appdownloader.b.mb(DownloadComponentManager.getAppContext(), 44.0f);
                            options.inSampleSize = b.mb(mb2, mb2, options);
                            options.inJustDecodeBounds = false;
                            b.this.b.put(Integer.valueOf(i), BitmapFactory.decodeStream(byteArrayInputStream3, null, options));
                            DownloadUtils.safeClose(inputStream3, byteArrayOutputStream, byteArrayInputStream4, byteArrayInputStream3);
                        } catch (Exception e4) {
                            e = e4;
                            inputStream2 = inputStream3;
                            byteArrayInputStream2 = byteArrayInputStream4;
                            e.printStackTrace();
                            DownloadUtils.safeClose(inputStream2, byteArrayOutputStream, byteArrayInputStream2, byteArrayInputStream3);
                        }
                    } catch (Exception e5) {
                        e = e5;
                        byteArrayOutputStream = null;
                        byteArrayInputStream2 = null;
                        byteArrayInputStream3 = null;
                        inputStream2 = null;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayOutputStream = null;
                        byteArrayInputStream = null;
                        closeable = null;
                        inputStream = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    closeable = closeable2;
                    byteArrayInputStream = closeable3;
                    byteArrayOutputStream = byteArrayOutputStream2;
                }
            }
        });
    }
}
